package com.redhaan.adventurersGalore.entity.adventurer.spells;

public class Spell {
	
	public int animationRow;
	public int minRange, maxRange;
	public SpellType spellType;
	public String name;
	
	public Spell(String name, SpellType spellType, int minRange, int maxRange, int animationRow) {
		
		this.name = name;
		this.spellType = spellType;
		this.minRange = minRange;
		this.maxRange = maxRange;
		this.animationRow = animationRow;
		
	}
	
	
	
	
	public static Spell oasis = new Spell("Oasis of a Tranquil Heart", SpellType.SingleAlly, 1, 5, 1);
	public static Spell city = new Spell("City full of Life", SpellType.WorldMap, 1, 5, 2);
	public static Spell fields = new Spell("Fields of Summer Rye", SpellType.WorldMap, 1, 5, 3);
	public static Spell grove = new Spell("Grove of Age-old Broadleaves", SpellType.WorldMap, 1, 5, 4);
	public static Spell vineyard = new Spell("Bountiful Vineyard", SpellType.WorldMap, 1, 5, 5);
	public static Spell castle = new Spell("Impregnable Castle", SpellType.WorldMap, 1, 5, 6);
	public static Spell skies = new Spell("Skies of Longing Vagabonds", SpellType.WorldMap, 1, 5, 7);
	public static Spell heath = new Spell("Heath of Scorched Memories", SpellType.WorldMap, 1, 5, 8);
	public static Spell river = new Spell("River of Killing Currents", SpellType.WorldMap, 1, 5, 9);
	public static Spell meadow = new Spell("Meadow of Rest for the Wicked", SpellType.WorldMap, 1, 5, 10);
	public static Spell volcano = new Spell("Volcano of Swallowing Ash", SpellType.WorldMap, 1, 5, 11);
	public static Spell mountain = new Spell("Mountain of an Early Grave", SpellType.WorldMap, 1, 5, 12);
	public static Spell ravine = new Spell("Ravine to the Gates of Hell", SpellType.WorldMap, 1, 5, 13);
	public static Spell ocean = new Spell("Ocean of Overwhelming Despair", SpellType.WorldMap, 1, 5, 14);
	public static Spell morass = new Spell("Corrosive Morass", SpellType.WorldMap, 1, 5, 15);
	public static Spell taiga = new Spell("Taiga where Life cannot Grow", SpellType.WorldMap, 1, 5, 16);
	public static Spell graveyard = new Spell("Impatient Graveyard", SpellType.WorldMap, 1, 5, 17);
	public static Spell library = new Spell("Library of Maddening Wisdom", SpellType.WorldMap, 1, 5, 18);

	
	public static Spell dummy = new Spell("dummy", SpellType.AllAllies, 0, 0, 0);
	

}
