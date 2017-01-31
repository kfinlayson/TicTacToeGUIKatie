package edu.jsu.mcis; 

import java.awt.Point;
import java.util.Scanner;

public class Main {
    private static final Scanner keyboard = new Scanner(System.in);

    private static Point getUserMove() {
        System.out.println("Give me a location: "); 
        int row = keyboard.nextInt();
        int col = keyboard.nextInt();
        return new Point(row, col); 
    }
    
    private static void controlModel(TicTacToeModel model) { 
        boolean running = false;
        while(!running) {
            Point getMove = getUserMove(); 
            running = model.setMark(getMove.x, getMove.y);
            if(!running) {
                System.out.println("The location (" + getMove.x + "," + getMove.y + ")" + " is not valid");
            }
        }
    }
    
    private static void viewModel(TicTacToeModel model) { 
        System.out.println("Model: " + "\n" + model + "\n");
    }

    public static void main(String[] args) {
        TicTacToeModel model = new TicTacToeModel();
        TicTacToeModel.Result result = TicTacToeModel.Result.NONE; 
        while(result == TicTacToeModel.Result.NONE) {
            String turn = (model.TurnX())? "X" : "O"; 
            viewModel(model);
            System.out.println(turn + "'s turn");
            controlModel(model);
            result = model.getResult();
        }
        String end = "It's a TIE";
        if (result == TicTacToeModel.Result.XWIN) end = "X is winner";
        else if (result == TicTacToeModel.Result.OWIN) end = "O is winner";
        System.out.println(end);
    }
}














