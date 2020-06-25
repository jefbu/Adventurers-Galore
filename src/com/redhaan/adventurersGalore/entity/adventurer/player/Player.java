package com.redhaan.adventurersGalore.entity.adventurer.player;

import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;
import com.redhaan.adventurersGalore.entity.adventurer.Affinities;
import com.redhaan.adventurersGalore.entity.adventurer.Job;
import com.redhaan.adventurersGalore.entity.adventurer.personality.Personality;
import com.redhaan.adventurersGalore.entity.adventurer.personality.PersonalityTrait;
import com.redhaan.adventurersGalore.entity.armour.ReinforcedLeather;
import com.redhaan.adventurersGalore.entity.town.Town;
import com.redhaan.adventurersGalore.entity.weapon.swords.IronSword;

public class Player extends Adventurer {

	public Player() {
		
		super();
		job = Job.archer;
		icon = job.icon;
		inParty = true;
		currentStats.move = 8;
		currentStats.PHY = 100;
		maxStats.PHY = 100;
		weapon = new IronSword();
		armour = new ReinforcedLeather();
		calculateSecondaryStats();
		name = "Moltke";
		gender = "male";
		age = 58;
		currentStats.TST = 0;
		homeTown = Town.apastan;
		tier = 1;
		affinities = new Affinities();
		mapX = 10;
		mapY = 10;
		personality = new Personality();
		personality.traits.add(PersonalityTrait.Pedantic);
		personality.traits.add(PersonalityTrait.Pedantic);
		personality.traits.add(PersonalityTrait.Pedantic);
		titbit.strings.add("This is you, we don't pretend to know you that well");

		
	}

	


}
