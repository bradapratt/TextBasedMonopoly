package com.game.monopoly;

import com.apps.util.Prompter;

/**
 * Class CommunityChest represents the Community Chest space on a Monopoly Board.
 *
 * Authors: Bradley Pratt, Christopher Palmer, & Tyrone Moore
 * Last Edited: 11/10/2020
 */
public class CommunityChest extends RandomCard{
    public CommunityChest() {
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
        Message.landedCommunityChest();
    }

    /**
     * Generate random int to choose a "card" and take actions of that card.
     */
    public void drawCard(Player player, int diceRoll){
        //TODO: Use a switch statement to pick a random card
    }
}
