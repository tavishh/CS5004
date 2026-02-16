/**
 * Represents a King chess piece.
 * A king can move horizontally, vertically, and diagonally, but only one space at a time.
 */
public class King extends ChessPiece {

  /**
   * Constructor for a King.
   * @param row the initial row (0-7)
   * @param col the initial column (0-7)
   * @param color the color of the piece
   */
  public King(int row, int col, Color color) {
    super(row, col, color);
  }

  @Override
  public boolean canMove(int row, int col) {
    // Check if position is valid and not the current position
    if (!isValidPosition(row, col) || (row == this.row && col == this.column)) {
      return false;
    }

    int rowDiff = Math.abs(row - this.row);
    int colDiff = Math.abs(col - this.column);

    // King can move one space in any direction
    return rowDiff <= 1 && colDiff <= 1;
  }
}