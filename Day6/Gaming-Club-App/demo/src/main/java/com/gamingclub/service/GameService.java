package com.gamingclub.service;

import com.gamingclub.dto.GameRequest;
import com.gamingclub.model.Game;
import com.gamingclub.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public Game createGame(GameRequest request) {
        Game game = new Game(request.getName(), request.getPrice(), request.getDescription(),
                request.getCategory(), request.getDifficultyLevel());
        return gameRepository.save(game);
    }
}