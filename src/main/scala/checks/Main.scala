package checks

import checks.Color._
import checks.Main.board
import checks.utils.PositionUtils.determinePositionToTake

import scala.language.postfixOps
import checks.utils.{BoardUtils, ColorUtils, PositionUtils, RuleUtils}

object Main extends App {
  println("Hello, initialisation of the board" )
  val board: Board = BoardUtils.init()
  println("End initialisation of the board" )

  // TODO use recursive function with parameter color
  // => TODO : termination condition -> forfeit or no pieces of color

  game(board, WHITE, "CONTINUE")

  // TODO use enumerations for message instead of string
  def game(board: Board, color: Color, message: String): Unit = {
    if(RuleUtils.hasNoPieces(board, color) || message == "END") println("End of game")
    else {
      BoardUtils.printBoard(board)
      println(s"${color} to play")
      // TODO rework to use val instead of var here
      var positionFrom: Position = new Position(0,0)
      PositionUtils.RetrievePosFrom() match {
        case Left(string) => if(string == "forfeit") {
          println(s"The player with ${color} color have abandoned")
          game(board, color, "END")
        } else {
          println("Invalid position, please retry")
          game(board, color, "CONTINUE")
          // TODO rework to use val instead of var here
        }
        case Right(position) => {
          positionFrom = position
          var positionTo: Position = new Position(0,0)
          PositionUtils.RetrievePosTo() match {
            case Left(string) => if(string == "forfeit") {
              println(s"The player with ${color} color have abandoned")
              game(board, color, "END")
            } else {
              println("Invalid position, please retry")
              game(board, color,"CONTINUE")
            }
            case Right(position) => {
              positionTo = position
              if (board.isLegalSimpleMove(positionFrom, positionTo, color)) {
                println("legal simple move")
                BoardUtils.move(positionFrom, positionTo, board) match {
                  case Some(newBoard) => game(newBoard, ColorUtils.oppositeColor(color), "CONTINUE")
                  case _ => println("Error")
                }
              } else if(board.isLegalTake(positionFrom, positionTo, color)) {
                println("legal take")
                BoardUtils.take(positionFrom, positionTo, board) match {
                  case Some(newBoard) => game(newBoard, ColorUtils.oppositeColor(color), "CONTINUE")
                  case _ => println("Error")
                }
              } else {
                println("illegal move, please retry")
                game(board, color,"CONTINUE")
              }
            }
          }

        }

      }

    }
  }






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






