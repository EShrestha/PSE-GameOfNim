import Models.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Tester {

    @Test
    public void testCheckRow() {
        Board.setBoard(1);
            assertEquals(6, Board.checkRow(2));
    }

}
