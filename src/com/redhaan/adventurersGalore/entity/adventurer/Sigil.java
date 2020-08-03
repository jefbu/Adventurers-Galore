package com.redhaan.adventurersGalore.entity.adventurer;

import java.io.Serializable;

public class Sigil implements Serializable {

	private static final long serialVersionUID = 1L;
	public String name;
	
	public Sigil(String name) {
		
		this.name = name;
		
	}
	
	
	
	
	
	public static Sigil meltdown = new Sigil("Meltdown");

}
