package com.gamingclub.controller;

import com.gamingclub.dto.PlayRequest;
import com.gamingclub.service.PlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/play")
@CrossOrigin(origins = "*") // Add this to avoid CORS issues
public class PlayController {

    @Autowired
    private PlayService playService;

    @PostMapping
    public ResponseEntity<String> playGame(@RequestBody PlayRequest request) {
        try {
            System.out.println("Received play request: " + request.getMemberId() + ", " + request.getGameId());
            String result = playService.playGame(request);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}