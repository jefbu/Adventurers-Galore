package com.redhaan.adventurersGalore.entity.adventurer.skills;

public class Skills {
	
	public int skillSlots;
	
	public Skill sword;
	public Skill axe;
	public Skill dagger;
	public Skill staff;
	public Skill bow;
	
	public Skill trapping;
	public Skill fishing;
	public Skill foraging;
	public Skill cooking;
	public Skill camping;
	
	public Skill lockpick;
	public Skill pickpocket;
	public Skill stealth;
	
	public Skill entertaining;
	public Skill haggling;
	public Skill decorum;
	
	public Skill crafting;
	public Skill alchemy;
	public Skill medicine;
	public Skill weaponSmith;
	
	public Skills() {
		
		skillSlots = 0;
		
		sword = new Skill("Sword", 0);
		axe = new Skill("Axe", 0);
		dagger = new Skill("Dagger", 0);
		staff = new Skill("Staff", 0);
		bow = new Skill("Bow", 0);
		trapping = new Skill("Trapping", 0);
		fishing = new Skill("Fishing", 0);
		foraging = new Skill("Foraging", 0);
		cooking = new Skill("Cooking", 0);
		camping = new Skill("Camping", 0);
		lockpick = new Skill("Lockpick", 0);
		pickpocket = new Skill("Pickpocket", 0);
		stealth = new Skill("Stealth", 0);
		entertaining = new Skill("Entertaining", 0);
		haggling = new Skill("Haggling", 0);
		decorum = new Skill("Decorum", 0);
		crafting = new Skill("Crafting", 0);
		alchemy = new Skill("Alchemy", 0);
		medicine = new Skill("Medicine", 0);
		weaponSmith = new Skill("Weaponsmith", 0);
		
		
	}
	
	
	
	

}
