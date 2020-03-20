package com.redhaan.adventurersGalore.combat;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;

public abstract class CombatLeftClicker {

	public static PlayerTurnLeftClickSituations decidePlayerLeftClickSituation(Adventurer adventurer, int x, int y) {

		adventurer.moveRange = MoveRangeFiller.fillMoveRange(adventurer.getCombatX(), adventurer.getCombatY(),
				adventurer.currentStats.move);
		int[] clickedLocation = new int[] { x / GameManager.GAMETILESIZE, y / GameManager.GAMETILESIZE };

		// Clicked on Party Adventurer
		if (clickedLocation[0] == adventurer.getCombatX() && clickedLocation[1] == adventurer.getCombatY()) {

			if (adventurer.leftClickSituation == PlayerTurnLeftClickSituations.Unit_Active_Moved_EnemyINRANGE) {
				return PlayerTurnLeftClickSituations.Unit_Inactive_TurnPassed;
			}

			if (!adventurer.moving && !adventurer.turnPassed) {
				return PlayerTurnLeftClickSituations.Unit_Active_NOTMoved;
			}

			else if (adventurer.moving && !adventurer.turnPassed) {
				return PlayerTurnLeftClickSituations.Unit_Inactive_TurnPassed;
			} else {
				return PlayerTurnLeftClickSituations.NothingToDo;
			}
		}

		// Clicked in MoveRange
		if (adventurer.moving) {
			for (int i = 0; i < adventurer.moveRange.size(); i++) {
				if (clickedLocation[0] == adventurer.moveRange.get(i)[0]
						&& clickedLocation[1] == adventurer.moveRange.get(i)[1]) {

					if (adventurer.leftClickSituation == PlayerTurnLeftClickSituations.Unit_Active_Moved_EnemyINRANGE) {
						return PlayerTurnLeftClickSituations.Unit_Inactive_TurnPassed;
					}

					if (adventurer.moving && !adventurer.turnPassed) {
						if (checkIfAnyEnemyInWeaponRange(clickedLocation[0], clickedLocation[1])) {
							return PlayerTurnLeftClickSituations.Unit_Active_Moved_EnemyINRANGE;
						} else {
							return PlayerTurnLeftClickSituations.Unit_Active_Moved_EnemyNOTINRANGE;
						}
					} else {
						return PlayerTurnLeftClickSituations.NothingToDo;
					}
				}
			}
		}

		// Clicked on Enemy
		for (int i = 0; i < Combat.enemies.size(); i++) {

			if (clickedLocation[0] == Combat.enemies.get(i).getCombatX()
					&& clickedLocation[1] == Combat.enemies.get(i).getCombatY()) {

				if (checkIfEnemyInWeaponRange(adventurer, clickedLocation)) {
					if (adventurer.leftClickSituation == PlayerTurnLeftClickSituations.Unit_Active_Moved_EnemyINRANGE
							|| adventurer.leftClickSituation == PlayerTurnLeftClickSituations.Unit_Active_NOTMoved) {
						return PlayerTurnLeftClickSituations.Active_Enemy_INRange;
					}
				}

				else {
					if (adventurer.leftClickSituation == PlayerTurnLeftClickSituations.Unit_Active_Moved_EnemyINRANGE) {
						return PlayerTurnLeftClickSituations.Unit_Inactive_TurnPassed;
					} else {
						return PlayerTurnLeftClickSituations.Enemy_NOTINRange;
					}
				}
			}
		}

		// Clicked anywhere else
		if (adventurer.leftClickSituation == PlayerTurnLeftClickSituations.Unit_Active_Moved_EnemyINRANGE) {
			return PlayerTurnLeftClickSituations.Unit_Inactive_TurnPassed;
		}
		return PlayerTurnLeftClickSituations.NothingToDo;

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
	}

}
