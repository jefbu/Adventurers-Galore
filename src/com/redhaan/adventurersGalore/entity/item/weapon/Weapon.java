package com.redhaan.adventurersGalore.entity.item.weapon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.entity.item.Item;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Amber;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Amethyst;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Emerald;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.GemStone;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.GemStoneEnum;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.MoonStone;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Onyx;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Pearl;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Ruby;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Sapphire;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Topaz;
import com.redhaan.adventurersGalore.entity.item.weapon.gemStones.Turquoise;

import gameEngine.ecclesiastes.gfx.ImageTile;

public class Weapon extends Item implements Serializable {

	private static final long serialVersionUID = 1L;
	public int damage, hit, crit;
	public int minRange, maxRange;
	public int upgrades;
	public WeaponType type;
	
	public Soul soul;
	public GemStone gemStone;
	
	public int runeTier;
	public int runeSlots;
	public ArrayList<Rune> runes;
	
	public boolean isLegendary;
	
	public static ImageTile icon = new ImageTile("/weapons.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE);;
	
	Random random;
	
	public Weapon() {
		random = new Random();
		
		runes = new ArrayList<Rune>();
		isLegendary = false;
		minRange = 1;
		maxRange = 1;
		
	}
	
	public void rollRuneSlots(int runeTier) {
		
		int roll = random.nextInt(100) + 1;
		
		switch(runeTier) {
		
		case 1:
			if (roll > 95) { runeSlots = 3; }
			else if (roll > 85) { runeSlots = 2; }
			else if (roll > 70) { runeSlots = 1; }
			else runeSlots = 0;
			break;
		case 2:
			if (roll > 90) { runeSlots = 3; }
			else if (roll > 70) { runeSlots = 2; }
			else if (roll > 40) { runeSlots = 1; }
			else runeSlots = 0;
			break;
		case 3:
			if (roll > 80) { runeSlots = 3; }
			else if (roll > 50) { runeSlots = 2; }
			else if (roll > 20) { runeSlots = 1; }
			else runeSlots = 0;
			break;
		case 4:
			if (roll > 60) { runeSlots = 3; }
			else if (roll > 20) { runeSlots = 2; }
			else if (roll > 5) { runeSlots = 1; }
			else runeSlots = 0;
			break;
		}
		
	}
	
	
	public GemStone rollGemStone(int gemTier) {
		
		boolean hasGem = rollToSeeIfHasGem(gemTier);
		
		if(hasGem) {
			
			GemStoneEnum type = rollForGemStoneType();
			int quality = rollGemStoneQuality(gemTier);
			
			switch(type) {
			
			case amber: return new Amber(quality);
			case amethyst: return new Amethyst(quality);
			case emerald: return new Emerald(quality);
			case onyx: return new Onyx(quality);
			case pearl: return new Pearl(quality);
			case ruby: return new Ruby(quality);
			case sapphire: return new Sapphire(quality);
			case topaz: return new Topaz(quality);
			case turquoise: return new Turquoise(quality);

			default: return new MoonStone(5);
			
			}
			
		}
		
		else { return null; }			
		
	}
	
	
	private boolean rollToSeeIfHasGem(int gemTier) {
		
		int roll = random.nextInt(100) + 1;
		
		switch(gemTier) {
		
		case 1: if (roll > 80) { return true; } else { return false; }
		case 2: if (roll > 65) { return true; } else { return false; }
		case 3: if (roll > 50) { return true; } else { return false; }
		case 4: if (roll > 35) { return true; } else { return false; }
		
		default: return false;

		}
		
	}
	
	private GemStoneEnum rollForGemStoneType() {
		
		int roll = random.nextInt(9) + 1;
		
		switch(roll) {
		
		case 1: return GemStoneEnum.amber;
		case 2: return GemStoneEnum.amethyst;
		case 3: return GemStoneEnum.emerald;
		case 4: return GemStoneEnum.onyx;
		case 5: return GemStoneEnum.pearl;
		case 6: return GemStoneEnum.ruby;
		case 7: return GemStoneEnum.sapphire;
		case 8: return GemStoneEnum.topaz;
		case 9: return GemStoneEnum.turquoise;
		
		default: return null;		
		
		}
		
	}
	
	private int rollGemStoneQuality(int gemTier) {
		
		int roll = random.nextInt(100) + 1; 
		
		switch(gemTier) {
		
		case 1:
			if (roll > 99) { return 4; }
			else if (roll > 90) { return 3; }
			else if (roll > 70) { return 2; }
			else { return 1; }
		case 2:
			if (roll > 95) { return 4; }
			else if (roll > 80) { return 3; }
			else if (roll > 50) { return 2; }
			else { return 1; }
		case 3:
			if (roll > 90) { return 4; }
			else if (roll > 70) { return 3; }
			else if (roll > 40) { return 2; }
			else { return 1; }
		case 4:
			if (roll > 80) { return 4; }
			else if (roll > 55) { return 3; }
			else if (roll > 25) { return 2; }
			else { return 1; }
			
		default: return 500;
		
		}
		
	}
	
	
	public Soul rollSoul() {
		
		int roll = random.nextInt(100) + 1;
		if (roll > 70) { return Soul.dwarfSlayer; } else { return null; }

	}
	
	public int rollUpgrades(int upgradeTier) {
		
		int roll = random.nextInt(100) + 1;
		switch(upgradeTier) {
		
		case 1:
			if (roll > 90) { return 2; }
			else if (roll > 70) { return 1; }
			else { return 0; }
		case 2:
			if (roll > 80) { return 2; }
			else if (roll > 60) { return 1; }
			else { return 0; }
		case 3:
			if (roll > 70) { return 2; }
			else if (roll > 50) { return 1; }
			else { return 0; }
		case 4:
			if (roll > 60) { return 2; }
			else if (roll > 30) { return 1; }
			else { return 0; }
			
		default: return 500;
		}
		
	}
	
	public boolean rollBonusUpgrades(int barrier) {
		
		int roll = random.nextInt(100) + 1;
		if (roll > barrier) { return true; } else { return false; }
		
	}
	
	
	
	
	
	
	public void upgrade() {
		
		damage++;
		hit = hit + 3;
		crit = crit + 2;
		
	}
			

}
