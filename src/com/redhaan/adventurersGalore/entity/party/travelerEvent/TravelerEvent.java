package com.redhaan.adventurersGalore.entity.party.travelerEvent;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.calendar.Calendar;
import com.redhaan.adventurersGalore.worldMap.SubState;
import com.redhaan.adventurersGalore.worldMap.WorldMap;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class TravelerEvent extends GameObject {

	private static final long serialVersionUID = 1L;
	public static TravelerEvent currentEvent;
	public static int optionsOffX;
	public static int optionsWidth;
	public static int optionsHeight;
	public static int optionAOffY;
	public static int optionBOffY;
	public static int optionCOffY;
	public static int optionDOffY;
	
	public static boolean optionA;
	public static boolean optionB;
	public static boolean optionC;
	public static boolean optionD;
	
	public static String optionAText;
	public static String optionBText;
	public static String optionCText;
	public static String optionDText;
	
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

		if (gameContainer.getInput().getMouseX() > optionsOffX && gameContainer.getInput().getMouseX() < optionsOffX + optionsWidth) {
			if (gameContainer.getInput().getMouseY() > optionAOffY && gameContainer.getInput().getMouseY() < optionAOffY + optionsHeight) {
				if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) { optionA = true; }
			}
		}
		
		if (gameContainer.getInput().getMouseX() > optionsOffX && gameContainer.getInput().getMouseX() < optionsOffX + optionsWidth) {
			if (gameContainer.getInput().getMouseY() > optionBOffY && gameContainer.getInput().getMouseY() < optionBOffY + optionsHeight) {
				if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) { optionB = true; }
			}
		}
		
		if (gameContainer.getInput().getMouseX() > optionsOffX && gameContainer.getInput().getMouseX() < optionsOffX + optionsWidth) {
			if (gameContainer.getInput().getMouseY() > optionCOffY && gameContainer.getInput().getMouseY() < optionCOffY + optionsHeight) {
				if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) { optionC = true; }
			}
		}
		
		if (gameContainer.getInput().getMouseX() > optionsOffX && gameContainer.getInput().getMouseX() < optionsOffX + optionsWidth) {
			if (gameContainer.getInput().getMouseY() > optionDOffY && gameContainer.getInput().getMouseY() < optionDOffY + optionsHeight) {
				if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) { optionD = true; }
			}
		}
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		renderer.drawRectOpaque(GameManager.GAMEWIDTH / 2 - 200, GameManager.GAMEHEIGHT / 2 - 150, 400, 300, 0x99000000);
		renderer.drawRect(GameManager.GAMEWIDTH / 2 - 195, GameManager.GAMEHEIGHT / 2 - 145, 310, 210, 0xff996644);
		renderer.drawRect(GameManager.GAMEWIDTH / 2 + 120, GameManager.GAMEHEIGHT / 2 - 145, 75, 210, 0xff996644);
		renderer.drawRect(GameManager.GAMEWIDTH / 2 - 195, GameManager.GAMEHEIGHT / 2 + 70, 390, 75, 0xff996644);
		
		renderer.drawRectOpaque(GameManager.GAMEWIDTH / 2 + 125, GameManager.GAMEHEIGHT / 2 - 140, optionsWidth, optionsHeight, 0xdd775533);
		renderer.drawRectOpaque(GameManager.GAMEWIDTH / 2 + 125, GameManager.GAMEHEIGHT / 2 - 90, optionsWidth, optionsHeight, 0xdd774422);
		renderer.drawRectOpaque(GameManager.GAMEWIDTH / 2 + 125, GameManager.GAMEHEIGHT / 2 - 40, optionsWidth, optionsHeight, 0xdd775522);
		renderer.drawRectOpaque(GameManager.GAMEWIDTH / 2 + 125, GameManager.GAMEHEIGHT / 2 + 10, optionsWidth, optionsHeight, 0xdd774433);

		
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
	
	
	
	
}
