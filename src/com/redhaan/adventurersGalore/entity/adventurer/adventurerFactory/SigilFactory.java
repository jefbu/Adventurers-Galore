package com.redhaan.adventurersGalore.entity.adventurer.adventurerFactory;

import java.util.ArrayList;
import java.util.Random;

import com.redhaan.adventurersGalore.entity.adventurer.Sigil;

public class SigilFactory {
	
	Random random;
	
	public SigilFactory() { 
		random = new Random();
	}
	
	public int rollSigilSlots(int tier, int tattooSlots) {
		
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
		
		return tattoos;
		
	}
		
	
	public ArrayList<Sigil> rollSigils(int tattooSlots) {
		
		ArrayList<Sigil> tattoos = new ArrayList<Sigil>();
		
		for (int i = 0; i < tattooSlots; i++) {	
			tattoos.add(Sigil.meltdown);
			
		}
		
		return tattoos;
		
	}

		
		
	

}
