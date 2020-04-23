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
		allTowns.add(Town.apastan);
		allTowns.add(Town.ydatopto);
		allTowns.add(Town.omichli);
		allTowns.add(Town.potami);
		allTowns.add(Town.taranau);
		allTowns.add(Town.sioc);
		allTowns.add(Town.hasiera);
		allTowns.add(Town.zuhaitz);
		allTowns.add(Town.ymvernu);
		allTowns.add(Town.nuage);
		allTowns.add(Town.oakheart);
		
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
