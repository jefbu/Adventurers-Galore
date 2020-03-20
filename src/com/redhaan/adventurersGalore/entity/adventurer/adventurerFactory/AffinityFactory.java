package com.redhaan.adventurersGalore.entity.adventurer.adventurerFactory;

import java.util.Random;

import com.redhaan.adventurersGalore.entity.adventurer.Affinities;
import com.redhaan.adventurersGalore.entity.adventurer.Job;
import com.redhaan.adventurersGalore.entity.adventurer.Race;

public class AffinityFactory {
	
	Random random;
	
	public AffinityFactory() {
		random = new Random();
	}
	
	
	public Affinities rollAffinities(int tier, Race race, Job job) {
		
		Affinities affinities  = new Affinities();
		int roll = random.nextInt(3);
		
		switch(job.jobEnum) {
		
		case Squire: affinities.white += 5; break;
		case Knight: affinities.white += 5; affinities.yellow += 5; break;
		case Paladin: affinities.white += 5; affinities.yellow += 10; break;
		
		case Mage: affinities.red += 5; affinities.green += 5; affinities.blue += 5; break;
		case Magus: affinities.red += 5; affinities.green += 5; affinities.blue += 5; 
			if(roll == 0) { affinities.red += 5; }
			else if (roll == 1) { affinities.green += 5; }
			else { affinities.red += 5; }
			break;
		case ArchMage: affinities.red += 10; affinities.green += 10; affinities.blue += 10; 
			if(roll == 0) { affinities.red += 5; }
			else if (roll == 1) { affinities.green += 5; }
			else { affinities.red += 5; }		
			break;

		case Thief: break;
		case Knave: affinities.brown += 5; break;
		case CatBurglar: affinities.brown += 5; break;
		
		case Archer: break;
		case Hunter: break;
		case Sniper: break;
		
		case Barbarian: affinities.red += 5; break;
		case Berserker: affinities.red += 5; break;
		case RedMist: affinities.red += 10; affinities.black += 5; break;
			
		}
		
		switch(race.raceEnum) {
		
		case Human: break;
		case Elf: affinities.green += 10; break;
		case Dwarf: affinities.red += 5; affinities.yellow += 5; affinities.brown += 5; break;
		case Dryad: affinities.teal += 5; affinities.green += 10; affinities.brown += 5; affinities.purple += 5; break;
		
		}
		
		int roll1 = random.nextInt(100) + 1;
		int bonusAffinities = 0;
		
		switch(tier) {
		
		case 0:
			if (roll1 > 95) { bonusAffinities = 8; }
			else if (roll1 > 90) { bonusAffinities = 7; }
			else if (roll1 > 85) { bonusAffinities = 6; }
			else if (roll1 > 80) { bonusAffinities = 5; }
			else if (roll1 > 70) { bonusAffinities = 4; }
			else if (roll1 > 60) { bonusAffinities = 3; }
			else if (roll1 > 50) { bonusAffinities = 2; }
			else if (roll1 > 30) { bonusAffinities = 1; }
			else { bonusAffinities = 0; }
			break;
		case 1:
			if (roll1 > 90) { bonusAffinities = 8; }
			else if (roll1 > 85) { bonusAffinities = 7; }
			else if (roll1 > 80) { bonusAffinities = 6; }
			else if (roll1 > 70) { bonusAffinities = 5; }
			else if (roll1 > 60) { bonusAffinities = 4; }
			else if (roll1 > 50) { bonusAffinities = 3; }
			else if (roll1 > 40) { bonusAffinities = 2; }
			else if (roll1 > 20) { bonusAffinities = 1; }
			else { bonusAffinities = 0; }
			break;
		case 2:
			if (roll1 > 90) { bonusAffinities = 8; }
			else if (roll1 > 80) { bonusAffinities = 7; }
			else if (roll1 > 70) { bonusAffinities = 6; }
			else if (roll1 > 60) { bonusAffinities = 5; }
			else if (roll1 > 50) { bonusAffinities = 4; }
			else if (roll1 > 40) { bonusAffinities = 3; }
			else if (roll1 > 30) { bonusAffinities = 2; }
			else if (roll1 > 20) { bonusAffinities = 1; }
			else { bonusAffinities = 0; }
			break;
		case 3:
			if (roll1 > 90) { bonusAffinities = 8; }
			else if (roll1 > 80) { bonusAffinities = 7; }
			else if (roll1 > 70) { bonusAffinities = 6; }
			else if (roll1 > 60) { bonusAffinities = 5; }
			else if (roll1 > 40) { bonusAffinities = 4; }
			else if (roll1 > 30) { bonusAffinities = 3; }
			else if (roll1 > 20) { bonusAffinities = 2; }
			else if (roll1 > 10) { bonusAffinities = 1; }
			else { bonusAffinities = 0; }
			break;
		case 4:
			if (roll1 > 85) { bonusAffinities = 8; }
			else if (roll1 > 75) { bonusAffinities = 7; }
			else if (roll1 > 65) { bonusAffinities = 6; }
			else if (roll1 > 50) { bonusAffinities = 5; }
			else if (roll1 > 30) { bonusAffinities = 4; }
			else if (roll1 > 20) { bonusAffinities = 3; }
			else if (roll1 > 10) { bonusAffinities = 2; }
			else if (roll1 > 5) { bonusAffinities = 1; }
			else { bonusAffinities = 0; }
			break;
				
		}
		
		for (int i = 0; i < bonusAffinities; i++) {
			
			int rollRandomAffinity = random.nextInt(9);
			
			switch(rollRandomAffinity) {
			case 0: affinities.white += 5; break;
			case 1: affinities.yellow += 5; break;
			case 2: affinities.teal += 5; break;
			case 3: affinities.red += 5; break;
			case 4: affinities.green += 5; break;
			case 5: affinities.blue += 5; break;
			case 6: affinities.brown += 5; break;
			case 7: affinities.purple += 5; break;
			case 8: affinities.black += 5; break;
			}
			
		}
	
		return affinities;		
		
	}

}
