package com.redhaan.adventurersGalore.entity.town.building.blacksmith.scrappingScreen;

import java.util.ArrayList;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.item.weapon.WeaponType;
import com.redhaan.adventurersGalore.inventory.Inventory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class DaggerSubScreen extends GameObject {

	private ArrayList<ItemRow> daggerRows;	
	
	public DaggerSubScreen() {
		
		daggerRows = new ArrayList<ItemRow>();

	}	

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
				
		for (ItemRow row: daggerRows) {
			row.update(gameContainer, deltaTime);
		}
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		for (ItemRow row: daggerRows) {
			row.render(gameContainer, renderer);
		}
		
	}
	
	
	public void initialise() {
		
		daggerRows.clear();
		
		int order = 0;
		for (int i = 0; i < Inventory.weapons.size(); i++) {
			if (Inventory.weapons.get(i).type == WeaponType.DAGGER) {
				daggerRows.add(new ItemRow(Inventory.weapons.get(i), order));
				order++;
			}
		}
		
	}
	
	
	
}
