package com.game.monopoly;

class Bank {

    /**
     * Transacts property purchase by collect() property.price from Player. Returns
     * true if player has enough money, otherwise false.
     * @param buyer
     * @param propertyPrice
     */
    public static boolean payForProperty(Player buyer, int propertyPrice){
        return false;
    }

    /**
     * Bank collects amount from the player who owes and pays to the owner of property.
     * Returns false if player doesn't have enough money (and needs to declare bankruptcy).
     * @param owes
     * @param dueMoney
     * @param amount
     * @return
     */
    public static boolean payRent(Player owes, Player dueMoney, int amount){
        return false;
    }

    /**
     * Takes amount owed from the player's wallet.
     * @param owes
     * @param amount
     */
    private static void collect(Player owes, int amount){
    }

    /**
     * Deposits amount due to the player's wallet.
     * @param dueMoney
     * @param amount
     */
    private static void pay(Player dueMoney, int amount){
    }

    /**
     * Collect tax money from Player and add to free parking fund.
     * @param owes
     * @param amount
     */
    public static void payIntoFreeParking(Player owes, int amount){
    }

}
