package com.redhaan.adventurersGalore.inventory.InventoryScreen;

import java.util.ArrayList;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.item.armour.Armour;
import com.redhaan.adventurersGalore.inventory.Inventory;
import com.redhaan.adventurersGalore.partyScreen.PartyScreen;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class ArmourInventory extends GameObject {

	private static final long serialVersionUID = 1L;
	
	protected boolean updated;
	private ArrayList<ArmourRow> armourRows;
	private int modifier;
	

	public ArmourInventory() {
		
		updated = false;
		armourRows = new ArrayList<ArmourRow>();
		modifier = 0;
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		if (!updated) {
						
			armourRows.clear();
			
			if(Inventory.armourChange) { 
				armourRows.add(new ArmourRow((Armour) GameManager.adventurers.allAdventurers.get(PartyScreen.member).armour, 0));
				modifier = 1;
				}
			else { modifier = 0; }
			
			for (int i = 0; i < Inventory.armours.size(); i++) {

				armourRows.add(new ArmourRow((Armour) Inventory.armours.get(i), i + modifier));
				
			}
			
			updated = true;
			
		}
		
		for (int i = 0; i < armourRows.size(); i++) {
			armourRows.get(i).update(gameContainer, deltaTime);
		}
		
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		for (int i = 0; i < armourRows.size(); i++) {
			armourRows.get(i).render(gameContainer, renderer);
		}
		
	}

}
