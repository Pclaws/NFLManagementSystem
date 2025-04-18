/**
 * Represents a player in the NFL management system.
 * Contains information such as player ID, name, age, team, and position.
 */
package dev.assign2.models;

import java.io.Serial;
import java.io.Serializable;

public class Player implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String playerId;
    private String name, teamName, position;
    private int age;

    /**
     * Constructs a new Player.
     *
     * @param playerId the unique identifier for the player
     * @param name     the player's name
     * @param age      the player's age
     * @param teamName the name of the team the player belongs to
     * @param position the player's position
     */
    public Player(String playerId, String name, int age, String teamName, String position) {
        this.playerId = playerId;
        this.name = name;
        this.age = age;
        this.teamName = teamName;
        this.position = position;
    }

    /**
     * Returns the name of the team the player belongs to.
     *
     * @return team name
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * Returns the player's position.
     *
     * @return position
     */
    public String getPosition() {
        return position;
    }

    /**
     * Returns the player's unique ID.
     *
     * @return player ID
     */
    public String getPlayerId() {
        return playerId;
    }

    /**
     * Returns the player's name.
     *
     * @return player name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the player's age.
     *
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * Returns a string representation of the player.
     *
     * @return a formatted string with player details
     */
    @Override
    public String toString() {
        return String.format("ID: %s, Name: %s, Age: %d, Team: %s, Position: %s",
                playerId, name, age, teamName, position);
    }
}
