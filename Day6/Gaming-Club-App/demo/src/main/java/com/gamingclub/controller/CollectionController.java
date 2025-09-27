package com.gamingclub.controller;

import com.gamingclub.model.RechargeHistory;
import com.gamingclub.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/collection")
public class CollectionController {

    @Autowired
    private CollectionService collectionService;

    @GetMapping("/{date}")
    public ResponseEntity<List<RechargeHistory>> getDailyCollection(@PathVariable String date) {
        List<RechargeHistory> collections = collectionService.getDailyCollection(date);
        return ResponseEntity.ok(collections);
    }
}