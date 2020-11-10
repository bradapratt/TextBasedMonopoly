package com.game.monopoly;

public abstract class OwnableSpace extends Space{
    private String owner;
    private int price;
    boolean owned = false;

    public OwnableSpace(String name, int price){
        super(name);
        owner = "Bank";
        setPrice(price);
    }

    /**
     * Calculates the rent total owed to a player that owns an own-able space.
     * @param player
     * @param context
     * @return
     */
    public abstract int rent(Player player, RentContext context);

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

    public boolean isOwned() {
        return owned;
    }

    public void setOwned(boolean owned) {
        this.owned = owned;
    }
}
