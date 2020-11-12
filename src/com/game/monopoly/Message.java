package com.game.monopoly;

/**
 * All methods in this class will be static. Message class stores static message methods to be
 * throughout the text-based Monopoly implementation. It acts as a centralized repository for
 * all messages printed to the console.
 *
 * Authors: Bradley Pratt, Christopher Palmer, & Tyrone Moore
 * Last Edited: 11/11/2020
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

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
    public static String invalidNumPlayers() {
        return "Number of players must be between 2 and 8. Please try again.\n";
    }

    /**
     * Returns a message stating that input number was invalid. Prompts user to try again.
     * @return msg - message
     */
    public static String invalidNumRounds() {
        return "Number of rounds must be between 1 and 9999. Please try again.\n";
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
     * Prints that input piece was invalid. Prompts user to try again.
     */
    public static void invalidPiece() {
        System.out.println("Not a valid piece name, please try again.");
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
        System.out.println("Thank you for playing Text-Based Monopoly! Goodbye!");
    }

    /**
     * Informs player they passed Go.
     */
    public static void passGo() {
        System.out.println("You passed Go. You collect $200.");
    }

    /**
     * Informs player they landed on Go.
     */
    public static void landedGo() {
        System.out.println("You landed on Go. You collect $200.");
    }

    /**
     * Informs player they landed on Free Parking and the amount they collect.
     * @param freeParking
     */
    public static void freeParking(int freeParking) {
        System.out.println("You landed on Free Parking. You collect the current Free Parking Fund balance of $" + freeParking);
    }

    /**
     * Informs player they landed on Chance.
     */
    public static void landedChance() {
        System.out.println("You landed on Chance. You draw a random card from the pile and it says: ");
    }

    /**
     * Informs player they landed on Chance.
     */
    public static void landedCommunityChest() {
        System.out.println("You landed on Community Chest. You draw a random card from the pile and it says: ");
    }

    /**
     * Informs player they do not have enough money they are attempting to buy.
     * @param name - property name
     * @param price - property price
     * @param wallet - amount current player has
     */
    public static void cantBuyProperty(String name, int price, int wallet) {
        System.out.println("You don't have enough money to buy " + name + ".");
        System.out.println(name + " costs $" + price + ", you have $" + wallet + " in your account.");
    }

    /**
     * Informs player of an attempt to add a negative amount to free parking
     */
    public static void invalidFreeParkingAmount() {
        System.out.println("Can't add negative amount to Free Parking. Nothing added to fund.");
    }

    /**
     * Displays Community Chest card #1 for the player to read.
     */
    public static void CommunityChestCard1() {
        System.out.println("Bank error in your favor: collect $200.");
        System.out.println("You collect $200!");
    }

    /**
     * Displays Community Chest card #2 for the player to read.
     */
    public static void CommunityChestCard2() {
        System.out.println("Lawyer's fee: pay $50.");
        System.out.println("You pay $50.");
    }

    /**
     * Displays Community Chest card #3 for the player to read.
     */
    public static void CommunityChestCard3() {
        System.out.println("Pay school tax.");
        System.out.println("You pay $150.");
    }

    /**
     * Displays Community Chest card #4 for the player to read.
     */
    public static void CommunityChestCard4() {
        System.out.println("Sell your stock holdings.");
        System.out.println("You collect $45!");
    }

    /**
     * Displays Community Chest card #5 for the player to read.
     */
    public static void CommunityChestCard5() {
        System.out.println("Pay hospital bill.");
        System.out.println("You pay $100.");
    }

    /**
     * Displays Community Chest card #6 for the player to read.
     */
    public static void CommunityChestCard6() {
        System.out.println("Receive inheritance windfall.");
        System.out.println("You receive $200!");
    }

    /**
     * Displays Chance card #1 for the player to read.
     */
    public static void ChanceCard1() {
        System.out.println("Collect monthly rent from your tenants.");
        System.out.println("You collect $400!");
    }

    /**
     * Displays Chance card #2 for the player to read.
     */
    public static void ChanceCard2() {
        System.out.println("Buy lottery tickets...and win nothing.");
        System.out.println("You lose $35.");
    }

    /**
     * Displays Chance card #3 for the player to read.
     */
    public static void ChanceCard3() {
        System.out.println("Invest early in electric car company.");
        System.out.println("You invest $200.");
    }

    /**
     * Displays Chance card #4 for the player to read.
     */
    public static void ChanceCard4() {
        System.out.println("Friend pays back loan...with interest!");
        System.out.println("You receive $215!");
    }

    /**
     * Displays Chance card #5 for the player to read.
     */
    public static void ChanceCard5() {
        System.out.println("Lend friend money.");
        System.out.println("You lend $100.");
    }

    /**
     * Displays Chance card #6 for the player to read.
     */
    public static void ChanceCard6() {
        System.out.println("Win city-wide karaoke contest.");
        System.out.println("You win $300!");
    }

    public static void landedOnOwned(Player owner, int rent) {
        System.out.println("This space is owned by " + owner.getName() + "!");
        System.out.println("Pay rent of $" + rent + ".");
    }

    public static void landedOn(String name) {
        System.out.println("You landed on " + name + ".");
    }

    public static void showPlayerBalance(String name, int wallet) {
        System.out.println(name + " you have $" + wallet + " in your account.");
    }

    public static void oweTax(Player tenant, int taxAmount) {
        System.out.println(tenant.getName() + " you owe taxes of $" + taxAmount + ".");
    }
}
