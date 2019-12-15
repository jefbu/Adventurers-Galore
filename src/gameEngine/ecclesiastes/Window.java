package gameEngine.ecclesiastes;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Window {

	private JFrame frame;
	private BufferedImage image;
	private Canvas canvas;
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
		
		frame = new JFrame(gameContainer.getTitle());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(canvas, BorderLayout.CENTER);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
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
