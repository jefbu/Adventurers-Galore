package com.redhaan.adventurersGalore.entity.adventurer.personality;

import java.io.Serializable;
import java.util.ArrayList;

public class Personality implements Serializable {

	private static final long serialVersionUID = 1L;
	public ArrayList<PersonalityTrait> traits;
	
	public Personality() {
		traits = new ArrayList<PersonalityTrait>();
	}
		
}
