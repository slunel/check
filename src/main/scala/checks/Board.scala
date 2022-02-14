package checks

import checks.Color.WHITE
import checks.utils.BoardUtils

class Board(val listPieces: List[Piece]) {
  val list: List[Piece] = listPieces

  override def toString(): String = {
    list.mkString(",")
  }

  /**
   * Determine if a white piece can simply advance
   * @param positionFrom
   * @param positionTo
   * @return true if there is no piece at the desired position and the move satisfies check's rules, false otherwise
   */
  def isLegalSimpleMoveWhite(positionFrom: Position, positionTo: Position): Boolean = {
    BoardUtils.getPiece(positionTo, listPieces) match {
      case Some(_) => false
      case None => (positionFrom.x == positionTo.x - 1 || positionFrom.x == positionTo.x - 1) && (positionFrom.y == positionTo.y + 1)
    }
  }

  /**
   * Determine if a black piece can simply advance
   * @param positionFrom
   * @param positionTo
   * @return true if there is no piece at the desired position and the move satisfies check's rules, false otherwise
   */
  def isLegalSimpleMoveBlack(positionFrom: Position, positionTo: Position): Boolean = {
    BoardUtils.getPiece(positionTo, listPieces) match {
      case Some(_) => false
      case None => (positionFrom.x == positionTo.x - 1 || positionFrom.x == positionTo.x - 1) && (positionFrom.y == positionTo.y - 1)
    }
  }

  def isLegalSimpleMove(positionFrom: Position, positionTo: Position): Boolean = {
    BoardUtils.getPiece(positionFrom, listPieces) match {
      case Some(piece: Piece) => if(piece.col == WHITE) isLegalSimpleMoveWhite(positionFrom, positionTo) else isLegalSimpleMoveBlack(positionFrom, positionTo)
      case _ => false
    }
  }

  def isLegalTakeMove(positionFrom: Position, positionTo: Position): Boolean = {
    BoardUtils.getPiece(positionTo, listPieces) match {
      case Some(_) => false
      case None => (positionFrom.x == positionTo.x - 2 || positionFrom.x == positionTo.x - 2) && (positionFrom.y == positionTo.y + 2 || positionFrom.y == positionTo.y - 2)
    }
  }

  def determinePositionToTake(positionFrom: Position, positionTo: Position): Position = {
    val xFrom: Int = positionFrom.x
    val yFrom: Int = positionFrom.y
    val xTo: Int = positionTo.x
    val yTo: Int = positionTo.y
    if (xFrom > xTo && yFrom > yTo) {new Position(xFrom+1, yFrom+1)}
    else if (xFrom > xTo && yFrom < yTo) {new Position(xFrom+1, yFrom-1)}
    else if (xFrom < xTo && yFrom < yTo) {new Position(xFrom-1, yFrom-1)}
    else {new Position(xFrom-1, yFrom+1)}
  }

  def isLegalTakePiece(positionFrom: Position, positionTo: Position): Boolean = {
    val positionToTake: Position = determinePositionToTake(positionFrom, positionTo)
    BoardUtils.getPiece(positionFrom, listPieces) match {
      case Some(pieceFrom: Piece) => BoardUtils.getPiece(positionToTake, listPieces) match {
        case Some(pieceToTake: Piece) => pieceFrom.col == pieceToTake.col
        case None => false
      }
      case None => false
    }
  }

  def isLegalTake(positionFrom: Position, positionTo: Position): Boolean = {
    isLegalTakeMove(positionFrom, positionTo) && isLegalTakePiece(positionFrom, positionTo)
  }

  def isLegalMove(positionFrom: Position, positionTo: Position): Boolean = {
    isLegalSimpleMove(positionFrom, positionTo) && isLegalTake(positionFrom, positionTo)
  }





}
