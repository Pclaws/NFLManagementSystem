/**
 * Manages player-related operations such as loading and displaying players.
 */
package dev.assign2.managers;

import dev.assign2.models.Player;
import dev.assign2.models.Team;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PlayerManager {
    private List<Player> players = new ArrayList<>();

    /**
     * Loads players from a CSV file and assigns them to the corresponding teams.
     *
     * @param csvFilePath the path to the CSV file containing player data
     * @param teamManager the TeamManager instance used to assign players to teams
     * @throws Exception if the file is not found or has an invalid format
     */
    public void loadPlayers(String csvFilePath, TeamManager teamManager) throws Exception {
        try (BufferedReader buff = new BufferedReader(new FileReader(csvFilePath))) {
            String line = buff.readLine();
            if (line == null) throw new Exception("Empty CSV file: " + csvFilePath);
            int numCols = line.split(",").length;

            // Process the first line as data and then remaining lines
            do {
                String[] fields = line.split(",");
                if (fields.length != numCols) {
                    throw new Exception("Invalid CSV format for players. Expected " + numCols + " columns.");
                }
                String playerId = fields[0];
                String name = fields[1];
                int age = Integer.parseInt(fields[2]);
                String teamName = fields[3];
                String position = fields[4];

                Player player = new Player(playerId, name, age, teamName, position);

                // Assign player to the correct team
                Team team = teamManager.findTeam(teamName);
                if (team != null) {
                    team.addPlayer(player);
                }
                players.add(player);
            } while ((line = buff.readLine()) != null);
        } catch (FileNotFoundException e) {
            throw new Exception("File not found: " + csvFilePath);
        } catch (IOException | NumberFormatException e) {
            throw new Exception("Error processing players file.");
        }
    }



    /**
     * Displays all loaded players in a formatted table.
     */
    public void displayPlayers() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.printf("%-6s %-18s %-4s %-12s %-18s%n", "ID", "Player", "Age", "Team", "Position");
        System.out.println("---------------------------------------------------------------------------------");

        for (Player player : players) {
            System.out.printf("%-6s %-18s %-4d %-12s %-18s%n",
                    player.getPlayerId(),
                    player.getName(),
                    player.getAge(),
                    player.getTeamName(),
                    player.getPosition());
        }
    }

    public List<Player> getPlayers() {
        return players;
    }
}

