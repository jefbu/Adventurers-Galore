package com.redhaan.adventurersGalore.entity.town.building.blacksmith.scrappingScreen;

import java.util.ArrayList;

import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.item.ItemID;
import com.redhaan.adventurersGalore.inventory.Inventory;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class ArmourSubScreen extends GameObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<ItemRow> armourRows;
	
	public ArmourSubScreen() {
		
		armourRows = new ArrayList<ItemRow>();
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		for (ItemRow row: armourRows) {
			row.update(gameContainer, deltaTime);
		}
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		for (ItemRow row: armourRows) {
			row.render(gameContainer, renderer);
		}
		
	}
	
	
	public void initialise() {
		
		armourRows.clear();
		
		int order = 0;
		for (int i = 0; i < Inventory.armours.size(); i++) {
			if (Inventory.armours.get(i).ID == ItemID.Armour) {
				armourRows.add(new ItemRow(Inventory.armours.get(i), order));
				order++;
			}
		}		
		
	}
	
	
	
	
	

}
