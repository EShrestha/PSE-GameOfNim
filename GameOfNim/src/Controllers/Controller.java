package Controllers;

import Models.Board;
import Views.Input;
import Views.Output;

public class Controller {
    private static byte turns; // Keeps track of how many turns have been made, and used for checking which players turn it is
    private static int vsMode = 0; // Keeps track of what mode the player wants, 0 being PvP, and 1 being PvAI


    /*
    * When called, it is responsible for setting up a new game.
    * Asks the user what game mode they wish to play, player vs player or player vs AI
    * Then User is prompted for the difficulty of the game.
    * After all prompts are answered play() is called which takes turns betweens the players until game is over
    * Once game is over the user is asked if they would like to play again or quit
    * If they want to play again, the above process is repeated
    * If they want to quit the application closes
    */
    public static void setup(){
        // Output.display welcome text
        //board = new Board();
        do{
            vsMode = (Input.requestNumber("What Game Mode Would You like?\n1) PvP\n2) PvE")-1);
            Board.setBoard((Input.requestNumber("What Difficulty would you like?\n1) Easy\n2) Medium\n3) Hard"))-1);
            play();
        }while(Input.requestNumber("What would you like to do?\n1) Play again.\n2) Quit.") != 2);
    }

    /*
    * Is active when a game is being played
    * The board is displayed
    * Player is prompted to make a move, once made, turns is incremented
    * AI makes a move if it is PvE
    * Repeats until game over is true
    * Prints out which player won the game
    * */
    public static void play(){
        boolean gameOver = false;
        do{
            Output.printBoard(); // Display board
            while (!Board.removePieces(Input.requestMove("Player " + (turns % 2 == 0 ? "1" : "2") + "'s turn."))) ;
            turns++;
            if(vsMode == 2){/*AI makes move*/ System.out.println("AI Move Made");turns++;}
        }while(!gameOver);
        System.out.println("Game over!");
        // Say which won here
    }
    


}
