package com.redhaan.adventurersGalore.entity.town.building.blacksmith.craftingScreen;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.town.building.blacksmith.BlackSmith;
import com.redhaan.adventurersGalore.entity.town.building.blacksmith.craftingScreen.daggerSubscreen.DaggerSubScreen;
import com.redhaan.adventurersGalore.entity.town.building.blacksmith.craftingScreen.swordSubscreen.SwordsSubScreen;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class CraftingScreen extends GameObject {

	private static final long serialVersionUID = 1L;
	
	private int tierNr;
	
	private SwordsSubScreen swordsSubScreen;
	private DaggerSubScreen daggerSubScreen;
	
	public CraftingScreen() {
		
		tierNr = 1;
		
		swordsSubScreen = new SwordsSubScreen();
		daggerSubScreen = new DaggerSubScreen();
		
	}
		
	
	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
			
			switch(BlackSmith.equipTypeOption) {
			
			case 0: swordsSubScreen.update(gameContainer, deltaTime); break;
			case 1: daggerSubScreen.update(gameContainer, deltaTime); break;
			case 2: System.out.println("staves"); break;
			case 3: System.out.println("armour"); break;
			
			
			}
			
		
	}

	
	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		switch(BlackSmith.equipTypeOption) {
		
		case 0: swordsSubScreen.render(gameContainer, renderer); break;
		case 1: daggerSubScreen.render(gameContainer, renderer); break;
		
		}		
		
	}
	

}
