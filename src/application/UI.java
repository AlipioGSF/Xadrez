package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class UI {
	
	public final static void clearScreen()
	{
		System.out.println("\n\n\n");
	}
	
	public static ChessPosition readChessPosition(Scanner sc) {
		try {
			String s = sc.nextLine();
			char column = s.charAt(0);
			int row = Integer.parseInt(s.substring(1));
			return new ChessPosition(column, row);			
		}catch (RuntimeException e) {
			throw new InputMismatchException("Error reading chess position. Valid value are from a1 to h8");
		}
	}
	
	public static void printMatch(ChessMatch chessMatch) {
		printBoard(chessMatch.getPieces());
		System.out.println("\nTurn : " + chessMatch.getTurn());
		System.out.println("Waiting player: " + chessMatch.getCurrentPlayer());
	}
	
	public static void printBoard(ChessPiece[][] pieces) {
		clearScreen();
		for(int i=0;i<pieces.length;i++){
			System.out.print((8-i) + " ");
			for(int j=0;j<pieces.length;j++) {
				printPiece(pieces[i][j], false);
			}
			System.out.println("\n");
		}
		System.out.print("   a   b   c   d   e   f   g   h ");
	}
	
	public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
		clearScreen();
		for(int i=0;i<pieces.length;i++){
			System.out.print((8-i) + " ");
			for(int j=0;j<pieces.length;j++) {
				printPiece(pieces[i][j], possibleMoves[i][j]);
			}
			System.out.println("\n");
		}
		System.out.print("   a   b   c   d   e   f   g   h ");
	}
	
	public static void printPiece(ChessPiece piece, boolean validPosition) {
		if(piece==null && validPosition) {
			System.out.print(" + ");	
		}
		else if(piece==null ) {
			System.out.print(" - ");
		}else if(piece!=null && validPosition){
			System.out.print("+" + piece + "+");	
		}else {
			System.out.print(" " + piece + " ");
		}
		System.out.print(" ");
	}
}
