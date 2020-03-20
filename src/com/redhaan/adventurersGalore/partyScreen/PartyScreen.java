package com.redhaan.adventurersGalore.partyScreen;

import java.awt.Color;

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
	private TotemWidget totemWidget;
	
	public PartyScreen() {
		
		member = 0;
		bgColour = 0xffBBBBAA;
		portrait = new PortraitWidget(15, 15, 60, 100);
		basicInfo = new BasicInfoWidget(77, 15, 103, 100);
		weapon = new WeaponWidget(185, 15, 208, 100);
		armourImage = new ArmourWidget(395, 15, 60, 100);
		statsInfo = new StatsWidget(15, 120, 165, 280);
		tattooWidget = new TattooWidget(185, 120, 270, 80);
		affinityWidget = new AffinityWidget(185, 202, 270, 80);
		skillWidget = new SkillWidget(185, 284, 270, 116);
		optionsWidget = new OptionsWidget(460, 15, 165, 267);
		commentWidget = new CommentWidget(15, 405, 610, 60);
		totemWidget = new TotemWidget(460, 284, 165, 116 );
		
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
			totemWidget.update(gameContainer, deltaTime);
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
			totemWidget.render(gameContainer, renderer);
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
		int red = 200 - (finalTrust / 2);
		int green = 150 + (finalTrust / 2);
		int blue = 0;
		if (green > red) { blue = 175; }
		else { blue = 150; }
		Color tmpColor = new Color (red, green, blue);
		bgColour = tmpColor.getRGB();
		
		
	}

}
