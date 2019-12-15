package com.redhaan.adventurersGalore.partyScreen;

import com.redhaan.adventurersGalore.GameObject;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class AffinityWidget extends GameObject {
	
	public AffinityWidget() {
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		renderer.drawRectOpaque(200, 130, 215, 100, 0xff242626);
		
	}
	
	

}
