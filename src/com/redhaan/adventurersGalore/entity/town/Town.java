package com.redhaan.adventurersGalore.entity.town;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.GameState;
import com.redhaan.adventurersGalore.entity.town.building.Building;
import com.redhaan.adventurersGalore.entity.town.building.BuildingFactory;
import com.redhaan.adventurersGalore.inTown.TownMap;
import com.redhaan.adventurersGalore.worldMap.WorldMap;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class Town extends GameObject {

	public String name;
	private int[] xLocations;
	private int[] yLocations;
	private ImageTile tileSet;

	public ArrayList<Building> buildings;
		
	public Town(String name, int[] xLocations, int[] yLocations) {

		this.name = name;
		this.xLocations = xLocations;
		this.yLocations = yLocations;
		tileSet = new ImageTile("/spritesheets/mapTiles.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE);
		
		buildings = BuildingFactory.createTownBuildings(xLocations.length);

	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		switch (GameManager.gameState) {

		case InTown: break;
		case Titlescreen: break;
		case Combat: break;

		case WorldMap:
			switch (WorldMap.getSubState()) {

			case GlobalMap:
				break;

			case DetailMap:

				if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {

					for (int i = 0; i < xLocations.length; i++) {
						if (
						WorldMap.getOffX() + gameContainer.getInput().getMouseX() / GameManager.GAMETILESIZE == xLocations[i]
						&& WorldMap.getOffY() + gameContainer.getInput().getMouseY() / GameManager.GAMETILESIZE == yLocations[i]) {
							TownMap.activeTown = this;
							GameManager.gameState = GameState.InTown;
						}
					}
				}
				break;
				
			case TravelerEvent: break;

			}
			break;

		}

	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		switch (GameManager.gameState) {

		case Titlescreen: break;
		case Combat: break;
		case InTown: break;
		
		case WorldMap:

			switch (WorldMap.getSubState()) {
			
			case GlobalMap: break;
			case DetailMap:
				for (int i = 0; i < xLocations.length; i++) {

					if (xLocations[i] < WorldMap.getOffX() + (GameManager.GAMEWIDTH / GameManager.GAMETILESIZE)
							&& xLocations[i] > WorldMap.getOffX() - (GameManager.GAMEWIDTH / GameManager.GAMETILESIZE)
							&& yLocations[i] < WorldMap.getOffY() + (GameManager.GAMEHEIGHT / GameManager.GAMETILESIZE)
							&& yLocations[i] > WorldMap.getOffY()
									- (GameManager.GAMEHEIGHT / GameManager.GAMETILESIZE)) {
						renderer.drawImageTile(tileSet, (xLocations[i] - WorldMap.getOffX()) * GameManager.GAMETILESIZE,
								(yLocations[i] - WorldMap.getOffY()) * GameManager.GAMETILESIZE, 0, 4);
					}
				}
				break;
			case TravelerEvent: break;

			}
			break;
		}

	}

	public static Town kaghak = new Town("Kaghak", new int[] { 14, 14, 15 }, new int[] { 12, 11, 11 });
	public static Town datark = new Town("Datark", new int[] { 5, 6 }, new int[] { 9, 9 });
	public static Town apastan = new Town("Apastan", new int[] { 15 }, new int[] { 5 });
	public static Town chahich = new Town("Chahich", new int[] { 24 }, new int[] { 10 });

	public static ArrayList<Town> allTowns = new ArrayList<Town>();

	public int[] getxLocations() {
		return xLocations;
	}

}
