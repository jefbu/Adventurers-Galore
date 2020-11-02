package com.redhaan.adventurersGalore.combat;

import java.util.ArrayList;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.combat.combatAI.HighLevelPlan;
import com.redhaan.adventurersGalore.entity.Monster;
import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;
import com.redhaan.adventurersGalore.entity.enemies.Enemy;
import com.redhaan.adventurersGalore.worldMap.LevelDrawer;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.audio.SoundClip;
import gameEngine.ecclesiastes.gfx.Image;

public class Combat extends GameObject {

	private static final long serialVersionUID = 1L;
	public static Image combatMap;
	public static ArrayList<Enemy> enemies;
	
	private LevelDrawer levelDrawer;
	
	public static CombatState combatState;
	public static HighLevelPlan highLevelPlan;
	public static CombatPhase combatPhase;
	
	private CombatConclusion combatConclusion;
	
	private int activeEnemy;
	
	public static SoundClip soundClip;
	public static boolean soundStarted;
	
	public Combat() {
		
		levelDrawer = new LevelDrawer();
		enemies = new ArrayList<Enemy>();

		
		combatState = CombatState.PlayerTurn;
		highLevelPlan = HighLevelPlan.Defend;
		combatPhase = CombatPhase.Setup;

		activeEnemy = 0;
		
		combatConclusion = new CombatConclusion();
		
		soundClip = new SoundClip("/battle.wav");
		soundStarted = false;
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		switch(GameManager.gameState) {
		case Combat:
			
			switch(combatPhase) {
			case Setup: CombatInitialiser.CombatInitialise(); break;
			case Conclusion: combatConclusion.update(gameContainer, deltaTime); break;
						
			case Combat:
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
					
					boolean endCombatVictorious = true;
					for (Monster enemy: enemies) {
						if(!enemy.isDead() ) { endCombatVictorious = false; }
					}
					
					if(endCombatVictorious) {
						combatConclusion.playerVictorious = true;
						Combat.combatPhase = CombatPhase.Conclusion; }
					
				break;
				
				case EnemyTurn:
					if(activeEnemy >= enemies.size()) { 
						for(Adventurer adventurer: GameManager.adventurers.allAdventurers) {
							if(!adventurer.isDead()) {
								if(adventurer.inParty) {
									adventurer.turnPassed = false;
									adventurer.selected = false;
									adventurer.hasMoved = false;
									adventurer.hasActed = false;
									//adventurer.moveRange.clear();
									//adventurer.leftClickSituation = PlayerTurnLeftClickSituations.NothingToDo;
								}
							}
						}
						activeEnemy = 0;
						Combat.combatState = CombatState.PlayerTurn; 
					}
					else {		
						enemies.get(activeEnemy).update(gameContainer, deltaTime);
						if(enemies.get(activeEnemy).turnPassed) {
							enemies.get(activeEnemy).turnPassed = false;
							activeEnemy++;
						}
					}
					
					boolean endCombatDefeated = true;
					for (Adventurer adventurer: GameManager.adventurers.allAdventurers) {
						if(adventurer.inParty) {
							if(!adventurer.isDead() ) { endCombatDefeated = false; }
						}
					}
					
					if(endCombatDefeated) {
						combatConclusion.playerVictorious = false;
						Combat.combatPhase = CombatPhase.Conclusion; }
					
					
				break;
				
				}
			break;
			}
			
			
		case InTown: break;
		case Titlescreen: break;
		case WorldMap: break;
		case PartyScreen: break;
		case QuestUI: break;
		case Transition: break;
		case QuestScreen: break;
		case PartyCohesionCheckerUI: break;
		
		}
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		switch(GameManager.gameState) {
		
		case Combat:
			
			switch(combatPhase) {
			
			case Combat:
				levelDrawer.drawLevel(renderer, combatMap, 0, 0, true);
				
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
				
			case Conclusion: combatConclusion.render(gameContainer, renderer); break;
			case Setup: break;			
			}

			break;
			
			
			
		case InTown: break;
		case Titlescreen: break;
		case WorldMap: break;
		case PartyScreen: break;
		case QuestUI: break;
		case Transition: break;
		case QuestScreen: break;
		case PartyCohesionCheckerUI: break;
		
		}
		
	}

}
