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
        //If the piece is at an invalid position off the board. Raise a cusotm exception
        if(!isValidPosition(location)) {
            throw new ChessBoardLocationOutOfBounds();
        }

        return board.get(getRowNumber(location)).get(getColNumber(location));//Double indexing the list
    }

    public void setPiece(String position, Piece piece) {
        board.get(getRowNumber(position)).remove(getColNumber(position));
        board.get(getRowNumber(position)).add(getColNumber(position),piece);
    }

    public ArrayList<String> getMoves(String location) {
       Piece piece = getPiece(location);
       ArrayList<String> moves = new ArrayList<>();

       //Add check to make sure the proper color is receiving moves if it is white's turn and black asks for moves, return an empty moves list
       if(piece==null) {
           return moves;

       } else if(piece instanceof Pawn) {

           Integer forward = 1;
           if(piece.getColor()=="black") {
               forward = -1;
           }

           //Compute the at most 3 possible moves
           String nextSpot = updateLocation(location, forward, 0);

           //Check if possible move is a valid position. If that is true then check the spot to see if it is empty.
           if(isValidPosition(nextSpot) && getPiece(nextSpot)==null) {
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
           //Knights can move 2 row/col and 1 col/row (an L-shaped move)

           //Primitive lists that just hold data consecutively in memory
           Integer[] aChanges = {2, -2};
           Integer[] bChanges = {1,-1};

           for (Integer aChange : aChanges) {
               for (Integer bChange : bChanges) {
                   String nextSpot=updateLocation(location, aChange, bChange);
                   if(isValidPosition(nextSpot) && (getPiece(nextSpot) == null ) ||
                           !getPiece(nextSpot).getColor().equals(piece.getColor())) {
                       moves.add(nextSpot);
                   }
               }
           }


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
       return moves;
    }

    public void movePiece(String start, String end) {
        Piece startingPiece= getPiece(start);
        setPiece(end, startingPiece); //Move piece to new location
        setPiece(start, null); //Erase piece from previous location

    }

    //Used in getMoves() to check for a possible location to move the piece
    public String updateLocation(String oldLocation, Integer rowChange, Integer columnChange) {
        Character newRow = (char) (oldLocation.charAt(1) + rowChange);
        Character newColumn = (char)(oldLocation.charAt(0) + columnChange);


        return "" + newColumn + newRow ;
    }

    private Boolean isValidPosition(String position) {
        return position.charAt(0) >= 'A' && position.charAt(0) <='H' &&
                position.charAt(1) >= '1' && position.charAt(1) <= '8';
    }

    private Boolean canAttack(String attacker, String victim) {
         return getPiece(victim) != null && !getPiece(victim).getColor().equals(getPiece(attacker).getColor());
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
