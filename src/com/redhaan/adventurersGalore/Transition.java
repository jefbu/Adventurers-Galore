package com.redhaan.adventurersGalore;

import java.util.Random;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class Transition extends GameObject {
	
	private int width, height;
	public static GameState nextGameState;
	private boolean increasing;
	
	private int colour;
	private Random random;
	
	public Transition() {
		
		width = 0;
		height = 0;
		nextGameState = GameState.WorldMap;
		increasing = true;
		random = new Random();
		int roll = random.nextInt(7);
		switch (roll) {
		case 0: colour = 0xff161623; break;
		case 1: colour = 0xff162316; break;
		case 2: colour = 0xff231616; break;
		case 3: colour = 0xff232316; break;
		case 4: colour = 0xff231623; break;
		case 5: colour = 0xff162323; break;
		case 6: colour = 0xff232323; break;
		default: colour = 0xffEEEEEE; break;
		}
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		switch(GameManager.gameState) {
		
		case Transition:
			if(increasing) { 
				width = width + 40;
				height = height + 30;
				if(width > 320) { increasing = false; }
			}
			else { 
				width = width - 40;
				height = height - 30;
			}
			
			if(width < 1 && !increasing) {
				increasing = true;
				int roll = random.nextInt(7);
				switch (roll) {
				case 0: colour = 0xff161623; break;
				case 1: colour = 0xff162316; break;
				case 2: colour = 0xff231616; break;
				case 3: colour = 0xff232316; break;
				case 4: colour = 0xff231623; break;
				case 5: colour = 0xff162323; break;
				case 6: colour = 0xff232323; break;
				default: colour = 0xffEEEEEE; break;
				}
				GameManager.gameState = nextGameState;
			}
			
			break;
			
		case Combat: break;
		case InTown: break;
		case PartyScreen: break;
		case QuestUI: break;
		case Titlescreen: break;
		case WorldMap: break;
		default: break;
		
		}
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		switch(GameManager.gameState) {
		
		case Transition:

			renderer.drawRectOpaque(0, 0, width, GameManager.GAMEHEIGHT, colour);
			renderer.drawRectOpaque(GameManager.GAMEWIDTH - width, 0, width, GameManager.GAMEHEIGHT, colour);
			renderer.drawRectOpaque(0, 0, GameManager.GAMEWIDTH, height, colour);
			renderer.drawRectOpaque(0, GameManager.GAMEHEIGHT - height, GameManager.GAMEWIDTH, height, colour);
			
			break;
			
		case Combat: break;
		case InTown: break;
		case PartyScreen: break;
		case QuestUI: break;
		case Titlescreen: break;
		case WorldMap: break;
		default: break;
		
		}		
		
	}

}
