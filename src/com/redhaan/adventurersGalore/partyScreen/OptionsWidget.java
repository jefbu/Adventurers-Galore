package com.redhaan.adventurersGalore.partyScreen;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.GameState;
import com.redhaan.adventurersGalore.Transition;
import com.redhaan.adventurersGalore.inventory.Inventory;
import com.redhaan.adventurersGalore.inventory.InventoryScreen.InventoryScreen;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class OptionsWidget extends GameObject {

	private static final long serialVersionUID = 1L;
	private int offX, offY;
	private int width, height;
	
	private int activeOption;
	private int activeColor, passiveColor;
	
	private boolean hover;
	private int hoverX, hoverY;
	
	public OptionsWidget(int offX, int offY, int width, int height) {
		
		this.offX = offX;
		this.offY = offY;
		this.width = width;
		this.height = height;
		
		activeOption = 1;
		activeColor = 0xff666666;
		passiveColor = 0xff333333;
		
		hover = false;
		hoverX = 0;
		hoverY = 0;
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		switch(GameManager.gameState) {
		case Combat: break;
		case InTown: break;
		case Titlescreen: break;
		case WorldMap: break;
		case QuestUI: break;
		case Transition: break;
		case QuestScreen: break;
		case PartyCohesionCheckerUI: break;
		
		case PartyScreen:
			
			if (checkHover(offX + 5, offX + width - 10, offY + 10, offY + 10 + height / 6, gameContainer)) { 
				hover = true; 
				activeOption = 1;
				if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) { calculatePartyScreenNumber(true); CommentWidget.timer = 0; } }
			
			else if (checkHover(offX + 5, offX + width - 10, offY + 15 + height / 6, offY + 15 + 2 * height / 6, gameContainer)) { 
				hover = true; 
				activeOption = 2;
				if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) { calculatePartyScreenNumber(false); CommentWidget.timer = 0; } }
			
			else if (checkHover(offX + 5, offX + width - 10, offY + 20 + 2 * height / 6, offY + 20 + 3 * height / 6, gameContainer)) { 
				hover = true; 
				activeOption = 3; }
			
			else if (checkHover(offX + 5, offX + width - 10, offY + 25 + 3 * height / 6, offY + 25 + 4 * height / 6, gameContainer)) { 
				hover = true; 
				activeOption = 4; }
			
			else if (checkHover(offX + 5, offX + width - 10, offY + 30 + 4 * height / 6, offY + 30 + 5 * height / 6, gameContainer)) { 
				hover = true; 
				activeOption = 5;
				if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) { 
					Transition.nextGameState = GameState.WorldMap;
					GameManager.gameState = GameState.Transition; 
					PartyScreen.member = 0;
				}	}						
			
			else { hover = false; }
			
			
			
			if (gameContainer.getInput().isKeyUp(KeyEvent.VK_UP)) {
				if (activeOption > 1) { activeOption --; }
			}
			if (gameContainer.getInput().isKeyUp(KeyEvent.VK_DOWN)) {
				if (activeOption < 5) { activeOption++; }
			}
			if (gameContainer.getInput().isKeyUp(KeyEvent.VK_ENTER)) {
				switch(activeOption) {
				
				case 1: calculatePartyScreenNumber(true);
						CommentWidget.timer = 0;
						System.out.println(GameManager.adventurers.allAdventurers.get(PartyScreen.member).skills.skillSlots + " skill slots");
						/*Adventurer hero = GameManager.adventurers.allAdventurers.get(PartyScreen.member);
						System.out.println("Adventurer: " + hero.name);
						System.out.println("HP Rate: " + hero.levelupPercentages.HP + ", " + "MP Rate: " + hero.levelupPercentages.MP);
						System.out.println("PHY Rate: " + hero.levelupPercentages.PHY + ", " + "AGI Rate: " + hero.levelupPercentages.AGI + ", " + "MAG Rate: " + hero.levelupPercentages.MAG);
						System.out.println("DEX Rate: " + hero.levelupPercentages.DEX + ", " + "INT Rate: " + hero.levelupPercentages.INT + ", " + "PRC Rate: " + hero.levelupPercentages.PRC);
						System.out.println("MOV Rate: " + hero.levelupPercentages.move);
						System.out.println("##########################	");*/
				break;				
				case 2: calculatePartyScreenNumber(false); break;
				case 3: 
					Transition.nextGameState = GameState.Inventory;
					GameManager.gameState = GameState.Transition;
					break;
				case 4:
					Transition.nextGameState = GameState.QuestScreen;
					GameManager.gameState = GameState.Transition;
					break;
				case 5: 
					Transition.nextGameState = GameState.WorldMap;
					GameManager.gameState = GameState.Transition;
					break;
				}
			}		
			break;
		}		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		renderer.drawRectOpaque(offX, offY, width, height, 0xff282828);
		
		if (activeOption == 1) { 
			renderer.drawRectOpaque(offX + 5, offY + 10, width - 10, height / 6, activeColor);	
			renderer.drawText("(->) Next Adventurer", offX + 10, offY + 30, passiveColor);
			}
		else { 
			renderer.drawRectOpaque(offX + 5, offY + 10, width - 10, height / 6, passiveColor);
			renderer.drawText("(->) Next Adventurer", offX + 10, offY + 30, activeColor);
			}
		
		if (activeOption == 2) { 
			renderer.drawRectOpaque(offX + 5, offY + 15 + (height / 6), width - 10, height / 6, activeColor);	
			renderer.drawText("(<-) Previous Adventurer", offX + 10, offY + 35 + (height / 6), passiveColor);			
			}
		else { 
			renderer.drawRectOpaque(offX + 5, offY + 15 + (height / 6), width - 10, height / 6, passiveColor); 
			renderer.drawText("(<-) Previous Adventurer", offX + 10, offY + 35 + (height / 6), activeColor);						
			}
		
		if (activeOption == 3) { 
			renderer.drawRectOpaque(offX + 5, offY + 20 + (2 * height / 6), width - 10, height / 6, activeColor);	
			renderer.drawText("(I)nventory", offX + 10, offY + 40 + (2 * height / 6), passiveColor);
			}
		else { 
			renderer.drawRectOpaque(offX + 5, offY + 20 + (2 * height / 6), width - 10, height / 6, passiveColor); 
			renderer.drawText("(I)nventory", offX + 10, offY + 40 + (2 * height / 6), activeColor);
			}
		
		if (activeOption == 4) { 
			renderer.drawRectOpaque(offX + 5, offY + 25 + (3 * height / 6), width - 10, height / 6, activeColor);	
			renderer.drawText("(Q)uests", offX + 10, offY + 45 + (3 * height / 6), passiveColor);
			}
		else { 
			renderer.drawRectOpaque(offX + 5, offY + 25 + (3 * height / 6), width - 10, height / 6, passiveColor); 
			renderer.drawText("(Q)uests", offX + 10, offY + 45 + (3 * height / 6), activeColor);
			}		
		
		if (activeOption == 5) { 
			renderer.drawRectOpaque(offX + 5, offY + 30 + (4 * height / 6), width - 10, height / 6, activeColor);	
			renderer.drawText("(E)xit", offX + 10, offY + 50 + (4 * height / 6), passiveColor);
			}
		else { 
			renderer.drawRectOpaque(offX + 5, offY + 30 + (4 * height / 6), width - 10, height / 6, passiveColor); 
			renderer.drawText("(E)xit", offX + 10, offY + 50 + (4 * height / 6), activeColor
					);
			}
		
		if(hover) { renderer.drawRect(hoverX, hoverY, width - 8, height / 6 + 2, 0xff999999); }		
		
	}
	
	
	private void calculatePartyScreenNumber(boolean increasing) {
		
		boolean gotNumber = false;
		int tempPartyNumber = 0;
		
		for (int i = 0; i < GameManager.adventurers.allAdventurers.size(); i++) {
			if(increasing) {
				if(GameManager.adventurers.allAdventurers.get(i).inParty && i > PartyScreen.member && !gotNumber) {
					PartyScreen.member = i;
					gotNumber = true;
				}
			} else {
				if(GameManager.adventurers.allAdventurers.get(i).inParty && i < PartyScreen.member) {
					tempPartyNumber = i;
				}
			}
		}
		
		if(!gotNumber) { PartyScreen.member = tempPartyNumber; }
		
	}
	
	
	private boolean checkHover(int leftSide, int rightSide, int top, int bottom, GameContainer gameContainer) {
		
		if(gameContainer.getInput().getMouseX() > leftSide && gameContainer.getInput().getMouseX() < rightSide &&
				gameContainer.getInput().getMouseY() > top && gameContainer.getInput().getMouseY() < bottom) {
			hoverX = leftSide - 1;
			hoverY = top - 1;
			return true;
		} else { return false; }
		
	}
	
	

}
