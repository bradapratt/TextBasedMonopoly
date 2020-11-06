package com.game.monopoly;

public class Utility extends OwnableSpace{
    public Utility(String name, int price){
        super(name, price);
    }

    @Override
    public int rent() {
        return 0;
    }

    @Override
    public void displayMessage() {
    }
}
