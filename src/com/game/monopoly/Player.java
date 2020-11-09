package com.game.monopoly;

import java.util.Collection;
import java.util.List;

class Player implements Comparable<Player> {
    private  final int FIRST_LOCATION = 0;
    private  final int LAST_LOCATION = 37;
    private int wallet;
    private String name;
    private List<Property> properties;
    private Piece gamePiece;
    private int location;


    /**
     * Constructor: initial values, wallet = 1500, properties = {}, location = 0
     * @param name
     * @param gamePiece
     */
    public Player(String name, Piece gamePiece, int wallet) {
        this.name = name;
        this.gamePiece = gamePiece;
        setWallet(1500);
    }

    /**
     * Get dice roll from game, move spaces (update location), return new location to game.
     */
    public int movePlayer(int diceRoll){
        setLocation(getLocation() + diceRoll);
        if (getLocation() > LAST_LOCATION){
            setLocation(getLocation() - LAST_LOCATION - 1);
        }
        return getLocation();
    }

    /**
     * Bought a new property, need add a copy to the property list for tracking.
     * @param copyOfNewProperty
     */
    private void addProperty(Property copyOfNewProperty){
       properties.add(copyOfNewProperty);
    }

    /**
     * Sold or lost a property, need to remove it from property list.
     * @param propertyName
     */
    private void removeProperty(String propertyName){
        properties.remove(propertyName);
    }

    /**
     * Save wallet amount to local var (and return), then set wallet to zero, clear property list.
     */
    private int declareBankruptcy(){
        return 0;
    }

    /**
     * Return property list to Game so they can reset owners/ transfer, before declaring bankruptcy.
     * @return
     */
    public List<Property> getProperties(){
        return null;
    }

    //**********ACCESSOR METHODS**********

    public int getWallet() {    //Game class needs access to this
        return wallet;
    }

    public String getName() {   //Game class needs access to this
        return name;
    }

    public Piece getGamePiece() {   //Game class needs access to this
        return gamePiece;
    }

    private int getLocation() {
        return location;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setGamePiece(Piece gamePiece) {
        this.gamePiece = gamePiece;
    }

    private void setLocation(int location) {
        this.location = location;
    }
    public int compareTo(Player other) {
        return this.getWallet() - other.getWallet();
    }
}
