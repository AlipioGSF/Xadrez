package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece{

	private ChessMatch chessMatch;
	
	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}
	
	public ChessMatch getChessMatch() {
		return chessMatch;
	}

	public boolean canMove(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}
	
	private boolean testRookCastling(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
	}
	
	
	@Override
	public String toString() {
		if(super.getColor() == Color.WHITE) return "k";
		return "K";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position p = new Position(0,0);
		
		//Above
		p.setValues(position.getRow() - 1 , position.getColumn());
		if(getBoard().positionExits(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		//Below
		p.setValues(position.getRow() + 1 , position.getColumn());
		if(getBoard().positionExits(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		//Left
		p.setValues(position.getRow(), position.getColumn() - 1);
		if(getBoard().positionExits(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		//Right
		p.setValues(position.getRow(), position.getColumn() + 1);
		if(getBoard().positionExits(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		//NW
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		if(getBoard().positionExits(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		//NE
		p.setValues(position.getRow()  - 1, position.getColumn() + 1);
		if(getBoard().positionExits(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}		
		//SW
		p.setValues(position.getRow()  + 1, position.getColumn() - 1);
		if(getBoard().positionExits(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}		
		//SE
		p.setValues(position.getRow()  + 1, position.getColumn() + 1);
		if(getBoard().positionExits(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}		

		
		// #specialmove - castling
		if(getMoveCount() == 0 && !chessMatch.isCheck()) {
			// #specialmove castling kingside
			Position posTK = new Position(position.getRow(), position.getColumn() + 3);
			if(testRookCastling(posTK)) {
				Position p1 = new Position(position.getRow(), position.getColumn() + 2);
				Position p2 = new Position(position.getRow(), position.getColumn() + 1);
				if(canMove(p1) && canMove(p2) ) {
					mat[position.getRow()][position.getColumn() + 2] = true;
				}
			}
			
			// #specialmove castlign queenside
			Position posTQ = new Position(position.getRow(), position.getColumn() - 4);
			if(testRookCastling(posTK)) {
				Position p1 = new Position(position.getRow(), position.getColumn() - 1);
				Position p2 = new Position(position.getRow(), position.getColumn() - 2);
				Position p3 = new Position(position.getRow(), position.getColumn() - 3);
				if(canMove(p1) && canMove(p2) && canMove(p3)) {
					mat[position.getRow()][position.getColumn() - 2] = true;
				}
			}
			
		}
		
		
		
		
		
		
		return mat;
	}


}
