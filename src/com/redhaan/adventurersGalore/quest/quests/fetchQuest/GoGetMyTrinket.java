package com.redhaan.adventurersGalore.quest.quests.fetchQuest;

import com.redhaan.adventurersGalore.quest.Quest;
import com.redhaan.adventurersGalore.quest.QuestLocationType;
import com.redhaan.adventurersGalore.quest.QuestStep;

public class GoGetMyTrinket extends QuestStep {
	
	public GoGetMyTrinket() {
		
		questLocationType = QuestLocationType.InTown;
		decideInitialQuestStepLocation(questLocationType, this);
		System.out.println("Quest happens in: " + questLocationTown.name);
		
	}
	
	
	@Override
	public void update(Quest quest) {
		
		System.out.println(quest);
		System.out.println("Go Get My Trinket!");
		quest.questStepNumber++;
		
	}

}
