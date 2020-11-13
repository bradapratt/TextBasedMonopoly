package com.game.monopoly;

/**
 * Abstract class that sets the framework for all descendants that represent the various
 * game spaces on a Monopoly board.
 * <p>
 * Authors: Bradley Pratt, Christopher Palmer, & Tyrone Moore
 * Last Edited: 11/11/2020
 */

import com.apps.util.Prompter;

public abstract class Space {
    private String name;

    public Space(String name) {
        this.name = name;
    }

    /**
     * Execute the sequence of actions necessary for the player to interact with that particular space.
     * @param player - current player who "landed" on space
     * @param diceRoll - their dice roll (won't be used by all descendants)
     * @param input - a prompter input for testing purposes
     */
    public abstract void execute(Player player, int diceRoll, Prompter input);

    public abstract void displayMessage();

    //**********ACCESSOR METHODS**********
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
