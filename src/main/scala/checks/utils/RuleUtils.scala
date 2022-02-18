package checks.utils

import checks.Color._
import checks.{Board, Piece, Position}

object RuleUtils {


  /**
   * Test if a player has no pieces left
   * @param board
   * @param color
   * @return true if there is no pieces
   */
  def hasNoPieces(board: Board, color: Color): Boolean = {
    val listPieces: List[Piece] = board.listPieces
    !(listPieces.exists(p => p.col == color))
  }



}
