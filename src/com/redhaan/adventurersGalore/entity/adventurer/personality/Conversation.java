package com.redhaan.adventurersGalore.entity.adventurer.personality;

import java.util.ArrayList;

import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;

public class Conversation {
	
	public ArrayList<Adventurer> talkers;
	public ArrayList<Line> lines;
	public int lineNumber;
	
	public Conversation() {
		
		talkers = new ArrayList<Adventurer>();
		lines = new ArrayList<Line>();
		lineNumber = 0;
		
	}

}
