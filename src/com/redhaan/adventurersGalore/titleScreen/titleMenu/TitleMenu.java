package com.redhaan.adventurersGalore.titleScreen.titleMenu;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.GameState;
import com.redhaan.adventurersGalore.Transition;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class TitleMenu extends GameObject {
	
	private int arrowX, arrowY;
	
	Rectangle startRect;
	Rectangle loadRect;
	Rectangle exitRect;
	
	private boolean hover;
	
	public TitleMenu() {
		
		arrowX = 15;
		arrowY = 15;
		
		startRect = new Rectangle("(S)TART", 10, 10, 150, 30);
		loadRect = new Rectangle("(L)OAD", 10, 45, 150, 30);
		exitRect = new Rectangle("(E)XIT", 10, 80, 150, 30);
		
		startRect.setActive(true);
		hover = false;
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		if(gameContainer.getInput().getMouseX() > startRect.offX && gameContainer.getInput().getMouseX() < startRect.offX + startRect.width &&
				gameContainer.getInput().getMouseY() > startRect.offY && gameContainer.getInput().getMouseY() < startRect.offY + startRect.height ) {
			
			hover = true;
			startRect.setActive(true); loadRect.setActive(false); exitRect.setActive(false);
			arrowY = 15;
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				Transition.nextGameState = GameState.WorldMap;
				GameManager.gameState = GameState.Transition;
			};
		}
		
		else if(gameContainer.getInput().getMouseX() > loadRect.offX && gameContainer.getInput().getMouseX() < loadRect.offX + loadRect.width &&
				gameContainer.getInput().getMouseY() > loadRect.offY && gameContainer.getInput().getMouseY() < loadRect.offY + loadRect.height ) {
			
			hover = true;
			loadRect.setActive(true); startRect.setActive(false); exitRect.setActive(false);
			arrowY = 50;
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
			};
		}
		
		
		else if(gameContainer.getInput().getMouseX() > exitRect.offX && gameContainer.getInput().getMouseX() < exitRect.offX + exitRect.width &&
				gameContainer.getInput().getMouseY() > exitRect.offY && gameContainer.getInput().getMouseY() < exitRect.offY + exitRect.height ) {

			hover = true;
			exitRect.setActive(true); startRect.setActive(false); loadRect.setActive(false);
			arrowY = 85;
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				GameContainer.running = false;
			};
		}
		
		else { hover = false; }
		
		
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
			if(startRect.isActive()) { Transition.nextGameState = GameState.WorldMap; GameManager.gameState = GameState.Transition; }
		}
		

		if(gameContainer.getInput().isKeyUp(KeyEvent.VK_S)) {
			Transition.nextGameState = GameState.WorldMap;
			GameManager.gameState = GameState.Transition;
		}		
		if(gameContainer.getInput().isKeyUp(KeyEvent.VK_L)) {
			
		}
		if(gameContainer.getInput().isKeyUp(KeyEvent.VK_E)) {
			GameContainer.running = false;
		}
		
		
		
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		startRect.render(gameContainer, renderer);
		loadRect.render(gameContainer, renderer);
		exitRect.render(gameContainer, renderer);
		
		renderer.drawRect(arrowX, arrowY, 20, 20, 0xff338877);
		
		if(hover) {
			
			if(startRect.active) { renderer.drawRect(startRect.offX - 1, startRect.offY - 1, startRect.width + 2, startRect.height + 2, 0xffCCCCCC); }
			else if(loadRect.active) { renderer.drawRect(loadRect.offX - 1, loadRect.offY - 1, loadRect.width + 2, loadRect.height + 2, 0xffCCCCCC); }
			else if(exitRect.active) { renderer.drawRect(exitRect.offX - 1, exitRect.offY - 1, exitRect.width + 2, exitRect.height + 2, 0xffCCCCCC); }
			
		}
		
	}

}
 