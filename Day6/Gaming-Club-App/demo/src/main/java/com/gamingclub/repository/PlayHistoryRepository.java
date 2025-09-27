package com.gamingclub.repository;

import com.gamingclub.model.PlayHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PlayHistoryRepository extends JpaRepository<PlayHistory, Long> {
    List<PlayHistory> findByMemberId(Long memberId);
    List<PlayHistory> findByGameId(Long gameId);
}