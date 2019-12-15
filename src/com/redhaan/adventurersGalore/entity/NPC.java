package com.redhaan.adventurersGalore.entity;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class NPC extends GameObject {
	
	public ImageTile icon;
	
	public NPC() {
		
		icon = new ImageTile("/Knight.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE);
		
	}
	
	

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		// TODO Auto-generated method stub
		
	}

}
