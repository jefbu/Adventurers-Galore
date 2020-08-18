package com.redhaan.adventurersGalore.entity.town.building;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class Building extends GameObject {

	private static final long serialVersionUID = 1L;
	ImageTile icon;
	int x, y;

	public Building() {
		icon = new ImageTile("/spriteSheets/buildingIcons.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE);
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
	}

}
