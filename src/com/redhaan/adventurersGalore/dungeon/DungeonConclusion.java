package com.redhaan.adventurersGalore.dungeon;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.GameState;
import com.redhaan.adventurersGalore.Transition;
import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;
import com.redhaan.adventurersGalore.entity.adventurer.LevelUpRoller;
import com.redhaan.adventurersGalore.entity.adventurer.Stats;
import com.redhaan.adventurersGalore.entity.item.Item;
import com.redhaan.adventurersGalore.entity.item.ItemID;
import com.redhaan.adventurersGalore.entity.item.armour.Armour;
import com.redhaan.adventurersGalore.entity.item.items.Antlers;
import com.redhaan.adventurersGalore.entity.item.items.BeastBlood;
import com.redhaan.adventurersGalore.entity.item.items.Bone;
import com.redhaan.adventurersGalore.entity.item.items.Claw;
import com.redhaan.adventurersGalore.entity.item.items.Coral;
import com.redhaan.adventurersGalore.entity.item.items.CraftItems;
import com.redhaan.adventurersGalore.entity.item.items.ElysianFlower;
import com.redhaan.adventurersGalore.entity.item.items.EvilSpirit;
import com.redhaan.adventurersGalore.entity.item.items.Fang;
import com.redhaan.adventurersGalore.entity.item.items.GloriousMoment;
import com.redhaan.adventurersGalore.entity.item.items.Gold;
import com.redhaan.adventurersGalore.entity.item.items.HeartSpirit;
import com.redhaan.adventurersGalore.entity.item.items.Hide;
import com.redhaan.adventurersGalore.entity.item.items.Iron;
import com.redhaan.adventurersGalore.entity.item.items.Lesses;
import com.redhaan.adventurersGalore.entity.item.items.LiquidInnocence;
import com.redhaan.adventurersGalore.entity.item.items.LuckyClover;
import com.redhaan.adventurersGalore.entity.item.items.MorningSunlight;
import com.redhaan.adventurersGalore.entity.item.items.NobleSpirit;
import com.redhaan.adventurersGalore.entity.item.items.OakWood;
import com.redhaan.adventurersGalore.entity.item.items.Pelt;
import com.redhaan.adventurersGalore.entity.item.items.PentUpAnger;
import com.redhaan.adventurersGalore.entity.item.items.RationalThought;
import com.redhaan.adventurersGalore.entity.item.items.ReforgedPlough;
import com.redhaan.adventurersGalore.entity.item.items.Silver;
import com.redhaan.adventurersGalore.entity.item.items.SpiritOfMischief;
import com.redhaan.adventurersGalore.entity.item.items.SpringBreeze;
import com.redhaan.adventurersGalore.entity.item.items.StolenMoonlight;
import com.redhaan.adventurersGalore.entity.item.items.Tusk;
import com.redhaan.adventurersGalore.entity.item.items.VagrantSpirit;
import com.redhaan.adventurersGalore.entity.item.items.ViolentSpirit;
import com.redhaan.adventurersGalore.entity.item.items.Wanderlust;
import com.redhaan.adventurersGalore.entity.item.weapon.Weapon;
import com.redhaan.adventurersGalore.inventory.Inventory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.audio.SoundClip;

public class DungeonConclusion extends GameObject {


	private static final long serialVersionUID = 1L;
	
	public Dungeon dungeon;
	private static Random random = new Random();
	private boolean initiated;
	ArrayList<Item> loot;
	private static SoundClip victorySound = new SoundClip("/victory.wav");
	private ArrayList<String> strings;

	
	public DungeonConclusion(Dungeon dungeon) {
		initiated = false;
		this.dungeon = dungeon;
		loot = new ArrayList<Item>();
		strings = new ArrayList<String>();
	}
	

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		if(!initiated) {
			
			victorySound.play();
			
			for (int i = 0; i < dungeon.lootCollected; i++) { loot.add(rollLoot()); }
			Inventory.update(loot);
			initiated = true;
	
			for (Adventurer adventurer: GameManager.adventurers.allAdventurers) {			
				if(adventurer.inParty) {
					adventurer.battlesPassed++;
					adventurer.actingAnimation = false;
					adventurer.turnPassed = false;
					adventurer.selected = false;
					adventurer.hasMoved = false;
					adventurer.hasActed = false;
					adventurer.setDead(false);
					adventurer.refreshStats();
					
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
						strings.add(adventurer.name + " got mighty.");
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
		}

		
		if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
			if(gameContainer.getInput().getMouseX() > 10 && gameContainer.getInput().getMouseX() < 600 &&
					gameContainer.getInput().getMouseY() > 10 && gameContainer.getInput().getMouseY() < 400) {
				
				initiated = false;
				Transition.nextGameState = GameState.WorldMap;
				GameManager.gameState = GameState.Transition;
				
				
			}
		}

		
	}
	


	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		if(initiated) {
			
			renderer.drawRectOpaque(20, 20, 600, 440, 0xff253320);
			
			renderer.drawRectOpaque(25, 25, 200, 435, 0xff182616);
				renderer.drawText("Thou hast vanquished the dungeon!", 30, 30, 0xff547346);
				renderer.drawText("Thy bounty:" , 30, 48, 0xff547346);
				
				for (int i = 0; i < loot.size(); i++) {
					if (loot.get(i).ID != ItemID.Weapon && loot.get(i).ID != ItemID.Armour) {
						renderer.drawImageTile(CraftItems.icon, 40, 72 + i * 20, loot.get(i).xTile, loot.get(i).yTile);
						renderer.drawText(loot.get(i).name, 40, 55 + i * 20, 0xff545481);
					}
					else if (loot.get(i).ID == ItemID.Weapon) { 
						renderer.drawImageTile(Weapon.icon, 40, 72+ i * 32, loot.get(i).xTile, loot.get(i).yTile); 
						renderer.drawText(loot.get(i).name, 40, 55 + i * 32, 0xff545481);
						}
					else if (loot.get(i).ID == ItemID.Armour) { 
						renderer.drawImageTile(Armour.icon, 40, 72 + i * 32, loot.get(i).xTile, loot.get(i).yTile); 
						renderer.drawText(loot.get(i).name, 40, 55 + i * 32, 0xff545481);
						}
				}
				

		
			renderer.drawRectOpaque(230, 25, 380, 300, 0xff161826);
				renderer.drawText("The following adventurers got mighty!", 235, 30, 0xff465473);
				
			for (int i = 0; i < strings.size(); i++) {
				renderer.drawText(strings.get(i), 235, 50 + i * 15, 0xff465473);
			}
				
				
		}		
		
	}
	
	
	
	private Item rollLoot() {
		
		int roll = random.nextInt(10) + 1;
		
		if(roll > 8) { return rollLootTier4(); }
		else if (roll > 4) { return rollLootTier3(); }
		else if (roll > 1) { return rollLootTier2(); }
		else { return rollLootTier1(); }		
		
	}
	
	
	private Item rollLootTier1() {
		
		int roll = random.nextInt(9) + 1;
		
		switch(roll) {
		case 1: return new Tusk();
		case 2: return new Fang();
		case 3: return new Claw();
		case 4: return new OakWood();
		case 5: return new Iron();
		case 6: return new Pelt();
		case 7: return new Hide();
		case 8: return new BeastBlood();
		case 9: return new Lesses();		
		default: return new Item();		
		}		
		
	}
	
	private Item rollLootTier2() { 
		
		int roll = random.nextInt(5) + 1;
		
		switch(roll) {
		case 1: return new Antlers();
		case 2: return new Coral();
		case 3: return new Bone();
		case 4: return new Silver();
		case 5: return new Gold();
		default: return new Item();		
		}
		
	}
	
	private Item rollLootTier3() { 
		
		int roll = random.nextInt(6) + 1;
		
		switch(roll) {
		case 1: return new EvilSpirit();
		case 2: return new ViolentSpirit();
		case 3: return new SpiritOfMischief();
		case 4: return new VagrantSpirit();
		case 5: return new NobleSpirit();
		case 6: return new HeartSpirit();
		default: return new Item();
		}
		
		
	}
	
	private Item rollLootTier4() { 

		int roll = random.nextInt(11) + 1;
		
		switch(roll) {
		case 1: return new StolenMoonlight();
		case 2: return new LiquidInnocence();
		case 3: return new LuckyClover();
		case 4: return new RationalThought();
		case 5: return new ReforgedPlough();
		case 6: return new SpringBreeze();
		case 7: return new MorningSunlight();
		case 8: return new PentUpAnger();
		case 9: return new GloriousMoment();
		case 10: return new ElysianFlower();
		case 11: return new Wanderlust();
		default: return new Item();		
		}
		
	}
	
	
	private void rollForLevelUp(Adventurer adventurer) {
		
		int roll = random.nextInt(120) + 1;
		if (roll + adventurer.battlesPassed > adventurer.getLevel() * 5 + 5) {
			LevelUpRoller.levelUp(adventurer);
		}
		
	}
	
	

}
