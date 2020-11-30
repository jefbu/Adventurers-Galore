package com.redhaan.adventurersGalore.entity.adventurer.player;

import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;
import com.redhaan.adventurersGalore.entity.adventurer.Affinities;
import com.redhaan.adventurersGalore.entity.adventurer.CombatMove;
import com.redhaan.adventurersGalore.entity.adventurer.Job;
import com.redhaan.adventurersGalore.entity.adventurer.personality.Personality;
import com.redhaan.adventurersGalore.entity.adventurer.personality.PersonalityTrait;
import com.redhaan.adventurersGalore.entity.item.armour.ReinforcedLeather;
import com.redhaan.adventurersGalore.entity.item.weapon.bows.ShortBow;
import com.redhaan.adventurersGalore.entity.town.Town;

public class Player extends Adventurer {

	private static final long serialVersionUID = 1L;

	public Player() {
		
		super();
		job = Job.archer;
		icon = job.icon;
		inParty = true;
		currentStats.move = 8;
		maxStats.move = 13;
		currentStats.PHY = 15;
		maxStats.PHY = 15;
		weapon = new ShortBow();
		armour = new ReinforcedLeather();
		calculateSecondaryStats();
		name = "Moltke";
		gender = "Female";
		age = 58;
		currentStats.TST = 100;
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

		calculateSecondaryStats();
		combatMoves.add(CombatMove.fight);
		combatMoves.add(CombatMove.magic);
		combatMoves.add(CombatMove.aim);
		combatMoves.add(CombatMove.shieldsUp);
		
	}

	


}
