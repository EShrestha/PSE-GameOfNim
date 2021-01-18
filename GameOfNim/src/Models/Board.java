package Models;

public class Board {

    public int[][] board;

    public void Board(byte rows, int[] colAmounts){
        //TODO:Implement making a board with provided number of rows and each row has the specified colAmounts(just a number in this case)
        board = new int[rows][];
        for(int i=0; i<board.length; i++){
            board[i][0] = colAmounts[i];
        }
    }
}
