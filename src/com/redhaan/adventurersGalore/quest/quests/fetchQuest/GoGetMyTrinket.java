package com.redhaan.adventurersGalore.quest.quests.fetchQuest;

import java.awt.event.KeyEvent;

import com.redhaan.adventurersGalore.quest.Quest;
import com.redhaan.adventurersGalore.quest.QuestLocationType;
import com.redhaan.adventurersGalore.quest.QuestStep;

import gameEngine.ecclesiastes.GameContainer;

public class GoGetMyTrinket extends QuestStep {
	
	public GoGetMyTrinket() {
		
		questLocationType = QuestLocationType.InTown;
		decideQuestStepLocation(questLocationType, this);
		System.out.println("Quest happens in: " + questLocationTown.name);
		
	}
	
	
	@Override
	public void update(GameContainer gameContainer, Quest quest) {
		
		System.out.println(quest);
		System.out.println("Go Get My Trinket!");
		//quest.questStepNumber++;
		
		if(gameContainer.getInput().isKeyUp(KeyEvent.VK_G)) {
			
		}
		
	}

}
