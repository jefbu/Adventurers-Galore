package com.redhaan.adventurersGalore.titleScreen.titleMenu;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.GameState;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class TitleMenu extends GameObject {
	
	private int arrowX, arrowY;
	
	Rectangle startRect;
	Rectangle loadRect;
	Rectangle exitRect;
	
	public TitleMenu() {
		
		arrowX = 15;
		arrowY = 15;
		
		startRect = new Rectangle("(S)tart", 10, 10, 150, 30);
		loadRect = new Rectangle("(L)oad", 10, 45, 150, 30);
		exitRect = new Rectangle("(E)xit", 10, 80, 150, 30);
		
		startRect.setActive(true);
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
			System.out.println("clicked");
		};
		
		if(startRect.isActive()) {
			if(gameContainer.getInput().isKeyUp(KeyEvent.VK_DOWN)) {
				startRect.setActive(false);
				loadRect.setActive(true);
				arrowY = 50;
			}
		}
		else if (loadRect.isActive()) {
			if(gameContainer.getInput().isKeyUp(KeyEvent.VK_DOWN)) {
				loadRect.setActive(false);
				exitRect.setActive(true);
				arrowY = 85;
			}
			else if(gameContainer.getInput().isKeyUp(KeyEvent.VK_UP)) {
				loadRect.setActive(false);
				startRect.setActive(true);
				arrowY = 15;
			}
		}
		else if (exitRect.isActive()) {
			if(gameContainer.getInput().isKeyUp(KeyEvent.VK_UP)) {
				exitRect.setActive(false);
				loadRect.setActive(true);
				arrowY = 50;
			}
		}
		
		if(gameContainer.getInput().isKeyUp(KeyEvent.VK_ENTER)) {
			if(startRect.isActive()) { GameManager.gameState = GameState.WorldMap; }
		}
		if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
			if(gameContainer.getInput().getMouseX() > 10 && gameContainer.getInput().getMouseX() < 160 &&
				gameContainer.getInput().getMouseY() > 10 && gameContainer.getInput().getMouseY() < 40) {
				GameManager.gameState = GameState.WorldMap;
			}
		}
		if(gameContainer.getInput().isKeyUp(KeyEvent.VK_S)) {
			GameManager.gameState = GameState.WorldMap;
		}		
		if(gameContainer.getInput().isKeyUp(KeyEvent.VK_L)) {
			
		}
		if(gameContainer.getInput().isKeyUp(KeyEvent.VK_E)) {

		}
		
		
		
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		startRect.render(gameContainer, renderer);
		loadRect.render(gameContainer, renderer);
		exitRect.render(gameContainer, renderer);
		
		renderer.drawRect(arrowX, arrowY, 20, 20, 0xffcc4411);
		
	}

}
