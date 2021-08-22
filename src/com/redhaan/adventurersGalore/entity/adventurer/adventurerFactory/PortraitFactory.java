package com.redhaan.adventurersGalore.entity.adventurer.adventurerFactory;

import java.util.Random;

import com.redhaan.adventurersGalore.entity.adventurer.Portrait;
import com.redhaan.adventurersGalore.entity.adventurer.Race;

public class PortraitFactory {
	
	private Random random;
	
	public PortraitFactory() {
		
		random = new Random();
		
	}
	
	protected Portrait rollPortrait(String gender, int age, Race race) {
		
		Portrait portrait = new Portrait();
			
			portrait.skinX = random.nextInt(12);
			if (race == Race.dwarf && portrait.skinX % 3 == 0) { portrait.skinX = random.nextInt(12); }
			portrait.skinY = 0;
			int skinModifier = portrait.skinX / 3;
			portrait.earX = random.nextInt(2);
				if (race == Race.elf) { portrait.earX += 17; }
			portrait.earY = 1 + skinModifier;
			portrait.mouthX = random.nextInt(3);
			portrait.mouthY = 5 + skinModifier;
			portrait.noseX = random.nextInt(3);
			portrait.noseY = 9 + skinModifier;
			portrait.eyesX = random.nextInt(7);
			portrait.eyesY = 13 + skinModifier;
			portrait.hairX = random.nextInt(12);
			portrait.hairY = 17 + skinModifier;
			if (race == Race.dwarf) { portrait.mouthX = 16 + portrait.hairX % 4; }
					
		
		return portrait;
		
	}
	
	
	

}
