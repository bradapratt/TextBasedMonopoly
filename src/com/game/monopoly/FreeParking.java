package com.game.monopoly;

/**
 * Class FreeParking represents the free parking space on a Monopoly board.
 *
 * Authors: Bradley Pratt, Christopher Palmer, & Tyrone Moore
 * Last Edited: 11/10/2020
 */
public class FreeParking extends Space{
    private static final int MIN_VALUE = 0;
    private static int freeParking;

    public FreeParking() {
        super("Free Parking");
        setFreeParking(MIN_VALUE);
    }

    /**
     * Execute actions taken when landing on this space.
     * @param player - current player
     * @param diceRoll - current player's dice roll total
     */
    @Override
    public void execute(Player player, int diceRoll) {
        displayMessage();
        collectFreeParking(player);

    }

    /**
     * Informs player they landed on free parking and the amount collected.
     */
    @Override
    public void displayMessage() {
        Message.freeParking(getFreeParking());
    }

    /**
     * Adds current parking fund to player's wallet and resets fund to zero.
     * @param player - current player
     */
    public static void collectFreeParking(Player player) {
        int balance = player.getWallet();
        player.setWallet(balance + getFreeParking());
        setFreeParking(MIN_VALUE);
    }

    /**
     * Add money to the free parking fund.
     * @param amount - amount to be added in dollars
     */
    public static void addToFreeParking(int amount){
        setFreeParking(getFreeParking() + amount);
    }

    //**********ACCESSOR METHODS**********

    private static int getFreeParking() {
        return freeParking;
    }

    private static void setFreeParking(int freeParking) {
        FreeParking.freeParking = freeParking;
    }
}
