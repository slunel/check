
import checks.Position
import checks.utils.PositionUtils
import org.scalatest.funsuite._

class PositionUtilsTest extends AnyFunSuite{
  test("PositionUtils.PositionToString") {
    assert(PositionUtils.PositionToString(new Position(1,1)) === "a1")
  }
}
