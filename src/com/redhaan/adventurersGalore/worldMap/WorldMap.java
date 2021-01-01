package com.redhaan.adventurersGalore.worldMap;

import java.awt.event.MouseEvent;
import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.party.Party;
import com.redhaan.adventurersGalore.entity.party.TravelerEngine;
import com.redhaan.adventurersGalore.entity.party.travelerEvent.TravelerEvent;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.audio.SoundClip;
import gameEngine.ecclesiastes.gfx.Image;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class WorldMap extends GameObject {

	private static final long serialVersionUID = 1L;
	public static SubState subState;
	public static SubState previousSubState;
	private LevelDrawer levelDrawer;
	private Image globalMap;
	private Image detailMap;
	private static int offX, offY;
	private static int scrollSpeedControlX, scrollSpeedControlY;
	public WorldMapTileInfo worldMapTileInfo;
	private TravelerEvent baseEvent;

	private ImageTile birds;
	private boolean birdsFlying;
	private int birdsX, birdsY;
	private int birdsCounter;

	private Image clouds;
	private int cloudsX, cloudsY;
	private int cloudsCounter;
	
	public static SoundClip soundClip;
	public static boolean soundStarted;

	Random random;

	public WorldMap() {
		subState = SubState.GlobalMap;
		levelDrawer = new LevelDrawer();
		globalMap = new Image("/worldMap/WorldMap.png");
		detailMap = new Image("/worldMap/DetailMap2.png");

		random = new Random();
		birds = new ImageTile("/worldMap/birds.png", GameManager.GAMETILESIZE * 2, GameManager.GAMETILESIZE * 2);
		birdsFlying = false;
		birdsX = random.nextInt(GameManager.GAMEWIDTH);
		birdsY = GameManager.GAMEHEIGHT - 10;
		birdsCounter = 0;

		clouds = new Image("/worldMap/clouds.png");
		cloudsX = 0;
		cloudsY = 0;
		cloudsCounter = 0;

		worldMapTileInfo = new WorldMapTileInfo();

		offX = 0;
		offY = 0;
		scrollSpeedControlX = 0;
		scrollSpeedControlY = 0;

		baseEvent = new TravelerEvent();
		
		soundClip = new SoundClip("/worldmap.wav");
		soundStarted = false;

	}

	public void update(GameContainer gameContainer, float deltaTime) {

		switch (GameManager.gameState) {

		case Titlescreen: break;
		case Combat: break;
		case InTown: break;
		case PartyScreen: break;
		case QuestUI: break;
		case Transition: break;
		case QuestScreen: break;
		case PartyCohesionCheckerUI: break;
		case Inventory: break;

		case WorldMap:
			
			if(!soundStarted) { soundClip.loop(); soundStarted = true; }
			
			switch (subState) {
			case DetailMap:
				if (gameContainer.getInput().getScroll() < 0) {
					offX = 0;
					offY = 0;
					subState = SubState.GlobalMap;
				}

				if (gameContainer.getInput().getMouseX() > 600) {
					scrollSpeedControlX++;
					if (scrollSpeedControlX > 3) {
						if (offX < 140) {
							offX++;
							scrollSpeedControlX = 0;
						}
					}
				} else if (gameContainer.getInput().getMouseX() < 40) {
					scrollSpeedControlX++;
					if (scrollSpeedControlX > 3) {
						if (offX > 0) {
							offX--;
							scrollSpeedControlX = 0;
						}
					}
				}

				if (gameContainer.getInput().getMouseY() > 440) {
					scrollSpeedControlY++;
					if (scrollSpeedControlY > 3) {
						if (offY < 105) {
							offY++;
							scrollSpeedControlY = 0;
						}
					}
				} else if (gameContainer.getInput().getMouseY() < 40) {
					scrollSpeedControlY++;
					if (scrollSpeedControlY > 3) {
						if (offY > 0) {
							offY--;
							scrollSpeedControlY = 0;
						}
					}
				}

				if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON3)) {
					Party.setxDestinationTile(
							(offX + (gameContainer.getInput().getMouseX() / GameManager.GAMETILESIZE)));
					Party.setyDestinationTile(offY + (gameContainer.getInput().getMouseY() / GameManager.GAMETILESIZE));
					TravelerEngine.traveling = true;
				}
				if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
					System.out.println(offX + gameContainer.getInput().getMouseX() / GameManager.GAMETILESIZE);
					System.out.println(offY + gameContainer.getInput().getMouseY() / GameManager.GAMETILESIZE);
				}


				break;
				
			case GlobalMap:

				cloudsCounter++;
				if (cloudsCounter > 5) {
					cloudsX--;
					cloudsCounter = 0;
				}

				if (cloudsX < -GameManager.GAMEWIDTH * 4) {
					cloudsX = 0;
				}

				if (birdsFlying) {

					birdsX++;
					birdsY--;
					if (random.nextInt(100) > 80) {
						birdsCounter++;
					}
					if (birdsCounter > 3) {
						birdsCounter = 0;
					}

					if (birdsX > GameManager.GAMEWIDTH + 64 || birdsY < -64) {
						birdsFlying = false;
						birdsX = random.nextInt(GameManager.GAMEWIDTH);
						birdsY = GameManager.GAMEHEIGHT - 10;
						birdsCounter = 0;
					}
				} else {
					if (random.nextInt(1000) > 995) {
						birdsFlying = true;
					}
				}

				if (gameContainer.getInput().getScroll() > 0) {
					offX = (gameContainer.getInput().getMouseX() / 4
							- (GameManager.GAMEWIDTH / GameManager.GAMETILESIZE / 2));
					if (offX > 140)
						offX = 140;
					if (offX < 0)
						offX = 0;
					offY = (gameContainer.getInput().getMouseY() / 4
							- (GameManager.GAMEHEIGHT / GameManager.GAMETILESIZE / 2));
					if (offY > 105)
						offY = 105;
					if (offY < 0)
						offY = 0;
					subState = SubState.DetailMap;
				}

				if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON3)) {
					Party.setDestination(gameContainer.getInput().getMouseX() / 4,
							gameContainer.getInput().getMouseY() / 4);
					TravelerEngine.traveling = true;
				}
				break;
			case TravelerEvent:
				baseEvent.update(gameContainer, deltaTime);
				break;
			}

			break;

		}

	}

	public void render(GameContainer gameContainer, Renderer renderer) {
		switch (GameManager.gameState) {

		case Titlescreen: break;
		case InTown: break;
		case Combat: break;
		case PartyScreen: break;
		case QuestUI: break;
		case Transition: break;
		case QuestScreen: break;
		case PartyCohesionCheckerUI: break;
		case Inventory: break;

		case WorldMap:

			switch (subState) {
			case GlobalMap:

				renderer.drawImage(globalMap, 0, 0);

				renderer.drawImage(clouds, cloudsX, cloudsY);

				if (birdsFlying) {
					renderer.drawImageTile(birds, birdsX, birdsY, birdsCounter, 0);
				}
				break;
			case DetailMap:
				levelDrawer.drawLevel(renderer, detailMap, offX, offY, false);
				break;
			case TravelerEvent:
				switch (previousSubState) {
				case GlobalMap:
					renderer.drawImage(globalMap, 0, 0);
					break;
				case DetailMap:
					levelDrawer.drawLevel(renderer, detailMap, offX, offY, false);
					break;
				case TravelerEvent:
					System.out.println("Error: Previous Substate was TravelerEvent");
					break;
				}
				baseEvent.render(gameContainer, renderer);
			}
		}

	}

	public static SubState getSubState() {
		return subState;
	}

	public static int getOffX() {
		return offX;
	}

	public static int getOffY() {
		return offY;
	}

}
