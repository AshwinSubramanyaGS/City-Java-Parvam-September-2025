package com.gamingclub.dto;

public class GameRequest {
    private String name;
    private Double price;
    private String description;
    private String category;
    private String difficultyLevel;

    public GameRequest() {}

    public GameRequest(String name, Double price, String description, String category, String difficultyLevel) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.difficultyLevel = difficultyLevel;
    }

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
}