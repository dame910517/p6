package p6;

public class Array7 { 
	private int[] array;

	public Array7() { // default
		array = new int[7];
	}

	public Array7(Array7 array7) {
		this(); 
		setArray(array7);

	}
	

	public Array7(int[] array) {
		for (int i = 0; i < array.length; i++) {
			this.array[i] = array[i]++;
		}
	}

	public void setElement(int pos, int value) {
		if (pos < array.length && pos > 0) {
			array[pos] = value; 
		}
	}

	public int getElement(int pos) {
		try {
			return array[pos];

		} catch (NullPointerException e) {
			return 0;
		}
	}


	public void setArray(Array7 array7) { //måste skriva begränsnig
		for (int i = 0; i < array.length; i++) {
			int ny = array7.getElement(i);
			array[i] = ny;
		}
	}

	public void setArray(int[] array) {
		this.array = array;

	}

	public Array7 getArray() { // ny instans av Array7 ska returneras
		Array7 ny = new Array7();
		for (int i = 0; i < array.length; i++) {
			array[i]  = ny.getElement(i);
		}
		return ny;
	}
	

	public int[] toIntArray() { // ny instans av int[] ska returneras
		int[] array2 = new int[7];
		for(int i = 0; i < array.length; i++) {
			array2[i] = array[i];
		}
		return array2;
	}
}
