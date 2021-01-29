import Controllers.AI;
import Models.Board;
import Views.Input;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Tester {

    @Test
    public void testCheckRow() {
        Board.setBoard(1);
        //assertEquals(2, Board.checkRow(0));     If Board is equal to the correct one
        //assertEquals(3, Board.checkRow(0));     If Board is more than the correct one
        //assertEquals(1, Board.checkRow(0));     If Board is less than the correct one
        /*Tested to make sure if above or below will make the test fail, which it did
        * Also tested to make sure it was correct, which it was*/

        //assertEquals(5, Board.checkRow(1));     If Board is equal to the correct one
        //assertEquals(6, Board.checkRow(1));     If Board is more than the correct one
        //assertEquals(4, Board.checkRow(1));     If Board is less than the correct one
        /*Tested to make sure if above or below will make the test fail, which it did
         * Also tested to make sure it was correct, which it was*/

        //assertEquals(7, Board.checkRow(2));     If Board is equal to the correct one
        //assertEquals(8, Board.checkRow(2));     If Board is more than the correct one
        //assertEquals(6, Board.checkRow(2));     If Board is less than the correct one
        /*Tested to make sure if above or below will make the test fail, which it did
         * Also tested to make sure it was correct, which it was*/
    }
    @Test
    public void testEasyAI() {

    }
    @Test
    public void testMediumAI() {

    }
    @Test
    public void testHardAI() {
        Board.setBoard(2);
        Board.removePieces(new int[]{1,2});
        Board.removePieces(new int[]{2,3});
        Board.removePieces(new int[]{3,8});
        int[] aiMove = AI.hardMove();
        assertEquals(4, aiMove[0]);
        assertEquals(8, aiMove[1]);

    }
    @Test
    public void testGetBoard() {

    }
    @Test
    public void testRemovePieces() {

    }
    @Test
    public void testIsGameOver() {
        Board.setBoard(0);

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
        Board.setBoard(0);

        // User can take all 3 pieces from top row since there will be pieces on the second row
        assertTrue(Board.quantityCheck(0, 3));

        //Removing all pieces from row 1
        Board.removePieces(new int[]{1,3});

        // User cannot take all 3 pieces from row 2 because all of row 1s pieces were taken above so then if all pieces are taken from row 2 there would be 0 pieces left
        assertFalse(Board.quantityCheck(1, 3));
    }

}
