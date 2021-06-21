package com.redhaan.adventurersGalore.entity.town.building.blacksmith.sharpeningScreen;

import java.util.ArrayList;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.item.weapon.WeaponType;
import com.redhaan.adventurersGalore.inventory.Inventory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class SwordSubScreen extends GameObject {
	
	
	private ArrayList<ItemRow> swordRows;

	public SwordSubScreen() {
		
		swordRows = new ArrayList<ItemRow>();
		
	}
	
	
	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		for (ItemRow row: swordRows) {
			row.update(gameContainer, deltaTime);
		}
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		for (ItemRow row: swordRows) {
			row.render(gameContainer, renderer);
		}
		
	}
	
	
	public void initialise() {
		
		swordRows.clear();
		
		int order = 0;
		for (int i = 0; i < Inventory.weapons.size(); i++) {
			if (Inventory.weapons.get(i).type == WeaponType.SWORD) {
				swordRows.add(new ItemRow(Inventory.weapons.get(i), order));
				order++;
			}
		}
		
	}

}
