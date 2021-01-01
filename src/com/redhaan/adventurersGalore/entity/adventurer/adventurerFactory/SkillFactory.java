package com.redhaan.adventurersGalore.entity.adventurer.adventurerFactory;

import java.io.Serializable;
import java.util.Random;

import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;
import com.redhaan.adventurersGalore.entity.adventurer.Job;
import com.redhaan.adventurersGalore.entity.adventurer.skills.SkillEnum;
import com.redhaan.adventurersGalore.entity.adventurer.skills.Skills;

public class SkillFactory implements Serializable {
	
	private static final long serialVersionUID = 1L;
	Random random;
	
	public SkillFactory() {
		
		random = new Random();
		
	}
	
	
	
	public Skills rollSkills(Adventurer adventurer) {
		
		Skills skills = new Skills();
		skills.sword.value = rollSkillValue(adventurer.job, SkillEnum.Sword, adventurer.tier);
		skills.axe.value = rollSkillValue(adventurer.job, SkillEnum.Axe, adventurer.tier);
		skills.dagger.value = rollSkillValue(adventurer.job, SkillEnum.Dagger, adventurer.tier);
		skills.staff.value = rollSkillValue(adventurer.job, SkillEnum.Staff, adventurer.tier);
		skills.spear.value = rollSkillValue(adventurer.job, SkillEnum.Spear, adventurer.tier);
		skills.bow.value = rollSkillValue(adventurer.job, SkillEnum.Bow, adventurer.tier);
		skills.trapping.value = rollSkillValue(adventurer.job, SkillEnum.Trapping, adventurer.tier);
		skills.fishing.value = rollSkillValue(adventurer.job, SkillEnum.Fishing, adventurer.tier);
		skills.foraging.value = rollSkillValue(adventurer.job, SkillEnum.Foraging, adventurer.tier);
		skills.cooking.value = rollSkillValue(adventurer.job, SkillEnum.Cooking, adventurer.tier);
		skills.camping.value = rollSkillValue(adventurer.job, SkillEnum.Camping, adventurer.tier);
		skills.lockpick.value = rollSkillValue(adventurer.job, SkillEnum.Lockpick, adventurer.tier);
		skills.pickpocket.value = rollSkillValue(adventurer.job, SkillEnum.Pickpocket, adventurer.tier);
		skills.stealth.value = rollSkillValue(adventurer.job, SkillEnum.Stealth, adventurer.tier);
		skills.entertaining.value = rollSkillValue(adventurer.job, SkillEnum.Entertaining, adventurer.tier);
		skills.haggling.value = rollSkillValue(adventurer.job, SkillEnum.Haggling, adventurer.tier);
		skills.decorum.value = rollSkillValue(adventurer.job, SkillEnum.Decorum, adventurer.tier);
		skills.crafting.value = rollSkillValue(adventurer.job, SkillEnum.Crafting, adventurer.tier);
		skills.alchemy.value = rollSkillValue(adventurer.job, SkillEnum.Alchemy, adventurer.tier);
		skills.medicine.value = rollSkillValue(adventurer.job, SkillEnum.Medicine, adventurer.tier);
		skills.weaponSmith.value = rollSkillValue(adventurer.job, SkillEnum.WeaponSmith, adventurer.tier);


		
		skills.skillSlots = rollActiveSkillSlots(adventurer.tier);
		setActiveSkills(skills, adventurer.job);
						
		return skills;
		
	}
	
	
	
	
	
	private int rollSkillValue(Job job, SkillEnum skillName, int tier) {
		
		int value = 0;
		int roll = random.nextInt(100) + 1;
		
		if (roll > 99) { value = 5; }
		else if (roll > 95) { value = 4; }
		else if (roll > 85) { value = 3; }
		else if (roll > 70) { value = 2; }
		else if (roll > 50) { value = 1; }
		else { value = 0; }
		
		int roll2 = random.nextInt(10) + 1;
		
		switch(tier) {
		case 0: if (roll2 == 10) { value++; } break;
		case 1: if (roll2 == 10) { value++; } break;
		case 2: if (roll2 > 8) { value++; } break;
		case 3: if (roll2 > 7) { value++; } break;
		case 4: if (roll2 > 6) { value++; } break;
		default: break;		
		}
		
		switch(job.jobEnum) {
		
		case Squire: if(skillName == SkillEnum.Sword) { value++; } break;
		case Knight: if(skillName == SkillEnum.Sword) { value++; } break;
		case Paladin: if(skillName == SkillEnum.Sword) { value++; } else if (skillName == SkillEnum.Decorum) { value++; } break;

		case Mage: if(skillName == SkillEnum.Staff) { value++; } break;
		case Magus: if(skillName == SkillEnum.Staff) { value++; } break;
		case ArchMage: if(skillName == SkillEnum.Staff) { value++; } else if (skillName == SkillEnum.Alchemy) { value++; } break;

		case Thief: if(skillName == SkillEnum.Dagger) { value++; } break;
		case Knave: if(skillName == SkillEnum.Dagger) { value++; } break;
		case CatBurglar: if(skillName == SkillEnum.Dagger) { value++; } else if (skillName == SkillEnum.Stealth) { value++; } break;

		case Archer: if(skillName == SkillEnum.Bow) { value++; } break;
		case Hunter: if(skillName == SkillEnum.Bow) { value++; } break;
		case Sniper: if(skillName == SkillEnum.Bow) { value++; } else if (skillName == SkillEnum.Camping) { value++; } break;

		case Barbarian: if(skillName == SkillEnum.Spear) { value++; } break;
		case Berserker: if(skillName == SkillEnum.Spear) { value++; } break;
		case RedMist: if(skillName == SkillEnum.Spear) { value++; } else if (skillName == SkillEnum.Trapping) { value++; } break;
			
		default: break;
		
		}
		
		if (value < 0) { value = 0; }
		if (value > 5) { value = 5; }
		
		return value;
		
	}
	
	
	
	
	
	
	private int rollActiveSkillSlots(int tier) {
				
		int skillSlots = 0;
		int roll = random.nextInt(100) + 1;
		
		switch(tier) {
		
		case 0:
			if(roll > 90) { skillSlots =  6; } 
			else if(roll > 75) { skillSlots =  5; } 
			else if(roll > 60) { skillSlots =  4; } 
			else if(roll > 25) { skillSlots =  3; } 
			else { skillSlots =  2; }
			break;
		case 1:
			if(roll > 90) { skillSlots =  6; }
			else if(roll > 75) { skillSlots =  5; }
			else if(roll > 60) { skillSlots =  4; }
			else if(roll > 25) { skillSlots =  3; }
			else { skillSlots =  2; }
			break;
		case 2:
			if(roll > 85) { skillSlots =  6; }
			else if(roll > 70) { skillSlots =  5; }
			else if(roll > 55) { skillSlots =  4; }
			else if(roll > 25) { skillSlots =  3; }
			else { skillSlots =  2; }	
			break;
		case 3:
			if(roll > 85) { skillSlots =  6; }
			else if(roll > 70) { skillSlots =  5; }
			else if(roll > 50) { skillSlots =  4; }
			else if(roll > 20) { skillSlots =  3; }
			else { skillSlots =  2; }
			break;
		case 4:
			if(roll > 80) { skillSlots =  6; }
			else if(roll > 60) { skillSlots =  5; }
			else if(roll > 40) { skillSlots =  4; }
			else if(roll > 15) { skillSlots =  3; }
			else { skillSlots =  2; }
			break;
						
		default: skillSlots =  1; break;
		
		}	
		return skillSlots;
	}	
		
	private void setActiveSkills(Skills skills, Job job) {
			
		int takenSlots = 0;
		while(takenSlots < skills.skillSlots) {
				
				int roll3 = random.nextInt(100) + 1;
				
				switch(job.jobEnum) {
				
				case Squire:
					if (roll3 > 80) { if(!skills.sword.activeSkill) { skills.sword.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 75) { if(!skills.axe.activeSkill) { skills.axe.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 70) { if(!skills.dagger.activeSkill) { skills.dagger.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 65) { if(!skills.staff.activeSkill) { skills.staff.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 60) { if(!skills.bow.activeSkill) { skills.bow.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 58) { if(!skills.trapping.activeSkill) { skills.trapping.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 56) { if(!skills.fishing.activeSkill) { skills.fishing.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 54) { if(!skills.foraging.activeSkill) { skills.foraging.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 52) { if(!skills.camping.activeSkill) { skills.camping.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 50) { if(!skills.cooking.activeSkill) { skills.cooking.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 48) { if(!skills.lockpick.activeSkill) { skills.lockpick.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 46) { if(!skills.pickpocket.activeSkill) { skills.pickpocket.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 44) { if(!skills.stealth.activeSkill) { skills.stealth.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 42) { if(!skills.entertaining.activeSkill) { skills.entertaining.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 40) { if(!skills.haggling.activeSkill) { skills.haggling.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 30) { if(!skills.decorum.activeSkill) { skills.decorum.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 25) { if(!skills.crafting.activeSkill) { skills.crafting.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 20) { if(!skills.alchemy.activeSkill) { skills.alchemy.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 10) { if(!skills.medicine.activeSkill) { skills.medicine.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 0) { if(!skills.weaponSmith.activeSkill) { skills.weaponSmith.activeSkill = true;  takenSlots++; } }
					break;
				case Knight:
					if (roll3 > 80) { if(!skills.sword.activeSkill) { skills.sword.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 75) { if(!skills.axe.activeSkill) { skills.axe.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 70) { if(!skills.dagger.activeSkill) { skills.dagger.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 65) { if(!skills.staff.activeSkill) { skills.staff.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 60) { if(!skills.bow.activeSkill) { skills.bow.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 58) { if(!skills.trapping.activeSkill) { skills.trapping.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 56) { if(!skills.fishing.activeSkill) { skills.fishing.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 54) { if(!skills.foraging.activeSkill) { skills.foraging.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 52) { if(!skills.camping.activeSkill) { skills.camping.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 50) { if(!skills.cooking.activeSkill) { skills.cooking.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 48) { if(!skills.lockpick.activeSkill) { skills.lockpick.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 46) { if(!skills.pickpocket.activeSkill) { skills.pickpocket.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 44) { if(!skills.stealth.activeSkill) { skills.stealth.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 42) { if(!skills.entertaining.activeSkill) { skills.entertaining.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 40) { if(!skills.haggling.activeSkill) { skills.haggling.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 30) { if(!skills.decorum.activeSkill) { skills.decorum.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 25) { if(!skills.crafting.activeSkill) { skills.crafting.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 20) { if(!skills.alchemy.activeSkill) { skills.alchemy.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 10) { if(!skills.medicine.activeSkill) { skills.medicine.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 0) { if(!skills.weaponSmith.activeSkill) { skills.weaponSmith.activeSkill = true;  takenSlots++; } }
					break;
				case Paladin:
					if (roll3 > 80) { if(!skills.sword.activeSkill) { skills.sword.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 75) { if(!skills.axe.activeSkill) { skills.axe.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 70) { if(!skills.dagger.activeSkill) { skills.dagger.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 65) { if(!skills.staff.activeSkill) { skills.staff.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 60) { if(!skills.bow.activeSkill) { skills.bow.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 58) { if(!skills.trapping.activeSkill) { skills.trapping.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 56) { if(!skills.fishing.activeSkill) { skills.fishing.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 54) { if(!skills.foraging.activeSkill) { skills.foraging.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 52) { if(!skills.camping.activeSkill) { skills.camping.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 50) { if(!skills.cooking.activeSkill) { skills.cooking.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 48) { if(!skills.lockpick.activeSkill) { skills.lockpick.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 46) { if(!skills.pickpocket.activeSkill) { skills.pickpocket.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 44) { if(!skills.stealth.activeSkill) { skills.stealth.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 42) { if(!skills.entertaining.activeSkill) { skills.entertaining.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 40) { if(!skills.haggling.activeSkill) { skills.haggling.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 30) { if(!skills.decorum.activeSkill) { skills.decorum.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 25) { if(!skills.crafting.activeSkill) { skills.crafting.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 20) { if(!skills.alchemy.activeSkill) { skills.alchemy.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 10) { if(!skills.medicine.activeSkill) { skills.medicine.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 0) { if(!skills.weaponSmith.activeSkill) { skills.weaponSmith.activeSkill = true;  takenSlots++; } }
					break;
					
				case Mage:
					if (roll3 > 95) { if(!skills.sword.activeSkill) { skills.sword.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 93) { if(!skills.axe.activeSkill) { skills.axe.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 90) { if(!skills.dagger.activeSkill) { skills.dagger.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 75) { if(!skills.staff.activeSkill) { skills.staff.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 72) { if(!skills.bow.activeSkill) { skills.bow.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 70) { if(!skills.trapping.activeSkill) { skills.trapping.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 68) { if(!skills.fishing.activeSkill) { skills.fishing.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 66) { if(!skills.foraging.activeSkill) { skills.foraging.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 64) { if(!skills.camping.activeSkill) { skills.camping.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 60) { if(!skills.cooking.activeSkill) { skills.cooking.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 58) { if(!skills.lockpick.activeSkill) { skills.lockpick.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 56) { if(!skills.pickpocket.activeSkill) { skills.pickpocket.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 54) { if(!skills.stealth.activeSkill) { skills.stealth.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 50) { if(!skills.entertaining.activeSkill) { skills.entertaining.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 46) { if(!skills.haggling.activeSkill) { skills.haggling.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 40) { if(!skills.decorum.activeSkill) { skills.decorum.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 35) { if(!skills.crafting.activeSkill) { skills.crafting.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 20) { if(!skills.alchemy.activeSkill) { skills.alchemy.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 5) { if(!skills.medicine.activeSkill) { skills.medicine.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 0) { if(!skills.weaponSmith.activeSkill) { skills.weaponSmith.activeSkill = true;  takenSlots++; } }
					break;
				case Magus:
					if (roll3 > 95) { if(!skills.sword.activeSkill) { skills.sword.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 93) { if(!skills.axe.activeSkill) { skills.axe.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 90) { if(!skills.dagger.activeSkill) { skills.dagger.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 75) { if(!skills.staff.activeSkill) { skills.staff.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 72) { if(!skills.bow.activeSkill) { skills.bow.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 70) { if(!skills.trapping.activeSkill) { skills.trapping.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 68) { if(!skills.fishing.activeSkill) { skills.fishing.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 66) { if(!skills.foraging.activeSkill) { skills.foraging.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 64) { if(!skills.camping.activeSkill) { skills.camping.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 60) { if(!skills.cooking.activeSkill) { skills.cooking.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 58) { if(!skills.lockpick.activeSkill) { skills.lockpick.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 56) { if(!skills.pickpocket.activeSkill) { skills.pickpocket.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 54) { if(!skills.stealth.activeSkill) { skills.stealth.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 50) { if(!skills.entertaining.activeSkill) { skills.entertaining.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 46) { if(!skills.haggling.activeSkill) { skills.haggling.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 40) { if(!skills.decorum.activeSkill) { skills.decorum.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 35) { if(!skills.crafting.activeSkill) { skills.crafting.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 20) { if(!skills.alchemy.activeSkill) { skills.alchemy.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 5) { if(!skills.medicine.activeSkill) { skills.medicine.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 0) { if(!skills.weaponSmith.activeSkill) { skills.weaponSmith.activeSkill = true;  takenSlots++; } }
					break;
				case ArchMage:
					if (roll3 > 95) { if(!skills.sword.activeSkill) { skills.sword.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 93) { if(!skills.axe.activeSkill) { skills.axe.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 90) { if(!skills.dagger.activeSkill) { skills.dagger.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 75) { if(!skills.staff.activeSkill) { skills.staff.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 72) { if(!skills.bow.activeSkill) { skills.bow.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 70) { if(!skills.trapping.activeSkill) { skills.trapping.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 68) { if(!skills.fishing.activeSkill) { skills.fishing.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 66) { if(!skills.foraging.activeSkill) { skills.foraging.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 64) { if(!skills.camping.activeSkill) { skills.camping.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 60) { if(!skills.cooking.activeSkill) { skills.cooking.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 58) { if(!skills.lockpick.activeSkill) { skills.lockpick.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 56) { if(!skills.pickpocket.activeSkill) { skills.pickpocket.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 54) { if(!skills.stealth.activeSkill) { skills.stealth.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 50) { if(!skills.entertaining.activeSkill) { skills.entertaining.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 46) { if(!skills.haggling.activeSkill) { skills.haggling.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 40) { if(!skills.decorum.activeSkill) { skills.decorum.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 35) { if(!skills.crafting.activeSkill) { skills.crafting.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 20) { if(!skills.alchemy.activeSkill) { skills.alchemy.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 5) { if(!skills.medicine.activeSkill) { skills.medicine.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 0) { if(!skills.weaponSmith.activeSkill) { skills.weaponSmith.activeSkill = true;  takenSlots++; } }
					break;
					
				case Thief:
					if (roll3 > 95) { if(!skills.sword.activeSkill) { skills.sword.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 93) { if(!skills.axe.activeSkill) { skills.axe.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 80) { if(!skills.dagger.activeSkill) { skills.dagger.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 78) { if(!skills.staff.activeSkill) { skills.staff.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 74) { if(!skills.bow.activeSkill) { skills.bow.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 70) { if(!skills.trapping.activeSkill) { skills.trapping.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 67) { if(!skills.fishing.activeSkill) { skills.fishing.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 64) { if(!skills.foraging.activeSkill) { skills.foraging.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 61) { if(!skills.camping.activeSkill) { skills.camping.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 58) { if(!skills.cooking.activeSkill) { skills.cooking.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 43) { if(!skills.lockpick.activeSkill) { skills.lockpick.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 28) { if(!skills.pickpocket.activeSkill) { skills.pickpocket.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 13) { if(!skills.stealth.activeSkill) { skills.stealth.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 11) { if(!skills.entertaining.activeSkill) { skills.entertaining.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 9) { if(!skills.haggling.activeSkill) { skills.haggling.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 7) { if(!skills.decorum.activeSkill) { skills.decorum.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 5) { if(!skills.crafting.activeSkill) { skills.crafting.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 3) { if(!skills.alchemy.activeSkill) { skills.alchemy.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 1) { if(!skills.medicine.activeSkill) { skills.medicine.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 0) { if(!skills.weaponSmith.activeSkill) { skills.weaponSmith.activeSkill = true;  takenSlots++; } }
					break;
				case Knave:
					if (roll3 > 95) { if(!skills.sword.activeSkill) { skills.sword.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 93) { if(!skills.axe.activeSkill) { skills.axe.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 80) { if(!skills.dagger.activeSkill) { skills.dagger.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 78) { if(!skills.staff.activeSkill) { skills.staff.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 74) { if(!skills.bow.activeSkill) { skills.bow.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 70) { if(!skills.trapping.activeSkill) { skills.trapping.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 67) { if(!skills.fishing.activeSkill) { skills.fishing.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 64) { if(!skills.foraging.activeSkill) { skills.foraging.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 61) { if(!skills.camping.activeSkill) { skills.camping.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 58) { if(!skills.cooking.activeSkill) { skills.cooking.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 43) { if(!skills.lockpick.activeSkill) { skills.lockpick.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 28) { if(!skills.pickpocket.activeSkill) { skills.pickpocket.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 13) { if(!skills.stealth.activeSkill) { skills.stealth.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 11) { if(!skills.entertaining.activeSkill) { skills.entertaining.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 9) { if(!skills.haggling.activeSkill) { skills.haggling.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 7) { if(!skills.decorum.activeSkill) { skills.decorum.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 5) { if(!skills.crafting.activeSkill) { skills.crafting.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 3) { if(!skills.alchemy.activeSkill) { skills.alchemy.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 1) { if(!skills.medicine.activeSkill) { skills.medicine.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 0) { if(!skills.weaponSmith.activeSkill) { skills.weaponSmith.activeSkill = true;  takenSlots++; } }
					break;
				case CatBurglar:
					if (roll3 > 95) { if(!skills.sword.activeSkill) { skills.sword.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 93) { if(!skills.axe.activeSkill) { skills.axe.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 80) { if(!skills.dagger.activeSkill) { skills.dagger.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 78) { if(!skills.staff.activeSkill) { skills.staff.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 74) { if(!skills.bow.activeSkill) { skills.bow.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 70) { if(!skills.trapping.activeSkill) { skills.trapping.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 67) { if(!skills.fishing.activeSkill) { skills.fishing.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 64) { if(!skills.foraging.activeSkill) { skills.foraging.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 61) { if(!skills.camping.activeSkill) { skills.camping.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 58) { if(!skills.cooking.activeSkill) { skills.cooking.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 43) { if(!skills.lockpick.activeSkill) { skills.lockpick.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 28) { if(!skills.pickpocket.activeSkill) { skills.pickpocket.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 13) { if(!skills.stealth.activeSkill) { skills.stealth.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 11) { if(!skills.entertaining.activeSkill) { skills.entertaining.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 9) { if(!skills.haggling.activeSkill) { skills.haggling.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 7) { if(!skills.decorum.activeSkill) { skills.decorum.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 5) { if(!skills.crafting.activeSkill) { skills.crafting.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 3) { if(!skills.alchemy.activeSkill) { skills.alchemy.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 1) { if(!skills.medicine.activeSkill) { skills.medicine.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 0) { if(!skills.weaponSmith.activeSkill) { skills.weaponSmith.activeSkill = true;  takenSlots++; } }
					break;
					
				case Archer:
					if (roll3 > 98) { if(!skills.sword.activeSkill) { skills.sword.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 96) { if(!skills.axe.activeSkill) { skills.axe.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 90) { if(!skills.dagger.activeSkill) { skills.dagger.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 88) { if(!skills.staff.activeSkill) { skills.staff.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 70) { if(!skills.bow.activeSkill) { skills.bow.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 62) { if(!skills.trapping.activeSkill) { skills.trapping.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 54) { if(!skills.fishing.activeSkill) { skills.fishing.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 46) { if(!skills.foraging.activeSkill) { skills.foraging.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 38) { if(!skills.camping.activeSkill) { skills.camping.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 30) { if(!skills.cooking.activeSkill) { skills.cooking.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 28) { if(!skills.lockpick.activeSkill) { skills.lockpick.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 26) { if(!skills.pickpocket.activeSkill) { skills.pickpocket.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 22) { if(!skills.stealth.activeSkill) { skills.stealth.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 20) { if(!skills.entertaining.activeSkill) { skills.entertaining.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 18) { if(!skills.haggling.activeSkill) { skills.haggling.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 16) { if(!skills.decorum.activeSkill) { skills.decorum.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 10) { if(!skills.crafting.activeSkill) { skills.crafting.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 8) { if(!skills.alchemy.activeSkill) { skills.alchemy.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 2) { if(!skills.medicine.activeSkill) { skills.medicine.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 0) { if(!skills.weaponSmith.activeSkill) { skills.weaponSmith.activeSkill = true;  takenSlots++; } }
					break;
				case Hunter:
					if (roll3 > 98) { if(!skills.sword.activeSkill) { skills.sword.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 96) { if(!skills.axe.activeSkill) { skills.axe.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 90) { if(!skills.dagger.activeSkill) { skills.dagger.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 88) { if(!skills.staff.activeSkill) { skills.staff.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 70) { if(!skills.bow.activeSkill) { skills.bow.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 62) { if(!skills.trapping.activeSkill) { skills.trapping.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 54) { if(!skills.fishing.activeSkill) { skills.fishing.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 46) { if(!skills.foraging.activeSkill) { skills.foraging.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 38) { if(!skills.camping.activeSkill) { skills.camping.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 30) { if(!skills.cooking.activeSkill) { skills.cooking.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 28) { if(!skills.lockpick.activeSkill) { skills.lockpick.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 26) { if(!skills.pickpocket.activeSkill) { skills.pickpocket.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 22) { if(!skills.stealth.activeSkill) { skills.stealth.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 20) { if(!skills.entertaining.activeSkill) { skills.entertaining.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 18) { if(!skills.haggling.activeSkill) { skills.haggling.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 16) { if(!skills.decorum.activeSkill) { skills.decorum.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 10) { if(!skills.crafting.activeSkill) { skills.crafting.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 8) { if(!skills.alchemy.activeSkill) { skills.alchemy.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 2) { if(!skills.medicine.activeSkill) { skills.medicine.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 0) { if(!skills.weaponSmith.activeSkill) { skills.weaponSmith.activeSkill = true;  takenSlots++; } }
					break;
				case Sniper:
					if (roll3 > 98) { if(!skills.sword.activeSkill) { skills.sword.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 96) { if(!skills.axe.activeSkill) { skills.axe.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 90) { if(!skills.dagger.activeSkill) { skills.dagger.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 88) { if(!skills.staff.activeSkill) { skills.staff.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 70) { if(!skills.bow.activeSkill) { skills.bow.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 62) { if(!skills.trapping.activeSkill) { skills.trapping.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 54) { if(!skills.fishing.activeSkill) { skills.fishing.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 46) { if(!skills.foraging.activeSkill) { skills.foraging.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 38) { if(!skills.camping.activeSkill) { skills.camping.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 30) { if(!skills.cooking.activeSkill) { skills.cooking.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 28) { if(!skills.lockpick.activeSkill) { skills.lockpick.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 26) { if(!skills.pickpocket.activeSkill) { skills.pickpocket.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 22) { if(!skills.stealth.activeSkill) { skills.stealth.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 20) { if(!skills.entertaining.activeSkill) { skills.entertaining.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 18) { if(!skills.haggling.activeSkill) { skills.haggling.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 16) { if(!skills.decorum.activeSkill) { skills.decorum.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 10) { if(!skills.crafting.activeSkill) { skills.crafting.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 8) { if(!skills.alchemy.activeSkill) { skills.alchemy.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 2) { if(!skills.medicine.activeSkill) { skills.medicine.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 0) { if(!skills.weaponSmith.activeSkill) { skills.weaponSmith.activeSkill = true;  takenSlots++; } }
					break;
					
				case Barbarian:
					if (roll3 > 96) { if(!skills.sword.activeSkill) { skills.sword.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 70) { if(!skills.axe.activeSkill) { skills.axe.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 68) { if(!skills.dagger.activeSkill) { skills.dagger.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 66) { if(!skills.staff.activeSkill) { skills.staff.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 64) { if(!skills.bow.activeSkill) { skills.bow.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 58) { if(!skills.trapping.activeSkill) { skills.trapping.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 52) { if(!skills.fishing.activeSkill) { skills.fishing.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 46) { if(!skills.foraging.activeSkill) { skills.foraging.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 40) { if(!skills.camping.activeSkill) { skills.camping.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 34) { if(!skills.cooking.activeSkill) { skills.cooking.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 32) { if(!skills.lockpick.activeSkill) { skills.lockpick.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 30) { if(!skills.pickpocket.activeSkill) { skills.pickpocket.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 28) { if(!skills.stealth.activeSkill) { skills.stealth.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 24) { if(!skills.entertaining.activeSkill) { skills.entertaining.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 22) { if(!skills.haggling.activeSkill) { skills.haggling.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 20) { if(!skills.decorum.activeSkill) { skills.decorum.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 14) { if(!skills.crafting.activeSkill) { skills.crafting.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 11) { if(!skills.alchemy.activeSkill) { skills.alchemy.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 5) { if(!skills.medicine.activeSkill) { skills.medicine.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 0) { if(!skills.weaponSmith.activeSkill) { skills.weaponSmith.activeSkill = true;  takenSlots++; } }
					break;
				case Berserker:
					if (roll3 > 96) { if(!skills.sword.activeSkill) { skills.sword.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 70) { if(!skills.axe.activeSkill) { skills.axe.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 68) { if(!skills.dagger.activeSkill) { skills.dagger.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 66) { if(!skills.staff.activeSkill) { skills.staff.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 64) { if(!skills.bow.activeSkill) { skills.bow.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 58) { if(!skills.trapping.activeSkill) { skills.trapping.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 52) { if(!skills.fishing.activeSkill) { skills.fishing.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 46) { if(!skills.foraging.activeSkill) { skills.foraging.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 40) { if(!skills.camping.activeSkill) { skills.camping.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 34) { if(!skills.cooking.activeSkill) { skills.cooking.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 32) { if(!skills.lockpick.activeSkill) { skills.lockpick.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 30) { if(!skills.pickpocket.activeSkill) { skills.pickpocket.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 28) { if(!skills.stealth.activeSkill) { skills.stealth.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 24) { if(!skills.entertaining.activeSkill) { skills.entertaining.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 22) { if(!skills.haggling.activeSkill) { skills.haggling.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 20) { if(!skills.decorum.activeSkill) { skills.decorum.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 14) { if(!skills.crafting.activeSkill) { skills.crafting.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 11) { if(!skills.alchemy.activeSkill) { skills.alchemy.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 5) { if(!skills.medicine.activeSkill) { skills.medicine.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 0) { if(!skills.weaponSmith.activeSkill) { skills.weaponSmith.activeSkill = true;  takenSlots++; } }
					break;
				case RedMist:
					if (roll3 > 96) { if(!skills.sword.activeSkill) { skills.sword.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 70) { if(!skills.axe.activeSkill) { skills.axe.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 68) { if(!skills.dagger.activeSkill) { skills.dagger.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 66) { if(!skills.staff.activeSkill) { skills.staff.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 64) { if(!skills.bow.activeSkill) { skills.bow.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 58) { if(!skills.trapping.activeSkill) { skills.trapping.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 52) { if(!skills.fishing.activeSkill) { skills.fishing.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 46) { if(!skills.foraging.activeSkill) { skills.foraging.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 40) { if(!skills.camping.activeSkill) { skills.camping.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 34) { if(!skills.cooking.activeSkill) { skills.cooking.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 32) { if(!skills.lockpick.activeSkill) { skills.lockpick.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 30) { if(!skills.pickpocket.activeSkill) { skills.pickpocket.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 28) { if(!skills.stealth.activeSkill) { skills.stealth.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 24) { if(!skills.entertaining.activeSkill) { skills.entertaining.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 22) { if(!skills.haggling.activeSkill) { skills.haggling.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 20) { if(!skills.decorum.activeSkill) { skills.decorum.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 14) { if(!skills.crafting.activeSkill) { skills.crafting.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 11) { if(!skills.alchemy.activeSkill) { skills.alchemy.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 5) { if(!skills.medicine.activeSkill) { skills.medicine.activeSkill = true;  takenSlots++; } }
					else if (roll3 > 0) { if(!skills.weaponSmith.activeSkill) { skills.weaponSmith.activeSkill = true;  takenSlots++; } }
					break;
					
				}					
			}
		}	

}
