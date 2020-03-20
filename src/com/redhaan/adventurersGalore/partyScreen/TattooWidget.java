package com.redhaan.adventurersGalore.partyScreen;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class TattooWidget extends GameObject {
	
	private int offX, offY;
	private int width, height;
	
	public TattooWidget(int offX, int offY, int width, int height) {
		
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

		renderer.drawRectOpaque(offX, offY, width, height, 0xff282028);
		
		for (int i = 0; i < GameManager.adventurers.allAdventurers.get(PartyScreen.member).tattooSlots; i++) {
			
			renderer.drawRectOpaque(offX + 5, (offY + 5) +  i * (height / 4 + 5), width - 10, height / 4, 0xff584858);
			renderer.drawText(GameManager.adventurers.allAdventurers.get(PartyScreen.member).tattoos.get(i).name, offX + 10, (offY + 10) +  i * (height / 4 + 5), 0xffCCBBCC);
			
		}
		
	}
	
	
	

}
