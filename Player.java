// -----------------------------------------------------
// Assignment 1
// Question: 1 - Part 2
// Written by: (include your name and student id)
// -----------------------------------------------------
// This program is a text-based version of the popular Snakes and Ladders board-game.
// It does this using three classes. The PlayLaddersAndSnake class acts as the driver, the Player class holds all information regarding the players, and the LadderAndSnake,
// which holds all the necessary methods for the program.

/**
 *  Mark Ghaby - 40201940.
 *  COMP249.
 *  Assignment #1.
 *  Due Date: Friday, February 3, 2023.
 *  The Player class represents a player, which holds a position, name and diceValue.
 */
public class Player {
    /**
     * Position of the player.
     */
    private int position = 0;
    /**
     * Name of the player.
     */
    private String name;
    /**
     * Dice value of the player after a roll.
     */
    private int diceValue;

    /**
     * Default constructor for player class. Sets name to blank string.
     */
    public Player(){
        name = "";
    }

    /**
     * @param name name to set
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * @return this Player's name.
     */
    public String getName(){
        return name;
    }

    /**
     * @param diceValue dice value to set
     */
    public void setDiceValue(int diceValue){
        this.diceValue = diceValue;
    }
    /**
     * @return this player's dice value.
     */
    public int getDiceValue(){
        return diceValue;
    }

    /**
     * @return this Player's position.
     */
    public int getPosition(){
        return position;
    }

    /**
     * @param newPosition position to set
     */
    public void setPosition(int newPosition){
        this.position = newPosition;
    }



}
