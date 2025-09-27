package com.gamingclub.repository;

import com.gamingclub.model.RechargeHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDate;
import java.util.List;

public interface RechargeHistoryRepository extends JpaRepository<RechargeHistory, Long> {
    List<RechargeHistory> findByMemberId(Long memberId);

    @Query("SELECT rh FROM RechargeHistory rh WHERE DATE(rh.dateTime) = :date")
    List<RechargeHistory> findByDate(LocalDate date);
}