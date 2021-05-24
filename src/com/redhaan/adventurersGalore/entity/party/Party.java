package com.redhaan.adventurersGalore.entity.party;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.calendar.Calendar;
import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;
import com.redhaan.adventurersGalore.inventory.Inventory;
import com.redhaan.adventurersGalore.worldMap.WorldMap;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class Party extends GameObject {

	private static final long serialVersionUID = 1L;
	private static int xTile, yTile;
	private static int xDestinationTile, yDestinationTile;
	private ImageTile icon;
	private int blinkColour;
	private float blinkTemp;
	
	public static boolean traveling;
	public static int MH;
	
	private int day;
	private PartyCohesionChecker partyCohesionChecker;
	
	public static int intimidation;
	
	public static Inventory inventory;
		
	public Party() {
		
		xTile = 1;
		yTile = 1;
		blinkColour = 0xff559977;
		blinkTemp = 0;
		icon = new ImageTile("/Knight.png", 32, 32);
		intimidation = 0;
		
		traveling = false;
		MH = 5000;
		
		day = Calendar.daysPassed;
		partyCohesionChecker = new PartyCohesionChecker();
		
		inventory = new Inventory();
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		for (Adventurer adventurer: GameManager.adventurers.allAdventurers) {
			if(adventurer.inParty) { adventurer.mapX = xTile; adventurer.mapY = yTile; }
		}
		
		switch (GameManager.gameState) {
		
		case WorldMap:
			switch (WorldMap.getSubState()) {
			case GlobalMap:
				blinkTemp += deltaTime;
				if (blinkTemp > 0.6) {
					blinkTemp = 0;
					if (blinkColour == 0xff559977) {
						blinkColour = 0xff55bb99;
					} else {
						blinkColour = 0xff559977;
					}
				}
				break;
			case DetailMap:
				break;
			case TravelerEvent:
				break;
			}
			
			if(day != Calendar.daysPassed) {
				partyCohesionChecker.checkDailyPartyCohesion(0, gameContainer);
				day = Calendar.daysPassed;
			}
			break;
			
		case InTown: break;
		case PartyScreen: break;
		case Combat: break;
		case Titlescreen: break;
		case QuestUI: break;
		case Transition: break;
		case QuestScreen: break;
		case PartyCohesionCheckerUI: break;
		case Inventory: break;

		}
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
				
		switch (GameManager.gameState) {
		
		case WorldMap:
			switch (WorldMap.getSubState()) {
			case DetailMap:
				if (xTile < WorldMap.getOffX() + (GameManager.GAMEWIDTH / GameManager.GAMETILESIZE)
						&& xTile > WorldMap.getOffX() - (GameManager.GAMEWIDTH / GameManager.GAMETILESIZE)
						&& yTile < WorldMap.getOffY() + (GameManager.GAMEHEIGHT / GameManager.GAMETILESIZE)
						&& yTile > WorldMap.getOffY() - (GameManager.GAMEHEIGHT / GameManager.GAMETILESIZE)) {

					renderer.drawImageTile(icon, (xTile - WorldMap.getOffX()) * GameManager.GAMETILESIZE,
							(yTile - WorldMap.getOffY()) * GameManager.GAMETILESIZE, 0, 0);
				}
				break;
			case GlobalMap:
				renderer.drawRect(xTile * 4, yTile * 4, GameManager.GAMEWIDTH / GameManager.GAMETILESIZE / 3,
						GameManager.GAMEHEIGHT / GameManager.GAMETILESIZE / 2, blinkColour);
				break;
			case TravelerEvent:
				break;
			}
			break;
			
		case InTown: break;
		case Combat: break;
		case Titlescreen: break;
		case PartyScreen: break;
		case QuestUI: break;
		case Transition: break;
		case QuestScreen: break;
		case PartyCohesionCheckerUI: break;
		case Inventory: break;

		}
		
	}
	
	public static void setDestination(int x, int y) {
		
		xDestinationTile = x;
		yDestinationTile = y;
		traveling = true;
		
	}
	
	public static void calculateKMH() {

	}
	
	

	public static int getxTile() {
		return xTile;
	}

	public static void setxTile(int xTile) {
		Party.xTile = xTile;
	}

	public static int getyTile() {
		return yTile;
	}

	public static void setyTile(int yTile) {
		Party.yTile = yTile;
	}

	public static int getxDestinationTile() {
		return xDestinationTile;
	}

	public static void setxDestinationTile(int xDestinationTile) {
		Party.xDestinationTile = xDestinationTile;
	}

	public static int getyDestinationTile() {
		return yDestinationTile;
	}

	public static void setyDestinationTile(int yDestinationTile) {
		Party.yDestinationTile = yDestinationTile;
	}

	public static boolean isTraveling() {
		return traveling;
	}

	public static void setTraveling(boolean traveling) {
		Party.traveling = traveling;
	}
	
	public static int getIntimidation() {
		
		intimidation = 0;
		for (Adventurer adventurer: GameManager.adventurers.allAdventurers) {
			if (adventurer.inParty) {
				System.out.println("intimidation is: " + intimidation);
				intimidation += adventurer.maxStats.PHY - 10;
			}
		}
		return intimidation;
	}
	
	
	

}
