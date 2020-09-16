package com.redhaan.adventurersGalore.inventory.InventoryScreen;

import java.util.ArrayList;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.item.weapon.Weapon;
import com.redhaan.adventurersGalore.inventory.Inventory;
import com.redhaan.adventurersGalore.partyScreen.PartyScreen;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class WeaponInventory extends GameObject {

	private static final long serialVersionUID = 1L;

	
	protected boolean updated;
	private ArrayList<WeaponRow> weaponRows;
	private int modifier;
	
	
	public WeaponInventory() {
		
		updated = false;
		weaponRows = new ArrayList<WeaponRow>();
		modifier = 0;
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		if (!updated) {
			
			weaponRows.clear();
			
			if(Inventory.weaponChange) { 
				weaponRows.add(new WeaponRow((Weapon) GameManager.adventurers.allAdventurers.get(PartyScreen.member).weapon, 0));
				modifier = 1;
				}
			else { modifier = 0; }
			
			for (int i = 0; i < Inventory.weapons.size(); i++) {

				weaponRows.add(new WeaponRow((Weapon) Inventory.weapons.get(i), i + modifier));
				
			}
			
			updated = true;
			
		}

		for (int i = 0; i < weaponRows.size(); i++) {
			weaponRows.get(i).update(gameContainer, deltaTime);
		}
		
		
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		for (int i = 0; i < weaponRows.size(); i++) {
			weaponRows.get(i).render(gameContainer, renderer);
		}
		
	}

}
