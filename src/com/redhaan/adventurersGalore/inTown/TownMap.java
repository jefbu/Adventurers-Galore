package com.redhaan.adventurersGalore.inTown;

import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.GameState;
import com.redhaan.adventurersGalore.entity.town.Town;
import com.redhaan.adventurersGalore.entity.town.building.Building;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.Image;

public class TownMap extends GameObject {
	
	private Image village;
	private Image town;
	private Image city;
	private Image metropole;
	
	public static Town activeTown;
	
	public TownMap() {
		
		village = new Image("/town/Town1.png");
		town = new Image("/town/Town2.png");
		city = new Image("/town/Town3.png");
		metropole = new Image("/town/Town4.png");
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		switch(GameManager.gameState) {
		
		case InTown:
			
			if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON3)) {
				GameManager.gameState = GameState.WorldMap;
			}
			
			break;
		
		case Titlescreen: break;
		case WorldMap: break;
		case Combat: break;
		case PartyScreen: break;

		}
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		switch(GameManager.gameState) {
		
		case InTown: 
			
			switch(activeTown.getxLocations().length) {
			
			case 1: renderer.drawImage(village, 0, 0); 
				break;
			case 2: renderer.drawImage(town, 0, 0);
				break;
			case 3: renderer.drawImage(city, 0, 0);
				break;
			case 4: renderer.drawImage(metropole, 0, 0);
				break;
			
			default: System.out.println("Error in townSize"); break;
			
			}
			
			for (Building building: activeTown.buildings) {
				building.render(gameContainer, renderer);
			}
			
			break;
		case Titlescreen: break;
		case WorldMap: break;
		case Combat: break;
		case PartyScreen: break;
		}
		
	}
	

}
