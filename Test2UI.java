package p6;


import javax.swing.*; 

import java.awt.*;



public class Test2UI extends JPanel
{

	private JButton btnLeft, btnRight;
	
	private JTextField[] leftColumn;
	private JTextField[] rightColumn;
	
	private JLabel[][] field;
	
	public Test2UI()
	{
		setLayout(new GridLayout());
		setPreferredSize(new Dimension(300, 200));
		
		leftColumn = new JTextField[7];
		rightColumn = new JTextField[7];
		field = new JLabel[7][7];
		
		
	    this.btnLeft = new JButton("<- Move Left <-");
		
	    this.btnRight = new JButton("-> Move Right ->");
	    
	    for(int i = 0; i <= 7; i++)
	    {
	    
	    	this.add(this.leftColumn[i]);	   
	    	this.add(this.rightColumn[i]);    
	    	this.add(this.field[0][i]);
	    }
	    
	    this.add(this.btnLeft);
	    this.add(this.btnRight);
	}
	
	public void setLeft(Array7 array)
	{
		for(int i = 0; i <= 7;i++)
		{
			leftColumn[i].setText(Integer.toString(array.getElement(i)));
		}
	}
	
	public void setRight(Array7 array)
	{
		for(int i = 0; i <= 7;i++)
		{
			rightColumn[i].setText(Integer.toString(array.getElement(i)));
		}
	}
	
	public void setMiddle(Array7x7 array)
	{
		
	}
	
	
	
	
	public static void main(String [] args)
	{
		Test2UI viewer = new Test2UI();
		
		JFrame frame1 = new JFrame( "SSPViewer" );
		frame1.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame1.add(viewer);
		frame1.pack();
		frame1.setVisible( true );
	}
	
}
