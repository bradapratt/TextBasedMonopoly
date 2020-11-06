package com.game.monopoly;

public abstract class OwnableSpace extends Space{
    private String owner;
    private int price;

    public OwnableSpace(String name, int price){
        super(name);
        owner = "Bank";
        setPrice(price);
    }

    public abstract int rent();

    /**
     * Sets the new owner name and returns the price.
     */
    public int buy(String name){
        return 0;
    }

    //**********ACCESSOR METHODS**********
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getPrice() {
        return price;
    }

    protected void setPrice(int price) {
        this.price = price;
    }
}