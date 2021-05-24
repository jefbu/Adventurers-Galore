package com.redhaan.adventurersGalore.quest;

import com.redhaan.adventurersGalore.quest.quests.fetchQuest.FetchQuest;

public abstract class QuestTable {
	
	public static Quest rollQuest(int roll) {
				
	switch(roll) {
		
		case 0: return new FetchQuest();
		//case 1: return new VampireVirgin();
		default: return new FetchQuest(); 
		
	}
}

}
