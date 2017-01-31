package edu.jsu.mcis; 

public class TicTacToeModel { 
    public enum Mark { EMPTY, X, O };
    public enum Result { NONE, XWIN, OWIN, TIE };
    private Mark[][] board; //creates 2 sets row and col
    private boolean xTurn; 
    
    public boolean TurnX() { return xTurn; }
    public boolean TurnO() { return !xTurn; }

    public TicTacToeModel() {
        board = new Mark[3][3];
        for(int i = 0; i < board.length; i++) { 
            for(int j = 0; j < board[i].length; j++) {
                board[i][j] = Mark.EMPTY;
            }
        }
        xTurn = true; //X goes first
    }
    
    public Mark getMark(int row, int col) {
        return board[row][col];
    }
    
    public boolean setMark(int row, int col) { 
        if(row >= 0 && row < board.length && col >= 0 && col < board[row].length) {
            if(board[row][col] == Mark.EMPTY) {
                board[row][col] = (xTurn)? Mark.X : Mark.O;;
                xTurn = !xTurn; //when it's not X it's O's
                return true;
            }
            else return false;
        }
        else return false;
    }

    public Result getResult() { 

        if(board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][0] == Mark.X) return Result.XWIN; 

        else if(board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][0] == Mark.X) return Result.XWIN;

        else if(board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][0] == Mark.X) return Result.XWIN;

        else if(board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[0][0] == Mark.X) return Result.XWIN;

        else if(board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[0][1] == Mark.X) return Result.XWIN;

        else if(board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[0][2] == Mark.X) return Result.XWIN;

        else if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] == Mark.X) return Result.XWIN;

        else if(board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] == Mark.X) return Result.XWIN;

        else if(board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][0] == Mark.O) return Result.OWIN; 

        else if(board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][0] == Mark.O) return Result.OWIN;
        
        else if(board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][0] == Mark.O) return Result.OWIN;

        else if(board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[0][0] == Mark.O) return Result.OWIN;

        else if(board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[0][1] == Mark.O) return Result.OWIN;
    
        else if(board[0][2] == board[1][2] && board[1][2] == board[1][2] && board[2][2] == Mark.O) return Result.OWIN;

        else if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] == Mark.O) return Result.OWIN;
       
        else if(board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] == Mark.O) return Result.OWIN;

        for( int row = 0; row < 3; row++ ) {
            for( int col = 0; col < 3; col++ ) {
                if(!(board[row][col] == Mark.X || board[row][col] == Mark.O)) {
                return Result.NONE;
                }
            }
        }

        return Result.TIE; //otherwise TIE

        }

        public String toString() {
            StringBuilder builder = new StringBuilder();
            for(int row = 0; row < board.length; row++) {
                for(int col = 0; col < board.length; col++){ 
                    if (board[row][col] == Mark.EMPTY) builder.append(" ");
                    else if (board[row][col] == Mark.X) builder.append("X");
                    else builder.append("O");
                    if (col < 2) builder.append("|");
                }
                if(row < 2) builder.append("\n-----\n");
            }
            return builder.toString();
        }
} 







