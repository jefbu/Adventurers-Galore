package com.redhaan.adventurersGalore.combat;

public enum PlayerTurnLeftClickSituation {
	
	Unit_Active_NOTMoved, 
	Unit_Inactive_TurnPassed, 
	Unit_Active_Moved_EnemyINRANGE,
	Unit_Active_Moved_EnemyNOTINRANGE,
	Active_Enemy_INRange, 
	Enemy_NOTINRange, 
	NothingToDo, 

}
