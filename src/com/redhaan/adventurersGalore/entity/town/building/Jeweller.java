package com.redhaan.adventurersGalore.entity.town.building;

import com.redhaan.adventurersGalore.inTown.TownMap;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class Jeweller extends Building {

	private static final long serialVersionUID = 1L;

	public Jeweller() {
		
		super();
		x = 2;
		y = 0;
		
	}
	
	public void update(GameContainer gameContainer, float deltaTime) {
		
	}
	
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		switch (TownMap.subState) {
		
		case General:
			renderer.drawImageTile(icon, 415, 140, x, y);
			break;
		
		case Jeweller: 
			break;	
			
		case Inn: break;
		case Alchemist:	break;
		case Seer: break;
		case Blacksmith: break;
		
		}
		
		
		
	}
	

}
