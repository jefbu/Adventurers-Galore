package com.redhaan.adventurersGalore.quest.quests.fetchQuest;

import com.redhaan.adventurersGalore.quest.Quest;
import com.redhaan.adventurersGalore.quest.QuestStep;

import gameEngine.ecclesiastes.GameContainer;

public class YouFoundIt extends QuestStep {

	public YouFoundIt() {
		
	}
	
	
	@Override
	public void update(GameContainer gameContainer, Quest quest) {
		
		System.out.println("You Found It");
		quest.questStepNumber = 0;
		
	}
	
	
}
