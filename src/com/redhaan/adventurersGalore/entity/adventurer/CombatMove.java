package com.redhaan.adventurersGalore.entity.adventurer;

public class CombatMove {
	
	public String name;
	public int row;
	
	
	public CombatMove(String name, int row) {
		
		this.name = name;
		this.row = row;
		
	}
	
	
	public static CombatMove fight = new CombatMove("Fight", 0);
	public static CombatMove magic = new CombatMove("Magic", 1);
	public static CombatMove shieldsUp = new CombatMove("Shields Up!", 2);
	public static CombatMove meditate = new CombatMove("Meditate", 3);
	public static CombatMove backstab = new CombatMove("Back Stab", 4);
	public static CombatMove aim = new CombatMove("Aim!", 5);
	public static CombatMove mowDown = new CombatMove("Mow Down", 6);
	
	
	

}
