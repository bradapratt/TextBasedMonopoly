package com.game.monopoly;

public class Property extends OwnableSpace {
    private int rentAmt;

    public Property(String name, int price, int rent) {
        super(name, price);
        setRentAmt(rent);
    }

    @Override
    public int rent(Player player, RentContext context) {
        // TODO rent is doubled if a player has a monopoly (all lots in a color-group)
        return getRentAmt();
    }

    @Override
    public void execute(Player tenant, int diceRoll) {
        if (!this.isOwned()) {
            // ask player if they want to buy it
            if (true) {
                // try to buy property
                boolean paid = Bank.payForProperty(tenant, this.getPrice());
                if (paid) {
                    this.setOwner(tenant);
                } else {
                    // tell player they don't have enough money
                }
            } else {
                // do nothing??
            }
        } else {
            Player owner = this.getOwner();
            RentContext ctx = new RentContext();
//            ctx.setDiceRoll(diceRoll);
//            ctx.setNumberOwned(owner);
            boolean paid = Bank.payRent(tenant, owner, this.rent(owner, ctx));
        }
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
