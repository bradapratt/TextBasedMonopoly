package com.game.monopoly;

public class Utility extends OwnableSpace{
    public Utility(String name, int price){
        super(name, price);
    }

    /**
     * Utility rent is determined by the number of utilities a player owns.
     * One owned - 4x the amount shown on dice
     * Both owned - 10x the amount shown on dice
     * @param player
     * @param context
     * @return
     */
    @Override
    public int rent(Player player, RentContext context) {
        int diceTotal = context.getDiceRoll();
        int result = switch (context.getNumberOwned()) {
            case 1 -> 4 * diceTotal;
            case 2 -> 10 * diceTotal;

            default -> throw new IllegalStateException("Unexpected value: " + context.getDiceRoll());
        };
        return result;
    }

    @Override
    public void execute(Player player, int diceRoll) {

    }

    @Override
    public void displayMessage() {
    }
}
