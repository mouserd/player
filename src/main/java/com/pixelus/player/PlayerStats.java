package com.pixelus.player;

public class PlayerStats {
    private String id;
    private Integer careerGames, careerGoals;

    @Override
    public String toString() {
        return "PlayerStats{" +
            "id=" + id +
            ", careerGames='" + careerGames + '\'' +
            ", careerGoals='" + careerGoals + '\'' +
            '}';
    }

    public PlayerStats() {
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public Integer getCareerGames() {
        return careerGames;
    }

    public void setCareerGames(final Integer careerGames) {
        this.careerGames = careerGames;
    }

    public Integer getCareerGoals() {
        return careerGoals;
    }

    public void setCareerGoals(final Integer careerGoals) {
        this.careerGoals = careerGoals;
    }
}