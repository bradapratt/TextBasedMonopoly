package com.game.monopoly;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
/**
 * All methods in this class will be static. We will add as we go.
 */
class Message {
    /**
     * Creates formatted string to display the current player rankings.
     * @param currentRankings - list of current rankings
     */
    public static void displayCurrentRankings(List<Player> currentRankings) {
        StringBuilder msg = new StringBuilder("Current rankings: \n");
        int rank = 1;

        for (Player player: currentRankings){
            msg.append("\t").append(rank).append(") ").append(player.getName()).append(": $");
            msg.append(player.getWallet()).append("\n");
            rank++;
        }

        System.out.printf(msg.toString());
    }

    /**
     * Creates formatted string to display the final rankings.
     * @param finalRankings - list of final rankings
     */
    public static void displayFinalRankings(List<Player> finalRankings) {
        StringBuilder msg = new StringBuilder("Final rankings: \n");
        int rank = 1;

        for (Player player: finalRankings){
            msg.append("\t").append(rank).append(") ").append(player.getName()).append(": $");
            msg.append(player.getWallet()).append("\n");
            rank++;
        }

        System.out.printf(msg.toString());
    }

    /**
     * Displays the monopoly banner from file "banner.txt"
     * @throws IOException - Error reading file
     */
    public static void banner(String fileName, String folder) throws IOException {
        try{
            List<String> banner = Files.readAllLines(Path.of(folder, fileName));

            for (String line : banner){
                System.out.println(line);
            }
            System.out.println();
        } catch (IOException e){
            System.out.println("Error displaying banner.");
        }
    }

    /**
     * Displays the game over banner from file "endgame.txt"
     */
    public static void gameOver(String fileName, String folder) throws IOException{
        try{
            List<String> banner = Files.readAllLines(Path.of(folder, fileName));

            for (String line : banner){
                System.out.println(line);
            }
            System.out.println();
        } catch (IOException e){
            System.out.println("Error displaying game over.");
        }
    }

    /**
     * Prints welcome message to the console.
     */
    public static void welcome() {
        String welcome = "Welcome to text-based monopoly!";
        System.out.println(welcome);
    }

    /**
     * Returns a message stating that input number was invalid. Prompts user to try again.
     * @return msg - message
     */
    public static String invalidNumber() {
        return "Not a valid number, please try again.\n";
    }

    /**
     * Outputs to user a list of available game pieces to choose from.
     * @param available - list of available pieces
     * @return msg - message
     */
    public static String choosePiece(List<String> available) {
        StringBuilder msg = new StringBuilder("Choose a game piece for your character. Options: ");
        for (String piece : available){
            msg.append("\n\t").append(piece);
        }
        msg.append("\nType your desired piece EXACTLY as shown: ");
        return msg.toString();
    }

    /**
     * Returns a message stating that input piece was invalid. Prompts user to try again.
     * @return msg - message
     */
    public static String invalidPiece() {
        return "Not a valid piece name, please try again.\n";
    }

    /**
     * Displays a banner showing the current round.
     * @param currentRound - current round
     */
    public static void displayRoundCount(int currentRound) {
        StringBuilder msg = new StringBuilder("****************************************\n***************ROUND ");
        msg.append(currentRound);
        String current = Integer.toString(currentRound);
        for (int i = 0; i < 19 - current.length(); i++){
            msg.append("*");
        }
        msg.append("\n****************************************\n");
        System.out.println();
        System.out.printf(msg.toString());
        System.out.println();
    }

    /**
     * Prints dialog for the player taking their turn. Notifies of turn, dice roll, and movement.
     * @param player - current player
     * @param roll1 - first die roll
     * @param roll2 - second die roll
     */
    public static void playerTurn(Player player, int roll1, int roll2) {
        System.out.println("Player " + player.getNumber() + "'s Turn: ");
        System.out.println(player.getName() + " rolls the dice: " + roll1 + " & " + roll2);
        System.out.println(player.getName() + " moves " + player.getGamePiece().toString() + " " + (roll1 + roll2) + " spaces.");
    }

    /**
     * Displays "end of round" banner
     * @param currentRound- current round
     */
    public static void endOfRound(int currentRound) {
        StringBuilder msg = new StringBuilder("************End of Round " + currentRound);
        String current = Integer.toString(currentRound);
        for (int i = 0; i < 15 - current.length(); i++){
            msg.append("*");
        }
        System.out.println(msg.toString());
    }

    /**
     * Displays remaining round count.
     * @param checkRoundCount - rounds remaining
     */
    public static void remainingRounds(int checkRoundCount) {
        System.out.println(checkRoundCount + " round(s) remaining.");
    }

    /**
     * Displays the winner for the game when there is only one person left standing.
     * @param player - winner
     */
    public static void endGame_lastPlayer(Player player) {
        System.out.println("Player " + player.getNumber() + ": " + player.getName() + " was the last person standing and wins the game!");
    }

    /**
     * Displays the winner for the game when all rounds have finished.
     * @param player - winner
     */
    public static void endGame_lastRound(Player player) {
        System.out.println("Player " + player.getNumber() + ": " + player.getName() + " was the person with the most money and wins the game!");
    }

    /**
     * Lets player(s) know new game is being created.
     */
    public static void playAgain() {
        System.out.println("Setting up new game...");
    }

    /**
     * Says goodbye to player(s).
     */
    public static void dontPlayAgain() {
        System.out.println("Thank you for play Text-Based Monopoly! Goodbye!");
    }
}
