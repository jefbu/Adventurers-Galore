package com.redhaan.adventurersGalore.dungeon;

import java.util.ArrayList;
import java.util.Random;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.calendar.Calendar;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class Dungeons extends GameObject {
	
	private static final long serialVersionUID = 1L;
	public static ArrayList<Dungeon> allDungeons;
	DungeonFactory dungeonFactory; 
	private int daysPassed;
	
	public Dungeons() {
		
		super();
		allDungeons = new ArrayList<Dungeon>();
		dungeonFactory = new DungeonFactory();
				
		allDungeons.add(dungeonFactory.createRandomDungeon());
		allDungeons.add(dungeonFactory.createRandomDungeon());
		
		daysPassed = 0;
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		boolean dayPassed = false;
		if (Calendar.daysPassed != daysPassed) {
			dayPassed = true;
			daysPassed++;
		}
		
		for (int i = 0; i < allDungeons.size(); i++) {
			
				if (dayPassed) { allDungeons.get(i).expiration--; }
				
				if (allDungeons.get(i).expiration == 0) {
					if (allDungeons.get(i).renewable) { allDungeons.add(dungeonFactory.createRandomDungeon()); }
					allDungeons.remove(i);
					i--;
					
				}			
				else { allDungeons.get(i).update(gameContainer, deltaTime); }
		}
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		for (Dungeon dungeon: allDungeons) {
			dungeon.render(gameContainer, renderer);
		}		
	} 
	
	

}
