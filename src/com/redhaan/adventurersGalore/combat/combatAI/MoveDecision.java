package com.redhaan.adventurersGalore.combat.combatAI;

import java.util.ArrayList;
import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;

public abstract class MoveDecision {
	
	static int targetX;
	static int targetY;
	static int distanceToTarget;
	
	
	public static int[] decideMoveDecision(CombatActions action, ArrayList<int[]> moveRange, int x, int y) {
		
		targetX = 0;
		targetY = 0;
		distanceToTarget = 100;
		
		int returnX = x;
		int returnY = y;
		
		
		switch(action) {
		
		case AttackNearestAdventurer:			

			if(moveRange.size() > 0) {
				
				for(Adventurer adventurer: GameManager.adventurers.allAdventurers) {
					if (adventurer.inParty) {
						int distanceToAdventurer = calculateDistanceFromOnePointToAnother(x, y, adventurer.getCombatX(), adventurer.getCombatY());
						if (distanceToAdventurer < distanceToTarget) {
							targetX = adventurer.getCombatX();
							targetY = adventurer.getCombatY();
							distanceToTarget = distanceToAdventurer;
						}
					}
				}
				

				for(int i = 0; i < moveRange.size(); i++) {
					int distanceFromMoveRangePoint = calculateDistanceFromOnePointToAnother(moveRange.get(i)[0], moveRange.get(i)[1], targetX, targetY);
					if (distanceFromMoveRangePoint < distanceToTarget) {
						returnX = moveRange.get(i)[0];
						returnY = moveRange.get(i)[1];
						distanceToTarget = distanceFromMoveRangePoint;
					}
										
				}
				
				return new int[] { returnX, returnY };
			}
			break;
		
		case AttackWeakestAdventurer:
			break;
		case DoNothing:
			break;
		
		}
		
		return new int[] { returnX, returnY };
		
	}
	
	private static int calculateDistanceFromOnePointToAnother(int x, int y, int targetX, int targetY) {
		
		int distance = 0;
		int xDistance = Math.abs(x - targetX);
		int yDistance = Math.abs(y - targetY);
		distance = xDistance + yDistance;
		return distance;
		
	}
	
	
	

}
