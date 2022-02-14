package checks

import checks.Color.Color
import checks.utils.PositionUtils

class Piece(val position: Position, val color: Color) {
  private var pos: Position = position
  val col: Color = color

  override def toString(): String = {
    val position: String = PositionUtils.PositionToString(pos)
    position + ", " + color
  }

  def getPos(): Position = pos
  def setPos(position: Position) { pos = position }


}

object Color extends Enumeration {
  type Color = Value
  val WHITE = Value("White")
  val BLACK = Value("Black")
}