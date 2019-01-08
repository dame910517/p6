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
	
	
	ui = new Test2UI(this.leftColumn, this.rightColumn, this.array, this);
	
	
	}
	
	public Controller2(Array7 mLeftColumn, Array7 mRightColumn, Array7x7 mArray)
	{
	
	
	array = mArray;
	rightColumn = mRightColumn;
	leftColumn = mLeftColumn;
	
	ui = new Test2UI(this.leftColumn, this.rightColumn, this.array, this);
	
	
	}
	
	
	public Array7x7 getArray()
	{
		return this.array;
	}
	
	public Array7 getLeftColumn()
	{
		return this.leftColumn;
	}
	
	public Test2UI getUI()
	{
		return this.ui;
	}
	
	
	public void update()
	{
		for(int i = 0; i < 7; i++)
		{
		
			this.ui.getLeftTfColumn()[i].setText(Integer.toString(this.ui.getLeftColumn().getElement(i)));			

			this.ui.getRightTfColumn()[i].setText(Integer.toString(this.ui.getRightColumn().getElement(i)));


			for(int j = 0; j <7; j++)
			{

				this.ui.getMiddleLblColumn()[i][j].setText(Integer.toString(this.ui.getMiddleColumn().getElement(i, j)));

			}
		}
	}
	
	public void moveLeft()
	{
		this.ui.setLeftColumn(this.ui.getMiddleColumn().shiftLeft(this.ui.getRightColumn()));
	}
	
	public void moveRight()
	{
		this.ui.setRightColumn(this.ui.getMiddleColumn().shiftRight(this.ui.getLeftColumn()));;
	}
}



