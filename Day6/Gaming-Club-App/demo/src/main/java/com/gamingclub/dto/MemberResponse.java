package com.gamingclub.dto;

import com.gamingclub.model.Member;
import java.util.List;

public class MemberResponse {
    private Member member;
    private List<RechargeHistoryDTO> rechargeHistory;
    private List<GameDTO> availableGames;
    private List<PlayHistoryDTO> playedHistory;
    private GamingStatsDTO gamingStats;

    public MemberResponse() {}

    public MemberResponse(Member member, List<RechargeHistoryDTO> rechargeHistory,
                          List<GameDTO> availableGames, List<PlayHistoryDTO> playedHistory,
                          GamingStatsDTO gamingStats) {
        this.member = member;
        this.rechargeHistory = rechargeHistory;
        this.availableGames = availableGames;
        this.playedHistory = playedHistory;
        this.gamingStats = gamingStats;
    }

    // Getters and Setters
    public Member getMember() { return member; }
    public void setMember(Member member) { this.member = member; }

    public List<RechargeHistoryDTO> getRechargeHistory() { return rechargeHistory; }
    public void setRechargeHistory(List<RechargeHistoryDTO> rechargeHistory) { this.rechargeHistory = rechargeHistory; }

    public List<GameDTO> getAvailableGames() { return availableGames; }
    public void setAvailableGames(List<GameDTO> availableGames) { this.availableGames = availableGames; }

    public List<PlayHistoryDTO> getPlayedHistory() { return playedHistory; }
    public void setPlayedHistory(List<PlayHistoryDTO> playedHistory) { this.playedHistory = playedHistory; }

    public GamingStatsDTO getGamingStats() { return gamingStats; }
    public void setGamingStats(GamingStatsDTO gamingStats) { this.gamingStats = gamingStats; }

    // Inner DTO classes
    public static class RechargeHistoryDTO {
        private Long id;
        private Double amount;
        private String dateTime;

        public RechargeHistoryDTO() {}
        public RechargeHistoryDTO(Long id, Double amount, String dateTime) {
            this.id = id;
            this.amount = amount;
            this.dateTime = dateTime;
        }

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        public Double getAmount() { return amount; }
        public void setAmount(Double amount) { this.amount = amount; }
        public String getDateTime() { return dateTime; }
        public void setDateTime(String dateTime) { this.dateTime = dateTime; }
    }

    public static class GameDTO {
        private Long id;
        private String name;
        private Double price;
        private String description;
        private String category;
        private String difficultyLevel;

        public GameDTO() {}
        public GameDTO(Long id, String name, Double price, String description, String category, String difficultyLevel) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.description = description;
            this.category = category;
            this.difficultyLevel = difficultyLevel;
        }

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public Double getPrice() { return price; }
        public void setPrice(Double price) { this.price = price; }
        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
        public String getCategory() { return category; }
        public void setCategory(String category) { this.category = category; }
        public String getDifficultyLevel() { return difficultyLevel; }
        public void setDifficultyLevel(String difficultyLevel) { this.difficultyLevel = difficultyLevel; }
    }

    public static class PlayHistoryDTO {
        private Long id;
        private String dateTime;
        private String gameName;
        private String gameCategory;
        private Double amount;

        public PlayHistoryDTO() {}
        public PlayHistoryDTO(Long id, String dateTime, String gameName, String gameCategory, Double amount) {
            this.id = id;
            this.dateTime = dateTime;
            this.gameName = gameName;
            this.gameCategory = gameCategory;
            this.amount = amount;
        }

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        public String getDateTime() { return dateTime; }
        public void setDateTime(String dateTime) { this.dateTime = dateTime; }
        public String getGameName() { return gameName; }
        public void setGameName(String gameName) { this.gameName = gameName; }
        public String getGameCategory() { return gameCategory; }
        public void setGameCategory(String gameCategory) { this.gameCategory = gameCategory; }
        public Double getAmount() { return amount; }
        public void setAmount(Double amount) { this.amount = amount; }
    }

    public static class GamingStatsDTO {
        private Integer totalGamesPlayed;
        private Double totalAmountSpent;
        private String favoriteCategory;
        private String memberSince;

        public GamingStatsDTO() {}
        public GamingStatsDTO(Integer totalGamesPlayed, Double totalAmountSpent, String favoriteCategory, String memberSince) {
            this.totalGamesPlayed = totalGamesPlayed;
            this.totalAmountSpent = totalAmountSpent;
            this.favoriteCategory = favoriteCategory;
            this.memberSince = memberSince;
        }

        public Integer getTotalGamesPlayed() { return totalGamesPlayed; }
        public void setTotalGamesPlayed(Integer totalGamesPlayed) { this.totalGamesPlayed = totalGamesPlayed; }
        public Double getTotalAmountSpent() { return totalAmountSpent; }
        public void setTotalAmountSpent(Double totalAmountSpent) { this.totalAmountSpent = totalAmountSpent; }
        public String getFavoriteCategory() { return favoriteCategory; }
        public void setFavoriteCategory(String favoriteCategory) { this.favoriteCategory = favoriteCategory; }
        public String getMemberSince() { return memberSince; }
        public void setMemberSince(String memberSince) { this.memberSince = memberSince; }
    }
}