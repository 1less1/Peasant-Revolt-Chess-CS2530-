## Possible Classes
aka "find the nouns"
* ChessBoard
* ChessBoardPanel
* Piece
  * King
  * Knight
  * Pawn
* Player
* PeasantRevoltChess
```mermaid
classDiagram
Piece <|-- King
Piece <|-- Pawn
Piece <|-- Knight
Piece -- ChessBoard
```

## Notes
* A chess board stores 64 pieces, with null meaning empty
* A chess board panel stores a board as 
  an instance variable, which is set when created.

## One Attempt at Behavior
```mermaid
sequenceDiagram
    User->>+ChessBoardPanel: Click on square
    ChessBoardPanel->>+ChessBoard: get moves
    ChessBoard->>+Piece: get possible moves
    Piece->>+ChessBoard: get piece
    ChessBoard-->-Piece: a Piece
    Piece-->-ChessBoard: possible moves
    ChessBoard-->-ChessBoardPanel: possible moves
    ChessBoardPanel-->-User: possible moves are highlighted
```