package com.redhaan.adventurersGalore.entity.adventurer.adventurerFactory;

import java.io.Serializable;
import java.util.Random;

import com.redhaan.adventurersGalore.entity.adventurer.Tattoo;

public class TattooFactory implements Serializable {

	private static final long serialVersionUID = 1L;
	Random random;
	
	public TattooFactory() {
		random = new Random();
	}
	
	public Tattoo rollTattoo(int tier) {
		
		int roll = random.nextInt(100) + 1;
		
		switch(tier) {
		
		case 0: 
			if(roll > 95) { return Tattoo.fox; }
			else if (roll > 90) { return Tattoo.kestrel; }
			else if (roll > 85) { return Tattoo.bull; }
			else if (roll > 80) { return Tattoo.butterfly; }
			else { return null; }
			
		case 1: 
			if(roll > 95) { return Tattoo.fox; }
			else if (roll > 90) { return Tattoo.kestrel; }
			else if (roll > 85) { return Tattoo.bull; }
			else if (roll > 80) { return Tattoo.butterfly; }
			else { return null; }
			
		case 2: 
			if(roll > 90) { return Tattoo.fox; }
			else if (roll > 80) { return Tattoo.kestrel; }
			else if (roll > 70) { return Tattoo.bull; }
			else if (roll > 60) { return Tattoo.bull; }
			else { return null; }
			
		case 3: 
			if(roll > 85) { return Tattoo.fox; }
			else if (roll > 70) { return Tattoo.kestrel; }
			else if (roll > 55) { return Tattoo.bull; }
			else if (roll > 40) { return Tattoo.butterfly; }
			else { return null; }
			
		case 4: 
			if(roll > 80) { return Tattoo.fox; }
			else if (roll > 60) { return Tattoo.kestrel; }
			else if (roll > 40) { return Tattoo.bull; }
			else if (roll > 20) { return Tattoo.butterfly; }
			else { return null; }
			
		default: return null;
		
		}
		
		
	}
	
	
	
}
