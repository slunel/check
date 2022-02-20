
import checks.Color.{BLACK, WHITE}
import checks.utils.ColorUtils.oppositeColor
import checks.utils.PositionUtils._
import org.scalatest.funsuite._

class ColorUtilsTest extends AnyFunSuite{
  test("ColorUtils.oppositeColor") {
    assert(oppositeColor(WHITE) === BLACK)
    assert(oppositeColor(BLACK) === WHITE)
  }



}
