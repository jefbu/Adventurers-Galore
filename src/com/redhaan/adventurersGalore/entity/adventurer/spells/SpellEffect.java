package com.redhaan.adventurersGalore.entity.adventurer.spells;

import java.util.ArrayList;
import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameState;
import com.redhaan.adventurersGalore.Toast;
import com.redhaan.adventurersGalore.Transition;
import com.redhaan.adventurersGalore.calendar.Calendar;
import com.redhaan.adventurersGalore.combat.Combat;
import com.redhaan.adventurersGalore.dungeon.Dungeon;
import com.redhaan.adventurersGalore.dungeon.Dungeons;
import com.redhaan.adventurersGalore.entity.Monster;
import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;
import com.redhaan.adventurersGalore.entity.adventurer.CombatMove;
import com.redhaan.adventurersGalore.entity.adventurer.Job;
import com.redhaan.adventurersGalore.entity.enemies.Enemy;
import com.redhaan.adventurersGalore.entity.item.weapon.daggers.Dagger;

public abstract class SpellEffect {
	
	private static Random random = new Random();
	
	public static void castSpell(Spell spell, SpellModifier spellModifier, Monster target, int magic) {
		
		switch(spell.name) {
		
		case "Oasis of a Tranquil Heart":
			target.currentStats.HP = target.currentStats.HP + magic;
			if (target.currentStats.HP > target.maxStats.HP) { target.currentStats.HP = target.maxStats.HP; }
			break;
			
		case "City full of Life":	
			ArrayList<Adventurer> deadHeroes = new ArrayList<Adventurer>();
			for (Adventurer adventurer: GameManager.adventurers.allAdventurers) {
				if (adventurer.inParty) {
					if (adventurer.isDead()) { deadHeroes.add(adventurer); }
				}
			}
			if (deadHeroes.size() > 0) {
				int hero = random.nextInt(deadHeroes.size());
				deadHeroes.get(hero).setDead(false);
				deadHeroes.get(hero).currentStats.HP = random.nextInt(deadHeroes.get(hero).maxStats.HP) + 1;
			}
			else { Toast.activate(false, "There are no dead heroes (yet)", 300, 200); }
			break;
			
		case "Fields of Summer Rye":
			for (Adventurer adventurer: GameManager.adventurers.allAdventurers) {
				if (adventurer.inParty && !adventurer.isDead()) {
					adventurer.currentStats.HP += random.nextInt(magic - 2);
					if (adventurer.currentStats.HP > adventurer.maxStats.HP) { adventurer.currentStats.HP = adventurer.maxStats.HP; }
				}
			}			
			break;
		
		case "Grove of Age-old Broadleaves":
			for (Adventurer adventurer: GameManager.adventurers.allAdventurers) {
				if (adventurer.inParty && !adventurer.isDead()) {
					if (adventurer.currentStats.PHY < adventurer.maxStats.PHY) { adventurer.currentStats.PHY = adventurer.maxStats.PHY; }
					if (adventurer.currentStats.AGI < adventurer.maxStats.AGI) { adventurer.currentStats.AGI = adventurer.maxStats.AGI; }					
					if (adventurer.currentStats.MAG < adventurer.maxStats.MAG) { adventurer.currentStats.MAG = adventurer.maxStats.MAG; }					
					if (adventurer.currentStats.DEX < adventurer.maxStats.DEX) { adventurer.currentStats.DEX = adventurer.maxStats.DEX; }					
					if (adventurer.currentStats.PRC < adventurer.maxStats.PRC) { adventurer.currentStats.PRC = adventurer.maxStats.PRC; }					
					if (adventurer.currentStats.INT < adventurer.maxStats.INT) { adventurer.currentStats.INT = adventurer.maxStats.INT; }					
					if (adventurer.currentStats.move < adventurer.maxStats.move) { adventurer.currentStats.move = adventurer.maxStats.move; }
					if (adventurer.currentStats.attack < adventurer.maxStats.attack) { adventurer.currentStats.attack = adventurer.maxStats.attack; }					
					if (adventurer.currentStats.defence < adventurer.maxStats.defence) { adventurer.currentStats.defence = adventurer.maxStats.defence; }					
				}
			}
			break;
			
		case "Bountiful Vineyard":
			for (Adventurer adventurer: GameManager.adventurers.allAdventurers) {
				if (adventurer.inParty && adventurer.maxStats.TST < 100) {
					adventurer.currentStats.TST++;
					adventurer.maxStats.TST++;
				}
			}
			GameManager.gameState = GameState.WorldMap;
			Toast.activate(true, "Party Trust Up!", 280, 50);
			break;
		
		case "Impregnable Castle":
			for (Adventurer adventurer: GameManager.adventurers.allAdventurers) {
				if (adventurer.inParty && !adventurer.isDead()) {
					adventurer.currentStats.defence += random.nextInt(4);			
				}
			}
			break;
			
		case "Skies of Longing Vagabonds":
			Calendar.calendarSpeed = 0;
			Transition.nextGameState = GameState.WorldMap;
			GameManager.gameState = GameState.Transition;
			TownList.active = true;
			break;
			
		case "Heath of Scorched Memories":
			for (Adventurer adventurer: GameManager.adventurers.allAdventurers) {
				if (adventurer.inParty && !adventurer.isDead()) {
					adventurer.currentStats.attack += random.nextInt(3) + 1;			
				}
			}
			break;	
			
		case "River of Killing Currents":
			target.currentStats.move += 3;
			break;	
			
		case "Meadow of Rest for the Wicked":
			for (Enemy enemy: Combat.enemies) {
				if (!enemy.isDead()) {
					enemy.currentStats.HP -= 5;
					if (enemy.currentStats.HP <= 0) { enemy.setDead(true); }
				}
			}
			break;
						
		case "Volcano of Swallowing Ash":
			for (Enemy enemy: Combat.enemies) {
				if (!enemy.isDead()) {
					enemy.currentStats.HP -= 5;
					if (enemy.currentStats.HP <= 0) { enemy.setDead(true); }
				}
			}
			break;
			
		case "Mountain of an Early Grave":
			target.currentStats.HP -= 5 + random.nextInt(magic);
			if (target.currentStats.HP <= 0) { target.setDead(true); }
			break;	
			
		case "Ravine to the Gates of Hell":	
			if (random.nextInt(5000) + (random.nextInt(5) + 1) * magic > 100) {
				target.currentStats.HP = 0;
				target.setDead(true);
			}
			break;
			
		case "Ocean of Overwhelming Despair":	
			for (Enemy enemy: Combat.enemies) {
				if (!enemy.isDead()) {
					enemy.currentStats.defence -= random.nextInt(5);
				}
			}
			break;
			
		case "Corrosive Morass":	
			for (Enemy enemy: Combat.enemies) {
				if (!enemy.isDead()) {
					enemy.currentStats.attack -= random.nextInt(4) + 1;
				}
			}
			break;
			
		case "Taiga where Life cannot Grow":	
			for (Enemy enemy: Combat.enemies) {
				if (!enemy.isDead()) {
					enemy.currentStats.move -= random.nextInt(3);
				}
			}
			break;
		
		case "Impatient Graveyard":
			boolean leftClear = true;
			boolean upClear = true;
			boolean rightClear = true;
			boolean downClear = true;
			for (Enemy enemy: Combat.enemies) {
				if (!enemy.isDead()) {
					if (enemy.getCombatX() == target.getCombatX() - 1 && enemy.getCombatY() == target.getCombatY()) { leftClear = false; }
					if (enemy.getCombatX() == target.getCombatX() + 1 && enemy.getCombatY() == target.getCombatY()) { rightClear = false; }
					if (enemy.getCombatX() == target.getCombatX() && enemy.getCombatY() == target.getCombatY() - 1) { upClear = false; }
					if (enemy.getCombatX() == target.getCombatX() && enemy.getCombatY() == target.getCombatY() + 1) { downClear = false; }
				}
			}
			for (Adventurer adventurer: GameManager.adventurers.allAdventurers) {
				if (adventurer.inParty && !adventurer.isDead()) {
					if (adventurer.getCombatX() == target.getCombatX() - 1 && adventurer.getCombatY() == target.getCombatY()) { leftClear = false; }
					if (adventurer.getCombatX() == target.getCombatX() + 1 && adventurer.getCombatY() == target.getCombatY()) { rightClear = false; }
					if (adventurer.getCombatX() == target.getCombatX() && adventurer.getCombatY() == target.getCombatY() - 1) { upClear = false; }
					if (adventurer.getCombatX() == target.getCombatX() && adventurer.getCombatY() == target.getCombatY() + 1) { downClear = false; }			
				}
			}
			
			if (leftClear) { createSkeleton(target.getCombatX() - 1, target.getCombatY(), magic); }
			else if (upClear) { createSkeleton(target.getCombatX(), target.getCombatY() - 1, magic); }
			else if (rightClear) { createSkeleton(target.getCombatX() + 1, target.getCombatY(), magic); }
			else if (downClear) { createSkeleton(target.getCombatX(), target.getCombatY() + 1, magic); }
			else { Toast.activate(false, "No room for necromancy", target.getCombatX() * GameManager.GAMETILESIZE + 20, target.getCombatY() * GameManager.GAMETILESIZE - 20); }
			
			break;	
			
						
		case "Library of Maddening Wisdom":		
			ArrayList<Dungeon> candidates = new ArrayList<Dungeon>();
			for (Dungeon dungeon: Dungeons.allDungeons) {
				if (!dungeon.discovered) { candidates.add(dungeon); }
			}
			if (candidates.size() > 0) {
				int i = random.nextInt(candidates.size());
				candidates.get(i).discovered = true;
				Toast.activate(true, "Dungeon at: " + candidates.get(i).xLocation + ", " + candidates.get(i).yLocation, 300, 220);
			}
			else { Toast.activate(false, "There are no undiscovered dungeons", 300, 220); }
			break;
		
		
		
		
		}
		
		
	}
	
	
	private static void createSkeleton (int combatX, int combatY, int magic) {
		
		Adventurer skeleton = new Adventurer();
		skeleton.setCombatX(combatX);
		skeleton.setCombatY(combatY);
		skeleton.job = Job.summonedSkeleton;
		skeleton.icon = Job.summonedSkeleton.icon;
		skeleton.currentStats.HP = 5 + (random.nextInt(magic) / 5);
		skeleton.maxStats.HP = skeleton.currentStats.HP;
		skeleton.currentStats.PHY = 6 + (random.nextInt(magic) / 10);
		skeleton.currentStats.AGI = 4 + (random.nextInt(magic) / 10);
		skeleton.currentStats.MAG = 1;
		skeleton.currentStats.move = 3 + (random.nextInt(magic) / 15);
		skeleton.currentStats.defence = 10 + (random.nextInt(magic) / 10);
		skeleton.currentStats.attack = 11 + (random.nextInt(magic) / 10);
		
		skeleton.combatMoves.add(CombatMove.fight);
		skeleton.combatMoves.add(CombatMove.magic);
		skeleton.combatMoves.add(CombatMove.mowDown);
		
		skeleton.weapon = new Dagger();
		
		skeleton.inParty = true;
		skeleton.setDead(false);
		
		GameManager.adventurers.allAdventurers.add(skeleton);
		
	}
	

}
