package com.redhaan.adventurersGalore.inTown;

import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.GameState;
import com.redhaan.adventurersGalore.entity.town.Town;
import com.redhaan.adventurersGalore.entity.town.TownSubState;
import com.redhaan.adventurersGalore.entity.town.building.Building;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.Image;

public class TownMap extends GameObject {

	private static final long serialVersionUID = 1L;
	private Image town;
	
	public static Town activeTown;
	
	private boolean hover;
	private int hoverOption;
	public static TownSubState subState;
	
	public TownMap() {		
		town = new Image("/town/NewTown7.png");		
		hover = false;
		subState = TownSubState.General;
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		switch(GameManager.gameState) {
		
		case InTown:
			
				for(Building building: activeTown.buildings) {
					building.update(gameContainer, deltaTime);
				}

			if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON3)) {
				GameManager.gameState = GameState.WorldMap;
			}
			
		/*
			if (gameContainer.getInput().getMouseX() > 258 && gameContainer.getInput().getMouseX() < 283 &&
					gameContainer.getInput().getMouseY() > 170 && gameContainer.getInput().getMouseY() < 203) {
				hover = true;
				hoverOption = 1;
				if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
					System.out.println("clicked");
				}
			}
			

			
			else if (gameContainer.getInput().getMouseX() > 100 && gameContainer.getInput().getMouseX() < 125 &&
					gameContainer.getInput().getMouseY() > 115 && gameContainer.getInput().getMouseY() < 143) {
				hover = true;
				hoverOption = 3;
				if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
					System.out.println("clicked");
				}
			}
			
			else if (gameContainer.getInput().getMouseX() > 243 && gameContainer.getInput().getMouseX() < 267 &&
					gameContainer.getInput().getMouseY() > 64 && gameContainer.getInput().getMouseY() < 92) {
				hover = true;
				hoverOption = 4;
				if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
					System.out.println("clicked");
				}
			}
			
			else if (gameContainer.getInput().getMouseX() > 419 && gameContainer.getInput().getMouseX() < 444 &&
					gameContainer.getInput().getMouseY() > 144 && gameContainer.getInput().getMouseY() < 169) {
				hover = true;
				hoverOption = 5;
				if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
					System.out.println("clicked");
				}
			}
			
			
			
			else { hover = false; }
				
						
			*/			
		
			break;
			
		case Titlescreen: break;
		case WorldMap: break;
		case Combat: break;
		case PartyScreen: break;
		case QuestUI: break;
		case Transition: break;
		case QuestScreen: break;
		case PartyCohesionCheckerUI: break;

		}
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		switch(GameManager.gameState) {
		
		case InTown: 
			
			renderer.drawImage(town, 0, 0);
			
			for (Building building: activeTown.buildings) {
				building.render(gameContainer, renderer);
			}				

			break;
		
			/*
				if(hover) {
					
					switch(hoverOption) {
					case 1: renderer.drawRect(259, 175, 23, 23, 0xffCCBB66); break;
					case 2: renderer.drawRect(380, 285, 23, 23, 0xffCCBB66); break;
					case 3: renderer.drawRect(101, 120, 23, 23, 0xffCCBB66); break;
					case 4: renderer.drawRect(245, 65, 23, 23, 0xffCCBB66); break;
					case 5: renderer.drawRect(420, 145, 23, 23, 0xffCCBB66); break;
					}
					
				}*/		
			
		case Titlescreen: break;
		case WorldMap: break;
		case Combat: break;
		case PartyScreen: break;
		case QuestUI: break;
		case Transition: break;
		case QuestScreen: break;
		case PartyCohesionCheckerUI: break;
		
		}
		
	}
	

}
