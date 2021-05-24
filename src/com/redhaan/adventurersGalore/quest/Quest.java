package com.redhaan.adventurersGalore.quest;

import java.util.ArrayList;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;
import com.redhaan.adventurersGalore.entity.adventurer.adventurerFactory.AdventurerFactory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class Quest extends GameObject {

	private static final long serialVersionUID = 1L;
	public ArrayList<QuestStep> questSteps;
	public Adventurer requester;
	private static AdventurerFactory adventurerFactory = new AdventurerFactory();
	public int questStepNumber;
	public int maxPartySize;
	public ArrayList<Adventurer> questParty;
	public boolean playerQuest;
	public String title;
	public int requesterGenderXOffset;
	public int requesterGenderYOffset;
	
	public Quest() {
		
		questSteps = new ArrayList<QuestStep>();
		requester = adventurerFactory.createTieredAdventurer(0);
		if (requester.gender == "male") { requesterGenderXOffset = 0; requesterGenderYOffset = 0; }
		else { requesterGenderXOffset = 4; requesterGenderYOffset = 4; }
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
