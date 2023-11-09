package peasant_revolt;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ChessBoardTest {

    @Test
    public void setPiece() {
        ChessBoard cb = new ChessBoard();

        Pawn pawn = new Pawn("", "white", null);
        cb.setPiece("A1", pawn);

        assertEquals(pawn, cb.getPiece("A1"));
    }

    @Test
    public void testGetMovesForPawn() {
        ChessBoard cb = new ChessBoard();

        Pawn pawn = new Pawn("", "white", null);
        cb.setPiece("B2", pawn);

        ArrayList<String> possibleMoves = cb.getMoves("B2");
        assertEquals(1, possibleMoves.size());
        assertEquals("B3", possibleMoves.get(0));

    }
}
