package gameEngine.ecclesiastes;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window {

	public JFrame frame;
	private BufferedImage image;
	public Canvas canvas;
	private BufferStrategy bufferStrategy;
	private Graphics g;

	public Window(GameContainer gameContainer) {

		image = new BufferedImage(gameContainer.getWidth(), gameContainer.getHeight(), BufferedImage.TYPE_INT_RGB);
		canvas = new Canvas();
		Dimension canvasDimension = new Dimension((int) (gameContainer.getWidth() * gameContainer.getScale()),
				(int) (gameContainer.getHeight() * gameContainer.getScale()));
		canvas.setPreferredSize(canvasDimension);
		canvas.setMinimumSize(canvasDimension);
		canvas.setMaximumSize(canvasDimension);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image cursor = null;
		try {
			//cursor = toolkit.getImage("/res/mouseCursor.png");
			cursor = toolkit.getImage("C:\\Adventurers-Galore\\res\\mouseCursor.png");
			//cursor = toolkit.getImage(new URL("https://lh3.googleusercontent.com/BpEdb0usPM1TcTcqThDuOuIN0YkBnbPhvVKxx76nH7KdXb9gKIJAWEFXKZe_yNklLssrdjZp=w128-h128-e365"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Point hotSpot = new Point(0,0);
		Cursor customCursor = toolkit.createCustomCursor(cursor, hotSpot, "Custom Cursor");
		
		//GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		//GraphicsDevice graphicsDevice = graphicsEnvironment.getDefaultScreenDevice();
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenHeight = (int) screenSize.getHeight();
		int screenWidth = (int) screenSize.getWidth();
		double ratio = 100 * screenSize.getHeight() / screenSize.getWidth();
		System.out.println("Ratio of screenSize: " + ratio);
		
		int division = 0;
		if(ratio > 60) { division = 12; } else { division = 8; }
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(Color.BLACK);
		leftPanel.setPreferredSize(new Dimension (screenWidth / division, screenHeight));
		System.out.println("Black Panels width: " + screenWidth / division);
		System.out.println("Black Panels height: " + screenHeight);
		JPanel rightPanel = new JPanel();
		rightPanel.setBackground(Color.BLACK);
		rightPanel.setPreferredSize(new Dimension (screenWidth / division, screenHeight));
		
		frame = new JFrame(gameContainer.getTitle());
		frame.setPreferredSize(new Dimension(screenWidth, screenHeight));
		frame.setUndecorated(true);
		frame.setCursor(customCursor);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(leftPanel, BorderLayout.WEST);
		frame.add(canvas, BorderLayout.CENTER);
		frame.add(rightPanel, BorderLayout.EAST);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		//graphicsDevice.setFullScreenWindow(frame);
		frame.setVisible(true);
		
		System.out.println("Frame width: " + frame.getWidth());
						
		canvas.createBufferStrategy(2);
		bufferStrategy = canvas.getBufferStrategy();
		g = bufferStrategy.getDrawGraphics();
		

		
	}
	
	public void update() {
		
		g.drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
		bufferStrategy.show();
		
	}

	public BufferedImage getImage() {
		return image;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public JFrame getFrame() {
		return frame;
	}

}
