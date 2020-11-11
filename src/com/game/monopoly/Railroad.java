package com.game.monopoly;

public class Railroad extends OwnableSpace{
    public Railroad(String name, int price){
        super(name, price);
    }

    /**
     * Railroad rent amount is determined by the number of railroads (RR's) a player owns.
     * One owned - $25
     * Two owned - $50
     * Three owned - $100
     * Four owned - $200
     * @param player
     * @param context
     * @return
     */
    @Override
    public int rent(Player player, RentContext context) {
        int result = switch (context.getNumberOwned()) {
            case 1 -> 25;
            case 2 -> 50;
            case 3 -> 100;
            case 4 -> 200;

            default -> throw new IllegalStateException("Unexpected value: " + context.getNumberOwned());
        };
        return result;
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
                }
                else {
                    // tell player they don't have enough money
                }
            }
            else {
                // do nothing??
            }
        }
        else {
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
