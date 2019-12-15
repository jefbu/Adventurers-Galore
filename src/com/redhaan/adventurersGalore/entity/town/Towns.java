package com.redhaan.adventurersGalore.entity.town;

import java.util.ArrayList;

import com.redhaan.adventurersGalore.GameObject;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class Towns extends GameObject {
	
	public static ArrayList<Town> allTowns;
	
	public Towns() {
		
		super();
		allTowns = new ArrayList<Town>();
		allTowns.add(Town.kaghak);
		allTowns.add(Town.datark);
		allTowns.add(Town.apastan);
		allTowns.add(Town.chahich);
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		for (Town town: allTowns) {
			town.update(gameContainer, deltaTime);
		}
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		for (Town town: allTowns) {
			town.render(gameContainer, renderer);
		}		
	} 

}
