package main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import utilities.GameStateValue;
import utilities.Screen;

public class Game extends Canvas {

	private static final long serialVersionUID = 1L;

	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private static BufferedImage image = new BufferedImage((int)screenSize.getWidth(), (int)screenSize.getHeight(),
			BufferedImage.TYPE_INT_RGB);
	public static int[] renderPixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	
	public Screen screen;
	public static GameStateValue gameStateValue;
	private GameState gameState;

	public Game() {
		setSize(screenSize);
		screen = new Screen();
		screen.setSize(screenSize);
		gameStateValue = GameStateValue.TITLESCREEN;
		gameState = new GameState();
	}

	public void update() {		
		gameState.update(gameStateValue);
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		for (int i = 0; i < renderPixels.length; i++) {
			renderPixels[i] = 0x00000000;
		}

		gameState.render(gameStateValue);

		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		bs.show();
	}

}
