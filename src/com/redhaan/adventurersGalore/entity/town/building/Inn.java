package com.redhaan.adventurersGalore.entity.town.building;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class Inn extends Building {

	private static final long serialVersionUID = 1L;
	
	public Inn() {
		
		super();
		x = 0;
		y = 0;
		
	}
	
	public void update(GameContainer gameContainer, float deltaTime) {
		
	}
	
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		renderer.drawImageTile(icon, 255, 170, x, y);
		
	}

}
