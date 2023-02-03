// -----------------------------------------------------
// Assignment 1
// Question: 1 - Part 2
// Written by: (include your name and student id)
// -----------------------------------------------------
// This program is a text-based version of the popular Snakes and Ladders board-game.
// It does this using three classes. The PlayLaddersAndSnake class acts as the driver, the Player class holds all information regarding the players, and the LadderAndSnake,
// which holds all the necessary methods for the program.

import java.util.Scanner;
/**
 * Mark Ghaby - 40201940
 * COMP249
 * Assignment #1
 * Due Date: Friday, February 3, 2023.
 * The PlayLadderAndSnake class is used to prompt the user for the number of players, and to run the play() method from the LadderAndSnake class.
 */
public class PlayLadderAndSnake {
    public static void main(String[] args) {

        // Creating Scanner
        Scanner input = new Scanner(System.in);

        // Displaying welcome message and prompting user for number of players
        System.out.println("Welcome to Snakes and Ladders! Created by Mark Ghaby.");
        System.out.print("Please enter the number of players: ");
        // Get user input
        int numPlayersInput = input.nextInt();

        LadderAndSnake.play(numPlayersInput);

    }
}