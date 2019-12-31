package com.redhaan.adventurersGalore.partyScreen;

import com.redhaan.adventurersGalore.GameObject;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class SkillWidget extends GameObject {
	
	private int offX, offY;
	private int width, height;
	
	public SkillWidget(int offX, int offY, int width, int height) {
		
		this.offX = offX;
		this.offY = offY;
		this.width = width;
		this.height = height;
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		renderer.drawRectOpaque(offX, offY, width, height, 0xff282420);
		
	}
	
	

}
