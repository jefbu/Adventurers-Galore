package com.redhaan.adventurersGalore;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class Tooltip extends GameObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean active;
	private int counter;
	private int oldXPosition, oldYPosition;
	
	public Tooltip() {
	
		active = false;
		counter = 0;
		oldXPosition = 100;
		oldYPosition = 100;
		
	}
	

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		
		/*if (counter >= 900 && !active) { active = true; }

		else if (gameContainer.getInput().getMouseX() == oldXPosition && gameContainer.getInput().getMouseY() == oldYPosition) { counter++; }
		
		else {
			counter = 0;
			oldXPosition = gameContainer.getInput().getMouseX();
			oldYPosition = gameContainer.getInput().getMouseY();
			active = false;
		}
		
		if (active) {
			
			switch (GameManager.gameState) {
			
			case Combat:
				break;
			case InTown:
				break;
			case Inventory:
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
			case WorldMap:
				switch (WorldMap.subState) {
				case DetailMap:
					break;
				case GlobalMap: 
					break;
				case TravelerEvent: break;
				default:
					break;
				
				}
				break;
			default:
				break;
						
			}
			
		}
	*/
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		if (active) {
			
			renderer.drawRect(299, 219, 82, 22, 0xff443320);
			renderer.drawRectOpaque(300, 220, 80, 20, 0xffEECCBB);
			
		}
		
		
		
	}
	
	
	
	

}
