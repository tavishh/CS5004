/**
 * Contract for all chess pieces.
 */
public interface ChessPieceContract {

  /**
   * Returns the current row of this chess piece.
   * @return the row (0-7)
   */
  int getRow();

  /**
   * Returns the current column of this chess piece.
   * @return the column (0-7)
   */
  int getColumn();

  /**
   * Returns the color of this chess piece.
   * @return the color (BLACK or WHITE)
   */
  Color getColor();

  /**
   * Determines if this chess piece can move to the given cell.
   * @param row the target row
   * @param col the target column
   * @return true if the piece can move to (row, col), false otherwise
   */
  boolean canMove(int row, int col);

  /**
   * Determines if this chess piece can kill the given piece.
   * @param piece the target piece to potentially kill
   * @return true if this piece can kill the given piece, false otherwise
   */
  boolean canKill(ChessPiece piece);
}