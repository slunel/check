
import checks.Position
import checks.utils.PositionUtils._
import org.scalatest.funsuite._

class PositionUtilsTest extends AnyFunSuite{
  test("PositionUtils.stringToPosition") {
    assert(stringToPosition("a3") === Some(Position(1,3)))
    assert(stringToPosition("a35") === None)
    assert(stringToPosition("a") === None)
    assert(stringToPosition("forfeit") === None)
  }

  test("PositionUtils.positionToString") {
    assert(positionToString(new Position(1,1)) === "a1")
    assert(positionToString(new Position(5,8)) === "e8")
  }


}
