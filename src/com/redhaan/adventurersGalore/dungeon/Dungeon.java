package com.redhaan.adventurersGalore.dungeon;

import java.util.ArrayList;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.Toast;
import com.redhaan.adventurersGalore.combat.Combat;
import com.redhaan.adventurersGalore.combat.Deployer;
import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;
import com.redhaan.adventurersGalore.entity.enemies.Enemy;
import com.redhaan.adventurersGalore.entity.party.Party;
import com.redhaan.adventurersGalore.worldMap.WorldMap;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class Dungeon extends GameObject {
	
	private static final long serialVersionUID = 1L;
	
	public int xLocation, yLocation;
	public int tileRow;
	public boolean discovered;
	private static ImageTile worldMapDungeonTiles = new ImageTile("/spritesheets/mapTiles2.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE);
	public DungeonPopup popup;
	ArrayList<DungeonRoom> dungeonRooms;
	public int activeRoom;
	public int dungeonLayoutType;
	
	private DungeonMiniMap miniMap;
	private DungeonConclusion dungeonConclusion;
	private boolean bossDefeated;
	
	public int lootCollected;
	
	public int expiration;
	protected boolean renewable;
	private boolean initialised;
		

	public Dungeon() {
		
		discovered = false;
		popup = new DungeonPopup(this);
		dungeonLayoutType = 1;
		activeRoom = 0;
		bossDefeated = false;
		tileRow = 0;
		lootCollected = 0;
		expiration = 0;
		renewable = false;
		initialised = false;

	}
	
	public void initialise() {
		
		dungeonRooms = DungeonRoomFactory.createDungeonRooms(dungeonLayoutType);
		miniMap = new DungeonMiniMap(this);
		miniMap.miniMapTiles.get(dungeonRooms.get(activeRoom).gridNumber).discovered = true;
		dungeonConclusion = new DungeonConclusion(this);
		
		for (DungeonRoom room: dungeonRooms) {
			for (MiniMapTile tile: miniMap.miniMapTiles) {
				if (room.gridNumber == tile.orderNumber) {
					if (room.rightRoom < 99) { tile.hasHorizontalLineToTheRight = true; }
					if (room.bottomRoom < 99) { tile.hasVerticalLineToTheTop = true; }
					if (room.leftRoom < 99) { tile.hasHorizontalLineToTheLeft = true; }
					if (room.topRoom < 99) { tile.hasVerticalLineToTheBottom = true; }
				}
			}
		}
		
		initialised = true;
		
	}
	
	

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		switch(GameManager.gameState) {
		
		case WorldMap:
			
			switch(WorldMap.subState) {
			
			case DetailMap:
				popup.update(gameContainer, deltaTime);
				break;
				
			case GlobalMap: break;
			case TravelerEvent: break;
			
			}
			
			break;
			
		case Combat: 
	
			if(Combat.dungeon && Party.getxTile() == xLocation && Party.getyTile() == yLocation) {
				
				if(!initialised) { initialise(); }
				
				miniMap.update(gameContainer, deltaTime);
				
				for (int i = 0; i < GameManager.adventurers.allAdventurers.size(); i++) {
					if(GameManager.adventurers.allAdventurers.get(i).inParty && !GameManager.adventurers.allAdventurers.get(i).isDead()) {
					
						if(dungeonRooms.get(activeRoom).hasTreasure && !dungeonRooms.get(activeRoom).treasureChest.collected) {
							if (GameManager.adventurers.allAdventurers.get(i).getCombatX() == dungeonRooms.get(activeRoom).treasureChest.getCombatX() 
									&& GameManager.adventurers.allAdventurers.get(i).getCombatY() == dungeonRooms.get(activeRoom).treasureChest.getCombatY()) {
								
								if(dungeonRooms.get(activeRoom).treasureChest.trapDisarmed(GameManager.adventurers.allAdventurers.get(i))) {
													
									dungeonRooms.get(activeRoom).treasureChest.collected = true;
									Toast.activate(true, "Found treasure!", 
											GameManager.adventurers.allAdventurers.get(i).getCombatX() * GameManager.GAMETILESIZE + 50, 
											GameManager.adventurers.allAdventurers.get(i).getCombatY() * GameManager.GAMETILESIZE - 20);
									lootCollected++;
									
								}
								
								else {
									
									GameManager.adventurers.allAdventurers.get(i).currentStats.HP -= 5;
									dungeonRooms.get(activeRoom).treasureChest.collected = true;
									Toast.activate(false, "Hurt by trap!", 
											GameManager.adventurers.allAdventurers.get(i).getCombatX() * GameManager.GAMETILESIZE + 50, 
											GameManager.adventurers.allAdventurers.get(i).getCombatY() * GameManager.GAMETILESIZE - 20);
									
								}
								
							}
						}
						
						
						if (GameManager.adventurers.allAdventurers.get(i).getCombatX() == 12 && GameManager.adventurers.allAdventurers.get(i).getCombatY() == 0) {
							if (dungeonRooms.get(activeRoom).topRoom < 20) { 
									changeRoom(1);
									for (Adventurer adventurer: GameManager.adventurers.allAdventurers) {
										if (adventurer.inParty) {
											adventurer.turnPassed = false;
											adventurer.hasMoved = false;
											adventurer.hasActed = false;
											adventurer.selected = false;
										}
									}
								} 	
						}
						else if (GameManager.adventurers.allAdventurers.get(i).getCombatX() == 19 && GameManager.adventurers.allAdventurers.get(i).getCombatY() == 7) {
							if (dungeonRooms.get(activeRoom).rightRoom < 20) { 
									changeRoom(2);
									for (Adventurer adventurer: GameManager.adventurers.allAdventurers) {
										if (adventurer.inParty) {
											adventurer.turnPassed = false;
											adventurer.hasMoved = false;
											adventurer.hasActed = false;
											adventurer.selected = false;
										}
									}
								} 
						}
						else if (GameManager.adventurers.allAdventurers.get(i).getCombatX() == 12 && GameManager.adventurers.allAdventurers.get(i).getCombatY() == 14) {
							if (dungeonRooms.get(activeRoom).bottomRoom < 20) { 
									changeRoom(3);
									for (Adventurer adventurer: GameManager.adventurers.allAdventurers) {
										if (adventurer.inParty) {
											adventurer.turnPassed = false;
											adventurer.hasMoved = false;
											adventurer.hasActed = false;
											adventurer.selected = false;
										}
									}
								} 
						}
						else if (GameManager.adventurers.allAdventurers.get(i).getCombatX() == 5 && GameManager.adventurers.allAdventurers.get(i).getCombatY() == 7) {
							if (dungeonRooms.get(activeRoom).leftRoom < 20) { 
									changeRoom(4);
									for (Adventurer adventurer: GameManager.adventurers.allAdventurers) {
										if (adventurer.inParty) {
											adventurer.turnPassed = false;
											adventurer.hasMoved = false;
											adventurer.hasActed = false;
											adventurer.selected = false;
										}
									}
								} 
						}				
					
					}
									
				}

				//dungeonRooms.get(activeRoom).update(gameContainer, deltaTime);
				
				if(bossDefeated) { dungeonConclusion.update(gameContainer, deltaTime); }
				
				else if (dungeonRooms.get(activeRoom).enemyType == 2) {
					boolean victory = true;
					for (Enemy enemy: dungeonRooms.get(activeRoom).enemies) {
						if (!enemy.isDead()) { victory = false; }
							
						if(victory) { 
							lootCollected++;
							bossDefeated = true; 
							}
		
					}
				}
				
			}

			
			break;
		
		
		
		
		case InTown: break;
		case Inventory: break;
		case PartyCohesionCheckerUI: break;
		case PartyScreen: break;
		case QuestScreen: break;
		case QuestUI: break;
		case Titlescreen: break;
		case Transition: break;
		
		}

		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		

		
		switch(GameManager.gameState) {
		
		case WorldMap:
			
			switch(WorldMap.subState) {
			
			case DetailMap:
				
				if(discovered) {
					
					if (xLocation < WorldMap.getOffX() + (GameManager.GAMEWIDTH / GameManager.GAMETILESIZE)
							&& xLocation > WorldMap.getOffX() - (GameManager.GAMEWIDTH / GameManager.GAMETILESIZE)
							&& yLocation < WorldMap.getOffY() + (GameManager.GAMEHEIGHT / GameManager.GAMETILESIZE)
							&& yLocation > WorldMap.getOffY()
									- (GameManager.GAMEHEIGHT / GameManager.GAMETILESIZE)) {
						renderer.drawImageTile(worldMapDungeonTiles, (xLocation - WorldMap.getOffX()) * GameManager.GAMETILESIZE,
								(yLocation - WorldMap.getOffY()) * GameManager.GAMETILESIZE, 3, tileRow);
					}
				
				}
				
					popup.render(gameContainer, renderer);


				
				break;
				
			case GlobalMap: break;
			case TravelerEvent: break;
			}

			break;
			
		case Combat: 
			
			if (Combat.dungeon && Party.getxTile() == xLocation && Party.getyTile() == yLocation) {
				
				if (bossDefeated) { dungeonConclusion.render(gameContainer, renderer); }
				
				else {
					
				miniMap.render(gameContainer, renderer);
				
				if(dungeonRooms.get(activeRoom).hasTreasure && !dungeonRooms.get(activeRoom).treasureChest.collected) {
					dungeonRooms.get(activeRoom).treasureChest.render(gameContainer, renderer);
				}
				
				if (dungeonRooms.get(activeRoom).topRoom < 99) { renderer.drawRectOpaque(384, 0, 32, 32, 0x55ffffff); }
				if (dungeonRooms.get(activeRoom).rightRoom < 99) { renderer.drawRectOpaque(608, 224, 32, 32, 0x55ffffff); }
				if (dungeonRooms.get(activeRoom).bottomRoom < 99) { renderer.drawRectOpaque(384, 448, 32, 32, 0x55ffffff); }
				if (dungeonRooms.get(activeRoom).leftRoom < 99) { renderer.drawRectOpaque(160, 224, 32, 32, 0x55ffffff); }
				
				}
				
			}
	
			break;
			
			
		case InTown: break;
		case Inventory: break;
		case PartyCohesionCheckerUI: break;
		case PartyScreen: break;
		case QuestScreen: break;
		case QuestUI: break;
		case Titlescreen: break;
		case Transition: break;
		
		}		
	}

	
	private void changeRoom(int direction) {
		
		switch(direction) { 
		
		case 1: activeRoom = dungeonRooms.get(activeRoom).topRoom; break;
		case 2: activeRoom = dungeonRooms.get(activeRoom).rightRoom; break;
		case 3: activeRoom = dungeonRooms.get(activeRoom).bottomRoom; break;
		case 4: activeRoom = dungeonRooms.get(activeRoom).leftRoom; break;		
		
		}
		
		if (dungeonRooms.get(activeRoom).enemies.size() > 0 && !dungeonRooms.get(activeRoom).enemiesDefeated) {
			Combat.enemies = dungeonRooms.get(activeRoom).enemies;
			Deployer.dungeonDeployEnemies = true;
		}
		
		Deployer.deploy(direction);
		Combat.combatMap = dungeonRooms.get(activeRoom).dungeonMap;
		miniMap.miniMapTiles.get(dungeonRooms.get(activeRoom).gridNumber).discovered = true;

		
	}
	
	
	
	
	
	
}
