package p6;

public class Array7 { //k�rde array.length-1 �verallt pga v�rdet s�tts t int[7]
	private int[] array;

	public Array7() { // default
		array = new int[7];
	}

	public Array7(Array7 array7) {//obejt inneh�ller array med flera v�rden

		for (int i = 0; i < array.length-1; i++) {
			int ny = array7.getElement(i);
			array[i] = ny;
		}
	}
	

	public Array7(int[] array) { //  R�TT?
		for (int i = 0; i < array.length-1; i++) {
			array[i]++; // l�gge ri v�rden i array, R�TT?
		}
	}

	public void setElement(int pos, int value) {
		if (pos < array.length - 1 && pos > 0) {
			array[pos] = value; 
		}
	}

	public int getElement(int pos) { // VARF�R FEL? vill hitta positionen eller v�rdet?
		while (pos < array.length - 1 && pos >= 0) {
			return array[pos];
		}
	}

	public void setArray(Array7 array7) { //SKA VARA SAMMA SOM KONSTURKTORN? N�?
		for (int i = 0; i < array.length-1; i++) {
			int ny = array7.getElement(i);
			array[i] = ny;
		}
	}

	public void setArray(int[] array) {
		this.array = array;

	}

	public Array7 getArray() { // ny instans av Array7 ska returneras
		Array7 ny = new Array7();
		for (int i = 0; i < array.length-1; i++) {
			array[i]  = ny.getElement(i);
		}
		return ny;
	}
	

	public int[] toIntArray() { // ny instans av int[] ska returneras
		int[] array2 = new int[7];
		for(int i = 0; i < array.length-1; i++) {
			array2[i] = array[i];
		}
		return array2;
	}
}
