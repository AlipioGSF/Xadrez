package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Horse extends ChessPiece {
	public Horse(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position p = new Position(0,0);
		
		//L(2A1W)
		p.setValues(position.getRow()-2 , position.getColumn()-1);
		while(getBoard().positionExits(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow()-2);
			p.setColumn(getMoveCount()-1);
		}
		if(getBoard().positionExits(p) && isThereAOponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		//L(1A2W)
		p.setValues(position.getRow()-1 , position.getColumn()-2);
		while(getBoard().positionExits(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow()-1);
			p.setColumn(getMoveCount()-2);
		}
		if(getBoard().positionExits(p) && isThereAOponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		//L(2A1E)
		p.setValues(position.getRow()-2 , position.getColumn()+1);
		while(getBoard().positionExits(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow()-1);
			p.setColumn(getMoveCount()-2);
		}
		if(getBoard().positionExits(p) && isThereAOponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		//L(1A2E)
		p.setValues(position.getRow()-1 , position.getColumn()+2);
		while(getBoard().positionExits(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow()-1);
			p.setColumn(getMoveCount()-2);
		}
		if(getBoard().positionExits(p) && isThereAOponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		//L(2B1W)
		p.setValues(position.getRow()+2 , position.getColumn()-1);
		while(getBoard().positionExits(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow()+2);
			p.setColumn(getMoveCount()-1);
		}
		if(getBoard().positionExits(p) && isThereAOponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		//L(1B2W)
		p.setValues(position.getRow()+1 , position.getColumn()-2);
		while(getBoard().positionExits(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow()+1);
			p.setColumn(getMoveCount()-2);
		}
		if(getBoard().positionExits(p) && isThereAOponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		//L(2B1E)
		p.setValues(position.getRow()+2 , position.getColumn()+1);
		while(getBoard().positionExits(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow()+2);
			p.setColumn(getMoveCount()+1);
		}
		if(getBoard().positionExits(p) && isThereAOponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		//L(1B2E)
		p.setValues(position.getRow()+1 , position.getColumn()+2);
		while(getBoard().positionExits(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow()+1);
			p.setColumn(getMoveCount()+2);
		}
		if(getBoard().positionExits(p) && isThereAOponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		
		return mat;
	}
	
	@Override
	public String toString() {
		return (getColor() == Color.WHITE) ? "h" : "H";
	}
}
