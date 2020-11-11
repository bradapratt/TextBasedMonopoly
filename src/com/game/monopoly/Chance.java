package com.game.monopoly;

import com.apps.util.Prompter;

/**
 * Class Chance represents the Chance space on a Monopoly board.
 *
 * Authors: Bradley Pratt, Christopher Palmer, & Tyrone Moore
 * Last Edited: 11/10/2020
 */
public class Chance extends RandomCard{
    public Chance() {
        super("Chance");
    }

    /**
     * Execute actions taken when landing on this space.
     * @param player - current player
     * @param diceRoll - current player's dice roll total
     */
    @Override
    public void execute(Player player, int diceRoll, Prompter input) {
        displayMessage();
        drawCard(player, diceRoll);
    }

    /**
     * Informs player they landed on Chance.
     */
    @Override
    public void displayMessage() {
        Message.landedChance();
    }

    /**
     * Generate random int to choose a "card" and take actions of that card.
     */
    public void drawCard(Player player, int diceRoll){
        //TODO: use switch statement to pick a card
    }
}
