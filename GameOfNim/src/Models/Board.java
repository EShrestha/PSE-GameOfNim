package Models;

import Controllers.AI;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Board {
    private static boolean[][] board;
    public static boolean[][] easyBoard = {{true, true, true},
                                    {true, true, true}};

    public static boolean[][] mediumBoard = {{false, false, true, false, true, false, false},
                                      {false, true, true, true, true, true, false},
                                      {true, true, true, true, true, true, true}};

    public static boolean[][] hardBoard = {{false, false, false, true, false, true, false, false, false},
                                    {false, false, false, true, true, true, false, false, false},
                                    {true, true, true, true, false, true, true, true, true},
                                    {true, true, true, true, true, true, true, true, true}};

    public static boolean[][] getBoard() {
        return board;
    }

    /*setBoard takes in the difficulty that the user decides and sets the
    * specifics of the board based on that difficulty*/
    public static void setBoard(int difficulty){
        AI.difficulty = difficulty;
        int length = 0;
        switch (difficulty) {
            case 0:
                length = easyBoard.length;
                break;
            case 1:
                length = mediumBoard.length;
                break;
            case 2:
                length = hardBoard.length;
                break;
        }
        board = new boolean[length][];
        for(int i = 0; i < length; i++){
            switch (difficulty) {
                case 0:
                    board[i] = easyBoard[i].clone();
                    break;
                case 1:
                    board[i] = mediumBoard[i].clone();
                    break;
                case 2:
                    board[i] = hardBoard[i].clone();
                    break;
            }
        }
    }

    /*
     * Removes pieces based on an int[] that is passed in that contain user
     * input for the specific row the user wants to remove from, and the
     * quantity of pieces that the user would like to remove fom said row
     * */
    public static boolean removePieces (int[] move) {
        int numPieces = 0;
        int row = move[0]-1;
        int quantity = move[1];

        if(quantity < 1) {System.out.println("Quantity must at least be 1"); return false; }
        try {
            numPieces = checkRow(row);
            if (numPieces >= quantity) {
                //for(int i = 0; (i<board[row].length && quantity !=0); i++){if(board[row][i]){ board[row][i]=false; quantity--;}}
                int i = 0;
                while (i<board[row].length && quantity !=0) {
                    if (board[row][i]) {
                        board[row][i] = false;
                        quantity--;
                    }
                        i++;
                }
            } else {
                return false;
            }
        }catch (Exception e){
            return false;
        }

        return true;
    }

    /*Takes in a row to check how many pieces are left in the row,
    * then returns the number of remaining pieces*/
    public static int checkRow (int row) {
        int numPieces = 0;
        
        for (boolean b : board[row]) {
            if (b) {
                numPieces++;
            }
        }

        return numPieces;
    }

    /*
    * Goes through each row in the board
    * If there are at least 2 pieces on the board, game is not over
    * If only 1 piece is left that means game is over
    */
    public static boolean isGameOver(){
        byte pieces = 0;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j]){pieces++;}
                if(pieces > 1){return false;}
            }
        }
        return true;
    }

}
