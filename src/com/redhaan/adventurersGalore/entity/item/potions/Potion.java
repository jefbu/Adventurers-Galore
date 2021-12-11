package com.redhaan.adventurersGalore.entity.item.potions;

import com.redhaan.adventurersGalore.entity.item.Item;
import com.redhaan.adventurersGalore.entity.item.ItemID;

public class Potion extends Item {
		
	public Potion(String name, int xTile, int yTile, ItemID ID) {
		
		this.name = name;
		this.xTile = xTile;
		this.yTile = yTile;
		
		this.ID = ItemID.blackPotion;
		
	}
	
		
	public static Potion whitePotion = new Potion("White Potion", 10, 0, ItemID.whitePotion);
	public static Potion goldPotion = new Potion("Gold Potion", 10, 1, ItemID.goldPotion);
	public static Potion tealPotion = new Potion("Teal Potion", 10, 2, ItemID.tealPotion);
	public static Potion redPotion = new Potion("Red Potion", 10, 3, ItemID.redPotion);
	public static Potion greenPotion = new Potion("Green Potion", 10, 4, ItemID.greenPotion);
	public static Potion bluePotion = new Potion("Blue Potion", 10, 5, ItemID.bluePotion);
	public static Potion brownPotion = new Potion("Brown Potion", 10, 6, ItemID.brownPotion);
	public static Potion purplePotion = new Potion("Purple Potion", 10, 7, ItemID.purplePotion);
	public static Potion blackPotion = new Potion("Black Potion", 10, 8, ItemID.blackPotion);

	
}
