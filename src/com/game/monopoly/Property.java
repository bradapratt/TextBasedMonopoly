package com.game.monopoly;

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
