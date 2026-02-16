/**
 * Represents a Rook chess piece.
 * A rook can move horizontally or vertically.
 */
public class Rook extends ChessPiece {

  /**
   * Constructor for a Rook.
   * @param row the initial row (0-7)
   * @param col the initial column (0-7)
   * @param color the color of the piece
   */
  public Rook(int row, int col, Color color) {
    super(row, col, color);
  }

  @Override
  public boolean canMove(int row, int col) {
    // Check if position is valid and not the current position
    if (!isValidPosition(row, col) || (row == this.row && col == this.column)) {
      return false;
    }
    // Rook can move horizontally or vertically
    return isHorizontalMove(row, col) || isVerticalMove(row, col);
  }
}