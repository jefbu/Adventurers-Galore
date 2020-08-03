package com.redhaan.adventurersGalore.quest.quests.fetchQuest;

import com.redhaan.adventurersGalore.quest.Quest;

import gameEngine.ecclesiastes.GameContainer;

public class FetchQuest extends Quest {

	private static final long serialVersionUID = 1L;


	public FetchQuest() {
		
		maxPartySize = 20;
		questSteps.add(new GoGetMyTrinket(requester));
		title = "Fetch";
		
	}
	
	
	@Override
	public void update(GameContainer gameContainer, float deltaTime) {	
		questSteps.get(questStepNumber).update(gameContainer, this);		
	}

}
