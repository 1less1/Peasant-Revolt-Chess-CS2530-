package peasant_revolt;

import java.util.ArrayList;

public class Pawn extends Piece {

    private ArrayList<String> newLocations = new ArrayList<>();
    public Pawn(String location, String color, ChessBoard board) {
        super(color, location,"\u2659", board);
    }

    @Override
    public ArrayList<String> getMoves() {
        // Get the ChessBoard from the superclass
        ChessBoard cb = super.getBoard();
        String location = super.getLocation();

        Integer forward = 1;
        if(getColor().equalsIgnoreCase("black")) {
            forward = -1;
        }

        String newLocation = (changeRow(getLocation(), forward));
        newLocations.add(newLocation);
        // For each motion I can make:
        //   Check what pieces are present
        //   If a legal move exists:
        //   (aka the spot is empty or it is taken up by another piece
        //    of the opposite side)
        //      Add to my moves list
        return newLocations;
    }
}
