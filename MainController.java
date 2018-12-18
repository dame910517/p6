package p6;

import javax.swing.JFrame;

import java.util.Random;

public class MainController {
	private Array7x7[][] arrBack;
	private Array7x7[][] arrFore;
	private Array7x7[][] arrDisp;
	private Array7x7[][] arrText;
	private int colIndex = 0;
	private int rowIndex = 0;
	private int dispHeight = 0;
	private int dispWidth = 0;
	private Random rand = new Random();
	private Display display;
	
	public MainController() {

		dispWidth = 16;
		dispHeight = 8;
		String input = "Test badabing";

		arrDisp = new Array7x7[dispHeight][dispWidth];
		arrBack = new Array7x7[dispHeight][dispWidth];
		arrFore = new Array7x7[dispHeight][dispWidth];
		initiateArray(arrDisp);
		initiateArray(arrBack);
		initiateArray(arrFore);

		fillArrayRandom(arrBack);
		fillArray(arrFore, Color.TRANSPARENT);

		// Get text
		arrText = Characters.translate(input, Color.TRANSPARENT, Color.RED);

		// Apply the text on the foreground
		transferArray(arrFore, arrText);

		display = new Display(this);
	}

	private void initiateArray(Array7x7[][] array) {
		for (Array7x7[] rowA7x7: array)
			for (int colA7x7 = 0; colA7x7 < rowA7x7.length; colA7x7++)
				rowA7x7[colA7x7] = new Array7x7();
	}

	private void fillArrayRandom(Array7x7[][] array) {
		for (Array7x7[] rowA7x7: array)
			for (Array7x7 a7x7: rowA7x7)
				for (int rowElem = 0; rowElem < 7; rowElem++)
					for (int colElem = 0; colElem < 7; colElem++)
						a7x7.setElement(rowElem, colElem, Color.rgb(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
	}


	private void fillArray(Array7x7[][] array, int color) {
		for (Array7x7[] rowA7x7: array)
			for (Array7x7 a7x7: rowA7x7)
				for (int rowElem = 0; rowElem < 7; rowElem++)
					for (int colElem = 0; colElem < 7; colElem++)
						a7x7.setElement(rowElem, colElem, color);
			
	}

	public void fillBackground(int color) {
		fillArray(arrBack, color);
	}

	public void addPictureToBackground(Picture pic, int backgroundColor) {
		
		fillArray(arrBack, backgroundColor);

		double dDispHeight = dispHeight * 7, dDispWidth = dispWidth * 7,
				picHeight = pic.getHeight(), picWidth = pic.getWidth(),
				firstRenderRow = 0, lastRenderRow = dDispHeight - 1,
				firstRenderCol = 0, lastRenderCol = dDispWidth - 1,
				picHeightInElems, picWidthInElems, pixelsPerElem, x, y;
		
		if (dDispHeight/dDispWidth < picHeight/picWidth) {
			pixelsPerElem = picHeight/dDispHeight;
			picWidthInElems = picWidth/pixelsPerElem;
			firstRenderCol = (dDispWidth-picWidthInElems)/2;
			lastRenderCol = firstRenderCol+picWidthInElems-1;
		} else {
			pixelsPerElem = picWidth/dDispWidth;
			picHeightInElems = picHeight/pixelsPerElem;
			firstRenderRow = (dDispHeight-picHeightInElems)/2;
			lastRenderRow = firstRenderRow+picHeightInElems-1;
		}
		
		for (double row = firstRenderRow; row <= lastRenderRow; row++)
			for (double col = firstRenderCol; col <= lastRenderCol; col++) {
				x = (col-firstRenderCol)*pixelsPerElem;
				y = (row-firstRenderRow)*pixelsPerElem;
				int color = pic.getAverageColor(x, y, x+pixelsPerElem, y+pixelsPerElem);
				arrBack[(int)Math.round(row)/7][(int)Math.round(col)/7].setElement(
						(int)Math.round(row)%7, (int)Math.round(col)%7, color);
			}
	}

	public void finalizeDisplayArray() {
		transferArray(arrDisp, arrBack);
		transferArray(arrDisp, arrFore);
	}

	private void transferArray(Array7x7[][] back, Array7x7[][] fore) {
		for (int rowA7x7 = 0; rowA7x7 < back.length && rowA7x7 < fore.length; rowA7x7++)
			for (int colA7x7 = 0; colA7x7 < back[rowA7x7].length && colA7x7 < fore[rowA7x7].length; colA7x7++)
				for (int rowElem = 0; rowElem < 7; rowElem++)
					for (int colElem = 0; colElem < 7; colElem++) {
						int elem = fore[rowA7x7][colA7x7].getElement(rowElem, colElem);
						if (elem != Color.TRANSPARENT)
							back[rowA7x7][colA7x7].setElement(rowElem, colElem, elem);
					}
	}

	public void shiftLeft() throws WrongArrayLengthException {
		colIndex--;
		if (colIndex < 7 * (dispWidth-arrText[0].length))
			colIndex = (dispWidth * 7)-1;

		for (int row = 0; row < arrFore.length; row++) {
			Array7 finalCol = new Array7();
			if (arrText[0].length > arrFore[0].length) {
				int textArrIndex = dispWidth - (colIndex < 0 ? (colIndex+1)/7 : colIndex/7+1);
				int textColIndex = (dispWidth * 7 - (colIndex+1))%7;
				if (rowIndex/7 == row) // If the iterator is on the same array row as the text
					if (rowIndex%7 == 0) { // and the element row as the text
						finalCol = arrText[0][textArrIndex].getCol(textColIndex);
					} else { // Otherwise on the top half
						for (int i = rowIndex%7; i < 7; i++) {
							finalCol.setElement(i, arrText[0][textArrIndex].getCol(textColIndex).getElement(i-rowIndex%7));
						}
					}
				else  if ((row == rowIndex/7+1 || (row == 0 && rowIndex/7 == dispHeight-1)) && rowIndex%7 != 0) {
					for (int i = 0; i < rowIndex%7; i++)
						finalCol.setElement(i, arrText[0][textArrIndex].getCol(textColIndex).getElement(7-rowIndex%7+i));
				}
			} else {
				finalCol = arrFore[row][0].getCol(0);
			}
			for (int col = arrFore[row].length-1; col >= 0; col--) {
				finalCol = arrFore[row][col].shiftLeft(finalCol);
			}
		}

	}

	public void shiftRight() throws WrongArrayLengthException {
		colIndex++;
		if (colIndex > (dispWidth * 7) -1)
			colIndex = (dispWidth-arrText[0].length) * 7;
		for (int row = 0; row < arrFore.length; row++) {
			Array7 firstCol = new Array7();
			if (arrText[0].length > arrFore[0].length) {
				int textArrIndex = (colIndex <= 0 ? (Math.abs(colIndex)/7) : ((arrText[0].length * 7)-colIndex)/7);
				int textColIndex = (dispWidth * 7 - (colIndex+1))%7;
				if (rowIndex/7 == row) // If the iterator is on the same array row as the text
					for (int i = rowIndex%7; i < 7; i++)
						firstCol.setElement(i, arrText[0][textArrIndex].getCol(textColIndex).getElement(i-rowIndex%7));
				else  if ((row == rowIndex/7+1 || (row == 0 && rowIndex/7 == dispHeight-1)) && rowIndex%7 != 0) {
					for (int i = 0; i < rowIndex%7; i++)
						firstCol.setElement(i, arrText[0][textArrIndex].getCol(textColIndex).getElement(7-rowIndex%7+i));
				}
			} else {
				firstCol = arrFore[row][arrFore[row].length-1].getCol(6);
			}
			for (int col = 0; col < arrFore[row].length; col++) {
				firstCol = arrFore[row][col].shiftRight(firstCol);
			}
		}
	}

	public void shiftUp() throws WrongArrayLengthException {
		rowIndex--;
		if (rowIndex < 0)
			rowIndex = 7 * dispHeight - 1;
		for (int col = 0; col < arrFore[0].length; col++) {
			Array7 finalRow = arrFore[0][col].getRow(0);
			for (int row = arrFore.length-1; row >= 0; row--)
				finalRow = arrFore[row][col].shiftUp(finalRow);
		}
	}

	public void shiftDown() throws WrongArrayLengthException {
		rowIndex++;
		if (rowIndex >= 7 * dispHeight)
			rowIndex = 0;
		for (int col = 0; col < arrFore[0].length; col++) {
			Array7 firstRow = arrFore[arrFore.length-1][col].getRow(6);
			for (int row = 0; row < arrFore.length; row++)
				firstRow = arrFore[row][col].shiftDown(firstRow);
		}
	}

	public int getDisplayHeight() {
		return dispHeight;
	}

	public int getDisplayWidth() {
		return dispWidth;
	}
	
	public void setDisplayHeight(int height) {
		dispHeight = height;
	}

	public void setDisplayWidth(int width) {
		dispWidth = width;
	}

	public Array7x7[][] getDisplayArray() {
		return arrDisp;
	}

	private Display getDisplay() {
		return display;
	}

	public void setText(String input) {
		setText(input, Color.TRANSPARENT, Color.WHITE);
	}

	public void setText(String input, int background, int foreground) {
		arrText = Characters.translate(input, background, foreground);
		fillArray(arrFore, Color.TRANSPARENT);
		transferArray(arrFore, arrText);
		
	}

	public static void main(String[] args) {
		MainController mc = new MainController();
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(mc.getDisplay());
		frame.pack();
		frame.setVisible(true);
	}
}