/**
 * Abstract base class for all chess pieces.
 */
public abstract class ChessPiece implements ChessPieceContract {
  protected int row;
  protected int column;
  protected Color color;

  /**
   * Constructor for a chess piece.
   * @param row the initial row (0-7)
   * @param col the initial column (0-7)
   * @param color the color of the piece
   * @throws IllegalArgumentException if row or column is out of bounds
   */
  public ChessPiece(int row, int col, Color color) {
    if (row < 0 || row > 7 || col < 0 || col > 7) {
      throw new IllegalArgumentException("Position must be within bounds (0-7)");
    }
    this.row = row;
    this.column = col;
    this.color = color;
  }

  @Override
  public int getRow() {
    return row;
  }

  @Override
  public int getColumn() {
    return column;
  }

  @Override
  public Color getColor() {
    return color;
  }

  @Override
  public boolean canKill(ChessPiece piece) {
    // Can only kill pieces of opposite color
    if (piece == null || piece.getColor() == this.color) {
      return false;
    }
    // Can kill if we can move to that piece's position
    return canMove(piece.getRow(), piece.getColumn());
  }

  /**
   * Helper method to check if a move is diagonal.
   * @param toRow the target row
   * @param toCol the target column
   * @return true if the move is diagonal
   */
  protected boolean isDiagonalMove(int toRow, int toCol) {
    int rowDiff = Math.abs(toRow - this.row);
    int colDiff = Math.abs(toCol - this.column);
    return rowDiff == colDiff && rowDiff > 0;
  }

  /**
   * Helper method to check if a move is horizontal.
   * @param toRow the target row
   * @param toCol the target column
   * @return true if the move is horizontal
   */
  protected boolean isHorizontalMove(int toRow, int toCol) {
    return toRow == this.row && toCol != this.column;
  }

  /**
   * Helper method to check if a move is vertical.
   * @param toRow the target row
   * @param toCol the target column
   * @return true if the move is vertical
   */
  protected boolean isVerticalMove(int toRow, int toCol) {
    return toCol == this.column && toRow != this.row;
  }

  /**
   * Helper method to check if position is within board bounds.
   * @param row the row to check
   * @param col the column to check
   * @return true if position is valid
   */
  protected boolean isValidPosition(int row, int col) {
    return row >= 0 && row <= 7 && col >= 0 && col <= 7;
  }
}