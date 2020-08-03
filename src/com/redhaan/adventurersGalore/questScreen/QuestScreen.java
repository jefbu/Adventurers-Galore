package com.redhaan.adventurersGalore.questScreen;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.GameState;
import com.redhaan.adventurersGalore.Transition;
import com.redhaan.adventurersGalore.quest.Quest;
import com.redhaan.adventurersGalore.quest.Quests;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class QuestScreen extends GameObject {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Quest> playerQuests;
	private boolean initiated;
	private int[] colours;
	
	private ImageTile image;
	
	private boolean hover;
	
	
	public QuestScreen() {
		
		playerQuests = new ArrayList<Quest>();
		initiated = false;
		image = new ImageTile("/icons.png", GameManager.GAMETILESIZE / 2, GameManager.GAMETILESIZE / 2);
		hover = false;
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		switch(GameManager.gameState) {

		case WorldMap:
			
			if(gameContainer.getInput().isKeyUp(KeyEvent.VK_Q)) {
				Transition.nextGameState = GameState.QuestScreen;
				GameManager.gameState = GameState.Transition;
			}
			
			if(gameContainer.getInput().getMouseX() > 5 && gameContainer.getInput().getMouseX() < 81 &&
					gameContainer.getInput().getMouseY() > 455 && gameContainer.getInput().getMouseY() < 481) {
					
				if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
					Transition.nextGameState = GameState.QuestScreen;
					GameManager.gameState = GameState.Transition;
				} else { hover = true; }
			} else { hover = false; }
			
			
			
		break;
		
		case QuestScreen:
			
			if(!initiated) {
				
				ArrayList<Quest> tempQuests = new ArrayList<Quest>();
				for (int i = 0; i < Quests.allQuests.size(); i++) {
					if (Quests.allQuests.get(i).playerQuest) { tempQuests.add(Quests.allQuests.get(i)); }
				}
				playerQuests = tempQuests;
				colours = new int[playerQuests.size()];
				for (int i = 0; i < colours.length; i++) {
					colours[i] = getRandomColour();
				}
				
				initiated = true;

				
			} else {			
			
			
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				if(gameContainer.getInput().getMouseX() > 560 && gameContainer.getInput().getMouseX() < 621 &&
						gameContainer.getInput().getMouseY() > 430 && gameContainer.getInput().getMouseY() < 451) {
					initiated = false;
					Transition.nextGameState = GameState.WorldMap;
					GameManager.gameState = GameState.Transition;
				}
			}
			
			if(gameContainer.getInput().isKeyUp(KeyEvent.VK_C)) {
				initiated = false;
				Transition.nextGameState = GameState.WorldMap;
				GameManager.gameState = GameState.Transition;				
			}
			
			}
			
		
		break;
		
		

		case InTown: break;
			
		case Combat: break;
		case Transition: break;
		case Titlescreen: break;
		case QuestUI: break;
		case PartyScreen: break;
		case PartyCohesionCheckerUI: break;
		default: break;
		
		}
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		switch(GameManager.gameState) {
		
		case QuestScreen:
			
			renderer.drawRectOpaque(10, 10, 620, 460, 0xff211719);
			
			for (int i = 0; i < playerQuests.size(); i++) {
				
				renderer.drawRectOpaque(20, 20 + i * 60, 600, 50, colours[i]);
				renderer.drawImageTile(playerQuests.get(i).requester.icon, 25, 20 + i * 60 + 15, 0, 0);
				renderer.drawText(playerQuests.get(i).requester.name + " has implored thine help in a " + playerQuests.get(i).title + " Quest", 75, 30 + i * 60 + 25, 0xff86A193);
				
			}
			
			
			
			
			renderer.drawRectOpaque(560, 430, 60, 20, 0xff264133);
			renderer.drawText("(C)lose", 570, 435, 0xff86A193);
		
		break;
		
		
		case WorldMap: 
			if(hover) { renderer.drawRect(4, 454, 77, 21, 0x88FFFFFF); }
			renderer.drawRectOpaque(5, 455, 75, 19, 0x22FFFFFF);
			renderer.drawImageTile(image, 10, 457, 1, 0);			
			renderer.drawText("(Q)uests", 30, 461, 0xff000000);
			break;
		case InTown: break;			
		case Combat: break;
		case Transition: break;
		case Titlescreen: break;
		case QuestUI: break;
		case PartyScreen: break;
		case PartyCohesionCheckerUI: break;
		default: break;
		
		
		}
		
	}
	
	
	
	private int getRandomColour() {
		
		Random random = new Random();
		int roll = random.nextInt(7);
		
		switch(roll) {
		
		case 0: return 0xff312428;
		case 1: return 0xff312824;
		case 2: return 0xff282431;
		case 3: return 0xff283124;
		case 4: return 0xff242831;
		case 5: return 0xff243128;
		case 6: return 0xff282828;
		default: return 0xffFFFFFF;
		
		}
		
		
	}
	
	
	
	

}
