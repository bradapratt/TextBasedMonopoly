package com.game.monopoly;

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
        int result = switch (getOwner().getNumUtilities()) {
            case 1 -> 4 * diceRoll;
            case 2 -> 10 * diceRoll;

            default -> throw new IllegalStateException("Unexpected value: " + diceRoll);
        };
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
