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
	private WeaponWidget weapon;
	private ArmourWidget armourImage;
	private StatsWidget statsInfo;
	private TattooWidget tattooWidget;
	private AffinityWidget affinityWidget;
	private SkillWidget skillWidget;
	private OptionsWidget optionsWidget;
	private CommentWidget commentWidget;
	
	public PartyScreen() {
		
		member = 0;
		bgColour = 0xffBBBBAA;
		portrait = new PortraitWidget(15, 15, 60, 100);
		basicInfo = new BasicInfoWidget(80, 15, 100, 100);
		weapon = new WeaponWidget(190, 15, 200, 100);
		armourImage = new ArmourWidget(395, 15, 60, 100);
		statsInfo = new StatsWidget(15, 125, 165, 280);
		tattooWidget = new TattooWidget(190, 125, 265, 80);
		affinityWidget = new AffinityWidget(190, 210, 265, 80);
		skillWidget = new SkillWidget(190, 295, 265, 110);
		optionsWidget = new OptionsWidget(465, 15, 160, 390);
		commentWidget = new CommentWidget(15, 415, 610, 45);
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		switch(GameManager.gameState) {
		
		case Combat: break;
		case InTown: break;
		case Titlescreen: break;
		case WorldMap: break;
		
		case PartyScreen:
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
			tattooWidget.update(gameContainer, deltaTime);
			affinityWidget.update(gameContainer, deltaTime);
			skillWidget.update(gameContainer, deltaTime);
			optionsWidget.update(gameContainer, deltaTime);
			commentWidget.update(gameContainer, deltaTime);
			break;
		
		}
		
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
			tattooWidget.render(gameContainer, renderer);
			affinityWidget.render(gameContainer, renderer);
			skillWidget.render(gameContainer, renderer);
			optionsWidget.render(gameContainer, renderer);
			commentWidget.render(gameContainer, renderer);			
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
		int red = 50 - (finalTrust / 2);
		int green = 0 + (finalTrust / 2);
		int blue = 15;
		Color tmpColor = new Color (red, green, blue);
		bgColour = tmpColor.getRGB();
		
		
	}

}
