package com.redhaan.adventurersGalore.entity.town.building;

import com.redhaan.adventurersGalore.inTown.TownMap;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class Alchemist extends Building {

	private static final long serialVersionUID = 1L;

	public Alchemist() {
		
		x = 1;
		y = 1;
		
	}
	
	public void update(GameContainer gameContainer, float deltaTime) {
		
	}
	
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		switch (TownMap.subState) {
		
		case General:
			renderer.drawImageTile(icon, 240, 60, x, y);
			break;
		
		case Alchemist:
			break;
			
		case Inn: break;
		case Seer: break;
		case Blacksmith: break;
		
		}
				
	}
	

}
