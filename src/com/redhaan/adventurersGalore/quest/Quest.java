package com.redhaan.adventurersGalore.quest;

import java.util.ArrayList;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;
import com.redhaan.adventurersGalore.entity.adventurer.adventurerFactory.AdventurerFactory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class Quest extends GameObject {
	
	public ArrayList<QuestStep> questSteps;
	public Adventurer questRequester;
	private AdventurerFactory adventurerFactory;
	public int questStepNumber;
	
	public Quest() {
		
		questSteps = new ArrayList<QuestStep>();
		adventurerFactory = new AdventurerFactory();
		questRequester = adventurerFactory.createTieredAdventurer(0);
		questStepNumber = 0;
		
	}


	@Override
	public void update(GameContainer gameContainer, float deltaTime) {		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {		
	}


}
