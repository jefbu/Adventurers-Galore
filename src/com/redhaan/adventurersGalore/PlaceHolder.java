package com.redhaan.adventurersGalore;

import java.awt.event.KeyEvent;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class PlaceHolder extends GameObject {
	
	public PlaceHolder(int posX, int posY) {
		
		this.setTag("");
		this.setPosX(posX * GameManager.GAMETILESIZE);
		this.setPosY(posY * GameManager.GAMETILESIZE);
		this.setWidth(GameManager.GAMETILESIZE);
		this.setHeight(GameManager.GAMETILESIZE);
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		if(gameContainer.getInput().isKey(KeyEvent.VK_A)) { 
			GameManager.gameState = GameState.WorldMap;
			System.out.println("clicked A");
			}
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		switch(GameManager.gameState) {
		case Titlescreen: renderer.drawRect(20, 20, 50, 50, 0xff553399); break;
		case WorldMap: break;
		default: break;
		
		}
		
	}

}
