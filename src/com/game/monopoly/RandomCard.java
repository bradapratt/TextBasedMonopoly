package com.game.monopoly;

/**
 * Abstract class that extends the Space class and declares a method drawCard() for random event
 * spaces such as Chance and Community Chest on a monopoly board.
 *
 * Authors: Bradley Pratt, Christopher Palmer, & Tyrone Moore
 * Last Edited: 11/10/2020
 */
public abstract class RandomCard extends Space{
    public RandomCard(String name) {
        super(name);
    }

    /**
     * Generate random int to choose a "card" and take actions of that card.
     */
    public abstract void drawCard(Player player, int diceRoll);
}
