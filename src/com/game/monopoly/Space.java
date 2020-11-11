package com.game.monopoly;

import com.apps.util.Prompter;

public abstract class Space {
    private String name;

    public Space(String name){
        this.name = name;
    }

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
