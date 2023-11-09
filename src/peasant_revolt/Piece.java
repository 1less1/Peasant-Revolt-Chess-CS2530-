package peasant_revolt;

import java.util.ArrayList;

public abstract class Piece {
    private String pieceRepresentation;
    private ChessBoard board;
    private String location;
    private String color;

    public Piece(String loc, String col, String rep, ChessBoard b) {
        //super(rep);
        board = b;
        location = loc;
        pieceRepresentation = rep;
        color = col;
        //this.setFont(new Font("Serif", Font.BOLD, 64));
    }

    public String getLocation() {
        return location;
    }

    public String getColor() {
        return color;
    }

    public String changeRow(String start, Integer change) {
        String newLocation = "" + start.charAt(0) + (start.charAt(1) + change);

        return newLocation;
    }

    protected ChessBoard getBoard() {
        return board;
    }

    public abstract ArrayList<String> getMoves();
}
