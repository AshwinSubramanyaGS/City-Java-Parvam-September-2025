package com.gamingclub.repository;

import com.gamingclub.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, Long> {
    Optional<Game> findByName(String name);
    List<Game> findByIsAvailableTrue();
    List<Game> findByCategory(String category);
}