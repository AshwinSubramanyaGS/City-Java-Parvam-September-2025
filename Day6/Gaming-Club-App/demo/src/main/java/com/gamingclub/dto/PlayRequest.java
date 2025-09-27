package com.gamingclub.dto;

public class PlayRequest {
    private Long memberId;
    private Long gameId;

    public PlayRequest() {}

    public PlayRequest(Long memberId, Long gameId) {
        this.memberId = memberId;
        this.gameId = gameId;
    }

    public Long getMemberId() { return memberId; }
    public void setMemberId(Long memberId) { this.memberId = memberId; }

    public Long getGameId() { return gameId; }
    public void setGameId(Long gameId) { this.gameId = gameId; }
}