package checks.utils

import checks.Position

object PositionUtils {

  /**
   * Return a position if the input string is a valid position,
   * i.e. of the form 'xn' x being a character between 'a' and 'h' and n a digit between 1 and 8
   * @param input
   * @return a position if valid position,note otherwise
   */
  def stringToPosition(input: String): Option[Position] = {
    try{
      if(input.size != 2) throw InvalidPositionException("Invalid position exception")
      val x:Int = input(0) match {
        case 'a' => 1
        case 'b' => 2
        case 'c' => 3
        case 'd' => 4
        case 'e' => 5
        case 'f' => 6
        case 'g' => 7
        case 'h' => 8
        case _ => throw InvalidPositionException("Invalid position exception")
      }
      val y:Int = input(1).asDigit
      if(y > 8 || y < 1) throw InvalidPositionException("Invalid position exception")
      Some(new Position(x,y))
    } catch {
      case e: InvalidPositionException => None
    }
  }

  /**
   * Convert a position to a human readable string
   * ex: Position(1,3) -> a3
   * @param position
   * @return
   */
  def positionToString(position: Position):String = {
    val x: Int = position.x
    val xString: String = x match {
      case 1 => "a"
      case 2 => "b"
      case 3 => "c"
      case 4 => "d"
      case 5 => "e"
      case 6 => "f"
      case 7 => "g"
      case 8 => "h"
    }
    val y: String = position.y.toString
    xString + y
  }

  /**
   * Ask the user to input the position of the piece she wants to move
   * @return a position if valid position, the input string otherwise
   */
  def retrievePosFrom():Either[String,Position] = {
    println("Please input the position of the piece you want to move")
    val input = scala.io.StdIn.readLine()
    PositionUtils.stringToPosition(input) match {
      case Some(position) => Right(position)
      case None => Left(input)
    }
  }

  /**
   * Ask the user to input the position where she wants to move the piece
   * @return a position if valid position, the input string otherwise
   */
  def RetrievePosTo():Either[String,Position] = {
    println("Please input the position where you want to move")
    val input = scala.io.StdIn.readLine()
    PositionUtils.stringToPosition(input) match {
      case Some(position) => Right(position)
      case None => Left(input)
    }
  }

  /**
   * Determine the position of the piece that would be taken by the move from positionFrom to positionTo
   * @param positionFrom
   * @param positionTo
   * @return the position between positionFrom and positionTo
   */
  def determinePositionToTake(positionFrom: Position, positionTo: Position): Position = {
    val xFrom: Int = positionFrom.x
    val yFrom: Int = positionFrom.y
    val xTo: Int = positionTo.x
    val yTo: Int = positionTo.y
    if (xFrom > xTo && yFrom > yTo) {new Position(xFrom-1, yFrom-1)}
    else if (xFrom > xTo && yFrom < yTo) {new Position(xFrom-1, yFrom+1)}
    else if (xFrom < xTo && yFrom < yTo) {new Position(xFrom+1, yFrom+1)}
    else {new Position(xFrom+1, yFrom-1)}
  }

  case class InvalidPositionException(str: String) extends Exception
}
