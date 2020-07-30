package com.redhaan.adventurersGalore.entity.adventurer.skills;

public class Skill {
	
	
	public String name;
	public int value;
	public int potential;
	
	public boolean activeSkill;
	
	public Skill(String name, int value) {
		
		this.name = name;
		this.value = value;
		
		activeSkill = false;
		
	}
	

}
