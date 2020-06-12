package com.redhaan.adventurersGalore.entity.party;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.calendar.Calendar;
import com.redhaan.adventurersGalore.worldMap.SubState;
import com.redhaan.adventurersGalore.worldMap.WorldMap;
import com.redhaan.adventurersGalore.worldMap.WorldMapTileInfo;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class TravelerEngine extends GameObject {
	
	public static boolean traveling;
	private int distanceTraveled;
	private int timer;
	
	public TravelerEngine() {
		
		traveling = false;
		distanceTraveled = 0;
		timer = 0;
		
	}

		

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		switch (GameManager.gameState) {
		
		case InTown: break;
		case Titlescreen: break;
		case Combat: break;
		case PartyScreen: break;
		
		case WorldMap:
			
			if(WorldMap.subState != SubState.TravelerEvent) {
			if(traveling) {
				timer++;
				
				if(timer * Calendar.calendarSpeed * deltaTime > 1) {
					
					//TravelerEvent.rollTravelerEvent();
					
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
						if(Party.getxTile() == Party.getxDestinationTile() && Party.getyTile() == Party.getyDestinationTile()) {
							traveling = false;
						}

						
						}

					timer = 0;
				
					}
					
					
				}
			
			
			break;	
		
			}
		}
		
	}

	
	
	
	
	@Override
	public void render(GameContainer gameContainer, Renderer renderer) { }

}
