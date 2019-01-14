package p6;

/**
 * En klass för att initiera en 1D-array. Används utav alla klasser i projektet. 
 * 
 * @author Amanda Eriksson
 */
public class Array7 {
	private int[] array;

	/**
	 * 
	 * Konstruerar och initialiserar en 1D-array med storlek 7
	 * 
	 */
	public Array7() {
		array = new int[7];
	}

	/**
	 * 
	 * Konstruerar och initialiserar en 1D-array
	 * @param array7 array som initialiseras
	 */

	public Array7(Array7 array7) {
		setArray(array7);

	}

	/**
	 * 
	 * Konstruerar och initialiserar en kopia utav en 1D-array
	 * @param array array som initialiseras
	 */
	public Array7(int[] array) {
		this.array = array.clone();

	}

	/**
	 * Metod för att initiera en 1D-array med värden på en viss position
	 * 
	 * @param pos positionen i arrayen
	 * @param value värdet i arrayen
	 */

	public void setElement(int pos, int value) {
		array[pos] = value;

	}
	/**
	 * Metod för att retunera värdet på en positionerna i arrayen
	 * 
	 * @param pos position i arrayen
	 * @return int retunerar positionen i arrayen
	 */
	public int getElement(int pos) {
		return array[pos];

	}

	/**
	 * Metod för att initiera en 1D-array med Array7-objekt
	 * 
	 * @param array7 objekt i arrayen
	 */

	public void setArray(Array7 array7) { 
		for (int i = 0; i < array.length; i++) {
			int ny = array7.getElement(i);
			array[i] = ny;
		}
	}

	/**
	 * Metod för att initiera en kopia utav 1D-arrayen
	 * 
	 * @param array array som ska initieras
	 */
	public void setArray(int[] array) {
		this.array = array.clone();

	}
	
	/**
	 * Metod för att initiera och retunera en ny instans av Array7-objekt
	 * 
	 * @return Array7 Objekt retuneras
	 */

	public Array7 getArray() {
		Array7 ny = new Array7();
		for (int i = 0; i < array.length; i++) {
			ny.setElement(i, array[i]);
		}
		return ny;
	}
	/**
	 * Metod för att initiera en ny instans utav 1D-arrayen samt returnera denna
	 * 
	 * @param array Array som ska initieras
	 * @return int[] Retunerar 1D-array
	 */
	public int[] toIntArray() { 
		return array.clone();
	}
}
