package checks.utils

import checks.Color._
import checks.{Board, Piece, Position}

object BoardUtils {
  def init(): Board = {
    val listPieces: List[Piece] = List(new Piece(new Position(1,1), WHITE))
    new Board(listPieces)
  }
}
