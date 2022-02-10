package checks

import checks.Color._

import scala.language.postfixOps
import checks.utils.{BoardUtils, PositionUtils}

object Main extends App {
  println("Hello, initialisation of the board" )
  val board: Board = BoardUtils.init()
  println("End initialisation of the board" )
  println(board.toString())

  println("Hello, you are playing the whites" )

  val posFrom: Position = PositionUtils.RetrievePosFrom()
  // TODO Add guards
  println("you have chosen the position " + PositionUtils.PositionToString(posFrom) + " at coordinates " + posFrom.x.toString + posFrom.y.toString)
  val posTo: Position = PositionUtils.RetrievePosTo()

  val piece: Piece = new Piece(posFrom, WHITE)
  piece.move(posTo)

}

class Board(val listPieces: List[Piece]) {
  val list: List[Piece] = listPieces

  override def toString(): String = {
    list.mkString(",")
  }

}




