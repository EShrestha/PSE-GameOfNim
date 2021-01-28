import Controllers.AI;
import Models.Board;
import Views.Input;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Tester {

    @Test
    public void testCheckRow() {

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
