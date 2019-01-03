package p6;

import java.util.Random;

import javax.swing.*; 

public class Controller2 


{
	
	private Test2UI ui;
	private Array7x7 array;
	private Array7 leftColumn;
	private Array7 rightColumn;

	
	Random rng = new Random();

	public Controller2()
	{
	
	ui = new Test2UI();
	
	array = new Array7x7();
	rightColumn = new Array7();
	leftColumn = new Array7();
	
	for(int i = 0; i >= 7; i++)
	{
		rightColumn.setElement(i, rng.nextInt(8));
		leftColumn.setElement(i, rng.nextInt(8));
	}
	
	ui = new Test2UI();
	
	ui.setRight(rightColumn);
	ui.setLeft(leftColumn);
	
	}
	
	
	public Array7x7 getArray()
	{
		return this.array;
	}
	
	public Array7 getLeftColumn()
	{
		return this.leftColumn;
	}
	
	
	
	
	
	public static void main(String [] args)
	{
		Controller2 controller = new Controller2();
		
		JFrame frame1 = new JFrame( "SSPViewer" );
		frame1.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame1.add(controller.ui);
		frame1.pack();
		frame1.setVisible( true );
	}
}



