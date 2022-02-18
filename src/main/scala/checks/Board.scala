package checks

import checks.Color.{BLACK, Color, WHITE}
import checks.Main.executionStart.==
import checks.utils.{BoardUtils, PositionUtils}
import checks.utils.PositionUtils.determinePositionToTake

class Board(val listPieces: List[Piece]) {
  val list: List[Piece] = listPieces

  override def toString(): String = {
    list.mkString(",")
  }

  /**
   * Determine if a white piece can simply advance from positionFrom to positionTo
   * @param positionFrom
   * @param positionTo
   * @return true if there is no piece at the desired position and the move satisfies check's rules, false otherwise
   */
  def isLegalSimpleMoveWhite(positionFrom: Position, positionTo: Position): Boolean = {
    BoardUtils.getPiece(positionTo, listPieces) match {
      case Some(_) => false
      case None => (positionFrom.x == positionTo.x - 1 || positionFrom.x == positionTo.x + 1) && (positionFrom.y == positionTo.y - 1)
    }
  }

  /**
   * Determine if a black piece can simply advance from positionFrom to positionTo
   * @param positionFrom
   * @param positionTo
   * @return true if there is no piece at the desired position and the move satisfies check's rules, false otherwise
   */
  def isLegalSimpleMoveBlack(positionFrom: Position, positionTo: Position): Boolean = {
    BoardUtils.getPiece(positionTo, listPieces) match {
      case Some(_) => false
      case None => (positionFrom.x == positionTo.x - 1 || positionFrom.x == positionTo.x + 1) && (positionFrom.y == positionTo.y + 1)
    }
  }

  /**
   * Determine if a white or black piece can simply advance from positionFrom to positionTo
   * @param positionFrom
   * @param positionTo
   * @param color the color of the current player
   * @return true if there is no piece at the desired position and the move satisfies check's rules, false otherwise
   */
  def isLegalSimpleMove(positionFrom: Position, positionTo: Position, color: Color): Boolean = {
    BoardUtils.getPiece(positionFrom, listPieces) match {
      case Some(piece: Piece) =>
        if(piece.col == WHITE)
          isLegalSimpleMoveWhite(positionFrom, positionTo) && WHITE == color
        else isLegalSimpleMoveBlack(positionFrom, positionTo) && color == BLACK
      case _ => false
    }
  }

  /**
   * Determine if a move to take a piece is legal
   * @param positionFrom
   * @param positionTo
   * @return true if the move satisfies check's rules, false otherwise
   */
  def isLegalTakeMove(positionFrom: Position, positionTo: Position): Boolean = {
    BoardUtils.getPiece(positionTo, listPieces) match {
      case Some(_) => false
      case None => (positionFrom.x == positionTo.x + 2 || positionFrom.x == positionTo.x - 2) && (positionFrom.y == positionTo.y + 2 || positionFrom.y == positionTo.y - 2)
    }
  }

  def isLegalTakePiece(positionFrom: Position, positionTo: Position, color: Color): Boolean = {
    val positionToTake: Position = determinePositionToTake(positionFrom, positionTo)
    BoardUtils.getPiece(positionFrom, listPieces) match {
      case Some(pieceFrom: Piece) => BoardUtils.getPiece(positionToTake, listPieces) match {
        case Some(pieceToTake: Piece) => (pieceFrom.col != pieceToTake.col) && (pieceFrom.col == color)
        case None => false
      }
      case None => false
    }
  }

  def isLegalTake(positionFrom: Position, positionTo: Position, color: Color): Boolean = {
    isLegalTakeMove(positionFrom, positionTo) && isLegalTakePiece(positionFrom, positionTo, color)
  }

  def isLegalMove(positionFrom: Position, positionTo: Position, color: Color): Boolean = {
    isLegalSimpleMove(positionFrom, positionTo, color)  || isLegalTake(positionFrom, positionTo, color)
  }

}
