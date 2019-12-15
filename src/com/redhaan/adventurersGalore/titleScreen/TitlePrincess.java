package com.redhaan.adventurersGalore.titleScreen;

import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class TitlePrincess extends GameObject {

	private ImageTile castlePrincessImage;
	private float temp = 0;
	private int xTile;
	private int yTile;
	
	boolean render = false;
	Random random = new Random();

	public TitlePrincess(int xTile, int yTile) {

		castlePrincessImage = new ImageTile("/titleScreen/titleScreenSpriteSheet16.png", GameManager.GAMETILESIZE,
				GameManager.GAMETILESIZE);
		this.xTile = xTile;
		this.yTile = yTile;

	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		if (random.nextInt(1000) > 997) { render = true; }
		
		if(render) {
		temp += deltaTime;
		// xTile++;
		if (temp > 2) {
			temp = 0;
			render = false;
		}
		}

	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		if(render) {
		renderer.drawImageTile(castlePrincessImage, xTile * GameManager.GAMETILESIZE,
				yTile * GameManager.GAMETILESIZE, (int) temp, 2);
		}
	}

}
