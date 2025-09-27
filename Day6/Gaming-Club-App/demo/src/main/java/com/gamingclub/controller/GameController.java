package com.gamingclub.controller;
import com.gamingclub.dto.GameRequest;
import com.gamingclub.model.Game;
import com.gamingclub.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping
    public ResponseEntity<Game> createGame(@RequestBody GameRequest request) {
        Game game = gameService.createGame(request);
        return ResponseEntity.ok(game);
    }
}