package com.redhaan.adventurersGalore.entity.adventurer.adventurerFactory;

import java.util.Random;

import com.redhaan.adventurersGalore.entity.adventurer.Job;
import com.redhaan.adventurersGalore.entity.adventurer.Race;

public class JobFactory {
	
	public JobFactory() { }
	
	
	protected Job setJob(Race race) {
		
		Job job = null;
		Random random = new Random();
		int roll = random.nextInt(100) + 1;
		
		switch(race.raceEnum) {
		
		case Human:
			if (roll > 90) { return Job.barbarian; 	}
			else if (roll > 75) { return Job.archer; }
			else if (roll > 50) { return Job.thief; }
			else if (roll > 25) { return Job.mage; }
			else { return Job.squire; }
			
		case Elf:
			if (roll > 95) { return Job.barbarian; }
			else if (roll > 70) { return Job.archer; }
			else if (roll > 50) { return Job.thief; }
			else if (roll > 25) { return Job.mage; }
			else { return Job.squire; }
			
		case Dwarf:
			if (roll > 75) { return Job.barbarian; }
			else if (roll > 65) { return Job.archer; }
			else if (roll > 55) { return Job.thief; }
			else if (roll > 35) { return Job.mage; }
			else { return Job.squire; }
			
		case Dryad:
			if (roll > 95) { return Job.barbarian; }
			else if (roll > 90) { return Job.archer; }
			else if (roll > 60) { return Job.thief; }
			else if (roll > 30) { return Job.mage; }
			else { return Job.squire; }
		
		}
		
		return job;
		
	}
	
	

}
