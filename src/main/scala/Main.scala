import scala.language.postfixOps

object Main extends App {
  println("Hello, you are playing the whites" )

  val posFrom: Position = RetrievePosFrom()
  val posTo: Position = RetrievePosTo()

  val piece: Piece = new Piece(posFrom)
  piece.move(posTo)



  // Move to a new location

  def RetrievePosFrom():Position = {
    println("Please input the x position of the piece you want to move")
    val x = scala.io.StdIn.readInt()
    println("You have chosen the x position: " + x)
    println("Please input the y position of the piece you want to move")
    val y = scala.io.StdIn.readInt()
    println("You have chosen the y position: " + y)
    new Position(x,y)
  }

  def RetrievePosTo():Position = {
    println("Please input the x position where you want to move")
    val x = scala.io.StdIn.readInt()
    println("You have chosen the x position: " + x)
    println("Please input the y position where you want to move")
    val y = scala.io.StdIn.readInt()
    println("You have chosen the y position: " + y)
    new Position(x,y)
  }


}


class Position(val xc: Int, val yc: Int) {
  val x: Int = xc
  val y: Int = yc

  def isLegalPosition(): Boolean = {
    x > 0 && x < 9 && y > 0 && y < 9
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

