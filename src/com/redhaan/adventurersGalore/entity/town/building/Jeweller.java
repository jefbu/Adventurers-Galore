package com.redhaan.adventurersGalore.entity.town.building;

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
		
		renderer.drawImageTile(icon, 415, 140, x, y);
		
	}
	

}
