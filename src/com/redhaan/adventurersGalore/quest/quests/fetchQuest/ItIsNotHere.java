package com.redhaan.adventurersGalore.quest.quests.fetchQuest;

import com.redhaan.adventurersGalore.quest.Quest;
import com.redhaan.adventurersGalore.quest.QuestLocationType;
import com.redhaan.adventurersGalore.quest.QuestStep;

import gameEngine.ecclesiastes.GameContainer;

public class ItIsNotHere extends QuestStep {
	
	public ItIsNotHere() {
		
		questLocationType = QuestLocationType.InTown;
		decideQuestStepLocation(questLocationType, this);
		
	}
	
	@Override
	public void update(GameContainer gameContainer, Quest quest) {
		
		System.out.println("It Is Not Here");
		quest.questStepNumber++;
		
	}
	

}
