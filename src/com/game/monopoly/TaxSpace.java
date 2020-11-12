package com.game.monopoly;

/**
 * TaxSpace represents the two tax spaces on a Monopoly board, Income Tax and
 * Luxury Tax.
 *
 * Authors: Bradley Pratt, Christopher Palmer, & Tyrone Moore
 * Last Edited: 11/12/2020
 */
import com.apps.util.Prompter;

public class TaxSpace extends Space{
    private static final double TEN_PERCENT = 0.10;
    private int taxAmount;

    public TaxSpace(String name, int taxAmount) {
        super(name);
        this.taxAmount = taxAmount;
    }

    @Override
    public void execute(Player player, int diceRoll, Prompter input) {
        displayMessage();
        Message.oweTax(player, getTaxAmount());
        Bank.payIntoFreeParking(player, this.getTaxAmount());
    }

    @Override
    public void displayMessage() {
        Message.landedOn(this.getName());
    }

    public int getTaxAmount() {
        return taxAmount;
    }
}
