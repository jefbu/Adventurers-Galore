package com.redhaan.adventurersGalore.entity;

import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class TreasureChest extends Monster {

	private static final long serialVersionUID = 1L;
	public static ImageTile icon = new ImageTile("/generic_icons.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE);
	public boolean collected;
	private Random random;
	
	public TreasureChest() {
		
		collected = false;
		random = new Random();
		
	}
	
	
	@Override 
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		if(!collected) {
		renderer.drawImageTile(icon, getCombatX() * GameManager.GAMETILESIZE, getCombatY() * GameManager.GAMETILESIZE, 0, 3);
		}
	
	}
	
	
	
	public boolean trapDisarmed(Adventurer adventurer) {
		
		int bonus = 0;
		if(adventurer.skills.lockpick.activeSkill) {
			switch(adventurer.skills.lockpick.value) {
			case 0: if(random.nextBoolean()) { bonus = 10; } else { bonus = -5; } break;
			case 1: bonus = 5;
			case 2: bonus = 10;
			case 3: bonus = 20;
			case 4: bonus = 30;
			case 5: bonus = 50;
			}
		}
		
		if (random.nextInt(100) + 1 + bonus > 70) { return true; }
		else { return false; }
		
	}
	
	

}
