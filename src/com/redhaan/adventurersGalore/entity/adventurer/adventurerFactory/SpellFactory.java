package com.redhaan.adventurersGalore.entity.adventurer.adventurerFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import com.redhaan.adventurersGalore.entity.adventurer.Job;
import com.redhaan.adventurersGalore.entity.adventurer.Sigil;
import com.redhaan.adventurersGalore.entity.adventurer.spells.Spell;
import com.redhaan.adventurersGalore.entity.adventurer.spells.SpellModifier;

public class SpellFactory implements Serializable {
	
	private static final long serialVersionUID = 1L;
	Random random;
	
	public SpellFactory() { 
		random = new Random();
	}
	
	public int rollSpellSlots(int tier, Job job) {
		
		int tattoos = 0;
		int roll = random.nextInt(100) + 1;
		
		switch(tier) {
		
		case 0:
			if (roll > 95) { tattoos = 3; }
			else if (roll > 70) { tattoos = 2; }
			else if (roll > 30) { tattoos = 1; }
			else { tattoos = 0; }
			break;
		case 1:
			if (roll > 80) { tattoos = 3; }
			else if (roll > 60) { tattoos = 2; }
			else if (roll > 30) { tattoos = 1; }
			else { tattoos = 0; }
			break;
		case 2:
			if (roll > 75) { tattoos = 3; }
			else if (roll > 50) { tattoos = 2; }
			else if (roll > 25) { tattoos = 1; }
			else { tattoos = 0; }
			break;
		case 3:
			if (roll > 70) { tattoos = 3; }
			else if (roll > 45) { tattoos = 2; }
			else if (roll > 20) { tattoos = 1; }
			else { tattoos = 0; }
			break;
		case 4:
			if (roll > 65) { tattoos = 3; }
			else if (roll > 35) { tattoos = 2; }
			else if (roll > 10) { tattoos = 1; }
			else { tattoos = 0; }
			break;
		
		}
		
		switch(job.jobEnum) {
		
		case Mage: tattoos++; break;
		case Magus: tattoos++; break;
		case ArchMage: tattoos++; break;
		
		case Squire: if (random.nextBoolean()) { tattoos++; } break; 
		case Knight: if (random.nextBoolean()) { tattoos++; } break;
		case Paladin: if (random.nextBoolean()) { tattoos++; } break;
		
		default: break;
		
		}
		
		if(tattoos > 3) { tattoos = 3; }
		System.out.println(job.name + " was created with " + tattoos + " spell slots");
		return tattoos;
		
	}
		
	
	public ArrayList<Sigil> rollSigils(int spellSlots) {
		
		ArrayList<Sigil> spells = new ArrayList<Sigil>();
		
		for (int i = 0; i < spellSlots; i++) {	
			
			int roll1 = random.nextInt(25);
			int roll2 = random.nextInt(90) + 1;
		
			switch(roll1) {
			
			case 0:
				if (roll2 > 80) { spells.add(new Sigil(Spell.oasis, SpellModifier.alabaster)); }
				else if (roll2 > 70) { spells.add(new Sigil(Spell.oasis, SpellModifier.bone)); }
				else if (roll2 > 60) { spells.add(new Sigil(Spell.oasis, SpellModifier.ivory)); }
				else if (roll2 > 40) { spells.add(new Sigil(Spell.oasis, SpellModifier.viridian)); }
				else if (roll2 > 20) { spells.add(new Sigil(Spell.oasis, SpellModifier.chartreuse)); }
				else { spells.add(new Sigil(Spell.oasis, SpellModifier.olive)); }
			break;
			
			case 1:
				if (roll2 > 80) { spells.add(new Sigil(Spell.city, SpellModifier.amber)); }
				else if (roll2 > 70) { spells.add(new Sigil(Spell.city, SpellModifier.ochre)); }
				else if (roll2 > 60) { spells.add(new Sigil(Spell.city, SpellModifier.honey)); }
				else if (roll2 > 40) { spells.add(new Sigil(Spell.city, SpellModifier.alabaster)); }
				else if (roll2 > 20) { spells.add(new Sigil(Spell.city, SpellModifier.bone)); }
				else { spells.add(new Sigil(Spell.city, SpellModifier.ivory)); }
			break;
			
			case 2:
				if (roll2 > 80) { spells.add(new Sigil(Spell.grove, SpellModifier.viridian)); }
				else if (roll2 > 70) { spells.add(new Sigil(Spell.grove, SpellModifier.chartreuse)); }
				else if (roll2 > 60) { spells.add(new Sigil(Spell.grove, SpellModifier.olive)); }
				else if (roll2 > 40) { spells.add(new Sigil(Spell.grove, SpellModifier.aquamarine)); }
				else if (roll2 > 20) { spells.add(new Sigil(Spell.grove, SpellModifier.malachite)); }
				else { spells.add(new Sigil(Spell.grove, SpellModifier.cobalt)); }
			break;
			
			case 3:
				if (roll2 > 80) { spells.add(new Sigil(Spell.fields, SpellModifier.amber)); }
				else if (roll2 > 70) { spells.add(new Sigil(Spell.fields, SpellModifier.ochre)); }
				else if (roll2 > 60) { spells.add(new Sigil(Spell.fields, SpellModifier.honey)); }
				else if (roll2 > 40) { spells.add(new Sigil(Spell.fields, SpellModifier.alabaster)); }
				else if (roll2 > 20) { spells.add(new Sigil(Spell.fields, SpellModifier.bone)); }
				else { spells.add(new Sigil(Spell.fields, SpellModifier.ivory)); }
			break;
			
			case 4:
				if (roll2 > 80) { spells.add(new Sigil(Spell.vineyard, SpellModifier.alabaster)); }
				else if (roll2 > 70) { spells.add(new Sigil(Spell.vineyard, SpellModifier.bone)); }
				else if (roll2 > 60) { spells.add(new Sigil(Spell.vineyard, SpellModifier.ivory)); }
				else if (roll2 > 40) { spells.add(new Sigil(Spell.vineyard, SpellModifier.viridian)); }
				else if (roll2 > 20) { spells.add(new Sigil(Spell.vineyard, SpellModifier.chartreuse)); }
				else { spells.add(new Sigil(Spell.vineyard, SpellModifier.olive)); }
			break;
			
			case 5:
				if (roll2 > 80) { spells.add(new Sigil(Spell.skies, SpellModifier.aquamarine)); }
				else if (roll2 > 70) { spells.add(new Sigil(Spell.skies, SpellModifier.malachite)); }
				else if (roll2 > 60) { spells.add(new Sigil(Spell.skies, SpellModifier.cobalt)); }
				else if (roll2 > 40) { spells.add(new Sigil(Spell.skies, SpellModifier.azure)); }
				else if (roll2 > 20) { spells.add(new Sigil(Spell.skies, SpellModifier.cerulean)); }
				else { spells.add(new Sigil(Spell.skies, SpellModifier.indigo)); }
			break;
			
			case 6:
				if (roll2 > 80) { spells.add(new Sigil(Spell.castle, SpellModifier.azure)); }
				else if (roll2 > 70) { spells.add(new Sigil(Spell.castle, SpellModifier.cerulean)); }
				else if (roll2 > 60) { spells.add(new Sigil(Spell.castle, SpellModifier.indigo)); }
				else if (roll2 > 40) { spells.add(new Sigil(Spell.castle, SpellModifier.amber)); }
				else if (roll2 > 20) { spells.add(new Sigil(Spell.castle, SpellModifier.ochre)); }
				else { spells.add(new Sigil(Spell.castle, SpellModifier.honey)); }
			break;
			
			case 7:
				if (roll2 > 80) { spells.add(new Sigil(Spell.heath, SpellModifier.tawny)); }
				else if (roll2 > 70) { spells.add(new Sigil(Spell.heath, SpellModifier.umber)); }
				else if (roll2 > 60) { spells.add(new Sigil(Spell.heath, SpellModifier.russet)); }
				else if (roll2 > 40) { spells.add(new Sigil(Spell.heath, SpellModifier.scarlet)); }
				else if (roll2 > 20) { spells.add(new Sigil(Spell.heath, SpellModifier.crimson)); }
				else { spells.add(new Sigil(Spell.heath, SpellModifier.carmine)); }
			break;
			
			case 8:
				if (roll2 > 80) { spells.add(new Sigil(Spell.river, SpellModifier.ebony)); }
				else if (roll2 > 70) { spells.add(new Sigil(Spell.river, SpellModifier.charcoal)); }
				else if (roll2 > 60) { spells.add(new Sigil(Spell.river, SpellModifier.sable)); }
				else if (roll2 > 40) { spells.add(new Sigil(Spell.river, SpellModifier.aquamarine)); }
				else if (roll2 > 20) { spells.add(new Sigil(Spell.river, SpellModifier.malachite)); }
				else { spells.add(new Sigil(Spell.river, SpellModifier.cobalt)); }
			break;
			
			case 9:
				if (roll2 > 80) { spells.add(new Sigil(Spell.meadow, SpellModifier.aquamarine)); }
				else if (roll2 > 70) { spells.add(new Sigil(Spell.meadow, SpellModifier.malachite)); }
				else if (roll2 > 60) { spells.add(new Sigil(Spell.meadow, SpellModifier.cobalt)); }
				else if (roll2 > 40) { spells.add(new Sigil(Spell.meadow, SpellModifier.amber)); }
				else if (roll2 > 20) { spells.add(new Sigil(Spell.meadow, SpellModifier.ochre)); }
				else { spells.add(new Sigil(Spell.meadow, SpellModifier.honey)); }
			break;
			
			case 10:
				if (roll2 > 80) { spells.add(new Sigil(Spell.volcano, SpellModifier.tawny)); }
				else if (roll2 > 70) { spells.add(new Sigil(Spell.volcano, SpellModifier.umber)); }
				else if (roll2 > 60) { spells.add(new Sigil(Spell.volcano, SpellModifier.russet)); }
				else if (roll2 > 40) { spells.add(new Sigil(Spell.volcano, SpellModifier.scarlet)); }
				else if (roll2 > 20) { spells.add(new Sigil(Spell.volcano, SpellModifier.crimson)); }
				else { spells.add(new Sigil(Spell.volcano, SpellModifier.carmine)); }
			break;
			
			case 11:
				if (roll2 > 80) { spells.add(new Sigil(Spell.mountain, SpellModifier.crimson)); }
				else if (roll2 > 70) { spells.add(new Sigil(Spell.mountain, SpellModifier.scarlet)); }
				else if (roll2 > 60) { spells.add(new Sigil(Spell.mountain, SpellModifier.carmine)); }
				else if (roll2 > 40) { spells.add(new Sigil(Spell.mountain, SpellModifier.umber)); }
				else if (roll2 > 20) { spells.add(new Sigil(Spell.mountain, SpellModifier.tawny)); }
				else { spells.add(new Sigil(Spell.mountain, SpellModifier.russet)); }
			break;
			
			case 12:
				if (roll2 > 80) { spells.add(new Sigil(Spell.ravine, SpellModifier.violet)); }
				else if (roll2 > 70) { spells.add(new Sigil(Spell.ravine, SpellModifier.lilac)); }
				else if (roll2 > 60) { spells.add(new Sigil(Spell.ravine, SpellModifier.periwinkle)); }
				else if (roll2 > 40) { spells.add(new Sigil(Spell.ravine, SpellModifier.ebony)); }
				else if (roll2 > 20) { spells.add(new Sigil(Spell.ravine, SpellModifier.charcoal)); }
				else { spells.add(new Sigil(Spell.ravine, SpellModifier.sable)); }
			break;
			
			case 13:
				if (roll2 > 80) { spells.add(new Sigil(Spell.ocean, SpellModifier.crimson)); }
				else if (roll2 > 70) { spells.add(new Sigil(Spell.ocean, SpellModifier.scarlet)); }
				else if (roll2 > 60) { spells.add(new Sigil(Spell.ocean, SpellModifier.carmine)); }
				else if (roll2 > 40) { spells.add(new Sigil(Spell.ocean, SpellModifier.azure)); }
				else if (roll2 > 20) { spells.add(new Sigil(Spell.ocean, SpellModifier.cerulean)); }
				else { spells.add(new Sigil(Spell.ocean, SpellModifier.indigo)); }
			break;
			
			case 14:
				if (roll2 > 80) { spells.add(new Sigil(Spell.morass, SpellModifier.ebony)); }
				else if (roll2 > 70) { spells.add(new Sigil(Spell.morass, SpellModifier.charcoal)); }
				else if (roll2 > 60) { spells.add(new Sigil(Spell.morass, SpellModifier.sable)); }
				else if (roll2 > 40) { spells.add(new Sigil(Spell.morass, SpellModifier.umber)); }
				else if (roll2 > 20) { spells.add(new Sigil(Spell.morass, SpellModifier.tawny)); }
				else { spells.add(new Sigil(Spell.morass, SpellModifier.russet)); }
			break;
			
			case 15:
				if (roll2 > 80) { spells.add(new Sigil(Spell.taiga, SpellModifier.azure)); }
				else if (roll2 > 70) { spells.add(new Sigil(Spell.taiga, SpellModifier.cerulean)); }
				else if (roll2 > 60) { spells.add(new Sigil(Spell.taiga, SpellModifier.indigo)); }
				else if (roll2 > 40) { spells.add(new Sigil(Spell.taiga, SpellModifier.lilac)); }
				else if (roll2 > 20) { spells.add(new Sigil(Spell.taiga, SpellModifier.violet)); }
				else { spells.add(new Sigil(Spell.taiga, SpellModifier.periwinkle)); }
			break;
			
			case 16:
				if (roll2 > 80) { spells.add(new Sigil(Spell.graveyard, SpellModifier.lilac)); }
				else if (roll2 > 70) { spells.add(new Sigil(Spell.graveyard, SpellModifier.violet)); }
				else if (roll2 > 60) { spells.add(new Sigil(Spell.graveyard, SpellModifier.periwinkle)); }
				else if (roll2 > 40) { spells.add(new Sigil(Spell.graveyard, SpellModifier.ebony)); }
				else if (roll2 > 20) { spells.add(new Sigil(Spell.graveyard, SpellModifier.charcoal)); }
				else { spells.add(new Sigil(Spell.graveyard, SpellModifier.sable)); }
			break;
			
			case 17:
				if (roll2 > 80) { spells.add(new Sigil(Spell.library, SpellModifier.viridian)); }
				else if (roll2 > 70) { spells.add(new Sigil(Spell.library, SpellModifier.chartreuse)); }
				else if (roll2 > 60) { spells.add(new Sigil(Spell.library, SpellModifier.olive)); }
				else if (roll2 > 40) { spells.add(new Sigil(Spell.library, SpellModifier.lilac)); }
				else if (roll2 > 20) { spells.add(new Sigil(Spell.library, SpellModifier.violet)); }
				else { spells.add(new Sigil(Spell.library, SpellModifier.periwinkle)); }
			break;			
			
			default: break;
			
			}
						
		}
		
		if(spells.size() > 0) {
			spells.get(0).level++;
		}

		
		return spells;
		
	}

		
		
	

}
