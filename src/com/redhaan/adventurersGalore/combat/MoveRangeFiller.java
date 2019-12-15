package com.redhaan.adventurersGalore.combat;

import java.util.ArrayList;

import com.redhaan.adventurersGalore.GameManager;

public abstract class MoveRangeFiller {
	
	public static ArrayList<int[]> fillMoveRange(int x, int y, int move) {
		
		ArrayList<int[]> tempArray = new ArrayList<int[]>();
		
		int counter = move;
		
		while (counter >= 1) {
			
			tempArray.add(new int[] {x, (y + counter) });
			tempArray.add(new int[] {x, (y - counter) });
			
			for (int i = 1; i < (move - counter) + 1; i++) {
				tempArray.add(new int[] { x + i, (y + counter) });
				tempArray.add(new int[] { x - i, (y + counter) });
				tempArray.add(new int[] { x + i, (y - counter) });
				tempArray.add(new int[] { x - i, (y - counter) });

			}
			
			counter--;
		}
		
		for (int i = 1; i < move + 1; i++) {
			tempArray.add(new int[] { x + i, y });
			tempArray.add(new int[] { x - i, y });
		}		
		
		
		ArrayList<int[]> withoutHeroesList = new ArrayList<int[]>();
		for (int i = 0; i < tempArray.size(); i++) {

			boolean canNotBeAdded = false;

			for (int ii = 0; ii < GameManager.adventurers.allAdventurers.size(); ii++) {
				if(tempArray.get(i)[0] == GameManager.adventurers.allAdventurers.get(ii).getCombatX() &&
						tempArray.get(i)[1] == GameManager.adventurers.allAdventurers.get(ii).getCombatY()) {
					canNotBeAdded = true;
				}
			}
			
			if(!canNotBeAdded) {
				withoutHeroesList.add(tempArray.get(i));
			}
			
			
		}
		
		ArrayList<int[]> withoutEnemiesList = new ArrayList<int[]>();
		for (int i = 0; i < withoutHeroesList.size(); i++) {

			boolean canNotBeAdded = false;

			for (int ii = 0; ii < Combat.enemies.size(); ii++) {
				if(withoutHeroesList.get(i)[0] == Combat.enemies.get(ii).getCombatX() &&
						withoutHeroesList.get(i)[1] == Combat.enemies.get(ii).getCombatY()) {
					canNotBeAdded = true;
				}
			}
			
			if(!canNotBeAdded) {
				withoutEnemiesList.add(withoutHeroesList.get(i));
			}
			
			
		}
		
		
		
		
		
		
		return withoutEnemiesList;

	}

}
