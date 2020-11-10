package com.game.monopoly;

public class FreeParking extends Space{
    private static final int MIN_VALUE = 0;
    private static int freeParking;

    public FreeParking(String name) {
        super(name);
        setFreeParking(MIN_VALUE);
    }

    @Override
    public void execute(Player player, int diceRoll) {

    }

    @Override
    public void displayMessage() {
    }

    /**
     * Adds current parking fund to player's wallet and resets fund to zero.
     * @param player
     */
    public static void collectFreeParking(Player player) {
        int balance = player.getWallet();
        player.setWallet(balance + getFreeParking());
        setFreeParking(MIN_VALUE);
    }

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
