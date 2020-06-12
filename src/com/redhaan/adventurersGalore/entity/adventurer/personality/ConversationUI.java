package com.redhaan.adventurersGalore.entity.adventurer.personality;

import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class ConversationUI extends GameObject {
	
	protected int offX, offY;
	private Random random;
	public boolean initiated;
	
	public ConversationUI() {
		random = new Random();
		offX = 0;
		offY = 0;
		initiated = false;
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		if(!initiated) {
			offX = random.nextInt(240);
			offY = random.nextInt(380);
			initiated = true;
		}
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		renderer.drawRectOpaque(offX, offY, 400, 70, 0x88221513);
		renderer.drawRectOpaque(offX + 5, offY + 5, GameManager.GAMETILESIZE + 10, 60, 0x99131333);
		renderer.drawRectOpaque(offX + 55, offY + 5, 330, 60, 0x99131333);
		
		
		
	}
	

}
