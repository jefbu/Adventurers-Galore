package com.redhaan.adventurersGalore.partyScreen;

import com.redhaan.adventurersGalore.GameObject;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class AffinityWidget extends GameObject {
	
	private int offX, offY;
	private int width, height;
	
	public AffinityWidget(int offX, int offY, int width, int height) {
				
		this.offX = offX;
		this.offY = offY;
		this.width = width;
		this.height = height;
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		renderer.drawRectOpaque(offX, offY, width, height, 0xff242626);
		
	}
	
	

}
