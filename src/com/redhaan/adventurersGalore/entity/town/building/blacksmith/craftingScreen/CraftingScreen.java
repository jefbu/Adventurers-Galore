package com.redhaan.adventurersGalore.entity.town.building.blacksmith.craftingScreen;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.town.building.blacksmith.BlackSmith;
import com.redhaan.adventurersGalore.entity.town.building.blacksmith.craftingScreen.armourSubscreen.ArmourSubscreen;
import com.redhaan.adventurersGalore.entity.town.building.blacksmith.craftingScreen.bowSubscreen.BowSubScreen;
import com.redhaan.adventurersGalore.entity.town.building.blacksmith.craftingScreen.daggerSubscreen.DaggerSubScreen;
import com.redhaan.adventurersGalore.entity.town.building.blacksmith.craftingScreen.spearSubscreen.SpearSubScreen;
import com.redhaan.adventurersGalore.entity.town.building.blacksmith.craftingScreen.staffSubscreen.StaffSubScreen;
import com.redhaan.adventurersGalore.entity.town.building.blacksmith.craftingScreen.swordSubscreen.SwordsSubScreen;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class CraftingScreen extends GameObject {

	private static final long serialVersionUID = 1L;
	
	
	private SwordsSubScreen swordsSubScreen;
	private DaggerSubScreen daggerSubScreen;
	private StaffSubScreen staffSubScreen;
	private SpearSubScreen spearSubScreen;
	private BowSubScreen bowSubScreen;
	private ArmourSubscreen	armourSubscreen;
	
	public CraftingScreen() {
				
		swordsSubScreen = new SwordsSubScreen();
		daggerSubScreen = new DaggerSubScreen();
		staffSubScreen = new StaffSubScreen();
		spearSubScreen = new SpearSubScreen();
		bowSubScreen = new BowSubScreen();
		armourSubscreen = new ArmourSubscreen();
		
	}
		
	
	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
			
			switch(BlackSmith.equipTypeOption) {
			
			case 0: swordsSubScreen.update(gameContainer, deltaTime); break;
			case 1: daggerSubScreen.update(gameContainer, deltaTime); break;
			case 2: staffSubScreen.update(gameContainer, deltaTime); break;
			case 3: spearSubScreen.update(gameContainer, deltaTime); break;
			case 4: bowSubScreen.update(gameContainer, deltaTime); break;
			case 5: armourSubscreen.update(gameContainer, deltaTime); break;
						
			}
			
		
	}

	
	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		switch(BlackSmith.equipTypeOption) {
		
		case 0: swordsSubScreen.render(gameContainer, renderer); break;
		case 1: daggerSubScreen.render(gameContainer, renderer); break;
		case 2: staffSubScreen.render(gameContainer, renderer); break;
		case 3: spearSubScreen.render(gameContainer, renderer); break;
		case 4: bowSubScreen.render(gameContainer, renderer); break;
		case 5: armourSubscreen.render(gameContainer, renderer); break;
		
		}		
		
	}
	

}
