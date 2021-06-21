package com.redhaan.adventurersGalore.entity.item.weapon;

import java.io.Serializable;

import com.redhaan.adventurersGalore.GameManager;

import gameEngine.ecclesiastes.gfx.ImageTile;

public class Rune implements Serializable {

	private static final long serialVersionUID = 1L;
	public String name;
	public static ImageTile icon = new ImageTile("/runes.png", GameManager.GAMETILESIZE /2, GameManager.GAMETILESIZE / 2);
	public int xRow, yRow;
	
	public Rune(String name, int xRow, int yRow) {
		
		this.name = name;
		this.xRow = xRow;
		this.yRow = yRow;
		
	}
	
	public static Rune ay = new Rune("Ay", 0, 0);
	public static Rune bir = new Rune("Bir", 1, 0);
	public static Rune cit = new Rune("Cit", 2, 0);
	public static Rune dol = new Rune("Dol", 3, 0);
	public static Rune fu = new Rune("Fu", 4, 0);
	public static Rune ges = new Rune("Ges", 5, 0);
	public static Rune hom = new Rune("Hom", 6, 0);
	public static Rune il = new Rune("Il", 7, 0);
	public static Rune kam = new Rune("Kam", 8, 0);
	public static Rune tiy = new Rune("Tiy", 9, 0);
	public static Rune var = new Rune("Var", 0, 1);
	public static Rune wos = new Rune("Wos", 1, 1);
	public static Rune yut = new Rune("Yut", 2, 1);

}
