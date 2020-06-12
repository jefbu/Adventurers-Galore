package com.redhaan.adventurersGalore;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class Transition extends GameObject {
	
	private int width, height;
	public static GameState nextGameState;
	private boolean increasing;
	
	public Transition() {
		
		width = 0;
		height = 0;
		nextGameState = GameState.WorldMap;
		increasing = true;
		
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

			renderer.drawRectOpaque(0, 0, width, GameManager.GAMEHEIGHT, 0xff181309);
			renderer.drawRectOpaque(GameManager.GAMEWIDTH - width, 0, width, GameManager.GAMEHEIGHT, 0xff091318);
			renderer.drawRectOpaque(0, 0, GameManager.GAMEWIDTH, height, 0xff130918);
			renderer.drawRectOpaque(0, GameManager.GAMEHEIGHT - height, GameManager.GAMEWIDTH, height, 0xff151515);
			
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
