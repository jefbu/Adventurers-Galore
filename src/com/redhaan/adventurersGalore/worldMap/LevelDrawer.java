package com.redhaan.adventurersGalore.worldMap;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.combat.MoveRangeFiller;

import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.Image;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class LevelDrawer {

	private ImageTile tileSet;

	public LevelDrawer() {

		tileSet = new ImageTile("/spritesheets/mapTiles.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE);
	}

	public void drawLevel(Renderer renderer, Image image, int offX, int offY, boolean combatMap) {

		for (int y = 0 + offY; y < (GameManager.GAMEHEIGHT / GameManager.GAMETILESIZE) + offY; y++) {
			for (int x = 0 + offX; x < (GameManager.GAMEWIDTH / GameManager.GAMETILESIZE) + offX; x++) {

				if (image.getPixels()[(y * image.getWidth()) + x] == 0xff00ff00) {		
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 0, 0);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }

				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff006400) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 0, 1);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }

				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff0000ff) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 0, 2);
					if (combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }

				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff000064) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 0, 3);
					if (combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }

				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff640064) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 0, 5);
					if (combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff6464ff) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 0, 6);
					if (combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }

				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff643200) {
						renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 0, 7);
					if (combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }

				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xffff0000) {
						renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 1, 6);
					if (combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
	
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff505050) {
						renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 0, 8);
					if (combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = false; }
					}
					
				
			}

		}

	}

}
