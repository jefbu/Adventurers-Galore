package com.redhaan.adventurersGalore;

import java.util.Random;

import com.redhaan.adventurersGalore.calendar.Calendar;
import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;
import com.redhaan.adventurersGalore.entity.adventurer.AdventurerGoalEnum;
import com.redhaan.adventurersGalore.entity.town.TownNeighbours;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class AdventurerGoals extends GameObject {
	
	private Random random;
	private boolean newGoalsChosen;
	
	public AdventurerGoals() {
		
		random = new Random();
		newGoalsChosen = false;
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		
		if (Calendar.monthDay == 1 && !newGoalsChosen) {
			
			for (Adventurer adventurer: GameManager.adventurers.allAdventurers) {
				setGoal(adventurer);
			}
			
			
			for (int i = 1; i < 3; i++) {
				System.out.println(GameManager.adventurers.allAdventurers.get(i).name+ " is: " + GameManager.adventurers.allAdventurers.get(i).goal.adventurerGoalEnum);
				System.out.println("and is at: " + GameManager.adventurers.allAdventurers.get(i).goal.town.name + " (" + 
						GameManager.adventurers.allAdventurers.get(i).goal.town.xLocations[0] + ", " + GameManager.adventurers.allAdventurers.get(i).goal.town.yLocations[0] + ")");
			}
			
		newGoalsChosen = true;
		
		}
		
		else if (Calendar.monthDay == 17) { newGoalsChosen = false; }
		
		
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
	}
	
	
	
	private void setGoal(Adventurer adventurer) {
		
		switch(adventurer.goal.adventurerGoalEnum) {
		
		case Idle:
			if (random.nextInt(100) + 1 > 30) {
				setNewGoal(adventurer);
			}
			break;
		
		case Travelling:
			chooseNextTown(adventurer);
			adventurer.mapX = adventurer.goal.town.xLocations[0];
			adventurer.mapY = adventurer.goal.town.yLocations[0];
			if (random.nextInt(100) + 1 > 40) {
				setNewGoal(adventurer);
			}
			break;
		
		case Military:
			if (random.nextInt(100) + 1 > 70) {
				setNewGoal(adventurer);
			}
			break;
		
		case Adventuring:
			if (random.nextInt(10) + 1 > 8) {
				chooseNextTown(adventurer);
				adventurer.mapX = adventurer.goal.town.xLocations[0];
				adventurer.mapY = adventurer.goal.town.yLocations[0];
			}
			if (random.nextInt(100) + 1 > 60) {
				setNewGoal(adventurer);
			}
			break;
		
		case Training:
			if (random.nextInt(100) + 1 > 60) {
				setNewGoal(adventurer);
			}
			break;
		
		case InParty:
			break;
		
		case Questing:
			break;

		}
	}
	
	private void setNewGoal(Adventurer adventurer) {
		
		int roll = random.nextInt(100) + 1;
		
		if (roll > 90) { adventurer.goal.adventurerGoalEnum = AdventurerGoalEnum.Training; }
		else if (roll > 10) { adventurer.goal.adventurerGoalEnum = AdventurerGoalEnum.Travelling; }
		else if (roll > 40) { adventurer.goal.adventurerGoalEnum = AdventurerGoalEnum.Military; }
		else if (roll > 20) { adventurer.goal.adventurerGoalEnum = AdventurerGoalEnum.Adventuring; }
		else { adventurer.goal.adventurerGoalEnum = AdventurerGoalEnum.Idle; }
		
	}
	
	
	private void chooseNextTown(Adventurer adventurer) {
		
		adventurer.goal.town = TownNeighbours.getNeighbouringTowns(adventurer.goal.town);
		
	}
	
		

}
