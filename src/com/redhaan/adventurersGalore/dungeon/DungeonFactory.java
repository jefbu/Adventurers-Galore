package com.redhaan.adventurersGalore.dungeon;

import java.util.Random;

import com.redhaan.adventurersGalore.worldMap.WorldMapTileInfo;
import com.redhaan.adventurersGalore.worldMap.WorldMapTiles;

public class DungeonFactory {
	
	private Random random;
	private int attempts;
	
	public DungeonFactory() {
		
		random = new Random(); 
		attempts = 0;
		
	}
	
	
	public Dungeon createRandomDungeon() {
		
		Dungeon dungeon = new Dungeon();
		dungeon.renewable = true;
		
		boolean goOn = true;
		while(goOn) {
			
			dungeon.xLocation = random.nextInt(160);
			dungeon.yLocation = random.nextInt(120);
			
			int tileInt = dungeon.yLocation * 160 + dungeon.xLocation;
			WorldMapTiles terrain = WorldMapTileInfo.tiles[tileInt];
			
			switch(terrain) {
			case DESERT: dungeon.tileRow = 10; goOn = false; break;
			case FOREST: dungeon.tileRow = 2; goOn = false; break;
			case GRASS: break;
			case ICE: dungeon.tileRow = 6; goOn = false; break;
			case MOUNTAIN: dungeon.tileRow = 12; goOn = false; break;
			case OCEAN:
				if (attempts < 4) { 
					attempts++; 
					break; 
					}
				else { 
					attempts = 0; 
					dungeon.tileRow = 14; 
					goOn = false; 
					break; 
					}				
			case SHALLOW: 
				if (attempts < 2) { 
					attempts++; 
					break; 
					}
				else { 
					attempts = 0; 
					dungeon.tileRow = 8; 
					goOn = false; 
					break; 
					}
			case SWAMP: dungeon.tileRow = 4; goOn = false; break;
			}
			
		}

		
		dungeon.expiration = 20 + random.nextInt(30);
		
		return dungeon;		
		
	}

}
