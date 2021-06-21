package com.redhaan.adventurersGalore.entity.adventurer;

import java.util.ArrayList;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.adventurer.adventurerFactory.AdventurerFactory;
import com.redhaan.adventurersGalore.entity.adventurer.player.Player;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class Adventurers extends GameObject {

	private static final long serialVersionUID = 1L;
	public ArrayList<Adventurer> allAdventurers;
	private AdventurerFactory adventurerFactory;
	
	public Adventurers() {
		
		super();
		allAdventurers = new ArrayList<Adventurer>();
		adventurerFactory = new AdventurerFactory();
		
		Player player = new Player();
		allAdventurers.add(player);
		
		for (int i = 0; i < 8; i++) {
			allAdventurers.add(adventurerFactory.createRandomAdventurer());
		}
		
		allAdventurers.get(0).inParty = true;
		allAdventurers.get(1).inParty = true;
		allAdventurers.get(2).inParty = true;
		allAdventurers.get(3).inParty = true;
		//allAdventurers.get(4).inParty = true;
		//allAdventurers.get(5).inParty = true;
		//allAdventurers.get(6).inParty = true;
		//allAdventurers.get(7).inParty = true;
		//allAdventurers.get(8).inParty = true;
		//allAdventurers.get(9).inParty = true;
		
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
