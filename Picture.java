package p6;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Picture {
	private BufferedImage image;

	public Picture(String path) throws IOException {
		this(new File(path));
	}

	public Picture(File file) {
		try {
			image = ImageIO.read(file);
		} catch (IOException e) {
			System.out.println(e.toString());
		}	
	}

	public int getColor(int x, int y) {
		int clr=  image.getRGB(x,y); 
		int  red   = (clr & 0x00ff0000) >> 16;
		int  green = (clr & 0x0000ff00) >> 8;
		int  blue  =  clr & 0x000000ff;
		return Color.rgb(red, green, blue);
	}

	public int getAverageColor(double x1, double y1, double x2, double y2) {

		int color = 0;
		double xLength = 1, yLength = 1, red = 0, green = 0, blue = 0, area = 0;
		
		for (double x = x1; x < (x2 > image.getWidth() ? image.getWidth() : x2); x++) {
			for (double y = y1; y < (y2 > image.getHeight() ? image.getHeight() : y2); y++) {

				if (Math.ceil(x) != x && Math.ceil(x) <= x2)
					xLength = Math.ceil(x) - x;
				else if (Math.ceil(x) != x || x+1 > x2)
					xLength = x2 - x;

				if (Math.ceil(y) != y && Math.ceil(y) <= y2)
					yLength = Math.ceil(y) - y;
				else if (Math.ceil(y) != y || y+1 > y2)
					yLength = y2 - y;

				area += xLength * yLength;
				color =  image.getRGB((int)x, (int)y); 
				x = Math.floor(x);
				y = Math.floor(y);
				red += ((color & 0x00ff0000) >> 16) * xLength * yLength;
				green += ((color & 0x0000ff00) >> 8) * xLength * yLength;
				blue +=  (color & 0x000000ff) * xLength * yLength;
			}
		}

		if (area != 0) {
			red /= area;
			green /= area;
			blue /= area;
		}

		return Color.rgb((int)Math.round(red), (int)Math.round(green), (int)Math.round(blue));
	}

	public int getWidth() {
		return image.getWidth();
	}

	public int getHeight() {
		return image.getHeight();
	}
}