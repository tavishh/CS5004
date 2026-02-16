/**
 * Represents a Bishop chess piece.
 * A bishop can only move diagonally.
 */
public class Bishop extends ChessPiece {

  /**
   * Constructor for a Bishop.
   * @param row the initial row (0-7)
   * @param col the initial column (0-7)
   * @param color the color of the piece
   */
  public Bishop(int row, int col, Color color) {
    super(row, col, color);
  }

  @Override
  public boolean canMove(int row, int col) {
    // Check if position is valid and not the current position
    if (!isValidPosition(row, col) || (row == this.row && col == this.column)) {
      return false;
    }
    // Bishop can only move diagonally
    return isDiagonalMove(row, col);
  }
}