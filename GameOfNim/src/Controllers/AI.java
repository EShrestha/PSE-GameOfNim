package Controllers;

import Models.Board;

import java.util.Random;

public class AI {
    public static int difficulty;

    /**
     * Helper method that helps to put all of the AI moves into one
     * Calls which the AIs mak move method based on difficulty and returns the result
     */
    public static int[] makeMove(){
        switch (difficulty){
            case 0:
                return easyMove();
            case 1:
                return mediumMove();
            case 2:
                return hardMove();
            default:
                return new int[]{};
        }
    }


    /*Makes a random move if the difficulty chosen is 'easy'*/
    public static int[] easyMove(){
        int selectedRow;
        int numberOfPieces;
        int[] moveArray;

        int row1 = Board.checkRow(0);
        int row2 = Board.checkRow(1);

        selectedRow = (int) (Math.random() * 2);
        if (selectedRow != 0){                                      //Fixed: should be != instead of ==
            numberOfPieces = (int) (Math.random() * row1) + 1;
        }
        else{
            numberOfPieces = (int) (Math.random() * row2) + 1;
        }

        moveArray = new int[]{selectedRow+1, numberOfPieces};

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

        moveArray = new int[]{selectedRow+1, numberOfPieces};

        return moveArray;
    }

    /*If the difficulty chosen is 'hard', then the AI will make strategic moves to
    * make it harder for the player to win, like taking a specific amount of pieces from a row
    * to force the player to take the last piece of a row*/
    public static int[] hardMove(){
        boolean[][] board = Board.getBoard();
        int[] numPieces = new int[4];
        for(int i = 0; i < board.length; i++){
            numPieces[i] = Board.checkRow(i);
        }
        int empty = 0;
        for(int i : numPieces){
            if(i == 0){
                empty++;
            }
        }
        switch(empty){
            case(3):
                System.out.println("D-case 3");
                for(int i = 0; i < 4; i++){
                    if(numPieces[i] != 0){
                        if(numPieces[i] > 1){
                            return new int[]{i+1, (numPieces[i] - 1)};
                        } else {
                            return new int[]{i+1,1};
                        }
                    }
                }
                break;
            case(2):
                System.out.println("D-case 2");
                int first = -1;
                for(int i = 0; i < 4; i++){
                    if(numPieces[i] != 0){
                        if(numPieces[i] > 1 && first != -1){
                            if(numPieces[first] == 1){
                                return new int[]{i+1, numPieces[i]};
                            } else {
                                return new int[]{first+1, numPieces[first] - 1};
                            }
                        } else {
                            first = i;
                        }
                    }
                }
                break;
            case(1):
                System.out.println("D-case 1");
                int one = 0;
                for(int i = 0; i < 4; i++){
                    if(numPieces[i] != 0){
                        if(one == 2){
                            return new int[]{i+1, numPieces[i]};
                        } else {
                            if(numPieces[i] == 1){
                                one++;
                            }
                        }
                    }
                }
            default:
                System.out.println("D-default");
                int ran;
                do {
                    ran = (int)(Math.random() * 4);                                     //Fixed: this was outside of the do while loop causing it to be in an infinite loop when ran was 0
                    if (numPieces[ran] != 0) {
                        return new int[]{ran+1, ((int) (Math.random() * numPieces[ran]))};
                    }
                } while(true);
        }
        throw new RuntimeException();
    }
}
