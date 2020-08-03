package com.redhaan.adventurersGalore.titleScreen;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class TitleNinja extends GameObject {

	private static final long serialVersionUID = 1L;
	private ImageTile castlePrincessImage;
	private float temp = 0;
	private int xTile;
	private int yTile;

	public TitleNinja(int xTile, int yTile) {

		castlePrincessImage = new ImageTile("/titleScreenSpriteSheet16.png", GameManager.GAMETILESIZE,
				GameManager.GAMETILESIZE);
		this.xTile = xTile;
		this.yTile = yTile;

	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		temp += deltaTime * 5 / 2;
		// xTile++;
		if (temp > 2) {
			temp = 0;
		}

	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		renderer.drawImageTile(castlePrincessImage, xTile * GameManager.GAMETILESIZE,
				yTile * GameManager.GAMETILESIZE, (int) temp, 3);
	}
	
}
