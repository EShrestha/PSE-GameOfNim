package Views;

import Models.Board;

public class Output {

    /* takes the current board and iterates over it to print
    out the spaces with items to the console
     */
    public static void printBoard(){
        boolean[][] board = Board.getBoard();
        for(int row = 0; row < (board.length * 2) + 1; row++){
            if(row % 2 == 0){
                for(int i = 0; i < board[0].length; i++){
                    System.out.print("++++");
                }
                System.out.println("+");
            } else {
                System.out.print("+");
                for(int col = 0; col <= board[0].length - 1; col++){
                    if(board[(row - 1) / 2][col]){
                        System.out.print(" x +");
                    } else {
                        System.out.print("   +");
                    }
                }
                System.out.println();
            }
        }
    }

    //basic abstraction to print a string to the console
    public static void send(String string){
        System.out.println(string);
    }

}
