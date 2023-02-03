import java.util.ArrayList;
import java.util.Scanner;

/**
 * Mark Ghaby - 40201940
 * COMP249
 * Assignment #1
 * Due Date: Friday, February 3, 2023.
 * The LadderAndSnake class holds all necessary methods for the program to run correctly.
 * It contains a 2D array to represent the board.
 */
public class LadderAndSnake {

    // Creating scanner
    static Scanner input = new Scanner(System.in);

    /**
     * Board array used to know the location of ladders and snakes. The locations stored are the end points of said snakes or ladders.
     */
    private static int[][] board =
                            {{38 , 0 , 0 , 14 , 0 , 0 , 0 , 0 , 31 , 0},
                             {0 , 0 , 0 , 0 , 0 , 6 , 0 , 0 , 0 , 0},
                             {42 , 0 , 0 , 0 , 0 , 0 , 0 , 84, 0 , 0},
                             {0 , 0 , 0 , 0 , 0 , 44 , 0 , 0 , 0 , 0},
                             {0 , 0 , 0 , 0 , 0 , 0 , 0 , 30 , 0 , 0},
                             {67 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0},
                             {0 , 0 , 0 , 60 , 0 , 0 , 0 , 0 , 0 , 0},
                             {91 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 19 , 100},
                             {0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0},
                             {0 , 0 , 68 , 0 , 24 , 0 , 76 , 78 , 0 , 0}};

    /**
     * Create first player using default constructor from Player class.
     */
    private static Player player1 = new Player();

    /**
     * Create second player using default constructor from Player class.
     */
    private static Player player2 = new Player();
    /**
     * ArrayList to hold all players, which is then used to set player move order.
     */
    private static ArrayList<Player> playerList = new ArrayList<>(2);
    /**
     * Number of players.
     */
    private int numPlayers;

    /**
     * Default LadderAndSnake constructor which sets number of players to 2.
     */
    public LadderAndSnake(){
        numPlayers = 2;
    }

    /**
     * Parametrized LadderAndSnake constructor which allows the user to set number of players.
     * Since program can only run with 2 players, any input over 2 will print warning message, then set number of players to 2.
     * Any input under 2 will print error message and terminate the program.
     * @param numPlayers
     */
    public LadderAndSnake(int numPlayers){
        // Case if user inputs a number over 2.
        if(numPlayers > 2)
            // Warning message.
            System.out.println("Initialization was attempted for " + numPlayers + " players; however, " +
                            "this is only expected for an extended version the game. Value will be set to '2'");
        // Case is user inputs a number under 2.
        else if (numPlayers < 2) {
            // Error message.
            System.out.println("Error: Cannot execute the game with less than 2 players! Will exit");
            // Terminate the program
            System.exit(0);
        }
        // Set numPlayers to 2.
        this.numPlayers = 2;
    }

    /**
     * Method to flip the die.
     * @return value of the die flip
     */
    public static int flipDice(){
        // Math.random is used to return a random value between 0 and 0.99. This value is then manipulated to return a number between 1 and 6.
        return (int)(Math.random() * 6 + 1);
    }

    /**
     *  ChooseOrder method is used to choose the move order of the players. Each player is assigned a die value using the flipDice() method.
     *  Both values are then compared, and the player with the larger value is stored in the playerList ArrayList first, at index 0. Then the second player is stored at index 1.
     *  The method will loop if a tie is achieved, and print the amount of tries taken to find an order.
     */
    public void chooseOrder(){
        // Count is used to count the number of attempts to find a move order.
        int count = 1;
        // Loops until an order is chosen
        do {
            // Flipping the dice for both players and setting the value to diceValue.
            player1.setDiceValue(flipDice());
            player2.setDiceValue(flipDice());
            // Displaying both values.
            System.out.println(player1.getName() + " got a dice value of " + player1.getDiceValue());
            System.out.println(player2.getName() + " got a dice value of " + player2.getDiceValue());
            // The following if-else statement compares both diceValues. If player1 has a larger diceValue than player2, they will be sorted in the ArrayList first, and vice-versa.
            // Otherwise, increment count and restart the method, since a tie was achieved.
            if(player1.getDiceValue() > player2.getDiceValue()) {
                playerList.add(player1);
                playerList.add(player2);
                System.out.println("Reached the final decision on order of playing: " + playerList.get(0).getName() + " then "
                                    + playerList.get(1).getName() + ". It took " + count + " attempt(s) before a decision was made");
                System.out.println("");
            }
            else if(player2.getDiceValue() > player1.getDiceValue()){
                playerList.add(player2);
                playerList.add(player1);
                System.out.println("Reached the final decision on order of playing: " + playerList.get(0).getName() + " then "
                        + playerList.get(1).getName() + ". It took " + count + " attempt(s) before a decision was made.");
                System.out.println("");
            }
            else {
                System.out.println("A tie was achieved between both players. Attempting to break tie.");
                count++;
            }
        }while(player1.getDiceValue() == player2.getDiceValue());
    }

    /**
     * winCheck() checks if a player's position is 100.
     * @return ture is the position is 100, false otherwise.
     */
    public static boolean winCheck(){
        return player1.getPosition() == 100 || player2.getPosition() == 100;
    }

    /**
     * movePLayer() move the specified player by the diceValue set by flipDice().
     * If a player's position is above 100, they are sent back n squares, where n is the remainder of position - 100.
     * @param i is the index of the player we wish to move in playerList.
     */
    public static void movePlayer(int i){
        // Asks the user to press <enter> to roll the dice.
        System.out.println(playerList.get(i).getName() + "'s turn. Press <enter> to roll the dice.");
        String junk = input.nextLine();
        // Sets diceValue using the flipDice() method.
        playerList.get(i).setDiceValue(flipDice());
        // Adds diceValue to the player's current position.
        playerList.get(i).setPosition(playerList.get(i).getPosition() + playerList.get(i).getDiceValue());

        // The following if statement checks if the player's new position is above 100.
        // If it is, it will make the player move back by n squares, where n is the remainder of position - 100.
        if(playerList.get(i).getPosition() > 100){
            playerList.get(i).setPosition(100 - (playerList.get(i).getPosition() - 100) );
        }

        // Displays the diceValue of the players, as well as the new position.
        System.out.println("Got a dice value of " + playerList.get(i).getDiceValue() + "; moved to square " + playerList.get(i).getPosition());
        // Checks the player's location using locationCheck() method
        locationCheck(i);

        // Checks if the game is over using the winCheck() method.
        if(winCheck() == false)
            System.out.println("Game not over; flipping again");

        System.out.println("");

    }

    /**
     * locationCheck method compares the players location to the board array to find whether the player is on a snake or ladder, or a plain square.
     * It also checks whether another player is on the same square, and, if so, sends them back to the start.
     * @param i The index in playerList of the player whose location we wish to check.
     */
    public static void locationCheck(int i){
        // The following if statement checks if the player's position on the board array is a plain square (equal to 0).
        // If it is, it checks whether it's a snake or a ladder by comparing the player's position to the number stored to check whether it's a snake or a ladder.
        // If it's a snake, the stored location in the array should be smaller than the player location, and if it's a ladder, the stored location should be higher.
        // It then prints a complementary message, and sets the player's position to the position stored in the array.
        // If the player's position is a plain square, it simply goes to the next if statement.
        if(board[(playerList.get(i).getPosition() - 1) / 10][(playerList.get(i).getPosition() - 1) % 10] != 0) {
            if(board[(playerList.get(i).getPosition() - 1) / 10][(playerList.get(i).getPosition() - 1) % 10] < playerList.get(i).getPosition())
                System.out.println("Oh no! You landed on a snake. Drop to square " + board[(playerList.get(i).getPosition() - 1) / 10][(playerList.get(i).getPosition() - 1) % 10] + ".");
            else if(board[(playerList.get(i).getPosition() - 1) / 10][(playerList.get(i).getPosition() - 1) % 10] > playerList.get(i).getPosition())
                System.out.println("Hooray! You landed on a ladder. Move up to square " + board[(playerList.get(i).getPosition() - 1) / 10][(playerList.get(i).getPosition() - 1) % 10] + ".");

            playerList.get(i).setPosition(board[(playerList.get(i).getPosition() - 1) / 10][(playerList.get(i).getPosition() - 1) % 10]);
            locationCheck(i);
        }

        // This if statement checks whether the 2 players share the same square.
        // If they do, the player that was there first gets sent back to the beginning of the board.
        if(playerList.get(0).getPosition() == playerList.get(1).getPosition()){
            if(i == 0) {
                playerList.get(1).setPosition(0);
                System.out.println(playerList.get(1).getName() + " was already on this square. He will be kicked out of the board. Back to 0!");
            }
            if(i == 1) {
                playerList.get(0).setPosition(0);
                System.out.println(playerList.get(0).getName() + " was already on this square. He will be kicked out of the board. Back to 0!");
            }

        }

    }

    /**
     * The play() method is the method that runs the whole game. It uses all previous methods to allow the game to work.
     * It runs until a player reaches position 100.
     * @param numPlayersInput is the amount of players the user inputs.
     */
    public static void play(int numPlayersInput){
        // Creating a LadderAndSnake object using numPlayersInput
        LadderAndSnake game1 = new LadderAndSnake(numPlayersInput);

        // Getting player names from the user and storing them.
        String name1 , name2;
        System.out.print("\nPlease enter the names for both players, seperated by a space: ");
        name1 = input.next();
        name2 = input.next();

        player1.setName(name1);
        player2.setName(name2);

        // Welcomes both players by their names and begins the game.
        System.out.println("\nWelcome " + player1.getName() + " and " + player2.getName() + ", we will now choose the order of play:");
        game1.chooseOrder();

        System.out.println("Let the game begin!");
        String junk1 = input.nextLine();

        // The following do-while loop runs until one player reaches position 100.
        do{

            // Moves player 1 using movePlayer() method.
            movePlayer(0);
            // Checks if said player has reached position 100.
            if(winCheck())
                // Prints game over message if position is 100.
                System.out.println("Game over! " + playerList.get(0).getName() + " won!");
            // If the first player hasn't reached position 100, we go to the next player's turn.
            else if(winCheck() == false) {
                // Moves player 2.
                movePlayer(1);
                // Checks if said player reached square 100.
                if(winCheck())
                    // Prints game over message if position is 100.
                    System.out.println("Game over! " + playerList.get(1).getName() + " won!");
            }

        }while(winCheck() == false);

    }

}
