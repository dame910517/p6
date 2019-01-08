package p6;

import java.util.Arrays;

public class Array7x7 {
	private int[][] array2;

	public Array7x7() {
		array2 = new int[7][7];
	}

	public Array7x7(Array7x7 array7x7) {
		this();
		setArray(array2);
	}

	public Array7x7(int[][] array2) { 
		this.array2 = array2.clone(); 
	}

	public void setElement(int row, int col, int value) {
		if (row >= 0 && row < array2.length && col >= 0 && col < array2.length) {
			array2[row][col] = value;
		}
	}

	public int getElement(int row, int col) {
		return array2[row][col];

	}

//	Skapa metoder som kan skriva och läsa rader och kolumner:
//hämtar värden från int[][] och stoppar in i Array7 typen
	public void setRow(int row, Array7 theRow) { 
		for (int i = 0; i < array2.length; i++) {
			array2[row][i] = theRow.getElement(i);
		}
	}

	public Array7 getRow(int row) {
		Array7 ny = new Array7();
		for (int i = 0; i < array2[row].length; i++) {
			ny.setElement(i, array2[row][i]);
		}
		return ny;
	}

	public void setCol(int col, Array7 theCol) {
		for(int i = 0; i< array2.length; i++) {
			array2[i][col]=theCol.getElement(i);
		}
	}

	public Array7 getCol(int col) {
		Array7 ny = new Array7();
		for (int i = 0; i < array2[col].length; i++) {
			ny.setElement(i, array2[i][col]);
		}
		return ny;
	}

//	Skapa metoder som kan skriva och läsa samliga element:

	public void setArray(Array7x7 array7x7) { //måste skriva begränsnig
		array2 = array7x7.toIntArray();
	}

	public void setArray(int[][] array) {//måste skriva begränsnig
		this.array2 = array.clone();
	}

	public Array7x7 getArray() { // ny instans av Array7x7 ska returneras
		Array7x7 ny = new Array7x7();
		for (int i = 0; i < array2.length ; i++) {
			for (int j = 0; j < array2[0].length ; j++) {
				ny.setElement(i, j, array2[i][j]);
			}
		}
		return ny;
	}

	public int[][] toIntArray() { // ny instans av int[][] ska returneras
		int[][] ny = new int[7][7];
		for (int i = 0; i < array2.length ; i++) {
			for (int j = 0; j < array2[0].length ; j++) {
				ny[i][j] = array2[i][j];
			}
		}
		return ny;
	}
	
		public Array7 shiftLeft(Array7 a7) { // behöver bara jobba i kolumner pga vänster och höger ej upp och ned
		Array7 retArray7 = this.getCol(0);//sparar densom stoppar us så att den sparas , annars försvinner den
		for (int i = 0; i < array2.length-1; i++) {
			this.setCol(i, this.getCol(i + 1)); //stoppar in värden från en pos (till höger om den pos vi jobbar med)
			//i den pos vi jobbar med, dvs shiftar vänster
		}//får in en col och får ut en col, tar in ett a7 och stoppar in från parameter 
		this.setCol(6, a7);
		return retArray7;
	}


	public Array7 shiftRight(Array7 a7) {
		Array7 retArray7 = this.getCol(6);
		for (int i = array2.length -1; i > 0; i--) {
			this.setCol(i, this.getCol(i - 1));
		}
		this.setCol(0, a7);
		return retArray7;
	}

	public Array7 shiftUp(Array7 a7) {
		Array7 retArray7 = this.getRow(0);//spottar ut
		for (int i = 0; i < array2.length - 1; i++) {
			this.setRow(i, this.getRow(i + 1));
		}
		this.setRow(6, a7);
		return retArray7;
	}

	public Array7 shiftDown(Array7 a7) {
		Array7 retArray7 = this.getRow(6);
		for (int i = array2.length - 1; i < 0; i--) {
			this.setRow(i, this.getRow(i - 1));
		}
		this.setRow(0, a7);
		return retArray7;
	}
