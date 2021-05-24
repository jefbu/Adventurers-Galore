package com.redhaan.adventurersGalore.entity.adventurer;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.combat.Attack;
import com.redhaan.adventurersGalore.combat.Combat;
import com.redhaan.adventurersGalore.combat.MoveAreaDrawer;
import com.redhaan.adventurersGalore.combat.MoveRangeFiller;
import com.redhaan.adventurersGalore.combat.PlayerCombatSituation;
import com.redhaan.adventurersGalore.entity.Monster;
import com.redhaan.adventurersGalore.entity.adventurer.personality.Personality;
import com.redhaan.adventurersGalore.entity.adventurer.skills.Skills;
import com.redhaan.adventurersGalore.entity.adventurer.spells.Spell;
import com.redhaan.adventurersGalore.entity.combatAddOns.CombatMovesBar;
import com.redhaan.adventurersGalore.entity.combatAddOns.HealthBar;
import com.redhaan.adventurersGalore.entity.town.Town;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class Adventurer extends Monster {

	private static final long serialVersionUID = 1L;

	public Race race;
	public String gender;
	public int genderInt;
	public int age;

	public int mapX, mapY;

	private int level;
	private int money;

	public Town homeTown;

	public boolean inParty;
	public PlayerCombatSituation combatSituation;
	public boolean selected;
	public boolean hasMoved;
	public boolean hasActed;
	ArrayList<Monster> targetsInRange;
	// public PlayerTurnLeftClickSituation leftClickSituation;
	public int battlesPassed;

	public int tier;

	public int spellSlots;
	public ArrayList<Sigil> spells;
	public Tattoo tattoo;
	public Skills skills;

	public Personality personality;
	public Titbit titbit;

	public ArrayList<CombatMove> combatMoves;
	private int combatAnimationTypeNumber;
	
	Monster opponent;
	Monster selectedAlly;

	public Adventurer() {

		super();

		race = Race.human;
		inParty = false;
		combatSituation = PlayerCombatSituation.notSelected_turnAvailable;
		selected = false;
		hasMoved = false;
		hasActed = false;
		// leftClickSituation = PlayerTurnLeftClickSituation.NothingToDo;
		battlesPassed = 0;
		spells = new ArrayList<Sigil>();
		personality = new Personality();
		titbit = new Titbit();
		skills = new Skills();
		targetsInRange = new ArrayList<Monster>();
		combatMoves = new ArrayList<CombatMove>();
		combatMovesBar = new CombatMovesBar(this);
		combatAnimationTypeNumber = 1;

	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		switch (GameManager.gameState) {

		case Combat:

			switch (Combat.combatState) {
			
			case EnemyTurn:
				break;				
			case PlayerTurn:

				if (actingAnimation) {
					attackTimer += (deltaTime * attackAnimationSpeed);
					if (attackTimer > 4) {
						attackTimer = 0;
						actingAnimation = false;
						selected = false;
						hasMoved = true;
						hasActed = true;
						combatAnimationTypeNumber = 1;
						CombatMovesBar.selectedNumber = 0;
						idleTimer = 0;
					}
				}
				
				combatSituation = decidePlayerCombatSituation();
				
				switch (combatSituation) {
			
				case notSelected_turnAvailable:
										
					idleTimer += (deltaTime * idleAnimationSpeed);
					if (idleTimer > 4) {
						idleTimer = 0;
					}

					if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
						if (gameContainer.getInput().getMouseX() / GameManager.GAMETILESIZE == getCombatX()
								&& gameContainer.getInput().getMouseY() / GameManager.GAMETILESIZE == getCombatY()) {
							selected = true;
						}
					}

					break;

				case selected_notMoved_noCombatMoveChosen_notActed:
					
					idleTimer += (deltaTime * idleAnimationSpeed);
					if (idleTimer > 4) {
						idleTimer = 0;
					}

					moveRange = MoveRangeFiller.fillMoveRange(getCombatX(), getCombatY(), currentStats.move);

					if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) { 
						
						if (gameContainer.getInput().getMouseX() / GameManager.GAMETILESIZE == combatX
								&& gameContainer.getInput().getMouseY() / GameManager.GAMETILESIZE == combatY) {
							hasMoved = true;
						}

						else {
							boolean inMoveRange = false;
							for (int i = 0; i < moveRange.size(); i++) {
								if (moveRange.get(i)[0] == gameContainer.getInput().getMouseX()
										/ GameManager.GAMETILESIZE
										&& moveRange.get(i)[1] == gameContainer.getInput().getMouseY()
												/ GameManager.GAMETILESIZE) {
									combatX = gameContainer.getInput().getMouseX() / GameManager.GAMETILESIZE;
									combatY = gameContainer.getInput().getMouseY() / GameManager.GAMETILESIZE;
									hasMoved = true;
									inMoveRange = true;
								}
							}

							if (!inMoveRange) { 
								selected = false;
							}
						}
						
					}
					
					break;
				
				case selected_moved_noCombatMoveChosen_notActed:
					idleTimer += (deltaTime * idleAnimationSpeed);
					if (idleTimer > 4) {
						idleTimer = 0;
					}
					combatMovesBar.update(gameContainer, deltaTime);
					break;
					
										
				case selected_moved_combatMoveChosen_notActed:
										
					idleTimer += (deltaTime * idleAnimationSpeed);
					if (idleTimer > 4) {
						idleTimer = 0; 
					}
					
					// 'FIGHT' or 'AIM' or 'BACKSTAB' COMBATMOVE ACTIVATED					
					if (combatMoves.get(CombatMovesBar.selectedNumber - 1).name == "Fight" 
							|| combatMoves.get(CombatMovesBar.selectedNumber - 1).name == "Aim!"
							|| combatMoves.get(CombatMovesBar.selectedNumber - 1).name == "Back Stab") {
					
						if (combatMoves.get(CombatMovesBar.selectedNumber - 1).name == "Aim!") { Attack.aimedAttack = true; }
						else if (combatMoves.get(CombatMovesBar.selectedNumber - 1).name == "Back Stab") { Attack.backstab = true; }
					
						targetsInRange = checkEnemiesInWeaponRange(getCombatX(), getCombatY(), 
								weapon.minRange, weapon.maxRange);
					
						if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
		
							if (targetsInRange.size() > 0) {
								opponent = checkSelectedEnemy(targetsInRange,
										gameContainer.getInput().getMouseX() / GameManager.GAMETILESIZE,
										gameContainer.getInput().getMouseY() / GameManager.GAMETILESIZE);

								if (opponent != null) {
									combatAnimationTypeNumber = 1;
									actingAnimation = true;
									Attack.attack(this, opponent);
								} else {
									selected = false;
									hasActed = true;
									CombatMovesBar.selectedNumber = 0;
								}
							} else {
								selected = false;
								hasActed = true;
								CombatMovesBar.selectedNumber = 0;
							}
						}
					}

						// 'MAGIC' COMBATMOVE ACTIVATED

						// 'SHIELDS UP!' COMBATMOVE ACTIVATED
					else if (combatMoves.get(CombatMovesBar.selectedNumber - 1).name == "Shields Up!") {
							
						targetsInRange = checkEligibleAdventurers(getCombatX(), getCombatY(), 5);
						
						if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
							
							for (Monster adventurer: targetsInRange) {
								if (gameContainer.getInput().getMouseX() / GameManager.GAMETILESIZE  == adventurer.getCombatX() &&
										gameContainer.getInput().getMouseY() / GameManager.GAMETILESIZE == adventurer.getCombatY()) {
									System.out.println("clicked on" + adventurer.name);
									combatAnimationTypeNumber = 2;
									actingAnimation = true;
									selectedAlly = adventurer;
									adventurer.currentStats.defence += 5;
								}
							}
							
						}

					}					
						

						// 'MEDITATE' COMBATMOVE ACTIVATED
					else if (combatMoves.get(CombatMovesBar.selectedNumber - 1).name == "Meditate") {
						
						targetsInRange = new ArrayList<Monster>();
						targetsInRange.add(this);
						
						if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
							if (gameContainer.getInput().getMouseX() / GameManager.GAMETILESIZE == getCombatX() && gameContainer.getInput().getMouseY() / GameManager.GAMETILESIZE == getCombatY()) {
								currentStats.MAG += 5;
								combatAnimationTypeNumber = 3;
								actingAnimation = true;
								selected = false;
								//hasMoved = true;
								hasActed = true;
							}
							else {
								selected = false;
								hasActed = true;
							}							
						}
					} 
						
						// 'MOW DOWN!' COMBATMOVE ACTIVATED
						
						
					else { 
							selected = false; 
							//hasMoved = true;
							hasActed = true;
							CombatMovesBar.selectedNumber = 0;
					}




					/*combatMovesBar.update(gameContainer, deltaTime);

					enemiesInRange = checkEnemiesInWeaponRange(combatX, combatY, weapon.minRange, weapon.maxRange);
					if (enemiesInRange.size() > 0) {

						if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {

							Enemy enemy = checkSelectedEnemy(enemiesInRange,
									gameContainer.getInput().getMouseX() / GameManager.GAMETILESIZE,
									gameContainer.getInput().getMouseY() / GameManager.GAMETILESIZE);
							if (enemy == null) {
								System.out.println("enemy null");
								selected = false;
								hasActed = true;
							} else {
								actingAnimation = true;
								Attack.attack(this, enemy);
							}
						}

					}

					else {
						hasActed = true;
						selected = false;
					}*/

					break;

				case notSelected_turnFinished:
					turnPassed = true;
					break;

				default:
					break;

				}
			}

			break;

		case InTown:
			break;
		case Titlescreen:
			break;
		case WorldMap:
			break;
		case PartyScreen:
			break;
		case QuestUI:
			break;
		case Transition:
			break;
		case QuestScreen:
			break;
		case PartyCohesionCheckerUI:
			break;
		case Inventory:
			break;

		}

	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		switch (GameManager.gameState) {

		case Combat:

			switch (Combat.combatState) {
			
			case EnemyTurn:

				renderer.drawImageTile(icon, combatX * GameManager.GAMETILESIZE, combatY * GameManager.GAMETILESIZE,
						genderInt, 0);
				break;

			case PlayerTurn:
				
				if(!actingAnimation) {
					
					switch(combatSituation) {
					
					case notSelected_turnAvailable:
						renderer.drawImageTile(icon, combatX * GameManager.GAMETILESIZE, combatY * GameManager.GAMETILESIZE,
								(int) idleTimer + genderInt, 0);
						break;
						
					case selected_notMoved_noCombatMoveChosen_notActed:
						renderer.drawImageTile(icon, combatX * GameManager.GAMETILESIZE, combatY * GameManager.GAMETILESIZE,
								(int) idleTimer + genderInt, 0);
						MoveAreaDrawer.drawMoveArea(moveRange, renderer);
						break;
					
					case selected_moved_noCombatMoveChosen_notActed:
						renderer.drawImageTile(icon, combatX * GameManager.GAMETILESIZE, combatY * GameManager.GAMETILESIZE,
								(int) idleTimer + genderInt, 0);
						combatMovesBar.render(gameContainer, renderer);
						break;
						
					case selected_moved_combatMoveChosen_notActed:
						renderer.drawImageTile(icon, combatX * GameManager.GAMETILESIZE, combatY * GameManager.GAMETILESIZE,
								(int) idleTimer + genderInt, 0);
						combatMovesBar.render(gameContainer, renderer);
						for (Monster monster: targetsInRange) {
							renderer.drawRectOpaque(
									monster.getCombatX() * GameManager.GAMETILESIZE, monster.getCombatY() * GameManager.GAMETILESIZE, GameManager.GAMETILESIZE, GameManager.GAMETILESIZE, 0x44ffffff);
						}
						break;
						
					case notSelected_turnFinished:
						renderer.drawImageTile(icon, combatX * GameManager.GAMETILESIZE, combatY * GameManager.GAMETILESIZE, 0 + genderInt, 0);
						break;
					
					}
					
				} else {
					
					switch(combatAnimationTypeNumber) {
					
					case 1:
						renderer.drawImageTile(icon, combatX * GameManager.GAMETILESIZE, combatY * GameManager.GAMETILESIZE,
								(int) attackTimer + genderInt, 1);						
						break;
					case 2:
						renderer.drawImageTile(icon, combatX * GameManager.GAMETILESIZE, combatY * GameManager.GAMETILESIZE,
								(int) attackTimer + genderInt, 1);	
						renderer.drawImageTile(CombatMove.icon, selectedAlly.getCombatX() * GameManager.GAMETILESIZE, selectedAlly.getCombatY() * GameManager.GAMETILESIZE, (int) attackTimer + 5, 2);
						break;	
					case 3:
						renderer.drawImageTile(icon, combatX * GameManager.GAMETILESIZE, combatY * GameManager.GAMETILESIZE,
								0 + genderInt, 1);	
						renderer.drawImageTile(CombatMove.icon, getCombatX() * GameManager.GAMETILESIZE, getCombatY() * GameManager.GAMETILESIZE, (int) attackTimer + 5, 3);
						break;						
						
					}
				

				}
							
			}

			HealthBar.drawHealthBar(this, renderer);
			break;

		case InTown:
			break;
		case Titlescreen:
			break;
		case WorldMap:
			break;
		case PartyScreen:
			break;
		case QuestUI:
			break;
		case Transition:
			break;
		case QuestScreen:
			break;
		case PartyCohesionCheckerUI:
			break;
		case Inventory:
			break;

		}

	}

	private PlayerCombatSituation decidePlayerCombatSituation() {
		if (selected) {
			if (hasMoved) {
				if(CombatMovesBar.selectedNumber == 0) { return PlayerCombatSituation.selected_moved_noCombatMoveChosen_notActed; }
				else { return PlayerCombatSituation.selected_moved_combatMoveChosen_notActed; }
			} else {
				return PlayerCombatSituation.selected_notMoved_noCombatMoveChosen_notActed;
			}
		} else {
			if (hasMoved) {
				return PlayerCombatSituation.notSelected_turnFinished;
			} else {
				return PlayerCombatSituation.notSelected_turnAvailable;
			}
		}

	}

	private ArrayList<Monster> checkEnemiesInWeaponRange(int x, int y, int minimumRange, int maximumRange) {

		ArrayList<Monster> enemiesInRange = new ArrayList<Monster>();
		for (int i = 0; i < Combat.enemies.size(); i++) {

			if(!Combat.enemies.get(i).isDead()) {
				int xDistance = Math.abs(Combat.enemies.get(i).getCombatX()) - Math.abs(x);
				int yDistance = Math.abs(Combat.enemies.get(i).getCombatY()) - Math.abs(y);
				int totalDistance = Math.abs(xDistance) + Math.abs(yDistance);
				if (totalDistance >= minimumRange && totalDistance <= maximumRange) {
					enemiesInRange.add(Combat.enemies.get(i));
				}
			}

		}
		return enemiesInRange;
	}

	private Monster checkSelectedEnemy(ArrayList<Monster> enemiesInRange, int x, int y) {

		for (int i = 0; i < enemiesInRange.size(); i++) {
			if (x == enemiesInRange.get(i).getCombatX() && y == enemiesInRange.get(i).getCombatY()) {
				return enemiesInRange.get(i);
			}
		}
		return null;
	}
	
	
	private ArrayList<Monster> checkEligibleAdventurers(int x, int y, int range) {
		
		ArrayList<Monster> adventurersInRange = new ArrayList<Monster>();
		
		for (Adventurer adventurer: GameManager.adventurers.allAdventurers) {
			if (adventurer.inParty && !adventurer.isDead()) {
				int xDistance = Math.abs(adventurer.getCombatX()) - Math.abs(x);
				int yDistance = Math.abs(adventurer.getCombatY()) - Math.abs(y);
				int totalDistance = Math.abs(xDistance) + Math.abs(yDistance);
				if (totalDistance <= range) { adventurersInRange.add(adventurer); }
			}
		}
		
		return adventurersInRange;
		
	}
	
	
	

	public void levelUp() {
		LevelUpRoller.levelUp(this);
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

}
