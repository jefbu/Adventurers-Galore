package com.redhaan.adventurersGalore.entity.town.building.blacksmith.scrappingScreen;

import java.util.ArrayList;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.item.weapon.WeaponType;
import com.redhaan.adventurersGalore.inventory.Inventory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class BowSubScreen extends GameObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<ItemRow> bowRows;
	
	
	public BowSubScreen() {
		
		bowRows = new ArrayList<ItemRow>();
		
	}
	
	
	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		
		for (ItemRow row: bowRows) {
			row.update(gameContainer, deltaTime);
		}
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		for (ItemRow row: bowRows) {
			row.render(gameContainer, renderer);
		}
		
	}
	
	public void initialise() {
		
	bowRows.clear();
	
	int order = 0;
	for (int i = 0; i < Inventory.weapons.size(); i++) {
		if (Inventory.weapons.get(i).type == WeaponType.BOW) {
			bowRows.add(new ItemRow(Inventory.weapons.get(i), order));
			order++;
			}
		}
		
	}
	
	
	

}
