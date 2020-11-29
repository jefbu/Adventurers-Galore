package com.redhaan.adventurersGalore.quest.quests.fetchQuest;

import java.util.ArrayList;
import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameState;
import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;
import com.redhaan.adventurersGalore.entity.party.travelerEvent.DialogueText;
import com.redhaan.adventurersGalore.quest.Quest;
import com.redhaan.adventurersGalore.quest.QuestStep;
import com.redhaan.adventurersGalore.quest.questUI.QuestUI;

import gameEngine.ecclesiastes.GameContainer;

public class GoGetMyTrinket extends QuestStep {

	Random random;

	public GoGetMyTrinket(Adventurer requester) {

		random = new Random();
		daysPassed = 0;
		maxDays = 50;
		questStepLocation.questLocationTown = rollForQuestStepLocationTown();
		questStepLocation.nextLocationTown = rollForQuestStepLocationTown();
		String gender = "";
		String pronoun = "";
		if (requester.gender == "Male") { gender = "man"; pronoun = "he"; } 
		else { gender = "woman"; pronoun = "she"; }
		
		ArrayList<Adventurer> speakerCandidates = new ArrayList<Adventurer>();
		for (Adventurer adventurer: GameManager.adventurers.allAdventurers) {
			if (adventurer.inParty) { speakerCandidates.add(adventurer); }
		}
		Adventurer speaker = speakerCandidates.get(random.nextInt(speakerCandidates.size()));

		playerGetsEmptyQuestInTown.add(new DialogueText(
				"A " + gender + " is sauntering nearby, and watches you with an air of feigned nonchalance.", null, null, 0, 0));
		
		playerGetsEmptyQuestInTown.add(new DialogueText(
				"After hesitating a spell, " + pronoun + " ambles up to you, and beseeches your help", null, null, 0, 0));
		
		playerGetsEmptyQuestInTown.add(new DialogueText(
				"A trinket lost, and lost to me. Perchance for all eternity. "
						+ "Unless thee heedst my tear-eyed plea, and soothe my poignant mysery. "
						+ "And bring that trinket back to me.", requester.icon, requester.name, requester.genderInt, 0));
		
		playerGetsEmptyQuestInTown.add(new DialogueText(
				"Well how hast lost thine joie de vivre?", speaker.icon, speaker.name, adventurerGenderXOffset, adventurerGenderYOffset));
		
		playerGetsEmptyQuestInTown.add(new DialogueText(
				"It was in drunken revelry...", requester.icon, requester.name, requester.genderInt, 0));
		
		playerGetsEmptyQuestInTown.add(new DialogueText(
				"I see...", speaker.icon, speaker.name, adventurerGenderXOffset, adventurerGenderYOffset));

		playerGetsEmptyQuestInTown.add(new DialogueText(
				"Thou shallst find it in " + questStepLocation.nextLocationTown.name, requester.icon, requester.name, requester.genderInt, 0));
		

		
		playerGetsTakenQuestInTown.add(new DialogueText("Taken Go Get My Trinket found in town", null, null, 0, 0));
				
		playerGetsEmptyQuestInWorldMap.add(new DialogueText("Empty Go Get My Trinket step found in the worldmap", null, null, 0, 0));

		playerGetsTakenQuestInWorldMap.add(new DialogueText("Already taken Go get my trinket found on the map!", null, null, 0, 0));

	}

	@Override
	public void update(GameContainer gameContainer, Quest quest) {

		Random random = new Random();

		switch (GameManager.gameState) {

		case Combat:
			break;
		case PartyScreen:
			break;
		case Titlescreen:
			break;
		default:
			break;

		case InTown:
			QuestUI.quest = quest;
			QuestUI.nextGameState = GameState.InTown;
			GameManager.gameState = GameState.QuestUI;
			if (random.nextBoolean()) {
				QuestUI.nextQuestStep = new ItIsNotHere(questStepLocation.nextLocationTown);
			} else {
				QuestUI.nextQuestStep = new YouFoundIt(questStepLocation.nextLocationTown);
			}
			break;

		case WorldMap:

			if (!quest.playerQuest) {
				if (activateNextQuestStep(quest)) {
					if (random.nextBoolean()) {
						createNextQuestStep(new ItIsNotHere(questStepLocation.nextLocationTown), quest);
					} else {
						createNextQuestStep(new YouFoundIt(questStepLocation.nextLocationTown), quest);
					}
				}

				else if (quest.questParty.size() < quest.maxPartySize) {
					questStepLocation.checkAvailableAdventurers(questStepLocation.questLocationTown, quest);
				}
			}

			daysPassed++;
			break;

		}

	}

}
