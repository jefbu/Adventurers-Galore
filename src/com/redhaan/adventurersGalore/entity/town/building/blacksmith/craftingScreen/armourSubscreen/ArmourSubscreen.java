package com.redhaan.adventurersGalore.entity.town.building.blacksmith.craftingScreen.armourSubscreen;

import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameObject;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class ArmourSubscreen extends GameObject {
	
	
	private static final long serialVersionUID = 1L;
	
	private int tierNr;
	private int tierHover;
	
	private ArmourTier1 tier1;
	private ArmourTier2 tier2;
	private ArmourTier3 tier3;
	private ArmourTier4 tier4;
	
	public ArmourSubscreen() {
		
		tierNr = 1;
		tierHover = 0;
		
		tier1 = new ArmourTier1();
		tier2 = new ArmourTier2();
		tier3 = new ArmourTier3();
		tier4 = new ArmourTier4();
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		if (gameContainer.getInput().getMouseX() > 30 && gameContainer.getInput().getMouseX() < 80 &&
				gameContainer.getInput().getMouseY() > 390 && gameContainer.getInput().getMouseY() < 405) {			
			tierHover = 1;			
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) { tierNr = 1; }		
		} 	
		
		else if (gameContainer.getInput().getMouseX() > 90 && gameContainer.getInput().getMouseX() < 140 &&
				gameContainer.getInput().getMouseY() > 390 && gameContainer.getInput().getMouseY() < 405) {			
			tierHover = 2;			
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) { tierNr = 2; }		
		} 
		
		else if (gameContainer.getInput().getMouseX() > 150 && gameContainer.getInput().getMouseX() < 200 &&
				gameContainer.getInput().getMouseY() > 390 && gameContainer.getInput().getMouseY() < 405) {			
			tierHover = 3;			
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) { tierNr = 3; }		
		} 
		
		else if (gameContainer.getInput().getMouseX() > 210 && gameContainer.getInput().getMouseX() < 260 &&
				gameContainer.getInput().getMouseY() > 390 && gameContainer.getInput().getMouseY() < 405) {
			tierHover = 4;			
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) { tierNr = 4; }		
		} 		
		
		else { tierHover = 0; }
		
		
		switch(tierNr) {
		
		case 1: tier1.update(gameContainer, deltaTime); break;
		case 2: tier2.update(gameContainer, deltaTime); break;
		case 3: tier3.update(gameContainer, deltaTime); break;
		case 4: tier4.update(gameContainer, deltaTime); break;
		
		}
		
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
				
		renderer.drawRectOpaque(30, 390, 50, 15, 0xff685245);
			renderer.drawText("Basic", 45, 393, 0xff181205);
		renderer.drawRectOpaque(90, 390, 50, 15, 0xff685245);
			renderer.drawText("Fine", 105, 393, 0xff181205);
		renderer.drawRectOpaque(150, 390, 50, 15, 0xff685245);
			renderer.drawText("Rare", 165, 393, 0xff181205);
		renderer.drawRectOpaque(210, 390, 50, 15, 0xff685245);
			renderer.drawText("Splendid", 215, 393, 0xff181205);
			
		switch(tierNr) {
		
		case 1: renderer.drawRect(30, 390, 50, 15, 0xff22AA88); tier1.render(gameContainer, renderer); break;
		case 2: renderer.drawRect(90, 390, 50, 15, 0xff22AA88); tier2.render(gameContainer, renderer); break;
		case 3: renderer.drawRect(150, 390, 50, 15, 0xff22AA88); tier3.render(gameContainer, renderer); break;
		case 4: renderer.drawRect(210, 390, 50, 15, 0xff22AA88); tier4.render(gameContainer, renderer); break;
		
		}	
			
		switch(tierHover) {
		
		case 0: break;
		case 1: renderer.drawRect(30, 390, 50, 15, 0xffAA8822); break;
		case 2: renderer.drawRect(90, 390, 50, 15, 0xffAA8822); break;
		case 3: renderer.drawRect(150, 390, 50, 15, 0xffAA8822); break;
		case 4: renderer.drawRect(210, 390, 50, 15, 0xffAA8822); break;
			
		}
					
	}

}
