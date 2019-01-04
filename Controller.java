package p6;

public class Controller {

	//Testarray för viewer- och inputklasserna
	private int[][] testArray = {
			{1, 8, 4, 6, 9, 0, 0},
			{2, 9, 0, 6, 8, 2, 0},
			{2, 5, 0, 6, 5, 9, 0},
			{6, 1, 0, 9, 4, 4, 0},
			{8, 6, 2, 6, 5, 9, 0},
			{7, 5, 0, 6, 1, 8, 0},
			{1, 0, 0, 6, 1, 9, 0},
	};

	private Array7x7 array = new Array7x7();
	private Viewer viewer;

	//Konstruktorn tar emot viewer som inparameter för kopplingen
	public Controller(Viewer viewer) {
		this.viewer = viewer;
		array.setArray(testArray);
		viewer.setCenterArray(array);
	}

	//Metod för att läsa/hämta och skicka vidare raden till displayen
	public void readRow(int row) {
		Array7 readR = array.getRow(row);
		viewer.setArrayBottomColumn(readR);
	}

	//Metod för att läsa/hämta och skicka vidare kolumnen till displayen
	public void readColumn(int col) {
		Array7 readC = array.getCol(col);
		viewer.setArrayLeftColumn(readC);
	}

	//Metod för att skriva och skicka vidare kolumnen till displayen
	public void writeColumn(int col, Array7 arr7) {
		array.setCol(col, arr7);
		viewer.setCenterArray(array);
	}

	//Metod för att skriva och skicka vidare raden till displayen
	public void writeRow(int row, Array7 arr7) {
		array.setRow(row, arr7);
		viewer.setCenterArray(array);
	}
}