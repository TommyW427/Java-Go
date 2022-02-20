

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GoGame implements ActionListener{

    private int[][] board;
    private JLabel[][] board2;
    private int currentPlayerMark;
    private int boardSize;
    private JFrame frame2;
	private JPanel panel2;
	private JLabel background2;
	private Image white;
	private Image black;
	private int [][] pos;
	private JTextField row;
	private JTextField col;
	private JLabel row2;
	private JLabel col2;
	private JButton enterButton;
	private int groupSize;
	private JButton passButton;
	private boolean lastTurnPass=false;
	private int whiteCaptures=0;
	private int blackCaptures=0;
	ArrayList<Integer> boundaries = new ArrayList<Integer>();
    
    public GoGame(int bSize) {
    	boardSize=bSize;
        board = new int[boardSize][boardSize];
        board2 = new JLabel[boardSize][boardSize];
        currentPlayerMark = 1;
        //initializeBoard();
        
        //getCurrentPlayerMark() = "1"
    }

 
    public int getCurrentPlayerMark()
    {
        return currentPlayerMark;
    }



    public void initializeBoard() {

        //2D array
        for (int i = 0; i < boardSize; i++) {

            for (int j = 0; j < boardSize; j++) {
                board[i][j] = 0;
                
            }
        }
        
        //Actual Window
        frame2 = new JFrame();
		
		panel2 = new JPanel();
	    panel2.setBorder(BorderFactory.createEmptyBorder());
	    panel2.setLayout(null);
	    panel2.setBackground(Color.lightGray);
	    
	    background2 = new JLabel();
	    Image nine = new ImageIcon(this.getClass().getResource("/9by9GoBoard.jpg")).getImage();
		Image thirteen = new ImageIcon(this.getClass().getResource("/13by13GoBoard.png")) .getImage();  
	    Image nineteen = new ImageIcon(this.getClass().getResource("/19by19GoBoard2.png")).getImage();
		
		if (boardSize == 9) {
	    	background2.setIcon(new ImageIcon(nine));
	    	white = new ImageIcon(this.getClass().getResource("/WhitePiece9-2.png")).getImage();
	    	black = new ImageIcon(this.getClass().getResource("/blackPiece9.png")).getImage();
	    	
	    }
		else if (boardSize == 13) {
			background2.setIcon(new ImageIcon(thirteen));
			white = new ImageIcon(this.getClass().getResource("/WhitePiece13.png")).getImage();
			black = new ImageIcon(this.getClass().getResource("/blackPiece13.png")).getImage();
		}
		
		else {
			background2.setIcon(new ImageIcon(nineteen));
			white = new ImageIcon(this.getClass().getResource("/WhitePiece19.png")).getImage();
			black = new ImageIcon(this.getClass().getResource("/blackPiece19.png")).getImage();
		}
		if (boardSize==19) {
			background2.setBounds(0,40,1000,1000);
		}
		else {
			background2.setBounds(0,50,1000,1000);
		}
	    
	    row = new JTextField();
	    col = new JTextField();
		
	    row2 = new JLabel("Row: ");
	    col2 = new JLabel("Column: ");
	    
	    row2.setFont(new Font("Interesting",Font.PLAIN,30));
	    col2.setFont(new Font("Interesting",Font.PLAIN,30));
	    
	    row2.setBounds(25,0,200,50);
	    col2.setBounds(325,0,200,50);
	    row.setBounds(125,0,200,50);
	    col.setBounds(450,0,200,50);
	    
	    enterButton = new JButton("Enter");
	    enterButton.setBounds(675,0,200,50);
	    enterButton.addActionListener(this);
	    
	    passButton = new JButton("Pass");
	    passButton.setBounds(900,0,200,50);
	    passButton.addMouseListener(new MouseAdapter() {
	    	public void mouseClicked(MouseEvent e) {
	    		if (currentPlayerMark==1) {
	    			System.out.println("Black passed!");
	    		}
	    		else {
	    			System.out.println("White passed!");
	    		}
	    		if (lastTurnPass==true) {
	    			endGame();
	    		}
	    		else {
	    			lastTurnPass=true;
	    		}
	    		changePlayer();
	    	}
	    });
	    
	    panel2.add(passButton);
	    panel2.add(enterButton);
	    panel2.add(row2);
	    panel2.add(col2);
	    panel2.add(row);
	    panel2.add(col);
	    
	    
	    panel2.add(background2);
		
		
		frame2.add(panel2,BorderLayout.CENTER);
	    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame2.setTitle("Java_Go");
	    frame2.pack();
	      
	    frame2.setSize(1100,1110);
	    frame2.setVisible(true);
    }



    public void printBoard() {
        System.out.println("---------------------------------------");

        for (int i = 0; i < boardSize; i++) {
            System.out.print("| ");
            for (int j = 0; j < boardSize; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("---------------------------------------");
        }
    }


    public boolean isBoardFull() {
        boolean isFull = true;

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (board[i][j] == 0) {
                    isFull = true;
                }
            }
        }

        return isFull;
    }



    public void changePlayer() {
        if (currentPlayerMark == 1) {
            currentPlayerMark = 2;
        }
        else {
            currentPlayerMark = 1;
        }
    }

    // Places a mark at the cell specified by row and col with the mark of the current player.
    public boolean placeMark(int row, int col) {

        // Make sure that row and column are open.       
        if ((row >= 0) && (row < boardSize)) {
            if ((col >= 0) && (col < boardSize)) {
                if (board[row][col] == 0) {
                    board[row][col] = currentPlayerMark;
                    JLabel piece = new JLabel();
                    if (currentPlayerMark==1) {
                    	piece.setIcon(new ImageIcon(black));
                    }
                    else {
                    	piece.setIcon(new ImageIcon(white));
                    }
                    if (boardSize==19) {
                    	piece.setBounds(col*1000/boardSize,row*955/boardSize-15,200,200);
                    }
                    else if (boardSize==13) {
                    	piece.setBounds(col*1000/boardSize,row*955/boardSize,200,200);
                    }
                    else {
                    	piece.setBounds(col*1000/boardSize,row*1000/boardSize,200,200);
                    }
                    
                    board2[row][col]=piece;
                    panel2.add(piece);
                    panel2.add(background2);
                    frame2.add(panel2);
             	    frame2.invalidate();
             	    frame2.revalidate();
             	    frame2.repaint();
                    return true;
                }
            }
        }

        return false;
    }
    public void removePiece(int row, int col) {
    	if (!(board[row][col]==0)) {
    		board[row][col]=0;
    		panel2.remove(board2[row][col]);
    		frame2.add(panel2);
    		frame2.invalidate();
     	    frame2.revalidate();
     	    frame2.repaint();
    	}
    	else {
    		System.out.println("There is no piece there!");
    	}
    	
    }
    public void checkWhiteCaptures(int [][] position) {
		//0 = no piece
		//1 = black
		//2 = white
		
		int group = 3;
		pos=position;
		ArrayList<Integer> capGroups = new ArrayList<Integer>();
		
		for (int i=0; i < pos.length; i++) {
			for (int a =0; a < pos.length; a++) {
				seed(i,a,1,group);
				
				if (boundaries.contains(2) && !(boundaries.contains(0))){
					capGroups.add(group);
				}
				group++;
				boundaries.clear();
				groupSize=0;
			}
		}
		for (int i=0; i < pos.length; i++) {
			for (int a=0; a < pos.length; a++) {
				if (capGroups.contains(pos[i][a])) {
					removePiece(i,a);
					pos[i][a]=0;
					whiteCaptures++;
				}
				else {
					pos[i][a]=1;
				}
			}
		}
		
		
		
		
	}
	
	public void checkBlackCaptures(int [][] position) {
		int group = 3;
		pos=position;
		ArrayList<Integer> capGroups = new ArrayList<Integer>();
		for (int i=0; i < pos.length; i++) {
			for (int a =0; a < pos.length; a++) {
				seed(i,a,2,group);
				if (boundaries.contains(1) && !(boundaries.contains(0))){
					capGroups.add(group);
				}
				group++;
				boundaries.clear();
				groupSize=0;
			}
		}
		
		for (int i=0; i < pos.length; i++) {
			for (int a=0; a < pos.length; a++) {
				if (capGroups.contains(pos[i][a])) {
					removePiece(i,a);
					pos[i][a]=0;
					blackCaptures++;
				}
				else {
					pos[i][a]=2;
				}
			}
		}
		 
	}
	public void seed(int y, int x, int tar, int group) {
		int self;
		
		try {
		self = pos[y][x];
		}
		catch (Exception ArrayIndexOutOfBoundsException) {
			return;
		}
		//IDEA:
			//We go through the thing using a seed fill algorithm
			//as we go through we make the 0s into whatever groupNum is
			//Once the group is done you add one to groupNum 
			//And search elsewhere
		
		if (!(self==tar)) {
			if (!(self==group)) {
				boundaries.add(self);
			}
			return;
		}
		else {
			groupSize++;
			self = group;
			pos[y][x] = group;
			if (group==5 || group==6) {
				for (int c = 0; c<pos.length; c++) {
					System.out.println(Arrays.toString(pos[c]));
				}
				System.out.println("\n");
			}
			seed(y+1,x,tar,group); //North
			seed(y-1,x,tar,group); //South
			seed(y,x+1,tar,group); //East
			seed(y,x-1,tar,group); //West
		}
		
		
		
	}


	@Override
	public void actionPerformed(ActionEvent enterButton) {
		
		int rowValue = Integer.parseInt(row.getText());
		int colValue = Integer.parseInt(col.getText());
		if (((rowValue<0) || (rowValue>=19)) || ((colValue<0) || (colValue>=19))){
			System.out.println("Invalid Coordinates Entered!");
		}
		else if (!(board[rowValue][colValue]==0)) {
			System.out.println("There is already piece there!");
		}
		else {
			lastTurnPass=false;
			placeMark(rowValue,colValue);
			int [][] board3 = new int[boardSize][];
			for(int i = 0; i < boardSize; i++)
			    board3[i] = board[i].clone();;
			if (currentPlayerMark==1) {
				
				checkBlackCaptures(board3);
			}
			else {
				
				checkWhiteCaptures(board3);
			}
			changePlayer();
			printBoard();
			//This is after change so it is backwards
			if (currentPlayerMark==1) {
			System.out.println("White played at row " + row.getText() + ",  and column " + col.getText());
			}
			else {
				System.out.println("Black played at row " + row.getText() + ",  and column " + col.getText());
			}
			
		}
		
		
	}
	public void endGame() {
		Score score = new Score(blackCaptures,whiteCaptures,board);
		float blackScore = score.getBlackScore();
		float whiteScore = score.getWhiteScore();
		
		panel2.removeAll();
		
		Font large = new Font("font",Font.PLAIN,60);
		Font small = new Font("font",Font.PLAIN,30);
		
		JLabel twoPass = new JLabel("Both Players Passed");
		twoPass.setFont(large);
		twoPass.setBounds(300,162,700,75);
		
		JLabel gameEnd = new JLabel("The Game Has Ended");
		gameEnd.setFont(large);
		gameEnd.setBounds(300,270,700,75);
		
		JLabel bS = new JLabel("Black Score");
		bS.setFont(small);
		JLabel wS = new JLabel("White Score");
		wS.setFont(small);
		
		bS.setBounds(300,450,200,50);
		wS.setBounds(700,450,200,50);
		
		JLabel bScore = new JLabel(Float.toString(blackScore));
		JLabel wScore = new JLabel(Float.toString(whiteScore));
		bScore.setFont(small);
		wScore.setFont(small);
		bScore.setBounds(300,550,200,50);
		wScore.setBounds(700,550,200,50);
		
		String winner;
		if (blackScore>whiteScore) {
			winner = "black";
		}
		else if (whiteScore>blackScore){
			winner = "white";
		}
		else {
			winner = "A TIE";
		}
		
		JLabel whoWon = new JLabel("The Winner is " + winner + "!");
		whoWon.setFont(large);
		whoWon.setBounds(300,700,700,75);
		
		twoPass.setForeground(Color.magenta.darker().darker());
		panel2.add(twoPass);
		
		gameEnd.setForeground(Color.magenta.darker().darker());
		panel2.add(gameEnd);
		panel2.add(bS);
		panel2.add(wS);
		panel2.add(bScore);
		panel2.add(wScore);
		panel2.add(whoWon);
		
		panel2.setBackground(Color.gray);
		
		frame2.add(panel2);
		
		
		
		frame2.invalidate();
 	    frame2.revalidate();
 	    frame2.repaint();
		
	}
	
	
}