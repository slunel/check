package checks

import checks.Color._

import scala.language.postfixOps
import checks.utils.{BoardUtils, PositionUtils}

object Main extends App {
  println("Hello, initialisation of the board" )
  val board: Board = BoardUtils.init()
  println("End initialisation of the board" )
  println(board.toString())
  BoardUtils.printBoard(board)

  println("White to play")
  val positionFrom: Position = PositionUtils.RetrievePosFrom()
  val positionTo: Position = PositionUtils.RetrievePosTo()
  if (board.isLegalMove(positionFrom, positionTo, WHITE)) println("Successful move") else println("Unauthorized move, please retry")



//  if(board.isLegalMove(new Position(1, 3), new Position(2,5))) println("True") else println("false")
//  BoardUtils.move(new Position(1,3), new Position(2,4), board) match {
//    case Some(board) => BoardUtils.printBoard(board)
//    case None => println("Trouble")
//  }

/*
  val posFrom: Position = PositionUtils.RetrievePosFrom()
  // TODO Add guards
  println("you have chosen the position " + PositionUtils.PositionToString(posFrom) + " at coordinates " + posFrom.x.toString + posFrom.y.toString)
  val posTo: Position = PositionUtils.RetrievePosTo()

  val piece: Piece = new Piece(posFrom, WHITE)
  piece.move(posTo)
  */

}






