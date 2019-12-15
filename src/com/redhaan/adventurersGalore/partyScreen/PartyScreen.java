package com.redhaan.adventurersGalore.partyScreen;

import java.awt.Color;
import java.awt.event.KeyEvent;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class PartyScreen extends GameObject {
	
	protected static int member;
	private int bgColour;
	private PortraitWidget portrait;
	private BasicInfoWidget basicInfo;
	private StatsWidget statsInfo;
	private WeaponWidget weapon;
	private ArmourImageWidget armourImage;
	private AffinityWidget affinityWidget;
	private SkillWidget skillWidget;
	
	public PartyScreen() {
		
		member = 0;
		bgColour = 0xffBBBBAA;
		portrait = new PortraitWidget(15, 15, 60, 100);
		basicInfo = new BasicInfoWidget(80, 15, 100, 100);
		weapon = new WeaponWidget(190, 15, 100, 100);
		armourImage = new ArmourImageWidget();
		statsInfo = new StatsWidget();
		affinityWidget = new AffinityWidget();
		skillWidget = new SkillWidget();
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		calculateBGColour();
		
		if(gameContainer.getInput().isKeyUp(KeyEvent.VK_LEFT)) {
			if(member > 0) { member--; }
		}
		if(gameContainer.getInput().isKeyUp(KeyEvent.VK_RIGHT)) {
			if(member < GameManager.adventurers.allAdventurers.size() - 1) { member++; }
		}
		
		portrait.update(gameContainer, deltaTime);
		basicInfo.update(gameContainer, deltaTime);
		statsInfo.update(gameContainer, deltaTime);
		weapon.update(gameContainer, deltaTime);
		armourImage.update(gameContainer, deltaTime);
		affinityWidget.update(gameContainer, deltaTime);
		skillWidget.update(gameContainer, deltaTime);
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		switch(GameManager.gameState) {
		case Combat: break;
		case InTown: break;
		case Titlescreen: break;
		case WorldMap: break;		
		
		case PartyScreen:
			renderer.drawRectOpaque(10, 10, 620, 460, bgColour);
			portrait.render(gameContainer, renderer);
			basicInfo.render(gameContainer, renderer);
			statsInfo.render(gameContainer, renderer);
			weapon.render(gameContainer, renderer);
			armourImage.render(gameContainer, renderer);
			affinityWidget.render(gameContainer, renderer);
			skillWidget.render(gameContainer, renderer);
			
			break;
		
		}
		
	}
	
	private void calculateBGColour() {
		
		int totalTrust = 0;
		int partyMembers = 0;
		for (Adventurer adventurer: GameManager.adventurers.allAdventurers) {
			if(adventurer.inParty) {
				totalTrust += adventurer.currentStats.TST;
				partyMembers++;
			}
		}
		int finalTrust = totalTrust / partyMembers;
		int red = 40 - (finalTrust / 4);
		int green = 15 + (finalTrust / 4);
		int blue = 20;
		Color tmpColor = new Color (red, green, blue);
		bgColour = tmpColor.getRGB();
		
		
	}

}
