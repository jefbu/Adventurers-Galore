package com.redhaan.adventurersGalore.entity.adventurer.skills;

import java.io.Serializable;

public class Skill implements Serializable {
	
	private static final long serialVersionUID = 1L;
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
