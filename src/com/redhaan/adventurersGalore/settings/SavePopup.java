package com.redhaan.adventurersGalore.settings;

import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.SaveGame;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class SavePopup extends GameObject {
	
	private static final long serialVersionUID = 1L;

	public SavePopup() {
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		if(gameContainer.getInput().getMouseX() > 20 && gameContainer.getInput().getMouseX() < 41 &&
				gameContainer.getInput().getMouseY() > 420 && gameContainer.getInput().getMouseY() <  446) {
			
			if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				SaveGame.save();
			}
			
		}
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		switch (GameManager.gameState) {

		case WorldMap:
			
			renderer.drawRect(20, 420, 20, 25, 0xff112211);
			break;
			
			
		case Combat:
			break;
		case InTown:
			break;
		case PartyCohesionCheckerUI:
			break;
		case PartyScreen:
			break;
		case QuestScreen:
			break;
		case QuestUI:
			break;
		case Titlescreen:
			break;
		case Transition:
			break;
		default:
			break;
		
		
		
		}
		
		
		
	}

}
