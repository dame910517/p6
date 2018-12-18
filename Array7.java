package p6;

public class Array7 { //körde array.length-1 överallt pga värdet sätts t int[7]
	private int[] array;

	public Array7() { // default
		array = new int[7];
	}

	public Array7(Array7 array7) {//obejt innehåller array med flera värden

		for (int i = 0; i < array.length-1; i++) {
			int ny = array7.getElement(i);
			array[i] = ny;
		}
	}
	

	public Array7(int[] array) { //  RÄTT?
		for (int i = 0; i < array.length-1; i++) {
			array[i]++; // lägge ri värden i array, RÄTT?
		}
	}

	public void setElement(int pos, int value) {
		if (pos < array.length - 1 && pos > 0) {
			array[pos] = value; 
		}
	}

	public int getElement(int pos) { // VARFÖR FEL? vill hitta positionen eller värdet?
		while (pos < array.length - 1 && pos >= 0) {
			return array[pos];
		}
	}

	public void setArray(Array7 array7) { //SKA VARA SAMMA SOM KONSTURKTORN? NÄ?
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
