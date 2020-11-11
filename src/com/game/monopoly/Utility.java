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
     * @param owner
     * @param context
     * @return
     */
    @Override
    public int rent(Player owner, RentContext context) {
        int diceTotal = context.getDiceRoll();
        int result = switch (context.getNumberOwned()) {
            case 1 -> 4 * diceTotal;
            case 2 -> 10 * diceTotal;

            default -> throw new IllegalStateException("Unexpected value: " + context.getDiceRoll());
        };
        return result;
    }

    @Override
    public void execute(Player tenant, int diceRoll) {
        if (!this.isOwned()) {
            // ask player if they want to buy it
            String buy = getPrompter().prompt("Would you like to buy this property? " +
                    "(Y/N)", "Y|y|N|n", "Please enter Y or N.");
            switch (buy) {
                // try to buy property
                case "Y", "y" -> {
                    boolean paid = Bank.payForProperty(tenant, this.getPrice());
                    if (paid) {
                        this.setOwner(tenant);
                    } else {
                        // tell player they don't have enough money
                        Message.cantBuyProperty(this.getName(), this.getPrice(), tenant.getWallet());
                    }
                }
                // TODO should we do something here?
                case "N", "n" -> {

                }
            }
        } else {
            Player owner = this.getOwner();
            RentContext ctx = new RentContext();
            ctx.setDiceRoll(diceRoll);
            ctx.setNumberOwned(owner.getNumRailRoads());
            boolean paid = Bank.payRent(tenant, owner, this.rent(owner, ctx));
        }
    }

    @Override
    public void displayMessage() {
    }
}
