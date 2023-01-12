package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece {

	public Queen(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position p = new Position(0,0);
		
		//Above
		p.setValues(position.getRow()-1 , position.getColumn());
		while(getBoard().positionExits(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() - 1);
		}
		if(getBoard().positionExits(p) && isThereAOponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		//Left
		p.setValues(position.getRow() , position.getColumn() - 1);
		while(getBoard().positionExits(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() - 1);
		}
		if(getBoard().positionExits(p) && isThereAOponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		//Right
		p.setValues(position.getRow() , position.getColumn() + 1);
		while(getBoard().positionExits(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() + 1);
		}
		if(getBoard().positionExits(p) && isThereAOponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//Below
		p.setValues(position.getRow() + 1 , position.getColumn());
		while(getBoard().positionExits(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() + 1);
		}
		if(getBoard().positionExits(p) && isThereAOponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		//NW
		p.setValues(position.getRow()-1 , position.getColumn()-1);
		while(getBoard().positionExits(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() - 1);
			p.setColumn(p.getColumn() -1);
		}
		if(getBoard().positionExits(p) && isThereAOponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		//SE
		p.setValues(position.getRow()+1 , position.getColumn()+1);
		while(getBoard().positionExits(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() + 1);
			p.setColumn(p.getColumn() +1);
		}
		if(getBoard().positionExits(p) && isThereAOponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		//NE
		p.setValues(position.getRow()-1 , position.getColumn()+1);
		while(getBoard().positionExits(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() - 1);
			p.setColumn(p.getColumn() +1);
		}
		if(getBoard().positionExits(p) && isThereAOponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//SO
		p.setValues(position.getRow()+1 , position.getColumn()-1);
		while(getBoard().positionExits(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() +1);
			p.setColumn(p.getColumn() -1);
		}
		if(getBoard().positionExits(p) && isThereAOponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		return mat;
	}
	
	@Override
	public String toString() {
		return (getColor() == Color.WHITE) ? "q" : "Q";
	}
}
