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

	private JPanel pnlColorPanel = new JPanel( new BorderLayout() );
	private JPanel pnlArrows = new JPanel( new GridLayout(3, 3) );
	private JPanel pnlSouth = new JPanel( new GridLayout(1, 3) );

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

	// Knappar för att sätta texten
	private JButton btnSetText = new JButton( imgSetText );
	private JButton btnBigRight = new JButton( imgChooseImage );

	private MainController mc;
	private ColorDisplay cd = new ColorDisplay(7,10,Color.WHITE,Color.BLACK,1,10);

	public Display( MainController mc ) {
		this.mc = mc; 
		mc.setDisplaySize( 7, 10 );
		mc.fillArrayRandom();
		mc.finalizeDisplayArray();

		setPreferredSize( new Dimension ( 755, 630 ) );
		setLayout( new BorderLayout() );

		// pnlArrows innehåller pilarna för att användaren ska kunna styra i vilken riktning
		// texten rör sig över fönstret
		pnlArrows.add( btnUpLeft );
		pnlArrows.add( btnUp );
		pnlArrows.add( btnUpRight );
		pnlArrows.add( btnLeft );
		pnlArrows.add( btnCenter );
		pnlArrows.add( btnRight );
		pnlArrows.add( btnDownLeft );
		pnlArrows.add( btnDown );
		pnlArrows.add( btnDownRight );

		pnlSouth.add( btnSetText );
		pnlSouth.add( pnlArrows );
		pnlSouth.add( btnBigRight );

		pnlColorPanel.add( cd );

		add( pnlColorPanel, BorderLayout.NORTH );
		add( pnlSouth, BorderLayout.SOUTH );

		AL listener = new AL();

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
		

	}
	
	public void addArray() {
		Array7x7 array[][] = mc.getDisplayArray();
		for( int row = 0 ; row < array.length ; row++ ) {
			for( int col = 0 ; col < array[row].length ; col++ ) {
				cd.setDisplay( array[row][col].toIntArray(), row, col );
			}
		}
		cd.updateDisplay();
	}
	
	public void pauseText() {
	}
	
	private class Scroller extends TimerTask {
		public Scroller( JButton btn ) {
			
		}
		public void actionPerformed( ActionEvent e ) {
			
		}
		@Override
		public void run() {
			
		}
		// konstruktor 
		// ta emot jbutton-input
		// scroll listener
		// stoplistener
		
	}
	
	private class OpenDirectoryListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int ret = fileChooser.showOpenDialog( null );
			if( e.getSource() == btnBigRight ) {
				if( ret == JFileChooser.APPROVE_OPTION ) {
					Picture picture = new Picture( fileChooser.getSelectedFile() );	
				}
			}
		}
	}

	private class AL implements ActionListener { 
		public void actionPerformed(ActionEvent e) {
			if( e.getSource() == btnUpLeft ) {
				mc.shiftTextLeft();
				
			} else if( e.getSource() == btnUp ) {
				mc.shiftTextUp();
				
			} else if( e.getSource() == btnUpRight ) {
				mc.shiftTextUp();
				mc.shiftTextRight();
				
			} else if( e.getSource() == btnLeft ) {
				mc.shiftTextLeft();
				
			} else if( e.getSource() == btnCenter ) {
				pauseText();
				
			} else if( e.getSource() == btnRight ) {
				mc.shiftTextRight();

			} else if( e.getSource() == btnDownLeft ) {
				mc.shiftTextDown();
				mc.shiftTextLeft();

			} else if( e.getSource() == btnDown ) {
				mc.shiftTextDown();

			} else if( e.getSource() == btnDownRight ) {
				mc.shiftTextDown();
				mc.shiftTextRight();

			} else if( e.getSource() == btnSetText ) {
				String input = JOptionPane.showInputDialog(null, "Write the text you wish to display");
				mc.setText( input );
				mc.finalizeDisplayArray();
				addArray();
//				mc.fillArrayRandom();
			}
		}
	}

	public static void main(String[] args) {
		MainController mc = new MainController();
		Display display = new Display( mc );
		JFrame frame1 = new JFrame( "Display" );
		frame1.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame1.add( display );
		frame1.setLocationRelativeTo(null);
		frame1.pack();
		frame1.setVisible( true );
	}
}

