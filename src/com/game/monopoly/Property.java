package com.game.monopoly;

import com.apps.util.Prompter;

public class Property extends OwnableSpace {
    private int rentAmt;

    public Property(String name, int price, int rent) {
        super(name, price);
        setRentAmt(rent);
    }

    @Override
    public int rent(Player player, int diceRoll) {
        // TODO rent is doubled if a player has a monopoly (all lots in a color-group)
        return getRentAmt();
    }

    @Override
    public void displayMessage() {
    }

    //**********ACCESSOR METHODS**********
    public int getRentAmt() {
        return rentAmt;
    }

    public void setRentAmt(int rentAmt) {
        this.rentAmt = rentAmt;
    }
}
