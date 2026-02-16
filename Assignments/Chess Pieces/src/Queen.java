/**
 * Represents a Queen chess piece.
 * A queen can move horizontally, vertically, and diagonally (unlimited distance).
 */
public class Queen extends ChessPiece {

  /**
   * Constructor for a Queen.
   * @param row the initial row (0-7)
   * @param col the initial column (0-7)
   * @param color the color of the piece
   */
  public Queen(int row, int col, Color color) {
    super(row, col, color);
  }

  @Override
  public boolean canMove(int row, int col) {
    // Check if position is valid and not the current position
    if (!isValidPosition(row, col) || (row == this.row && col == this.column)) {
      return false;
    }
    // Queen can move horizontally, vertically, or diagonally
    return isHorizontalMove(row, col) || isVerticalMove(row, col) || isDiagonalMove(row, col);
  }
}