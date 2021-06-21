package com.redhaan.adventurersGalore.entity.town.building.blacksmith.scrappingScreen;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.town.building.blacksmith.BlackSmith;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class ScrappingScreen extends GameObject {
	
	private static final long serialVersionUID = 1L;
	
	private SwordSubScreen swordsSubScreen;
	private DaggerSubScreen daggerSubScreen;
	private StaffSubScreen staffSubScreen;
	private SpearSubScreen spearSubScreen;
	private BowSubScreen bowSubScreen;
	private ArmourSubScreen armourSubscreen;
	
	public static boolean initialised;
	
	public ScrappingScreen() {
		
		swordsSubScreen = new SwordSubScreen();
		daggerSubScreen = new DaggerSubScreen();
		staffSubScreen = new StaffSubScreen();
		spearSubScreen = new SpearSubScreen();
		bowSubScreen = new BowSubScreen();
		armourSubscreen = new ArmourSubScreen();
		
		initialised = false;
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		if (!initialised) {
			swordsSubScreen.initialise();
			daggerSubScreen.initialise();
			staffSubScreen.initialise();
			spearSubScreen.initialise();
			bowSubScreen.initialise();
			armourSubscreen.initialise();
			initialised = true;
		}

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
		
		renderer.drawRect(495, 25, 50, 100, 0xff88AA22);
		
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
