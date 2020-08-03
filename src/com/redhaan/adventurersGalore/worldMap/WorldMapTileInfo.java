package com.redhaan.adventurersGalore.worldMap;

import java.io.Serializable;

import gameEngine.ecclesiastes.gfx.Image;

public class WorldMapTileInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	private Image detailMap;
	public static WorldMapTiles[] tiles;
	
	public WorldMapTileInfo() {
		
		detailMap = new Image("/worldMap/DetailMap.png");
		tiles = new WorldMapTiles[detailMap.getPixels().length];
		
		for (int i = 0; i < detailMap.getPixels().length; i++) {
			
			if (detailMap.getPixels()[i] == 0xff00ff00) {
				tiles[i] = WorldMapTiles.GRASS;
			}
			else if (detailMap.getPixels()[i] == 0xff0000ff) {
				tiles[i] = WorldMapTiles.OCEAN;
			}
			else if (detailMap.getPixels()[i] == 0xffff0000) {
				tiles[i] = WorldMapTiles.DESERT;
			}
			else if (detailMap.getPixels()[i] == 0xff006400) {
				tiles[i] = WorldMapTiles.FOREST;
			}
			else if (detailMap.getPixels()[i] == 0xff000064) {
				tiles[i] = WorldMapTiles.SHALLOW;
			}
			else if (detailMap.getPixels()[i] == 0xff640064) {
				tiles[i] = WorldMapTiles.SWAMP;
			}
			else if (detailMap.getPixels()[i] == 0xff643200) {
				tiles[i] = WorldMapTiles.MOUNTAIN;
			}
			else if (detailMap.getPixels()[i] == 0xff6464ff) {
				tiles[i] = WorldMapTiles.ICE;
			}
			else System.out.println("colour not found");
			
			
		}
				
	}
	
	

}
