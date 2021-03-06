package com.redhaan.adventurersGalore.entity.town.building.blacksmith.craftingScreen.daggerSubscreen;

import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameObject;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class DaggerSubScreen extends GameObject {
	
	private static final long serialVersionUID = 1L;
	
	private int tierNr;
	private boolean tierHover;
	
	private DaggerTier1 tier1;
	private DaggerTier2 tier2;
	private DaggerTier3 tier3;
	private DaggerTier4 tier4;
	
	public DaggerSubScreen() {
		
		tierNr = 1;
		
		tier1 = new DaggerTier1();
		tier2 = new DaggerTier2();
		tier3 = new DaggerTier3();
		tier4 = new DaggerTier4();
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		if (gameContainer.getInput().getMouseX() > 30 && gameContainer.getInput().getMouseX() < 70 &&
				gameContainer.getInput().getMouseY() > 390 && gameContainer.getInput().getMouseY() < 405) {
			
			tierHover = true;
			
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				tierNr++;
				if (tierNr > 4) { tierNr = 1; }
			}
		
		} else { tierHover = false; }
		
		
		switch(tierNr) {
		
		case 1: tier1.update(gameContainer, deltaTime); break;
		case 2: tier2.update(gameContainer, deltaTime); break;
		case 3: tier3.update(gameContainer, deltaTime); break;
		case 4: tier4.update(gameContainer, deltaTime); break;
		
		}
		
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		switch(tierNr) {
		
		case 1: tier1.render(gameContainer, renderer); break;
		case 2: tier2.render(gameContainer, renderer); break;
		case 3: tier3.render(gameContainer, renderer); break;
		case 4: tier4.render(gameContainer, renderer); break;
		
		}		
		
		
		renderer.drawRectOpaque(30, 390, 40, 15, 0xff685245);
			renderer.drawText("Tier: " + tierNr, 35, 393, 0xff181205);
		if(tierHover) { renderer.drawRect(30, 390, 40, 15, 0xffAA8822); }
		
	}

}
