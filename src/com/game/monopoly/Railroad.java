package com.game.monopoly;

public class Railroad extends OwnableSpace{
    public Railroad(String name, int price){
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
