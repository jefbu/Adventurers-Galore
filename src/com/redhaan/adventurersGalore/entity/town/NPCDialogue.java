package com.redhaan.adventurersGalore.entity.town;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;

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
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		animationTimer++;
		if(animationTimer >= 100) { animationTimer = 0; }

		
		if (!textFinished) {

			if (stringToDrawFrom.length() == 0) {
				stringToDrawFrom = conversationLibrary.getActiveConversation();
			}

			if (stringToDraw.length() < stringToDrawFrom.length()) {
				stringToDraw = stringToDraw + stringToDrawFrom.substring(timer, timer + 1);
				if (timer != stringToDrawFrom.length() - 1) {
					timer++;
				}
			} else {
				textFinished = true;
			}

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
	
	

	

}


