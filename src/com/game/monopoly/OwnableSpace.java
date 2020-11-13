package com.game.monopoly;

/**
 * OwnableSpace is an abstract class that defines the process of execution
 * for all spaces on a Monopoly board that can be owned by a player.
 *
 * Authors: Bradley Pratt, Christopher Palmer, & Tyrone Moore
 * Last Edited: 11/12/2020
 */
import com.apps.util.Prompter;
import java.util.Scanner;

public abstract class OwnableSpace extends Space {
    private Player owner;
    private int price;
    private boolean isOwned;
    private Prompter prompter;

    public OwnableSpace(String name, int price) {
        super(name);
        owner = null;
        setPrice(price);
        setOwned(false);
        prompter = new Prompter(new Scanner(System.in));
    }

    @Override
    public void execute(Player tenant, int diceRoll, Prompter input) {
        displayMessage();
        if (!this.isOwned()) {
            // ask player if they want to buy it
            Message.showPlayerBalance(tenant.getName(), tenant.getWallet());
            String buy = input.prompt(Message.promptBuyProperty(getPrice()), "Y|y|N|n", "Please enter Y or N.");
            switch (buy) {
                // try to buy property
                case "Y", "y" -> {
                    boolean paid = Bank.payForProperty(tenant, this.getPrice());
                    if (paid) {
                        this.setOwner(tenant);
                        this.setOwned(true);
                        tenant.addProperty(this);
                    } else {
                        // tell player they don't have enough money
                        Message.cantBuyProperty(this.getName(), this.getPrice(), tenant.getWallet());
                    }
                }
            }
        } else if (getOwner().getGamePiece() != tenant.getGamePiece()){
            Player owner = this.getOwner();
            int rent = this.rent(diceRoll);
            Bank.payRent(tenant, owner, rent);
        }else{
            System.out.println("You already own this property!");
        }
    }

    /**
     * Calculates the rent total owed to a player that owns an own-able space.
     *
     * @param diceRoll
     * @return
     */
    public abstract int rent(int diceRoll);

    /**
     * Sets the new owner name and returns the price.
     */
    public int buy(String name) {
        return 0;
    }

    //**********ACCESSOR METHODS**********
    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public int getPrice() {
        return price;
    }

    protected void setPrice(int price) {
        this.price = price;
    }

    public boolean isOwned() {
        return isOwned;
    }

    public void setOwned(boolean owned) {
        this.isOwned = owned;
    }

    public Prompter getPrompter() {
        return prompter;
    }
}
