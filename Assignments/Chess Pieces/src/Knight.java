/**
 * Represents a Knight chess piece.
 * A knight moves in an L pattern: 2 cells in one direction and 1 cell perpendicular.
 */
public class Knight extends ChessPiece {

  /**
   * Constructor for a Knight.
   * @param row the initial row (0-7)
   * @param col the initial column (0-7)
   * @param color the color of the piece
   */
  public Knight(int row, int col, Color color) {
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

    // Knight moves in L shape: (2,1) or (1,2)
    return (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2);
  }
}