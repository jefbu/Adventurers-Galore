package com.redhaan.adventurersGalore.partyScreen;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.GameState;
import com.redhaan.adventurersGalore.Transition;
import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;
import com.redhaan.adventurersGalore.entity.adventurer.skills.Skill;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class PartyScreen extends GameObject {

	private static final long serialVersionUID = 1L;
	public static int member;
	private int bgColour;
	
	public static PartyScreenSubState subState;
	public static Skill skill;
	public static int skillNumber;
	
	private PortraitWidget portrait;
	private BasicInfoWidget basicInfo;
	private WeaponWidget weapon;
	private ArmourWidget armourImage;
	private StatsWidget statsInfo;
	private SigilWidget sigilWidget;
	private AffinityWidget affinityWidget;
	private SkillWidget skillWidget;
	private OptionsWidget optionsWidget;
	private CommentWidget commentWidget;
	private TattooWidget tattooWidget;
	
	private SkillChangeScreen skillChangeScreen;
	
	private ImageTile image;
	
	private boolean hover;
	
	public PartyScreen() {
		
		member = 0;
		bgColour = 0xffBBBBAA;
		
		subState = PartyScreenSubState.Main;
		
		portrait = new PortraitWidget(15, 15, 60, 100);
		basicInfo = new BasicInfoWidget(77, 15, 103, 100);
		weapon = new WeaponWidget(185, 15, 208, 100);
		armourImage = new ArmourWidget(395, 15, 60, 100);
		statsInfo = new StatsWidget(15, 120, 165, 290);
		sigilWidget = new SigilWidget(185, 120, 270, 80);
		affinityWidget = new AffinityWidget(185, 202, 270, 80);
		skillWidget = new SkillWidget(185, 284, 270, 126);
		optionsWidget = new OptionsWidget(460, 15, 165, 267);
		commentWidget = new CommentWidget(15, 415, 610, 50);
		tattooWidget = new TattooWidget(460, 284, 165, 126 );
		
		skillChangeScreen = new SkillChangeScreen(120, 100, 400, 280);
		image = new ImageTile("/icons.png", GameManager.GAMETILESIZE / 2, GameManager.GAMETILESIZE / 2);
		hover = false;
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		switch(GameManager.gameState) {
		
		case Combat: break;
		case InTown: break;
		case Titlescreen: break;
		case QuestUI: break;
		case Transition: break;
		case QuestScreen: break;
		case PartyCohesionCheckerUI: break;
		
		case PartyScreen:
			
			switch(subState) {
			
			case Main: 
				
				if (gameContainer.getInput().isKeyUp(KeyEvent.VK_L)) {
					GameManager.adventurers.allAdventurers.get(PartyScreen.member).levelUp();
				}
				
				calculateBGColour();
				
				portrait.update(gameContainer, deltaTime);
				basicInfo.update(gameContainer, deltaTime);
				statsInfo.update(gameContainer, deltaTime);
				weapon.update(gameContainer, deltaTime);
				armourImage.update(gameContainer, deltaTime);
				sigilWidget.update(gameContainer, deltaTime);
				affinityWidget.update(gameContainer, deltaTime);
				skillWidget.update(gameContainer, deltaTime);
				optionsWidget.update(gameContainer, deltaTime);
				commentWidget.update(gameContainer, deltaTime);
				tattooWidget.update(gameContainer, deltaTime);
				break;
			
			case SkillChange:
				
				skillChangeScreen.update(gameContainer, deltaTime);
				break;
			
			}
			
			break;
			
		case WorldMap: 

			if(gameContainer.getInput().getMouseX() > 85 && gameContainer.getInput().getMouseX() < 161 &&
					gameContainer.getInput().getMouseY() > 455 && gameContainer.getInput().getMouseY() < 481) {
			
				if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
					Transition.nextGameState = GameState.PartyScreen;
					GameManager.gameState = GameState.Transition;
				} else { hover = true; }
			
			} 
			
			else if(gameContainer.getInput().isKeyUp(KeyEvent.VK_P)) {
				Transition.nextGameState = GameState.PartyScreen;
				GameManager.gameState = GameState.Transition;
			}
			
			else { hover = false; }
			
			
			break;	
		
		}
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		switch(GameManager.gameState) {
		case Combat: break;
		case InTown: break;
		case Titlescreen: break;
		case QuestUI: break;
		case Transition: break;
		case QuestScreen: break;
		case PartyCohesionCheckerUI: break;
		
		case PartyScreen:
			renderer.drawRectOpaque(10, 10, 620, 460, bgColour);
			portrait.render(gameContainer, renderer);
			basicInfo.render(gameContainer, renderer);
			statsInfo.render(gameContainer, renderer);
			weapon.render(gameContainer, renderer);
			armourImage.render(gameContainer, renderer);
			sigilWidget.render(gameContainer, renderer);
			affinityWidget.render(gameContainer, renderer);
			skillWidget.render(gameContainer, renderer);
			optionsWidget.render(gameContainer, renderer);
			commentWidget.render(gameContainer, renderer);	
			tattooWidget.render(gameContainer, renderer);
			break;
		
		case WorldMap: 
			if(hover) { renderer.drawRect(84, 454, 77, 21, 0x88FFFFFF); }
			renderer.drawRectOpaque(85, 455, 75, 19, 0x22FFFFFF);
			renderer.drawImageTile(image, 90, 457, 1, 0);			
			renderer.drawText("(P)arty", 115, 461, 0xff000000);
			break;			
		}
		

		
		switch(subState) {
		
		case Main: break;
		
		case SkillChange:
			skillChangeScreen.render(gameContainer, renderer);
		
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
