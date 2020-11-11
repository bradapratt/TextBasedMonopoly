package com.game.monopoly;

class Bank {
    private static final int ZERO = 0;

    /**
     * Transacts property purchase by collect() property.price from Player. Returns
     * true if player has enough money, otherwise false.
     * @param player
     * @param propertyPrice
     */
    public static boolean payForProperty(Player player, int propertyPrice) {
        boolean result = false;
        if (hasEnoughCash(player, propertyPrice)) {
            collect(player, propertyPrice);
            result = true;
        }
        return result;
    }



    /**
     * Bank collects amount from the player one (tenant) and pays to player two (owner) of property.
     * Returns false if player doesn't have enough money (and needs to declare bankruptcy).
     * @param tenant
     * @param owner
     * @param rent
     * @return
     */
    public static boolean payRent(Player tenant, Player owner, int rent) {
        // TODO if tenant can't afford can't to pay, then owner seizes all of tenants property and is bankrupt
        boolean result = false;
        if (hasEnoughCash(tenant, rent)) {
            collect(tenant, rent);
            pay(owner, rent);
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
        if (hasEnoughCash(player, tax)) {
            collect(player, tax);
            FreeParking.addToFreeParking(tax);
        }
    }

    /**
     * Takes amount owed from the player's wallet.
     * @param player
     * @param amount
     */
    public static void collect(Player player, int amount) {
        int balance = player.getWallet();
        player.setWallet(balance - amount);
    }

    /**
     * Deposits amount due to the player's wallet.
     * @param player
     * @param amount
     */
    public static void pay(Player player, int amount){
        int balance = player.getWallet();
        player.setWallet(balance + amount);
    }

    private static boolean hasEnoughCash(Player player, int amount) {
        boolean result = false;
        if ((player.getWallet() - amount) >= amount || player.getWallet() == amount) {
            result = true;
        }
        return result;
    }
}
