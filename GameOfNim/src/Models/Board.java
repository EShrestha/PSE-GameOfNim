package Models;

import Controllers.AI;
import Views.Output;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Board {
    private static boolean[][] board;
    public static final boolean[][] easyBoard = {{true, true, true},
                                    {true, true, true}};

    public static final boolean[][] mediumBoard = {{false, false, true, false, true, false, false},
                                      {false, true, true, true, true, true, false},
                                      {true, true, true, true, true, true, true}};

    public static final boolean[][] hardBoard = {{false, false, false, true, false, true, false, false, false},
                                    {false, false, false, true, true, true, false, false, false},
                                    {true, true, true, true, false, true, true, true, true},
                                    {true, true, true, true, true, true, true, true, true}};

    /*Returns the board*/
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

        System.out.println("D-ATTEMPTING TO MAKE MOVE: " + move[0]+","+move[1]);

        if(quantity < 1) {Output.send("***Quantity must at least be 1***"); return false; }

        try {
            if(!quantityCheck(row, quantity)){Output.send("***Cannot take all of the pieces!***"); return false;}
            numPieces = checkRow(row);
            if(numPieces < quantity){Output.send("***There are not " + quantity + " pieces in row " + (row+1) + "***"); return false;}
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

    /*
    * Checks how many total pieces there are on the board
    * If the selected row contains all of the pieces and the user wants to remove all of the pieces then false is returned
    * If User wants to remove an entire row but there will still be pieces left after that operation then true is returned
    */
    public static boolean quantityCheck(int row, int quantity){
        int totalPiecesOnBoard = 0;
        for(int i = 0; i<board.length; i++){
            totalPiecesOnBoard += checkRow(i);
        }
        if(totalPiecesOnBoard != 1 && quantity != 1){
            if((checkRow(row) == totalPiecesOnBoard) && (quantity == totalPiecesOnBoard)){
                return false;
            }
        }

        return true;
    }


}
