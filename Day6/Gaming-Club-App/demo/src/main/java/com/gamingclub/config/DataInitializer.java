package com.gamingclub.config;

import com.gamingclub.model.Game;
import com.gamingclub.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private GameRepository gameRepository;

    @Override
    public void run(String... args) throws Exception {
        // Add sample games if none exist
        if (gameRepository.count() == 0) {
            Game game1 = new Game("FIFA 2024", 25.0, "Football simulation game", "SPORTS", "MEDIUM");
            Game game2 = new Game("Call of Duty", 30.0, "First-person shooter", "ACTION", "HARD");
            Game game3 = new Game("Mario Kart", 20.0, "Racing game with characters", "RACING", "EASY");
            Game game4 = new Game("Chess Master", 15.0, "Strategic board game", "STRATEGY", "HARD");
            Game game5 = new Game("Puzzle Quest", 10.0, "Mind challenging puzzles", "PUZZLE", "MEDIUM");

            gameRepository.save(game1);
            gameRepository.save(game2);
            gameRepository.save(game3);
            gameRepository.save(game4);
            gameRepository.save(game5);

            System.out.println("Sample games added to the gaming club!");
        }
    }
}