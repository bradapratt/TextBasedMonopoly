package com.game.monopoly;

public abstract class RandomCard extends Space{
    public RandomCard(String name) {
        super(name);
    }

    /**
     * Generate random int to choose a "card" (possibly use a switch statement) and
     * take actions of that card.
     */
    public abstract void drawCard();
}
