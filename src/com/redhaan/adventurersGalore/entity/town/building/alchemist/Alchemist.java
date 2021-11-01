package com.redhaan.adventurersGalore.entity.town.building.alchemist;

import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.entity.town.TownSubState;
import com.redhaan.adventurersGalore.entity.town.building.Building;
import com.redhaan.adventurersGalore.inTown.TownMap;
import com.redhaan.adventurersGalore.inventory.Inventory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class Alchemist extends Building {

	private static final long serialVersionUID = 1L;
	
	private boolean generalHover;
	private boolean closeHover;
	
	private int animation;
	private int timer;
	
	private static ImageTile alchemist = new ImageTile("/alchemist.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE);
	
	private PotionLine whitePotion;
	private PotionLine goldPotion;
	private PotionLine tealPotion;
	private PotionLine redPotion;
	private PotionLine greenPotion;
	private PotionLine bluePotion;
	private PotionLine brownPotion;
	private PotionLine purplePotion;
	private PotionLine blackPotion;

	public Alchemist() {
		
		x = 1;
		y = 1;
		
		generalHover = false;
		closeHover = false;
		
		animation = 0;
		timer = 0;
		
		whitePotion = new PotionLine(30, 135, 1);
		goldPotion = new PotionLine(30, 180, 2);
		tealPotion = new PotionLine(30, 225, 3);
		redPotion = new PotionLine(30, 270, 4);
		greenPotion = new PotionLine(30, 315, 5);
		bluePotion = new PotionLine(295, 135, 6);
		brownPotion = new PotionLine(295, 180, 7);
		purplePotion = new PotionLine(295, 225, 8);
		blackPotion = new PotionLine(295, 270, 9);
				
	}
	
	public void update(GameContainer gameContainer, float deltaTime) {
		
		switch(TownMap.subState) {

		case General:
			if (gameContainer.getInput().getMouseX() > 240 && gameContainer.getInput().getMouseX() < 240 + icon.getTileWidth() &&
					gameContainer.getInput().getMouseY() > 60 && gameContainer.getInput().getMouseY() < 60 + icon.getTileHeight()) {
				generalHover = true;
				if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
					TownMap.subState = TownSubState.Alchemist;
				}
			} else { generalHover = false; }
			break;
			
		case Alchemist:
			
			if(timer < 20) { timer++; } else { timer = 0; animation++; }
			if(animation > 3) { animation = 0; }

			if (gameContainer.getInput().getMouseX() > 525 && gameContainer.getInput().getMouseX() < 585 &&
					gameContainer.getInput().getMouseY() > 385 && gameContainer.getInput().getMouseY() < 405) {
				closeHover = true;
				if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) { 
					TownMap.subState = TownSubState.General; 
					whitePotion.initialised = false;
				}
			} else { closeHover = false; }
			
			whitePotion.update(gameContainer, deltaTime);
			goldPotion.update(gameContainer, deltaTime);
			tealPotion.update(gameContainer, deltaTime);
			redPotion.update(gameContainer, deltaTime);
			greenPotion.update(gameContainer, deltaTime);
			bluePotion.update(gameContainer, deltaTime);
			brownPotion.update(gameContainer, deltaTime);
			purplePotion.update(gameContainer, deltaTime);
			blackPotion.update(gameContainer, deltaTime);			
	
			break;
			
		case Inn: break;
		case Blacksmith: break;	
		case Seer: break;
		case Jeweller: break;
		
		}
		
	}
	
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		switch (TownMap.subState) {
		
		case General:
			renderer.drawImageTile(icon, 240, 60, x, y);
			if (generalHover) { renderer.drawRect(240, 60, icon.getTileWidth(), icon.getTileHeight(), 0xffAA8822); }
			break;
		
		case Alchemist:
			
			renderer.drawRectOpaque(20, 20, 600, 400, 0xbb222815);
			
			renderer.drawRectOpaque(25, 25, 100, 100, 0xff121621);
			renderer.drawImageTile(alchemist, 57, 57, animation, 0);
			
			renderer.drawRectOpaque(130, 25, 470, 100, 0xff121621);
			renderer.drawText("Yes? Can't you see I'm busy?", 140, 45, 0xff617191);
			renderer.drawText("Potions? Fine then, quick and easy..", 140, 60, 0xff617191);
			renderer.drawText("Nono, all my reagents are above the shelf, nothing sleazy", 140, 75, 0xff617191);
			renderer.drawText("Please don't smell that purple bottle, you'll get sneezy.", 140, 90, 0xff617191);
												
			renderer.drawRectOpaque(25, 130, 580, 285, 0xff121612);
			
			renderer.drawRectOpaque(525, 385, 60, 20, 0xff371512);
				renderer.drawText("Close", 540, 390, 0xff722315);
				if(closeHover) { renderer.drawRect(525, 385, 60, 20, 0xffAA8822); }
				
			whitePotion.render(gameContainer, renderer);
			goldPotion.render(gameContainer, renderer);
			tealPotion.render(gameContainer, renderer);
			redPotion.render(gameContainer, renderer);
			greenPotion.render(gameContainer, renderer);
			bluePotion.render(gameContainer, renderer);
			brownPotion.render(gameContainer, renderer);
			purplePotion.render(gameContainer, renderer);
			blackPotion.render(gameContainer, renderer);				
			
			break;
			
		case Inn: break;
		case Seer: break;
		case Blacksmith: break;
		case Jeweller: break;
		
		}
				
	}
	

}
