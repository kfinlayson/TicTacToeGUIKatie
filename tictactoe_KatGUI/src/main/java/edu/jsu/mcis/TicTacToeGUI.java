package edu.jsu.mcis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToeGUI extends JFrame implements ActionListener {
    private TicTacToeModel model;
    private JButton[][] button;

    public TicTacToeGUI() {
        model = new TicTacToeModel();
        button = new JButton[3][3];
        JPanel buttonPanel = new JPanel();
        //JFrame frame = new JFrame();
        buttonPanel.setLayout(new GridLayout(3, 3));
        for(int i = 0; i < button.length; i++) {
            for(int j = 0; j < button[i].length; j++) {
                button[i][j] = new JButton();
                button[i][j].addActionListener((ActionListener)this); 
                buttonPanel.add(button[i][j]);
            }
        }
        add(buttonPanel); //frame?
    }

    public void actionPerformed(ActionEvent event) { //buttonlistener
        int row = 0;
        int col = 0;
        for(int i = 0; i < button.length; i++) {
            for(int j = 0; j < button[i].length; j++) {
                if(button[i][j] == event.getSource()) {
                    row = i;
                    col = i;
                }
            }
        }
        model.setMark(row, col);
        TicTacToeModel.Result result = model.getResult();
    }

    /*public void buttonListener extends ActionListener { //buttonlistener
        int row = 0;
        int col = 0;

            row = i;
            col = i;
    }
        
        model.setMark(row, col);
        TicTacToeModel.Result result = model.getResult();

    public static buttonPress() { 
        
    }*/

    public static void main(String[] args) {
        TicTacToeGUI window = new TicTacToeGUI();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(300, 300);
        window.setVisible(true);
    }
}