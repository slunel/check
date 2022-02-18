package checks.utils

import checks.Color._
import checks.{Board, Piece, Position}

object BoardUtils {

  /**
   * Initialize a board
   * @return a board initialized
   */
  def init(): Board = {
    val listPieces: List[Piece] =
      List(new Piece(new Position(1,1), WHITE),
        new Piece(new Position(3,1), WHITE),
        new Piece(new Position(5,1), WHITE),
        new Piece(new Position(7,1), WHITE),
        new Piece(new Position(2,2), WHITE),
        new Piece(new Position(4,2), WHITE),
        new Piece(new Position(6,2), WHITE),
        new Piece(new Position(8,2), WHITE),
        new Piece(new Position(1,3), WHITE),
        new Piece(new Position(3,3), WHITE),
        new Piece(new Position(5,3), WHITE),
        new Piece(new Position(7,3), WHITE),
        new Piece(new Position(2,6), BLACK),
        new Piece(new Position(4,6), BLACK),
        new Piece(new Position(6,6), BLACK),
        new Piece(new Position(8,6), BLACK),
        new Piece(new Position(1,7), BLACK),
        new Piece(new Position(3,7), BLACK),
        new Piece(new Position(5,7), BLACK),
        new Piece(new Position(7,7), BLACK),
        new Piece(new Position(2,8), BLACK),
        new Piece(new Position(4,8), BLACK),
        new Piece(new Position(6,8), BLACK),
        new Piece(new Position(8,8), BLACK)
      )
    new Board(listPieces)
  }

  // TODO
  /*
  def initPieces(color: Color): List[Piece] = {

  }
  */

  /**
   * Pretty print a line
   * @param lineNumber
   * @param pieces
   */
  def printLine(lineNumber: Int, pieces: List[Piece]): Unit = {
    val positionsX: List[(Int, Int, Color)] = pieces.map(p => (p.getPos().x, p.getPos().y, p.col))
    val line:List[Int] = List(1,2,3,4,5,6,7,8)
    val lineString:List[String] = line.map(x => {
      if(positionsX.contains((x, lineNumber, WHITE))) { "W" }
      else if(positionsX.contains((x, lineNumber, BLACK))) { "B" }
      else { " "}
    })
    val lineToPrint: String = lineNumber.toString + " |" + lineString.mkString("|") + "|"
    println(lineToPrint)
  }

  /**
   * Pretty print a board
   * @param board
   */
  def printBoard(board:Board): Unit = {
    val pieces: List[Piece] = board.listPieces
    for(y <- 1 to 8) {
      printLine(y,pieces)
    }
    println("   a b c d e f g h")
  }

  def isPositionOccupied(position: Position, board: Board): Boolean = {
    val positionsOfBoard: List[(Int, Int)] = board.listPieces.map(p => (p.getPos().x, p.getPos().y))
    positionsOfBoard.contains((position.x, position.y))
  }

  def getPiece(position: Position, board: Board): Option[Piece] = {
    board.listPieces.find(p => p.getPos().x == position.x && p.getPos().y == position.y)
  }

  /**
   * Get the piece at position from a list of pieces
   * @param position
   * @param listPieces
   * @return the piece at position position
   */
  def getPiece(position: Position, listPieces: List[Piece]): Option[Piece] = {
    listPieces.find(p => p.getPos().x == position.x && p.getPos().y == position.y)
  }

  /**
   * Move a piece from positionFrom to positionTo
   * @param positionFrom
   * @param positionTo
   * @param board
   * @return the board updated
   */
  def move(positionFrom: Position, positionTo: Position, board: Board): Option[Board] = {
    getPiece(positionFrom, board) match {
      case Some(piece) => {
        val listPiecesUpdated: List[Piece] = board.listPieces.map(p => {
          if(p.getPos().x == piece.getPos().x && p.getPos().y == piece.getPos().y) {p.setPos(positionTo); p}
          else {p}
        } )
        Some(new Board(listPiecesUpdated))
      }
      case None => None
    }
  }

  /**
   * Remove the piece at positionToTake from the board
   * This method does not check if it is a legal move
   * @param positionToTake
   * @param board
   * @return the board without the piece
   */
  def take(positionToTake: Position, board: Board): Option[Board] = {
    getPiece(positionToTake, board) match {
      case Some(piece) => {
        val listPiecesUpdated: List[Piece] = board.listPieces.filter(p => p.getPos().x != piece.getPos().x && p.getPos().y != piece.getPos().y)
        Some(new Board(listPiecesUpdated))
      }
      case None => None
    }
  }




}
