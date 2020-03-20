package com.redhaan.adventurersGalore.combat.combatAI;

public abstract class ActionDecision {

	public static CombatActions decideActionDecision(HighLevelPlan combatStrategy) {
		
		switch(combatStrategy) {
		
		case Attack: return CombatActions.AttackNearestAdventurer; 
		case Kill: return CombatActions.AttackWeakestAdventurer;
		case Defend: return CombatActions.DoNothing;
		case Guard: return CombatActions.DoNothing;
		
		default: return CombatActions.DoNothing;
		
		
		}
				
	}
	
}
