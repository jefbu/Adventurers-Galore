package com.redhaan.adventurersGalore.partyScreen;

import com.redhaan.adventurersGalore.GameObject;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class SkillWidget extends GameObject {
	
	public SkillWidget() {
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		renderer.drawRectOpaque(200, 240, 215, 150, 0xff282820);
		
	}
	
	

}
