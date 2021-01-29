import Controllers.AI;
import Models.Board;
import Views.Input;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Tester {

    @Test
    public void testCheckRow() {
        //sets up the board for the medium difficulty
        Board.setBoard(1);

        //checks to make sure the first row is only 2 long
        assertEquals(2,Board.checkRow(0));
    }
    @Test
    public void testEasyAI() {
        Board.setBoard(0);

        //checks to see if the method returns a valid row and number of pieces to be removed
        int[] move = AI.easyMove();
        if(move[0] < 1 || move[0] > 2){
            fail();
        } else if (move[0] < 1 || move[0] > 3) {
            fail();
        } else {
            assertTrue(true);
        }
    }
    @Test
    public void testMediumAI() {
        //setting up the medium board so that only one of the rows has pieces in it
        Board.setBoard(1);
        Board.removePieces(new int[]{2,5});
        Board.removePieces(new int[]{1,2});

        //makes sure the AI takes all but one of the remaining pieces from the last row
        int[] aiMove = AI.mediumMove();
        assertEquals(6, aiMove[1]);
    }
    @Test
    public void testHardAI() {
        //setting up the hard board so that only one of the rows has pieces in it
        Board.setBoard(2);
        Board.removePieces(new int[]{1,2});
        Board.removePieces(new int[]{2,3});
        Board.removePieces(new int[]{3,8});

        //makes sure the AI takes all but one of the remaining pieces from the last row
        int[] aiMove = AI.hardMove();
        assertEquals(4, aiMove[0]);
        assertEquals(8, aiMove[1]);

    }
    @Test
    public void testGetBoard() {

        // Making easy board the active board
        Board.setBoard(0); // 2x3 board
        // Easy board should be 2 rows
        assertEquals(2, Board.getBoard().length);
        // Each row in easy board is 3 columns wide
        for(boolean[] c : Board.getBoard()){assertEquals(3, c.length);}

        // Making medium board the active board
        Board.setBoard(1); // 3x7 board
        // easy board should be 3 rows
        assertEquals(3, Board.getBoard().length);
        // Each row in medium board is 7 columns wide
        for(boolean[] c : Board.getBoard()){assertEquals(7, c.length);}

        // Making hard board the active board
        Board.setBoard(2); // 4x9 board
        // Hard board should be 4 rows
        assertEquals(4, Board.getBoard().length);
        // Each row in hard board is 9 columns wide
        for(boolean[] c : Board.getBoard()){assertEquals(9, c.length);}

    }
    @Test
    public void testRemovePieces() {
        Board.setBoard(0); // 2x3 board

        // User cannot select a row that does not exist
        assertFalse(Board.removePieces(new int[]{5,2}));

        // User cannot select an amount that is greater than there are columns for the specified row
        assertFalse(Board.removePieces(new int[]{2,9}));

        // User cannot select a amount less than 1
        assertFalse(Board.removePieces(new int[]{2, 0}));

        Board.removePieces(new int[]{1,1}); // Simulating a player taking 1 of 3 pieces from row one

        // User cannot take more pieces then there currently are on the specified row
        assertFalse(Board.removePieces(new int[]{1, 3}));

        // User can take all of the pieces from a row as long as there are more pieces in other rows
        assertTrue(Board.removePieces(new int[]{1, 2}));

        // User cannot take pieces from a row that has no pieces
        assertFalse(Board.removePieces(new int[]{1, 2}));

        // User cannot take all of the pieces form a row if said row is the only row on the board with pieces
        assertFalse(Board.removePieces(new int[]{2, 3}));


    }
    @Test
    public void testIsGameOver() {
        Board.setBoard(0); // 2x3 board

        Board.removePieces(new int[]{1,3}); // Simulating a player taking 3 of 3 pieces from row one
        Board.removePieces(new int[]{2,1}); // Simulating a player taking 1 of 3 pieces from row two

        // Game should not be over since there are 2 pieces still left in row 2
        assertFalse(Board.isGameOver());

        Board.removePieces(new int[]{2,1}); // Simulating a player taking 1 of 2 pieces from row two

        // Game should now be over since ther is only 1 piece left on the entire board
        assertTrue(Board.isGameOver());


    }
    @Test
    public void testQuantityCheck() {
        Board.setBoard(0); // 2x3 board

        // User can take all 3 pieces from top row since there will be pieces on the second row
        assertTrue(Board.quantityCheck(0, 3));

        //Removing all pieces from row 1
        Board.removePieces(new int[]{1,3});

        // User cannot take all 3 pieces from row 2 because all of row 1s pieces were taken above so then if all pieces are taken from row 2 there would be 0 pieces left
        assertFalse(Board.quantityCheck(1, 3));
    }

}
