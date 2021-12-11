package com.redhaan.adventurersGalore.entity.item.weapon;

import java.io.Serializable;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.entity.item.Item;
import com.redhaan.adventurersGalore.entity.item.ItemID;

import gameEngine.ecclesiastes.gfx.ImageTile;

public class Rune extends Item implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Rune(String name, int xTile, int yTile, ItemID id) {
		
		this.name = name;
		this.xTile = xTile;
		this.yTile = yTile;
		this.ID = id;
		
	}
	
	public static Rune ay = new Rune("Ay", 4, 0, ItemID.ay);
	public static Rune bir = new Rune("Bir", 4, 1, ItemID.bir);
	public static Rune cit = new Rune("Cit", 4, 2, ItemID.cit);
	public static Rune dol = new Rune("Dol", 4, 3, ItemID.dol);
	public static Rune fu = new Rune("Fu", 4, 4, ItemID.fu);
	public static Rune ges = new Rune("Ges", 4, 5, ItemID.ges);
	public static Rune hom = new Rune("Hom", 4, 6, ItemID.hom);
	public static Rune il = new Rune("Il", 4, 7, ItemID.il);
	public static Rune kam = new Rune("Kam", 4, 8, ItemID.kam);
	public static Rune tiy = new Rune("Tiy", 4, 9, ItemID.tiy);
	public static Rune var = new Rune("Var", 5, 0, ItemID.var);
	public static Rune wos = new Rune("Wos", 5, 1, ItemID.wos);
	public static Rune yut = new Rune("Yut", 5, 2, ItemID.yut);

}
