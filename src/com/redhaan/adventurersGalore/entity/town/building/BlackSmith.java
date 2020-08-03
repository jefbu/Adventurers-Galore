package com.redhaan.adventurersGalore.entity.town.building;

import com.redhaan.adventurersGalore.GameManager;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.ImageTile;
	
	public class BlackSmith extends Building {

		private static final long serialVersionUID = 1L;
		private ImageTile image;
		private int xTile, yTile;
		
		public BlackSmith(int xTile, int yTile) {
			
			super();
			this.xTile = xTile;
			this.yTile = yTile;
			image = new ImageTile("/spritesheets/Buildings.png", 96, 64);
			
		}
		
		public void update(GameContainer gameContainer, float deltaTime) {
			
		}
		
		public void render(GameContainer gameContainer, Renderer renderer) {
			
			renderer.drawImageTile(image, xTile * GameManager.GAMETILESIZE, yTile * GameManager.GAMETILESIZE, 0, 0);
			
		}

}
