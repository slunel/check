package checks

import java.util

import checks.Color.Color
import checks.utils.PositionUtils

class Piece(val position: Position, val color: Color) {
  var pos: Position = position

  def move(newPos: Position): Unit = {
    if(isLegalMove(pos, newPos)) {
      pos = newPos
    }
  }

  def isLegalMove(oldPos: Position, newPos: Position): Boolean = {
    (newPos.x == oldPos.x - 1 || newPos.x == oldPos.x - 1) && newPos.y == oldPos.y + 1
  }

  override def toString(): String = {
    val position: String = PositionUtils.PositionToString(pos)
    position + ", " + color
  }


}

object Color extends Enumeration {
  type Color = Value
  val WHITE = Value("White")
  val BLACK = Value("Black")
}