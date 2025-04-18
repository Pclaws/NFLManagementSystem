/**
 * Represents a coach in the NFL management system.
 * Contains information such as coach ID, name, associated team, and years of experience.
 *
 */

// I did not use Coach.csv as there was no need for it in my implementation
package dev.assign2.models;

import java.io.Serial;
import java.io.Serializable;

public class Coach implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String coachId;
    private String name;
    private String teamName;
    private int yearsOfExperience;

    /**
     * Constructs a new Coach.
     *
     * @param coachId           the unique identifier for the coach
     * @param name              the coach's name
     * @param teamName          the name of the team the coach is associated with
     * @param yearsOfExperience the number of years the coach has experience
     */
    public Coach(String coachId, String name, String teamName, int yearsOfExperience) {
        this.coachId = coachId;
        this.name = name;
        this.teamName = teamName;
        this.yearsOfExperience = yearsOfExperience;
    }

    /**
     * Returns the coach ID.
     *
     * @return coach ID
     */
    public String getCoachId() {
        return coachId;
    }

    /**
     * Returns the coach's name.
     *
     * @return coach name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the name of the team the coach is associated with.
     *
     * @return team name
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * Returns the number of years of experience the coach has.
     *
     * @return years of experience
     */
    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    /**
     * Returns a string representation of the coach.
     *
     * @return a formatted string with coach details
     */
    @Override
    public String toString() {
        return String.format("Coach: %s (Team: %s, Experience: %d years)",
                name, teamName, yearsOfExperience);
    }
}
