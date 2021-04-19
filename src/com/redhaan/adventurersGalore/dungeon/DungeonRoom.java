package com.redhaan.adventurersGalore.dungeon;

import java.util.ArrayList;
import java.util.Random;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.combat.CombatMap;
import com.redhaan.adventurersGalore.entity.TreasureChest;
import com.redhaan.adventurersGalore.entity.enemies.Bat;
import com.redhaan.adventurersGalore.entity.enemies.Enemy;
import com.redhaan.adventurersGalore.entity.enemies.GiantBat;
import com.redhaan.adventurersGalore.entity.enemies.Snake;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class DungeonRoom extends GameObject {

	private static final long serialVersionUID = 1L;
	public ArrayList<Enemy> enemies;
	public int leftRoom, rightRoom, topRoom, bottomRoom;
	public int gridNumber;
	
	public boolean discovered, currentLocation;
	public boolean enemiesDefeated;
	public int enemyType;
	
	protected CombatMap dungeonMap;
	
	public boolean hasTreasure;
	public TreasureChest treasureChest;
	
	
	public DungeonRoom(int gridNumber, int topRoom, int rightRoom, int bottomRoom, int leftRoom, int enemyType) {
		
		this.topRoom = topRoom;
		this.rightRoom = rightRoom;
		this.bottomRoom = bottomRoom;
		this.leftRoom = leftRoom;
		
		this.gridNumber = gridNumber;
		this.enemyType = enemyType;
		
		discovered = false;
		currentLocation = false;
		enemiesDefeated = false;
		
		enemies = new ArrayList<Enemy>();
		
		rollEnemies(enemyType);
		
		dungeonMap = DungeonMapChooser.chooseDungeonMap();
		
		hasTreasure = false;
			
	}
	

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
	}
	
	
	
	private void rollEnemies(int enemyType) {
		
		Random random = new Random();
		
		switch(enemyType) {
		
		case 0: break;
		
		case 1:
			int roll = random.nextInt(100) + 1;
			enemies.add(new Bat());
			if (roll > 10) { enemies.add(new Bat()); }
			if (roll > 30) { enemies.add(new Bat()); }
			if (roll > 60) { enemies.add(new GiantBat()); }
			if (roll > 90) { enemies.add(new Bat()); }
			break;
			
		case 2:
			enemies.add(new Snake());
			break;
			
		}
		
		
	}
	
	
	
	

}
