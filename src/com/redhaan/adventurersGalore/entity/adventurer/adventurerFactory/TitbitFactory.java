package com.redhaan.adventurersGalore.entity.adventurer.adventurerFactory;

import java.io.Serializable;
import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;
import com.redhaan.adventurersGalore.entity.adventurer.Titbit;

public class TitbitFactory implements Serializable {

	private static final long serialVersionUID = 1L;
	private Random random;

	public TitbitFactory() {
		random = new Random();
	}

	public Titbit createTitBit(Adventurer adventurer) {

		Titbit titbit = new Titbit();

		rollHobbies(titbit);
		rollFavouriteFood(titbit);
		rollFavouriteSong(titbit);
		rollDislikes(titbit);
		rollOriginStory(titbit, adventurer);
		rollMillionDollar(titbit);
		rollLifeMotto(titbit);
		rollRobotTorfs(titbit);
		rollIdiosynchracy(titbit);

		return titbit;

	}

	private void rollHobbies(Titbit titbit) {

		for (int i = 0; i < 2; i++) {

			int roll = random.nextInt(20);

			switch (roll) {

			case 0: titbit.strings.add("Likes: Poetry"); break;
			case 1: titbit.strings.add("Likes: Origami"); break;
			case 2: titbit.strings.add("Likes: Gardening"); break;
			case 3: titbit.strings.add("Likes: Going out for drinks"); break;
			case 4: titbit.strings.add("Likes: Fishing"); break;
			case 5: titbit.strings.add("Likes: Gambling on Drakehorse races"); break;
			case 6: titbit.strings.add("Likes: Cooking"); break;
			case 7: titbit.strings.add("Likes: Gymnastics, particularly the Horizontal Bar"); break;
			case 8: titbit.strings.add("Likes: Walking and Hiking"); break;
			case 9: titbit.strings.add("Likes: Dozing off in a hangmat in the sun with a cocktail"); break;
			case 10: titbit.strings.add("Likes: Making handcrafted furniture"); break;
			case 11: titbit.strings.add("Likes: Wine tasting and collecting"); break;
			case 12: titbit.strings.add("Likes: Board Game evenings with the family"); break;
			case 13: titbit.strings.add("Likes: The Opera (at least they pretend they do)"); break;
			case 14: titbit.strings.add("Likes: Coaching a children's football team"); break;
			case 15: titbit.strings.add("Likes: Watching the neighbourhood from their window"); break;
			case 16: titbit.strings.add("Likes: Casual dating"); break;
			case 17: titbit.strings.add("Likes: A few drinks too many"); break;
			case 18: titbit.strings.add("Likes: Reading pretentious non-fiction stuff"); break;
			case 19: titbit.strings.add("Likes: Nothing. Has a hole where their heart used to be"); break;


			}

		}

	}

	private void rollFavouriteFood(Titbit titbit) {

		int roll = random.nextInt(10);

		switch (roll) {

		case 0: titbit.strings.add("Favourite food: Kobold Steak"); break;
		case 1: titbit.strings.add("Favourite food: Fruits from Syrena"); break;
		case 2: titbit.strings.add("Favourite food: Fish from Vine Island"); break;
		case 3: titbit.strings.add("Favourite food: Tintreach Hot Noodles"); break;
		case 4: titbit.strings.add("Favourite food: Unicorn ribs"); break;
		case 5: titbit.strings.add("Favourite food: Suirach (Parzumak Islands dish made of fermented broccoli and goat milk)"); break;
		case 6: titbit.strings.add("Favourite food: Phoenix Barbecue"); break;
		case 7: titbit.strings.add("Favourite food: Kaghak Fried Centaur"); break;
		case 8: titbit.strings.add("Favourite food: Captain Ymvernu Merman Fingers"); break;
		case 9: titbit.strings.add("Favourite food: Caesar Salad?!"); break;


		}

	}
	
	private void rollFavouriteSong(Titbit titbit) {
		
		int roll = random.nextInt(10);
		
		switch(roll) {
		
		case 0: titbit.strings.add("Favourite song: yattl yiyu lltyitlyu (it's a Dryad song, look it up)"); break;
		case 1: titbit.strings.add("Favourite song: There's some Gnomes in this House"); break;
		case 2: titbit.strings.add("Favourite song: My Halfling will go on"); break;
		case 3: titbit.strings.add("Favourite song: I've got some beer in the back of my truck by Michael Hartigan"); break;
		case 4: titbit.strings.add("Favourite song: I am a Roc, I am a Naiad"); break;
		case 5: titbit.strings.add("Favourite song: Purple Faun"); break;
		case 6: titbit.strings.add("Favourite song: You've got that Goblin reeling"); break;
		case 7: titbit.strings.add("Favourite song: Pixie Nymph (is not my lover)"); break;
		case 8: titbit.strings.add("Favourite song: Hotel Cockatrice"); break;
		case 9: titbit.strings.add("Favourite song: Dancing Undine"); break;

		
		}
		
	}
	

	private void rollDislikes(Titbit titbit) {

		int roll = random.nextInt(8);

		switch (roll) {

		case 0: titbit.strings.add("Can't stand false modesty"); break;
		case 1: titbit.strings.add("Can't stand people whistling in public"); break;
		case 2: titbit.strings.add("Can't stand bureaucracy"); break;
		case 3: titbit.strings.add("Can't stand pompous Disciplian stiffnosed know-it-alls"); break;
		case 4: titbit.strings.add("Can't stand tardiness"); break;
		case 5: titbit.strings.add("Can't stand ortographic mistakes"); break;
		case 6: titbit.strings.add("Can't stand Suirach (Parzumak Islands dish made of fermented broccoli and goat milk)"); break;
		case 7: titbit.strings.add("Can't stand craft beers"); break;


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
		
		case SummonedSkeleton:
			break;
		
		}

	}

	private void rollMillionDollar(Titbit titbit) {
		
		int roll = random.nextInt(4);
		
		switch(roll) {
		
		case 0: titbit.strings.add("'What would you do if you had 1,000,000$?' 'Buy a cottage in the country for my mama'"); break;
		case 1: titbit.strings.add("'What would you do if you had 1,000,000$?' "
				+ "'Live life to the fullest. Parties, depravity, intoxication. Sodom and Gomorrah!'"); break;
		case 2: titbit.strings.add("'What would you do if you had 1,000,000$?' 'Retire from adventuring. Be an angel investor in some startups'"); break;
		case 3: titbit.strings.add("'What would you do if you had 1,000,000$?' 'I like what I do, so pretty much the same. I'd get a new weapon though'"); break;
		
		}
	}

	private void rollLifeMotto(Titbit titbit) {

		int roll = random.nextInt(12);

		switch (roll) {

		case 0: titbit.strings.add("Life motto: 'First time right is an oxymoron'"); break;
		case 1: titbit.strings.add("Life motto: 'Most problems will solve themselves if you ignore them long enough'"); break;
		case 2: titbit.strings.add("Life motto: 'What you lack in talent, can be compensated with entertainment'"); break;
		case 3: titbit.strings.add("Life motto: 'Never reward those that are late'"); break;
		case 4: titbit.strings.add("Life motto: 'What you lack in entertainment, can be compensated with volume'"); break;
		case 5: titbit.strings.add("Life motto: 'Failure is not the end'"); break;
		case 6: titbit.strings.add("Life motto: 'More is more'"); break;
		case 7: titbit.strings.add("Life motto: 'Less is less'"); break;
		case 8: titbit.strings.add("Life motto: 'Love is weaker than logistics'"); break;
		case 9: titbit.strings.add("Life motto: 'The wish is the basis for the thought'"); break;
		case 10: titbit.strings.add("Life motto: 'Take desire in one hand, and nothing in the other. Mix the two together and see what's left'"); break;
		case 11: titbit.strings.add("Life motto: 'Never point out a pun. Those who didn't see it won't laugh, and those who did won't anymore'"); break;


		}
	}
	
	private void rollRobotTorfs(Titbit titbit) {

		int roll = random.nextInt(20);

		switch (roll) {

		case 0: titbit.strings.add("Drunk wisom (maybe?): 'To live in a clean environment. Arguments used to.'"); break;
		case 1: titbit.strings.add("Drunk wisom (maybe?): 'Indignation is sadly often but replacing old preferences with new ones.'"); break;
		case 2: titbit.strings.add("Drunk wisom (maybe?): 'The limits of enjoying life. But I won't. I will just do as I please'"); break;
		case 3: titbit.strings.add("Drunk wisom (maybe?): 'The biggest strength of leadership is the heart to be a leader.'"); break;
		case 4: titbit.strings.add("Drunk wisom (maybe?): 'Temperance is beautiful. But it ends where temperance starts.'"); break;
		case 5: titbit.strings.add("Drunk wisom (maybe?): 'Life is the art of changing.'"); break;
		case 6: titbit.strings.add("Drunk wisom (maybe?): 'A warm political party protects the mistrust above the knife in the back.'"); break;
		case 7: titbit.strings.add("Drunk wisom (maybe?): 'Striving for failure does not make happy.'"); break;
		case 8: titbit.strings.add("Drunk wisom (maybe?): 'For example, pretend to be affronted. There will always be someone with a symbol.'"); break;
		case 9: titbit.strings.add("Drunk wisom (maybe?): 'Those who are always afraid will never be it anymore.'"); break;
		case 10: titbit.strings.add("Drunk wisom (maybe?): 'Those who follow their ideals are bad politicians. Those who haven't got any also.'"); break;
		case 11: titbit.strings.add("Drunk wisom (maybe?): 'If I was a ghost, I'd be Frank.'"); break;
		case 12: titbit.strings.add("Drunk wisom (maybe?): 'The real conversation starts when feigned morality wins.'"); break;
		case 13: titbit.strings.add("Drunk wisom (maybe?): 'Sustainability is the photo album that pierces the room.'"); break;
		case 14: titbit.strings.add("Drunk wisom (maybe?): 'Predictable ideas boost our self esteem.'"); break;
		case 15: titbit.strings.add("Drunk wisom (maybe?): 'To grow older is rarely to know more. Only to know more humans who know less.'"); break;
		case 16: titbit.strings.add("Drunk wisom (maybe?): 'I love people that are reasonable. As long as they don't always behave that way.'"); break;
		case 17: titbit.strings.add("Drunk wisom (maybe?): 'If we wait too long to cherish a few ideas, they risk becoming many.'"); break;
		case 18: titbit.strings.add("Drunk wisom (maybe?): 'There are two guilty. Those that do, and those that tolerate.'"); break;
		case 19: titbit.strings.add("Drunk wisom (maybe?): 'Urgency is an immediate problem.'"); break;




		}
	}
	
	private void rollIdiosynchracy(Titbit titbit) {
		
		int roll = random.nextInt(5);
		
		switch (roll) {
		
		case 0: titbit.strings.add("Was born with an extra toe"); break;
		case 1: titbit.strings.add("Has perfect absolute pitch hearing"); break;
		case 2: titbit.strings.add("Has an unusually large family"); break;
		case 3: titbit.strings.add("Has exceptionally large feet"); break;
		case 4: titbit.strings.add("Was born on new year's eve just after midnight"); break;
		
		}
		
	}
	
	

}
