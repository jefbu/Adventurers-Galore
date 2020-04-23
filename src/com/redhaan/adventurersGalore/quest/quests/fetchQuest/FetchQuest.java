package com.redhaan.adventurersGalore.quest.quests.fetchQuest;

import com.redhaan.adventurersGalore.quest.Quest;

public class FetchQuest extends Quest {
	
	public FetchQuest() {
		
		questSteps.add(new GoGetMyTrinket());
		questSteps.add(new ItIsNotHere());
		questSteps.add(new YouFoundIt());
		
	}
	
	
	@Override
	public void update() {		
		questSteps.get(questStepNumber).update(this);		
	}

}
