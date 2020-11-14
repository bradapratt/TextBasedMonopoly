package com.game.monopoly;

/**
 * Railroad implements the four railroad spaces on a Monopoly board.
 *
 * Authors: Bradley Pratt, Christopher Palmer, & Tyrone Moore
 * Last Edited: 11/12/2020
 */
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
     * @param diceRoll - what the current player rolled to land on the railroad
     * @return resulting rent
     */
    @Override
    public int rent(int diceRoll) {
        int result = 0;
        switch (getOwner().getNumRailRoads()) {
            case 1: result = 25;
            break;
            case 2: result = 50;
            break;
            case 3: result = 100;
            break;
            case 4: result = 200;
        }
        Message.landedOnOwned_Owner(getOwner());
        Message.numRailroadsOwned(getOwner().getName(), getOwner().getNumRailRoads());
        Message.landedOnOwned_Rent(result);
        return result;
    }

    @Override
    public void displayMessage() {
        Message.landedOn(this.getName());
    }
}
