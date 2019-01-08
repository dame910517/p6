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
	
	
	array = new Array7x7();
	rightColumn = new Array7();
	leftColumn = new Array7();
	
	for(int i = 0; i < 7; i++)
	{
		rightColumn.setElement(i, rng.nextInt(8));
		leftColumn.setElement(i, rng.nextInt(8));
		
		for(int j = 0; j < 0; j++)
		{
			array.setElement(i, j, rng.nextInt(8));
		}
	}
	
	
	ui = new Test2UI(this.leftColumn, this.rightColumn, this.array);
	
	
	}
	
	public Controller2(Array7 mLeftColumn, Array7 mRightColumn, Array7x7 mArray)
	{
	
	
	array = mArray;
	rightColumn = mRightColumn;
	leftColumn = mLeftColumn;
	
	ui = new Test2UI(this.leftColumn, this.rightColumn, this.array);
	
	
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

		Random rng = new Random();
		
	    Array7 testArray1 = new Array7();
	    Array7 testArray2 = new Array7();
	    Array7 testArray4 = new Array7();
	    
	    for(int i = 0; i < 7; i++)
		{
			testArray1.setElement(i, rng.nextInt(9));
			
		}
	    
	    for(int i = 0; i < 7; i++)
		{
			testArray2.setElement(i, rng.nextInt(9));
			
		}
	    int[] s = {4, 6, 6, 6, 7, 8, 6};
	    testArray4.setArray(s);
	    
	    int[][] test = {{7, 6, 6, 6, 7, 8, 9}, 
	    		{2, 6, 6, 6, 7, 8, 9}, 
	    		{7, 51, 6, 6, 7, 8, 9},
	    		{1, 6, 2, 6, 7, 8, 9},
	    		{6, 1, 6, 6, 7, 8, 9},
	    		{3, 6, 4, 6, 7, 8, 16},
	    		{9, 6, 6, 6, 21, 8, 12}};
	    
	    Array7x7 testArray3 = new Array7x7(test);
		
	   // Controller2 controller = new Controller2();
		Controller2 controller = new Controller2(testArray4, testArray2, testArray3);
		
		
		
		JFrame frame1 = new JFrame( "SSPViewer" );
		frame1.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame1.add(controller.ui);
		frame1.pack();
		frame1.setVisible( true );
	}
}



