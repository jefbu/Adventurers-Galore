package com.redhaan.adventurersGalore.quest;

import java.util.ArrayList;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;
import com.redhaan.adventurersGalore.entity.adventurer.adventurerFactory.AdventurerFactory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class Quest extends GameObject {
	
	public ArrayList<QuestStep> questSteps;
	public Adventurer requester;
	private AdventurerFactory adventurerFactory;
	public int questStepNumber;
	public int maxPartySize;
	public ArrayList<Adventurer> questParty;
	public boolean playerQuest;
	public String title;
	
	public Quest() {
		
		questSteps = new ArrayList<QuestStep>();
		adventurerFactory = new AdventurerFactory();
		requester = adventurerFactory.createTieredAdventurer(0);
		questStepNumber = 0;
		questParty = new ArrayList<Adventurer>();
		playerQuest = false;
		
	}


	@Override
	public void update(GameContainer gameContainer, float deltaTime) {		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {		
	}
	
	
	public void conclude() {
		
	}
	
	
	
}
