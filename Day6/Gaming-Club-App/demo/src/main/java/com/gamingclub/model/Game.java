package com.gamingclub.model;

import jakarta.persistence.*;

@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double price;

    private String description;

    @Column(name = "category")
    private String category; // ARCADE, STRATEGY, SPORTS, ADVENTURE, PUZZLE

    @Column(name = "difficulty_level")
    private String difficultyLevel; // EASY, MEDIUM, HARD

    @Column(name = "is_available")
    private Boolean isAvailable = true;

    // Remove the bidirectional mapping to avoid circular dependencies
    // @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    // private List<PlayHistory> playHistory = new ArrayList<>();

    // Constructors
    public Game() {}

    public Game(String name, Double price, String description, String category, String difficultyLevel) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.difficultyLevel = difficultyLevel;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getDifficultyLevel() { return difficultyLevel; }
    public void setDifficultyLevel(String difficultyLevel) { this.difficultyLevel = difficultyLevel; }

    public Boolean getIsAvailable() { return isAvailable; }
    public void setIsAvailable(Boolean isAvailable) { this.isAvailable = isAvailable; }
}