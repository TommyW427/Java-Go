

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.util.Scanner;

import javax.swing.*;



public class Board {
	
	
	private JFrame frame2;
	private JPanel panel2;
	private JLabel background2;
	private JLabel whitePiece;
	private JLabel blackPiece;
	private Image white;
	private Image black;
	private int [][] pos;
	Scanner scan = new Scanner(System.in);
	
	public Board(int boardSize) {
		
	    
	    
	    
	    Scanner scan = new Scanner(System.in);
        GoGame game = new GoGame(boardSize);
        game.initializeBoard();
        System.out.println("Go!");
        System.out.println("Current board layout:");
        game.printBoard();
            
		
	}
	

}
