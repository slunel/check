package checks

class Position(val xc: Int, val yc: Int) {
  val x: Int = xc
  val y: Int = yc

  def isLegalPosition(): Boolean = {
    x > 0 && x < 9 && y > 0 && y < 9
  }




}