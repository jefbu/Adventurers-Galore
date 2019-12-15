package com.redhaan.adventurersGalore.entity.adventurer.adventurerFactory;

import java.util.Random;

import com.redhaan.adventurersGalore.entity.adventurer.Job;
import com.redhaan.adventurersGalore.entity.adventurer.Race;

public class JobFactory {
	
	public JobFactory() { }
	
	
	protected Job setJob(Race race, int level) {
		
		Job job = null;
		Random random = new Random();
		int roll = random.nextInt(100) + 1;
		
		switch(race.raceEnum) {
		
		case Human:
			if (roll > 90) {
				if (level > 20) { job = Job.redMist; }
				else if (level > 10) { job = Job.berserker; }
				else { job = Job.barbarian; }
			}
			else if (roll > 75) {
				if (level > 20) { job = Job.sniper; }
				else if (level > 10) { job = Job.hunter; }
				else { job = Job.archer; }
			}
			else if (roll > 50) {
				if (level > 20) { job = Job.catBurglar; }
				else if (level > 10) { job = Job.knave; }
				else { job = Job.thief; }
			}
			else if (roll > 25) {
				if (level > 20) { job = Job.archMage; }
				else if (level > 10) { job = Job.magus; }
				else { job = Job.mage; }
			}
			else {
				if (level > 20) { job = Job.paladin; }
				else if (level > 10) { job = Job.knight; }
				else { job = Job.squire; }
			}
			break;
			
		case Elf:
			if (roll > 95) {
				if (level > 20) { job = Job.redMist; }
				else if (level > 10) { job = Job.berserker; }
				else { job = Job.barbarian; }
			}
			else if (roll > 70) {
				if (level > 20) { job = Job.sniper; }
				else if (level > 10) { job = Job.hunter; }
				else { job = Job.archer; }
			}
			else if (roll > 50) {
				if (level > 20) { job = Job.catBurglar; }
				else if (level > 10) { job = Job.knave; }
				else { job = Job.thief; }
			}
			else if (roll > 25) {
				if (level > 20) { job = Job.archMage; }
				else if (level > 10) { job = Job.magus; }
				else { job = Job.mage; }
			}
			else {
				if (level > 20) { job = Job.paladin; }
				else if (level > 10) { job = Job.knight; }
				else { job = Job.squire; }
			}
			break;
			
		case Dwarf:
			if (roll > 75) {
				if (level > 20) { job = Job.redMist; }
				else if (level > 10) { job = Job.berserker; }
				else { job = Job.barbarian; }
			}
			else if (roll > 65) {
				if (level > 20) { job = Job.sniper; }
				else if (level > 10) { job = Job.hunter; }
				else { job = Job.archer; }
			}
			else if (roll > 55) {
				if (level > 20) { job = Job.catBurglar; }
				else if (level > 10) { job = Job.knave; }
				else { job = Job.thief; }
			}
			else if (roll > 35) {
				if (level > 20) { job = Job.archMage; }
				else if (level > 10) { job = Job.magus; }
				else { job = Job.mage; }
			}
			else {
				if (level > 20) { job = Job.paladin; }
				else if (level > 10) { job = Job.knight; }
				else { job = Job.squire; }
			}
			break;
			
		case Dryad:
			if (roll > 95) {
				if (level > 20) { job = Job.redMist; }
				else if (level > 10) { job = Job.berserker; }
				else { job = Job.barbarian; }
			}
			else if (roll > 90) {
				if (level > 20) { job = Job.sniper; }
				else if (level > 10) { job = Job.hunter; }
				else { job = Job.archer; }
			}
			else if (roll > 60) {
				if (level > 20) { job = Job.catBurglar; }
				else if (level > 10) { job = Job.knave; }
				else { job = Job.thief; }
			}
			else if (roll > 30) {
				if (level > 20) { job = Job.archMage; }
				else if (level > 10) { job = Job.magus; }
				else { job = Job.mage; }
			}
			else {
				if (level > 20) { job = Job.paladin; }
				else if (level > 10) { job = Job.knight; }
				else { job = Job.squire; }
			}
			break;
		
		}
		
		return job;
		
	}
	
	

}
