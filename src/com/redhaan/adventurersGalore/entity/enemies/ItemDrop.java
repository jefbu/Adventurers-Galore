package com.redhaan.adventurersGalore.entity.enemies;

import com.redhaan.adventurersGalore.entity.item.Item;

public class ItemDrop {
	
	public int dropRate;
	public Item item;
	
	public ItemDrop(Item item, int dropRate) {
		
		this.item = item;
		this.dropRate = dropRate;
		
	}

}
