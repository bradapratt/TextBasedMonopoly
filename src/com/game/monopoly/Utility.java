package com.game.monopoly;

/**
 * Utility represents the two utility spaces on a Monopoly board, Water Works
 * and Electric Company.
 *
 * Authors: Bradley Pratt, Christopher Palmer, & Tyrone Moore
 * Last Edited: 11/12/2020
 */
public class Utility extends OwnableSpace {

    public Utility(String name, int price) {
        super(name, price);
    }

    /**
     * Utility rent is determined by the number of utilities a player owns.
     * One owned - 4x the amount shown on dice
     * Both owned - 10x the amount shown on dice
     *
     * @param diceRoll
     * @return
     */
    @Override
    public int rent(int diceRoll) {
        int result = 0;
        switch (getOwner().getNumUtilities()) {
            case 1: result = 4 * diceRoll;
            break;
            case 2: result = 10 * diceRoll;
        }
        Message.landedOnOwned_Owner(getOwner());
        Message.numUtilitiesOwned(getOwner().getName(), getOwner().getNumUtilities());
        Message.landedOnOwned_Rent(result);
        return result;
    }

    @Override
    public void displayMessage() {
        Message.landedOn(this.getName());
    }
}
