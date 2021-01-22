package Models;

public class Board {
    private boolean[][] board;
    public boolean[][] easyBoard = {{true, true, true},
                                    {true, true, true}};

    public boolean[][] mediumBoard = {{false, false, true, false, true, false, false},
                                      {false, true, true, true, true, true, false},
                                      {true, true, true, true, true, true, true}};

    public boolean[][] hardBoard = {{false, false, false, true, false, true, false, false, false},
                                    {false, false, false, true, true, true, false, false, false},
                                    {true, true, true, true, false, true, true, true, true},
                                    {true, true, true, true, true, true, true, true, true}};

    public boolean[][] getBoard() {
        return board;
    }

    /*setBoard takes in the difficulty that the user decides and sets the
    * specifics of the board based on that difficulty*/
    public void setBoard(int difficulty){
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
    public boolean removePieces (int row, int quantity) {
        int numPieces = 0;

        for (boolean b : board[row]){
            if (b){numPieces++;}
        }
        if (numPieces >= quantity){
            int i = 0;
            while (quantity > 0) {
                if (board[row][i]){
                    board[row][i] = false;
                    quantity--;
                }
            }
        }
        else {
            return false;
        }

        return true;
    }
}
