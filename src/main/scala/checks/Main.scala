package checks

import checks.Color._

import scala.language.postfixOps
import checks.utils.{BoardUtils, PositionUtils, RuleUtils}

object Main extends App {
  println("Hello, initialisation of the board" )
  val board: Board = BoardUtils.init()
  println("End initialisation of the board" )
  println(board.toString())
  BoardUtils.printBoard(board)

  println("White to play")
  // TODO use recursive function with parameter color
  // => TODO : termination condition -> forfeit or no pieces of color
  val positionFrom: Position = PositionUtils.RetrievePosFrom()
  val positionTo: Position = PositionUtils.RetrievePosTo()
  if (board.isLegalMove(positionFrom, positionTo, BLACK)) println("Successful move") else println("Unauthorized move, please retry")
  if(RuleUtils.hasNoPieces(board, BLACK)) println("End of game") else println("We can continue")





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






