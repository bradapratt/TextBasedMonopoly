package com.game.monopoly;

public class FreeParking extends Space{
    private final int FREE_PARKING_MIN = 0;
    private int freeParking;

    public FreeParking(String name) {
        super(name);
        setFreeParking(0);
    }

    @Override
    public void displayMessage() {
    }

    /**
     * Adds current parking fund to player's wallet and resets fund to zero.
     * @param whoParked
     */
    public void collectFreeParking(Player whoParked){
    }

    public void addToFreeParking(int amount){
        freeParking += amount;
    }

    //**********ACCESSOR METHODS**********

    private int getFreeParking() {
        return freeParking;
    }

    private void setFreeParking(int freeParking) {
        this.freeParking = freeParking;
    }
}
