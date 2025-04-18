/**
 * Manages team-related operations such as loading teams, displaying teams, and adding teams.
 */
package dev.assign2.managers;

import dev.assign2.models.Coach;
import dev.assign2.models.Team;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TeamManager {

    private List<Team> teams = new ArrayList<>();

    /**
     * Loads teams from a CSV file.
     *
     * @param csvFile the path to the CSV file containing team data
     * @throws Exception if the file is not found or has an invalid format
     */
    public void loadTeams(String csvFile) throws Exception {
        try (BufferedReader buff = new BufferedReader(new FileReader(csvFile))) {
            String line = buff.readLine();
            if (line == null) {
                throw new Exception("Empty CSV file: " + csvFile);
            }
            int numCols = line.split(",").length;

            // Process the first line as data and then remaining lines
            do {
                String[] fields = line.split(",");
                if (fields.length != numCols) {
                    throw new Exception("Invalid CSV format for teams. Expected " + numCols + " columns.");
                }
                String teamName = fields[0];
                String city = fields[1];
                String coachName = fields[2];
                int yearsOfExperience = (fields.length > 3) ? Integer.parseInt(fields[3]) : 0;
                String coachId = "C" + String.format("%02d", teams.size() + 1);
                Coach coach = new Coach(coachId, coachName, teamName, yearsOfExperience);
                teams.add(new Team(teamName, city, coach));
            } while ((line = buff.readLine()) != null);
        } catch (FileNotFoundException e) {
            throw new Exception("File not found: " + csvFile);
        } catch (IOException | NumberFormatException e) {
            throw new Exception("Error processing teams file.");
        }
    }


    /**
     * Finds a team by its name.
     *
     * @param teamName the name of the team to search for
     * @return the Team object if found; otherwise, null
     */
    public Team findTeam(String teamName) {
        for (Team team : teams) {
            if (team.getTeamName().equalsIgnoreCase(teamName)) {
                return team;
            }
        }
        return null;
    }

    /**
     * Displays all loaded teams in a formatted table.
     */
    public void displayTeams() {
        System.out.println("---------------------------------------------------------------------");
        System.out.printf("%-12s %-15s %-30s %s%n", "Team", "City", "Coach", "Players");
        System.out.println("---------------------------------------------------------------------");

        for (Team team : teams) {
            System.out.printf("%-12s %-15s %-30s %d%n",
                    team.getTeamName(),
                    team.getCity(),
                    team.getCoach().getName() + " (" + team.getCoach().getYearsOfExperience() + " years)",
                    team.getPlayers().size());
        }
    }

    /**
     * Adds a new team to the list of teams.
     *
     * @param teamName          the name of the team
     * @param city              the city the team is based in
     * @param coachName         the name of the coach
     * @param yearsOfExperience the coach's years of experience
     */
    public void addTeam(String teamName, String city, String coachName, int yearsOfExperience) {
        String coachId = "C" + String.format("%02d", teams.size() + 1); // Generate coach ID dynamically
        Coach coach = new Coach(coachId, coachName, teamName, yearsOfExperience);
        teams.add(new Team(teamName, city, coach));
        System.out.println("Team added successfully!");
    }
}

