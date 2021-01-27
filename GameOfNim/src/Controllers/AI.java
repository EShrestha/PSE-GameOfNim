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
                for(int i = 0; i < 4; i++){
                    if(numPieces[i] != 0){
                        if(numPieces[i] > 1){
                            return new int[]{i, (numPieces[i] - 1)};
                        } else {
                            return new int[]{i,1};
                        }
                    }
                }
                break;
            case(2):
                int first = -1;
                for(int i = 0; i < 4; i++){
                    if(numPieces[i] != 0){
                        if(numPieces[i] > 1 && first != -1){
                            if(numPieces[first] == 1){
                                return new int[]{i, numPieces[i]};
                            } else {
                                return new int[]{first, numPieces[first] - 1};
                            }
                        } else {
                            first = i;
                        }
                    }
                }
                break;
            case(1):
                int one = 0;
                for(int i = 0; i < 4; i++){
                    if(numPieces[i] != 0){
                        if(one == 2){
                            return new int[]{i, numPieces[i]};
                        } else {
                            if(numPieces[i] == 1){
                                one++;
                            }
                        }
                    }
                }
            default:
                int ran = (int)(Math.random() * 4);
                do {
                    if (numPieces[ran] != 0) {
                        return new int[]{ran, ((int) Math.random() * numPieces[ran])};
                    }
                } while(true);
        }
        throw new RuntimeException();
    }
}
