package com.redhaan.adventurersGalore.quest.quests.fetchQuest;

import com.redhaan.adventurersGalore.quest.Quest;
import com.redhaan.adventurersGalore.quest.QuestStep;

public class ItIsNotHere extends QuestStep {
	
	public ItIsNotHere() {
		
	}
	
	@Override
	public void update(Quest quest) {
		
		System.out.println("It Is Not Here");
		quest.questStepNumber++;
		
	}
	

}
