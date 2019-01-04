package p6;

import java.awt.*;
import javax.swing.*;

public class Viewer extends JPanel {
	//JPanels och JLabels
	private JPanel panel = new JPanel(new GridLayout(7,7,18,18));
	private JPanel leftColumn = new JPanel(new GridLayout(7,1,18,18));
	private JLabel array7x7 = new JLabel("Column                                                      Array7x7");
	private JLabel row = new JLabel("Row");

	private JPanel leftPanel = new JPanel();
	private JPanel rightPanel = new JPanel();
	private JPanel southPanel = new JPanel(); 
	private JPanel sydPanel = new JPanel();
	private JPanel southRowPanel = new JPanel();
	private JPanel centerPanel = new JPanel();

	//Fonten för all text och siffror
	private Font font = new Font( "SansSerif", Font.PLAIN, 16 );

	//JLabel-arraysen som dyker upp i viewer-displayen
	private JLabel[][] centerArray = new JLabel[7][7];
	private JLabel[] leftArray = new JLabel[7];
	private JLabel[] southArray = new JLabel[7];

	//Konstruktor där displayen byggs upp
	public Viewer() {
		initiateArrayLeftColumn();
		initiateArray7x7();
		initiateArraySouthRow();
		setPreferredSize(new Dimension (600, 500));
		setLayout(new BorderLayout(0,0));

		array7x7.setFont(font);
		array7x7.setPreferredSize(new Dimension(550,30));

		row.setFont(font);

		leftPanel.setPreferredSize(new Dimension(50,370));
		rightPanel.setPreferredSize(new Dimension(50,370));
		sydPanel.setPreferredSize(new Dimension(600,50));
		southPanel.setPreferredSize(new Dimension(545,50));
		centerPanel.setPreferredSize(new Dimension(300,370));

		add(array7x7, BorderLayout.NORTH);
		add(leftPanel, BorderLayout.WEST);
		add(rightPanel, BorderLayout.EAST);
		add(sydPanel, BorderLayout.SOUTH);
		add(centerPanel, BorderLayout.CENTER);

		leftPanel.add(leftColumn, BorderLayout.WEST);
		sydPanel.add(southRowPanel, BorderLayout.WEST);
		southRowPanel.add(row, BorderLayout.WEST);
		sydPanel.add(southPanel, BorderLayout.WEST);
		centerPanel.add(panel, BorderLayout.CENTER);
	}

	//Metod för att initiera 7x7-arrayen
	public void initiateArray7x7() {
		for(int row = 0; row < centerArray.length; row++) {
			for(int col = 0; col < centerArray[row].length; col ++) {
				centerArray[row][col] = new JLabel();
				centerArray[row][col].setBorder(BorderFactory.createMatteBorder(7, 10, 7, 10, java.awt.Color.WHITE));
				centerArray[row][col].setFont(font);
				panel.add(centerArray[row][col]);
			}
		}
	}

	//Metod för att fylla 7x7-arrayen
	public void setCenterArray(Array7x7 array7x7) {
		for(int row = 0; row < centerArray.length; row++) {
			for(int col = 0; col < centerArray[row].length; col ++) {
				centerArray[row][col].setText(String.valueOf(array7x7.getElement(row,col)));
			}
		}
	}

	//Metod för att initiera vänster-arrayen
	public void initiateArrayLeftColumn() {
		for(int row = 0; row < leftArray.length; row++) {
			leftArray[row] = new JLabel();
			leftArray[row].setBorder(BorderFactory.createMatteBorder(7, 10, 7, 10, java.awt.Color.WHITE));
			leftArray[row].setFont(font);
			leftColumn.add(leftArray[row]);
		}
	}

	//Metod för att fylla vänster-arrayen
	public void setArrayLeftColumn(Array7 array7) {
		for(int i = 0; i < leftArray.length; i++) {
			leftArray[i].setText(String.valueOf(array7.getElement(i)));
		}
	}

	//Metod för att fylla botten-arrayen
	public void setArrayBottomColumn(Array7 array7) {
		for(int i = 0; i < southArray.length; i++) {
			southArray[i].setText(String.valueOf(array7.getElement(i)));
		}
	}

	//Metod för att initiera botten-arrayen
	public void initiateArraySouthRow() {
		for(int i = 0; i < southArray.length; i++) {
			southArray[i] = new JLabel();
			southArray[i].setBorder(BorderFactory.createMatteBorder(7, 10, 7, 10, java.awt.Color.WHITE));
			southArray[i].setFont(font);
			southPanel.add(southArray[i]);
		}
	}
}