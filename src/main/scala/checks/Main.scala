package checks

import checks.Color._

import scala.language.postfixOps
import checks.utils.{BoardUtils, PositionUtils}

object Main extends App {
  println("Hello, initialisation of the board" )
  val board: Board = BoardUtils.init()
  println("End initialisation of the board" )
  println(board.toString())
  //BoardUtils.printLine(1,board.listPieces)
  BoardUtils.printBoard(board)
  if(board.isLegalMove(new Position(1, 3), new Position(2,5))) println("True") else println("false")
  BoardUtils.move(new Position(1,3), new Position(2,4), board) match {
    case Some(board) => BoardUtils.printBoard(board)
    case None => println("Trouble")
  }


  println("Hello, you are playing the whites" )
/*
  val posFrom: Position = PositionUtils.RetrievePosFrom()
  // TODO Add guards
  println("you have chosen the position " + PositionUtils.PositionToString(posFrom) + " at coordinates " + posFrom.x.toString + posFrom.y.toString)
  val posTo: Position = PositionUtils.RetrievePosTo()

  val piece: Piece = new Piece(posFrom, WHITE)
  piece.move(posTo)
  */

}






