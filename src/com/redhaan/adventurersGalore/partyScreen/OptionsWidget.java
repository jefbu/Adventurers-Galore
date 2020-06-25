package com.redhaan.adventurersGalore.partyScreen;

import java.awt.event.KeyEvent;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.GameState;
import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class OptionsWidget extends GameObject {
	
	private int offX, offY;
	private int width, height;
	
	private int activeOption;
	private int activeColor, passiveColor;
	
	public OptionsWidget(int offX, int offY, int width, int height) {
		
		this.offX = offX;
		this.offY = offY;
		this.width = width;
		this.height = height;
		
		activeOption = 1;
		activeColor = 0xff666666;
		passiveColor = 0xff333333;
		
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
		
		case PartyScreen:
			
			int partyMembers = 0;
			for (Adventurer adventurer: GameManager.adventurers.allAdventurers) {
				if (adventurer.inParty) { partyMembers++; }
			}
			if (gameContainer.getInput().isKeyUp(KeyEvent.VK_UP)) {
				if (activeOption > 1) { activeOption --; }
			}
			if (gameContainer.getInput().isKeyUp(KeyEvent.VK_DOWN)) {
				if (activeOption < 5) { activeOption++; }
			}
			if (gameContainer.getInput().isKeyUp(KeyEvent.VK_ENTER)) {
				switch(activeOption) {
				
				case 1: if (PartyScreen.member < partyMembers - 1) { PartyScreen.member++; }
						CommentWidget.timer = 0;
						Adventurer hero = GameManager.adventurers.allAdventurers.get(PartyScreen.member);
						System.out.println("Adventurer: " + hero.name);
						System.out.println("HP Rate: " + hero.levelupPercentages.HP + ", " + "MP Rate: " + hero.levelupPercentages.MP);
						System.out.println("PHY Rate: " + hero.levelupPercentages.PHY + ", " + "AGI Rate: " + hero.levelupPercentages.AGI + ", " + "MAG Rate: " + hero.levelupPercentages.MAG);
						System.out.println("DEX Rate: " + hero.levelupPercentages.DEX + ", " + "INT Rate: " + hero.levelupPercentages.INT + ", " + "PRC Rate: " + hero.levelupPercentages.PRC);
						System.out.println("MOV Rate: " + hero.levelupPercentages.move);
						System.out.println("##########################	");
				break;				
				case 2: if (PartyScreen.member > 0) { PartyScreen.member--; } break;
				case 3: break;
				case 4: break;
				case 5: GameManager.gameState = GameState.WorldMap;
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
			renderer.drawText("Change Equipment", offX + 10, offY + 40 + (2 * height / 6), passiveColor);
			}
		else { 
			renderer.drawRectOpaque(offX + 5, offY + 20 + (2 * height / 6), width - 10, height / 6, passiveColor); 
			renderer.drawText("Change Equipment", offX + 10, offY + 40 + (2 * height / 6), activeColor);
			}
		
		if (activeOption == 4) { 
			renderer.drawRectOpaque(offX + 5, offY + 25 + (3 * height / 6), width - 10, height / 6, activeColor);	
			renderer.drawText("???", offX + 10, offY + 45 + (3 * height / 6), passiveColor);
			}
		else { 
			renderer.drawRectOpaque(offX + 5, offY + 25 + (3 * height / 6), width - 10, height / 6, passiveColor); 
			renderer.drawText("???", offX + 10, offY + 45 + (3 * height / 6), activeColor);
			}		
		
		if (activeOption == 5) { 
			renderer.drawRectOpaque(offX + 5, offY + 30 + (4 * height / 6), width - 10, height / 6, activeColor);	
			renderer.drawText("(X) Exit", offX + 10, offY + 50 + (4 * height / 6), passiveColor);
			}
		else { 
			renderer.drawRectOpaque(offX + 5, offY + 30 + (4 * height / 6), width - 10, height / 6, passiveColor); 
			renderer.drawText("(X) Exit", offX + 10, offY + 50 + (4 * height / 6), activeColor
					);
			}
		
		
	}
	
	

}
