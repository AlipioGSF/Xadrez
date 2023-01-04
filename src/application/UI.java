package application;

public class UI {
	
	public static void printBoard(ChessPiece[][] pieces) {
		//Parei criando o for(){};
	}
	
	public static void printPiece(ChessPiece piece) {
		if(piece==null) {
			System.out.print("-");
		}else {
			System.out.print(piece);
		}
		System.out.print("-");
	}
}
