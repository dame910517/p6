package p6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class Test2UI extends JPanel {
	private Array7x7 array;
	private Array7 leftColumn;
	private Array7 rightColumn;
	private JPanel pnLeft = new JPanel();
	private JPanel pnRight = new JPanel();
	private JPanel pnCenter = new JPanel();
	private JPanel pnBottom = new JPanel();
	private JButton bnLeft = new JButton("<- Move left <-");
	private JButton bnRight = new JButton("-> Move right ->");
	private JLabel[][] lbCenterArray = new JLabel[7][7];
	private JTextField[] tfLeftArray = new JTextField[7];
	private JTextField[] tfRightArray = new JTextField[7];
	private Border bor = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK);
	private Dimension dim = new Dimension(30, 30);

	public Test2UI() {
		try {
		int[][] testC = {
				{1,2,3,4,5,6,7},
				{2,3,4,5,6,7,8},
				{3,4,5,6,7,8,9},
				{4,5,6,7,8,9,10},
				{5,6,7,8,9,10,11},
				{6,7,8,9,10,11,12},
				{7,8,9,10,11,12,13}
		};
		int[] testL = {1,2,3,4,5,6,7};
		int[] testR = {7,6,5,4,3,2,1};
		array = new Array7x7(testC);
		leftColumn = new Array7(testL);
		rightColumn = new Array7(testR);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		setLayout(new BorderLayout());

		pnLeft.setLayout(new GridLayout(7,1));
		for (int i = 0; i < tfLeftArray.length; i++) {
			JTextField tf = new JTextField("0", SwingConstants.CENTER);
			tf.setBorder(bor);
			tf.setPreferredSize(dim);
			pnLeft.add(tf);
			tfLeftArray[i] = tf;
		}

		pnRight.setLayout(new GridLayout(7,1));
		for (int i = 0; i < tfRightArray.length; i++) {
			JTextField tf = new JTextField("0", SwingConstants.CENTER);
			tf.setBorder(bor);
			tf.setPreferredSize(dim);
			pnRight.add(tf);
			tfRightArray[i] = tf;
		}

		pnCenter.setLayout(new GridLayout(7, 7));
		for (int i = 0; i < lbCenterArray.length; i++)
			for (int j = 0; j < 7; j++) {
				JLabel lb = new JLabel("0", SwingConstants.CENTER);
				lb.setBorder(bor);
				lb.setPreferredSize(dim);
				pnCenter.add(lb);
				lbCenterArray[i][j] = lb;
			}	

		pnBottom.setLayout(new GridLayout(1, 2));
		MoveListener ml = new MoveListener();
		bnLeft.addActionListener(ml);
		pnBottom.add(bnLeft);
		bnRight.addActionListener(ml);
		pnBottom.add(bnRight);

		add(pnLeft, BorderLayout.EAST);
		add(pnRight, BorderLayout.WEST);
		add(pnCenter, BorderLayout.CENTER);
		add(pnBottom, BorderLayout.SOUTH);

		setAll();
	}

	public void setAll() {
		for (int i = 0; i < 7; i++)
			tfLeftArray[i].setText(Integer.toString(leftColumn.getElement(i)));

		for (int i = 0; i < 7; i++)
			tfRightArray[i].setText(Integer.toString(rightColumn.getElement(i)));

		for (int i = 0; i < array.toIntArray().length; i++)
			for (int j = 0; j < array.toIntArray()[i].length; j++)
				lbCenterArray[i][j].setText(Integer.toString(array.getElement(i, j)));
	}

	private class MoveListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(bnLeft))
				rightColumn = array.shiftLeft(leftColumn);
			else if (e.getSource().equals(bnRight))
				leftColumn = array.shiftRight(rightColumn);
			setAll();
		}
	}

	public static void main(String[] args) {
		Test2UI t2ui = new Test2UI();
		JFrame frame1 = new JFrame("Test2UI");
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.add(t2ui);
		frame1.pack();
		frame1.setVisible(true);
	}
}