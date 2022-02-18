package checks.utils

import checks.Position

object PositionUtils {
  // TODO use stainless here?
  def StringToPosition(input: String): Position = {
    val y:Int = input(1).asDigit
    val x:Int = input(0) match {
      case 'a' => 1
      case 'b' => 2
      case 'c' => 3
      case 'd' => 4
      case 'e' => 5
      case 'f' => 6
      case 'g' => 7
      case 'h' => 8
    }
    new Position(x,y)
  }

  def PositionToString(position: Position):String = {
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

  def RetrievePosFrom():Position = {
    println("Please input the position of the piece you want to move")
    val input = scala.io.StdIn.readLine()
    PositionUtils.StringToPosition(input)
  }

  def RetrievePosTo():Position = {
    println("Please input the position where you want to move")
    val input = scala.io.StdIn.readLine()
    PositionUtils.StringToPosition(input)
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

}
