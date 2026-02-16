/**
 * Represents a Pawn chess piece.
 * A pawn can move forward one space (two from starting position),
 * but can only kill diagonally forward.
 */
public class Pawn extends ChessPiece {

  /**
   * Constructor for a Pawn.
   * @param row the initial row (0-7)
   * @param col the initial column (0-7)
   * @param color the color of the piece
   * @throws IllegalArgumentException if pawn is created in royal row
   */
  public Pawn(int row, int col, Color color) {
    super(row, col, color);

    // White pawns cannot be created in row 0, Black pawns cannot be in row 7
    if ((color == Color.WHITE && row == 0) || (color == Color.BLACK && row == 7)) {
      throw new IllegalArgumentException("Pawns cannot be created in their royal row");
    }
  }

  @Override
  public boolean canMove(int row, int col) {
    // Check if position is valid and not the current position
    if (!isValidPosition(row, col) || (row == this.row && col == this.column)) {
      return false;
    }

    // Must be in the same column (pawns move straight)
    if (col != this.column) {
      return false;
    }

    // Determine direction based on color
    // White moves up (decreasing row), Black moves down (increasing row)
    int direction = (color == Color.WHITE) ? -1 : 1;
    int startRow = (color == Color.WHITE) ? 1 : 6;

    int rowDiff = row - this.row;

    // Check if moving in correct direction
    if (rowDiff * direction <= 0) {
      return false; // Moving backwards or not moving
    }

    // Can move one space forward
    if (rowDiff == direction) {
      return true;
    }

    // Can move two spaces forward only from starting position
    if (this.row == startRow && rowDiff == 2 * direction) {
      return true;
    }

    return false;
  }

  @Override
  public boolean canKill(ChessPiece piece) {
    // Can only kill pieces of opposite color
    if (piece == null || piece.getColor() == this.color) {
      return false;
    }

    int targetRow = piece.getRow();
    int targetCol = piece.getColumn();

    // Pawn kills diagonally forward (one space)
    int direction = (color == Color.WHITE) ? -1 : 1;
    int rowDiff = targetRow - this.row;
    int colDiff = Math.abs(targetCol - this.column);

    // Must be one space forward diagonally
    return rowDiff == direction && colDiff == 1;
  }
}