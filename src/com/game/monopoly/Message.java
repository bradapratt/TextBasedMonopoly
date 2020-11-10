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
     * @param currentRankings
     * @return msg
     */
    public static void displayCurrentRankings(List<Player> currentRankings) {
        String msg = "Current rankings: \n";
        int rank = 1;

        for (Player player: currentRankings){
            msg += "\t" + rank + ") " + player.getName() + ": $" + player.getWallet() + "\n";
            rank++;
        }

        System.out.printf(msg);
    }

    /**
     * Displays the monopoly banner from file "banner.txt"
     * @throws IOException
     */
    public static void banner() throws IOException {
        try{
            List<String> banner = Files.readAllLines(Path.of("data", "banner.txt"));

            for (String line : banner){
                System.out.println(line);
            }
            System.out.println();
        } catch (IOException e){
            System.out.println("Error displaying banner.");
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
     * @return msg
     */
    public static String invalidNumber() {
        String msg = "Not a valid number, please try again.\n";
        return msg;
    }

    /**
     * Outputs to user a list of available game pieces to choose from.
     * @param available
     * @return msg.toString()
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
     * @return msg
     */
    public static String invalidPiece() {
        String msg = "Not a valid piece name, please try again.\n";
        return msg;
    }
}
