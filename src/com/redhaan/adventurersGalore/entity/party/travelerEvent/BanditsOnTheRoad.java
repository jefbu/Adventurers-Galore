package com.redhaan.adventurersGalore.entity.party.travelerEvent;

import java.util.ArrayList;
import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameState;
import com.redhaan.adventurersGalore.combat.Combat;
import com.redhaan.adventurersGalore.combat.CombatMapRoller;
import com.redhaan.adventurersGalore.combat.CombatPhase;
import com.redhaan.adventurersGalore.combat.combatAI.HighLevelPlan;
import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;
import com.redhaan.adventurersGalore.entity.enemies.Pirate;
import com.redhaan.adventurersGalore.entity.party.Party;
import com.redhaan.adventurersGalore.worldMap.WorldMap;
import com.redhaan.adventurersGalore.worldMap.WorldMapTiles;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.Image;

public class BanditsOnTheRoad extends TravelerEvent {

	private static final long serialVersionUID = 1L;
	String optionAConclusion;
	
	ArrayList<String> warners;
	Random random;
	
	public BanditsOnTheRoad() {
		
		eventImage = new Image("/banditsOnTheRoad.png");
		
		warners = new ArrayList<String>();
		
		for (Adventurer adventurer: GameManager.adventurers.allAdventurers) {
			if (adventurer.inParty) { warners.add(adventurer.name); }
		}
		
		random = new Random();
		String warner = warners.get(random.nextInt(warners.size()));
		
		optionAText = "Give in";
		optionBText = "Compromise";
		optionCText = "Refuse";
		optionDText = "Trickery!";
		
		introTexts.add("The wolfmaker hung low in heaven. "
				+ "Fat, lethargic, pocked, demurely covered in a cloudy dress. "
				+ "The camp fire sputtered with a few defiant sparks, then died. "
				+ "We fell asleep ...");
		introTexts.add("And should not have, for bandits seek their shadowy marks, and were upon us in a jiffy!");
		introTexts.add(warner + ": Awake, To arms! To arms! The enemy hast arrived!");
		introTexts.add("Bandit Chief: Stand and deliver, give us thy money and you shallst go free.");
	
	}
	
	@Override
	public void writeOutcomeText() {
		
		if (optionA) {
			
			ArrayList<Adventurer> pleaders = new ArrayList<Adventurer>();
			for (Adventurer adventurer: GameManager.adventurers.allAdventurers) {
				if (adventurer.inParty) {
					pleaders.add(adventurer);
				}
			}
			String pleader = pleaders.get(random.nextInt(pleaders.size())).name;
			
			outcomeTexts.add(pleader + ": Take it! Take it all! Take all but leave our dignity!");
			
			String willFight = "";
			if(willFight(10)) { willFight = " In fact, thine blubbered cowardry, makest us abandon all mercy. "
					+ "Let's fight it out here, you and me!"; }
			else { willFight = " but easy pickings do please me, we'll leavest thee in thine blubbery."; }
			
			outcomeTexts.add("Bandit chief: That chance seems rather lost to thee."
					+ willFight);
	
		}
		
		else if (optionB) {
			
			Adventurer negotiator = new Adventurer();
			negotiator.currentStats.INT = 0;
			for (Adventurer adventurer: GameManager.adventurers.allAdventurers) {
				if (adventurer.inParty) { if (adventurer.currentStats.INT > negotiator.currentStats.INT) {
					negotiator = adventurer;
					}
				}
			}
				
			outcomeTexts.add(negotiator.name + ": For the moment, thous hast us at advantage's edge."
					+ "But the clock carries you no favour. "
					+ "As we recuperate from initial shock, perhaps thy boldness turns unlocked.");
			outcomeTexts.add(negotiator.name + ": What sayest thee, we shall pay you a smidgen of what you hoped, "
					+ "but without bloodshed you'll elope. "
					+ "... Or we'll fight and see if thee comest out unsoured");
			
			if(willFight(negotiator.currentStats.INT)) {
				outcomeTexts.add("Bandit chief: Pah, thine spineless discours moves me not, "
						+ "perhaps it'd work on politician's lot, "
						+ "my men, attack, leave their corpses here to rot!");
			} else {
				outcomeTexts.add("Bandit chief: we'll take that deal, thou speakest well, "
						+ "thine wordy zeal couldst anything sell. "
						+ "thou slippery eel, fare thee well. ");
			}
			
		}
		
		else if (optionC) {
			outcomeTexts.add("Outcome C");
			outcomeTexts.add("Outcome C once again");
		}
		
		else if (optionD) {
			outcomeTexts.add("Outcome D");
		}
		
	}
	
	

	@Override
	public void calculateOutcome() {

		if(optionA) {
			optionA = false;
			for(Adventurer adventurer: GameManager.adventurers.allAdventurers) {
				if(adventurer.inParty) {
				adventurer.setMoney (adventurer.getMoney() / 2);
				}
			}
			WorldMap.subState = WorldMap.previousSubState;
			GameManager.gameState = GameState.WorldMap;

		}
		
		if(optionC) { System.out.println("option C");
			optionC = false;
			Combat.combatMap = CombatMapRoller.rollCombatMap(WorldMapTiles.GRASS);
			WorldMap.subState = WorldMap.previousSubState;
			
			Combat.enemies.add(new Pirate());
			Combat.enemies.add(new Pirate());
			Combat.enemies.add(new Pirate());
			
			Combat.highLevelPlan = HighLevelPlan.Attack;
			Combat.combatPhase = CombatPhase.Setup;
			GameManager.gameState = GameState.Combat;
		}
	
	}
	
	

	private boolean willFight(int modifier) {
		
		if (Party.getIntimidation() + modifier + random.nextInt(10) > 20) {
			return false;
		} else { return true; }
		
	}
	
	
	
	
	
	
	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		

	}

	
	
	
	
	
}
