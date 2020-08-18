package com.redhaan.adventurersGalore.entity.enemies;

import java.util.ArrayList;

import com.redhaan.adventurersGalore.entity.item.Item;

public class DropTable {
	
	public ArrayList<Item> itemDrops;
	public int[] quantities;
	public int[] dropRates;
	
	public DropTable() {
		
		itemDrops = new ArrayList<Item>();
		quantities = new int[8];
		dropRates = new int[8];
		
		dropRates[0] = 10000;
		dropRates[1] = 5000;
		dropRates[2] = 2000;
		dropRates[3] = 2000;
		dropRates[4] = 500;
		dropRates[5] = 100;
		dropRates[6] = 20;
		dropRates[7] = 5;

		
	}

}
