package com.game.monopoly;

/**
 * Game class is the controller for a text-based Monopoly board game. It manages all other classes
 * according to the game rules. It also communicates directly with the players and prompts them
 * for input.
 *
 * Authors: Bradley Pratt, Christopher Palmer, & Tyrone Moore
 * Last Edited: 11/11/2020
 */
import com.apps.util.Prompter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Game {
    private final static int MIN_ROUNDS = 1;    //minimum # of rounds needed to play
    private final static int MIN_PLAYERS = 2;   //minimum # of players needed to play
    private final static int MAX_PLAYERS = 8;   //maximum # of players possible
    private final Prompter P1;
    private final List<Space> BOARD;

    private List<Player> playerList;
    private Stack<Player> bankruptcies;
    private int numRounds;
    private int currentRound;
    private int numPlayers;
    private boolean lastPlayerStanding;
    private boolean wantsToPlayAgain;



    /**
     * Initialize the board.
     */
    public Game() {
        setLastPlayerStanding(false);
        setWantsToPlayAgain(false);
        P1 = new Prompter(new Scanner(System.in));
        playerList = new ArrayList<>();
        bankruptcies = new Stack<>();
        BOARD = new ArrayList<>();

        //load up the board
        BOARD.add(new Go());                                                      //0
        BOARD.add(new Property("Mediterranean Avenue", 60, 2));   //1
        BOARD.add(new CommunityChest());                                          //2
        BOARD.add(new Property("Baltic Avenue", 60, 4));          //3
        BOARD.add(new TaxSpace("Income Tax", 200));                //4
        BOARD.add(new Railroad("Reading Railroad", 200));              //5
        BOARD.add(new Property("Oriental Avenue", 100, 6));       //6
        BOARD.add(new Chance());                                                  //7
        BOARD.add(new Property("Vermont Avenue", 100, 6));        //8
        BOARD.add(new Property("Connecticut Avenue", 120, 8));    //9
        //***"Jail" Would Go Here***
        BOARD.add(new Property("St. Charles Place", 140, 10));    //10
        BOARD.add(new Utility("Electric Company", 150));               //11
        BOARD.add(new Property("States Avenue", 140, 10));        //12
        BOARD.add(new Property("Virginia Avenue", 160, 12));      //13
        BOARD.add(new Railroad("Pennsylvania Railroad", 200));         //14
        BOARD.add(new Property("St. James Place", 180, 14));      //15
        BOARD.add(new CommunityChest());                                          //16
        BOARD.add(new Property("Tennessee", 180, 14));            //17
        BOARD.add(new Property("New York Avenue", 200, 16));      //18
        BOARD.add(new FreeParking());                                             //19
        BOARD.add(new Property("Kentucky Avenue", 220, 18));      //20
        BOARD.add(new Chance());                                                  //21
        BOARD.add(new Property("Indiana Avenue", 220, 18));       //22
        BOARD.add(new Property("Illinois Avenue", 240, 20));      //23
        BOARD.add(new Railroad("B. & O. Railroad", 200));              //24
        BOARD.add(new Property("Atlantic Avenue", 260, 22));      //25
        BOARD.add(new Property("Ventnor Avenue", 260, 22));       //26
        BOARD.add(new Utility("Water Works", 150));                    //27
        BOARD.add(new Property("Marvin Gardens", 280, 24));       //28
        //***"Go To Jail" Would Go Here
        BOARD.add(new Property("Pacific Avenue", 300, 26));       //29
        BOARD.add(new Property("North Carolina Avenue", 300, 26));//30
        BOARD.add(new CommunityChest());                                          //31
        BOARD.add(new Property("Pennsylvania Avenue", 320, 28));  //32
        BOARD.add(new Railroad("Short Line", 200));                    //33
        BOARD.add(new Chance());                                                  //34
        BOARD.add(new Property("Park Place", 350, 35));           //35
        BOARD.add(new TaxSpace("Luxury Tax", 75));                 //36
        BOARD.add(new Property("Boardwalk", 400, 50));            //37
    }

    /**
     * Send welcome message to console, sends welcome message, runs game iterations.
     */
    public void startGame() throws IOException {
        Message.banner("banner.txt", "data");
        Message.welcome();
        pause(1000);

        do {
            initializeGame();
            endGame();
            playAgain(P1);
        }while (wantsToPlayAgain());
    }

    /**
     * Initializes game values such as number of rounds and players, and executes rounds.
     */
    private void initializeGame(){
        inputNumPlayers(P1);
        inputNumRounds(P1);
        initializePlayers(P1);

        while (checkRoundCount() > 0 && !isLastPlayerStanding()){
            setCurrentRound(getCurrentRound()+1);
            startRound();
            endRound();
        }
    }

    /**
     * Prompts user for the number of players and sets.
     */
    private void inputNumPlayers(Prompter input){
        String numP = input.prompt("Please enter number of players, up to 8: ", "[2-8]", Message.invalidNumPlayers());
        int num = Integer.parseInt(numP);

        setNumPlayers(num);
    }

    /**
     * Prompts user for the number of rounds to be played and sets.
     */
    private void inputNumRounds(Prompter input){
        boolean isNotValid = true;
        int num = 1;

        while (isNotValid){
            String numR = input.prompt("Please enter number of desired rounds: ", "\\d{1,4}+", Message.invalidNumRounds());
            num = Integer.parseInt(numR);

            if (num < 1){
                System.out.println(Message.invalidNumRounds());
            }else{
                isNotValid = false;
            }
        }

        setNumRounds(num);
        setCurrentRound(0);
    }

    /**
     * Create the player objects and initialize all their values.
     */
    private void initializePlayers(Prompter input){
        List<String> available = Piece.classToString();

        for (int i = 1; i <= getNumPlayers(); i++){
            String name = input.prompt("Enter the name for Player" + i + ": ");
            boolean notValidPiece = true;
            while (notValidPiece) {
                String piece = input.prompt(Message.choosePiece(available));
                if (available.contains(piece)) {
                    Piece piece1 = Piece.valueOf(piece);
                    available.remove(piece);
                    Player current = new Player(name, piece1, i);
                    playerList.add(current);
                    notValidPiece = false;
                }else{
                    Message.invalidPiece();
                }
            }
        }
    }

    /**
     * Game will begin each round, and rotate through players' turns.
     */
    private void startRound(){
        //for each Player: rollDice() x2, takeTurn
        Message.displayRoundCount(getCurrentRound());
        pause(3000);

        for (Player player: playerList){
            int roll1 = rollDice();
            int roll2 = rollDice();
            Message.playerTurn(player, roll1, roll2);
            int newLoc = player.movePlayer((roll1 + roll2));

            passGo(player);
            BOARD.get(newLoc).execute(player, (roll1 + roll2), P1); //land on new space
            System.out.println();
            checkBankruptcy(player);

            if (playerList.size() == 1){
                setLastPlayerStanding(true);
                break;
            }
            pause(3000);
        }
    }

    /**
     * Checks if player is bankrupt and moves them to the bankruptcy list so they are no longer
     * in rotation.
     * @param player - current player
     */
    private void checkBankruptcy(Player player) {
        if (player.isBankrupt()){
            bankruptcies.push(player);
            playerList.remove(player);
        }
    }

    /**
     * Pays player for simply passing the "Go" space
     * @param player - current player
     */
    private void passGo(Player player) {
        if (player.passedGo()) {    //if player passes go, collect $200 BEFORE landing on new space
            Message.passGo();
            Bank.pay(player, 200);
        }
    }

    /**
     * Game will end the round, display current rankings, notify #of rounds left
     */
    private void endRound(){
        Message.endOfRound(getCurrentRound());
        displayCurrentRankings();
        Message.remainingRounds(checkRoundCount());
        pause(3000);
    }

    /**
     * Wrap up the game, display winners, ask players if they want to start another game.
     */
    private void endGame() throws IOException {
        Message.gameOver("endgame.txt", "data");
        List<Player> finalRankings = playerList.stream()
                .sorted(Comparator.comparing(Player::getWallet).reversed())
                .collect(Collectors.toList());

        if (isLastPlayerStanding()){
            Message.endGame_lastPlayer(playerList.get(0));
        }else{
            Message.endGame_lastRound(playerList.get(0));
        }

        while(!bankruptcies.isEmpty()){
            finalRankings.add(bankruptcies.pop());
        }
        Message.displayFinalRankings(finalRankings);
        pause(3000);
    }

    /**
     * Prompts the player if they want to play again and updates the boolean var
     */
    private void playAgain(Prompter input){
        String again = input.prompt("Would you like to play again? (Y/N) ", "Y|y|N|n", "Please enter Y or N.");
        switch (again){
            case "Y": case "y":
                setWantsToPlayAgain(true);
                Message.playAgain();
                break;
            case "N": case "n":
                setWantsToPlayAgain(false);
                Message.dontPlayAgain();
                break;
        }
    }

    /**
     * Accessory method for checking number rounds that are left.
     * @return how close we are to the final round
     */
    private int checkRoundCount(){
        return getNumRounds() - getCurrentRound();
    }

    /**
     * Displays current winner/rankings to console.
     */
    private void displayCurrentRankings(){
        List<Player> currentRankings = playerList.stream()
                .sorted(Comparator.comparing(Player::getWallet).reversed())
                .collect(Collectors.toList());

        Message.displayCurrentRankings(currentRankings);
    }

    /**
     * Returns the roll for one six-sided die.
     * @return the dice roll (1-6)
     */
    private int rollDice(){
        return Dice.rollDice();
    }

    /**
     * Pauses program for a period of time passed in. Improves readability for players.
     * @param pauseTime - amount of time to be paused, in milliseconds
     */
    private void pause(int pauseTime){
        try{
            Thread.sleep(pauseTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    //***************ACCESSOR METHODS***************
    private int getNumRounds(){
        return numRounds;
    }

    private int getNumPlayers(){
        return numPlayers;
    }

    private int getCurrentRound(){ return currentRound; }

    private boolean isLastPlayerStanding() {
        return lastPlayerStanding;
    }

    private boolean wantsToPlayAgain() {
        return wantsToPlayAgain;
    }

    private List<Player> getPlayerList() {
        return playerList;
    }

    private Stack<Player> getBankruptcies() {
        return bankruptcies;
    }

    private void setNumRounds(int numRounds) {
        this.numRounds = numRounds;
    }

    private void setCurrentRound(int currentRound) {
        this.currentRound = currentRound;
    }

    private void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    private void setLastPlayerStanding(boolean lastPlayerStanding) {
        this.lastPlayerStanding = lastPlayerStanding;
    }

    private void setWantsToPlayAgain(boolean wantsToPlayAgain) {
        this.wantsToPlayAgain = wantsToPlayAgain;
    }
}
