package com.redhaan.adventurersGalore.entity.party;

import java.awt.event.MouseEvent;
import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.GameState;
import com.redhaan.adventurersGalore.Transition;
import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class PartyCohesionCheckerUI extends GameObject {

	private static final long serialVersionUID = 1L;
	public static GameState nextGameState;	
	private boolean textFinished;
	
	private String textToDrawFrom;
	private String textToDraw;
	private int counter;
	
	public static Adventurer adventurer;
	
	private Random random;
	
	private String firstLine;
	private String secondLine;
	private String thirdLine;
	
	private boolean hovering;
	
	public PartyCohesionCheckerUI() {
		
		nextGameState = GameState.Titlescreen;
		textFinished = false;
		textToDrawFrom = "";
		textToDraw = "";
		firstLine = "";
		secondLine = "";
		thirdLine = "";
		counter = 0;
		adventurer = new Adventurer();
		random = new Random();
		hovering = false;
		
	}


	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		switch (GameManager.gameState) {
		
		case PartyCohesionCheckerUI:
			
			if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				if(textFinished) {
					if (gameContainer.getInput().getMouseX() > 400 && gameContainer.getInput().getMouseX() <= 470
							&& gameContainer.getInput().getMouseY() > 330 && gameContainer.getInput().getMouseY() <= 350) {
						firstLine = "";
						secondLine = "";
						thirdLine = "";
						textToDraw = "";
						textToDrawFrom = "";
						counter = 0;
						textFinished = false;
						Transition.nextGameState = nextGameState;
						GameManager.gameState = GameState.Transition;
					}
				}
			}
			
			if (gameContainer.getInput().getMouseX() > 400 && gameContainer.getInput().getMouseX() <= 470
					&& gameContainer.getInput().getMouseY() > 330 && gameContainer.getInput().getMouseY() <= 350) { hovering = true; }
			else { hovering = false; }
			
			if(textToDrawFrom.length() == 0) { textToDrawFrom = createGoodByeText(); }
			
			if(textToDraw.length() < textToDrawFrom.length()) {
				textToDraw = textToDraw + textToDrawFrom.substring(counter, counter + 1);
				counter++;
			}
			
			else {
				textFinished = true;
			}
			
			
			
			
			
			break;
		
		case Combat: break;
		case InTown: break;
		case PartyScreen: break;
		case QuestUI: break;
		case Titlescreen: break;
		case Transition: break;
		case WorldMap: break;
		default: break;
		
		}			
	}


	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		switch (GameManager.gameState) {
		
		case PartyCohesionCheckerUI:
				
				if(textToDraw.length() < 60) {
					firstLine = textToDraw;
				}
			
				else if(textToDraw.length() < 120) {					
					int nextSpaceFirstLine = 0;
					for (int i = 0; i < 60; i++) {
						if (textToDraw.charAt(i) == 32) { nextSpaceFirstLine = i; }
					}
					firstLine = textToDraw.substring(0, nextSpaceFirstLine);
					secondLine = textToDraw.substring(nextSpaceFirstLine + 1);
				}
				
				else if(textToDraw.length() < 180) {
					int nextSpaceFirstLine = 0;
					for (int i = 0; i < 60; i++) {
						if (textToDraw.charAt(i) == 32) { nextSpaceFirstLine = i; }
					}
					firstLine = textToDraw.substring(0, nextSpaceFirstLine);
					int nextSpaceSecondLine = 0;
					for (int i = nextSpaceFirstLine + 1; i < nextSpaceFirstLine + 60; i++) {
						if (textToDraw.charAt(i) == 32) { nextSpaceSecondLine = i; }
					}
					secondLine = textToDraw.substring(nextSpaceFirstLine + 1, nextSpaceSecondLine);
					thirdLine = textToDraw.substring(nextSpaceSecondLine + 1);
				}

			
			renderer.drawRectOpaque(160, 120, 320, 240, 0xff161211);

			renderer.drawRectOpaque(170, 130, 80, 110, 0x20562734);
				renderer.drawText(adventurer.job.name, 175, 135, 0xAAA8C7A3);
				renderer.drawText(adventurer.race.name, 175, 145, 0xAAA8C7A3);
				renderer.drawText("Level: " + adventurer.getLevel(), 175, 155, 0xAAA8C7A3);
				renderer.drawText(adventurer.gender + ", age: " + adventurer.age, 175, 165, 0xAAA8C7A3);
			renderer.drawRectOpaque(260, 130, 120, 110, 0x20275634);
				renderer.drawText(adventurer.name, 310, 140, 0xDDA8C7A3);
				renderer.drawImageTile(adventurer.icon, 305, 180, 0, 0);
			renderer.drawRectOpaque(390, 130, 80, 110, 0x20562734);
				renderer.drawText("HP: " + adventurer.maxStats.HP, 395, 135, 0xAAA8C7A3);
				renderer.drawText("MP: " + adventurer.maxStats.MP, 395, 145, 0xAAA8C7A3);
				renderer.drawText("PHY: " + adventurer.maxStats.PHY, 395, 155, 0xAAA8C7A3);
				renderer.drawText("AGI: " + adventurer.maxStats.AGI, 395, 165, 0xAAA8C7A3);
				renderer.drawText("MAG: " + adventurer.maxStats.MAG, 395, 175, 0xAAA8C7A3);
				renderer.drawText("DEX: " + adventurer.maxStats.DEX, 395, 185, 0xAAA8C7A3);
				renderer.drawText("INT: " + adventurer.maxStats.INT, 395, 195, 0xAAA8C7A3);
				renderer.drawText("PRC: " + adventurer.maxStats.PRC, 395, 205, 0xAAA8C7A3);
			renderer.drawRectOpaque(170, 250, 300, 70, 0x20273456);
				renderer.drawText(firstLine, 175, 260, 0xAAA8C7A3);
				renderer.drawText(secondLine, 175, 275, 0xAAA8C7A3);
				renderer.drawText(thirdLine, 175, 290, 0xAAA8C7A3);

			
			if(textFinished) {
				if(hovering) { renderer.drawRectOpaque(400, 330, 70, 20, 0x44345627); }
				else { renderer.drawRectOpaque(400, 330, 70, 20, 0x20345627); }
				renderer.drawText("Fare thee well!", 405, 335, 0xAA99C7A3);
			}

			
			break;
		
		case Combat: break;
		case InTown: break;
		case PartyScreen: break;
		case QuestUI: break;
		case Titlescreen: break;
		case Transition: break;
		case WorldMap: break;
		default: break;
		
		}		
	}
	
	
	private String createGoodByeText() {
		
		int roll = random.nextInt(2);
		
		switch(roll) {
		
		case 0: return "I have decided that thine company no longer satisfies my ambitions, and must leave";
		//case 1: return "It seems that thou needst my help no more. Goodbye.";
		
		default: return "I have decided that thine company no longer satisfies my ambitions, and must leave thee behind. It is not sad, it is just as it is.";
		}
				
	}
	
	
	


}
