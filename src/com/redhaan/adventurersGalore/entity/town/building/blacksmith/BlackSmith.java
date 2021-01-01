package com.redhaan.adventurersGalore.entity.town.building.blacksmith;

import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.entity.town.TownSubState;
import com.redhaan.adventurersGalore.entity.town.building.Building;
import com.redhaan.adventurersGalore.entity.town.building.blacksmith.craftingScreen.CraftingScreen;
import com.redhaan.adventurersGalore.inTown.TownMap;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.ImageTile;
	
	public class BlackSmith extends Building {

		private static final long serialVersionUID = 1L;
	
		private ImageTile blacksmith;
		private int timer;
		private int animation;
		private boolean generalHover;
		private int mainOptionHover;
		private boolean closeHover;
		private int equipTypeHover;
		
		private int activeColour;
		private int passiveColour;
		public static int equipTypeOption;
		
		public static BlacksmithSubstate substate;
		private CraftingScreen craftingScreen;
		private SharpeningScreen sharpeningScreen;
		private ScrappingScreen scrappingScreen;
		private RuneforgingScreen runeforgingScreen;
		
		public BlackSmith() {
			
			super();
			x = 1;
			y = 0;
			blacksmith = new ImageTile("/blacksmith.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE);
			
			timer = 0;
			animation = 0;
			
			mainOptionHover = 0;
			equipTypeOption = 0;
			
			activeColour = 0xff231911;
			passiveColour = 0xff181205;
			
			substate = BlacksmithSubstate.Crafting;
			
			craftingScreen = new CraftingScreen();
			sharpeningScreen = new SharpeningScreen();
			scrappingScreen = new ScrappingScreen();
			runeforgingScreen = new RuneforgingScreen();
			
		}
		
		public void update(GameContainer gameContainer, float deltaTime) {
			
			switch(TownMap.subState) {

			
			case General:
				
				if (gameContainer.getInput().getMouseX() > 375 && gameContainer.getInput().getMouseX() < 375 + icon.getTileWidth() &&
						gameContainer.getInput().getMouseY() > 280 && gameContainer.getInput().getMouseY() < 280 + icon.getTileHeight()) {
					generalHover = true;
					if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
						TownMap.subState = TownSubState.Blacksmith;
					}
				} else { generalHover = false; }
				break;
				
			case Blacksmith:
				
				if(timer < 20) { timer++; } else { timer = 0; animation++; }
				if(animation > 3) { animation = 0; }
				
				
				switch(substate) {	
				
					case Crafting: craftingScreen.update(gameContainer, deltaTime); break;
					case Runeforging: runeforgingScreen.update(gameContainer, deltaTime); break;
					case Scrapping: scrappingScreen.update(gameContainer, deltaTime); break;
					case Sharpening: sharpeningScreen.update(gameContainer, deltaTime); break;				
				
				}
				
				
				if(gameContainer.getInput().getMouseX() > 385 && gameContainer.getInput().getMouseX() < 435 &&
						gameContainer.getInput().getMouseY() > 25 && gameContainer.getInput().getMouseY() < 125) {
					mainOptionHover = 1;
					if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) { substate = BlacksmithSubstate.Crafting; }
				}
				else if(gameContainer.getInput().getMouseX() > 440 && gameContainer.getInput().getMouseX() < 490 &&
						gameContainer.getInput().getMouseY() > 25 && gameContainer.getInput().getMouseY() < 125) {
					mainOptionHover = 2;
					if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) { substate = BlacksmithSubstate.Sharpening; }
				}		
				else if(gameContainer.getInput().getMouseX() > 495 && gameContainer.getInput().getMouseX() < 545 &&
						gameContainer.getInput().getMouseY() > 25 && gameContainer.getInput().getMouseY() < 125) {
					mainOptionHover = 3;
					if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) { substate = BlacksmithSubstate.Scrapping; }
				}	
				else if(gameContainer.getInput().getMouseX() > 550 && gameContainer.getInput().getMouseX() < 600 &&
						gameContainer.getInput().getMouseY() > 25 && gameContainer.getInput().getMouseY() < 125) {
					mainOptionHover = 4;
					if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) { substate = BlacksmithSubstate.Runeforging; }
				}	
								
				else { mainOptionHover = 0; }
				
				if(gameContainer.getInput().getMouseX() > 525 && gameContainer.getInput().getMouseX() < 585 &&
						gameContainer.getInput().getMouseY() > 385 && gameContainer.getInput().getMouseY() < 405) {
					closeHover = true;
					if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) { TownMap.subState = TownSubState.General; }
				}  else { closeHover = false; }

				if(gameContainer.getInput().getMouseX() > 30 && gameContainer.getInput().getMouseX() < 80 &&
						gameContainer.getInput().getMouseY() > 130 && gameContainer.getInput().getMouseY() < 150) {
					equipTypeHover = 1;
					if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) { equipTypeOption = 0; }
				} 
				else if(gameContainer.getInput().getMouseX() > 85 && gameContainer.getInput().getMouseX() < 135 &&
						gameContainer.getInput().getMouseY() > 130 && gameContainer.getInput().getMouseY() < 150) {
					equipTypeHover = 2;
					if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) { equipTypeOption = 1; }
				} 
				else if(gameContainer.getInput().getMouseX() > 140 && gameContainer.getInput().getMouseX() < 190 &&
						gameContainer.getInput().getMouseY() > 130 && gameContainer.getInput().getMouseY() < 150) {
					equipTypeHover = 3;
					if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) { equipTypeOption = 2; }
				} 
				else if(gameContainer.getInput().getMouseX() > 195 && gameContainer.getInput().getMouseX() < 245 &&
						gameContainer.getInput().getMouseY() > 130 && gameContainer.getInput().getMouseY() < 150) {
					equipTypeHover = 4;
					if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) { equipTypeOption = 3; }
				} 
				else if(gameContainer.getInput().getMouseX() > 250 && gameContainer.getInput().getMouseX() < 300 &&
						gameContainer.getInput().getMouseY() > 130 && gameContainer.getInput().getMouseY() < 150) {
					equipTypeHover = 5;
					if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) { equipTypeOption = 4; }
				} 
				else if(gameContainer.getInput().getMouseX() > 305 && gameContainer.getInput().getMouseX() < 355 &&
						gameContainer.getInput().getMouseY() > 130 && gameContainer.getInput().getMouseY() < 150) {
					equipTypeHover = 6;
					if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) { equipTypeOption = 5; }
				} 
				
				else { equipTypeHover = 0; }
				
				
				break;
				
			
			case Alchemist: break;
			case Inn: break;
			
			}
			
			

			
			
		}
		
		public void render(GameContainer gameContainer, Renderer renderer) {
			
			switch (TownMap.subState) {
			
			case General: 
				renderer.drawImageTile(icon, 375, 280, x, y); 
				if(generalHover) { renderer.drawRect(375, 280, icon.getTileWidth(), icon.getTileHeight(), 0xffAA8822); }
				break;
			
			case Blacksmith: 
				
				renderer.drawRectOpaque(20, 20, 600, 400, 0xbb222815);
			
				renderer.drawRectOpaque(25, 25, 100, 100, 0xff121621);
				renderer.drawImageTile(blacksmith, 57, 57, animation, 0);
				
				renderer.drawRectOpaque(130, 25, 250, 100, 0xff121621);
				renderer.drawText("What wisht from me, a humble blacksmith?", 140, 45, 0xff617191);
				
				renderer.drawRectOpaque(385, 25, 50, 100, 0xff201417);
					renderer.drawImageTile(blacksmith, 395, 50, 0, 1);
					renderer.drawText("Craft", 400, 100, 0xff582536);
				renderer.drawRectOpaque(440, 25, 50, 100, 0xff201417);
					renderer.drawImageTile(blacksmith, 450, 50, 1, 1);
					renderer.drawText("Sharpen", 450, 100, 0xff582536);
				renderer.drawRectOpaque(495, 25, 50, 100, 0xff201417);
					renderer.drawImageTile(blacksmith, 505, 50, 2, 1);
					renderer.drawText("Scrap", 510, 100, 0xff582536);
				renderer.drawRectOpaque(550, 25, 50, 100, 0xff201417);
					renderer.drawImageTile(blacksmith, 560, 50, 3, 1);
					renderer.drawText("Rune", 565, 100, 0xff582536);

				
				if (equipTypeOption == 0) { 
					renderer.drawRectOpaque(30, 130, 50, 20, activeColour); }
				else { renderer.drawRectOpaque(30, 130, 50, 20, passiveColour); }
					renderer.drawText("Swords", 35, 135, 0xff685245);
					
				if(equipTypeOption == 1) {
					renderer.drawRectOpaque(85, 130, 50, 20, activeColour); }
				else { renderer.drawRectOpaque(85, 130, 50, 20, passiveColour); }
					renderer.drawText("Daggers", 90	, 135, 0xff685245);
				
				if (equipTypeOption == 2) {	
					renderer.drawRectOpaque(140, 130, 50, 20, activeColour); }
				else { renderer.drawRectOpaque(140, 130, 50, 20, passiveColour); }
					renderer.drawText("Staves", 145	, 135, 0xff685245);	
					
				if (equipTypeOption == 3) { 
					renderer.drawRectOpaque(195, 130, 50, 20, activeColour); }
				else { renderer.drawRectOpaque(195, 130, 50, 20, passiveColour); }
					renderer.drawText("Spears", 200, 135, 0xff685245);
					
				if (equipTypeOption == 4) { 
					renderer.drawRectOpaque(250, 130, 50, 20, activeColour); }
				else { renderer.drawRectOpaque(250, 130, 50, 20, passiveColour); }
					renderer.drawText("Bows", 255, 135, 0xff685245);
						
				if (equipTypeOption == 5) { 
					renderer.drawRectOpaque(305, 130, 50, 20, activeColour); }
				else { renderer.drawRectOpaque(305, 130, 50, 20, passiveColour); }
					renderer.drawText("Armour", 310, 135, 0xff685245);
					
				renderer.drawRectOpaque(25, 150, 580, 265, activeColour);
				
				renderer.drawRectOpaque(525, 385, 60, 20, 0xff371512);
					renderer.drawText("Close", 540, 390, 0xff722315);
					
					
				switch(mainOptionHover) {
				case 0: break;
				case 1: renderer.drawRect(385, 25, 50, 100, 0xffAA8822); break;
				case 2: renderer.drawRect(440, 25, 50, 100, 0xffAA8822); break;
				case 3: renderer.drawRect(495, 25, 50, 100, 0xffAA8822); break;
				case 4: renderer.drawRect(550, 25, 50, 100, 0xffAA8822); break;
				}
				
				if(closeHover) { renderer.drawRect(525, 385, 60, 20, 0xffAA8822); }
					
				switch(equipTypeHover) {
				case 0: break;
				case 1: renderer.drawRect(30, 130, 50, 20, 0xff685245); break;
				case 2: renderer.drawRect(85, 130, 50, 20, 0xff685245); break;
				case 3: renderer.drawRect(140, 130, 50, 20, 0xff685245); break;
				case 4: renderer.drawRect(195, 130, 50, 20, 0xff685245); break;
				case 5: renderer.drawRect(250, 130, 50, 20, 0xff685245); break;
				case 6: renderer.drawRect(305, 130, 50, 20, 0xff685245); break;
				}
				
				switch(substate) {	
				
					case Crafting: craftingScreen.render(gameContainer, renderer); break;
					case Runeforging: runeforgingScreen.render(gameContainer, renderer); break;
					case Scrapping: scrappingScreen.render(gameContainer, renderer); break;
					case Sharpening: sharpeningScreen.render(gameContainer, renderer); break;				
			
				}
				
				
				break;
				
			case Alchemist: break;
			case Inn: break;

					
			}
			
			

			
		}

}
