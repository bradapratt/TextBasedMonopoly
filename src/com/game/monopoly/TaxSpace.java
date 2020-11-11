package com.game.monopoly;

import com.apps.util.Prompter;

public class TaxSpace extends Space{
    private int taxAmount;

    public TaxSpace(String name, int taxAmount) {
        super(name);
        this.taxAmount = taxAmount;
    }

    @Override
    public void execute(Player player, int diceRoll, Prompter input) {

    }

    @Override
    public void displayMessage() {
    }

    public int getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(int taxAmount) {
        this.taxAmount = taxAmount;
    }
}
