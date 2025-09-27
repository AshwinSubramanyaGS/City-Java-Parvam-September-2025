package com.gamingclub.service;

import com.gamingclub.dto.PlayRequest;
import com.gamingclub.model.Member;
import com.gamingclub.model.Game;
import com.gamingclub.model.PlayHistory;
import com.gamingclub.repository.MemberRepository;
import com.gamingclub.repository.GameRepository;
import com.gamingclub.repository.PlayHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlayService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private PlayHistoryRepository playHistoryRepository;

    @Transactional
    public String playGame(PlayRequest request) {
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new RuntimeException("Member not found"));

        Game game = gameRepository.findById(request.getGameId())
                .orElseThrow(() -> new RuntimeException("Game not found"));

        if (!game.getIsAvailable()) {
            return "Game is currently unavailable!";
        }

        if (member.getBalance() < game.getPrice()) {
            return "Insufficient balance!";
        }

        // Deduct balance
        member.setBalance(member.getBalance() - game.getPrice());
        member.setTotalGamesPlayed(member.getTotalGamesPlayed() + 1);
        memberRepository.save(member);

        // Create play history
        PlayHistory playHistory = new PlayHistory(member, game, game.getPrice());
        playHistoryRepository.save(playHistory);

        return String.format("Game '%s' played successfully! Balance deducted: $%.2f",
                game.getName(), game.getPrice());
    }
}