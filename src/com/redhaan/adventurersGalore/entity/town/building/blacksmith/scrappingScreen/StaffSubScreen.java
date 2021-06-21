package com.redhaan.adventurersGalore.entity.town.building.blacksmith.scrappingScreen;

import java.util.ArrayList;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.item.weapon.WeaponType;
import com.redhaan.adventurersGalore.inventory.Inventory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class StaffSubScreen extends GameObject {
	
	private ArrayList<ItemRow> staffRows;

	public StaffSubScreen() {
		
		staffRows = new ArrayList<ItemRow>();
		
	}
	
	
	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		for (ItemRow row: staffRows) {
			row.update(gameContainer, deltaTime);
		}
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		for (ItemRow row: staffRows) {
			row.render(gameContainer, renderer);
		}
		
	}
	
	
	public void initialise() {
		
		staffRows.clear();
		
		int order = 0;
		for (int i = 0; i < Inventory.weapons.size(); i++) {
			if (Inventory.weapons.get(i).type == WeaponType.STAFF) {
				staffRows.add(new ItemRow(Inventory.weapons.get(i), order));
				order++;
			}
		}
		
	}

}
