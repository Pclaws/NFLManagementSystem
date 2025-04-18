/**
 * Manages game-related operations such as loading and displaying games.
 */
package dev.assign2.managers;

import dev.assign2.models.Game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameManager {

    private final List<Game> games = new ArrayList<>();

    /**
     * Loads games from a CSV file.
     *
     * @param csvFilePath the path to the CSV file containing game data
     * @throws Exception if the file is not found or has an invalid format
     */
    public void loadGames(String csvFilePath) throws Exception {
        try (BufferedReader buff = new BufferedReader(new FileReader(csvFilePath))) {
            String line = buff.readLine();
            if (line == null) throw new Exception("Empty CSV file: " + csvFilePath);
            int numCols = line.split(",").length;

            // Process the first line as data and then remaining lines
            do {
                String[] fields = line.split(",");
                if (fields.length != numCols) {
                    throw new Exception("Invalid CSV format for games. Expected " + numCols + " columns.");
                }
                String team1 = fields[0];
                String team2 = fields[1];
                String date = fields[2];
                String location = fields[3];
                String score = fields[4];

                games.add(new Game(team1, team2, date, location, score));
            } while ((line = buff.readLine()) != null);
        } catch (FileNotFoundException e) {
            throw new Exception("File not found: " + csvFilePath);
        } catch (IOException e) {
            throw new Exception("Error processing games file.");
        }
    }


    /**
     * Displays all loaded games in a formatted table.
     */
    public void displayGames() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.printf("%-15s %-15s %-12s %-15s %-7s%n", "Team 1", "Team 2", "Date", "Location", "Score");
        System.out.println("------------------------------------------------------------------------------");

        for (Game game : games) {
            System.out.printf("%-15s %-15s %-12s %-15s %-7s%n",
                    game.getTeam1(),
                    game.getTeam2(),
                    game.getDate(),
                    game.getLocation(),
                    game.getScore());
        }
    }
}

