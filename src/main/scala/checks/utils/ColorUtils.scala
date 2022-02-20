package checks.utils

import checks.Color._

object ColorUtils {

  /**
   * Return the opposite color
   * @param color
   * @return
   */
  def oppositeColor(color: Color): Color = {
    if(color == WHITE) BLACK else WHITE
  }

}
