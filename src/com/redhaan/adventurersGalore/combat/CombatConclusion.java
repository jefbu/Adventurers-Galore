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

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class CombatConclusion extends GameObject {

	private static final long serialVersionUID = 1L;
	private Random random;
	public boolean playerVictorious;
	private boolean conclusionStarted;
	
	private ArrayList<ImageTile> icons;
	private ArrayList<String> strings;
	
	public CombatConclusion() {
		random = new Random();
		playerVictorious = false;
		conclusionStarted = false;
		strings = new ArrayList<String>();
		icons = new ArrayList<ImageTile>();
	}
	

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		if(!conclusionStarted) {
			
			for (Adventurer adventurer: GameManager.adventurers.allAdventurers) {			
				if(adventurer.inParty) {
					adventurer.battlesPassed++;
					adventurer.attackAnimation = false;
					adventurer.turnPassed = false;
					adventurer.setDead(false);
					adventurer.leftClickSituation = PlayerTurnLeftClickSituations.NothingToDo;
					adventurer.moving = false;

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
			}
			
			CombatInitialiser.deployment = false;
			Combat.enemies.clear();

			conclusionStarted = true;
			
		}
		
		if (gameContainer.getInput().getMouseX() > 500 && gameContainer.getInput().getMouseX() < 551 && 
				gameContainer.getInput().getMouseY() > 300 && gameContainer.getInput().getMouseY() < 321) {
			if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				strings.clear();
				conclusionStarted = false;
				GameManager.gameState = GameState.WorldMap;
			}
		}

		
	}	
	


	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		renderer.drawRectOpaque(10, 10, 600, 400, 0x66BB7758);
		
		renderer.drawRectOpaque(500, 300, 50, 20, 0xff332222);
		
		for (int i = 0; i < strings.size(); i++) {
			renderer.drawText(strings.get(i), 10, 10 + i * 15, 0xffCC8855);
		}
	
	}
	
	
	
	private void rollForLevelUp(Adventurer adventurer) {
		
		int roll = random.nextInt(100) + 1;
		if (roll + adventurer.battlesPassed > adventurer.getLevel() * 5 + 5) {
			LevelUpRoller.levelUp(adventurer);
		}
		
	}
	

}
