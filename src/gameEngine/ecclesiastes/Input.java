package gameEngine.ecclesiastes;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class Input implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {
	
	private GameContainer gameContainer;
	
	private final int KEYSNUMBER = 256;
	private boolean[] keys = new boolean[KEYSNUMBER];
	private boolean[] keysLastFrame = new boolean[KEYSNUMBER];
	
	private final int BUTTONSNUMBER = 5;
	private boolean[] buttons = new boolean[BUTTONSNUMBER];
	private boolean[] buttonsLastFrame = new boolean[BUTTONSNUMBER];
	
	private int mouseX, mouseY;
	private int scroll;
	
	public Input(GameContainer gameContainer) {
		
		this.gameContainer = gameContainer;
		mouseX = 0;
		mouseY = 0;
		scroll = 0;
		
		gameContainer.getWindow().getCanvas().addKeyListener(this);
		gameContainer.getWindow().getCanvas().addMouseMotionListener(this);
		gameContainer.getWindow().getCanvas().addMouseListener(this);
		gameContainer.getWindow().getCanvas().addMouseWheelListener(this);
		
	}
	
	public void update() {
		
		scroll = 0;
		
		for (int i = 0; i < KEYSNUMBER; i++) {
			keysLastFrame[i] = keys[i];
		}
		for (int i = 0; i < BUTTONSNUMBER; i++) {
			buttonsLastFrame[i] = buttons[i];
		}
		
	}
	
	public boolean isKey(int keyCode) {
		return keys[keyCode];
	}
	
	public boolean isKeyUp(int keyCode) {
		return !keys[keyCode] && keysLastFrame[keyCode];
	}
	
	public boolean isKeyDown(int keyCode) {
		return keys[keyCode] && !keysLastFrame[keyCode];
	}
	
	public boolean isButton(int button) {
		return buttons[button];
	}
	
	public boolean isButtonUp(int button) {
		return !buttons[button] && buttonsLastFrame[button];
	}
	
	public boolean isButtonDown(int button) {
		return buttons[button] && !buttonsLastFrame[button];
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		scroll = e.getWheelRotation();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO DRAGGING SPECIFIC CODE
		mouseX = (int)(e.getX() / gameContainer.getScale());
		mouseY = (int)(e.getY() / gameContainer.getScale());		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = (int)(e.getX() / gameContainer.getScale());
		mouseY = (int)(e.getY() / gameContainer.getScale());
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		buttons[e.getButton()] = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		buttons[e.getButton()] = false;		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public int getMouseX() {
		return mouseX;
	}

	public int getMouseY() {
		return mouseY;
	}

	public int getScroll() {
		return scroll;
	}

	public void setMouseX(int mouseX) {
		this.mouseX = mouseX;
	}

	public void setMouseY(int mouseY) {
		this.mouseY = mouseY;
	}

}
