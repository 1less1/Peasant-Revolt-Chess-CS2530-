package peasant_revolt;

import java.util.ArrayList;

public class ChessBoard {
    private ArrayList<ArrayList<Piece>> board = new ArrayList<>();

    public ChessBoard() {
        for(int i = 0; i < 8; i++) {
            ArrayList<Piece> column = new ArrayList<>();
            board.add(column);
            addRow(i);
        }
    }

    public void addPiece(Piece p, String location) {
        location = location.toUpperCase();

        ArrayList<Piece> row = board.get(getRowNumber(location));

        // Replace what was at this location with the new Piece (p)
        // and delete the old value that was there
        row.add(getColNumber(location), p);
        row.remove(getColNumber(location) + 1);
    }

    public Piece getPiece(String location) {
        return board.get(getRowNumber(location)).get(getColNumber(location));//Double indexing the list
    }

    public ArrayList<String> getMoves(String location) {
       Piece piece = getPiece(location);
       ArrayList<String> moves = new ArrayList<>();
       if(piece==null) {
           return moves;
       } else if(piece instanceof Pawn) {

           Integer forward = 1;
           if(piece.getColor()=="black") {
               forward = -1;
           }


           //Compute the at most 3 possible moves
           String nextSpot = updateLocation(location, forward, 0);

           if(getPiece(nextSpot)==null) {
               moves.add(updateLocation(location, forward, 0));
           }

           //Both below check to see if the diagonal location has a piece of the opposite color
           nextSpot = updateLocation(location, forward, -1); //Forward one and to the left one
           if(canAttack(location, nextSpot)) {
               moves.add(nextSpot);
           }

           nextSpot = updateLocation(location, forward, 1); //Forward one and to the right one
           if(canAttack(location, nextSpot)) {
               moves.add(nextSpot);
           }



       } else if(piece instanceof Knight) {

       } else if(piece instanceof King) {

           for(Integer rowChange=-1; rowChange<2; rowChange++) {
               for(Integer colChange = -1; colChange<2; colChange++) {
                   String nextSpot = updateLocation(location, rowChange, colChange); //Forward one and to the right one
                   if(getPiece(nextSpot)!=null && !getPiece(nextSpot).getColor().equals(piece.getColor())) {
                       moves.add(nextSpot);
                   }

               }

           }

       }
       return null;
    }

    public void movePiece(String start, String end) {
        Piece startingPiece= getPiece(start);
        setPiece(end, startingPiece); //Move piece to new location
        setPiece(start, null); //Erase piece from previous location

    }

    public void setPiece(String position, Piece piece) {
        board.get(getRowNumber(position)).remove(getColNumber(position));
        board.get(getRowNumber(position)).add(getColNumber(position),piece);
    }

    private Boolean canAttack(String attacker, String victim) {
         return getPiece(victim) != null && !getPiece(victim).getColor().equals(getPiece(attacker).getColor());
    }


    //Used in getMoves() to check for a possible location to move the piece
    private String updateLocation(String oldLocation, Integer rowChange, Integer columnChange) {
        return "";
    }

    private Integer getColNumber(String location) {
        return location.charAt(0) - 'A';
    }

    private Integer getRowNumber(String location) {
        return location.charAt(1) - '1';
    }

    private void addRow(Integer rowNum) {
        for(int i = 0; i < 8; i++) {
            board.get(rowNum).add(null);
        }
    }
}
