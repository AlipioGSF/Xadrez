package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	ChessMatch chessMatch;
	
	public Pawn(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

	public ChessMatch getChessMatch() {
		return chessMatch;
	}


	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position p = new Position(0,0);
		
		if(getColor() == Color.WHITE) {
			p.setValues(position.getRow() - 1, position.getColumn());
			if(getBoard().positionExits(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			p.setValues(position.getRow() - 2, position.getColumn());
			Position p2 = new Position(position.getRow() - 1, position.getColumn());
			if(getBoard().positionExits(p) && !getBoard().thereIsAPiece(p) && getMoveCount() == 0 && getBoard().positionExits(p2) && !getBoard().thereIsAPiece(p2)) { 
				mat[p.getRow()][p.getColumn()] = true;
			
			}
			p.setValues(position.getRow()-1, position.getColumn()-1);
			if(getBoard().positionExits(p) && isThereAOponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			p.setValues(position.getRow()-1, position.getColumn()+1);
			if(getBoard().positionExits(p) && isThereAOponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			//#Special Move enPassant
			if(position.getRow() == 3){
				Position left = new Position(position.getRow(), position.getColumn() - 1);
				if(getBoard().positionExits(left) && isThereAOponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVunerable()) {
					mat[left.getRow()-1][left.getColumn()] = true;
				}
				Position right = new Position(position.getRow(), position.getColumn() + 1);
				if(getBoard().positionExits(right) && isThereAOponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVunerable()) {
					mat[right.getRow()-1][right.getColumn()] = true;
				}
			
			}
			
		}else {
			p.setValues(position.getRow() + 1, position.getColumn());
			if(getBoard().positionExits(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			p.setValues(position.getRow() + 2, position.getColumn());
			Position p2 = new Position(position.getRow() + 1, position.getColumn());
			if(getBoard().positionExits(p) && !getBoard().thereIsAPiece(p) && getMoveCount() == 0 && getBoard().positionExits(p2) && !getBoard().thereIsAPiece(p2)) { 
				mat[p.getRow()][p.getColumn()] = true;
			
			}
			p.setValues(position.getRow()+1, position.getColumn()-1);
			if(getBoard().positionExits(p) && isThereAOponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			p.setValues(position.getRow()+1, position.getColumn()-1);
			if(getBoard().positionExits(p) && isThereAOponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			//#Special Move enPassant
			if(position.getRow() == 4){
				Position left = new Position(position.getRow(), position.getColumn() + 1);
				if(getBoard().positionExits(left) && isThereAOponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVunerable()) {
					mat[left.getRow()+1][left.getColumn()] = true;
				}
				Position right = new Position(position.getRow(), position.getColumn() - 1);
				if(getBoard().positionExits(right) && isThereAOponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVunerable()) {
					mat[right.getRow()+1][right.getColumn()] = true;
				}
			
			}
			
			
			
		}
		return mat;
	}
	
	@Override
	public String toString() {
		return (getColor() == Color.WHITE) ? "p" : "P";
	}
	
	
	
}
