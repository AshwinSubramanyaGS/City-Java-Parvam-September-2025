package com.gamingclub.service;

import com.gamingclub.dto.MemberRequest;
import com.gamingclub.dto.MemberResponse;
import com.gamingclub.model.Member;
import com.gamingclub.model.RechargeHistory;
import com.gamingclub.model.Game;
import com.gamingclub.model.PlayHistory;
import com.gamingclub.repository.MemberRepository;
import com.gamingclub.repository.RechargeHistoryRepository;
import com.gamingclub.repository.GameRepository;
import com.gamingclub.repository.PlayHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private RechargeHistoryRepository rechargeHistoryRepository;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private PlayHistoryRepository playHistoryRepository;

    public Member createMember(MemberRequest request) {
        if (memberRepository.existsByPhone(request.getPhone())) {
            throw new RuntimeException("Member with phone " + request.getPhone() + " already exists");
        }

        Member member = new Member(request.getName(), request.getPhone(), request.getFee());
        Member savedMember = memberRepository.save(member);

        // Create recharge history
        RechargeHistory recharge = new RechargeHistory(savedMember, request.getFee());
        rechargeHistoryRepository.save(recharge);

        return savedMember;
    }

    public MemberResponse searchMember(String phone) {
        Member member = memberRepository.findByPhone(phone)
                .orElseThrow(() -> new RuntimeException("Member not found with phone: " + phone));

        List<MemberResponse.RechargeHistoryDTO> rechargeHistory = rechargeHistoryRepository
                .findByMemberId(member.getId())
                .stream()
                .map(rh -> new MemberResponse.RechargeHistoryDTO(
                        rh.getId(), rh.getAmount(), rh.getDateTime().toString()))
                .collect(Collectors.toList());

        List<MemberResponse.GameDTO> availableGames = gameRepository.findByIsAvailableTrue()
                .stream()
                .map(game -> new MemberResponse.GameDTO(
                        game.getId(), game.getName(), game.getPrice(), game.getDescription(),
                        game.getCategory(), game.getDifficultyLevel()))
                .collect(Collectors.toList());

        List<PlayHistory> memberPlayHistory = playHistoryRepository.findByMemberId(member.getId());

        List<MemberResponse.PlayHistoryDTO> playedHistory = memberPlayHistory
                .stream()
                .map(ph -> new MemberResponse.PlayHistoryDTO(
                        ph.getId(), ph.getDateTime().toString(),
                        ph.getGame().getName(), ph.getGame().getCategory(), ph.getAmount()))
                .collect(Collectors.toList());

        // Calculate gaming stats
        MemberResponse.GamingStatsDTO gamingStats = calculateGamingStats(member, memberPlayHistory);

        return new MemberResponse(member, rechargeHistory, availableGames, playedHistory, gamingStats);
    }

    private MemberResponse.GamingStatsDTO calculateGamingStats(Member member, List<PlayHistory> playHistory) {
        Integer totalGamesPlayed = member.getTotalGamesPlayed();
        Double totalAmountSpent = playHistory.stream().mapToDouble(PlayHistory::getAmount).sum();

        // Calculate favorite category
        String favoriteCategory = playHistory.stream()
                .collect(Collectors.groupingBy(ph -> ph.getGame().getCategory(), Collectors.counting()))
                .entrySet().stream()
                .max((e1, e2) -> e1.getValue().compareTo(e2.getValue()))
                .map(entry -> entry.getKey())
                .orElse("No games played yet");

        // Get member since date (first recharge date)
        String memberSince = rechargeHistoryRepository.findByMemberId(member.getId())
                .stream()
                .min((rh1, rh2) -> rh1.getDateTime().compareTo(rh2.getDateTime()))
                .map(rh -> rh.getDateTime().toLocalDate().toString())
                .orElse(LocalDateTime.now().toLocalDate().toString());

        return new MemberResponse.GamingStatsDTO(totalGamesPlayed, totalAmountSpent, favoriteCategory, memberSince);
    }
}