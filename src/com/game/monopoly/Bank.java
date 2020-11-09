package com.game.monopoly;

class Bank {
    private static final int ZERO = 0;

    /**
     * Transacts property purchase by collect() property.price from Player. Returns
     * true if player has enough money, otherwise false.
     * @param player
     * @param propertyPrice
     */
    public static boolean payForProperty(Player player, int propertyPrice){
        boolean result = false;
        if (hasEnoughCash(player.getWallet() - propertyPrice)) {
            collect(player, propertyPrice);
            result = true;
        }
        return result;
    }



    /**
     * Bank collects amount from the player one and pays to the owner (playerTwo) of property.
     * Returns false if player doesn't have enough money (and needs to declare bankruptcy).
     * @param playerOne
     * @param playerTwo
     * @param rent
     * @return
     */
    public static boolean payRent(Player playerOne, Player playerTwo, int rent){
        boolean result = false;
        if (hasEnoughCash(playerOne.getWallet() - rent)) {
            collect(playerOne, rent);
            pay(playerTwo, rent);
            result = true;

        }
        return result;
    }

    /**
     * Collect tax money from Player and add to free parking fund.
     * @param player
     * @param tax
     */
    public static void payIntoFreeParking(Player player, int tax) {
        collect(player, tax);

    }

    /**
     * Takes amount owed from the player's wallet.
     * @param player
     * @param amount
     */
    private static void collect(Player player, int amount) {
        int balance = player.getWallet();
        player.setWallet(balance - amount);
    }

    /**
     * Deposits amount due to the player's wallet.
     * @param player
     * @param amount
     */
    private static void pay(Player player, int amount){
        int balance = player.getWallet();
        player.setWallet(balance + amount);
    }

    private static boolean hasEnoughCash(int i) {
        return i >= ZERO;
    }
}
