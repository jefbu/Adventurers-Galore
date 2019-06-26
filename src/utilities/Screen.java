package utilities;

import javax.swing.JFrame;

public class Screen extends JFrame {
	
	public int width;
	public int height;
	public int[] screenWidthPixels;
	public int[] screenHeightPixels;

	private static final long serialVersionUID = 1L;

	public Screen() {
		
		super();
		screenWidthPixels = new int[width];
		screenHeightPixels = new int[height];
		
	}

}
