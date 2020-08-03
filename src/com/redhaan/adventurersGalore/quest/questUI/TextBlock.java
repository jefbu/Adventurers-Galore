package com.redhaan.adventurersGalore.quest.questUI;

import java.awt.event.MouseEvent;

import com.redhaan.adventurersGalore.GameObject;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class TextBlock extends GameObject {
	
	private static final long serialVersionUID = 1L;
	private String stringToBeDrawn;
	private String stringToBeDrawnFrom;
	private int stringNumber;
	private int temp;
	private int timer;
	
	private String firstLine;
	private String secondLine;
	private String thirdLine;
	private String fourthLine;
	
	private boolean textFinished;
		
	public TextBlock() {
		
		stringToBeDrawn = "";
		stringToBeDrawnFrom = "";
		stringNumber = 0;
		temp = 0;
		timer = 0;
		firstLine = "";
		secondLine = "";
		thirdLine = "";
		fourthLine = "";
		textFinished = false;
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

	if(textFinished) {
	if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
		if (gameContainer.getInput().getMouseX() > 468 && gameContainer.getInput().getMouseX() < 523) {
		if (gameContainer.getInput().getMouseY() > 270 && gameContainer.getInput().getMouseY() < 295) {
			stringToBeDrawn = "";
			stringToBeDrawnFrom = "";
			firstLine = "";
			secondLine = "";
			thirdLine = "";
			fourthLine = "";
			timer = 0;
			stringNumber = 0;
			textFinished = false;
			QuestUI.questRefused = true;
		}
		}
		if (gameContainer.getInput().getMouseX() > 528 && gameContainer.getInput().getMouseX() < 583) {
		if (gameContainer.getInput().getMouseY() > 270 && gameContainer.getInput().getMouseY() < 295) {
			QuestUI.quest.questSteps.get(0).createNextQuestStep(QuestUI.nextQuestStep, QuestUI.quest);
			stringToBeDrawn = "";
			stringToBeDrawnFrom = "";
			firstLine = "";
			secondLine = "";
			thirdLine = "";
			fourthLine = "";
			timer = 0;
			stringNumber = 0;
			textFinished = false;
			QuestUI.questAccepted = true;
		}
		}
	}
	} else {
	if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
		if (gameContainer.getInput().getMouseX() > 525 && gameContainer.getInput().getMouseX() < 585) {
		if (gameContainer.getInput().getMouseY() > 410 && gameContainer.getInput().getMouseY() < 430) {

			stringNumber++;
			stringToBeDrawn = "";
			stringToBeDrawnFrom = "";
			firstLine = "";
			secondLine = "";
			thirdLine = "";
			fourthLine = "";
			timer = 0;

		}
		}
	}
	}
		
		
	temp += deltaTime * 10000;
	if (temp > 50) {

		temp = 0;			
		//if(QuestUI.quest.questParty.size() == 0) {	QuestUI.quest.questParty.add(new Adventurer()); QuestUI.quest.questParty.get(0).name = "Sucker";}
		
		switch(QuestUI.nextGameState) {
		
		case InTown:			
			if(stringToBeDrawnFrom.length() == 0) { 
				if (QuestUI.quest.questParty.size() > 0) {
					stringToBeDrawnFrom = QuestUI.quest.questSteps.get(0).playerGetsTakenQuestInTown.get(stringNumber);
					if(stringNumber == QuestUI.quest.questSteps.get(0).playerGetsTakenQuestInTown.size() - 1) { textFinished = true; }
				}
				else {
					stringToBeDrawnFrom = QuestUI.quest.questSteps.get(0).playerGetsEmptyQuestInTown.get(stringNumber); 
					if(stringNumber == QuestUI.quest.questSteps.get(0).playerGetsEmptyQuestInTown.size() - 1) { textFinished = true; }
				}	
			}		
			break;
			
		case WorldMap:  
			if(stringToBeDrawnFrom.length() == 0) {
				if (QuestUI.quest.questParty.size() > 0) {
					stringToBeDrawnFrom = QuestUI.quest.questSteps.get(0).playerGetsTakenQuestInWorldMap.get(stringNumber);
					if(stringNumber == QuestUI.quest.questSteps.get(0).playerGetsTakenQuestInWorldMap.size() - 1) { textFinished = true; }
				}
				else {
					stringToBeDrawnFrom = QuestUI.quest.questSteps.get(0).playerGetsEmptyQuestInWorldMap.get(stringNumber);
					if(stringNumber == QuestUI.quest.questSteps.get(0).playerGetsEmptyQuestInWorldMap.size() - 1) { textFinished = true; }
				}	
			}	
			break;
		default: break;

		}
		
		if(stringToBeDrawn.length() != stringToBeDrawnFrom.length()) {
			stringToBeDrawn = stringToBeDrawn + stringToBeDrawnFrom.substring(timer, timer + 1);
			if(timer != stringToBeDrawnFrom.length() - 1) { timer++; }			
		}
	}
			
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
	if(textFinished) {
		renderer.drawRectOpaque(468, 270, 55, 25, 0xff451911);
		renderer.drawRectOpaque(528, 270, 55, 25, 0xff253818);
		renderer.drawText("Refuse", 480, 280, 0xffbb4433);
		renderer.drawText("Accept", 540, 280, 0xff55aa44);		
	}
		
	else {
		renderer.drawRectOpaque(525, 410, 60, 20, 0xff665522);
		renderer.drawText("Next", 540, 415, 0xffFFDDBB);
	}				
				
	if(stringToBeDrawn.length() > 0) {
		
		if(stringToBeDrawn.length() < 110) {
			if (stringToBeDrawn.length() > 80 && stringToBeDrawn.charAt(stringToBeDrawn.length() - 1) == 32) { }
			else { firstLine = stringToBeDrawn; }
		}
	
		else if(stringToBeDrawn.length() < 220) {
			if (stringToBeDrawn.length() > 190 && stringToBeDrawn.charAt(stringToBeDrawn.length() - 1) == 32) { }
			else { secondLine = stringToBeDrawn.substring(firstLine.length() + 1); }
		}
		
		else if(stringToBeDrawn.length() < 330) {
			if (stringToBeDrawn.length() > 300 && stringToBeDrawn.charAt(stringToBeDrawn.length() - 1) == 32) { }
			else { thirdLine = stringToBeDrawn.substring(firstLine.length() + secondLine.length() + 1); }
		}
		
		else if(stringToBeDrawn.length() < 440) {
			if (stringToBeDrawn.length() > 410 && stringToBeDrawn.charAt(stringToBeDrawn.length() - 1) == 32) { }
			else { fourthLine = stringToBeDrawn.substring(firstLine.length() + secondLine.length() + thirdLine.length() + 1); }
		}
		

		renderer.drawText(firstLine, 60, 310, 0xff996644);
		renderer.drawText(secondLine, 60, 325, 0xff996644);
		renderer.drawText(thirdLine, 60, 340, 0xff996644);
		renderer.drawText(fourthLine, 60, 355, 0xff996644);
		
	}
		
	}
	
	

}
