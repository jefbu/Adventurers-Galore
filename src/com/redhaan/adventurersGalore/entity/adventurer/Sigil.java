package com.redhaan.adventurersGalore.entity.adventurer;

import java.io.Serializable;
import java.util.Random;

import com.redhaan.adventurersGalore.entity.adventurer.spells.Spell;
import com.redhaan.adventurersGalore.entity.adventurer.spells.SpellModifier;
import com.redhaan.adventurersGalore.entity.item.potions.Potion;

public class Sigil implements Serializable {

	private static final long serialVersionUID = 1L;
	public Spell spell;
	public SpellModifier spellModifier;
	public int level;
	private static Random random = new Random();;
	
	public Sigil(Spell spell, SpellModifier spellModifier) {
		
		this.spell = spell;
		this.spellModifier = spellModifier;
		level = 1;
		
		
	}
	
	
	public static Sigil rollSigil(Potion potion, Sigil sigil) {
		
		int roll1 = random.nextInt(100 + 1);
		int roll2 = random.nextInt(100 + 1);
		Spell tempSpell;
		SpellModifier tempSpellModifier;
		
		switch(potion.name) {
		
		case "White Potion": 
			
			if (roll1 > 65) { tempSpell = Spell.city; }
			else if (roll1 > 30) { tempSpell = Spell.fields; }
			else if (roll1 > 15) { tempSpell = Spell.oasis; }
			else { tempSpell = Spell.vineyard; }
			
			if(roll2 > 66) { tempSpellModifier = SpellModifier.alabaster; }
			else if (roll2 > 33) { tempSpellModifier = SpellModifier.bone; }
			else { tempSpellModifier = SpellModifier.ivory; }
			
			break;
		
		case "Gold Potion": 
			
			if (roll1 > 65) { tempSpell = Spell.castle; }
			else if (roll1 > 30) { tempSpell = Spell.meadow; }
			else if (roll1 > 15) { tempSpell = Spell.city; }
			else { tempSpell = Spell.fields; }
			
			if(roll2 > 66) { tempSpellModifier = SpellModifier.amber; }
			else if (roll2 > 33) { tempSpellModifier = SpellModifier.ochre; }
			else { tempSpellModifier = SpellModifier.honey; }
			
			break;
			
		case "Teal Potion": 
			
			if (roll1 > 65) { tempSpell = Spell.grove; }
			else if (roll1 > 30) { tempSpell = Spell.river; }
			else if (roll1 > 15) { tempSpell = Spell.skies; }
			else { tempSpell = Spell.meadow; }
			
			if(roll2 > 66) { tempSpellModifier = SpellModifier.aquamarine; }
			else if (roll2 > 33) { tempSpellModifier = SpellModifier.malachite; }
			else { tempSpellModifier = SpellModifier.cobalt; }
			
			break;
			
		case "Red Potion": 
			
			if (roll1 > 65) { tempSpell = Spell.heath; }
			else if (roll1 > 30) { tempSpell = Spell.volcano; }
			else if (roll1 > 15) { tempSpell = Spell.mountain; }
			else { tempSpell = Spell.ocean; }
			
			if(roll2 > 66) { tempSpellModifier = SpellModifier.crimson; }
			else if (roll2 > 33) { tempSpellModifier = SpellModifier.scarlet; }
			else { tempSpellModifier = SpellModifier.carmine; }
			
			break;
			
		case "Green Potion": 
			
			if (roll1 > 65) { tempSpell = Spell.oasis; }
			else if (roll1 > 30) { tempSpell = Spell.vineyard; }
			else if (roll1 > 15) { tempSpell = Spell.grove; }
			else { tempSpell = Spell.library; }
			
			if(roll2 > 66) { tempSpellModifier = SpellModifier.viridian; }
			else if (roll2 > 33) { tempSpellModifier = SpellModifier.chartreuse; }
			else { tempSpellModifier = SpellModifier.olive; }
			
			break;
			
		case "Blue Potion": 
			
			if (roll1 > 65) { tempSpell = Spell.skies; }
			else if (roll1 > 30) { tempSpell = Spell.ocean; }
			else if (roll1 > 15) { tempSpell = Spell.castle; }
			else { tempSpell = Spell.taiga; }
			
			if(roll2 > 66) { tempSpellModifier = SpellModifier.alabaster; }
			else if (roll2 > 33) { tempSpellModifier = SpellModifier.bone; }
			else { tempSpellModifier = SpellModifier.ivory; }
			
			break;
			
		case "Brown Potion": 
			
			if (roll1 > 65) { tempSpell = Spell.mountain; }
			else if (roll1 > 30) { tempSpell = Spell.morass; }
			else if (roll1 > 15) { tempSpell = Spell.heath; }
			else { tempSpell = Spell.volcano; }
			
			if(roll2 > 66) { tempSpellModifier = SpellModifier.umber; }
			else if (roll2 > 33) { tempSpellModifier = SpellModifier.tawny; }
			else { tempSpellModifier = SpellModifier.russet; }
			
			break;
			
		case "Purple Potion": 
			
			if (roll1 > 65) { tempSpell = Spell.library; }
			else if (roll1 > 30) { tempSpell = Spell.taiga; }
			else if (roll1 > 15) { tempSpell = Spell.ravine; }
			else { tempSpell = Spell.graveyard; }
			
			if(roll2 > 66) { tempSpellModifier = SpellModifier.periwinkle; }
			else if (roll2 > 33) { tempSpellModifier = SpellModifier.lilac; }
			else { tempSpellModifier = SpellModifier.violet; }
			
			break;
			
		case "Black Potion": 
			
			if (roll1 > 65) { tempSpell = Spell.graveyard; }
			else if (roll1 > 30) { tempSpell = Spell.ravine; }
			else if (roll1 > 15) { tempSpell = Spell.river; }
			else { tempSpell = Spell.morass; }
			
			if(roll2 > 66) { tempSpellModifier = SpellModifier.ebony; }
			else if (roll2 > 33) { tempSpellModifier = SpellModifier.charcoal; }
			else { tempSpellModifier = SpellModifier.sable; }
			
			break;
			
		default: tempSpell = Spell.ocean; tempSpellModifier = SpellModifier.alabaster; break;
		
		}
		
		if (tempSpell == sigil.spell) { 
			if (sigil.level < 3) {
				sigil.level++;
			}
			return sigil;
		}
		
		else { return new Sigil(tempSpell, tempSpellModifier); }
		
	}
	
	
	
	
	

}
