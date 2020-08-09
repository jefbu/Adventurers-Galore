package com.redhaan.adventurersGalore.entity.combatAddOns;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.Monster;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class SkillBar extends GameObject {

	private static final long serialVersionUID = 1L;
	
	private boolean hover;
	private int skillBarSize;
	private int xStartPoint;
	private int yStartPoint;
	private int skillNumber;
	private boolean selected;
	private int counter;
	private int animationNumber;
	
	private ImageTile icons;
	
	public SkillBar(Monster monster) {
		
		hover = false;
		selected = false;
		skillBarSize = 160;
		xStartPoint = 240;
		yStartPoint = 5;
		skillNumber = 0;
		counter = 0;
		
		icons = new ImageTile("/skillBarIcons.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE);
		
	}


	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
				
		if (selected) { 
			if (deltaTime * counter * 3 < 1) { counter++; }
			else { animationNumber++; counter = 0; }
			if (animationNumber > 3) { animationNumber = 1; }
		}
		
		if (gameContainer.getInput().isKeyUp(KeyEvent.VK_P)) {
			if(!selected) { selected = true; System.out.println("bring the fire");}
		}
		
		if (gameContainer.getInput().getMouseX() > xStartPoint && gameContainer.getInput().getMouseX() < xStartPoint + skillBarSize + 1 &&
				gameContainer.getInput().getMouseY() > yStartPoint && gameContainer.getInput().getMouseY() < yStartPoint + GameManager.GAMETILESIZE + 1) {
			
			hover = true;
			
			if (gameContainer.getInput().getMouseX() < xStartPoint + 3 + GameManager.GAMETILESIZE) { skillNumber = 1; }
			else if (gameContainer.getInput().getMouseX() < xStartPoint + GameManager.GAMETILESIZE * 2) { skillNumber = 2; }
			else if (gameContainer.getInput().getMouseX() < xStartPoint + GameManager.GAMETILESIZE * 3) { skillNumber = 3; }
			else if (gameContainer.getInput().getMouseX() < xStartPoint + GameManager.GAMETILESIZE * 4) { skillNumber = 4; }
			else { hover = false; skillNumber = 0; }
			
		}
		
		else { 
			hover = false;
			if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				selected = false;
				animationNumber = 0;
			}
		};
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		renderer.drawRect(xStartPoint, yStartPoint, skillBarSize, GameManager.GAMETILESIZE + 2, 0xff000000);
		
		renderer.drawRect(xStartPoint + 1, yStartPoint + 1, GameManager.GAMETILESIZE, GameManager.GAMETILESIZE, 0xff999999);
		renderer.drawRect(xStartPoint + 1 + GameManager.GAMETILESIZE, yStartPoint + 1, GameManager.GAMETILESIZE, GameManager.GAMETILESIZE, 0xff999999);
		renderer.drawRect(xStartPoint + 1 + GameManager.GAMETILESIZE * 2, yStartPoint + 1, GameManager.GAMETILESIZE, GameManager.GAMETILESIZE, 0xff999999);
		renderer.drawRect(xStartPoint + 1 + GameManager.GAMETILESIZE * 3, yStartPoint + 1, GameManager.GAMETILESIZE, GameManager.GAMETILESIZE, 0xff999999);
	
		renderer.drawText("SKILL", xStartPoint + 4 * GameManager.GAMETILESIZE + 5, yStartPoint + GameManager.GAMETILESIZE / 3, 0xffDD8899);
		
		renderer.drawImageTile(icons, xStartPoint + 1, yStartPoint + 1, animationNumber, 0);
		renderer.drawImageTile(icons, xStartPoint + 1 + GameManager.GAMETILESIZE, yStartPoint + 1, 0, 1);
		
		
		if (hover) {
			renderer.drawRect(xStartPoint + 1 + GameManager.GAMETILESIZE * (skillNumber - 1), yStartPoint + 1, GameManager.GAMETILESIZE, GameManager.GAMETILESIZE, 0xffDDDDDD);
		}
	
	}

	

}
