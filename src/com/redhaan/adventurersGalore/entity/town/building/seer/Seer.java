package com.redhaan.adventurersGalore.entity.town.building.seer;

import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.entity.town.TownSubState;
import com.redhaan.adventurersGalore.entity.town.building.Building;
import com.redhaan.adventurersGalore.inTown.TownMap;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class Seer extends Building {

	private static final long serialVersionUID = 1L;
	
	private boolean generalHover;
	private static ImageTile seer = new ImageTile("/seer.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE);
	
	private int timer;
	private int animation;
	
	private AdventurerListScreen listScreen;

	public Seer() {
		
		super();
		x = 2;
		y = 1;
		
		generalHover = false;
		
		timer = 0;
		animation = 0;
		
		listScreen = new AdventurerListScreen();
		
	}
	
	
	public void update(GameContainer gameContainer, float deltaTime) {
		
		switch(TownMap.subState) {

		case General:
			if (gameContainer.getInput().getMouseX() > 300 && gameContainer.getInput().getMouseX() < 300 + icon.getTileWidth() &&
					gameContainer.getInput().getMouseY() > 325 && gameContainer.getInput().getMouseY() < 325 + icon.getTileHeight()) {
				generalHover = true;
				if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
					TownMap.subState = TownSubState.Seer;
				}
			} else { generalHover = false; }
			break;
			
		case Seer:
			
			if (!listScreen.initialised) { listScreen.initialise(); }
			
			listScreen.update(gameContainer, deltaTime);
			
			if(timer < 20) { timer++; } else { timer = 0; animation++; }
			if(animation > 3) { animation = 0; }
			
			break;
			
		case Inn: break;		
		case Alchemist: break;
		case Blacksmith: break;		
		
		}
				
	}
	
	
	
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		switch (TownMap.subState) {
		
		case General: 		
			renderer.drawImageTile(icon, 300, 325, x, y);
			if (generalHover) { renderer.drawRect(300, 325, icon.getTileWidth(), icon.getTileHeight(), 0xffAA8822); }
			break;
		
		case Seer:
			
			renderer.drawRectOpaque(20, 20, 605, 400, 0xbb222815);
			
			renderer.drawRectOpaque(25, 25, 100, 100, 0xff121621);
			renderer.drawImageTile(seer, 57, 57, animation, 0);
			
			renderer.drawRectOpaque(130, 25, 250, 100, 0xff121621);
			renderer.drawText("Double, double, soil, and dabble,", 135, 30, 0xffAA99DD);
			renderer.drawText("Hear me prattle, sing, and babble.", 135, 45, 0xffAA99DD);
			renderer.drawText("Cauldron on me fire wobble.", 135, 60, 0xffAA99DD);
			renderer.drawText("I bought it second hand, it's labile.", 135, 75, 0xffAA99DD);
			renderer.drawText("Anyways, who do you want me to scry?", 135, 90, 0xffAA99DD);
			
			
			listScreen.render(gameContainer, renderer);
			

			break;
		
		case Inn: break;
		case Alchemist: break;
		case Blacksmith: break;
			
		}
		
	}
	
	

}
