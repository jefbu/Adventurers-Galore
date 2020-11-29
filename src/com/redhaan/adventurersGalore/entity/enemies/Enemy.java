package com.redhaan.adventurersGalore.entity.enemies;

import java.util.ArrayList;
import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.combat.Combat;
import com.redhaan.adventurersGalore.combat.MoveAreaDrawer;
import com.redhaan.adventurersGalore.combat.MoveRangeFiller;
import com.redhaan.adventurersGalore.combat.combatAI.ActionDecision;
import com.redhaan.adventurersGalore.combat.combatAI.AttackDecision;
import com.redhaan.adventurersGalore.combat.combatAI.CombatActions;
import com.redhaan.adventurersGalore.combat.combatAI.MoveDecision;
import com.redhaan.adventurersGalore.entity.Monster;
import com.redhaan.adventurersGalore.entity.combatAddOns.HealthBar;
import com.redhaan.adventurersGalore.entity.item.Item;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class Enemy extends Monster {
	
	Random random;
	public DropTable dropTable;
	public int row;

	private static final long serialVersionUID = 1L;

	public Enemy() {
		
		random = new Random();
		dropTable = new DropTable();
		icon = new ImageTile("/Monsters.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE);
		
	}
	
	
	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		switch(GameManager.gameState) {
		
		case Combat:
			
			switch(Combat.combatState) {
				
			case PlayerTurn: break;
			
			case EnemyTurn:
				
				if(dead) { turnPassed = true; }
				
				else {
					idleTimer += (deltaTime * idleAnimationSpeed);
					if(idleTimer > 4 ) {
						idleTimer = 0;
					}
					
					if(attackAnimation) {
						attackTimer +=(deltaTime * attackAnimationSpeed);
						if(attackTimer > 4) {
							attackTimer = 0;
							attackAnimation = false;
							turnPassed = true;
						}
					}
						
					if(moveRange.size() == 0) { moveRange = MoveRangeFiller.fillMoveRange(combatX, combatY, currentStats.move);}
		
					moveRangeCounter++;
					if (moveRangeCounter < 60) { moveRangeFlareUp = true; } 
					else { 
						moveRangeCounter = 0;
						moveRangeFlareUp = false;
					}
					
					if(!moveRangeFlareUp && moveRangeCounter == 0) {
						CombatActions action = ActionDecision.decideActionDecision(Combat.highLevelPlan);
						int[] moveDecision = MoveDecision.decideMoveDecision(action, moveRange, getCombatX(), getCombatY());
						combatX = moveDecision[0];
						combatY = moveDecision[1];
						AttackDecision.decideAttackDecision(this, getCombatX(), getCombatY());
						moveRange.clear();
						turnPassed = true;
					}
				}	
			break;
			}
			
		break;	
		case WorldMap: break;
		case Titlescreen: break;
		case InTown: break;
		case PartyScreen: break;
		case QuestUI: break;
		case Transition: break;
		case QuestScreen: break;
		case PartyCohesionCheckerUI: break;
		case Inventory: break;
		
		}
		
	}
	
	
	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		switch(GameManager.gameState) {
		
		case Combat:
			renderer.drawImageTile(icon, combatX * GameManager.GAMETILESIZE, combatY * GameManager.GAMETILESIZE, (int) idleTimer, row);
			HealthBar.drawHealthBar(this, renderer);
			
			if(moveRangeFlareUp) {
				MoveAreaDrawer.drawMoveArea(moveRange, renderer);
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
		case Inventory: break;
	
		}
				
	}
	
	
	public void rollLoot(ArrayList<Item> loot) {
		
		for (int i = 0; i < dropTable.itemDrops.size(); i++) {
			int roll = random.nextInt(10000) + 1;
			if (roll < dropTable.dropRates[i]) {
				for (int ii = 0; ii < dropTable.quantities[i]; ii++) {
					loot.add(dropTable.itemDrops.get(i));					
				}
			}
		}
		
		
	}
	
	public int rollGemStoneLevel(int cheap, int basic, int quality, int flawless) {
		
		if (cheap + basic + quality + flawless != 100) { System.out.println("error at rollGemStoneLevel"); return 0; }
		
		else {

			int roll = random.nextInt(100) + 1;
			
			if (roll < cheap) { return 1; }
			else if (roll < basic) { return 2; }
			else if (roll < quality) { return 3; }
			else { return 4; }
			
		}	
	}
}
