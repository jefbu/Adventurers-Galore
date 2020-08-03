package com.redhaan.adventurersGalore.combat;

import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class PowAnimation extends GameObject {

	private static final long serialVersionUID = 1L;
	private float timer;
	public static boolean activated;
	public static int x, y;
	private ImageTile image;
	private int yNumber;
	private Random random;
	
	public PowAnimation() {
		
		timer = 0;
		x = 0;
		y = 0;
		yNumber = 0;
		activated = false;
		image = new ImageTile("/pow.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE);
		random = new Random();
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		switch(GameManager.gameState) {
		
		case Combat:
			timer += (deltaTime * 3);
			if(timer > 4 ) {
				timer = 0;
				activated = false;
				yNumber = random.nextInt(3);
			}	
			break;
			
		case InTown: break;
		case PartyScreen: break;
		case Titlescreen: break;
		case WorldMap: break;
		case QuestUI: break;
		case Transition: break;
		case QuestScreen: break;
		case PartyCohesionCheckerUI: break;
		
		}			
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		switch(GameManager.gameState) {
		
		case Combat:
		if(activated) {	
			renderer.drawImageTile(image, x * GameManager.GAMETILESIZE, y * GameManager.GAMETILESIZE, (int)timer, yNumber);
		}
			break;			
			
		case InTown: break;
		case PartyScreen:break;
		case Titlescreen: break;
		case WorldMap: break;
		case QuestUI: break;
		case Transition: break;
		case QuestScreen: break;
		case PartyCohesionCheckerUI: break;
		
		
		}
		
		
	}

}
