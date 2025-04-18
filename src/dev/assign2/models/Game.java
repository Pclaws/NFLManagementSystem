/**
 * Represents a game between two teams in the NFL management system.
 * Contains details such as the teams involved, date, location, and score.
 */
package dev.assign2.models;

import java.io.Serial;
import java.io.Serializable;

public class Game implements Serializable {



    @Serial
    private static final long serialVersionUID = 1L;

    private String team1;
    private String team2;
    private String date;
    private String location;
    private String score;

    /**
     * Constructs a new Game.
     *
     * @param team1    the name of the first team
     * @param team2    the name of the second team
     * @param date     the date of the game
     * @param location the location where the game is played
     * @param score    the score of the game
     */
    public Game(String team1, String team2, String date, String location, String score) {
        this.team1 = team1;
        this.team2 = team2;
        this.date = date;
        this.location = location;
        this.score = score;
    }

    /**
     * Returns the name of the first team.
     *
     * @return team1 name
     */
    public String getTeam1() {
        return team1;
    }

    /**
     * Returns the name of the second team.
     *
     * @return team2 name
     */
    public String getTeam2() {
        return team2;
    }

    /**
     * Returns the date of the game.
     *
     * @return game date
     */
    public String getDate() {
        return date;
    }

    /**
     * Returns the location of the game.
     *
     * @return game location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Returns the score of the game.
     *
     * @return game score
     */
    public String getScore() {
        return score;
    }

    /**
     * Returns a string representation of the game.
     *
     * @return a formatted string with game details
     */
    @Override
    public String toString() {
        return String.format("Game: %s vs %s on %s at %s, Score: %s",
                team1, team2, date, location, score);
    }
}

