package com.redhaan.adventurersGalore.entity.town.building;

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
		
		renderer.drawImageTile(icon, 97, 115, x, y);
		
	}
	
}
