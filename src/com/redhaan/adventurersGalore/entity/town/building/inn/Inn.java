package com.redhaan.adventurersGalore.entity.town.building.inn;

import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.entity.town.TownSubState;
import com.redhaan.adventurersGalore.entity.town.building.Building;
import com.redhaan.adventurersGalore.inTown.TownMap;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class Inn extends Building {
	
	private boolean generalHover;
	
	private static ImageTile innKeeper = new ImageTile("/innkeeper.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE);
	
	private int timer;
	private int animation;
	
	private PatronScreen patronScreen;

	private static final long serialVersionUID = 1L;
	
	public Inn() {
		
		super();
		x = 0;
		y = 0;
		
		generalHover = false;
		
		timer = 0;
		animation = 0;
		
		patronScreen = new PatronScreen();
		
	}
	
	public void update(GameContainer gameContainer, float deltaTime) {
		
		switch(TownMap.subState) {

		case General:
			if (gameContainer.getInput().getMouseX() > 255 && gameContainer.getInput().getMouseX() < 255 + icon.getTileWidth() &&
					gameContainer.getInput().getMouseY() > 170 && gameContainer.getInput().getMouseY() < 170 + icon.getTileHeight()) {
				generalHover = true;
				if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
					TownMap.subState = TownSubState.Inn;
				}
			} else { generalHover = false; }
			break;
			
		case Inn:
			
			if (!patronScreen.initialised) { patronScreen.initialise(); }
			
			patronScreen.update(gameContainer, deltaTime);
			
			if(timer < 20) { timer++; } else { timer = 0; animation++; }
			if(animation > 3) { animation = 0; }
			break;
			
		case Alchemist: break;
		case Blacksmith: break;	
		case Seer: break;
		
		}
				
	}
	
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		switch (TownMap.subState) {
		
		case General: 		
			renderer.drawImageTile(icon, 255, 170, x, y);
			if (generalHover) { renderer.drawRect(255, 170, icon.getTileWidth(), icon.getTileHeight(), 0xffAA8822); }
			break;
		
		case Inn:
			
			renderer.drawRectOpaque(20, 20, 600, 400, 0xbb222815);
			
			renderer.drawRectOpaque(25, 25, 100, 100, 0xff121621);
			renderer.drawImageTile(innKeeper, 57, 57, animation, 0);
			
			renderer.drawRectOpaque(130, 25, 250, 100, 0xff121621);

			break;
			
		case Alchemist: break;
		case Blacksmith: break;
		case Seer: break;
			
		}
		
	}

}
