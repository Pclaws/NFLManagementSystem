/**
 * Main class for the NFL Management System application.
 * This class loads teams, players, and games from CSV files and provides a menu-driven interface.
 */
package dev.assign2.main;

import dev.assign2.managers.GameManager;
import dev.assign2.managers.PlayerManager;
import dev.assign2.managers.TeamManager;
import dev.assign2.models.Player;
import dev.assign2.models.Team;

import java.util.Scanner;

public class NFLManagementSystem {

    /**
     * Main method that starts the NFL Management System application.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        TeamManager teamManager = new TeamManager();
        PlayerManager playerManager = new PlayerManager();
        GameManager gameManager = new GameManager();

        try {
            teamManager.loadTeams("resources/teams.csv");
            playerManager.loadPlayers("resources/players.csv", teamManager);
            gameManager.loadGames("resources/games.csv");
        } catch (Exception e) {
            System.out.println("Error loading data: " + e.getMessage());
            return;
        }

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            while (!scanner.hasNextInt()) {
                System.out.println("***Invalid input. Please enter a number.***");
                scanner.next();
                displayMenu();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> teamManager.displayTeams();
                case 2 -> playerManager.displayPlayers();
                case 3 -> gameManager.displayGames();
                case 4 -> addTeam(scanner, teamManager);
                case 5 -> addPlayer(scanner, teamManager,playerManager);
                case 6 -> findTeam(scanner, teamManager);
                case 7 -> System.out.println("Exiting the program by Letshu Phinees Abel...");
                default -> System.out.println("***Invalid choice. Try again.***");
            }
        } while (choice != 7);

        scanner.close();
    }

    /**
     * Displays the main menu options to the user.
     */
    private static void displayMenu() {
        System.out.println("\nNFL Operations Management System");
        System.out.println("1. Display Teams");
        System.out.println("2. Display Players");
        System.out.println("3. Display Scheduled Games");
        System.out.println("4. Add Team");
        System.out.println("5. Add Player to Team");
        System.out.println("6. Find Team");
        System.out.println("7. Exit");
        System.out.print("Enter choice: ");
    }

    /**
     * Adds a new team based on user input.
     *
     * @param scanner     Scanner object to read user input
     * @param teamManager TeamManager instance to manage teams
     */
    private static void addTeam(Scanner scanner, TeamManager teamManager) {
        System.out.print("Enter team name: ");
        String teamName = scanner.nextLine();
        System.out.print("Enter city: ");
        String city = scanner.nextLine();
        System.out.print("Enter coach name: ");
        String coachName = scanner.nextLine();
        System.out.print("Enter coach years of experience: ");
        int yearsOfExperience = getValidInt(scanner);

        teamManager.addTeam(teamName, city, coachName, yearsOfExperience);
    }

    /**
     * Adds a new player to a team based on user input.
     *
     * @param scanner     Scanner object to read user input
     * @param teamManager TeamManager instance to find and add players to teams
     */
    private static void addPlayer(Scanner scanner, TeamManager teamManager,PlayerManager playerManager) {
        System.out.print("Enter player ID: ");
        String playerId = scanner.nextLine();
        System.out.print("Enter player name: ");
        String playerName = scanner.nextLine();
        System.out.print("Enter player age: ");
        int age = getValidInt(scanner);
        System.out.print("Enter team name: ");
        String playerTeamName = scanner.nextLine();
        System.out.print("Enter player position: ");
        String position = scanner.nextLine();

        Team team = teamManager.findTeam(playerTeamName);


        if (team != null) {
            Player newPlayer = new Player(playerId,playerName,age,playerTeamName,position);
            team.addPlayer(newPlayer);           // Adds to the team
            playerManager.getPlayers().add(newPlayer); // Adds to the display list


            System.out.println("Player added successfully!");
        } else {
            System.out.println("Team not found. Player not added.");
        }
    }

    /**
     * Searches and displays a team based on user input.
     *
     * @param scanner     Scanner object to read user input
     * @param teamManager TeamManager instance to search teams
     */
    private static void findTeam(Scanner scanner, TeamManager teamManager) {
        System.out.print("Enter team name to search: ");
        String searchTeamName = scanner.nextLine();
        Team foundTeam = teamManager.findTeam(searchTeamName);
        if (foundTeam != null) {
            System.out.println("Team found: " + foundTeam);
        } else {
            System.out.println("Team not found.");
        }
    }

    /**
     * Retrieves a valid integer from the user.
     *
     * @param scanner Scanner object to read user input
     * @return a valid integer input
     */
    private static int getValidInt(Scanner scanner) {
        int value;
        while (true) {
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                break;
            } else {
                System.out.print("Invalid input. Please enter a valid number: ");
                scanner.next(); // Consume invalid input
            }
        }
        return value;
    }
}

