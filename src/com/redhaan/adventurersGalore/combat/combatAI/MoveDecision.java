package com.redhaan.adventurersGalore.combat.combatAI;

import java.util.ArrayList;
import java.util.Random;

public abstract class MoveDecision {
	
	
	public static int[] decideMoveDecision(CombatActions action, ArrayList<int[]> moveRange) {
		
		switch(action) {
		
		case AttackNearestAdventurer:
			
			Random random = new Random();
			return moveRange.get(random.nextInt(moveRange.size()));
		
		
		case AttackWeakestAdventurer:
			break;
		case DoNothing:
			break;
		
		}
		
		return new int[] { 2, 2 };
		
	}

}
