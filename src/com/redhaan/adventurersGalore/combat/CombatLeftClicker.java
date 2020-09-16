package com.redhaan.adventurersGalore.combat;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;

public abstract class CombatLeftClicker {

	public static PlayerTurnLeftClickSituation decidePlayerLeftClickSituation(Adventurer adventurer, int x, int y) {
		/*
		adventurer.moveRange = MoveRangeFiller.fillMoveRange(adventurer.getCombatX(), adventurer.getCombatY(),
				adventurer.currentStats.move);
		int[] clickedLocation = new int[] { x / GameManager.GAMETILESIZE, y / GameManager.GAMETILESIZE };

		// Clicked on Party Adventurer
		if (clickedLocation[0] == adventurer.getCombatX() && clickedLocation[1] == adventurer.getCombatY()) {

			if (adventurer.leftClickSituation == PlayerTurnLeftClickSituation.Unit_Active_Moved_EnemyINRANGE) {
				return PlayerTurnLeftClickSituation.Unit_Inactive_TurnPassed;
			}

			if (!adventurer.selected && !adventurer.turnPassed) {
				return PlayerTurnLeftClickSituation.Unit_Active_NOTMoved;
			}

			else if (adventurer.selected && !adventurer.turnPassed) {
				return PlayerTurnLeftClickSituation.Unit_Inactive_TurnPassed;
			} else {
				return PlayerTurnLeftClickSituation.NothingToDo;
			}
		}

		// Clicked in MoveRange
		if (adventurer.selected) {
			for (int i = 0; i < adventurer.moveRange.size(); i++) {
				if (clickedLocation[0] == adventurer.moveRange.get(i)[0]
						&& clickedLocation[1] == adventurer.moveRange.get(i)[1]) {

					if (adventurer.leftClickSituation == PlayerTurnLeftClickSituation.Unit_Active_Moved_EnemyINRANGE) {
						return PlayerTurnLeftClickSituation.Unit_Inactive_TurnPassed;
					}

					if (adventurer.selected && !adventurer.turnPassed) {
						if (checkIfAnyEnemyInWeaponRange(clickedLocation[0], clickedLocation[1])) {
							return PlayerTurnLeftClickSituation.Unit_Active_Moved_EnemyINRANGE;
						} else {
							return PlayerTurnLeftClickSituation.Unit_Active_Moved_EnemyNOTINRANGE;
						}
					} else {
						return PlayerTurnLeftClickSituation.NothingToDo;
					}
				}
			}
		}

		// Clicked on Enemy
		for (int i = 0; i < Combat.enemies.size(); i++) {

			if (clickedLocation[0] == Combat.enemies.get(i).getCombatX()
					&& clickedLocation[1] == Combat.enemies.get(i).getCombatY()) {

				if (checkIfEnemyInWeaponRange(adventurer, clickedLocation)) {
					if (adventurer.leftClickSituation == PlayerTurnLeftClickSituation.Unit_Active_Moved_EnemyINRANGE
							|| adventurer.leftClickSituation == PlayerTurnLeftClickSituation.Unit_Active_NOTMoved) {
						return PlayerTurnLeftClickSituation.Active_Enemy_INRange;
					}
				}

				else {
					if (adventurer.leftClickSituation == PlayerTurnLeftClickSituation.Unit_Active_Moved_EnemyINRANGE) {
						return PlayerTurnLeftClickSituation.Unit_Inactive_TurnPassed;
					} else {
						return PlayerTurnLeftClickSituation.Enemy_NOTINRange;
					}
				}
			}
		}

		// Clicked anywhere else
		if (adventurer.leftClickSituation == PlayerTurnLeftClickSituation.Unit_Active_Moved_EnemyINRANGE) {
			return PlayerTurnLeftClickSituation.Unit_Inactive_TurnPassed;
		}
		return PlayerTurnLeftClickSituation.NothingToDo;

	}

	private static boolean checkIfAnyEnemyInWeaponRange(int x, int y) {

		for (int i = 0; i < Combat.enemies.size(); i++) {
			if (x - 1 == Combat.enemies.get(i).getCombatX() && y == Combat.enemies.get(i).getCombatY()) {
				return true;
			} else if (x + 1 == Combat.enemies.get(i).getCombatX() && y == Combat.enemies.get(i).getCombatY()) {
				return true;
			} else if (x == Combat.enemies.get(i).getCombatX() && y - 1 == Combat.enemies.get(i).getCombatY()) {
				return true;
			} else if (x == Combat.enemies.get(i).getCombatX() && y + 1 == Combat.enemies.get(i).getCombatY()) {
				return true;
			}

		}

		return false;
	}

	private static boolean checkIfEnemyInWeaponRange(Adventurer adventurer, int[] clickLocation) {


		if (adventurer.getCombatX() - 1 == clickLocation[0] && adventurer.getCombatY() == clickLocation[1]) {
			return true;
		} else if (adventurer.getCombatX() + 1 == clickLocation[0] && adventurer.getCombatY() == clickLocation[1]) {
			return true;
		} else if (adventurer.getCombatX() == clickLocation[0] && adventurer.getCombatY() - 1 == clickLocation[1]) {
			return true;
		} else if (adventurer.getCombatX() == clickLocation[0] && adventurer.getCombatY() + 1 == clickLocation[1]) {
			return true;
		}

		return false;
		*/
		return null;
	}
	
}
