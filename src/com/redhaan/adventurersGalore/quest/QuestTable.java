package com.redhaan.adventurersGalore.quest;

import com.redhaan.adventurersGalore.quest.quests.VampireVirgin;
import com.redhaan.adventurersGalore.quest.quests.fetchQuest.FetchQuest;

public abstract class QuestTable {
	
	public static Quest rollQuest(int roll) {
		
	switch(roll) {
		
		case 0: return new VampireVirgin();
		case 1: return new FetchQuest();
		default: return new FetchQuest();
		
	}
}

}
