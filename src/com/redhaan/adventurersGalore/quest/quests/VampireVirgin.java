package com.redhaan.adventurersGalore.quest.quests;

import com.redhaan.adventurersGalore.quest.Quest;
import com.redhaan.adventurersGalore.quest.quests.fetchQuest.GoGetMyTrinket;

import gameEngine.ecclesiastes.GameContainer;

public class VampireVirgin extends Quest {
	
	public VampireVirgin() {

		maxPartySize = 4;
		questSteps.add(new GoGetMyTrinket(requester));
		
	}
	
	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
	}
	
	

}
