package com.redhaan.adventurersGalore.entity.adventurer.personality;

import java.io.Serializable;

import com.redhaan.adventurersGalore.GameManager;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class ConversationUI implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public ConversationUI() {

	}

	public void render(GameContainer gameContainer, Renderer renderer, int offX, int offY) {

		renderer.drawRectOpaque(offX, offY, 380, 50, 0x88221513);
		renderer.drawRectOpaque(offX + 3, offY + 3, GameManager.GAMETILESIZE + 10, 44, 0x99131333);
		renderer.drawRectOpaque(offX + 48, offY + 3, 330, 44, 0x99131333);
		
		
		
	}
	

}
