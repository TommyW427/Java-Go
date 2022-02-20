

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.File;


public class Start implements ActionListener {
   
   
   private JFrame frame;
   private JPanel panel;
   private JButton nine;
   private JButton thirteen;
   private JButton nineteen;
   private JLabel background;
   private JLabel play;
   private Image image1;
   int width=1000;
   int height=1000;
   
   
   
   public Start() {
      
      frame = new JFrame();
      
      panel = new JPanel();
      panel.setBorder(BorderFactory.createEmptyBorder());
      panel.setLayout(null);
      panel.setBackground(Color.lightGray);
      
      title();
      
     
      frame.add(panel,BorderLayout.CENTER);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setTitle("Start_Screen");
      frame.pack();
      
      frame.setSize(width,height);
      frame.setVisible(true);
      
      
   }
   
   public static void main(String[] args) {
      new Start();
   }
   
   public void title() {
	   
	   JLabel head = new JLabel("Java-Go");
	   head.setForeground(Color.magenta.darker().darker());
	   JLabel sub = new JLabel("By: ");
	   Color color=Color.blue.darker().darker();
	   sub.setForeground(color);
	   JLabel name1 = new JLabel("Tommy Williams");
	   name1.setForeground(color);
	   JLabel name2 = new JLabel("Dhruv Khatod");
	   name2.setForeground(color);
	   JLabel name3 = new JLabel("Abhinav Angirekula");
	   name3.setForeground(color);
	   
	   background = new JLabel();
      try
        {
          image1 = ImageIO.read(new File("GameBoard-2.jpg"));
        }
        catch (Exception e)
        {
          e.printStackTrace();
          System.exit(1);
        }
      
	   //Image image = new ImageIcon(this.getClass().getResource("/GameBoard-2.png")).getImage();
	   background.setIcon(new ImageIcon(image1));
	   background.setBounds(0,-5,width,height);
	   
	   play = new JLabel("Play");
	   play.setForeground(Color.blue);
	   play.setBounds(width/2-150,height*3/4-100,500,200);
	   play.setFont(new Font("font",Font.BOLD,150));
	   play.addMouseListener(new MouseAdapter() {
		   public void mouseClicked(MouseEvent e) {
			   boardSize();
		   }
	   });
	   
	   panel.add(head);
	   panel.add(sub);
	   panel.add(name1);
	   panel.add(name2);
	   panel.add(name3);
	   panel.add(play);
	   panel.add(background);
	   
	   head.setBounds(width/2-235,height/4-65,470,130);
	   head.setFont(new Font("header",Font.ROMAN_BASELINE,120));
	   
	   Font plain = new Font("font",Font.PLAIN,30);
	   
	   sub.setBounds(width/2-25,(height*11)/32,75,50);
	   sub.setFont(plain);
	   
	   name1.setBounds(width/2-122,height*13/32-10,240,50);
	   name1.setFont(plain);
	   name2.setBounds(width/2-105,height*15/32-20,210,50);
	   name2.setFont(plain);
	   name3.setBounds(width/2-150,height*17/32-30,290,50);
	   name3.setFont(plain);
	   
	   
	   
	   
   
   }
   
   public void boardSize() {
	   nine = new JButton("9 x 9");
	   nine.addMouseListener(new MouseAdapter() {
		   public void mouseClicked(MouseEvent e) {
			  frame.dispose();
			  Board board = new Board(9);
		   }
	   });
	   thirteen = new JButton("13 x 13");
	   thirteen.addMouseListener(new MouseAdapter() {
		   public void mouseClicked(MouseEvent e) {
			   frame.dispose();
			   Board board = new Board(13);
		   }
	   });
	   nineteen = new JButton("19 x 19");
	   nineteen.addMouseListener(new MouseAdapter() {
		   public void mouseClicked(MouseEvent e) {
			   frame.dispose();
			   Board board = new Board(19);
		   }
	   });
	      
	   JLabel label = new JLabel("Choose a Board Size");
	      
	      
	      
	   panel.add(label);
	   label.setBounds(width/2-275,height*3/5-100,800,200);
	   label.setFont(new Font("Interesting",Font.PLAIN,60));
	      
	   panel.add(nine);
	   nine.setBounds(width/2-450,height*8/12,300,150);
	   panel.add(thirteen);
	   thirteen.setBounds(width/2-150,height*8/12,300,150);
	   panel.add(nineteen);
	   nineteen.setBounds(width/2+150,height*8/12,300,150);
	  
	   panel.add(background);
	   panel.remove(play);
	   
	   frame.add(panel);
	   frame.invalidate();
	   frame.revalidate();
	   frame.repaint();
	   
   }
   
   
   @Override
   public void actionPerformed(ActionEvent nine) {
      
   }

   
}
