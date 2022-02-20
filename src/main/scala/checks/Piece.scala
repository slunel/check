package checks

import checks.Color.Color

//class Piece(val position: Position, val color: Color) {
//  private var pos: Position = position
//  val col: Color = color
//
//  override def toString(): String = {
//    val position: String = PositionUtils.positionToString(pos)
//    position + ", " + color
//  }
//
//  def getPos(): Position = pos
//  def setPos(position: Position) { pos = position }
//
//}

case class Piece(position: Position, color: Color)

object Color extends Enumeration {
  type Color = Value
  val WHITE = Value("White")
  val BLACK = Value("Black")
}