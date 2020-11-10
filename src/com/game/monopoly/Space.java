package com.game.monopoly;

public abstract class Space {
    private String name;

    public Space(String name){
        this.name = name;
    }

    public abstract void execute(Player player, int diceRoll);
    public abstract void displayMessage();

    //**********ACCESSOR METHODS**********
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
