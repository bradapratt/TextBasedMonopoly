package com.game.monopoly;

import com.apps.util.Prompter;

public class Railroad extends OwnableSpace {
    public Railroad(String name, int price) {
        super(name, price);
    }

    /**
     * Railroad rent amount is determined by the number of railroads (RR's) a player owns.
     * One owned - $25
     * Two owned - $50
     * Three owned - $100
     * Four owned - $200
     *
     * @param player
     * @param diceRoll
     * @return
     */
    @Override
    public int rent(Player player, int diceRoll) {
        int result = switch (player.getNumRailRoads()) {
            case 1 -> 25;
            case 2 -> 50;
            case 3 -> 100;
            case 4 -> 200;

            default -> throw new IllegalStateException("Unexpected value: " + player.getNumRailRoads());
        };
        return result;
    }

    @Override
    public void displayMessage() {
    }
}
