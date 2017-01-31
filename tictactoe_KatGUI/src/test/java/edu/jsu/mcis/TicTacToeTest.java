package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeTest {
	private TicTacToeModel model;

	@Before
	public void setup() {
		model = new TicTacToeModel();
	}
    
    @Test
	public void testInitialBoardIsEmpty() {
        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col++) {
                TicTacToeModel.Mark m = model.getMark(row, col);
                assertEquals(TicTacToeModel.Mark.EMPTY, m);
            }
        }
	}
	
	@Test
	public void testMarkXInUpperRightCorner() {
        model.setMark(0, 2); 
        TicTacToeModel.Mark m = model.getMark(0, 2);
        assertEquals(TicTacToeModel.Mark.X, m);
	}
	
	@Test
	public void testMarkOInBottomLeftCorner() { 
		model.setMark(0, 2); 
		model.setMark(2, 0); 
		TicTacToeModel.Mark m = model.getMark(2, 0);
		assertEquals(TicTacToeModel.Mark.O, m);
	}
	
	@Test
	public void testUnableToMarkOverExistingMark() {
		model.setMark(1, 0);
		assertEquals(TicTacToeModel.Mark.X, model.getMark(1, 0));
		model.setMark(1, 0);
		assertEquals(TicTacToeModel.Mark.X, model.getMark(1, 0));
		model.setMark(0, 0);
		assertEquals(TicTacToeModel.Mark.O, model.getMark(0, 0)); 
	}
	
	@Test
	public void testGameIsNotOverAfterTheFirstMark() { 
		TicTacToeModel.Result r = model.getResult();
		model.setMark(2, 2);
		assertEquals(TicTacToeModel.Result.NONE, r);
	}

   @Test
    public void testToStringWorksCorrectly() {
		String board = " | |O\n-----\nO|X| \n-----\n |X| ";
		model.setMark(2, 1);
		model.setMark(1, 0);
		model.setMark(1, 1);
		model.setMark(0, 2); 
		assertEquals(board, model.toString());
    } 
    
	@Test
	public void testGameIsWonByXHorizontallyAcrossTopRow() {
		model.setMark(0, 0); //start X
		assertEquals(TicTacToeModel.Result.NONE, model.getResult());
		model.setMark(1, 0);
		assertEquals(TicTacToeModel.Result.NONE, model.getResult());
		model.setMark(0, 1);
		assertEquals(TicTacToeModel.Result.NONE, model.getResult());
		model.setMark(2, 0);
		assertEquals(TicTacToeModel.Result.NONE, model.getResult());
		model.setMark(0, 2);
		assertEquals(TicTacToeModel.Result.XWIN, model.getResult());
	}
	
	@Test
	public void testGameIsOverByTieIfAllLocationsAreFilled() {
		model.setMark(0, 0); //start X
		assertEquals(TicTacToeModel.Result.NONE, model.getResult());
		model.setMark(0, 2); //O
		assertEquals(TicTacToeModel.Result.NONE, model.getResult());
		model.setMark(0, 1); //X
		assertEquals(TicTacToeModel.Result.NONE, model.getResult());
		model.setMark(1, 0); //O
		assertEquals(TicTacToeModel.Result.NONE, model.getResult());
		model.setMark(1, 1); //X
		assertEquals(TicTacToeModel.Result.NONE, model.getResult());
		model.setMark(2, 1); //O
		assertEquals(TicTacToeModel.Result.NONE, model.getResult());
		model.setMark(1, 2); //X
		assertEquals(TicTacToeModel.Result.NONE, model.getResult());
		model.setMark(2, 2); //O
		assertEquals(TicTacToeModel.Result.NONE, model.getResult());
		model.setMark(2, 0); //X
		assertEquals(TicTacToeModel.Result.TIE, model.getResult());
	}
    
}
