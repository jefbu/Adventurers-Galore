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
	private int selectedNumber;
	private int counter;
	private int animationNumber;
	
	private ImageTile icons;
	private int jobSkillRow;
	
	Monster monster;
	
	public SkillBar(Monster monster) {
		
		hover = false;
		skillBarSize = 160;
		xStartPoint = 240;
		yStartPoint = 5;
		skillNumber = 0;
		selectedNumber = 1;
		counter = 0;
		this.monster = monster;
		
		icons = new ImageTile("/skillBarIcons.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE);
		
	}


	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		
		switch(monster.job.jobEnum) {
		
		case Squire: jobSkillRow = 2; break;
		case Knight: jobSkillRow = 2; break;
		case Paladin: jobSkillRow = 2; break;
		
		case Mage: jobSkillRow = 3; break;
		case Magus: jobSkillRow = 3; break;
		case ArchMage: jobSkillRow = 3; break;
		
		case Thief: jobSkillRow = 4; break;
		case Knave: jobSkillRow = 4; break;
		case CatBurglar: jobSkillRow = 4; break;
		
		case Archer: jobSkillRow = 5; break;
		case Hunter: jobSkillRow = 5; break;
		case Sniper: jobSkillRow = 5; break;
		
		case Barbarian: jobSkillRow = 6; break;
		case Berserker: jobSkillRow = 6; break;
		case RedMist: jobSkillRow = 6; break;
		
		default: break;
		
		}
		
				
		if (deltaTime * counter * 5 < 1) { counter++; }
		else { animationNumber++; counter = 0; }
		if (animationNumber > 3) { animationNumber = 1; }

		
		if (gameContainer.getInput().isKeyUp(KeyEvent.VK_NUMPAD1)) { selectedNumber = 1; }
		else if (gameContainer.getInput().isKeyUp(KeyEvent.VK_NUMPAD2)) { selectedNumber = 2; }
		else if (gameContainer.getInput().isKeyUp(KeyEvent.VK_NUMPAD3)) { selectedNumber = 3; }
		else if (gameContainer.getInput().isKeyUp(KeyEvent.VK_NUMPAD4)) { selectedNumber = 4; }

		
		if (gameContainer.getInput().getMouseX() > xStartPoint && gameContainer.getInput().getMouseX() < xStartPoint + skillBarSize + 1 &&
				gameContainer.getInput().getMouseY() > yStartPoint && gameContainer.getInput().getMouseY() < yStartPoint + GameManager.GAMETILESIZE + 1) {
			
			hover = true;
			
			if (gameContainer.getInput().getMouseX() < xStartPoint + 3 + GameManager.GAMETILESIZE) { 
				skillNumber = 1; 
				if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) { selectedNumber = 1; }
			}
			else if (gameContainer.getInput().getMouseX() < xStartPoint + GameManager.GAMETILESIZE * 2) { 
				skillNumber = 2; 
				if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) { selectedNumber = 2; }
			}
			else if (gameContainer.getInput().getMouseX() < xStartPoint + GameManager.GAMETILESIZE * 3) { 
				skillNumber = 3; 
				if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) { selectedNumber = 3; }
			}
			else if (gameContainer.getInput().getMouseX() < xStartPoint + GameManager.GAMETILESIZE * 4) { 
				skillNumber = 4; 
				if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) { selectedNumber = 4; }
			}
			else { hover = false; skillNumber = 0; }
			
		}
		
		else { hover = false; }
		
		
		
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		renderer.drawRect(xStartPoint, yStartPoint, skillBarSize, GameManager.GAMETILESIZE + 2, 0xff000000);
		
		renderer.drawRect(xStartPoint + 1, yStartPoint + 1, GameManager.GAMETILESIZE, GameManager.GAMETILESIZE, 0xff999999);
		renderer.drawRect(xStartPoint + 1 + GameManager.GAMETILESIZE, yStartPoint + 1, GameManager.GAMETILESIZE, GameManager.GAMETILESIZE, 0xff999999);
		renderer.drawRect(xStartPoint + 1 + GameManager.GAMETILESIZE * 2, yStartPoint + 1, GameManager.GAMETILESIZE, GameManager.GAMETILESIZE, 0xff999999);
		renderer.drawRect(xStartPoint + 1 + GameManager.GAMETILESIZE * 3, yStartPoint + 1, GameManager.GAMETILESIZE, GameManager.GAMETILESIZE, 0xff999999);
	
		renderer.drawText("SKILL", xStartPoint + 4 * GameManager.GAMETILESIZE + 5, yStartPoint + GameManager.GAMETILESIZE / 3, 0xffDD8899);

		if (hover) {
			renderer.drawRect(xStartPoint + 1 + GameManager.GAMETILESIZE * (skillNumber - 1), yStartPoint + 1, GameManager.GAMETILESIZE, GameManager.GAMETILESIZE, 0xffDDDDDD);
		}
		
		switch (selectedNumber) {
		case 1:
			renderer.drawImageTile(icons, xStartPoint + 1, yStartPoint + 1, animationNumber, 0);
			renderer.drawImageTile(icons, xStartPoint + 1 + GameManager.GAMETILESIZE, yStartPoint + 1, 0, 1);
			renderer.drawImageTile(icons, xStartPoint + 1 + GameManager.GAMETILESIZE * 2, yStartPoint + 1, 0, jobSkillRow);				
			break;
		case 2:
			renderer.drawImageTile(icons, xStartPoint + 1, yStartPoint + 1, 0, 0);
			renderer.drawImageTile(icons, xStartPoint + 1 + GameManager.GAMETILESIZE, yStartPoint + 1, animationNumber, 1);
			renderer.drawImageTile(icons, xStartPoint + 1 + GameManager.GAMETILESIZE * 2, yStartPoint + 1, 0, jobSkillRow);	
			break;
		case 3:
			renderer.drawImageTile(icons, xStartPoint + 1, yStartPoint + 1, 0, 0);
			renderer.drawImageTile(icons, xStartPoint + 1 + GameManager.GAMETILESIZE, yStartPoint + 1, 0, 1);
			renderer.drawImageTile(icons, xStartPoint + 1 + GameManager.GAMETILESIZE * 2, yStartPoint + 1, animationNumber, jobSkillRow);
			break;
		case 4:
			break;
		
		default: break;
			
		}
		
		renderer.drawImageTile(icons, xStartPoint + 1 + GameManager.GAMETILESIZE * 2, yStartPoint + 1, 0, jobSkillRow);
		
	
	}

	

}
