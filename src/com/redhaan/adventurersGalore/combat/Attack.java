package com.redhaan.adventurersGalore.combat;

import com.redhaan.adventurersGalore.entity.Monster;

public abstract class Attack {
	
	public static int attacks = 0;
	
	public static void attack(Monster attacker, Monster defender) {
		
		attacks++;
		boolean hit = checkToHit(attacker, defender);
		if(hit) {
			calculateDamage(attacker, defender);
		}
						
	}
	
	
	
	
	private static boolean checkToHit(Monster attacker, Monster defender) {
		
		
		return true;
		
	}
	
	private static void calculateDamage(Monster attacker, Monster defender) {
		
		defender.currentStats.HP = defender.currentStats.HP - attacker.currentStats.attack;

		if(defender.currentStats.HP <= 0) {
			defender.setDead(true);
		}
	}
	

}
