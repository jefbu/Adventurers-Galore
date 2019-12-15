package com.redhaan.adventurersGalore.entity.adventurer.adventurerFactory;

import java.util.Random;

import com.redhaan.adventurersGalore.entity.adventurer.Race;

public class NameFactory {
	
	public NameFactory() { }
	
	public String rollName(Race race, String gender) {
		
		String name = "";
		Random random = new Random();
		int syllables = 0;
		
		if (random.nextInt(100) > 90) { name = rollSpecialName(race, gender); }
		else { 	
			syllables = rollSyllables(race);
			
			for (int i = 0; i < syllables; i++) {
				name = name + rollSyllable(race, gender); 
			}
		}
				
		return name;
		
	}
	
	private String rollSpecialName(Race race, String gender) {
		
		String name = "";
		Random random = new Random();
		int roll = random.nextInt(5) + 1;
		
		switch(race.raceEnum) {
		
		case Human:
			switch(roll) {
			case 1: if (gender.equals("Male")) { name = "Napoleon"; } else { name = "Nancy"; } break;
			case 2: if (gender.equals("Male")) { name = "Alexander"; } else { name = "Kelly"; } break;
			case 3: if (gender.equals("Male")) { name = "Joffre"; } else { name = "Shelly"; } break;
			case 4: if (gender.equals("Male")) { name = "Rocky"; } else { name = "Sally"; } break;
			case 5: if (gender.equals("Male")) { name = "Karl"; } else { name = "Shania"; } break;
			}
			break;
		case Elf:
			switch(roll) {
			case 1: if (gender.equals("Male")) { name = "Napoleon"; } else { name = "Nancy"; } break;
			case 2: if (gender.equals("Male")) { name = "Alexander"; } else { name = "Kelly"; } break;
			case 3: if (gender.equals("Male")) { name = "Joffre"; } else { name = "Shelly"; } break;
			case 4: if (gender.equals("Male")) { name = "Rocky"; } else { name = "Sally"; } break;
			case 5: if (gender.equals("Male")) { name = "Karl"; } else { name = "Shania"; } break;
			}
			break;
		case Dwarf:
			switch(roll) {
			case 1: if (gender.equals("Male")) { name = "Napoleon"; } else { name = "Nancy"; } break;
			case 2: if (gender.equals("Male")) { name = "Alexander"; } else { name = "Kelly"; } break;
			case 3: if (gender.equals("Male")) { name = "Joffre"; } else { name = "Shelly"; } break;
			case 4: if (gender.equals("Male")) { name = "Rocky"; } else { name = "Sally"; } break;
			case 5: if (gender.equals("Male")) { name = "Karl"; } else { name = "Shania"; } break;
			}
			break;
		case Dryad:
			switch(roll) {
			case 1: if (gender.equals("Male")) { name = "Napoleon"; } else { name = "Nancy"; } break;
			case 2: if (gender.equals("Male")) { name = "Alexander"; } else { name = "Kelly"; } break;
			case 3: if (gender.equals("Male")) { name = "Joffre"; } else { name = "Shelly"; } break;
			case 4: if (gender.equals("Male")) { name = "Rocky"; } else { name = "Sally"; } break;
			case 5: if (gender.equals("Male")) { name = "Karl"; } else { name = "Shania"; } break;
			}
			break;
		}
		
		return name;
		
	}
	
	private int rollSyllables(Race race) {
		int syllables = 0;
		Random random = new Random();
		int roll = random.nextInt(100) + 1;
		
		switch(race.raceEnum) {
		
		case Human:
			if (roll > 90) { syllables = 4; }
			else if (roll > 65) { syllables = 1; }
			else if (roll > 35) { syllables = 3; }
			else { syllables = 2; } 
			break;
		case Dwarf:
			if (roll > 40) { syllables = 1; }
			else if (roll > 15) { syllables = 2; }
			else if (roll > 5) { syllables = 3; }
			else { syllables = 4; } 
			break;
		case Elf:
			if (roll > 50) { syllables = 4; }
			else if (roll > 20) { syllables = 3; }
			else if (roll > 5) { syllables = 2; }
			else { syllables = 1; } 
			break;
		case Dryad:
			if (roll > 20) { syllables = 3; }
			else if (roll > 10) { syllables = 2; }
			else if (roll > 5) { syllables = 1; }
			else { syllables = 4; } 
			break;
					
		}
				
		return syllables;
	}
	
	private String rollSyllable(Race race, String gender) {
		
		String syllable = "";
		Random random = new Random();
		int roll = random.nextInt(10) + 1;
		
		switch(race.raceEnum) {
		
		case Human:
			
			switch(roll) {
			case 1: if (gender.equals("Male")) { syllable = "man"; } else { syllable = "grid"; } break;
			case 2: if (gender.equals("Male")) { syllable = "her"; } else { syllable = "in"; } break;
			case 3: if (gender.equals("Male")) { syllable = "bert"; } else { syllable = "as"; } break;
			case 4: if (gender.equals("Male")) { syllable = "paul"; } else { syllable = "trid"; } break;
			case 5: if (gender.equals("Male")) { syllable = "tom"; } else { syllable = "leen"; } break;
			case 6: if (gender.equals("Male")) { syllable = "as"; } else { syllable = "cath"; } break;
			case 7: if (gender.equals("Male")) { syllable = "gun"; } else { syllable = "els"; } break;
			case 8: if (gender.equals("Male")) { syllable = "cai"; } else { syllable = "so"; } break;
			case 9: if (gender.equals("Male")) { syllable = "lance"; } else { syllable = "phie"; } break;
			case 10: if (gender.equals("Male")) { syllable = "rick"; } else { syllable = "ann"; } break;
			}
			
			break;
			
		case Dwarf:
			
			switch(roll) {
			case 1: syllable = "thor"; break;
			case 2: syllable = "grund"; break;
			case 3: syllable = "dain"; break;
			case 4: syllable = "borm"; break;
			case 5: syllable = "rud"; break;
			case 6: syllable = "glim"; break;
			case 7: syllable = "moar"; break;
			case 8: syllable = "burns"; break;
			case 9: syllable = "dale"; break;
			case 10: syllable = "uri"; break;
			}
			
			break;
			
		case Elf:
			
			switch(roll) {
			case 1: syllable = "el"; break;
			case 2: syllable = "driel"; break;
			case 3: syllable = "ron"; break;
			case 4: syllable = "dur"; break;
			case 5: syllable = "lego"; break;
			case 6: syllable = "thran"; break;
			case 7: syllable = "luin"; break;
			case 8: syllable = "la"; break;
			case 9: syllable = "ga"; break;
			case 10: syllable = "fawn"; break;
			}
			
			break;
			
		case Dryad:
			
			switch(roll) {
			case 1: if (gender.equals("Male")) { syllable = "yak"; } else { syllable = "yek"; } break;
			case 2: if (gender.equals("Male")) { syllable = "iya"; } else { syllable = "iye"; } break;
			case 3: if (gender.equals("Male")) { syllable = "ma"; } else { syllable = "me"; } break;
			case 4: if (gender.equals("Male")) { syllable = "pra"; } else { syllable = "ple"; } break;
			case 5: if (gender.equals("Male")) { syllable = "ahr"; } else { syllable = "ehr"; } break;
			case 6: if (gender.equals("Male")) { syllable = "shan"; } else { syllable = "shen"; } break;
			case 7: if (gender.equals("Male")) { syllable = "rack"; } else { syllable = "reck"; } break;
			case 8: if (gender.equals("Male")) { syllable = "at"; } else { syllable = "et"; } break;
			case 9: if (gender.equals("Male")) { syllable = "aum"; } else { syllable = "eim"; } break;
			case 10: if (gender.equals("Male")) { syllable = "kua"; } else { syllable = "kie"; } break;
			}
			
			break;
		
		}
		
		
		return syllable;
		
	}
	
	

}
