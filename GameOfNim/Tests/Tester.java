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

    }
    @Test
    public void testQuantityCheck() {

    }

}
