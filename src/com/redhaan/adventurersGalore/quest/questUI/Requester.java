package com.redhaan.adventurersGalore.quest.questUI;

import com.redhaan.adventurersGalore.GameObject;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class Requester extends GameObject {
		
	public Requester() {
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		renderer.drawText("Quest Requested By", 470, 50, 0xff996644);
		renderer.drawText(QuestUI.quest.requester.name, 470, 65, 0xff996644);
		renderer.drawImageTile(QuestUI.quest.requester.job.icon, 470, 85, 0, 0);
		
		renderer.drawText("Level: " + Integer.toString(QuestUI.quest.requester.getLevel()), 470, 120, 0xff996644);
		renderer.drawText(QuestUI.quest.requester.job.name, 470, 135, 0xff996644);
		renderer.drawText(QuestUI.quest.requester.race.name, 470, 150, 0xff996644);
		
	}
	
	

}
