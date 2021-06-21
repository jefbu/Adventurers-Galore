package com.redhaan.adventurersGalore.dungeon;

import java.util.ArrayList;

import com.redhaan.adventurersGalore.GameObject;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class Dungeons extends GameObject {
	
	private static final long serialVersionUID = 1L;
	public static ArrayList<Dungeon> allDungeons;
	DungeonFactory dungeonFactory; 
	
	public Dungeons() {
		
		super();
		allDungeons = new ArrayList<Dungeon>();
		dungeonFactory = new DungeonFactory();
		
		allDungeons.add(dungeonFactory.createRandomDungeon());
		allDungeons.add(dungeonFactory.createRandomDungeon());
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		for (Dungeon dungeon: allDungeons) {
			dungeon.update(gameContainer, deltaTime);
		}
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		for (Dungeon dungeon: allDungeons) {
			dungeon.render(gameContainer, renderer);
		}		
	} 
	
	

}
