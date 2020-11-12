package com.game.monopoly;
/**
 * * Player class creates the player and defines the player object.
 *
 * Authors: Bradley Pratt, Christopher Palmer, & Tyrone Moore
 *  Last Edited: 11/11/2020
 */

/**
 * Player simulates the individual players in the Monopoly text-based game. Stores values
 * such as their current cash reserve (wallet), their location on the board, their chosen
 * game piece, and the list of properties they own.
 *
 * Authors: Bradley Pratt, Christopher Palmer, & Tyrone Moore
 * Last Edited: 11/12/2020
 */
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
     * @param name - name of player
     * @param gamePiece - Their chosen piece
     * @param num - number assigned by Game
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

            //set flag to true because you passed go but didn't land on it
            if (getLocation() != 0) {
                setPassedGo(true);
            }
        }
        return getLocation();
    }

    /**
     * Adds new property purchased by player to the property list
     *
     * @param newProperty - new property that was purchased
     */
    public void addProperty(OwnableSpace newProperty) {
        properties.add(newProperty);
        setNumRailRoads();
        setNumUtilities();
    }

    /**
     * Removes a property that was sold from the property list.
     *
     * @param soldProperty - name of the property to be removed
     */
    public void removeProperty(OwnableSpace soldProperty) {
        properties.remove(soldProperty);
        setNumRailRoads();
        setNumUtilities();
    }

    /**
     * Sets bankrupt flag, empties wallet, sets all property ownership to null, and clears out
     * list of properties (If current player owes money to the bank).
     */
    public void declareBankruptcy() {
        Message.playerWentBankrupt(getName());
        isBankrupt = true;
        setWallet(0);
        clearOwner();
        getProperties().clear();
    }

    /**
     * Sets bankrupt flag, pays the debt holder the remainder of current player's wallet, transfers
     * property ownership, and then clears out list of properties (If current player owes money to
     * another player).
     *
     * @param debtHolder - person that current player owes money to (and can't pay full amount)
     */
    public void declareBankruptcy(Player debtHolder){
        Message.playerWentBankruptToAnother(getName(), debtHolder.getName());
        isBankrupt = true;
        Bank.payRent(this, debtHolder, getWallet());
        transferOwner(debtHolder);
        getProperties().clear();
    }

    /**
     * Sets owner of all properties to null (no current owner)
     */
    public void clearOwner(){
        for (OwnableSpace property: properties){
            property.setOwned(false);
            property.setOwner(null);
        }
    }

    /**
     * Sets owner of all properties to the new owner (debt holder)
     * @param newOwner - person current player owes money to (and can't pay full amount)
     */
    public void transferOwner(Player newOwner){
        for (OwnableSpace property: properties){
            property.setOwner(newOwner);
            newOwner.addProperty(property);
        }
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

    public int getLocation() {
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

    public List<OwnableSpace> getProperties() {
        return properties;
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

    public void setLocation(int location) {
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

        if (numRailRoads >= MIN_NUM_RAILROAD && numRailRoads <= MAX_NUM_RAILROAD){
            numRailRoads = counter;
        }else{
            System.out.println("Invalid number of railroads.");
        }
    }

    private void setNumUtilities() {
        int counter = 0;
        for (OwnableSpace utils : properties) {
            if (utils instanceof Utility) {
                counter++;
            }
        }

        if (numUtilities >= MIN_NUM_UTILITIES && numUtilities <= MAX_NUM_UTILITIES){
            numUtilities = counter;
        }else{
            System.out.println("Invalid number of utilities.");
        }
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
