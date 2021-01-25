package Models;

import Controllers.AI;

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
        switch (difficulty) {
            case 0:
                board = easyBoard;
                break;
            case 1:
                board = mediumBoard;
                break;
            case 2:
                board = hardBoard;
                break;
        }
    }

    /*
    * TODO comment
    * */
    public static boolean removePieces (int[] move) {
        int numPieces = 0;
        int row = move[0]-1;
        int quantity = move[1];

        if(quantity < 1) {System.out.println("Quantity must at least be 1"); return false; }
        try {
            for (boolean b : board[row]) {
                if (b) {
                    numPieces++;
                }
            }
            if (numPieces >= quantity) {
                //for(int i = 0; (i<board[row].length && quantity !=0); i++){if(board[row][i]){ board[row][i]=false; quantity--;}}
                int i = 0;
                while (quantity > 0) {
                    if (board[row][i]) {
                        board[row][i] = false;
                        quantity--;
                        i++;
                    }
                }
            } else {
                return false;
            }
        }catch (Exception e){
            return false;
        }

        return true;
    }
}
