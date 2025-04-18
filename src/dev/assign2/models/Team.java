/**
 * Represents a team in the NFL management system.
 * Contains information such as team name, city, coach, and a list of players.
 */
package dev.assign2.models;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Team implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String teamName;
    private String city;
    private Coach coach;
    private List<Player> players;



    /**
     * Constructs a new Team.
     *
     * @param teamName the name of the team
     * @param city     the city where the team is based
     * @param coach    the coach associated with the team
     */
    public Team(String teamName, String city, Coach coach) {
        this.teamName = teamName;
        this.city = city;
        this.coach = coach;
        this.players = new ArrayList<>();
    }

    /**
     * Returns the team's name.
     *
     * @return team name
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * Returns the city where the team is based.
     *
     * @return city name
     */
    public String getCity() {
        return city;
    }

    /**
     * Returns the coach of the team.
     *
     * @return Coach object
     */
    public Coach getCoach() {
        return coach;
    }

    /**
     * Returns the list of players in the team.
     *
     * @return list of players
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * Adds a player to the team.
     *
     * @param player the player to be added
     */
    public void addPlayer(Player player) {
        players.add(player);
    }

    /**
     * Returns a string representation of the team.
     *
     * @return a formatted string with team details
     */
    @Override
    public String toString() {
        return String.format("Team (%s), City (%s), Coach (%s), Players: %d",
                teamName, city, coach.getName(), players.size());
    }
}
