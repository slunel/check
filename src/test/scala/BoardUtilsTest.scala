

import checks.Color.{BLACK, WHITE}
import checks.utils.BoardUtils
import checks.{Board, Piece, Position}
import org.scalatest.funsuite._

class BoardUtilsTest extends AnyFunSuite{
  val listPieces: List[Piece] = List(Piece(Position(1,1), WHITE),Piece(Position(5,1), BLACK))
  val board: Board = new Board(listPieces)

  test("BoardUtils.removePiece") {
    val listPiecesSubstracted: List[Piece] = List(Piece(Position(1,1), WHITE))
    val boardSubstracted: Board = new Board(listPiecesSubstracted)
    assert(BoardUtils.removePiece(board, Piece(Position(5,1), BLACK)) === boardSubstracted)
    assert(BoardUtils.removePiece(boardSubstracted, Piece(Position(1,1), WHITE)) === new Board(Nil))
    assert(BoardUtils.removePiece(board, Piece(Position(4,8), BLACK)) === board)
  }

  test("BoardUtils.addPiece") {
    val listPiecesAdditioned: List[Piece] = List(Piece(Position(1,1), WHITE),Piece(Position(5,1), BLACK),Piece(Position(3,8), BLACK))
    val boardAdditioned: Board = new Board(listPiecesAdditioned)
    assert(BoardUtils.addPiece(board, Piece(Position(3,8), BLACK)) === boardAdditioned)
    assert(BoardUtils.addPiece(board, Piece(Position(4,8), BLACK)) === board)
  }


}
