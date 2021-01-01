package com.redhaan.adventurersGalore.worldMap;

import java.io.Serializable;
import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.combat.MoveRangeFiller;

import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.Image;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class LevelDrawer implements Serializable {

	private static final long serialVersionUID = 1L;
	private ImageTile tileSet;
	private Random random;
	private int timer;
	private int roll;
	private int[] xTile;
	
	public LevelDrawer() {

		tileSet = new ImageTile("/spritesheets/mapTiles2.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE);
		random = new Random();
		roll = 0;
		xTile = new int[300];
		timer = 0;
		
	}

	public void drawLevel(Renderer renderer, Image image, int offX, int offY, boolean combatMap) {
		
		if(timer == 0) {
			for (int i = 0; i < 300; i++) {
				roll = random.nextInt(200) + 1;
				if (roll > 199) { xTile[i] = 3; }
				else if (roll > 198) { xTile[i] = 2; }
				else if (roll > 100) { xTile[i] = 1; }
				else { xTile[i] = 0; }
			}
		}
		timer++;
		if (timer == 1800) { timer = 0; }


		for (int y = 0 + offY; y < (GameManager.GAMEHEIGHT / GameManager.GAMETILESIZE) + offY; y++) {
			for (int x = 0 + offX; x < (GameManager.GAMEWIDTH / GameManager.GAMETILESIZE) + offX; x++) {

				//GRASS
				if (image.getPixels()[(y * image.getWidth()) + x] == 0xff00ff00) {						
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, xTile[(y - offY) * (y - offY) + (x - offX)], 0);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				
				//FOREST
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff33aa33) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, xTile[(y - offY) * (y - offY) + (x - offX)], 2);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff55aa33) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 0, 3);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff66aa33) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 1, 3);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff77aa33) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 2, 3);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff88aa33) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 3, 3);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff99aa33) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 4, 3);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff33aa55) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 5, 3);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff33aa66) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 6, 3);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff33aa77) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 7, 3);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff33aa88) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 8, 3);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff33aa99) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 9, 3);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff55aa55) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 10, 3);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff66aa66) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 11, 3);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff77aa77) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 12, 3);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff88aa88) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 13, 3);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff99aa99) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 14, 3);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				
				//OCEAN
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff0000ff) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, xTile[(y - offY) * (y - offY) + (x - offX)], 14);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = false; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff2200ff) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 0, 15);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = false; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff0022ff) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 1, 15);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = false; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff0033ff) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 2, 15);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = false; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff3300ff) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 3, 15);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = false; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff3322ff) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 4, 15);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = false; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff2233ff) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 5, 15);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = false; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff4400ff) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 6, 15);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = false; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff0044ff) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 7, 15);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = false; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff4422ff) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 8, 15);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = false; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff2244ff) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 9, 15);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = false; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff6600ff) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 10, 15);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = false; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff0066ff) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 11, 15);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = false; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff6644ff) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 12, 15);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = false; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff4466ff) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 13, 15);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = false; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff6666ff) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 14, 15);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = false; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff2200aa) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 0, 16);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = false; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff0022aa) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 1, 16);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = false; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff0033aa) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 2, 16);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = false; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff3300aa) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 3, 16);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = false; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff3322aa) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 4, 16);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = false; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff2233aa) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 5, 16);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = false; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff4400aa) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 6, 16);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = false; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff0044aa) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 7, 16);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = false; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff4422aa) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 8, 16);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = false; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff2244aa) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 9, 16);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = false; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff6600aa) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 10, 16);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = false; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff0066aa) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 11, 16);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = false; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff6644aa) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 12, 16);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = false; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff4466aa) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 13, 16);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = false; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff6666aa) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 14, 16);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = false; }

				//SHALLOWS
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff8888ff) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, xTile[(y - offY) * (y - offY) + (x - offX)], 8);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xffccccff) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 0, 9);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff9988ff) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 1, 9);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xffaa88ff) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 2, 9);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xffbb88ff) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 3, 9);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xffcc88ff) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 4, 9);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff8899ff) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 5, 9);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff88aaff) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 6, 9);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff88bbff) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 7, 9);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff88ccff) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 8, 9);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff9999ff) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 9, 9);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff99aaff) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 10, 9);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xffaa99ff) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 11, 9);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xffaaaaff) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 12, 9);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xffbbaaff) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 13, 9);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xffaabbff) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 14, 9);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }

				//SWAMP
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff553377) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, xTile[(y - offY) * (y - offY) + (x - offX)], 4);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff663377) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 0, 5);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff553388) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 1, 5);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff663388) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 2, 5);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff773388) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 3, 5);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff663399) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 4, 5);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff773399) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 5, 5);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff774499) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 6, 5);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff8844aa) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 7, 5);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff9944aa) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 8, 5);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff9944bb) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 9, 5);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff9955bb) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 10, 5);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff9966bb) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 11, 5);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff9977bb) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 12, 5);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff9988bb) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 13, 5);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff9999bb) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 14, 5);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				
				//ICE
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xffffffff) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, xTile[(y - offY) * (y - offY) + (x - offX)], 6);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xffffeeee) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 0, 7);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xffeeffee) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 1, 7);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xffeeeeff) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 2, 7);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xffffffee) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 3, 7);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xffffeeff) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 4, 7);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xffeeffff) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 5, 7);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xffeeeeee) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 6, 7);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xffdddddd) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 7, 7);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xffddeeee) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 8, 7);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xffeeeedd) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 9, 7);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xffeeddee) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 10, 7);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xffddddee) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 11, 7);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xffddeedd) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 12, 7);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xffeedddd) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 13, 7);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xffcccccc) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 14, 7);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }

				//MOUNTAIN
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff995500) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, xTile[(y - offY) * (y - offY) + (x - offX)], 12);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff994400) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 0, 13);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff995511) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 1, 13);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff995522) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 2, 13);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff995533) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 3, 13);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff884400) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 4, 13);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff885500) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 5, 13);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff884411) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 6, 13);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff884422) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 7, 13);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff885511) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 8, 13);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff885522) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 9, 13);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xffaa5522) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 10, 13);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xffaa5511) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 11, 13);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xffaa4422) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 12, 13);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xffaa6622) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 13, 13);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xffaa6611) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 14, 13);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }

				//DESERT
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xffff0000) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, xTile[(y - offY) * (y - offY) + (x - offX)], 10);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xffff2200) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 0, 11);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xffff0022) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 1, 11);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xffff2222) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 2, 11);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xffff4400) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 3, 11);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xffff0044) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 4, 11);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xffff4444) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 5, 11);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xffff6600) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 6, 11);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xffff0066) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 7, 11);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xffff8800) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 8, 11);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xffff0088) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 9, 11);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xffff8888) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 10, 11);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xffffaa00) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 11, 11);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xffff00aa) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 12, 11);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xffffaaaa) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 13, 11);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xffffbbbb) {
					renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 14, 11);
					if(combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = true; }
	
				//WALL
				} else if (image.getPixels()[(y * image.getWidth()) + x] == 0xff505050) {
						renderer.drawImageTile(tileSet, (x - offX) * GameManager.GAMETILESIZE,
							(y - offY) * GameManager.GAMETILESIZE, 1, 7);
					if (combatMap) { MoveRangeFiller.passableTile[y * image.getWidth() + x] = false; }
				}
					
				
			}

		}

	}

}
