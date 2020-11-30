package com.redhaan.adventurersGalore.combat;

import com.redhaan.adventurersGalore.entity.Monster;

public abstract class Attack {
	
	//public static int attacks = 0;
	public static boolean aimedAttack = false;
	public static boolean backstab = false;
	
	public static void attack(Monster attacker, Monster defender) {
		
		//attacks++;
		boolean hit = checkToHit(attacker, defender);
		if(hit) {
			calculateDamage(attacker, defender);
		}
						
	}
	
	
	
	
	private static boolean checkToHit(Monster attacker, Monster defender) {
		
		if(aimedAttack) { System.out.println("Aimed Attack"); aimedAttack = false; return true; }
		
		else { return true; }
		
	}
	
	private static void calculateDamage(Monster attacker, Monster defender) {

		if(backstab) { System.out.println("Backstab"); backstab = false; defender.currentStats.HP = defender.currentStats.HP - attacker.currentStats.attack - 5; }
		else { defender.currentStats.HP = defender.currentStats.HP - attacker.currentStats.attack; }
		
		if(defender.currentStats.HP <= 0) {
			defender.setDead(true);
		}
	}
	

}
