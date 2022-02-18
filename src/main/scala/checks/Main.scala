package checks

import checks.Color._
import checks.Main.board

import scala.language.postfixOps
import checks.utils.{BoardUtils, ColorUtils, PositionUtils, RuleUtils}

object Main extends App {
  println("Hello, initialisation of the board" )
  val board: Board = BoardUtils.init()
  println("End initialisation of the board" )

  // TODO use recursive function with parameter color
  // => TODO : termination condition -> forfeit or no pieces of color

  game(board, WHITE)

  def game(board: Board, color: Color): Unit = {
    if(RuleUtils.hasNoPieces(board, color)) println("End of game")
    else {
      BoardUtils.printBoard(board)
      println(s"${color} to play")
      val positionFrom: Position = PositionUtils.RetrievePosFrom()
      val positionTo: Position = PositionUtils.RetrievePosTo()
      if (board.isLegalMove(positionFrom, positionTo, color)) {
        println("legal move")
        BoardUtils.move(positionFrom, positionTo, board) match {
          case Some(newBoard) => game(newBoard, ColorUtils.oppositeColor(color))
          case _ =>
        }
      } else {
        println("illegal move, please retry")
        game(board, color)
      }
    }
  }



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






