package com.gamingclub.service;

import com.gamingclub.model.RechargeHistory;
import com.gamingclub.repository.RechargeHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class CollectionService {

    @Autowired
    private RechargeHistoryRepository rechargeHistoryRepository;

    public List<RechargeHistory> getDailyCollection(String date) {
        LocalDate localDate = LocalDate.parse(date);
        return rechargeHistoryRepository.findByDate(localDate);
    }
}