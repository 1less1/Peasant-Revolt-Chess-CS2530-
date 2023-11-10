package peasant_revolt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {
    private ChessBoard board = new ChessBoard();
    private Pawn pawn;

    @BeforeEach
    void setUp() {
        pawn = new Pawn("e2", "white", board);
        board.addPiece(pawn, "e2");
    }

    @Test
    void getMoves() {
        ArrayList<String> newLocations = pawn.getMoves();

        String legalMoves = "e3";

        for(String newLocation : newLocations) {
            assertTrue(legalMoves.contains(newLocation));
        }

        assertEquals(1,newLocations.size());


    }

    @Test
    public void testUpdateLocation() {
        ChessBoard cb = new ChessBoard();
        String oldLocation = "A1";
        assertEquals("B2", cb.updateLocation(oldLocation,1, 1));

    }
}