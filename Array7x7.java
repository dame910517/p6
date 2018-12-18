package p6;

public class Array7x7 {
	private int[][] array2;
	private Array7 array7 = new Array7();

	public Array7x7() {
		array2 = new int[7][7];
	}

	public Array7x7(Array7x7 array7x7) {
		for (int i = 0; i < array2.length - 1; i++) {
			for (int j = 0; j < array2[0].length - 1; j++) {
				int ny = array7x7.getElement(i, j);
				array2[i][j] = ny;
			}
		}
	}

	public Array7x7(int[][] array) { // RÄTT?
		for (int i = 0; i < array2.length - 1; i++) {
			for (int j = 0; j < array2[0].length - 1; j++) {
				array2[i][j]++; // RÄTT?
			}
		}
	}

	public void setElement(int row, int col, int value) {
		if (row >= 0 && row < array2.length - 1 && col >= 0 && col < array2.length - 1) {
			array2[row][col] = value;
		}
	}

	public int getElement(int row, int col) { // VARFÖR FEL?
		if (row >= 0 && row < array2.length - 1 && col >= 0 && col < array2.length - 1) {
			return array2[row][col];
		}
	}

//	Skapa metoder som kan skriva och läsa rader och kolumner:

	public void setRow(int row, Array7 theRow) { // måste använda metod i klassen array7
//		if (row >= 0 && row < array2.length - 1 && theRow >= 0 && theRow < array2.length) {
//			array2[row] = theRow.getElement(row); //nu är det rätt med typer
//			array2[row] = array7.getElement(theRow); //detta känns mer logiskt
		for (int i = 0; i < array2.length; i++) {
			array2[i] = array7.getElement(row);
		}
	}

//	for (int i = 0; i < array.length-1; i++) {
//		int ny = array7.getElement(i);
//		array[i] = ny;
//	}

	public Array7 getRow(int row) {

	}

	public void setCol(int col, Array7 theCol) {

	}

	public Array7 getCol(int col) {
	}

//	Skapa metoder som kan skriva och läsa samliga element:

	public void setArray(Array7x7 array7x7) { //SAMMA SOM KONSTRUKTORN?
		for (int i = 0; i < array2.length - 1; i++) {
			for (int j = 0; j < array2[0].length - 1; j++) {
				int ny = array7x7.getElement(i, j);
				array2[i][j] = ny;
			}
		}
	}

	public void setArray(int[][] array) {
		this.array2 = array;
	}

	public Array7x7 getArray() { // ny instans av int[] ska returneras
		Array7x7 ny = new Array7x7();
		for (int i = 0; i < array2.length - 1; i++) {
			for (int j = 0; j < array2[0].length - 1; j++) {
				array2[i][j] = ny.getElement(i, j);
			}
		}
		return ny;
	}

	public int[][] toIntArray() { // ny instans av int[] ska returneras
		int[][] ny = new int[7][7];
		for (int i = 0; i < array2.length - 1; i++) {
			for (int j = 0; j < array2[0].length - 1; j++) {
				array2[i][j] = ny[i][j];
			}
		}
		return ny;
	}
}
