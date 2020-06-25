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

		renderer.drawRectOpaque(offX, offY, width, height, 0xff282020);

		if (GameManager.adventurers.allAdventurers.get(PartyScreen.member).tattoo != null) {
			renderer.drawImageTile(GameManager.adventurers.allAdventurers.get(PartyScreen.member).tattoo.icon,
					offX + width / 2 - GameManager.GAMETILESIZE, offY + 5,
					GameManager.adventurers.allAdventurers.get(PartyScreen.member).tattoo.iconX,
					GameManager.adventurers.allAdventurers.get(PartyScreen.member).tattoo.iconY);
			renderer.drawText(GameManager.adventurers.allAdventurers.get(PartyScreen.member).tattoo.name, offX + width / 2 - 10, offY + 80, 0xffBB8899);
		}
	}

}
