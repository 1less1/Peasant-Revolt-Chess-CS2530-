package peasant_revolt;

public class PeasantRevolt {
    ChessBoard board = new ChessBoard();

    public PeasantRevolt() {
        Piece pawn1 = null;
        board.addPiece(pawn1, "A2");
    }

    public ChessBoard getChessBoard() {
        return board;
    }
}
