package com.game.monopoly;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class Player implements Comparable<Player> {
    private final int FIRST_LOCATION = 0;
    private final int LAST_LOCATION = 37;
    private final int MIN_NUM_RAILROAD = 1;
    private final int MAX_NUM_RAILROAD = 4;
    private final int MIN_NUM_UTILITIES = 1;
    private final int MAX_NUM_UTILITIES = 2;
    private int wallet;
    private String name;
    private List<Property> properties;
    private Piece gamePiece;
    private int location;
    private int number;
    private boolean isBankrupt;
    private int numRailRoads;
    private int numUtilities;



    /**
     * Constructor: initial values, wallet = 1500, properties = {}, location = 0
     * @param name
     * @param gamePiece
     */
    public Player(String name, Piece gamePiece, int num) {
        setName(name);
        setGamePiece(gamePiece);
        setNumber(num);
        setLocation(FIRST_LOCATION);
        setWallet(1500);
        setBankrupt(false);
        properties = new ArrayList<>();
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
    public void addProperty(Property copyOfNewProperty){
       properties.add(copyOfNewProperty);
       getNumRailRoads();
       getNumUtilities();
    }

    /**
     * Sold or lost a property, need to remove it from property list.
     * @param propertyName
     */
    public void removeProperty(String propertyName){
        properties.remove(propertyName);
        getNumRailRoads();
        getNumUtilities();
    }

    /**
     * Save wallet amount to local var (and return), then set wallet to zero, clear property list.
     */
    public int declareBankruptcy(){
        int balance = getWallet();
        setWallet(0);
        properties.clear();
        return balance;
    }

    /**
     * Return property list to Game so they can reset owners/ transfer, before declaring bankruptcy.
     * @return
     */
    public List<Property> getProperties(){
        return properties;
    }

    /**
     * create getNumRailRoads and getNumUtilities
     */
    public int getNumRailRoads(){
        for(Property railroads : properties) {
            if (numRailRoads >= MIN_NUM_RAILROAD  || numRailRoads <= MAX_NUM_RAILROAD ) ;
        }
        return numRailRoads;
    }

    public int getNumUtilities(){
        for(Property utilities : properties) {
            if (numUtilities >= MIN_NUM_UTILITIES || numUtilities <= MAX_NUM_UTILITIES) ;
        }
            return numUtilities;
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

    public int getNumber() {
        return number;
    }

    public boolean isBankrupt() { return isBankrupt; }

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

    private void setNumber(int number) {
        this.number = number;
    }

    public void setBankrupt(boolean bankrupt) {
        isBankrupt = bankrupt;
    }

    public int compareTo(Player other) {
        return this.getWallet() - other.getWallet();
    }
}
