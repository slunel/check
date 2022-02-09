import scala.language.postfixOps

object Main extends App {
  println("Hello, you are playing the whites" )

  val posFrom: Position = RetrievePosFrom()
  println("you have chosen the position " + PositionUtils.PositionToString(posFrom) + " at coordinates " + posFrom.x.toString + posFrom.y.toString)
  val posTo: Position = RetrievePosTo()

  val piece: Piece = new Piece(posFrom)
  piece.move(posTo)



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

}


class Position(val xc: Int, val yc: Int) {
  val x: Int = xc
  val y: Int = yc

  def isLegalPosition(): Boolean = {
    x > 0 && x < 9 && y > 0 && y < 9
  }
}

object PositionUtils {
  def StringToPosition(input: String):Position = {
    val y:Int = input(1).asDigit
    val x:Int = input(0) match {
      case 'a' => 1
      case 'b' => 2
    }
    new Position(x,y)
  }

  def PositionToString(position: Position):String = {
    val x: Int = position.x
    val xString: String = x match {
      case 1 => "a"
      case 2 => "b"
    }
    val y: String = position.y.toString
    xString + y
  }
}

class Piece(val position: Position) {
  var pos: Position = position

  def move(newPos: Position): Unit = {
    if(isLegalMove(pos, newPos)) {
      pos = newPos
    }
  }

  def isLegalMove(oldPos: Position, newPos: Position): Boolean = {
    (newPos.x == oldPos.x - 1 || newPos.x == oldPos.x - 1) && newPos.y == oldPos.y + 1
  }

}

