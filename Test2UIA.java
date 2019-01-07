package p6;


import javax.swing.*; 

import java.awt.*;
import java.util.Random;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;


public class Test2UIA extends JPanel
{

	private Controller2 controller;
	
	private JButton btnLeft, btnRight;
	
	private JTextField[] tfLeftColumn;
	private JTextField[] tfRightColumn;
	private JLabel[][] lblMiddleColumn;
	
	private Array7 leftColumn;
	private Array7 rightColumn;
	private Array7x7 middleColumn;
	
	private JPanel leftPanel;
	private JPanel rightPanel;
	private JPanel middlePanel;
	private JPanel lowerPanel;
	
	
	
	
	public Test2UIA(Array7 mLeftColumn, Array7 mRightColumn, Array7x7 mMiddleColumn)
	{
		//Panelen
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(300, 200));
		
		//Arrayer
		this.leftColumn = mLeftColumn;
		this.rightColumn = mRightColumn;
		this.middleColumn = mMiddleColumn;
		
		//Paneler
		this.leftPanel = new JPanel();
		this.leftPanel.setLayout(new GridLayout(7, 1));
		
		this.rightPanel = new JPanel();
		this.rightPanel.setLayout(new GridLayout(7, 1));
		
		this.middlePanel = new JPanel();
		this.middlePanel.setLayout(new GridLayout(7, 7));
		
		this.lowerPanel = new JPanel(new GridLayout(1, 2));
		
		//Rader och kolumer
		this.tfLeftColumn = new JTextField[7];
		this.tfRightColumn = new JTextField[7];
		this.lblMiddleColumn = new JLabel[7][7];
		
		MoveListener moveListener = new MoveListener();

		this.btnLeft = new JButton("<- Move Left <-");
		this.btnLeft.addActionListener(moveListener);
		
	    this.btnRight = new JButton("-> Move Right ->");
	    this.btnRight.addActionListener(moveListener);
	    

	    this.lowerPanel.add(this.btnLeft);
	    this.lowerPanel.add(this.btnRight);
	    
	    
		//Inititerar och ger variabler
		for(int i = 0; i < 7; i++)
		{
			this.tfLeftColumn[i] = new JTextField();			
			this.tfLeftColumn[i].setText(Integer.toString(this.leftColumn.getElement(i)));			
			this.tfLeftColumn[i].setPreferredSize(new Dimension(30, 30));			
			this.leftPanel.add(this.tfLeftColumn[i]);
			
			this.tfRightColumn[i] = new JTextField();
			this.tfRightColumn[i].setText(Integer.toString(this.rightColumn.getElement(i)));
			this.tfRightColumn[i].setPreferredSize(new Dimension(30, 30));
			this.rightPanel.add(this.tfRightColumn[i]);

			for(int j = 0; j <7; j++)
			{
				this.lblMiddleColumn[i][j] = new JLabel("");
				this.lblMiddleColumn[i][j].setBorder(BorderFactory.createRaisedBevelBorder());
				this.lblMiddleColumn[i][j].setText(Integer.toString(this.middleColumn.getElement(i, j)));
				this.lblMiddleColumn[i][j].setPreferredSize(new Dimension(30, 30));
				this.middlePanel.add(this.lblMiddleColumn[i][j]);
			}
		}
		
		
	    
	    

	    this.add(this.middlePanel, BorderLayout.CENTER);
	    this.add(this.leftPanel, BorderLayout.WEST);
	    this.add(this.rightPanel, BorderLayout.EAST);
	    this.add(this.lowerPanel, BorderLayout.SOUTH);
	    
	    
	    
	    
	}
	
	public void update()
	{
		for(int i = 0; i < 7; i++)
		{
		
			this.tfLeftColumn[i].setText(Integer.toString(this.leftColumn.getElement(i)));			

			this.tfRightColumn[i].setText(Integer.toString(this.rightColumn.getElement(i)));


			for(int j = 0; j <7; j++)
			{

				this.lblMiddleColumn[i][j].setText(Integer.toString(this.middleColumn.getElement(i, j)));

			}
		}
	}
	
	
	private class MoveListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			
			
			if(e.getSource().equals(btnLeft))
			{
				rightColumn = middleColumn.shiftLeft(leftColumn);
				
			}
			
			else if(e.getSource().equals(btnRight))
			{
				leftColumn = middleColumn.shiftRight(rightColumn);
			}
			
			update();
		}
		
	}
	

	
	
	
	
	
	
	public static void main(String [] args)
	{
		Random rng = new Random();
		
	    Array7 testArray1 = new Array7();
	    
	    
	    for(int i = 0; i < 7; i++)
		{
			testArray1.setElement(i, rng.nextInt(9));
			
		}
	    
	    int[][] test = {{rng.nextInt(9), rng.nextInt(9), rng.nextInt(9), rng.nextInt(9), rng.nextInt(9), rng.nextInt(9), rng.nextInt(9)}, {7, 6, 6, 6, 7, 8, 9}, {7, 6, 6, 6, 7, 8, 9},{7, 6, 6, 6, 7, 8, 9},{7, 6, 6, 6, 7, 8, 9},{7, 6, 6, 6, 7, 8, 9},{7, 6, 6, 6, 7, 8, 9}};
	    
	    Array7x7 testArray2 = new Array7x7(test);
		
		Test2UIA viewer = new Test2UIA(testArray1, testArray1, testArray2);
		
		
		
		JFrame frame1 = new JFrame( "SSPViewer" );
		frame1.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame1.add(viewer);
		frame1.pack();
		frame1.setVisible( true );
	}
	
	
	
}
