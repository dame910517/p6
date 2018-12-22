package p6;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

public class Input extends JPanel {
	private JPanel mainPan = new JPanel();
	private JPanel upper = new JPanel();
	private JPanel bottom = new JPanel();
	
	private JPanel rightArr = new JPanel();
	private JPanel downArr = new JPanel();
	
	private JPanel rightArrayen = new JPanel(new GridLayout(7,1,18,18));
	private JPanel downArrayen = new JPanel(new GridLayout(1,7,18,18));
	
	private JPanel upperColSpace = new JPanel();
	private JPanel bottomColSpace = new JPanel();
	
	private JButton readCol = new JButton("Read column");
	private JButton writeCol = new JButton("Write column");
	
	private JButton readRow = new JButton("Read row");
	private JButton writeRow = new JButton("Write row");
	
	private JLabel colNbr = new JLabel("Column nbr:");
	private JTextField colNbrText = new JTextField();
	
	private JLabel rowNbr = new JLabel("Row nbr:");
	private JTextField rowNbrText = new JTextField();
	
	private Font font = new Font( "SansSerif", Font.PLAIN, 16 );
	
	public void getRightArray() {
		JTextField[][] rightArray = new JTextField[7][1];
		for(int row = 0; row < rightArray.length; row++) {
			for(int col = 0; col < rightArray[row].length; col ++) {
				rightArray[row][col] = new JTextField("A");
				rightArray[row][col].setBorder(BorderFactory.createMatteBorder(7, 10, 7, 10, java.awt.Color.WHITE));
				rightArray[row][col].setFont(font);
				rightArrayen.add(rightArray[row][col]);
			}
		}
	}
	
	public void getDownArray() {
		JTextField[][] downArray = new JTextField[1][7];
		for(int row = 0; row < downArray.length; row++) {
			for(int col = 0; col < downArray[row].length; col ++) {
				downArray[row][col] = new JTextField("A");
				downArray[row][col].setBorder(BorderFactory.createMatteBorder(7, 10, 7, 10, java.awt.Color.WHITE));
				downArray[row][col].setFont(font);
				downArrayen.add(downArray[row][col]);
			}
		}
	}
	
	public Input() {
		setPreferredSize(new Dimension (600, 500));
		setLayout(new BorderLayout(0,0));
		
		mainPan.setPreferredSize(new Dimension(480,380));
//		mainPan.setBorder(BorderFactory.createLineBorder(java.awt.Color.BLACK));
		
		upperColSpace.setPreferredSize(new Dimension(460,70));
		upper.setPreferredSize(new Dimension(480,190));
		upper.setBorder(BorderFactory.createLineBorder(java.awt.Color.BLACK));
		bottom.setPreferredSize(new Dimension(480,190));
		bottom.setBorder(BorderFactory.createLineBorder(java.awt.Color.BLACK));
		bottomColSpace.setPreferredSize(new Dimension(460,70));
		
		colNbrText.setPreferredSize(new Dimension(35,25));
		readCol.setPreferredSize(new Dimension(460,50));
		writeCol.setPreferredSize(new Dimension(460,50));
		
		rowNbrText.setPreferredSize(new Dimension(35,25));
		readRow.setPreferredSize(new Dimension(460,50));
		writeRow.setPreferredSize(new Dimension(460,50));
		
		rightArr.setPreferredSize(new Dimension(130,370));
		rightArrayen.setPreferredSize(new Dimension(40,380));
		
		downArr.setPreferredSize(new Dimension(480,80));
		downArrayen.setPreferredSize(new Dimension(400,40));
		
		
		add(mainPan, BorderLayout.WEST);
		
		add(rightArr, BorderLayout.EAST);
		
		add(downArr, BorderLayout.SOUTH);
		
		mainPan.add(upper, BorderLayout.NORTH);
		upper.add(upperColSpace, BorderLayout.NORTH);
		upperColSpace.add(colNbr, BorderLayout.NORTH);
		upperColSpace.add(colNbrText, BorderLayout.NORTH);
		upper.add(readCol, BorderLayout.SOUTH);
		upper.add(writeCol, BorderLayout.SOUTH);
		
		mainPan.add(bottom, BorderLayout.SOUTH);
		bottom.add(bottomColSpace, BorderLayout.SOUTH);
		bottomColSpace.add(rowNbr, BorderLayout.SOUTH);
		bottomColSpace.add(rowNbrText, BorderLayout.SOUTH);
		bottom.add(readRow, BorderLayout.NORTH);
		bottom.add(writeRow, BorderLayout.NORTH);
		
		rightArr.add(rightArrayen, BorderLayout.CENTER);
		downArr.add(downArrayen, BorderLayout.WEST);
	}
	
	public static void main(String[]args) {
		Input input = new Input();
		JFrame frame = new JFrame("Array7x7 input");
		input.getRightArray();
		input.getDownArray();
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.add( input );
		frame.pack();
		frame.setVisible( true );

	}
}