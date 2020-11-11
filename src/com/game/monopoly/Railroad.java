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
    public void execute(Player tenant, int diceRoll, Prompter input) {
        if (!this.isOwned()) {
            // ask player if they want to buy it
            String buy = input.prompt("Would you like to buy this property? " +
                    "(Y/N)", "Y|y|N|n", "Please enter Y or N.");
            switch (buy) {
                // try to buy property
                case "Y", "y" -> {
                    boolean paid = Bank.payForProperty(tenant, this.getPrice());
                    if (paid) {
                        this.setOwner(tenant);
                        this.setOwned(true);
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
            boolean paid = Bank.payRent(tenant, owner, this.rent(owner, diceRoll));
        }
    }

    @Override
    public void displayMessage() {
    }
}
