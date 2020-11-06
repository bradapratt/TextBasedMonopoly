package com.game.monopoly;

public class Go extends Space{
    private static final int go = 200;

    public Go(String name) {
        super(name);
    }

    @Override
    public void displayMessage() {
    }

    /**
     * Pays player $200
     * @param passedGo
     */
    public void collectGo(Player passedGo){
    }
}