package com.redhaan.adventurersGalore.combat;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.GameState;
import com.redhaan.adventurersGalore.Toast;
import com.redhaan.adventurersGalore.Transition;
import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;
import com.redhaan.adventurersGalore.entity.adventurer.Job;
import com.redhaan.adventurersGalore.entity.adventurer.LevelUpRoller;
import com.redhaan.adventurersGalore.entity.adventurer.Stats;
import com.redhaan.adventurersGalore.entity.enemies.Enemy;
import com.redhaan.adventurersGalore.entity.item.Item;
import com.redhaan.adventurersGalore.entity.item.ItemID;
import com.redhaan.adventurersGalore.entity.item.armour.Armour;
import com.redhaan.adventurersGalore.entity.item.items.CraftItems;
import com.redhaan.adventurersGalore.entity.item.weapon.Weapon;
import com.redhaan.adventurersGalore.inventory.Inventory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.audio.SoundClip;

public class CombatConclusion extends GameObject {

	private static final long serialVersionUID = 1L;
	private Random random;
	public boolean playerVictorious;
	private boolean conclusionStarted;
	
	private ArrayList<String> strings;
	private ArrayList<Item> loot;
	
	private SoundClip victorySound;
	private SoundClip lossSound;
	
	private boolean closeHover;
	
	public CombatConclusion() {
		random = new Random();
		playerVictorious = false;
		conclusionStarted = false;
		strings = new ArrayList<String>();
		loot = new ArrayList<Item>();
		
		victorySound = new SoundClip("/victory.wav");
		lossSound = new SoundClip("/loss.wav");
		
		closeHover = false;
	}
	

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		if(Combat.dungeon) {
			for (int i = 0; i < GameManager.adventurers.allAdventurers.size(); i++) {
				if (GameManager.adventurers.allAdventurers.get(i).job == Job.summonedSkeleton) { GameManager.adventurers.allAdventurers.remove(i); }
			}
			Transition.nextGameState = GameState.WorldMap;
			GameManager.gameState = GameState.Transition;
			Toast.activate(false, "Kicked from Dungeon!", 265, 20);
		}
		
		else {
				
			if(!conclusionStarted) {
				
				Combat.soundClip.stop();
				Combat.soundStarted = false;
				
				for (int i = 0; i < GameManager.adventurers.allAdventurers.size(); i++) {
					if (GameManager.adventurers.allAdventurers.get(i).job == Job.summonedSkeleton) { GameManager.adventurers.allAdventurers.remove(i); i--; }
				}
				
				for (Adventurer adventurer: GameManager.adventurers.allAdventurers) {
					
					if(adventurer.inParty) {
						adventurer.battlesPassed++;
						adventurer.actingAnimation = false;
						adventurer.turnPassed = false;
						adventurer.selected = false;
						adventurer.hasMoved = false;
						adventurer.hasActed = false;
						adventurer.setDead(false);
						//adventurer.leftClickSituation = PlayerTurnLeftClickSituation.NothingToDo;
						adventurer.refreshStats();
	
					if(playerVictorious) {
						
						victorySound.play();
						
						int currentLevel = adventurer.getLevel();
						Stats currentStats = new Stats();
						currentStats.HP = adventurer.maxStats.HP;
						currentStats.MP = adventurer.maxStats.MP;
						currentStats.PHY = adventurer.maxStats.PHY;
						currentStats.AGI = adventurer.maxStats.AGI;
						currentStats.MAG = adventurer.maxStats.MAG;
						currentStats.DEX = adventurer.maxStats.DEX;
						currentStats.INT = adventurer.maxStats.INT;
						currentStats.PRC = adventurer.maxStats.PRC;
						currentStats.move = adventurer.maxStats.move;
	
						rollForLevelUp(adventurer);
						if (adventurer.getLevel() > currentLevel) {
							strings.add(adventurer.name + " has gained a level.");
							if(adventurer.maxStats.HP > currentStats.HP) { strings.add("HP increased"); }
							if(adventurer.maxStats.MP > currentStats.MP) { strings.add("MP increased"); }
							if(adventurer.maxStats.PHY > currentStats.PHY) { strings.add("PHY increased"); }
							if(adventurer.maxStats.AGI > currentStats.AGI) { strings.add("AGI increased"); }
							if(adventurer.maxStats.MAG > currentStats.MAG) { strings.add("MAG increased"); } 
							if(adventurer.maxStats.DEX > currentStats.DEX) { strings.add("DEX increased"); }
							if(adventurer.maxStats.INT > currentStats.INT) { strings.add("INT increased"); }
							if(adventurer.maxStats.PRC > currentStats.PRC) { strings.add("PRC increased"); }
							if(adventurer.maxStats.move > currentStats.move) { strings.add("move increased"); }
							strings.add("############");
						}
					}
					
					else { lossSound.play(); }
						
				}
				
			}
				
				if(playerVictorious) {
					for (Enemy enemy: Combat.enemies) {
						enemy.rollLoot(loot);
					}
					
					Inventory.update(loot);
				}
	
				
				CombatInitialiser.deployment = false;
				Combat.enemies.clear();
				Combat.activeEnemy = 0;
				Combat.combatState = CombatState.PlayerTurn;
	
				conclusionStarted = true;
				
			}
			
			if (gameContainer.getInput().getMouseX() > 550 && gameContainer.getInput().getMouseX() < 595 && 
					gameContainer.getInput().getMouseY() > 390 && gameContainer.getInput().getMouseY() < 410) {
				
				closeHover = true;
				if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
					strings.clear();
					loot.clear();
					conclusionStarted = false;
					Transition.nextGameState = GameState.WorldMap;
					GameManager.gameState = GameState.Transition;
				}
				
			} else { closeHover = false; }
			
		}
	}	
	


	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
			
		renderer.drawRectOpaque(10, 20, 600, 400, 0xff211814);
		
		renderer.drawRectOpaque(15, 25, 120, 250, 0xff141821);
		renderer.drawRectOpaque(15, 280, 120, 135, 0xff141821);
		renderer.drawRectOpaque(140, 25, 465, 390, 0xff141821);
		
		if(playerVictorious) {
			
			renderer.drawText("The Spoils of War: ", 20, 30, 0xff9191D8);
			
			int craftItems = 0;
			int equipment = 0;
			
			for (int i = 0; i < loot.size(); i++) {
				if (loot.get(i).ID != ItemID.Weapon && loot.get(i).ID != ItemID.Armour) {
					renderer.drawImageTile(CraftItems.icon, 20, 50 + craftItems * 20, loot.get(i).xTile, loot.get(i).yTile);
					renderer.drawText(loot.get(i).name, 40, 55 + craftItems * 20, 0xff545481);
					craftItems++;
				}
				else if (loot.get(i).ID == ItemID.Weapon) { 
					renderer.drawImageTile(Weapon.icon, 10, 285 + equipment * 32, loot.get(i).xTile, loot.get(i).yTile); 
					renderer.drawText(loot.get(i).name, 40, 295 + equipment * 32, 0xff545481);
					equipment++;
					}
				else if (loot.get(i).ID == ItemID.Armour) { 
					renderer.drawImageTile(Armour.icon, 10, 285 + equipment * 32, loot.get(i).xTile, loot.get(i).yTile); 
					renderer.drawText(loot.get(i).name, 40, 295 + equipment * 32, 0xff545481);
					equipment++;
					}
			}
			
		
			
			for (int i = 0; i < strings.size(); i++) {
				renderer.drawText(strings.get(i), 150, 50 + i * 20, 0xffCC8855);
			}
		
		}
		
		
		renderer.drawRectOpaque(550, 390, 50, 20, 0xff9191D8);
		renderer.drawText("Close", 565, 395, 0xff141821);
		if (closeHover) { renderer.drawRect(550, 390, 50, 20, 0xff91D891); }
		
	}
	
	
	
	private void rollForLevelUp(Adventurer adventurer) {
		
		int roll = random.nextInt(100) + 1;
		if (roll + adventurer.battlesPassed > adventurer.getLevel() * 5 + 5) {
			LevelUpRoller.levelUp(adventurer);
		}
		
	}
	

}
