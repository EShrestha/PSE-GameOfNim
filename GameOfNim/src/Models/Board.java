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

    public boolean removePieces (int row, int quantity) {
        

        return false;
    }
}
