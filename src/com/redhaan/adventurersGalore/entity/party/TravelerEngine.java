package com.redhaan.adventurersGalore.entity.party;

import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.calendar.Calendar;
import com.redhaan.adventurersGalore.dungeon.Dungeon;
import com.redhaan.adventurersGalore.dungeon.Dungeons;
import com.redhaan.adventurersGalore.entity.party.travelerEvent.TravelerEvent;
import com.redhaan.adventurersGalore.worldMap.SubState;
import com.redhaan.adventurersGalore.worldMap.WorldMap;
import com.redhaan.adventurersGalore.worldMap.WorldMapTileInfo;
import com.redhaan.adventurersGalore.worldMap.WorldMapTiles;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class TravelerEngine extends GameObject {

	private static final long serialVersionUID = 1L;
	public static boolean traveling;
	private int distanceTraveled;
	private int timer;
	private Random random;
	
	
	public TravelerEngine() {
		
		traveling = false;
		distanceTraveled = 0;
		timer = 0;
		random = new Random();
		
	}

		

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		switch (GameManager.gameState) {
		
		case InTown: break;
		case Titlescreen: break;
		case Combat: break;
		case PartyScreen: break;
		case QuestUI: break;
		case Transition: break;
		case QuestScreen: break;
		case PartyCohesionCheckerUI: break;
		case Inventory: break;
		
		case WorldMap:
			
			if(WorldMap.subState != SubState.TravelerEvent) {
			if(traveling) {
							
				timer++;
				
				if(timer * Calendar.calendarSpeed * deltaTime > 1) {
					
					TravelerEvent.rollTravelerEvent();
					
					int number = 0;
					number = Party.getyTile() * 160 + Party.getxTile();
					int travelingSpeedModifier = 0;
					
					switch(WorldMapTileInfo.tiles[number]) {
					
					case DESERT: travelingSpeedModifier = 70; break;
					case FOREST: travelingSpeedModifier = 50; break;
					case GRASS: travelingSpeedModifier = 100; break;
					case ICE: travelingSpeedModifier = 50; break;
					case MOUNTAIN: travelingSpeedModifier = 20; break;
					case OCEAN: travelingSpeedModifier = 80; break;
					case SHALLOW: travelingSpeedModifier = 80; break;
					case SWAMP: travelingSpeedModifier = 40; break;
					
					}
					
					distanceTraveled = distanceTraveled + Party.MH * travelingSpeedModifier / 100;
					if (distanceTraveled > 10000) {
												
						int xDistance = Math.abs((Party.getxTile() - Party.getxDestinationTile()));
						int yDistance = Math.abs((Party.getyTile() - Party.getyDestinationTile()));
						
						boolean travelHorizontal = false;
						if(xDistance >= yDistance) { travelHorizontal = true; }
						
						if(travelHorizontal) {
							if(Party.getxTile() > Party.getxDestinationTile()) {
								Party.setxTile(Party.getxTile() - 1);
							}
							else { Party.setxTile(Party.getxTile() + 1); }
						}
						else {
							if(Party.getyTile() > Party.getyDestinationTile()) {
								Party.setyTile(Party.getyTile() - 1) ;
							}
							else { Party.setyTile(Party.getyTile() + 1); }
						}
						
						distanceTraveled = 0;
						
						if (random.nextInt(100) > 90) {
							
							Dungeon dungeon = new Dungeon();
							
							dungeon.xLocation = Party.getxTile();
							dungeon.yLocation = Party.getyTile();
							dungeon.expiration = 15 + random.nextInt(30);
							dungeon.popup.timer = 300;
							
							int tileInt = dungeon.yLocation * 160 + dungeon.xLocation;
							WorldMapTiles terrain = WorldMapTileInfo.tiles[tileInt];
							
							boolean addable = true;
							switch(terrain) {
							case DESERT: dungeon.tileRow = 10; break;
							case FOREST: dungeon.tileRow = 2; break;
							case GRASS: addable = false; break;
							case ICE: dungeon.tileRow = 6; break;
							case MOUNTAIN: dungeon.tileRow = 12; break;
							case OCEAN: dungeon.tileRow = 14; break; 
							case SHALLOW: dungeon.tileRow = 8; break; 
							case SWAMP: dungeon.tileRow = 4; break;
							}
							
							if (addable) { Dungeons.allDungeons.add(dungeon); }
						}
						
						if(Party.getxTile() == Party.getxDestinationTile() && Party.getyTile() == Party.getyDestinationTile()) {
							traveling = false;
						}					
				
					}
					
					timer = 0;
					
				}			
				}
		
			}
			
			break;
		}	
			
	}


	
	
	
	
	@Override
	public void render(GameContainer gameContainer, Renderer renderer) { }

}
