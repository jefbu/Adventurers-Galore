package com.redhaan.adventurersGalore.titleScreen;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class TitleBard extends GameObject {
	

	private ImageTile castlePrincessImage;
	private float temp = 0;
	private int xTile;
	private int yTile;

	public TitleBard(int xTile, int yTile) {

		castlePrincessImage = new ImageTile("/Bard1.png", GameManager.GAMETILESIZE,
				GameManager.GAMETILESIZE);
		this.xTile = xTile;
		this.yTile = yTile;

	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		temp += deltaTime * 5;
		// xTile++;
		if (temp > 4) {
			temp = 0;
		}

	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		renderer.drawImageTile(castlePrincessImage, xTile * GameManager.GAMETILESIZE,
				yTile * GameManager.GAMETILESIZE, (int) temp, 0);
	}



}
