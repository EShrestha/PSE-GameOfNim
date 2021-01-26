package Controllers;

import Models.Board;

public class AI {
    public static int difficulty;

    /*Makes a random move if the difficulty chosen is 'easy'*/
    public static int[] easyMove(){

        return null;
    }

    /*Makes a more sophisticated and tactical move if the difficulty chosen is 'medium',
    * ex. the AI will not take the last piece in a row if it does not have to*/
    public static int[] mediumMove(){

        return null;
    }

    /*If the difficulty chosen is 'hard', then the AI will make strategic moves to
    * make it harder for the player to win, like taking a specific amount of pieces from a row
    * to force the player to take the last piece of a row*/
    public static int[] hardMove(){
        return null;
    }
}
