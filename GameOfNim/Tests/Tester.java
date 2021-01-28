import Models.Board;
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
    @Test
    public void testRequestNumber() {

    }
    @Test
    public void testRequestMove() {

    }

}
