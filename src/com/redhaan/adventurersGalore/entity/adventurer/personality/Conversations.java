package com.redhaan.adventurersGalore.entity.adventurer.personality;

import java.util.ArrayList;
import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class Conversations extends GameObject {

	public static boolean active;
	Random random;
	ConversationUI conversationUI;
	Conversation conversation;
	String stringToBeDrawn;
	String stringToBeDrawnFrom;
	private int timer, pauseTimer;
	private int offX, offY;
	private String firstLine, secondLine, thirdLine;
	private int lineModifier;

	public Conversations() {
		active = false;
		random = new Random();
		conversationUI = new ConversationUI();
		stringToBeDrawn = "";
		stringToBeDrawnFrom = "";
		firstLine = "";
		secondLine = "";
		thirdLine = "";
		timer = 0;
		pauseTimer = 0;
		offX = 0;
		offY = 0;
		lineModifier = 0;
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		switch (GameManager.gameState) {

		case WorldMap:

//<<<<<<< HEAD
				if(random.nextInt(6000000) == 0) { 
//=======
			if (!active) {

				if (random.nextInt(60) == 0) {
//>>>>>>> branch 'master' of https://github.com/jefbu/Adventurers-Galore.git
					ArrayList<Adventurer> candidates = new ArrayList<Adventurer>();
					for (Adventurer adventurer : GameManager.adventurers.allAdventurers) {
						if (adventurer.inParty) {
							candidates.add(adventurer);
						}
					}
					if (candidates.size() > 2) {
						active = true;
						Random random = new Random();
						offX = random.nextInt(240);
						offY = random.nextInt(380);
						conversation = ConversationTable.rollConversation(candidates);
					}
				}

			} else {

				if(thirdLine.length() > 1) { lineModifier = 180; }
				else if(secondLine.length() > 1) { lineModifier = 120; }
				else { lineModifier = 0; }
				
				pauseTimer++;
				if (stringToBeDrawnFrom.length() == 0) {
					stringToBeDrawnFrom = conversation.lines.get(conversation.lineNumber).line;
				}

				if (stringToBeDrawn.length() != stringToBeDrawnFrom.length()) {
					stringToBeDrawn = stringToBeDrawn + stringToBeDrawnFrom.substring(timer, timer + 1);
					if (timer != stringToBeDrawnFrom.length() - 1) {
						timer++;
					}
				} else {
					if (conversation.lineNumber != conversation.lines.size() - 1 && pauseTimer > 120 + lineModifier) {
						stringToBeDrawnFrom = "";
						stringToBeDrawn = "";
						timer = 0;
						pauseTimer = 0;
						firstLine = "";
						secondLine = "";
						thirdLine = "";
						conversation.lineNumber++; 
						}
					else if (pauseTimer > 180 + lineModifier) {
						stringToBeDrawnFrom = "";
						stringToBeDrawn = "";
						timer = 0;
						pauseTimer = 0;
						firstLine = "";
						secondLine = "";
						thirdLine = "";
						active = false;
					}
				}							
			}
			}

			break;

		case Combat:
			break;
		case InTown:
			break;
		case PartyScreen:
			break;
		case QuestUI:
			break;
		case Titlescreen:
			break;
		case Transition:
			break;
		default:
			break;

		}

	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		switch (GameManager.gameState) {

		case WorldMap:
			if (active) {
				conversationUI.render(gameContainer, renderer, offX, offY);
				renderer.drawImageTile(
						conversation.talkers.get(conversation.lines.get(conversation.lineNumber).speakerNumber).icon,
						offX + 7, offY + 12, 0, 0);
			
			
			
				if(stringToBeDrawn.length() > 0) {
					
					if(stringToBeDrawn.length() < 70) {
						if (stringToBeDrawn.length() > 40 && stringToBeDrawn.charAt(stringToBeDrawn.length() - 1) == 32) { }
						else { firstLine = stringToBeDrawn; }
					}
				
					else if(stringToBeDrawn.length() < 140) {
						if (stringToBeDrawn.length() > 110 && stringToBeDrawn.charAt(stringToBeDrawn.length() - 1) == 32) { }
						else { secondLine = stringToBeDrawn.substring(firstLine.length() + 1); }
					}
					
					else if(stringToBeDrawn.length() < 210) {
						if (stringToBeDrawn.length() > 180 && stringToBeDrawn.charAt(stringToBeDrawn.length() - 1) == 32) { }
						else { thirdLine = stringToBeDrawn.substring(firstLine.length() + secondLine.length() + 1); }
					}

				}
								
				renderer.drawText(firstLine, offX + 60, offY + 10, 0xffffffff);
				renderer.drawText(secondLine, offX + 60, offY + 20, 0xffffffff);
				renderer.drawText(thirdLine, offX + 60, offY + 30, 0xffffffff);
				
			}
			break;

		case Combat:
			break;
		case InTown:
			break;
		case PartyScreen:
			break;
		case QuestUI:
			break;
		case Titlescreen:
			break;
		case Transition:
			break;
		default:
			break;

		}

	}

}
