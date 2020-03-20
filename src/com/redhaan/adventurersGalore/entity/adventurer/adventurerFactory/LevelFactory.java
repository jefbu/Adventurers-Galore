package com.redhaan.adventurersGalore.entity.adventurer.adventurerFactory;

import java.util.Random;

public class LevelFactory {
	
	public LevelFactory() {
		
	}
	
	protected int setBaseLevel(int tier) {
		
		Random random = new Random();
		int level = 0;
		int roll = random.nextInt(100) + 1;
		int roll2 = random.nextInt(10) + 1;
		
		switch(tier) {
		case 0:
			if(roll > 95) { level = 20 + roll2; }
			else if(roll > 80) { level = 10 + roll2; }
			else { level = roll2; }
			break;
		case 1:
			if(roll > 90) { level = 20 + roll2; }
			else if(roll > 70) { level = 10 + roll2; }
			else { level = roll2; }
			break;
		case 2:
			if(roll > 85) { level = 20 + roll2; }
			else if(roll > 60) { level = 10 + roll2; }
			else { level = roll2; }
			break;
		case 3:
			if(roll > 75) { level = 20 + roll2; }
			else if(roll > 50) { level = 10 + roll2; }
			else { level = roll2; }
			break;
		case 4:
			if(roll > 70) { level = 20 + roll2; }
			else if(roll > 40) { level = 10 + roll2; }
			else { level = roll2; }
			break;
		}
		
		return level;
		
	}	
	
}
