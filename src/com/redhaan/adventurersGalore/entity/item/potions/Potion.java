package com.redhaan.adventurersGalore.entity.item.potions;

import com.redhaan.adventurersGalore.entity.adventurer.Sigil;

public class Potion {
	
	public int xRow, yRow;
	public String name;
	
	public Potion(String name, int xRow, int yRow) {
		
		this.name = name;
		this.xRow = xRow;
		this.yRow = yRow;
		
	}
	
		
	public static Potion whitePotion = new Potion("White Potion", 10, 0);
	public static Potion goldPotion = new Potion("Gold Potion", 10, 1);
	public static Potion tealPotion = new Potion("Teal Potion", 10, 2);
	public static Potion redPotion = new Potion("Red Potion", 10, 3);
	public static Potion greenPotion = new Potion("Green Potion", 10, 4);
	public static Potion bluePotion = new Potion("Blue Potion", 10, 5);
	public static Potion brownPotion = new Potion("Brown Potion", 10, 6);
	public static Potion purplePotion = new Potion("Purple Potion", 10, 7);
	public static Potion blackPotion = new Potion("Black Potion", 10, 8);

	
}
