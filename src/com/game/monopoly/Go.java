package com.game.monopoly;

/**
 * Class Go represents the "Go" space on a Monopoly board.
 *
 * Authors: Bradley Pratt, Christopher Palmer, & Tyrone Moore
 * Last Edited: 11/10/2020
 */
import com.apps.util.Prompter;

public class Go extends Space{
    private static final int GO = 200;

    public Go() {
        super("Go");
    }

    /**
     * Execute actions taken when landing on this space.
     * @param player - current player
     * @param diceRoll - current player's dice roll total
     */
    @Override
    public void execute(Player player, int diceRoll, Prompter input) {
        displayMessage();
        collectGo(player);
    }

    /**
     * Inform player they landed on the space.
     */
    @Override
    public void displayMessage() {
        Message.landedGo();
    }

    /**
     * Pays player $200
     * @param passedGo - the player who passed Go
     */
    private void collectGo(Player passedGo){
        Bank.pay(passedGo, GO);
    }
}
