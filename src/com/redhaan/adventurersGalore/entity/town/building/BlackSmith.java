package com.redhaan.adventurersGalore.entity.town.building;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
	
	public class BlackSmith extends Building {

		private static final long serialVersionUID = 1L;
		
		public BlackSmith() {
			
			super();
			x = 1;
			y = 0;
			
		}
		
		public void update(GameContainer gameContainer, float deltaTime) {
			
		}
		
		public void render(GameContainer gameContainer, Renderer renderer) {
			
			renderer.drawImageTile(icon, 375, 280, x, y);
			
		}

}
