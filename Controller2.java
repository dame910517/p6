package p6;

import java.util.Random;

import javax.swing.*; 


/* Klassen skapar ett controller2-objekt med inmatade v�rden som k�rs i ett frame-objekt
 * @author Andreas J�nsson den 13/1-2019  
 * 
 **/
public class Controller2 
{
	//skapar alla objekt i klassen
	private Test2UI ui;
	private Array7x7 middleGrid;
	private Array7 leftColumn;
	private Array7 rightColumn;
	
	Random rng = new Random();
	
	 /**
	    * Konstruerar och initialiserar ett controller2-objekt.
	    * controller = new Controller2()
	    */
	public Controller2()
	{
		middleGrid= new Array7x7();	
		rightColumn = new Array7();	
		leftColumn = new Array7();	
	
		
		//ger slumpartade v�rden till alla v�rden
		for(int i = 0; i < 7; i++)	
		{		
			rightColumn.setElement(i, rng.nextInt(8));		
			leftColumn.setElement(i, rng.nextInt(8));
				
			for(int j = 0; j < 0; j++)		
			{			
				middleGrid.setElement(i, j, rng.nextInt(8));		
			}
		}	
	
		//inititerar Test2UI-objektet
		ui = new Test2UI(this.leftColumn, this.rightColumn, this.middleGrid, this);
	}	
	
	 /**
	    * Konstruerar och initialiserar ett controller2-objekt med angivna v�rden.
	    * controller = new Controller2()
	    * @param mLeftColumn v�nster kolumn
	    * @param mRightColumn h�ger kolumn
	    * @param mmArray mittenf��ltet
	    */
	public Controller2(Array7 mLeftColumn, Array7 mRightColumn, Array7x7 mArray)
	{
		middleGrid= mArray;	
		rightColumn = mRightColumn;	
		leftColumn = mLeftColumn;
	
	//inititerar Test2UI-objektet
	ui = new Test2UI(this.leftColumn, this.rightColumn, this.middleGrid, this);
	}		

	
	

	//get-metoder f�r controller2-klassen
	
	
	/**
	    * Retunerar mittenf�ltet
	    *  som en array7x7.
	    * @return array7x7 mittenf�ltet
	    */
	public Array7x7 getArray()
	{
		return this.middleGrid;
	}
	
	
	/**
	    * Retunerar den h�gra kolumnen som en array7.
	    * @return array7 h�ger kolumn
	    */
	public Array7 getLeftColumn()
	{
		return this.leftColumn;
	}
	
	
	/**
	    * Retunerar den v�nstra kolumnen som en array7.
	    * @return array7 v�nster kolumn
	    */
	public Array7 getRightColumn()
	{
		return this.rightColumn;
	}
	
	
	/**
	    * Retunerar Test2UI som controller2 anv�nder.
	    * @return Test2UI userInterface f�r controller2 objektet
	    */
	public Test2UI getUI()
	{
		return this.ui;
	}
	
	
	
	
	/**
	    * Uppdaterar alla elementen i test2ui-objektet i controller2-klassen
	    */
	public void update()
	{
		for(int i = 0; i < 7; i++)
		{
			this.ui.getLeftTfColumn()[i].setText(Integer.toString(this.leftColumn.getElement(i)));			
			this.ui.getRightTfColumn()[i].setText(Integer.toString(this.rightColumn.getElement(i)));

			for(int j = 0; j <7; j++)
			{

				this.ui.getMiddleLblColumn()[i][j].setText(Integer.toString(this.ui.getMiddleColumn().getElement(i, j)));
			}
		}
	}
	
	
	
	
	/**
	    * Flyttar alla element till v�nster i mittenf�ltet
	    */
	public void moveLeft()
	{
		this.leftColumn = (this.middleGrid.shiftLeft(this.getRightColumn()));
	}
	
	
	
	
	/**
	    * Flyttar alla element till h�ger i mittenf�ltet
	    */
	public void moveRight()
	{
		this.rightColumn = (this.middleGrid.shiftRight(this.getLeftColumn()));;
	}
}



