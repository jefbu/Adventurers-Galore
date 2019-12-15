package com.redhaan.adventurersGalore.partyScreen;

import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class ArmourImageWidget extends GameObject {
	
	private ImageTile portrait;
	private int temp;
	Random random;
	
	public ArmourImageWidget() {
		
		portrait = new ImageTile("/armour.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE);
		temp = 0;
		random = new Random();
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		temp += deltaTime * 4;
		if (temp > 0) {
			temp = 0;
		}
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		renderer.drawRectOpaque(350, 20, 64, 96, 0xff242822);
		renderer.drawImageTile(portrait, 367, 65, (int) temp, 0);		
	
	}
		

}