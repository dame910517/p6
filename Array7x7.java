package p6;

import java.util.Arrays;

public class Array7x7 {
	private int[][] array2;
	private Array7 array7 = new Array7();

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
		try {
			return array2[row][col];

		} catch (NullPointerException e) {
			return 0;
		}
	}

//	Skapa metoder som kan skriva och läsa rader och kolumner:

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
		for (int i = 0; i < array2.length ; i++) {
			for (int j = 0; j < array2[0].length ; j++) {
				int ny = array7x7.getElement(i, j);
				array2[i][j] = ny;
			}
		}
	}

	public void setArray(int[][] array) {//måste skriva begränsnig
		this.array2 = array;
	}

	public Array7x7 getArray() { // ny instans av int[] ska returneras
		Array7x7 ny = new Array7x7();
		for (int i = 0; i < array2.length ; i++) {
			for (int j = 0; j < array2[0].length ; j++) {
				ny.getElement(i, j) = array2[i][j];
			}
		}
		return ny;
	}

	public int[][] toIntArray() { // ny instans av int[] ska returneras
		int[][] ny = new int[7][7];
		for (int i = 0; i < array2.length ; i++) {
			for (int j = 0; j < array2[0].length ; j++) {
				ny[i][j] = array2[i][j];
			}
		}
		return ny;
	}
	
		public Array7 shiftLeft(Array7 a7) { // behöver bara jobba i kolumner pga vänster och höger ej upp och ned
		Array7 retArray7 = this.getCol(0);
		for (int i = 0; i < array2.length-1; i++) {
			this.setCol(i, this.getCol(i + 1)); //stoppar in värden från en pos (till höger om den pos vi jobbar med)
			//i den pos vi jobbar med, dvs shiftar vänster
		}
		this.setCol(6, a7);
		return retArray7;
	}


	public Array7 shiftRight(Array7 a7) {
		Array7 retArray7 = this.getCol(0);
		for (int i = 0; i<array2.length-1; i++) {
			this.setCol(i, this.getCol(i -1));
		}
		this.setCol(6, a7);
		return retArray7;
	}
	
		public Array7 shiftUp(Array7 a7) {
		Array7 retArray7 = this.getRow(0);
		for (int i = 0; i < array2.length - 1; i++) {
			this.setRow(i, this.getRow(i + 1));
		}
		this.setRow(6, a7);
		return retArray7;
	}

	public Array7 shiftDown(Array7 a7) {
		Array7 retArray7 = this.getRow(0);
		for (int i = 0; i < array2.length - 1; i++) {
			this.setRow(i, this.getRow(i - 1));
		}
		this.setRow(6, a7);
		return retArray7;
	}
	
	public static void main(String[]args) {
		Array7x7 jaja = new Array7x7();
		System.out.println(Arrays.deepToString(jaja.toIntArray()));
	}
}
