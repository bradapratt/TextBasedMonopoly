package com.game.monopoly;

import com.apps.util.Prompter;

public class Utility extends OwnableSpace {

    public Utility(String name, int price) {
        super(name, price);
    }

    /**
     * Utility rent is determined by the number of utilities a player owns.
     * One owned - 4x the amount shown on dice
     * Both owned - 10x the amount shown on dice
     *
     * @param owner
     * @param diceRoll
     * @return
     */
    @Override
    public int rent(Player owner, int diceRoll) {
        int result = switch (owner.getNumUtilities()) {
            case 1 -> 4 * diceRoll;
            case 2 -> 10 * diceRoll;

            default -> throw new IllegalStateException("Unexpected value: " + diceRoll);
        };
        return result;
    }

    @Override
    public void displayMessage() {
    }
}
