package com.game.monopoly;

import com.apps.util.Prompter;

import java.io.IOException;
import java.util.*;

public class Game {
    private final static int MIN_ROUNDS = 3;    //minimum # of rounds needed to play
    private final static int MIN_PLAYERS = 2;   //minimum # of players needed to play
    private final static int MAX_PLAYERS = 8;   //maximum # of players possible

    private List<Player> playerList;
    private List<Space> board;
    private List<Player> currentRankings;
    private Stack<Player> finalRankings;
    private int numRounds;
    private int currentRound;
    private int numPlayers;

    private Prompter p1;


    /**
     * Initialize the board;
     */
    public Game() {
        p1 = new Prompter(new Scanner(System.in));
        board = new ArrayList<>();

        //load up the board
        board.add(new Go("Go"));                                            //0
        board.add(new Property("Mediterranean Avenue", 60, 2));   //1
        board.add(new CommunityChest("Community Chest"));                   //2
        board.add(new Property("Baltic Avenue", 60, 4));          //3
        board.add(new TaxSpace("Income Tax", 200));                //4
        board.add(new Railroad("Reading Railroad", 200));              //5
        board.add(new Property("Oriental Avenue", 100, 6));       //6
        board.add(new Chance("Chance"));                                    //7
        board.add(new Property("Vermont Avenue", 100, 6));        //8
        board.add(new Property("Connecticut Avenue", 120, 8));    //9
        //***"Jail" Would Go Here***
        board.add(new Property("St. Charles Place", 140, 10));    //10
        board.add(new Utility("Electric Company", 150));               //11
        board.add(new Property("States Avenue", 140, 10));        //12
        board.add(new Property("Virginia Avenue", 160, 12));      //13
        board.add(new Railroad("Pennsylvania Railroad", 200));         //14
        board.add(new Property("St. James Place", 180, 14));      //15
        board.add(new CommunityChest("Community Chest"));                   //16
        board.add(new Property("Tennessee", 180, 14));            //17
        board.add(new Property("New York Avenue", 200, 16));      //18
        board.add(new FreeParking("Free Parking"));                         //19
        board.add(new Property("Kentucky Avenue", 220, 18));      //20
        board.add(new Chance("Chance"));                                    //21
        board.add(new Property("Indiana Avenue", 220, 18));       //22
        board.add(new Property("Illinois Avenue", 240, 20));      //23
        board.add(new Railroad("B. & O. Railroad", 200));              //24
        board.add(new Property("Atlantic Avenue", 260, 22));      //25
        board.add(new Property("Ventnor Avenue", 260, 22));       //26
        board.add(new Utility("Water Works", 150));                    //27
        board.add(new Property("Marvin Gardens", 280, 24));       //28
        //***"Go To Jail" Would Go Here
        board.add(new Property("Pacific Avenue", 300, 26));       //29
        board.add(new Property("North Carolina Avenue", 300, 26));//30
        board.add(new CommunityChest("Community Chest"));                   //31
        board.add(new Property("Pennsylvania Avenue", 320, 28));  //32
        board.add(new Railroad("Short Line", 200));                    //33
        board.add(new Chance("Chance"));                                    //34
        board.add(new Property("Park Place", 350, 35));           //35
        board.add(new TaxSpace("Luxury Tax", 75));                 //36
        board.add(new Property("Boardwalk", 400, 50));            //37
    }

    /**
     * Send welcome message to console, prompt players for info, set values, etc.
     */
    public void startGame() throws IOException {
        Message.banner();
        Message.welcome();
        inputNumPlayers();
        inputNumRounds();
        initializePlayers();
    }

    /**
     * Prompts user for the number of players and sets.
     */
    private void inputNumPlayers(){
        boolean isNotValid = true;
        int num = 0;

        while (isNotValid){
            String numP = p1.prompt("Please enter number of players, up to 8: ", "\\d", Message.invalidNumber());
            num = Integer.parseInt(numP);
            if (num < 2 || num > 8){
                System.out.println("Number of players must be between 2 and 8. Please try again.");
            }else{
                isNotValid = false;
            }
        }
        setNumPlayers(num);
    }

    /**
     * Prompts user for the number of rounds to be played and sets.
     */
    private void inputNumRounds(){
        boolean isNotValid = true;
        int num = 0;

        while (isNotValid){
            String numR = p1.prompt("Please enter number of desired rounds: ", "\\d+", Message.invalidNumber());
            num = Integer.parseInt(numR);
            if (num <= 0){
                System.out.println("Number of rounds must be greater than 0. Please try again.");
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
    private void initializePlayers(){
        playerList = new ArrayList<>();
        List<String> available = Piece.classToString();

        for (int i = 1; i <= numPlayers; i++){
            String name = p1.prompt("Enter the name for Player" + i + ": ");
            boolean notValidPiece = true;
            while (notValidPiece) {
                String piece = p1.prompt(Message.choosePiece(available));
                if (available.contains(piece)) {
                    Piece piece1 = Piece.valueOf(piece);
                    available.remove(piece);
                    Player current = new Player(name, piece1);
                    playerList.add(current);
                    notValidPiece = false;
                }else{
                    System.out.println(Message.invalidPiece());
                }
            }
        }
    }

    /**
     * Game will begin each round, and rotate through players' turns.
     */
    private void startRound(){
        //for each Player: rollDice() x2, Player.takeTurn()
    }

    /**
     * Game will end the round, display current rankings, notify #of rounds left, decrement round count.
     */
    private void endRound(){
    }

    /**
     * Wrap up the game, display winners, ask players if they want to start another game.
     */
    private void endGame(){
    }

    private int getNumRounds(){
        return numRounds;
    }

    private int getNumPlayers(){
        return numPlayers;
    }

    private int getCurrentRound(){ return currentRound; }

    private void setNumRounds(int numRounds) {
        this.numRounds = numRounds;
    }

    private void setCurrentRound(int currentRound) {
        this.currentRound = currentRound;
    }

    private void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    /**
     * Accessory method for checking number rounds that are left.
     * @return
     */
    private int checkRoundCount(){
        return getNumRounds() - getCurrentRound();
    }

    /**
     * Displays current winner/rankings to console.
     */
    private void displayCurrentRankings(){
        currentRankings = new ArrayList<>(playerList);
        Collections.sort(currentRankings);

        Message.displayCurrentRankings(currentRankings);
    }

    /**
     * Returns the roll for one six-sided die.
     * @return
     */
    private int rollDice(){
        return Dice.rollDice();
    }
}
