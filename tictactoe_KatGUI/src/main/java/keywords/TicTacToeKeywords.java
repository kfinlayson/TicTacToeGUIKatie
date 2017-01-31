package keywords; 

import edu.jsu.mcis.*;

public class TicTacToeKeywords {
	private TicTacToeModel model;
    
	public void startNewGame() {
		model = new TicTacToeModel(); 
	}
	
	public void markLocation(int row, int col) {
		model.setMark(row, col);
	}
	
	public String getMark(int row, int col) { //
		TicTacToeModel.Mark m = model.getMark(row, col);
		if ( m == TicTacToeModel.Mark.X ) return "X";

		else if ( m == TicTacToeModel.Mark.O ) return "O";

		else return "";
	}
    
	public String getWinner() {
		String winner = "";
		TicTacToeModel.Result n = model.getResult();
		if ( n == TicTacToeModel.Result.XWIN ) { 
			winner = "X";
		}

		if ( n == TicTacToeModel.Result.OWIN )  {
			winner = "O";
		}

		if ( n == TicTacToeModel.Result.TIE ) { 
			winner = "TIE";
		}

        return winner;
	}
}
