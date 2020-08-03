package com.redhaan.adventurersGalore.entity.adventurer.adventurerFactory;

import java.io.Serializable;
import java.util.Random;

import com.redhaan.adventurersGalore.entity.adventurer.Race;

public class NameFactory implements Serializable {

	private static final long serialVersionUID = 1L;
	String name;
	Random random;
	
	public NameFactory() { 	
		random = new Random();
	}
	
	public String rollName(Race race, String gender) {
	
		name = "Bob Dylan";
		
		switch (race.raceEnum) {		
		case Human: rollHumanName(gender); break;
		case Elf: rollElfName(gender); break;
		case Dwarf: rollDwarfName(gender); break;
		case Dryad: rollDryadName(gender); break;								
		}
				
		return name;
		
	}
	
	private void rollHumanName(String gender) {
		
		int rarityRoll = random.nextInt(10) + 1;
		
		if (rarityRoll == 10) {
			int nameRoll = random.nextInt(10) + 1;
			switch(nameRoll) {
			case 1: if (gender.equals("Male")) { name = "Napoleon"; } else { name = "Cleopatra"; } break;
			case 2: if (gender.equals("Male")) { name = "Julius"; } else { name = "Scully"; } break;
			case 3: if (gender.equals("Male")) { name = "Brigadeiro"; } else { name = "Leia"; } break;
			case 4: if (gender.equals("Male")) { name = "Scipio"; } else { name = "Catniss"; } break;
			case 5: if (gender.equals("Male")) { name = "Hannibal"; } else { name = "Anna Comnena"; } break;
			case 6: if (gender.equals("Male")) { name = "Joffre"; } else { name = "Hermione"; } break;
			case 7: if (gender.equals("Male")) { name = "Bismarck"; } else { name = "Sansa"; } break;
			case 8: if (gender.equals("Male")) { name = "El Cid"; } else { name = "Holly Golightly"; } break;
			case 9: if (gender.equals("Male")) { name = "Hector"; } else { name = "Xena"; } break;
			case 10: if (gender.equals("Male")) { name = "Musashi"; } else { name = "Lorelai"; } break;
			}
		}
		
		else {			
			int nameRoll = random.nextInt(20) + 1;
			switch(nameRoll) {
			case 1: if (gender.equals("Male")) { name = "George"; } else { name = "Lucy"; } break;
			case 2: if (gender.equals("Male")) { name = "Peter"; } else { name = "Catherine"; } break;
			case 3: if (gender.equals("Male")) { name = "Andrew"; } else { name = "Anne"; } break;
			case 4: if (gender.equals("Male")) { name = "John"; } else { name = "Evelyn"; } break;
			case 5: if (gender.equals("Male")) { name = "Stephen"; } else { name = "Julia"; } break;
			case 6: if (gender.equals("Male")) { name = "Richard"; } else { name = "Mary"; } break;
			case 7: if (gender.equals("Male")) { name = "Bruce"; } else { name = "Priscilla"; } break;
			case 8: if (gender.equals("Male")) { name = "Marc"; } else { name = "Tamara"; } break;
			case 9: if (gender.equals("Male")) { name = "Luke"; } else { name = "Erika"; } break;
			case 10: if (gender.equals("Male")) { name = "Thomas"; } else { name = "Valerie"; } break;
			case 11: if (gender.equals("Male")) { name = "Kaito"; } else { name = "Yui"; } break;
			case 12: if (gender.equals("Male")) { name = "Sora"; } else { name = "Mei"; } break;
			case 13: if (gender.equals("Male")) { name = "Haruto"; } else { name = "Sakura"; } break;
			case 14: if (gender.equals("Male")) { name = "Aarav"; } else { name = "Saanvi"; } break;
			case 15: if (gender.equals("Male")) { name = "Aditya"; } else { name = "Prisha"; } break;
			case 16: if (gender.equals("Male")) { name = "Ramvinoth"; } else { name = "Diya"; } break;
			case 17: if (gender.equals("Male")) { name = "Sergei"; } else { name = "Svetlana"; } break;
			case 18: if (gender.equals("Male")) { name = "Ivan"; } else { name = "Olga"; } break;
			case 19: if (gender.equals("Male")) { name = "Dmitri"; } else { name = "Irina"; } break;
			case 20: if (gender.equals("Male")) { name = "Andrei"; } else { name = "Yelena"; } break;			
			}			
		}
				
	}
	
	private void rollElfName(String gender) {
		
		int syllableRoll = random.nextInt(10) + 1;
		int syllables = 0;
		if (syllableRoll > 8) { syllables = 2; }
		else if (syllableRoll > 6) { syllables = 4; }
		else { syllables = 3; }
		
		String tempName = "";
		
		int firstSyllableRoll = random.nextInt(11) + 1;
		switch(firstSyllableRoll) {
		case 1: tempName = tempName + "Hal"; break;
		case 2: tempName = tempName + "Mi"; break;
		case 3: tempName = tempName + "El"; break;
		case 4: tempName = tempName + "Lo"; break;
		case 5: tempName = tempName + "Le"; break;
		case 6: tempName = tempName + "Thran"; break;
		case 7: tempName = tempName + "Tau"; break;
		case 8: tempName = tempName + "Ga"; break;
		case 9: tempName = tempName + "Ar"; break;
		case 10: tempName = tempName + "Lu"; break;
		case 11: tempName = tempName + "I"; break;
		}
		
		int secondSyllableRoll = random.nextInt(11) + 1;
		switch(secondSyllableRoll) {
		case 1: tempName = tempName + "dir"; break;
		case 2: tempName = tempName + "wen"; break;
		case 3: tempName = tempName + "duil"; break;
		case 4: tempName = tempName + "rien"; break;
		case 5: tempName = tempName + "go"; break;
		case 6: tempName = tempName + "rond"; break;
		case 7: tempName = tempName + "riel"; break;
		case 8: tempName = tempName + "la"; break;
		case 9: tempName = tempName + "thran"; break;
		case 10: tempName = tempName + "thien"; break;
		case 11: tempName = tempName + "ser"; break;
		}		
		
		if (syllables > 2) {
			int thirdSyllableRoll = random.nextInt(11) + 1;
			switch(thirdSyllableRoll) {
			case 1: tempName = tempName + "el"; break;
			case 2: tempName = tempName + "eon"; break;
			case 3: tempName = tempName + "sa"; break;
			case 4: tempName = tempName + "ia"; break;
			case 5: tempName = tempName + "dri"; break;
			case 6: tempName = tempName + "dor"; break;
			case 7: tempName = tempName + "a"; break;
			case 8: tempName = tempName + "e"; break;
			case 9: tempName = tempName + "i"; break;
			case 10: tempName = tempName + "to"; break;
			case 11: tempName = tempName + "las"; break;			
			}			
		}
		
		if (syllables > 3) {
			int fourthSyllableRoll = random.nextInt(5) + 1;
			switch (fourthSyllableRoll) {
			case 1: tempName = tempName + "el"; break;
			case 2: tempName = tempName + "min"; break;
			case 3: tempName = tempName + "do"; break;
			case 4: tempName = tempName + "en"; break;
			case 5: tempName = tempName + "yu"; break;
			}
		}
		
		name = tempName;
	}
	
	private void rollDwarfName(String gender) {
		
		int roll = random.nextInt(30) + 1;
		
		switch(roll) {
		case 1: name = "Dain"; break;
		case 2: name = "Gloin"; break;
		case 3: name = "Gimli"; break;
		case 4: name = "Gunna"; break;
		case 5: name = "Ungri"; break;
		case 6: name = "Bimbor"; break;
		case 7: name = "Bronk"; break;
		case 8: name = "Ingli"; break;
		case 9: name = "Dari"; break;
		case 10: name = "Dibrang"; break;
		case 11: name = "Balin"; break;
		case 12: name = "Bifur"; break;
		case 13: name = "Dorin"; break;
		case 14: name = "Dwain"; break;
		case 15: name = "Undwong"; break;
		case 16: name = "Fingar"; break;
		case 17: name = "Falifor"; break;
		case 18: name = "Gifa"; break;
		case 19: name = "Gufi"; break;
		case 20: name = "Karn"; break;
		case 21: name = "Kring"; break;
		case 22: name = "Narwi"; break;
		case 23: name = "Thurng"; break;
		case 24: name = "Bingdor"; break;
		case 25: name = "Daler"; break;
		case 26: name = "Kiraka"; break;
		case 27: name = "Ogri"; break;
		case 28: name = "Ongbur"; break;
		case 29: name = "Rhuin"; break;
		case 30: name = "Urno"; break;
		}
	}
	
	private void rollDryadName(String gender) {
		
		int syllables = random.nextInt(2) + 3;
		String tempName = "";
		
		for (int i = 0; i < syllables; i++) {
			int roll = random.nextInt(15) + 1;
			switch(roll) {
			case 1: if (gender.equals("Male")) { tempName = tempName + "ya"; } else { tempName = tempName + "ye"; } break;
			case 2: if (gender.equals("Male")) { tempName = tempName + "yi"; } else { tempName = tempName + "yo"; } break;
			case 3: if (gender.equals("Male")) { tempName = tempName + "yu"; } else { tempName = tempName + "yu"; } break;
			case 4: if (gender.equals("Male")) { tempName = tempName + "ka"; } else { tempName = tempName + "ke"; } break;
			case 5: if (gender.equals("Male")) { tempName = tempName + "ke"; } else { tempName = tempName + "ko"; } break;
			case 6: if (gender.equals("Male")) { tempName = tempName + "ku"; } else { tempName = tempName + "ku"; } break;
			case 7: if (gender.equals("Male")) { tempName = tempName + "sha"; } else { tempName = tempName + "she"; } break;
			case 8: if (gender.equals("Male")) { tempName = tempName + "she"; } else { tempName = tempName + "sho"; } break;
			case 9: if (gender.equals("Male")) { tempName = tempName + "shu"; } else { tempName = tempName + "shu"; } break;
			case 10: if (gender.equals("Male")) { tempName = tempName + "l"; } else { tempName = tempName + "t"; } break;
			case 11: if (gender.equals("Male")) { tempName = tempName + "l"; } else { tempName = tempName + "t"; } break;
			case 12: if (gender.equals("Male")) { tempName = tempName + "l"; } else { tempName = tempName + "t"; } break;
			case 13: if (gender.equals("Male")) { tempName = tempName + "l"; } else { tempName = tempName + "t"; } break;
			case 14: if (gender.equals("Male")) { tempName = tempName + "l"; } else { tempName = tempName + "t"; } break;
			case 15: if (gender.equals("Male")) { tempName = tempName + "l"; } else { tempName = tempName + "t"; } break;
			}
		}
		
		name = tempName.substring(0, 1).toUpperCase() + tempName.substring(1);
		
	}
	
		
/*		
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
	
		*/
		
		

}
