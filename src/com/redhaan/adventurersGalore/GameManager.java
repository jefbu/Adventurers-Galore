package com.redhaan.adventurersGalore;

import java.util.ArrayList;

import com.redhaan.adventurersGalore.calendar.Calendar;
import com.redhaan.adventurersGalore.combat.Combat;
import com.redhaan.adventurersGalore.combat.PowAnimation;
import com.redhaan.adventurersGalore.entity.adventurer.Adventurers;
import com.redhaan.adventurersGalore.entity.party.Party;
import com.redhaan.adventurersGalore.entity.party.TravelerEngine;
import com.redhaan.adventurersGalore.entity.town.Towns;
import com.redhaan.adventurersGalore.inTown.TownMap;
import com.redhaan.adventurersGalore.partyScreen.PartyScreen;
import com.redhaan.adventurersGalore.titleScreen.TitleScreen;
import com.redhaan.adventurersGalore.worldMap.WorldMap;

import gameEngine.ecclesiastes.AbstractGame;
import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class GameManager extends AbstractGame {

	public static final int GAMETILESIZE = 32;
	public static final int GAMEWIDTH = 640;
	public static final int GAMEHEIGHT = 480;
	public static GameState gameState = GameState.Titlescreen;
	
	public static Adventurers adventurers;

	private ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
	
	public GameManager() {

		gameObjects.add(new WorldMap());
		gameObjects.add(new TownMap());
		gameObjects.add(new Calendar());
		gameObjects.add(new TitleScreen());
		gameObjects.add(new Combat());
		gameObjects.add(new Towns());
		gameObjects.add(new Party());
		gameObjects.add(new PartyScreen());
		gameObjects.add(new PowAnimation());
		
		adventurers = new Adventurers();
		//gameObjects.add(adventurers);
				
		gameObjects.add(new TravelerEngine());
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		for (int i = 0; i < gameObjects.size(); i++) {
			gameObjects.get(i).update(gameContainer, deltaTime);

			if (gameObjects.get(i).isDead()) {
				gameObjects.remove(i);
				i--;
			}
		}

	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		for (GameObject gameObject : gameObjects) {
			gameObject.render(gameContainer, renderer);
		}

	}

	public static void main(String args[]) {

		GameContainer gameContainer = new GameContainer(new GameManager());
		gameContainer.setWidth(GAMEWIDTH);
		gameContainer.setHeight(GAMEHEIGHT);
		gameContainer.setScale(1.50f);
		gameContainer.start();
		
	}

}
