package com.redhaan.adventurersGalore.entity.town.building;

import com.redhaan.adventurersGalore.inTown.TownMap;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class Farm extends Building {

	private static final long serialVersionUID = 1L;

	public Farm() {
		
		super();
		x = 0;
		y = 1;
		
	}
	
	public void update(GameContainer gameContainer, float deltaTime) {
		
	}
	
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		switch (TownMap.subState) {
		
		case General:
			renderer.drawImageTile(icon, 97, 115, x, y);
			break;
		
		case Inn: 
			break;	
			
		case Alchemist:	break;
		case Seer: break;
		case Blacksmith: break;
		
		}
		
		
		
		
	}
	
}
