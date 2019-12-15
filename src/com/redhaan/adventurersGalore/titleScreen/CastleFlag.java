package com.redhaan.adventurersGalore.titleScreen;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class CastleFlag extends GameObject {

	private ImageTile castleFlagImage;
	private float temp = 0;
	private int xTile;
	private int yTile;

	public CastleFlag(int xTile, int yTile) {

		castleFlagImage = new ImageTile("/titleScreen/sprite32.png", GameManager.GAMETILESIZE,
				GameManager.GAMETILESIZE);
		this.xTile = xTile;
		this.yTile = yTile;
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		temp += deltaTime * 3;
		if (temp > 3) {
			temp = 0;
		}

	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		renderer.drawImageTile(castleFlagImage, xTile * GameManager.GAMETILESIZE, yTile * GameManager.GAMETILESIZE,
				(int) temp, 0);
	}

}
