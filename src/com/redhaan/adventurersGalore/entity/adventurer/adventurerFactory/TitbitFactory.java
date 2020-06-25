package com.redhaan.adventurersGalore.entity.adventurer.adventurerFactory;

import java.util.Random;

import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;
import com.redhaan.adventurersGalore.entity.adventurer.Titbit;

public class TitbitFactory {
	
	private Random random;
	
	public TitbitFactory() {
		random = new Random();		
	}
	
	
	public Titbit createTitBit(Adventurer adventurer) {
		
		Titbit titbit = new Titbit();
		
		rollHobbies(titbit);
		rollFavouriteFood(titbit);
		rollDislikes(titbit);
		rollOriginStory(titbit, adventurer);
		
		return titbit;
		
	}
	
	
	private void rollHobbies(Titbit titbit) {
		
		for(int i = 0; i < 2; i++) {
			
			int roll = random.nextInt(10);
			
			switch(roll) {
			
			case 0: titbit.strings.add("Likes: Poetry"); break;
			case 1: titbit.strings.add("Likes: Origami"); break;
			case 2: titbit.strings.add("Likes: Gardening"); break;
			case 3: titbit.strings.add("Likes: Going out for drinks"); break;
			case 4: titbit.strings.add("Likes: Fishing"); break;
			case 5: titbit.strings.add("Likes: Gambling on Drakehorse races"); break;
			case 6: titbit.strings.add("Likes: Cooking");
			case 7: int roll2 = random.nextInt(3);
				String sport = "";
				switch(roll2) {
				case 0: sport = "Competitive gymnastics"; break;
				case 1: sport = "Ragby"; break;
				case 2: sport = "Tournament fencing"; break;
				}
					titbit.strings.add("likes: " + sport); break;
			case 8: titbit.strings.add("Likes: Walking and Hiking"); break;
			case 9: titbit.strings.add("Likes: Dozing off in a hangmat in the sun with a cocktail"); break;
			
			}
			
		}

	}
	
	private void rollFavouriteFood(Titbit titbit) {
		
		int roll = random.nextInt(7);
		
		switch(roll) {
		
		case 0: titbit.strings.add("Favourite food: Kobold Steak"); break;
		case 1: titbit.strings.add("Favourite food: Fruits from Syrena"); break;
		case 2: titbit.strings.add("Favourite food: Fish from Vine Island"); break;
		case 3: titbit.strings.add("Favourite food: Tintreach Hot Noodles"); break;
		case 4: titbit.strings.add("Favourite food: Unicorn ribs"); break;
		case 5: titbit.strings.add("Favourite food: Suirach (Parzumak Islands dish made of fermented broccoli and goat milk)");
		case 6: titbit.strings.add("Favourite food: Phoenix Barbecue"); break;
		
		}
		
	}
	
	private void rollDislikes(Titbit titbit) {
		
		int roll = random.nextInt(5);
		
		switch(roll) {
		
		case 0: titbit.strings.add("Can't stand false modesty"); break;
		case 1: titbit.strings.add("Can't stand people whistling tunes in public"); break;
		case 2: titbit.strings.add("Can't stand bureaucracy"); break;
		case 3: titbit.strings.add("Can't stand pompous Disciplian stiffnosed know-it-alls"); break;
		case 4: titbit.strings.add("Can't stand tardiness"); break;
		
		}
		
	}
	
	private void rollOriginStory(Titbit titbit, Adventurer adventurer) {
		
		int roll = random.nextInt(4);
		
		switch(adventurer.job.jobEnum) {
		
		case ArchMage:
			switch(roll) {
			
			}
			break;
		case Archer:
			break;
		case Barbarian:
			break;
		case Berserker:
			break;
		case CatBurglar:
			break;
		case Hunter:
			break;
		case Knave:
			break;
		case Knight:
			break;
		case Mage:
			break;
		case Magus:
			break;
		case Paladin:
			break;
		case RedMist:
			break;
		case Sniper:
			break;
		case Squire:
			break;
		case Thief:
			break;
		default:
			break;
		
		}
		
	}
	
	

}
