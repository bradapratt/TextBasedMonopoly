package com.game.monopoly;

/**
 * Property implements property spaces on a Monopoly board, that can normally
 * have houses/ hotels built on them (but not in this game).
 * Examples include Park Place, Boardwalk, New York Avenue, etc.
 *
 * Authors: Bradley Pratt, Christopher Palmer, & Tyrone Moore
 * Last Edited: 11/12/2020
 */
public class Property extends OwnableSpace {
    private int rentAmt;

    public Property(String name, int price, int rent) {
        super(name, price);
        setRentAmt(rent);
    }

    @Override
    public int rent(int diceRoll) {
        // TODO rent is doubled if a player has a monopoly (all lots in a color-group)
        Message.landedOnOwned_Owner(getOwner());
        Message.landedOnOwned_Rent(getRentAmt());
        return getRentAmt();
    }

    @Override
    public void displayMessage() {
        Message.landedOn(this.getName());
    }

    //**********ACCESSOR METHODS**********
    private int getRentAmt() {
        return rentAmt;
    }

    public void setRentAmt(int rentAmt) {
        this.rentAmt = rentAmt;
    }
}
