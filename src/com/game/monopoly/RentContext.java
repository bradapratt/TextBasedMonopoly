package com.game.monopoly;

class RentContext {
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
