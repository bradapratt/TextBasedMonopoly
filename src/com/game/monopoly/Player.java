package com.game.monopoly;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

class Player {
    private final int FIRST_LOCATION = 0;
    private final int LAST_LOCATION = 37;
    private final int MIN_NUM_RAILROAD = 0;
    private final int MAX_NUM_RAILROAD = 4;
    private final int MIN_NUM_UTILITIES = 0;
    private final int MAX_NUM_UTILITIES = 2;
    private int wallet;
    private String name;
    private List<OwnableSpace> properties;
    private Piece gamePiece;
    private int location;
    private int number;
    private boolean isBankrupt;
    private boolean passedGo;
    private int numRailRoads;
    private int numUtilities;


    /**
     * Constructor: initial values, wallet = 1500, properties = {}, location = 0
     *
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
        setPassedGo(false);
        properties = new ArrayList<>();
    }

    /**
     * Get dice roll from game, move spaces (update location), return new location to game.
     */
    public int movePlayer(int diceRoll) {
        setPassedGo(false);     //reset flag to false
        setLocation(getLocation() + diceRoll);
        if (getLocation() > LAST_LOCATION) {
            setLocation(getLocation() - LAST_LOCATION - 1);

            if (getLocation() != 0) {    //set flag to true because you passed go but didn't land on it
                setPassedGo(true);
            }
        }
        return getLocation();
    }

    /**
     * Bought a new property, need add a copy to the property list for tracking.
     *
     * @param newProperty
     */
    public void addProperty(OwnableSpace newProperty) {
        properties.add(newProperty);
        setNumRailRoads();
        setNumUtilities();
    }

    /**
     * Sold or lost a property, need to remove it from property list.
     *
     * @param propertyName
     */
    public void removeProperty(String propertyName) {
        properties.remove(propertyName);
        setNumRailRoads();
        setNumUtilities();
    }

    /**
     * If current player owes money to the bank.
     * Sets bankrupt flag, empties wallet, sets all property ownership to null, and clears out
     * list of properties.
     */
    public void declareBankruptcy() {
        isBankrupt = true;
        setWallet(0);
        clearOwner();
        getProperties().clear();
    }

    /**
     * If current player owes money to another player.
     * Sets bankrupt flag, pays the debt holder the remainder of current player's wallet, transfers
     * property ownership, and then clears out list of properties.
     * @param debtHolder - person that current player owes money to (and can't pay full amount)
     */
    public void declareBankruptcy(Player debtHolder){
        isBankrupt = true;
        Bank.payRent(this, debtHolder, getWallet());
        transferOwner(debtHolder);
        getProperties().clear();
    }

    /**
     * Sets owner of all properties to null (no current owner)
     */
    private void clearOwner(){
        for (OwnableSpace property: properties){
            property.setOwned(false);
            property.setOwner(null);
        }
    }

    /**
     * Sets owner of all properties to the new owner (debt holder)
     * @param newOwner - person current player owes money to (and can't pay full amount)
     */
    private void transferOwner(Player newOwner){
        for (OwnableSpace property: properties){
            property.setOwner(newOwner);
        }
    }

    /**
     * Return property list to Game so they can reset owners/ transfer, before declaring bankruptcy.
     *
     * @return
     */
    private List<OwnableSpace> getProperties() {
        return properties;
    }

    //**********ACCESSOR METHODS**********
    public int getNumRailRoads() {
        return numRailRoads;
    }

    public int getNumUtilities() {
        return numUtilities;
    }

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

    public boolean isBankrupt() {
        return isBankrupt;
    }

    public boolean passedGo() {
        return passedGo;
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

    private void setNumber(int number) {
        this.number = number;
    }

    private void setBankrupt(boolean bankrupt) {
        isBankrupt = bankrupt;
    }

    private void setNumRailRoads() {
        int counter = 0;
        for (OwnableSpace rails : properties) {
            if (rails instanceof Railroad) {
                counter++;
            }
        }
        numRailRoads = counter;
    }

    private void setNumUtilities() {
        int counter = 0;
        for (OwnableSpace utils : properties) {
            if (utils instanceof Utility) {
                counter++;
            }
        }
        numUtilities = counter;
    }

    public void setPassedGo(boolean passedGo) {
        this.passedGo = passedGo;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj instanceof Player) {
            Player other = (Player) obj;
            result = this.getWallet() == other.getWallet() &&
                    this.getLocation() == other.getLocation() &&
                    this.getName().equals(other.getName()) &&
                    this.getGamePiece() == other.getGamePiece();
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWallet(), getName(), getGamePiece(), getLocation(), getNumber());
    }
}
