package com.redhaan.adventurersGalore.entity.party.travelerEvent;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.calendar.Calendar;
import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;
import com.redhaan.adventurersGalore.entity.enemies.Enemy;
import com.redhaan.adventurersGalore.worldMap.SubState;
import com.redhaan.adventurersGalore.worldMap.WorldMap;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.Image;

public class TravelerEvent extends GameObject {

	private static final long serialVersionUID = 1L;
	
	public static TravelerEvent currentEvent;
	
	public Image eventImage;
	
	public int optionsOffX;
	public int optionsWidth;
	public int optionsHeight;
	public int optionAOffY;
	public int optionBOffY;
	public int optionCOffY;
	public int optionDOffY;
	
	public boolean optionA;
	public boolean optionB;
	public boolean optionC;
	public boolean optionD;
	
	public ArrayList<String> introTexts;
	public ArrayList<String> outcomeTexts;
	
	public String optionAText;
	public String optionBText;
	public String optionCText;
	public String optionDText;
	
	public boolean introText;
	public boolean outcomeText;
	public boolean textFinished;
	public boolean paragraphFinished;
	
	public String stringToDraw;
	public String stringToDrawFrom;
	public int paragraphNumber;
	public int timer;
	
	private String firstLine;
	private String secondLine;
	private String thirdLine;
	private String fourthLine;
	
	private int hoverOption;
	
	protected int speakerOption;
	protected Adventurer speaker1;
	protected Enemy speaker2;
	
	
	
	public TravelerEvent() {
		
		optionsOffX = GameManager.GAMEWIDTH / 2 + 125;
		optionsWidth = 65;
		optionsHeight = 45;
		
		optionAOffY = GameManager.GAMEHEIGHT / 2 - 140;
		optionBOffY = GameManager.GAMEHEIGHT / 2 - 90;
		optionCOffY = GameManager.GAMEHEIGHT / 2 - 40;
		optionDOffY = GameManager.GAMEHEIGHT / 2 + 10;		
		
		optionA = false;
		optionB = false;
		optionC = false;
		optionD = false;
		
		optionAText = "";
		optionBText = "";
		optionCText = "";
		optionDText = "";
		
		introTexts = new ArrayList<String>();
		outcomeTexts = new ArrayList<String>();
		
		introText = true;
		outcomeText = false;
		textFinished = false;
		paragraphFinished = false;
		stringToDraw = "";
		stringToDrawFrom = "";
		paragraphNumber = 0;
		timer = 0;
		
		firstLine = "";
		secondLine = "";
		thirdLine = "";
		fourthLine = "";
		
		hoverOption = 0;
		speakerOption = 0;
		speaker1 = null;
		speaker2 = null;
		
	}
		
	
	public static void rollTravelerEvent() {
		
		Random random = new Random();
		int roll = random.nextInt(100) + 1;
		
		switch(Calendar.calendarSpeed) {
		
		case 1: 
			if (roll > 99) { createMajorEvent(); }
			else if (roll > 97) { createMediumEvent(); }
			else if (roll > 92) { createMinorEvent(); }
			break;
		case 3: 
			if (roll > 99) { createMajorEvent(); }
			else if (roll > 97) { createMediumEvent(); }
			else if (roll > 95) { createMinorEvent(); }			
			break;
		case 10: 
			if (roll > 98) { createMajorEvent(); }
			else if (roll > 96) { createMediumEvent(); }
			else if (roll > 95) { createMinorEvent(); }
			break;
		case 40: 
			if (roll > 98) { createMajorEvent(); }
			else if (roll > 97) { createMediumEvent(); }
			else if (roll > 96) { createMinorEvent(); }
			break;
		
		default: System.out.println("Error in rollTravelerEvent"); break;
		
		
		}
		
	}
	
	private static void createMinorEvent() {
		currentEvent = new BanditsOnTheRoad();
		WorldMap.previousSubState = WorldMap.subState;
		WorldMap.subState = SubState.TravelerEvent;
	}
	
	private static void createMediumEvent() {
		currentEvent = new BanditsOnTheRoad();
		WorldMap.previousSubState = WorldMap.subState;
		WorldMap.subState = SubState.TravelerEvent;
	}
	
	private static void createMajorEvent() {
		currentEvent = new BanditsOnTheRoad();
		WorldMap.previousSubState = WorldMap.subState;
		WorldMap.subState = SubState.TravelerEvent;
	}



	@Override
	public void update(GameContainer gameContainer, float deltaTime) {	
		
		currentEvent.update(gameContainer, deltaTime);

		if(textFinished && introText) {
			
			if (gameContainer.getInput().getMouseX() > optionsOffX && gameContainer.getInput().getMouseX() < optionsOffX + optionsWidth) {
				if (gameContainer.getInput().getMouseY() > optionAOffY && gameContainer.getInput().getMouseY() < optionAOffY + optionsHeight) {
					hoverOption = 1;
					if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) { 
						if (introText) { 
							currentEvent.optionA = true; 
							introText = false; 
							outcomeText = true; 
							currentEvent.writeOutcomeText(); 
							textFinished = false; 
							paragraphNumber = 0;
							}
					}
				}
			}
			
			if (gameContainer.getInput().getMouseX() > optionsOffX && gameContainer.getInput().getMouseX() < optionsOffX + optionsWidth) {
				if (gameContainer.getInput().getMouseY() > optionBOffY && gameContainer.getInput().getMouseY() < optionBOffY + optionsHeight) {
					hoverOption = 2;
					if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) { 
						if (introText) { 
							currentEvent.optionB = true; 
							introText = false; 
							outcomeText = true; 
							currentEvent.writeOutcomeText(); 
							textFinished = false;
							paragraphNumber = 0;
							}
					}
				}
			}
			
			if (gameContainer.getInput().getMouseX() > optionsOffX && gameContainer.getInput().getMouseX() < optionsOffX + optionsWidth) {
				if (gameContainer.getInput().getMouseY() > optionCOffY && gameContainer.getInput().getMouseY() < optionCOffY + optionsHeight) {
					hoverOption = 3;
					if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) { 
						if (introText) { 
							currentEvent.optionC = true; 
							introText = false; 
							outcomeText = true; 
							currentEvent.writeOutcomeText(); 
							textFinished = false;
							paragraphNumber = 0;
							}
					}
				}
			}
			
			if (gameContainer.getInput().getMouseX() > optionsOffX && gameContainer.getInput().getMouseX() < optionsOffX + optionsWidth) {
				if (gameContainer.getInput().getMouseY() > optionDOffY && gameContainer.getInput().getMouseY() < optionDOffY + optionsHeight) {
					hoverOption = 4;
					if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
						if (introText) { 
							currentEvent.optionD = true; 
							introText = false; 
							outcomeText = true; 
							currentEvent.writeOutcomeText(); 
							textFinished = false;
							paragraphNumber = 0;
							}
					}
				}
			}
			
			else { hoverOption = 0; }
			
		}

		
	
		if (gameContainer.getInput().getMouseX() > 450 && gameContainer.getInput().getMouseX() < 500) {
			if (gameContainer.getInput().getMouseY() > 350 && gameContainer.getInput().getMouseY() < 370) {
				if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) { 
					if(!textFinished) {
						paragraphNumber++;
						firstLine = "";
						secondLine = "";
						thirdLine = "";
						fourthLine = "";
						paragraphFinished = false;
						timer = 0;
						stringToDraw = "";
						stringToDrawFrom = "";
						if(introText) { if (paragraphNumber >= currentEvent.introTexts.size()) { textFinished = true; } }
						else if (outcomeText) { if (paragraphNumber >= currentEvent.outcomeTexts.size()) { 
							outcomeText = false;
							paragraphFinished = false;
							paragraphNumber = 0;
							timer = 0;
							stringToDraw = "";
							stringToDrawFrom = "";
							firstLine = "";
							secondLine = "";
							thirdLine = "";
							optionA = false;
							optionB = false;
							optionC = false;
							optionD = false;
							
							optionAText = "";
							optionBText = "";
							optionCText = "";
							optionDText = "";						
							introText = true;
							textFinished = false;
							
							firstLine = "";
							secondLine = "";
							thirdLine = "";
							fourthLine = "";
							
							hoverOption = 0;
							speakerOption = 0;
							speaker1 = null;
							speaker2 = null;
							currentEvent.calculateOutcome();
						}
						}
					}
				}
			}			
		}

		
		//if(introText) { if (paragraphNumber >= currentEvent.introTexts.size()) { textFinished = true; } }
		//else if (outcomeText) { System.out.println(paragraphNumber); if (paragraphNumber >= currentEvent.outcomeTexts.size()) { textFinished = true; } }

		
		if(!textFinished) {
						
			if(stringToDrawFrom.length() == 0) {
				if (introText) { stringToDrawFrom = currentEvent.introTexts.get(paragraphNumber); }
				else if (outcomeText) { stringToDrawFrom = currentEvent.outcomeTexts.get(paragraphNumber); }
			}
			
			if(stringToDraw.length() < stringToDrawFrom.length()) {
				stringToDraw = stringToDraw + stringToDrawFrom.substring(timer, timer + 1);
				if(timer != stringToDrawFrom.length() - 1) { timer++; }
			} 
			else {
				paragraphFinished = true;
			}
						
		}
		

		
		
		
		
		
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		currentEvent.render(gameContainer, renderer);
		
		renderer.drawRectOpaque(120, 90, 400, 300, 0x99000000);
		renderer.drawRect(125, 95, 310, 210, 0xff996644);
		renderer.drawRect(440, 95, 75, 210, 0xff996644);
		renderer.drawRect(125, 310, 390, 75, 0xff996644);
		renderer.drawRectOpaque(65, 310, 55, 75, 0x99000000);
		
		renderer.drawImage(currentEvent.eventImage, 126, 96);
		
		if(textFinished && introText) renderer.drawRectOpaque(445, 100, optionsWidth, optionsHeight, 0xdd775533);
		if(textFinished && introText) renderer.drawRectOpaque(445, 150, optionsWidth, optionsHeight, 0xdd774422);
		if(textFinished && introText) renderer.drawRectOpaque(445, 200, optionsWidth, optionsHeight, 0xdd775522);
		if(textFinished && introText) renderer.drawRectOpaque(445, 250, optionsWidth, optionsHeight, 0xdd774433);
		
		if(textFinished && introText && hoverOption == 1) renderer.drawRect(444, 99, optionsWidth + 2, optionsHeight + 2, 0xffFFCC88);
		if(textFinished && introText && hoverOption == 2) renderer.drawRect(444, 149, optionsWidth + 2, optionsHeight + 2, 0xffFFCC88);
		if(textFinished && introText && hoverOption == 3) renderer.drawRect(444, 199, optionsWidth + 2, optionsHeight + 2, 0xffFFCC88);
		if(textFinished && introText && hoverOption == 4) renderer.drawRect(444, 249, optionsWidth + 2, optionsHeight + 2, 0xffFFCC88);

		
		if(textFinished && introText) renderer.drawText(currentEvent.optionAText, GameManager.GAMEWIDTH / 2 + 130, GameManager.GAMEHEIGHT / 2 - 120, 0xff451205);
		if(textFinished && introText) renderer.drawText(currentEvent.optionBText, GameManager.GAMEWIDTH / 2 + 130, GameManager.GAMEHEIGHT / 2 - 70, 0xff451205);
		if(textFinished && introText) renderer.drawText(currentEvent.optionCText, GameManager.GAMEWIDTH / 2 + 130, GameManager.GAMEHEIGHT / 2 - 20, 0xff451205);
		if(textFinished && introText) renderer.drawText(currentEvent.optionDText, GameManager.GAMEWIDTH / 2 + 130, GameManager.GAMEHEIGHT / 2 + 30, 0xff451205);
		
		if(!textFinished) renderer.drawRectOpaque(450, 350, 50, 20, 0xffAA9933);
		if(textFinished && outcomeText) { renderer.drawRectOpaque(450, 350, 50, 20, 0xffAA9933); }

		if (outcomeText && paragraphNumber + 1 >= currentEvent.outcomeTexts.size()) { renderer.drawText("Finish", 460, 355, 0xff443012); }
		else if(paragraphFinished && !textFinished) { renderer.drawText("Next", 460, 355, 0xff443012); }
		else if (!textFinished) { renderer.drawText("Skip", 460, 355, 0xff443012); }		
				
		if(stringToDraw.length() > 0) {
			
				if (firstLine.length() > 60 && firstLine.charAt(firstLine.length() - 1) == 32) { }
				else { firstLine = stringToDraw; }
				
				if(stringToDraw.length() > firstLine.length()) {
					if (secondLine.length() > 60 && secondLine.charAt(secondLine.length() - 1) == 32) { }
					else { secondLine = stringToDraw.substring(firstLine.length()); }
				}

				if(stringToDraw.length() > firstLine.length() + secondLine.length()) {
					if (thirdLine.length() > 60 && thirdLine.charAt(thirdLine.length() - 1) == 32) { }
					else { thirdLine = stringToDraw.substring(firstLine.length() + secondLine.length()); }
				}

				if(stringToDraw.length() > firstLine.length() + secondLine.length() + thirdLine.length()) {
					fourthLine = stringToDraw.substring(firstLine.length() + secondLine.length() + thirdLine.length());
				}

		}
			
		if(firstLine.length() > 0) { renderer.drawText(firstLine, 140, 320, 0xffFFFFFF); }
		if (secondLine.length() > 0) { renderer.drawText(secondLine, 140, 335, 0xffFFFFFF); }
		if (thirdLine.length() > 0) { renderer.drawText(thirdLine, 140, 350, 0xffFFFFFF); }
		if (fourthLine.length() > 0) { renderer.drawText(fourthLine, 140, 365, 0xffFFFFFF); }

		switch(currentEvent.speakerOption) {
		
		case 0: break;
		case 1: 
			renderer.drawImageTile(currentEvent.speaker1.icon, 80, 325, 0, 0); 
			renderer.drawText(currentEvent.speaker1.name, 80, 365, 0xffDDDDBB);
			break;
		case 2: 
			renderer.drawImageTile(currentEvent.speaker2.icon, 80, 325, 0, 0); 
			renderer.drawText(currentEvent.speaker2.name, 80, 365, 0xffDDDDBB);
			break;
		
		}

		
	}
	
	
	
	
	public void writeOptionTexts(String a, String b, String c, String d, Renderer renderer) {
		
		renderer.drawText(a, GameManager.GAMEWIDTH / 2 + 130, GameManager.GAMEHEIGHT / 2 - 135, 0xffddddaa);
		renderer.drawText(b, GameManager.GAMEWIDTH / 2 + 130, GameManager.GAMEHEIGHT / 2 - 85, 0xffddddaa);
		renderer.drawText(c, GameManager.GAMEWIDTH / 2 + 130, GameManager.GAMEHEIGHT / 2 - 35, 0xffddddaa);
		renderer.drawText(d, GameManager.GAMEWIDTH / 2 + 130, GameManager.GAMEHEIGHT / 2 + 15, 0xffddddaa);

		
	}
	
	public void writeText(String text, Renderer renderer) {
		ArrayList<String> strings = splitText(text);
		for (int i = 0; i < strings.size(); i++) {
			renderer.drawText(strings.get(i), GameManager.GAMEWIDTH / 2 - 190, (GameManager.GAMEHEIGHT / 2 + 75) + (i * 15), 0xffddddaa);
		}
	}

	
	private ArrayList<String> splitText(String text) {		
				
		ArrayList<String> strings = new ArrayList<String>();
		
		int lines = text.length() / 90 + 1;
		
		int beginIndex = 0;
		int lineCut = 80 + text.substring(80, 90).indexOf(" ") + 1;		
		
		for (int  i = 0; i < lines; i++ ) {			
			strings.add(text.substring(beginIndex, Math.min(lineCut, text.length())));
			beginIndex = lineCut ;
			try {
			lineCut = beginIndex + 80 + text.substring(beginIndex + 80, beginIndex + 90).indexOf(" ") + 1;
			} catch (Exception e) {
				lineCut = text.length();
			}
		}
			
		return strings;
				
	}
	
	public void writeOutcomeText() {
		
	}
	
	public void calculateOutcome() {
		
	}
	
	
	
	
}
