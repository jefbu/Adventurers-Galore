package com.redhaan.adventurersGalore;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class Tooltip extends GameObject {
	
	private boolean active;
	private int counter;
	private int xPosition, yPosition;
	private int oldXPosition, oldYPosition;
	
	public Tooltip() {
	
		active = false;
		counter = 0;
		oldXPosition = 100;
		oldYPosition = 100;
		xPosition = 0;
		yPosition = 0;
		
	}
	

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		
		if (counter >= 60 && !active) { active = true; }

		else if (gameContainer.getInput().getMouseX() == oldXPosition && gameContainer.getInput().getMouseY() == oldYPosition) { counter++; }
		
		else {
			counter = 0;
			oldXPosition = gameContainer.getInput().getMouseX();
			oldYPosition = gameContainer.getInput().getMouseY();
			active = false;
		}

		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		if (active) {
			
			renderer.drawRect(299, 219, 82, 22, 0xff443320);
			renderer.drawRectOpaque(300, 220, 80, 20, 0xffEECCBB);
			
		}
		
		
		
	}
	
	
	
	

}
