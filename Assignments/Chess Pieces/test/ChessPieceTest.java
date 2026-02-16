import static org.junit.jupiter.api.Assertions.*;

class ChessPieceTest {

  private Bishop whiteBishop;
  private Knight whiteKnight;
  private Rook whiteRook;
  private Queen whiteQueen;
  private King whiteKing;
  private Pawn whitePawn;
  private Bishop blackBishop;
  private Knight blackKnight;
  private Rook blackRook;
  private Queen blackQueen;
  private King blackKing;
  private Pawn blackPawn;

  @org.junit.jupiter.api.BeforeEach
  void setUp() {
    whiteBishop = new Bishop(3, 3, Color.WHITE);
    whiteKnight = new Knight(3, 3, Color.WHITE);
    whiteRook = new Rook(3, 3, Color.WHITE);
    whiteQueen = new Queen(3, 3, Color.WHITE);
    whiteKing = new King(3, 3, Color.WHITE);
    whitePawn = new Pawn(1, 3, Color.WHITE);

    blackBishop = new Bishop(5, 5, Color.BLACK);
    blackKnight = new Knight(5, 4, Color.BLACK);
    blackRook = new Rook(3, 7, Color.BLACK);
    blackQueen = new Queen(7, 7, Color.BLACK);
    blackKing = new King(4, 4, Color.BLACK);
    blackPawn = new Pawn(6, 3, Color.BLACK);
  }

  @org.junit.jupiter.api.Test
  void getRow() {
    assertEquals(3, whiteBishop.getRow());
    assertEquals(5, blackBishop.getRow());
    assertEquals(1, whitePawn.getRow());
    assertEquals(6, blackPawn.getRow());
  }

  @org.junit.jupiter.api.Test
  void getColumn() {
    assertEquals(3, whiteBishop.getColumn());
    assertEquals(5, blackBishop.getColumn());
    assertEquals(3, whitePawn.getColumn());
    assertEquals(3, blackPawn.getColumn());
  }

  @org.junit.jupiter.api.Test
  void getColor() {
    assertEquals(Color.WHITE, whiteBishop.getColor());
    assertEquals(Color.BLACK, blackBishop.getColor());
    assertEquals(Color.WHITE, whiteKing.getColor());
    assertEquals(Color.BLACK, blackKing.getColor());
  }

  @org.junit.jupiter.api.Test
  void canKill() {
    // Bishop can kill opponent on diagonal
    assertTrue(whiteBishop.canKill(blackBishop));
    assertFalse(whiteBishop.canKill(whiteKnight)); // same color

    // Knight can kill opponent in L position
    assertTrue(whiteKnight.canKill(blackKnight));

    // Rook can kill opponent on same row/column
    assertTrue(whiteRook.canKill(blackRook));

    // Queen can kill in any direction
    assertTrue(whiteQueen.canKill(blackQueen));

    // King can kill adjacent opponent
    assertTrue(whiteKing.canKill(blackKing));

    // Pawn kills diagonally forward only
    Pawn whitePawnTest = new Pawn(3, 3, Color.WHITE);
    Pawn blackPawnDiagonal = new Pawn(2, 4, Color.BLACK);
    Pawn blackPawnStraight = new Pawn(2, 3, Color.BLACK);
    assertTrue(whitePawnTest.canKill(blackPawnDiagonal)); // diagonal kill
    assertFalse(whitePawnTest.canKill(blackPawnStraight)); // cannot kill straight

    // Cannot kill same color
    assertFalse(whiteRook.canKill(whiteQueen));
  }

  @org.junit.jupiter.api.Test
  void isDiagonalMove() {
    // Test diagonal moves for bishop
    assertTrue(whiteBishop.canMove(5, 5)); // diagonal
    assertTrue(whiteBishop.canMove(1, 1)); // diagonal
    assertTrue(whiteBishop.canMove(6, 0)); // diagonal
    assertFalse(whiteBishop.canMove(3, 5)); // horizontal (not diagonal)
    assertFalse(whiteBishop.canMove(5, 3)); // vertical (not diagonal)
  }

  @org.junit.jupiter.api.Test
  void isHorizontalMove() {
    // Test horizontal moves for rook (only moves horizontally/vertically)
    assertTrue(whiteRook.canMove(3, 7)); // horizontal
    assertTrue(whiteRook.canMove(3, 0)); // horizontal
    assertFalse(whiteRook.canMove(5, 5)); // diagonal (not allowed for rook)

    // Test that bishop cannot move horizontally
    assertFalse(whiteBishop.canMove(3, 7)); // horizontal (not allowed for bishop)
  }

  @org.junit.jupiter.api.Test
  void isVerticalMove() {
    // Test vertical moves for rook (only moves horizontally/vertically)
    assertTrue(whiteRook.canMove(7, 3)); // vertical
    assertTrue(whiteRook.canMove(0, 3)); // vertical
    assertFalse(whiteRook.canMove(5, 5)); // diagonal (not allowed for rook)

    // Test that bishop cannot move vertically
    assertFalse(whiteBishop.canMove(5, 3)); // vertical (not allowed for bishop)
  }

  @org.junit.jupiter.api.Test
  void isValidPosition() {
    // Test valid positions
    assertTrue(whiteQueen.canMove(0, 0)); // valid corner
    assertTrue(whiteQueen.canMove(7, 7)); // valid corner

    // Test invalid positions
    assertFalse(whiteQueen.canMove(-1, 3)); // negative row
    assertFalse(whiteQueen.canMove(3, -1)); // negative column
    assertFalse(whiteQueen.canMove(8, 3)); // row too high
    assertFalse(whiteQueen.canMove(3, 8)); // column too high
    assertFalse(whiteQueen.canMove(3, 3)); // same position
  }

  @org.junit.jupiter.api.Test
  void testBishopMoves() {
    // Valid diagonal moves
    assertTrue(whiteBishop.canMove(5, 5));
    assertTrue(whiteBishop.canMove(1, 1));
    assertTrue(whiteBishop.canMove(0, 6));

    // Invalid non-diagonal moves
    assertFalse(whiteBishop.canMove(3, 5));
    assertFalse(whiteBishop.canMove(5, 3));
  }

  @org.junit.jupiter.api.Test
  void testKnightMoves() {
    // Valid L-shaped moves
    assertTrue(whiteKnight.canMove(5, 4)); // 2 down, 1 right
    assertTrue(whiteKnight.canMove(5, 2)); // 2 down, 1 left
    assertTrue(whiteKnight.canMove(1, 4)); // 2 up, 1 right
    assertTrue(whiteKnight.canMove(4, 5)); // 1 down, 2 right
    assertTrue(whiteKnight.canMove(2, 5)); // 1 up, 2 right

    // Invalid moves
    assertFalse(whiteKnight.canMove(3, 5)); // straight
    assertFalse(whiteKnight.canMove(5, 5)); // diagonal
    assertFalse(whiteKnight.canMove(5, 6)); // not L-shape
  }

  @org.junit.jupiter.api.Test
  void testRookMoves() {
    // Valid horizontal and vertical moves
    assertTrue(whiteRook.canMove(3, 0));
    assertTrue(whiteRook.canMove(3, 7));
    assertTrue(whiteRook.canMove(0, 3));
    assertTrue(whiteRook.canMove(7, 3));

    // Invalid diagonal moves
    assertFalse(whiteRook.canMove(5, 5));
    assertFalse(whiteRook.canMove(1, 1));
  }

  @org.junit.jupiter.api.Test
  void testQueenMoves() {
    // Valid moves in all directions
    assertTrue(whiteQueen.canMove(3, 7)); // horizontal
    assertTrue(whiteQueen.canMove(7, 3)); // vertical
    assertTrue(whiteQueen.canMove(6, 6)); // diagonal
    assertTrue(whiteQueen.canMove(0, 0)); // diagonal
    assertTrue(whiteQueen.canMove(0, 3)); // vertical

    // Invalid knight-like move
    assertFalse(whiteQueen.canMove(5, 4));
  }

  @org.junit.jupiter.api.Test
  void testKingMoves() {
    // Valid one-space moves
    assertTrue(whiteKing.canMove(3, 4)); // right
    assertTrue(whiteKing.canMove(3, 2)); // left
    assertTrue(whiteKing.canMove(4, 3)); // down
    assertTrue(whiteKing.canMove(2, 3)); // up
    assertTrue(whiteKing.canMove(4, 4)); // diagonal
    assertTrue(whiteKing.canMove(2, 2)); // diagonal

    // Invalid multiple-space moves
    assertFalse(whiteKing.canMove(3, 5));
    assertFalse(whiteKing.canMove(5, 3));
    assertFalse(whiteKing.canMove(5, 5));
  }

  @org.junit.jupiter.api.Test
  void testWhitePawnMoves() {
    // White pawn at row 1 (starting position)
    assertTrue(whitePawn.canMove(0, 3)); // one space forward
    assertFalse(whitePawn.canMove(-1, 3)); // two spaces forward (out of bounds)

    // White pawn not at starting position
    Pawn whitePawnMoved = new Pawn(3, 3, Color.WHITE);
    assertTrue(whitePawnMoved.canMove(2, 3)); // one space forward
    assertFalse(whitePawnMoved.canMove(1, 3)); // two spaces (not from start)
    assertFalse(whitePawnMoved.canMove(4, 3)); // backward
    assertFalse(whitePawnMoved.canMove(3, 4)); // sideways
  }

  @org.junit.jupiter.api.Test
  void testBlackPawnMoves() {
    // Black pawn at row 6 (starting position)
    assertTrue(blackPawn.canMove(7, 3)); // one space forward

    // Black pawn not at starting position
    Pawn blackPawnMoved = new Pawn(3, 3, Color.BLACK);
    assertTrue(blackPawnMoved.canMove(4, 3)); // one space forward
    assertFalse(blackPawnMoved.canMove(5, 3)); // two spaces (not from start)
    assertFalse(blackPawnMoved.canMove(2, 3)); // backward
    assertFalse(blackPawnMoved.canMove(3, 4)); // sideways
  }

  @org.junit.jupiter.api.Test
  void testPawnKillMoves() {
    Pawn whitePawnTest = new Pawn(3, 3, Color.WHITE);
    Pawn blackPawnDiagonal1 = new Pawn(2, 4, Color.BLACK);
    Pawn blackPawnDiagonal2 = new Pawn(2, 2, Color.BLACK);
    Pawn blackPawnStraight = new Pawn(2, 3, Color.BLACK);

    // Can kill diagonally forward
    assertTrue(whitePawnTest.canKill(blackPawnDiagonal1));
    assertTrue(whitePawnTest.canKill(blackPawnDiagonal2));

    // Cannot kill straight ahead
    assertFalse(whitePawnTest.canKill(blackPawnStraight));

    // Cannot kill backward
    Pawn blackPawnBehind = new Pawn(4, 4, Color.BLACK);
    assertFalse(whitePawnTest.canKill(blackPawnBehind));
  }

  @org.junit.jupiter.api.Test
  void testBoundaryValidation() {
    // Test invalid constructions
    assertThrows(IllegalArgumentException.class, () -> new Bishop(-1, 3, Color.WHITE));
    assertThrows(IllegalArgumentException.class, () -> new Knight(8, 3, Color.WHITE));
    assertThrows(IllegalArgumentException.class, () -> new Rook(3, -1, Color.WHITE));
    assertThrows(IllegalArgumentException.class, () -> new Queen(3, 8, Color.WHITE));
  }

  @org.junit.jupiter.api.Test
  void testPawnRoyalRowValidation() {
    // White pawns cannot be in row 0
    assertThrows(IllegalArgumentException.class, () -> new Pawn(0, 3, Color.WHITE));

    // Black pawns cannot be in row 7
    assertThrows(IllegalArgumentException.class, () -> new Pawn(7, 3, Color.BLACK));

    // Valid pawn positions
    assertDoesNotThrow(() -> new Pawn(1, 3, Color.WHITE));
    assertDoesNotThrow(() -> new Pawn(6, 3, Color.BLACK));
  }

  @org.junit.jupiter.api.Test
  void testCannotMoveToSamePosition() {
    assertFalse(whiteBishop.canMove(3, 3));
    assertFalse(whiteKnight.canMove(3, 3));
    assertFalse(whiteRook.canMove(3, 3));
    assertFalse(whiteQueen.canMove(3, 3));
    assertFalse(whiteKing.canMove(3, 3));
    assertFalse(whitePawn.canMove(1, 3));
  }

  @org.junit.jupiter.api.Test
  void testCannotKillSameColor() {
    Bishop whiteBishop2 = new Bishop(5, 5, Color.WHITE);
    assertFalse(whiteBishop.canKill(whiteBishop2));
    assertFalse(whiteKnight.canKill(whiteBishop));
    assertFalse(whiteRook.canKill(whiteQueen));
  }

  @org.junit.jupiter.api.Test
  void testCannotKillNull() {
    assertFalse(whiteBishop.canKill(null));
    assertFalse(whiteKnight.canKill(null));
    assertFalse(whiteRook.canKill(null));
    assertFalse(whiteQueen.canKill(null));
    assertFalse(whiteKing.canKill(null));
    assertFalse(whitePawn.canKill(null));
  }
}