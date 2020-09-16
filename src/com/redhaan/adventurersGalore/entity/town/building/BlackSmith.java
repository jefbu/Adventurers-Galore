package com.redhaan.adventurersGalore.entity.town.building;

import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.entity.town.TownSubState;
import com.redhaan.adventurersGalore.inTown.TownMap;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.ImageTile;
	
	public class BlackSmith extends Building {

		private static final long serialVersionUID = 1L;
	
		private ImageTile blacksmith;
		private int timer;
		private int animation;
		
		public BlackSmith() {
			
			super();
			x = 1;
			y = 0;
			blacksmith = new ImageTile("/blacksmith.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE);
			
			timer = 0;
			animation = 0;
			
		}
		
		public void update(GameContainer gameContainer, float deltaTime) {
			
			switch(TownMap.subState) {
			
			case General:
				
				if (gameContainer.getInput().getMouseX() > 375 && gameContainer.getInput().getMouseX() < 375 + icon.getTileWidth() &&
						gameContainer.getInput().getMouseY() > 280 && gameContainer.getInput().getMouseY() < 280 + icon.getTileHeight()) {
					if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
						TownMap.subState = TownSubState.Blacksmith;
					}
				}
				break;
				
			case Blacksmith:
				
				if(timer < 20) { timer++; } else { timer = 0; animation++; }
				if(animation > 3) { animation = 0; }
				
				break;
				
			
			
			}
			
			

			
			
		}
		
		public void render(GameContainer gameContainer, Renderer renderer) {
			
			switch (TownMap.subState) {
			
			case General: renderer.drawImageTile(icon, 375, 280, x, y); break;
			
			case Blacksmith: 
				
				renderer.drawRectOpaque(20, 20, 600, 400, 0xbb222815);
			
				renderer.drawRectOpaque(25, 25, 50, 50, 0xff121621);
				renderer.drawImageTile(blacksmith, 30, 30, animation, 0);
				
				renderer.drawRectOpaque(80, 25, 300, 50, 0xff121621);
				renderer.drawText("What wisht from me, a humble blacksmith?", 85, 30, 0xff617191);
				
				renderer.drawRectOpaque(25, 80, 355, 50, 0xff211216);
				renderer.drawRectOpaque(30, 85, 80, 40, 0xff271621);
				renderer.drawRectOpaque(115, 85, 80, 40, 0xff271621);
				renderer.drawRectOpaque(200, 85, 80, 40, 0xff271621);
				renderer.drawRectOpaque(285, 85, 80, 40, 0xff271621);


				
				renderer.drawRectOpaque(25, 135, 50, 20, 0xff282215);
					renderer.drawText("Swords", 30, 140, 0xff685245);
				renderer.drawRectOpaque(80, 135, 50, 20, 0xff282215);
					renderer.drawText("Daggers", 85, 140, 0xff685245);
				
				renderer.drawRectOpaque(25, 155, 550, 260, 0xff282215);
			}
			
			

			
		}

}
