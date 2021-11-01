package com.redhaan.adventurersGalore.entity.combatAddOns;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class CombatMovesBar extends GameObject {

	private static final long serialVersionUID = 1L;
	
	private boolean hover;
	private int skillBarSize;
	private int xStartPoint;
	private int yStartPoint;
	private int skillNumber;
	public int selectedNumber;
	private int counter;
	private int animationNumber;
	
	private ImageTile icons;
	
	Adventurer adventurer;
	
	public CombatMovesBar(Adventurer adventurer) {
		
		hover = false;
		skillBarSize = 160;
		xStartPoint = 240;
		yStartPoint = 5;
		skillNumber = 0;
		selectedNumber = 1;
		counter = 0;
		this.adventurer = adventurer;
		
		icons = new ImageTile("/skillBarIcons.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE);
		
	}


	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		if (gameContainer.getInput().isKeyUp(KeyEvent.VK_NUMPAD1)) { selectedNumber = 1; }
		else if (gameContainer.getInput().isKeyUp(KeyEvent.VK_NUMPAD2) && !adventurer.spells.isEmpty()) { selectedNumber = 2; }
		else if (gameContainer.getInput().isKeyUp(KeyEvent.VK_NUMPAD3)) { selectedNumber = 3; }
		else if (gameContainer.getInput().isKeyUp(KeyEvent.VK_NUMPAD4) && adventurer.combatMoves.size() > 3) { selectedNumber = 4; }

		
		if (gameContainer.getInput().getMouseX() > xStartPoint && gameContainer.getInput().getMouseX() < xStartPoint + skillBarSize + 1 &&
				gameContainer.getInput().getMouseY() > yStartPoint && gameContainer.getInput().getMouseY() < yStartPoint + GameManager.GAMETILESIZE + 1) {
			
			hover = true;
			
			if (gameContainer.getInput().getMouseX() < xStartPoint + 3 + GameManager.GAMETILESIZE) { 
				skillNumber = 1; 
				if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) { selectedNumber = 1; }
			}
			else if (gameContainer.getInput().getMouseX() < xStartPoint + GameManager.GAMETILESIZE * 2 && !adventurer.spells.isEmpty()) { 
				skillNumber = 2; 
				if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) { selectedNumber = 2; }
			}
			else if (gameContainer.getInput().getMouseX() < xStartPoint + GameManager.GAMETILESIZE * 3) { 
				skillNumber = 3; 
				if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) { selectedNumber = 3; }
			}
			else if (gameContainer.getInput().getMouseX() < xStartPoint + GameManager.GAMETILESIZE * 4 && adventurer.combatMoves.size() > 3) { 
				skillNumber = 4; 
				if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) { selectedNumber = 4; }
			}
			else { hover = false; skillNumber = 0; }
			
		}
		
		else { hover = false; }
		
		
		
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		if (counter < 20) { counter++; }
		else { animationNumber++; counter = 0; }
		if (animationNumber > 3) { animationNumber = 1; }
		
		
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
		case 0:
			renderer.drawImageTile(icons, xStartPoint + 1, yStartPoint + 1, 0, adventurer.combatMoves.get(0).row);
			if (adventurer.spells.isEmpty()) { renderer.drawImageTile(icons, xStartPoint + 1 + GameManager.GAMETILESIZE, yStartPoint + 1, 0, 7); }
			else { renderer.drawImageTile(icons, xStartPoint + 1 + GameManager.GAMETILESIZE, yStartPoint + 1, 0, adventurer.combatMoves.get(1).row); }
			renderer.drawImageTile(icons, xStartPoint + 1 + GameManager.GAMETILESIZE * 2, yStartPoint + 1, 0, adventurer.combatMoves.get(2).row);
			if(adventurer.combatMoves.size() > 3) {
				renderer.drawImageTile(icons, xStartPoint + 1 + GameManager.GAMETILESIZE * 3, yStartPoint + 1, 0, adventurer.combatMoves.get(3).row);
			}
			break;		
		case 1:
			renderer.drawImageTile(icons, xStartPoint + 1, yStartPoint + 1, animationNumber, adventurer.combatMoves.get(0).row);
			if (adventurer.spells.isEmpty()) { renderer.drawImageTile(icons, xStartPoint + 1 + GameManager.GAMETILESIZE, yStartPoint + 1, 0, 7);  }
			else { renderer.drawImageTile(icons, xStartPoint + 1 + GameManager.GAMETILESIZE, yStartPoint + 1, 0, adventurer.combatMoves.get(1).row); }
			renderer.drawImageTile(icons, xStartPoint + 1 + GameManager.GAMETILESIZE * 2, yStartPoint + 1, 0, adventurer.combatMoves.get(2).row);
			if(adventurer.combatMoves.size() > 3) {
				renderer.drawImageTile(icons, xStartPoint + 1 + GameManager.GAMETILESIZE * 3, yStartPoint + 1, 0, adventurer.combatMoves.get(3).row);
			}
			break;
		case 2:
			renderer.drawImageTile(icons, xStartPoint + 1, yStartPoint + 1, 0, adventurer.combatMoves.get(0).row);
			renderer.drawImageTile(icons, xStartPoint + 1 + GameManager.GAMETILESIZE, yStartPoint + 1, animationNumber, adventurer.combatMoves.get(1).row);
			renderer.drawImageTile(icons, xStartPoint + 1 + GameManager.GAMETILESIZE * 2, yStartPoint + 1, 0, adventurer.combatMoves.get(2).row);	
			if(adventurer.combatMoves.size() > 3) {
				renderer.drawImageTile(icons, xStartPoint + 1 + GameManager.GAMETILESIZE * 3, yStartPoint + 1, 0, adventurer.combatMoves.get(3).row);
			}
			break;
		case 3:
			renderer.drawImageTile(icons, xStartPoint + 1, yStartPoint + 1, 0, adventurer.combatMoves.get(0).row);
			if (adventurer.spells.isEmpty()) { renderer.drawImageTile(icons, xStartPoint + 1 + GameManager.GAMETILESIZE, yStartPoint + 1, 0, 7); System.out.println("empty");}
			else { renderer.drawImageTile(icons, xStartPoint + 1 + GameManager.GAMETILESIZE, yStartPoint + 1, 0, adventurer.combatMoves.get(1).row); System.out.println("not empty");}
			renderer.drawImageTile(icons, xStartPoint + 1 + GameManager.GAMETILESIZE * 2, yStartPoint + 1, animationNumber, adventurer.combatMoves.get(2).row);
			if(adventurer.combatMoves.size() > 3) {
				renderer.drawImageTile(icons, xStartPoint + 1 + GameManager.GAMETILESIZE * 3, yStartPoint + 1, 0, adventurer.combatMoves.get(3).row);
			}
			break;
		case 4:
			renderer.drawImageTile(icons, xStartPoint + 1, yStartPoint + 1, 0, adventurer.combatMoves.get(0).row);
			if (adventurer.spells.isEmpty()) { renderer.drawImageTile(icons, xStartPoint + 1 + GameManager.GAMETILESIZE, yStartPoint + 1, 0, 7); System.out.println("empty");}
			else { renderer.drawImageTile(icons, xStartPoint + 1 + GameManager.GAMETILESIZE, yStartPoint + 1, 0, adventurer.combatMoves.get(1).row); System.out.println("not empty");}
			renderer.drawImageTile(icons, xStartPoint + 1 + GameManager.GAMETILESIZE * 2, yStartPoint + 1, 0, adventurer.combatMoves.get(2).row);
			if(adventurer.combatMoves.size() > 3) {
				renderer.drawImageTile(icons, xStartPoint + 1 + GameManager.GAMETILESIZE * 3, yStartPoint + 1, animationNumber, adventurer.combatMoves.get(3).row);
			}
			break;
		
		default: break;
			
		}
		
		//renderer.drawImageTile(icons, xStartPoint + 1 + GameManager.GAMETILESIZE * 2, yStartPoint + 1, 0, jobSkillRow);
		
	
	}

	

}
