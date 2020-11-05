package com.redhaan.adventurersGalore.entity.party.travelerEvent;

import gameEngine.ecclesiastes.gfx.ImageTile;

public class DialogueText {
	
	public String text;
	public ImageTile speakerIcon;
	public String name;
	public int xTile;
	public int yTile;
	
	
	public DialogueText(String text, ImageTile speakerIcon, String name, int xTile, int yTile) {
		
		this.text = text;
		this.speakerIcon = speakerIcon;
		this.name = name;
		this.xTile = xTile;
		this.yTile = yTile;
		
	}

}
