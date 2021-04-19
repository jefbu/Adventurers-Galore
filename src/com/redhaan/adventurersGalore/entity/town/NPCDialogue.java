package com.redhaan.adventurersGalore.entity.town;

import java.awt.event.MouseEvent;
import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.dungeon.Dungeons;
import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class NPCDialogue extends GameObject {

	private static final long serialVersionUID = 1L;
	NPC npc;
	private String stringToDraw, stringToDrawFrom;
	private String firstLine, secondLine, thirdLine;
	private boolean textFinished;
	private int timer;
	private int animationTimer;
	private boolean hover;
	
	protected ConversationLibrary conversationLibrary;
	
	public NPCDialogue(NPC npc) {
		
		this.npc = npc;
		conversationLibrary = new ConversationLibrary();
		
		stringToDraw = "";
		stringToDrawFrom = "";
		firstLine = "";
		secondLine = "";
		thirdLine = "";
		textFinished = false;
		timer = 0;
		animationTimer = 0;
		hover = false;
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		animationTimer++;
		if(animationTimer >= 100) { animationTimer = 0; }

		
		if (!textFinished) {

			if (stringToDrawFrom.length() == 0) {
				if(conversationLibrary.activeConversation >= conversationLibrary.conversations.size()) {
					stringToDrawFrom = conversationLibrary.getEmptyConversation();
				}
				else { 
					stringToDrawFrom = conversationLibrary.getActiveConversation();
					if(conversationLibrary.importantLines[conversationLibrary.activeConversation]) {
						Dungeons.allDungeons.get(0).discovered = true;
					}
					}
			}

			if (stringToDraw.length() < stringToDrawFrom.length()) {
				stringToDraw = stringToDraw + stringToDrawFrom.substring(timer, timer + 1);
				if (timer != stringToDrawFrom.length() - 1) {
					timer++;
				}
			} else { textFinished = true; }

		}
		
		
		if(gameContainer.getInput().getMouseX() > npc.xLocation - 137 && gameContainer.getInput().getMouseX() < npc.xLocation - 87 &&
				gameContainer.getInput().getMouseY() > npc.yLocation - 6 && gameContainer.getInput().getMouseY() < npc.yLocation + 14) {
			
			hover = true;
			
			if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
				if(charmed(npc) && npc.familiarity < 3) { npc.familiarity++; }
				npc.dialogueActive = false;
				stringToDraw = "";
				stringToDrawFrom = "";
				timer = 0;
				conversationLibrary.activeConversation++;
				textFinished = false;
			}
		
		} else {
			hover = false;
		}
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		renderer.drawImageTile(NPC.icon, npc.xLocation, npc.yLocation, npc.body, 5 + npc.facing);
		renderer.drawImageTile(NPC.icon, npc.xLocation, npc.yLocation, npc.head, 13 + npc.facing);
		renderer.drawImageTile(NPC.icon, npc.xLocation, npc.yLocation, npc.skin, 21 + npc.facing);
		
		renderer.drawRectOpaque(npc.xLocation - 187, npc.yLocation - 60, 380, 50, 0x88221513);
		renderer.drawRectOpaque(npc.xLocation - 184, npc.yLocation - 57, GameManager.GAMETILESIZE + 10, 44, 0x99131333);
		
		renderer.drawImageTile(NPC.portrait, npc.xLocation - 180, npc.yLocation - 52, npc.portraitBody, 5 + animationTimer / 25);
		renderer.drawImageTile(NPC.portrait, npc.xLocation - 180, npc.yLocation - 52, npc.portraitSkin, 21 + animationTimer / 25);
		renderer.drawImageTile(NPC.portrait, npc.xLocation - 180, npc.yLocation - 52, npc.portraitHead, 13 + animationTimer / 25);

		renderer.drawRectOpaque(npc.xLocation - 139, npc.yLocation - 57, 330, 44, 0x99131333);	
		
		renderer.drawRectOpaque(npc.xLocation - 137, npc.yLocation - 6, 50, 20, 0xff558877);
		renderer.drawText("Ok", npc.xLocation - 130, npc.yLocation, 0xff225540);
		
		if(hover) { renderer.drawRect(npc.xLocation - 136, npc.yLocation - 5, 48, 18, 0xff114430); }
				
		
		if (stringToDraw.length() > 0) {

			if (firstLine.length() > 70 && firstLine.charAt(firstLine.length() - 1) == 32) {
			} else {
				firstLine = stringToDraw;
			}

			if (stringToDraw.length() > firstLine.length()) {
				if (secondLine.length() > 70 && secondLine.charAt(secondLine.length() - 1) == 32) {
				} else {
					secondLine = stringToDraw.substring(firstLine.length());
				}
			}

			if (stringToDraw.length() > firstLine.length() + secondLine.length()) {
				if (thirdLine.length() > 70 && thirdLine.charAt(thirdLine.length() - 1) == 32) {
				} else {
					thirdLine = stringToDraw.substring(firstLine.length() + secondLine.length());
				}
			}

		}

		if (firstLine.length() > 0) {
			renderer.drawText(firstLine, npc.xLocation - 132, npc.yLocation - 50, 0xff567389);
		}
		if (secondLine.length() > 0) {
			renderer.drawText(secondLine, npc.xLocation - 132, npc.yLocation - 40, 0xff567389);
		}
		if (thirdLine.length() > 0) {
			renderer.drawText(thirdLine, npc.xLocation - 132, npc.yLocation - 30, 0xff567389);
		}
		
	
	}	

	private boolean charmed(NPC npc) {
		
		Random random = new Random();
		for (Adventurer adventurer: GameManager.adventurers.allAdventurers) {
			if (adventurer.inParty) {
				if (adventurer.skills.decorum.activeSkill) {
					
					int roll = random.nextInt(100) + 1;
					switch(adventurer.skills.decorum.value) {
					case 0: if (roll > 95) { return true; } break;
					case 1: if (roll > 85) { return true; } break;
					case 2: if (roll > 75) { return true; } break;
					case 3: if (roll > 65) { return true; } break;
					case 4: if (roll > 55) { return true; } break;
					case 5: if (roll > 40) { return true; } break;					
					}
				
				}
			}
		}
		
		return false;
		
	}
	
	
	
	
}


