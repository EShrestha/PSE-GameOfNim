package Controllers;

import Models.Board;

import java.util.Random;

public class AI {
    public static int difficulty;

    /*Makes a random move if the difficulty chosen is 'easy'*/
    public static int[] easyMove(){
        int selectedRow;
        int numberOfPieces;
        int[] moveArray;

        int row1 = Board.checkRow(0);
        int row2 = Board.checkRow(1);

        selectedRow = (int) (Math.random() * 2);
        if (selectedRow == 0){
            numberOfPieces = (int) (Math.random() * row1) + 1;
        }
        else{
            numberOfPieces = (int) (Math.random() * row2) + 1;
        }

        moveArray = new int[]{selectedRow, numberOfPieces};

        return moveArray;
    }

    /*Makes a more sophisticated and tactical move if the difficulty chosen is 'medium',
    * ex. the AI will not take the last piece in a row if it does not have to*/
    public static int[] mediumMove(){
        int selectedRow = 0;
        int numberOfPieces = 1;
        int[] moveArray;

        int[] rows = {Board.checkRow(0), Board.checkRow(1), Board.checkRow(2)};
        int empty = 0;

        for (int i = 0; i < rows.length; i++){
            if (rows[1] == 0) {
                empty++;
            }
        }

        if (empty != 2) {
            do {
                selectedRow = (int) (Math.random() * 3);
            } while (rows[selectedRow] == 0);

            numberOfPieces = (int) (Math.random() * rows[selectedRow]) + 1;
        }

        moveArray = new int[]{selectedRow, numberOfPieces};

        return moveArray;
    }

    /*If the difficulty chosen is 'hard', then the AI will make strategic moves to
    * make it harder for the player to win, like taking a specific amount of pieces from a row
    * to force the player to take the last piece of a row*/
    public static int[] hardMove(){
        return null;
    }
}
