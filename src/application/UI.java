package application;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

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
	
	public static void printMatch(ChessMatch chessMatch, List<ChessPiece> captured) {
		printBoard(chessMatch.getPieces());
		System.out.println();
		printCapturedPieces(captured);
		System.out.println("\nTurn : " + chessMatch.getTurn());
		System.out.println("Waiting player: " + chessMatch.getCurrentPlayer());
		
		if(chessMatch.isCheck()) {
			System.out.println("CHECK!");
		}
	}
	
	public static void printBoard(ChessPiece[][] pieces) {
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
	
	public static void printCapturedPieces(List<ChessPiece> captured) {
		try {
			List<ChessPiece> white = captured.stream().filter(x -> x!= null && x.getColor() == Color.WHITE).collect(Collectors.toList());
			List<ChessPiece> black = captured.stream().filter(x -> x!=null && x.getColor() == Color.BLACK).collect(Collectors.toList());						
			System.out.println("Captured pieces");
			System.out.print("White: ");
			System.out.println(Arrays.toString(white.toArray()));
			System.out.print("Black: ");
			System.out.println(Arrays.toString(black.toArray()));
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	
	}
	
}
