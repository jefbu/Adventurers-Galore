package com.redhaan.adventurersGalore.partyScreen;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class BasicInfoWidget extends GameObject {

	private static final long serialVersionUID = 1L;
	private int offX, offY, width, height;

	public BasicInfoWidget(int offX, int offY, int width, int height) {

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

		renderer.drawRectOpaque(offX, offY, width, height, 0xff242822);

		renderer.drawText(GameManager.adventurers.allAdventurers.get(PartyScreen.member).name, offX + 5, offY + 5, 0xffBBBBBB);
		renderer.drawText(GameManager.adventurers.allAdventurers.get(PartyScreen.member).gender, offX + 5, offY + 20, 0xffBBBBBB);		
		renderer.drawText("Lv: " + GameManager.adventurers.allAdventurers.get(PartyScreen.member).getLevel()
				+ " / Age: " + GameManager.adventurers.allAdventurers.get(PartyScreen.member).age, offX + 5, offY + 35, 0xffBBBBBB);
		renderer.drawText(GameManager.adventurers.allAdventurers.get(PartyScreen.member).job.name, offX + 5, offY + 50, 0xffBBBBBB);
		renderer.drawText(GameManager.adventurers.allAdventurers.get(PartyScreen.member).race.name, offX + 5, offY + 65, 0xffBBBBBB);
		renderer.drawText("Home: " + GameManager.adventurers.allAdventurers.get(PartyScreen.member).homeTown.name, offX + 5, offY + 80, 0xffBBBBBB);
		
	}

}
