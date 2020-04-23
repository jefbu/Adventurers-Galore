package com.redhaan.adventurersGalore.quest;

import java.util.ArrayList;

import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;
import com.redhaan.adventurersGalore.entity.adventurer.adventurerFactory.AdventurerFactory;

public class Quest {
	
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

	public void update() { }


}
