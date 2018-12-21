package p6;

import javax.swing.JFrame;
import java.util.Random;

/**
 * En klass för att skapa en array som kan appliceras på en ColorDisplay med olika effekter
 * @author Filip Spånberg
 */
public class MainController {
	private Array7x7[][] arrBack;
	private Array7x7[][] arrFore;
	private Array7x7[][] arrDisp;
	private Array7x7[][] arrText;
	private LoopingCounter nextColRight;
	private LoopingCounter nextColLeft;
	private LoopingCounter rowIndex;
	private int dispHeight;
	private int dispWidth;
	private Random rand = new Random();
	private Display display;

	/**
	 * Konstruktor
	 */
	public MainController() {

		dispWidth = 8;
		dispHeight = 8;
		String input = "Test badabing ";

		arrDisp = new Array7x7[dispHeight][dispWidth];
		arrBack = new Array7x7[dispHeight][dispWidth];
		arrFore = new Array7x7[dispHeight][dispWidth];
		initiateArray(arrDisp);
		initiateArray(arrBack);
		initiateArray(arrFore);

		fillArray(arrBack, Color.BLACK);
		fillArray(arrFore, Color.TRANSPARENT);

		// Get text
		//arrText = Characters.translate(input, Color.TRANSPARENT, Color.RED);
		setText(input, Color.TRANSPARENT, Color.RED);

		// Apply the text on the foreground
		transferArray(arrFore, arrText);

		display = new Display(this);
	}

	/**
	 * Metod för att initiera en 2D-array med Array7x7-objekt
	 * @param array Den array som ska initieras
	 */
	private void initiateArray(Array7x7[][] array) {
		for (Array7x7[] rowA7x7: array)
			for (int colA7x7 = 0; colA7x7 < rowA7x7.length; colA7x7++)
				rowA7x7[colA7x7] = new Array7x7();
	}

	/**
	 * Fyller en Array7x7 2D-array med slumpmässigfa färger
	 * @param array Den array som ska fyllas
	 */
	private void fillArrayRandom(Array7x7[][] array) {
		for (Array7x7[] rowA7x7: array)
			for (Array7x7 a7x7: rowA7x7)
				for (int rowElem = 0; rowElem < 7; rowElem++)
					for (int colElem = 0; colElem < 7; colElem++)
						a7x7.setElement(rowElem, colElem, Color.rgb(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
	}

	/**
	 * Fyller en Array7x7 2D-array med 
	 * @param array Den array som ska fyllas
	 * @param color Färgen som ska användas, i formatet som beskrivs i Color-klassen i samma paket
	 */
	private void fillArray(Array7x7[][] array, int color) {
		for (Array7x7[] rowA7x7: array)
			for (Array7x7 a7x7: rowA7x7)
				for (int rowElem = 0; rowElem < 7; rowElem++)
					for (int colElem = 0; colElem < 7; colElem++)
						a7x7.setElement(rowElem, colElem, color);

	}

	/**
	 * Fyller backgrundsarrayen med en färg
	 * @param color Färgen som ska användas, i formatet som beskrivs i Color-klassen i samma paket
	 */
	public void fillBackground(int color) {
		fillArray(arrBack, color);
	}

	/**
	 * Fyller bakgrundsarrayen med en färg, och applicerar sedan en bild på den
	 * @param pic Bilden som ska användas, i formatet Picture som beskrivs i Picture-klassen i samma paket
	 * @param backgroundColor Färgen som ska användas, i formatet som beskrivs i Color-klassen i samma paket
	 */
	public void addPictureToBackground(Picture pic, int backgroundColor) {

		fillArray(arrBack, backgroundColor); // Fyll bakgrunden med färgen backgroundColor

		// Skapa de variabler som kommer behövas
		double dDispHeight = dispHeight * 7, dDispWidth = dispWidth * 7,
				picHeight = pic.getHeight(), picWidth = pic.getWidth(),
				firstRenderRow = 0, lastRenderRow = dDispHeight - 1,
				firstRenderCol = 0, lastRenderCol = dDispWidth - 1,
				picHeightInElems, picWidthInElems, pixelsPerElem, x, y;

		/* Ta reda på om displayens bredd/höjd ratio är större eller mindre än bildens
		 * och initiera variablerna därefter.
		 */
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

	/**
	 * Applicera för- och bakgrunden på den slutgiltiga arrayen som ska skickas vidare till ColorDisplay
	 */
	public void finalizeDisplayArray() {
		transferArray(arrDisp, arrBack);
		transferArray(arrDisp, arrFore);
	}

	/**
	 * Applicera en array på en annan, med undantag om färgen ska vara genomskinlig
	 * @param back Array7x7 2D array som ska appliceras på
	 * @param fore Array7x7 2D-array som ska appliceras från
	 */
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

	/**
	 * Flytta texten ett steg till vänster
	 * @throws WrongArrayLengthException
	 */
	public void shiftLeft() throws WrongArrayLengthException {

		nextColRight.increase();
		nextColLeft.increase();

		for (int row = 0; row < arrFore.length; row++) {
			Array7 finalCol = new Array7();
			// Om texten är bredare än vad ColorDisplay är,
			if (arrText[0].length > arrFore[0].length) {

				//test
				int textColA7x7Index = nextColRight.getCounter()/7;
				int textColElemIndex = nextColRight.getCounter()%7;
				
				// Om iteratorn är på samma Array7x7-rad som texten är på
				if (rowIndex.getCounter()/7 == row) {
					// Skapa ett Array7-objekt med den övre delen av texten
					for (int i = rowIndex.getCounter()%7; i < 7; i++)
						finalCol.setElement(i, arrText[0][textColA7x7Index].getCol(textColElemIndex).getElement(i-rowIndex.getCounter()%7));
					// Annars (om vi är på raden under text-index, eller om vi är på översta raden medan text-raden är på den understa)
				} else  if ((row == rowIndex.getCounter()/7+1 || (row == 0 && rowIndex.getCounter()/7 == dispHeight-1)) && rowIndex.getCounter()%7 != 0) {
					// Skapa ett Array7-objekt med den undre delen av texten
					for (int i = 0; i < rowIndex.getCounter()%7; i++)
						finalCol.setElement(i, arrText[0][textColA7x7Index].getCol(textColElemIndex).getElement(7-rowIndex.getCounter()%7+i));
				}
				// Annars (om texten inte är bredare än ColorDisplay), plocka den första kolumnen
			} else {
				finalCol = arrFore[row][0].getCol(0);
			}
			// Iterera sedan igenom hela skärmen och flytta alla Array7x7-objekts kolumner ett steg till vänster
			for (int col = arrFore[row].length-1; col >= 0; col--) {
				finalCol = arrFore[row][col].shiftLeft(finalCol);
			}
		}

	}

	/**
	 * Flytta texten ett steg till höger
	 * @throws WrongArrayLengthException
	 */
	public void shiftRight() throws WrongArrayLengthException {

		nextColRight.decrease();
		nextColLeft.decrease();

		for (int row = 0; row < arrFore.length; row++) {
			Array7 firstCol = new Array7();
			// Om texten är bredare än vad ColorDisplay är,
			if (arrText[0].length > arrFore[0].length) {

				int textColA7x7Index = nextColLeft.getCounter()/7,
						textColElemIndex = nextColLeft.getCounter()%7,
						textRowA7x7Index = rowIndex.getCounter()/7,
						textRowElemIndex = rowIndex.getCounter()%7;
				// Om iteratorn är på samma Array7x7-rad som texten är på
				if (textRowA7x7Index == row) {
					// Skapa ett Array7-objekt med den övre delen av texten
					for (int i = rowIndex.getCounter()%7; i < 7; i++)
						firstCol.setElement(i, arrText[0][textColA7x7Index].getCol(textColElemIndex).getElement(i-rowIndex.getCounter()%7));
					// Annars (om vi är på raden under text-index, eller om vi är på översta raden medan text-raden är på den understa)
				} else  if ((row == textRowA7x7Index+1 || (row == 0 && textRowA7x7Index == dispHeight-1)) && rowIndex.getCounter()%7 != 0) {
					// Skapa ett Array7-objekt med den undre delen av texten
					for (int i = 0; i < rowIndex.getCounter()%7; i++)
						firstCol.setElement(i, arrText[0][textColA7x7Index].getCol(textColElemIndex).getElement(7-rowIndex.getCounter()%7+i));
				}
				// Annars (om texten inte är bredare än ColorDisplay), plocka den första kolumnen
			} else {
				firstCol = arrFore[row][arrFore[row].length-1].getCol(6);
			}
			// Iterera sedan igenom hela skärmen och flytta alla Array7x7-objekts kolumner ett steg till vänster
			for (int col = 0; col < arrFore[row].length; col++) {
				firstCol = arrFore[row][col].shiftRight(firstCol);
			}
		}
	}

	/**
	 * Flytta texten ett steg uppåt
	 * @throws WrongArrayLengthException
	 */
	public void shiftUp() throws WrongArrayLengthException {
		// Håll reda på vid vilket rad-index texten är för närvarande
		rowIndex.decrease();
		
		// Flytta alla element ett steg uppåt
		for (int col = 0; col < arrFore[0].length; col++) {
			Array7 finalRow = arrFore[0][col].getRow(0);
			for (int row = arrFore.length-1; row >= 0; row--)
				finalRow = arrFore[row][col].shiftUp(finalRow);
		}
	}
	/**
	 * Flytta texten ett steg nedåt
	 * @throws WrongArrayLengthException
	 */
	public void shiftDown() throws WrongArrayLengthException {
		// Håll reda på vid vilket rad-index texten är för närvarande
		rowIndex.increase();

		// Flytta alla element ett steg nedåt
		for (int col = 0; col < arrFore[0].length; col++) {
			Array7 firstRow = arrFore[arrFore.length-1][col].getRow(6);
			for (int row = 0; row < arrFore.length; row++)
				firstRow = arrFore[row][col].shiftDown(firstRow);
		}
	}

	/**
	 *  Hämta bredden på skärmen
	 *  @return Bredden på skärmen i Array7x7-objekt
	 */
	public int getDisplayHeight() {
		return dispHeight;
	}
	/**
	 * Hämtar höjden på skärmen
	 * @return Höjden på skärmen i Array7x7-objekt
	 */
	public int getDisplayWidth() {
		return dispWidth;
	}

	/**
	 * Sätter höjden på skärmen
	 * @param height Höjden på skärmen i Array7x7-objekt
	 */
	public void setDisplayHeight(int height) {
		dispHeight = height;
	}

	/**
	 * Sätter bredden på skärmen
	 * @param height Bredden på skärmen i Array7x7-objekt
	 */
	public void setDisplayWidth(int width) {
		dispWidth = width;
	}

	/**
	 * Hämtar Array7x7 2D-arrayen som ska appliceras på ColorDisplay
	 * @return
	 */
	public Array7x7[][] getDisplayArray() {
		return arrDisp;
	}

	/** 
	 * Hämtar Display-objektet som MainController använder
	 * @return
	 */
	private Display getDisplay() {
		return display;
	}

	/**
	 * Sätter texten som ska rullar över skärmen med standardfärger (vit med genomskinlig bakgrund)
	 * @param input
	 */
	public void setText(String input) {
		setText(input, Color.TRANSPARENT, Color.WHITE);
	}

	/**
	 * Sätter texten som ska rullar över skärmen med valfria färger
	 * @param input Texten som sätts
	 * @param background Bakgrundsfärgen
	 * @param foreground Textfärgen 
	 */
	public void setText(String input, int background, int foreground) {
		arrText = Characters.translate(input, background, foreground);
		fillArray(arrFore, Color.TRANSPARENT);
		transferArray(arrFore, arrText);
		//nextColRight = (dispWidth * 7) - 1;
		nextColRight = new LoopingCounter(0, (arrText[0].length*7) - 1, dispWidth*7-1);
		nextColLeft = new LoopingCounter(arrText[0].length*7-1);
		rowIndex = new LoopingCounter(dispHeight*7-1);

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