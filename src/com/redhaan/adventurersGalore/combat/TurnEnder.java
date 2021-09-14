package com.redhaan.adventurersGalore.combat;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.SpellAnimation;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class TurnEnder extends GameObject {

	private static final long serialVersionUID = 1L;
	public boolean turnEnded;
	private ImageTile icon;
	
	private boolean hover;
	
	public TurnEnder() {
				
		turnEnded = false;
		icon = new ImageTile("/smallIcons.png", GameManager.GAMETILESIZE / 4, GameManager.GAMETILESIZE / 4);
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		if(gameContainer.getInput().isKeyUp(KeyEvent.VK_ENTER)) {
			if (!SpellAnimation.active) { turnEnded = true; }
		}
		
		if (gameContainer.getInput().getMouseX() > 610 && gameContainer.getInput().getMouseX() < 627 &&
				gameContainer.getInput().getMouseY() > 445 && gameContainer.getInput().getMouseY() < 462) {
			hover = true;
			if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				if (!SpellAnimation.active) { turnEnded = true; }
			}
		} else { hover = false; }
			
		
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		if (hover) { 
			renderer.drawRect(609, 444, 18, 18, 0xff220011); 
			renderer.drawRectOpaque(610, 445, 16, 16, 0xffff99dd);	
			}
		else { renderer.drawRectOpaque(610, 445, 16, 16, 0xffee88cc); }
		
		renderer.drawImageTile(icon, 614, 449, 0, 9);
		renderer.drawText("End Turn", 597, 466, 0xff5b003f);
		
	}
	
	
	public void reset() {
		turnEnded = false;
	}

}
