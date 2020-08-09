package com.redhaan.adventurersGalore;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import com.redhaan.adventurersGalore.calendar.Calendar;
import com.redhaan.adventurersGalore.combat.Combat;
import com.redhaan.adventurersGalore.combat.PowAnimation;
import com.redhaan.adventurersGalore.entity.adventurer.Adventurers;
import com.redhaan.adventurersGalore.entity.adventurer.personality.Conversations;
import com.redhaan.adventurersGalore.entity.party.Party;
import com.redhaan.adventurersGalore.entity.party.PartyCohesionCheckerUI;
import com.redhaan.adventurersGalore.entity.party.TravelerEngine;
import com.redhaan.adventurersGalore.entity.town.Towns;
import com.redhaan.adventurersGalore.inTown.TownMap;
import com.redhaan.adventurersGalore.partyScreen.PartyScreen;
import com.redhaan.adventurersGalore.quest.Quests;
import com.redhaan.adventurersGalore.quest.questUI.QuestUI;
import com.redhaan.adventurersGalore.questScreen.QuestScreen;
import com.redhaan.adventurersGalore.settings.SavePopup;
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

	protected static ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
	
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
		gameObjects.add(new Quests());
		gameObjects.add(new QuestUI());
		gameObjects.add(new Transition());
		gameObjects.add(new Conversations());
		gameObjects.add(new PartyCohesionCheckerUI());
		gameObjects.add(new QuestScreen());
		gameObjects.add(new SavePopup());		
		gameObjects.add(new TravelerEngine());		
		
		adventurers = new Adventurers();
		//gameObjects.add(adventurers);

		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		if(gameContainer.getInput().isKeyUp(KeyEvent.VK_ESCAPE)) {
			GameContainer.running = false;
		}
		
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
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		float screenHeight = (float) screenSize.getHeight();
		float scale = screenHeight / (GAMEHEIGHT); 
		gameContainer.setScale(scale);
		
		System.out.println("Screen width: " + screenSize.getWidth());
		System.out.println("Screen height: " + screenHeight);
		System.out.println("Scale: " + scale);
		System.out.println("Game Width: " + GAMEWIDTH);
		System.out.println("Game Height: " + GAMEHEIGHT);
		System.out.println("Scaled width: " + GAMEWIDTH * scale);
		System.out.println("Scaled height: " + GAMEHEIGHT * scale);
		
		gameContainer.start();
		
	}

}
