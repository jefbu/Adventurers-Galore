package com.redhaan.adventurersGalore.combat;

import java.util.ArrayList;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.combat.combatAI.CombatStrategies;
import com.redhaan.adventurersGalore.combat.combatAI.StrategyDecision;
import com.redhaan.adventurersGalore.entity.Monster;
import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;
import com.redhaan.adventurersGalore.worldMap.LevelDrawer;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.Image;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class Combat extends GameObject {
	
	public static Image combatMap;
	public static ArrayList<Monster> enemies;
	
	private LevelDrawer levelDrawer;

	private boolean deployment;
	
	public static CombatState combatState;
	public static CombatStrategies combatStrategy;
	
	private int activeEnemy;
	
	public Combat() {
		
		levelDrawer = new LevelDrawer();
		deployment = false;
		enemies = new ArrayList<Monster>();
		enemies.add(new Monster());
		enemies.add(new Monster());
		enemies.get(0).icon = new ImageTile("/spriteSheets/Bandit.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE);
		enemies.get(1).icon = new ImageTile("/spriteSheets/Bandit.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE);
		enemies.get(0).currentStats.move = 3;
		enemies.get(1).currentStats.move = 7;

		
		combatState = CombatState.PlayerTurn;
		combatStrategy = CombatStrategies.Defend;

		activeEnemy = 0;
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		switch(GameManager.gameState) {
		case Combat:
			if(!deployment) {
				Deployer.deploy();
				deployment = true;
			}
			
			switch(Combat.combatState) {
			
			case PlayerTurn:
			
				boolean continuePlayerTurn = false;
				for (Adventurer adventurer: GameManager.adventurers.allAdventurers) {
					if(adventurer.inParty) {
						if(!adventurer.isDead()) {
							adventurer.update(gameContainer, deltaTime);
							if(!adventurer.turnPassed) {
								continuePlayerTurn = true;
							}
						}
					}
				}
				if(!continuePlayerTurn) { 
					for (Monster enemy: enemies) {
						enemy.turnPassed = false;
					}
					Combat.combatState = CombatState.EnemyTurn;			
					}
			break;
			
			case EnemyTurn:
				
				if(activeEnemy >= enemies.size()) { 
					for(Adventurer adventurer: GameManager.adventurers.allAdventurers) {
						if(adventurer.inParty) {
							adventurer.turnPassed = false;
							adventurer.moving = false;
							adventurer.leftClickSituation = PlayerTurnLeftClickSituations.NothingToDo;
						}
					}
				activeEnemy = 0;
				Combat.combatState = CombatState.PlayerTurn; 
					}
				else {
					combatStrategy = StrategyDecision.decideCombatStrategy();
	
					enemies.get(activeEnemy).update(gameContainer, deltaTime);
					if(enemies.get(activeEnemy).turnPassed) {
						activeEnemy++;
					}
				}
			break;
			
			}	
			
		case InTown: break;
		case Titlescreen: break;
		case WorldMap: break;
		
		}
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		switch(GameManager.gameState) {
		
		case Combat:
			levelDrawer.drawLevel(renderer, combatMap, 0, 0);
			
			for(Adventurer adventurer: GameManager.adventurers.allAdventurers) {
				if(adventurer.inParty) {
					if(!adventurer.isDead()) {
						adventurer.render(gameContainer, renderer);
					}
				}
			}
			
			for (Monster enemy: enemies) {
				if(!enemy.isDead()) {
				enemy.render(gameContainer, renderer);
				}
			}
			break;
			
			
			
		case InTown: break;
		case Titlescreen: break;
		case WorldMap: break;
		
		}
		
	}

}
