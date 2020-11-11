package com.game.monopoly;

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

    protected class RentContext {
        private int diceRoll = 0;
        private int numberOwned = 0;

        public int getDiceRoll() {
            return diceRoll;
        }

        public void setDiceRoll(int diceRoll) {
            // TODO call method to get rolled dice total and set diceRoll
            this.diceRoll = diceRoll;
        }

        public int getNumberOwned() {
            return numberOwned;
        }

        public void setNumberOwned(int numberOwned) {
            // TODO call method to get number of specific (group of) properties owned by a player and set numberOwned
            this.numberOwned = numberOwned;
        }
    }

    /**
     * Calculates the rent total owed to a player that owns an own-able space.
     *
     * @param owner
     * @param context
     * @return
     */
    public abstract int rent(Player owner, RentContext context);

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
