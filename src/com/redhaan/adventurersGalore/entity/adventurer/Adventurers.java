package com.redhaan.adventurersGalore.entity.adventurer;

import java.util.ArrayList;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.adventurer.adventurerFactory.AdventurerFactory;
import com.redhaan.adventurersGalore.entity.adventurer.player.Player;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class Adventurers extends GameObject {
	
	public ArrayList<Adventurer> allAdventurers;
	private AdventurerFactory adventurerFactory;
	
	public Adventurers() {
		
		super();
		allAdventurers = new ArrayList<Adventurer>();
		adventurerFactory = new AdventurerFactory();
		
		Player player = new Player();
		allAdventurers.add(player);
		
		for (int i = 0; i < 100; i++) {
			allAdventurers.add(adventurerFactory.createRandomAdventurer());
		}
		
		for (int i = 0; i < 50; i++) {
			allAdventurers.get(i).inParty = true;
		}
		
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		for (Adventurer adventurer: allAdventurers) {
			adventurer.update(gameContainer, deltaTime);
		}
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		for (Adventurer adventurer: allAdventurers) {
			adventurer.render(gameContainer, renderer);
		}		
	} 

}
