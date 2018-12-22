package p6;

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

	public Array7x7(int[][] array) { 
		for (int i = 0; i < array2.length; i++) {
			for (int j = 0; j < array2[0].length; j++) {
				this.array2[i][j] = array2[i][j]++;
			}
		}
	}

	public void setElement(int row, int col, int value) {
		if (row >= 0 && row < array2.length && col >= 0 && col < array2.length) {
			array2[row][col] = value;
		}
	}

	public int getElement(int row, int col) { 
		try {
			return array[pos][col];

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
				array2[i][j] = ny.getElement(i, j);
			}
		}
		return ny;
	}

	public int[][] toIntArray() { // ny instans av int[] ska returneras
		int[][] ny = new int[7][7];
		for (int i = 0; i < array2.length ; i++) {
			for (int j = 0; j < array2[0].length ; j++) {
				array2[i][j] = ny[i][j];
			}
		}
		return ny;
	}
}
