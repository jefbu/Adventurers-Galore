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
		rollMillionDollar(titbit);
		rollLifeMotto(titbit);

		return titbit;

	}

	private void rollHobbies(Titbit titbit) {

		for (int i = 0; i < 2; i++) {

			int roll = random.nextInt(10);

			switch (roll) {

			case 0:
				titbit.strings.add("Likes: Poetry");
				break;
			case 1:
				titbit.strings.add("Likes: Origami");
				break;
			case 2:
				titbit.strings.add("Likes: Gardening");
				break;
			case 3:
				titbit.strings.add("Likes: Going out for drinks");
				break;
			case 4:
				titbit.strings.add("Likes: Fishing");
				break;
			case 5:
				titbit.strings.add("Likes: Gambling on Drakehorse races");
				break;
			case 6:
				titbit.strings.add("Likes: Cooking");
			case 7:
				int roll2 = random.nextInt(3);
				String sport = "";
				switch (roll2) {
				case 0:
					sport = "Competitive gymnastics";
					break;
				case 1:
					sport = "Ragby";
					break;
				case 2:
					sport = "Tournament fencing";
					break;
				}
				titbit.strings.add("likes: " + sport);
				break;
			case 8:
				titbit.strings.add("Likes: Walking and Hiking");
				break;
			case 9:
				titbit.strings.add("Likes: Dozing off in a hangmat in the sun with a cocktail");
				break;

			}

		}

	}

	private void rollFavouriteFood(Titbit titbit) {

		int roll = random.nextInt(7);

		switch (roll) {

		case 0:
			titbit.strings.add("Favourite food: Kobold Steak");
			break;
		case 1:
			titbit.strings.add("Favourite food: Fruits from Syrena");
			break;
		case 2:
			titbit.strings.add("Favourite food: Fish from Vine Island");
			break;
		case 3:
			titbit.strings.add("Favourite food: Tintreach Hot Noodles");
			break;
		case 4:
			titbit.strings.add("Favourite food: Unicorn ribs");
			break;
		case 5:
			titbit.strings
					.add("Favourite food: Suirach (Parzumak Islands dish made of fermented broccoli and goat milk)");
		case 6:
			titbit.strings.add("Favourite food: Phoenix Barbecue");
			break;

		}

	}

	private void rollDislikes(Titbit titbit) {

		int roll = random.nextInt(5);

		switch (roll) {

		case 0:
			titbit.strings.add("Can't stand false modesty");
			break;
		case 1:
			titbit.strings.add("Can't stand people whistling tunes in public");
			break;
		case 2:
			titbit.strings.add("Can't stand bureaucracy");
			break;
		case 3:
			titbit.strings.add("Can't stand pompous Disciplian stiffnosed know-it-alls");
			break;
		case 4:
			titbit.strings.add("Can't stand tardiness");
			break;

		}

	}

	private void rollOriginStory(Titbit titbit, Adventurer adventurer) {

		int roll = random.nextInt(2);

		switch (adventurer.job.jobEnum) {
		
		case Squire:
			switch(roll) {
			case 0:
				titbit.strings.add("Sold to a lecherous drunkard knight in their puberty, eloped soon after");
				break;
			case 1:
				titbit.strings.add("Used to be a mercenary, distinction in battle opened up a more noble career");
				break;
			}
		break;
		case Knight:
			switch(roll) {
			case 0:
				titbit.strings.add("Sold to a lecherous drunkard knight in their puberty, eloped soon after");
				break;
			case 1:
				titbit.strings.add("Used to be a mercenary, distinction in battle opened up a more noble career");
				break;
			}
		break;
		case Paladin:
			switch(roll) {
			case 0:
				titbit.strings.add("Sold to a lecherous drunkard knight in their puberty, eloped soon after");
				break;
			case 1:
				titbit.strings.add("Used to be a mercenary, distinction in battle opened up a more noble career");
				break;
			}
		break;

		case Mage:
			switch (roll) {
			case 0: 
				titbit.strings.add("Discovered a passion for the arcane when reading an almanac as a child. Enrolled in Disciplia's mage school soon after"); 
				break;
			case 1:
				titbit.strings.add("Naturally talented from early childhood, a wandering hedge mage dsicovered this rough diamond");
				break;
			}
		break;
		case Magus:
			switch (roll) {
			case 0: 
					titbit.strings.add("Discovered a passion for the arcane when reading an almanac as a child. Enrolled in Disciplia's mage school soon after"); 
					break;
			case 1:
					titbit.strings.add("Naturally talented from early childhood, a wandering hedge mage dsicovered this rough diamond");
					break;
			}
		break;
		case ArchMage:
			switch (roll) {
			case 0: 
				titbit.strings.add("Discovered a passion for the arcane when reading an almanac as a child. Enrolled in Disciplia's mage school soon after"); 
				break;
			case 1:
				titbit.strings.add("Naturally talented from early childhood, a wandering hedge mage dsicovered this rough diamond");
				break;
			}
		break;
		
		case Thief:
			switch(roll) {
			case 0: 
				titbit.strings.add("Parents died while still a child, lack of social support left pretty much only one career option open");
				break;
			case 1:
				titbit.strings.add("Work twelve hours a day for a measly wage you still owe taxes on? No thanks, I'll just take from life what I deserve");
				break;
			}
		break;
		case Knave:
			switch(roll) {
			case 0: 
				titbit.strings.add("Parents died while still a child, lack of social support left pretty much only one career option open");
				break;
			case 1:
				titbit.strings.add("Work twelve hours a day for a measly wage you still owe taxes on? No thanks, I'll just take from life what I deserve");
				break;
			}
		break;		
		case CatBurglar:
			switch(roll) {
			case 0: 
				titbit.strings.add("Parents died while still a child, lack of social support left pretty much only one career option open");
				break;
			case 1:
				titbit.strings.add("Work twelve hours a day for a measly wage you still owe taxes on? No thanks, I'll just take from life what I deserve");
				break;
			}
		break;		

		case Barbarian:
			switch(roll) {
			case 0:
				titbit.strings.add("Some people are good at math. Some at swimming. Some are good at poetry. Others at wielding a massive axe");
				break;
			case 1:
				titbit.strings.add("Started out as a mercenary. But then coin got turned into carousing and rambunctiousness over and over again");
				break;
			}
		break;
		case Berserker:
			switch(roll) {
			case 0:
				titbit.strings.add("Some people are good at math. Some at swimming. Some are good at poetry. Others at wielding a massive axe");
				break;
			case 1:
				titbit.strings.add("Started out as a mercenary. But then coin got turned into carousing and rambunctiousness over and over again");
				break;
			}
		break;
		case RedMist:
			switch(roll) {
			case 0:
				titbit.strings.add("Some people are good at math. Some at swimming. Some are good at poetry. Others at wielding a massive axe");
				break;
			case 1:
				titbit.strings.add("Started out as a mercenary. But then coin got turned into carousing and rambunctiousness over and over again");
				break;
			}
		break;
				
		case Archer:
			switch(roll) {
			case 0:
				titbit.strings.add("Fascinated as a child by the stories of the nobly rascal bow and arrow rake, play belief eventually turned into a job");
				break;
			case 1:
				titbit.strings.add("For the naturally talented with the bow, there's good money to be made at local tournaments");
				break;
			}
		break;
		case Hunter:
			switch(roll) {
			case 0:
				titbit.strings.add("Fascinated as a child by the stories of the nobly rascal bow and arrow rake, play belief eventually turned into a job");
				break;
			case 1:
				titbit.strings.add("For the naturally talented with the bow, there's good money to be made at local tournaments");
				break;
			}
		break;
		case Sniper:
			switch(roll) {
			case 0:
				titbit.strings.add("Fascinated as a child by the stories of the nobly rascal bow and arrow rake, play belief eventually turned into a job");
				break;
			case 1:
				titbit.strings.add("For the naturally talented with the bow, there's good money to be made at local tournaments");
				break;
			}
		break;
		
		}

	}

	private void rollMillionDollar(Titbit titbit) {
		
		int roll = random.nextInt(4);
		
		switch(roll) {
		
		case 0: titbit.strings.add("What would you do if you had 1,000,000$? Buy a cottage in the country for my mama"); break;
		case 1: titbit.strings.add("What would you do if you had 1,000,000$? "
				+ "Live life to the fullest. Parties, depravity, intoxication. Sodom and Gomorrah!"); break;
		case 2: titbit.strings.add("What would you do if you had 1,000,000$? Retire from adventuring. Be an angel investor in some startups"); break;
		case 3: titbit.strings.add("What would you do if you had 1,000,000$? I like what I do, so pretty much the same. I'd get a new weapon though"); break;
		
		}
	}

	private void rollLifeMotto(Titbit titbit) {

		int roll = random.nextInt(10);

		switch (roll) {

		case 0:
			titbit.strings.add("Life motto: 'It is better to be the judge between two enemies, than two friends. "
					+ "For one of the enemies will become a friend, whereas one of the friends will become an enemy'");
			break;
		case 1:
			titbit.strings.add("Life motto: 'Most problems will solve themselves if you ignore them long enough'");
			break;
		case 2:
			titbit.strings.add("Life motto: 'Life's a puzzle, it all goes back in the box in the end'");
			break;
		case 3:
			titbit.strings
					.add("Life motto: 'If you look at it from the universe's perspective, life is pretty meaningless'");
			break;
		case 4:
			titbit.strings.add("Life motto: 'Never look further ahead in life than your next meal'");
			break;
		case 5:
			titbit.strings.add("Life motto: 'Reality is a bore'");
			break;
		case 6:
			titbit.strings.add("Life motto: 'When you lack talent, compensate with entertainment'");
			break;
		case 7:
			titbit.strings.add("Life motto: 'On this long and winding road, the only one that can follow me, is me'");
			break;
		case 8:
			titbit.strings.add(
					"Life motto: 'Shame is like a disease the body can rid itself of with time. Glorious death on the other hand, is forever'");
			break;
		case 9:
			titbit.strings.add("Life motto: I've got some beer in the back of my truck'");
			break;

		}

	}

}
