package Lab5;

public class TicTacToe {
	private static final char EMPTY = ' ';
	private char[][] board;
	
	public TicTacToe(char[][] board) {
		this.board = board;
	}

	public boolean checkRows() {
		for (int i = 0; i < board.length; i++) {
			int row = 0;
			for (int j = 0; j < board[i].length; j++) {
				row += board[i][j];
			}
			if(row == 88 * board.length || row == 79 * board.length) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkColumns() {
		for (int i = 0; i < board.length; i++) {
			int col = 0;
			for (int j = 0; j < board[i].length; j++) {
				col += board[j][i];
			}
			if(col == 88 * board.length || col == 79 * board.length) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkDiagonals() {
		// Check top-left to bottom-right
		int dia1 = 0;
		for (int i = 0; i < board.length; i++) {
				dia1 += board[i][i];
		}
		if(dia1 == 88 * board.length || dia1 == 79 * board.length) {
			return true;
		}
		
		// Check bottom-left to top-right
		int dia2 = 0;
		for (int i = board.length - 1; i >= 0; i--) {
			dia2 += board[i][board.length-1-i];
		}
		if(dia2 == 88 * board.length || dia2 == 79 * board.length) {
			return true;
		}
		
		return false;
	}
	public static void main(String[] args) {
		//Testing for checkRows method
		char[][] ma1 = {	{'O',' ',' '},
				   	  		{'O',' ','O'},
				   	  		{'X','X','X'} };
		TicTacToe t1 = new TicTacToe(ma1);
		System.out.println(t1.checkRows());
		
		//Testing for checkColumns method
		char[][] ma2 = {	{'X','O','X'},
	   	  					{' ','O',' '},
	   	  					{' ','O','X'} };
		TicTacToe t2 = new TicTacToe(ma2);
		System.out.println(t2.checkColumns());
		
		//Testing for checkDiagonals method
		char[][] ma3 = {	{'X','O',' '},
	   	  					{'O','X',' '},
	   	  					{'O',' ','X'} };
		TicTacToe t3 = new TicTacToe(ma3);
		System.out.println(t3.checkDiagonals());
		
		//Testing for checkDiagonals method
		char[][] ma4 = {	{'X',' ','O'},
			   	  			{'X','O',' '},
			   	  			{'O',' ','X'} };
		TicTacToe t4 = new TicTacToe(ma4);
		System.out.println(t4.checkDiagonals());
	}
}
