package p6;

import java.awt.*;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.*;


public class Viewer extends JPanel {
	//Panel
	private JPanel panel = new JPanel(new GridLayout(7,7,18,18));
	private JPanel leftColumn = new JPanel(new GridLayout(7,1,18,18));
	private JPanel southRow = new JPanel(new GridLayout(1,7,18,18));
	private JPanel topPanel = new JPanel();
	private JPanel topLeftPanel = new JPanel();
	private JPanel KOLUMN = new JPanel();
	private JLabel array7x7 = new JLabel("Column                                                      Array7x7");
	private JLabel column = new JLabel("Column");
	private JLabel row = new JLabel("Row");

	//GridPanel för Array7x7
	private JPanel mainPanel = new JPanel();
	private JPanel leftPanel = new JPanel();
	private JPanel rightPanel = new JPanel();
	private JPanel southPanel = new JPanel(); //själva shitet 
	private JPanel sydPanel = new JPanel();
	private JPanel southRowPanel = new JPanel();
	private JPanel centerPanel = new JPanel();
	
	


	private Font font = new Font( "SansSerif", Font.PLAIN, 16 );

	//Vänsterkolumnen "Column"
	private JLabel leftColumn1 = new JLabel("");
	private JLabel leftColumn2 = new JLabel("");
	private JLabel leftColumn3 = new JLabel("");
	private JLabel leftColumn4 = new JLabel("");
	private JLabel leftColumn5 = new JLabel("");
	private JLabel leftColumn6 = new JLabel("");
	private JLabel leftColumn7 = new JLabel("");

	//Nedersta raden "Row"
	private JLabel bottomRow1 = new JLabel();
	private JLabel bottomRow2 = new JLabel();
	private JLabel bottomRow3 = new JLabel();
	private JLabel bottomRow4 = new JLabel();
	private JLabel bottomRow5 = new JLabel();
	private JLabel bottomRow6 = new JLabel();
	private JLabel bottomRow7 = new JLabel();

	//Array7x7

	public void getArrayLeftColumn() {
		JLabel[][] leftArray = new JLabel[7][1];
		for(int row = 0; row < leftArray.length; row++) {
			for(int col = 0; col < leftArray[row].length; col ++) {
				leftArray[row][col] = new JLabel("B");
				leftArray[row][col].setBorder(BorderFactory.createMatteBorder(7, 10, 7, 10, java.awt.Color.WHITE));
				leftArray[row][col].setFont(font);
				leftColumn.add(leftArray[row][col]);
			}
		}
	}

	public void getArray7x7() {
		JLabel[][] centerArray = new JLabel[7][7];
		for(int row = 0; row < centerArray.length; row++) {
			for(int col = 0; col < centerArray[row].length; col ++) {
				centerArray[row][col] = new JLabel("A");
				centerArray[row][col].setBorder(BorderFactory.createMatteBorder(7, 10, 7, 10, java.awt.Color.WHITE));
				centerArray[row][col].setFont(font);
				panel.add(centerArray[row][col]);
			}
		}
	}

	public void getArraySouthRow() {
		JLabel[][] southRow = new JLabel[1][7];
		for(int row = 0; row < southRow.length; row++) {
			for(int col = 0; col < southRow[row].length; col ++) {
				southRow[row][col] = new JLabel("C");
				southRow[row][col].setBorder(BorderFactory.createMatteBorder(7, 10, 7, 10, java.awt.Color.WHITE));
				southRow[row][col].setFont(font);
				southPanel.add(southRow[row][col]);
			}
		}
	}
	public Viewer() {
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
		
//		add(southPanel, BorderLayout.SOUTH);
		
		add(centerPanel, BorderLayout.CENTER);
			
		leftPanel.add(leftColumn, BorderLayout.WEST);
		sydPanel.add(southRowPanel, BorderLayout.WEST);
		southRowPanel.add(row, BorderLayout.WEST);
		sydPanel.add(southPanel, BorderLayout.WEST);
//		southPanel.add(southRow, BorderLayout.WEST);
		centerPanel.add(panel, BorderLayout.CENTER);
	}

	public static void main(String[]args) {
		Viewer viewer = new Viewer();
		JFrame frame = new JFrame("Array7x7 viewer");
		viewer.getArrayLeftColumn();
		viewer.getArray7x7();
		viewer.getArraySouthRow();
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.add( viewer );
		frame.pack();
		frame.setVisible( true );

	}
}
