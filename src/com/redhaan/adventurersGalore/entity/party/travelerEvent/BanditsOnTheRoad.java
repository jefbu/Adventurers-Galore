package com.redhaan.adventurersGalore.entity.party.travelerEvent;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameState;
import com.redhaan.adventurersGalore.combat.Combat;
import com.redhaan.adventurersGalore.combat.CombatMapRoller;
import com.redhaan.adventurersGalore.combat.CombatPhase;
import com.redhaan.adventurersGalore.combat.combatAI.HighLevelPlan;
import com.redhaan.adventurersGalore.entity.Monster;
import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;
import com.redhaan.adventurersGalore.worldMap.WorldMap;
import com.redhaan.adventurersGalore.worldMap.WorldMapTiles;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class BanditsOnTheRoad extends TravelerEvent {
	
	
	String stage1Text;
	String optionAConclusion;
	String optionAText;
	String optionBText;
	String optionCText;
	String optionDText;
	
	public BanditsOnTheRoad() {
		
		optionAText = "Give in";
		optionBText = "Compromise";
		optionCText = "Refuse";
		optionDText = "Trickery!";
		
		stage1Text = "The weather was pleasantly mild for a change. "
				+ "The entire day had passed smoothly, the party travelling in silence but with spirits high. "
				+ "Until of course a cluster of bandits appeared out of nowhere. "
				+ "Stand and deliver, the ringleader announces! "; 
		
		optionAConclusion = "Cowering and with a many a trousers asoiled; you hand over your money";
	
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		if(optionA) {
			optionA = false;
			for(Adventurer adventurer: GameManager.adventurers.allAdventurers) {
				if(adventurer.inParty) {
				adventurer.setMoney (adventurer.getMoney() / 2);
				}
			}
			WorldMap.subState = WorldMap.previousSubState;
			GameManager.gameState = GameState.WorldMap;

		}
		
		if(optionC) {
			optionC = false;
			Combat.combatMap = CombatMapRoller.rollCombatMap(WorldMapTiles.GRASS);
			WorldMap.subState = WorldMap.previousSubState;
			
			Combat.enemies.add(new Monster());
			Combat.enemies.add(new Monster());
			Combat.enemies.get(0).icon = new ImageTile("/Monsters.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE);
			Combat.enemies.get(1).icon = new ImageTile("/Monsters.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE);
			Combat.enemies.get(0).currentStats.move = 3;
			Combat.enemies.get(1).currentStats.move = 7;
			Combat.enemies.get(0).currentStats.attack = 40;
			Combat.enemies.get(1).currentStats.attack = 140;
			
			Combat.highLevelPlan = HighLevelPlan.Attack;
			Combat.combatPhase = CombatPhase.Setup;
			GameManager.gameState = GameState.Combat;
		}
		
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		writeOptionTexts(optionAText, optionBText, optionCText, optionDText, renderer);
		writeText(stage1Text, renderer);

	}

}
