package checks.utils

import checks.Color._
import checks.{Board, Piece}

object ColorUtils {

  def oppositeColor(color: Color): Color = {
    if(color == WHITE) BLACK else WHITE
  }



}
