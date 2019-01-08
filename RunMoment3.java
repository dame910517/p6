package p6;

import java.util.Random;

import javax.swing.JFrame;

public class RunMoment3 
{

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
		frame1.add(controller.getUI());
		frame1.pack();
		frame1.setVisible( true );
	}
}
