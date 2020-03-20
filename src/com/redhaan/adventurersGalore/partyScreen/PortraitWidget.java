package com.redhaan.adventurersGalore.partyScreen;

import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class PortraitWidget extends GameObject {

	private float temp;
	private int animationLine;
	Random random;

	private int offX, offY, width, height, gender;

	public PortraitWidget(int offX, int offY, int width, int height) {

		temp = 0;
		animationLine = 0;
		random = new Random();
		this.offX = offX;
		this.offY = offY;
		this.width = width;
		this.height = height;
		gender = 0;

	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		temp += deltaTime * 4;
		if (temp > 4) {
			temp = 0;
			if (random.nextInt(100) > 93) {
				animationLine = random.nextInt(1) + 1;
			} else { animationLine = 0; }
		}

		if (GameManager.adventurers.allAdventurers.get(PartyScreen.member).gender.equals("Female")) { gender = 4; } 
		else { gender = 0; }

	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		renderer.drawRectOpaque(offX, offY, width, height, 0xff242822);
		renderer.drawImageTile(GameManager.adventurers.allAdventurers.get(PartyScreen.member).icon,
				offX + width / 2 - GameManager.GAMETILESIZE / 2, offY + height / 2, (int) temp + gender, animationLine);

	}

}
