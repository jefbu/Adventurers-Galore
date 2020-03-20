package com.redhaan.adventurersGalore.combat;

import java.util.ArrayList;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.entity.Monster;
import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;

public abstract class MoveRangeFiller {
	
	public static boolean[] passableTile = new boolean[GameManager.GAMEWIDTH / GameManager.GAMETILESIZE * GameManager.GAMEHEIGHT / GameManager.GAMETILESIZE];

	public static ArrayList<int[]> fillMoveRange(int x, int y, int move) {

		ArrayList<int[]> finalArray = new ArrayList<int[]>();
		ArrayList<int[]> tempArray = new ArrayList<int[]>();
		
		finalArray.add(new int[] { x, y });

		for (int i = 0; i < move; i++) {

			checkIfCanMoveLeft(finalArray, tempArray);
			checkIfCanMoveRight(finalArray, tempArray);
			checkIfCanMoveUp(finalArray, tempArray);
			checkIfCanMoveDown(finalArray, tempArray);
			
			for (int ii = 0; ii < tempArray.size(); ii++) {
				boolean canAdd = true;
				for (int iii = 0; iii < finalArray.size(); iii++) {
					if (tempArray.get(ii)[0] == finalArray.get(iii)[0] && tempArray.get(ii)[1] == finalArray.get(iii)[1]) {
						canAdd = false;
					}
				}
				if (canAdd) { finalArray.add(new int[] { tempArray.get(ii)[0], tempArray.get(ii)[1] }); }
			}
		}

		finalArray.remove(0);
		return finalArray;

	}

	private static void checkIfCanMoveLeft(ArrayList<int[]> finalArray, ArrayList<int[]> tempArray) {

		for (int i = 0; i < finalArray.size(); i++) {
			if (finalArray.get(i)[0] > 0 && isFree(finalArray.get(i)[0] - 1, finalArray.get(i)[1]) && isPassable(finalArray.get(i)[0] - 1, finalArray.get(i)[1])) {
				tempArray.add(new int[] { finalArray.get(i)[0] - 1, finalArray.get(i)[1] });
			}
		}

	}

	private static void checkIfCanMoveRight(ArrayList<int[]> finalArray, ArrayList<int[]> tempArray) {

		for (int i = 0; i < finalArray.size(); i++) {
			if (finalArray.get(i)[0] < GameManager.GAMEWIDTH / GameManager.GAMETILESIZE
					&& isFree(finalArray.get(i)[0] + 1, finalArray.get(i)[1]) && isPassable(finalArray.get(i)[0] + 1, finalArray.get(i)[1])) {
				tempArray.add(new int[] { finalArray.get(i)[0] + 1, finalArray.get(i)[1] });
			}
		}

	}

	private static void checkIfCanMoveUp(ArrayList<int[]> finalArray, ArrayList<int[]> tempArray) {

		for (int i = 0; i < finalArray.size(); i++) {
			if (finalArray.get(i)[1] > 0 && isFree(finalArray.get(i)[0], finalArray.get(i)[1] - 1) && isPassable(finalArray.get(i)[0], finalArray.get(i)[1] - 1)) {
				tempArray.add(new int[] { finalArray.get(i)[0], finalArray.get(i)[1] - 1 });
			}
		}

	}

	private static void checkIfCanMoveDown(ArrayList<int[]> finalArray, ArrayList<int[]> tempArray) {

		for (int i = 0; i < finalArray.size(); i++) {
			if (finalArray.get(i)[1] < GameManager.GAMEHEIGHT / GameManager.GAMETILESIZE
					&& isFree(finalArray.get(i)[0], finalArray.get(i)[1] + 1) && isPassable(finalArray.get(i)[0], finalArray.get(i)[1] + 1)) {
				tempArray.add(new int[] { finalArray.get(i)[0], finalArray.get(i)[1] + 1 });
			}
		}

	}

	private static boolean isFree(int x, int y) {

		boolean free = true;

		for (Adventurer adventurer : GameManager.adventurers.allAdventurers) {
			if (adventurer.inParty && !adventurer.isDead()) {
				if (adventurer.getCombatX() == x && adventurer.getCombatY() == y) {
					free = false;
				}
			}
		}
		
		for (Monster monster: Combat.enemies) {
			if (!monster.isDead()) {
				if (monster.getCombatX() == x && monster.getCombatY() == y) {
						free = false;
				}
			}
		}

		return free;

	}
	
	private static boolean isPassable(int x, int y) {
		if (x >= 0 && x < GameManager.GAMEWIDTH / GameManager.GAMETILESIZE && y >= 0 && y < GameManager.GAMEHEIGHT / GameManager.GAMETILESIZE) {
			if (passableTile[y * GameManager.GAMEWIDTH / GameManager.GAMETILESIZE + x]) {
				return true;
			}
		}
		return false;
	}

	/*
	 * int counter = move;
	 * 
	 * while (counter >= 1) {
	 * 
	 * tempArray.add(new int[] {x, (y + counter) }); tempArray.add(new int[] {x, (y
	 * - counter) });
	 * 
	 * for (int i = 1; i < (move - counter) + 1; i++) { tempArray.add(new int[] { x
	 * + i, (y + counter) }); tempArray.add(new int[] { x - i, (y + counter) });
	 * tempArray.add(new int[] { x + i, (y - counter) }); tempArray.add(new int[] {
	 * x - i, (y - counter) });
	 * 
	 * }
	 * 
	 * counter--; }
	 * 
	 * for (int i = 1; i < move + 1; i++) { tempArray.add(new int[] { x + i, y });
	 * tempArray.add(new int[] { x - i, y }); }
	 * 
	 * 
	 * ArrayList<int[]> withoutHeroesList = new ArrayList<int[]>(); for (int i = 0;
	 * i < tempArray.size(); i++) {
	 * 
	 * boolean canNotBeAdded = false;
	 * 
	 * for (int ii = 0; ii < GameManager.adventurers.allAdventurers.size(); ii++) {
	 * if(tempArray.get(i)[0] ==
	 * GameManager.adventurers.allAdventurers.get(ii).getCombatX() &&
	 * tempArray.get(i)[1] ==
	 * GameManager.adventurers.allAdventurers.get(ii).getCombatY()) { canNotBeAdded
	 * = true; } }
	 * 
	 * if(!canNotBeAdded) { withoutHeroesList.add(tempArray.get(i)); }
	 * 
	 * 
	 * }
	 * 
	 * ArrayList<int[]> withoutEnemiesList = new ArrayList<int[]>(); for (int i = 0;
	 * i < withoutHeroesList.size(); i++) {
	 * 
	 * boolean canNotBeAdded = false;
	 * 
	 * for (int ii = 0; ii < Combat.enemies.size(); ii++) {
	 * if(withoutHeroesList.get(i)[0] == Combat.enemies.get(ii).getCombatX() &&
	 * withoutHeroesList.get(i)[1] == Combat.enemies.get(ii).getCombatY()) {
	 * canNotBeAdded = true; } }
	 * 
	 * if(!canNotBeAdded) { withoutEnemiesList.add(withoutHeroesList.get(i)); }
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * return withoutEnemiesList;
	 */

}
