package p6;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

public class Display extends JPanel {
	private Timer timer;

	private ImageIcon imgSetText = new ImageIcon("Images/settext2.jpg");
	private ImageIcon imgChooseImage = new ImageIcon("Images/chooseimage.jpg");

	private JPanel pnlColorPanel = new JPanel(new BorderLayout());
	private JPanel pnlArrows = new JPanel(new GridLayout(3, 3));
	private JPanel pnlSouth = new JPanel(new GridLayout(1, 3));

	// Knappar för att styra bokstävernas flöde i fönstret.
	private JButton btnUpLeft = new JButton("↖");
	private JButton btnUp = new JButton(" ↑");
	private JButton btnUpRight = new JButton("↗");
	private JButton btnLeft = new JButton("←");
	private JButton btnCenter = new JButton("Stop");
	private JButton btnRight = new JButton("→");
	private JButton btnDownLeft = new JButton("↙");
	private JButton btnDown = new JButton("↓");
	private JButton btnDownRight = new JButton("↘");

	private JFileChooser fileChooser = new JFileChooser();

	// Knappar för att sätta text och bild
	private JButton btnSetText = new JButton("Skriv in en text"); // JButton(imgSetText);
	private JButton btnBigRight = new JButton("Välj en bild"); // (imgChooseImage);

	private MainController mc;
	private ColorDisplay cd = new ColorDisplay(7, 10, Color.WHITE, Color.BLACK, 1, 10);

	public Display(MainController mc) {
		this.mc = mc;
		mc.setDisplaySize(7, 10);
		mc.fillArrayRandom();
		mc.finalizeDisplayArray();

		setPreferredSize(new Dimension(755, 630));
		setLayout(new BorderLayout());

		pnlArrows.add(btnUpLeft);
		pnlArrows.add(btnUp);
		pnlArrows.add(btnUpRight);
		pnlArrows.add(btnLeft);
		pnlArrows.add(btnCenter);
		pnlArrows.add(btnRight);
		pnlArrows.add(btnDownLeft);
		pnlArrows.add(btnDown);
		pnlArrows.add(btnDownRight);

		pnlSouth.add(btnSetText);
		pnlSouth.add(pnlArrows);
		pnlSouth.add(btnBigRight);

		pnlColorPanel.add(cd);

		add(pnlColorPanel, BorderLayout.NORTH);
		add(pnlSouth, BorderLayout.SOUTH);

		ScrollerListener listener = new ScrollerListener();

		btnUpLeft.addActionListener(listener);
		btnUp.addActionListener(listener);
		btnUpRight.addActionListener(listener);
		btnLeft.addActionListener(listener);
		btnCenter.addActionListener(listener);
		btnRight.addActionListener(listener);
		btnDownLeft.addActionListener(listener);
		btnDown.addActionListener(listener);
		btnDownRight.addActionListener(listener);
		btnSetText.addActionListener(listener);

		OpenDirectoryListener odListener = new OpenDirectoryListener();
		btnBigRight.addActionListener(odListener);
		btnSetText.addActionListener(new DecideText());

	}

	public void addArray() {
		Array7x7 array[][] = mc.getDisplayArray();
		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col++) {
				cd.setDisplay(array[row][col].toIntArray(), row, col);
			}
		}
		cd.updateDisplay();
	}

	private class ScrollerListener implements ActionListener {// NÄR kollla vilken knapp
		public void actionPerformed(ActionEvent e) {

			ScrollerTask task = new ScrollerTask((JButton) e.getSource());
			timer = new Timer();
			timer.schedule(task, 100, 100);
		}
	}

	private class ScrollerTask extends TimerTask {
		private JButton input;

		public ScrollerTask(JButton input) {
			this.input = input;
		}

		@Override
		public void run() {
			if (input.equals(btnUpLeft)) {// kollar vilken knapp
				mc.shiftTextLeft();
				mc.shiftTextUp();
			} else if (input.equals(btnUp)) {
				mc.shiftTextUp();
			} else if (input.equals(btnUpRight)) {
				mc.shiftTextUp();
				mc.shiftTextRight();
			} else if (input.equals(btnLeft)) {
				mc.shiftTextLeft();
			} else if (input.equals(btnCenter)) {
				timer.cancel();
				timer.purge();
			} else if (input.equals(btnRight)) {
				mc.shiftTextRight();
			} else if (input.equals(btnDownLeft)) {
				mc.shiftTextDown();
				mc.shiftTextLeft();
			} else if (input.equals(btnDown)) {
				mc.shiftTextDown();
			} else if (input.equals(btnDownRight)) {
				mc.shiftTextDown();
				mc.shiftTextRight();
			}
			mc.finalizeDisplayArray();
			addArray();
		}
	}

	private class DecideText implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String input = JOptionPane.showInputDialog(null, "Write the text you wish to display");
			mc.setText(input);
			mc.finalizeDisplayArray();
			addArray();
		}
	}

	private class OpenDirectoryListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int ret = fileChooser.showOpenDialog(null);
			if (e.getSource() == btnBigRight) {
				if (ret == JFileChooser.APPROVE_OPTION) {
					Picture picture = new Picture(fileChooser.getSelectedFile());
				}
			}
		}
	}

	public static void main(String[] args) {
		MainController mc = new MainController();
		Display display = new Display(mc);
		JFrame frame1 = new JFrame("Display");
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.add(display);
		display.addArray();
		frame1.setLocationRelativeTo(null);
		frame1.pack();
		frame1.setVisible(true);
	}
}

