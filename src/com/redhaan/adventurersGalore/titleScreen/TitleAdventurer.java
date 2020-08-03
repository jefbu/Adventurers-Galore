package com.redhaan.adventurersGalore.titleScreen;

import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class TitleAdventurer extends GameObject {

	private static final long serialVersionUID = 1L;
	private ImageTile castleFlagImage;
	private float temp = 0;
	private int xTile;
	private int yTile;
	
	private int moveSpeed;

	public TitleAdventurer(int xTile, int yTile) {

		castleFlagImage = new ImageTile("/Knight.png", GameManager.GAMETILESIZE,
				GameManager.GAMETILESIZE);
		this.xTile = xTile;
		this.yTile = yTile;

		Random random = new Random();
		moveSpeed = random.nextInt(4) + 4;
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		temp += deltaTime * moveSpeed;
		// xTile++;
		if (temp > 4) {
			temp = 0;
		}

	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		renderer.drawImageTile(castleFlagImage, xTile * GameManager.GAMETILESIZE, yTile * GameManager.GAMETILESIZE,
				(int) temp, 0);
	}

}
