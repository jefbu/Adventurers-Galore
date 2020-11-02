package com.redhaan.adventurersGalore.combat;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.GameState;
import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;
import com.redhaan.adventurersGalore.entity.adventurer.LevelUpRoller;
import com.redhaan.adventurersGalore.entity.adventurer.Stats;
import com.redhaan.adventurersGalore.entity.enemies.Enemy;
import com.redhaan.adventurersGalore.entity.item.Item;
import com.redhaan.adventurersGalore.inventory.Inventory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.audio.SoundClip;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class CombatConclusion extends GameObject {

	private static final long serialVersionUID = 1L;
	private Random random;
	public boolean playerVictorious;
	private boolean conclusionStarted;
	
	private ArrayList<ImageTile> icons;
	private ArrayList<String> strings;
	private ArrayList<Item> loot;
	
	private SoundClip victorySound;
	private SoundClip lossSound;
	
	public CombatConclusion() {
		random = new Random();
		playerVictorious = false;
		conclusionStarted = false;
		strings = new ArrayList<String>();
		icons = new ArrayList<ImageTile>();
		loot = new ArrayList<Item>();
		
		victorySound = new SoundClip("/victory.wav");
		lossSound = new SoundClip("/loss.wav");
	}
	

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		if(!conclusionStarted) {
			
			Combat.soundClip.stop();
			Combat.soundStarted = false;
			
			for (Adventurer adventurer: GameManager.adventurers.allAdventurers) {			
				if(adventurer.inParty) {
					adventurer.battlesPassed++;
					adventurer.attackAnimation = false;
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

			conclusionStarted = true;
			
		}
		
		if (gameContainer.getInput().getMouseX() > 500 && gameContainer.getInput().getMouseX() < 551 && 
				gameContainer.getInput().getMouseY() > 300 && gameContainer.getInput().getMouseY() < 321) {
			if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				strings.clear();
				loot.clear();
				conclusionStarted = false;
				GameManager.gameState = GameState.WorldMap;
			}
		}

		
	}	
	


	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		renderer.drawRectOpaque(10, 20, 600, 400, 0xff211814);
		
		renderer.drawRectOpaque(15, 25, 580, 120, 0xff141821);
		if(playerVictorious) {
			
			renderer.drawText("The Spoils of War: ", 20, 30, 0xff545481);
			for (int i = 0; i < loot.size(); i++) {
				renderer.drawText(loot.get(i).name, 20 + i * 50, 50, 0xff545481);
			}
	
			
			for (int i = 0; i < strings.size(); i++) {
				renderer.drawText(strings.get(i), 10, 200 + i * 15, 0xffCC8855);
			}
		
		}
		
		
		
		
		renderer.drawRectOpaque(530, 350, 50, 20, 0xff141824);
	
	}
	
	
	
	private void rollForLevelUp(Adventurer adventurer) {
		
		int roll = random.nextInt(100) + 1;
		if (roll + adventurer.battlesPassed > adventurer.getLevel() * 5 + 5) {
			LevelUpRoller.levelUp(adventurer);
		}
		
	}
	

}
