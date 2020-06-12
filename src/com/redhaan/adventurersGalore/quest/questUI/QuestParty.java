package com.redhaan.adventurersGalore.quest.questUI;

import com.redhaan.adventurersGalore.GameObject;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class QuestParty extends GameObject {
	
	public QuestParty() {
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		if(QuestUI.quest.questParty.size() > 0) {
		
			renderer.drawText("This quest is currently", 55, 50, 0xff996644);
			renderer.drawText("handled by: ", 55, 60, 0xff996644);

			for (int i = 0; i < QuestUI.quest.questParty.size(); i++) {

				renderer.drawText(QuestUI.quest.questParty.get(i).name, 55, (30 * i) + 80, 0xff996644);
				renderer.drawText("Level: " + Integer.toString(QuestUI.quest.questParty.get(i).getLevel()), 55, (30 * i) + 90, 0xff996644);
				renderer.drawText(QuestUI.quest.questParty.get(i).job.name, 55, (30 * i) + 100, 0xff996644);
				
			}
			
		}
		
		else {
			
			renderer.drawText("So far... ", 60, 50, 0xff996644);			
			renderer.drawText("No one is handling this!", 60, 60, 0xff996644);			
			
		}
		

		
		
	}

}
