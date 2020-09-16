package com.redhaan.adventurersGalore.entity.adventurer;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.combat.Attack;
import com.redhaan.adventurersGalore.combat.Combat;
import com.redhaan.adventurersGalore.combat.MoveAreaDrawer;
import com.redhaan.adventurersGalore.combat.MoveRangeFiller;
import com.redhaan.adventurersGalore.combat.PlayerCombatSituation;
import com.redhaan.adventurersGalore.combat.PlayerTurnLeftClickSituation;
import com.redhaan.adventurersGalore.entity.Monster;
import com.redhaan.adventurersGalore.entity.adventurer.personality.Personality;
import com.redhaan.adventurersGalore.entity.adventurer.skills.Skills;
import com.redhaan.adventurersGalore.entity.combatAddOns.HealthBar;
import com.redhaan.adventurersGalore.entity.enemies.Enemy;
import com.redhaan.adventurersGalore.entity.town.Town;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class Adventurer extends Monster {

	private static final long serialVersionUID = 1L;

	public Race race;
	public String gender;
	private int genderInt;
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
	ArrayList<Enemy> enemiesInRange;
	//public PlayerTurnLeftClickSituation leftClickSituation;
	public int battlesPassed;
	
	public int tier;
	
	public int sigilSlots;
	public ArrayList<Sigil> sigils;
	public Tattoo tattoo;
	public Skills skills;
	
	public Personality personality;
	public Titbit titbit;
		
	public Adventurer() {

		super();

		race = Race.human;
		inParty = false;
		combatSituation = PlayerCombatSituation.notSelected_turnAvailable;
		selected = false;
		hasMoved = false;
		hasActed = false;
		//leftClickSituation = PlayerTurnLeftClickSituation.NothingToDo;
		battlesPassed = 0;
		sigils = new ArrayList<Sigil>();
		genderInt = 0;
		personality = new Personality();
		titbit = new Titbit();
		skills = new Skills();
		enemiesInRange = new ArrayList<Enemy>();

	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		switch (GameManager.gameState) {

		case Combat:

			if (gender.equals("Female")) { genderInt = 4; } else { genderInt = 0; }
			
			if (attackAnimation) {
				attackTimer += (deltaTime * attackAnimationSpeed);
				if (attackTimer > 4) {
					attackTimer = 0;
					attackAnimation = false;
					selected = false;
					hasMoved = true;
					hasActed = true;
				}
			}
			
			switch (Combat.combatState) {

			case EnemyTurn:
				break;

			case PlayerTurn:

				combatSituation = decidePlayerCombatSituation();
				
				switch (combatSituation) {
				
				case notSelected_turnAvailable:
					
					idleTimer += (deltaTime * idleAnimationSpeed);
					if (idleTimer > 4) {
						idleTimer = 0;
					}
					
					if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
						if (gameContainer.getInput().getMouseX() / GameManager.GAMETILESIZE == getCombatX() &&
								gameContainer.getInput().getMouseY() / GameManager.GAMETILESIZE == getCombatY()) {
							selected = true;
						}
					}
					
					break;
					
				case selected_notMoved_notActed:
					
					idleTimer += (deltaTime * idleAnimationSpeed);
					if (idleTimer > 4) {
						idleTimer = 0;
					}
					
					skillBar.update(gameContainer, deltaTime);
					moveRange = MoveRangeFiller.fillMoveRange(getCombatX(), getCombatY(), currentStats.move);
					
					if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
						
						boolean keepGoing = true; 
						
						enemiesInRange = checkEnemiesInWeaponRange(combatX, combatY);
						if(enemiesInRange.size() > 0) { 
					
								Enemy enemy = checkSelectedEnemy(
										enemiesInRange, gameContainer.getInput().getMouseX() / GameManager.GAMETILESIZE, gameContainer.getInput().getMouseY() / GameManager.GAMETILESIZE);
								
								if(enemy != null) {
									keepGoing = false;
									attackAnimation = true;
									Attack.attack(this, enemy); 
								}								
						}
							
						if(gameContainer.getInput().getMouseX() / GameManager.GAMETILESIZE == combatX &&
								gameContainer.getInput().getMouseY() / GameManager.GAMETILESIZE == combatY) {
							selected = false;
							hasMoved = true;
							hasActed = true;
						}
						
						if(keepGoing) {
							boolean inMoveRange = false;
							for (int i = 0; i < moveRange.size(); i++) {
								if (moveRange.get(i)[0] == gameContainer.getInput().getMouseX() / GameManager.GAMETILESIZE &&
										moveRange.get(i)[1] == gameContainer.getInput().getMouseY() / GameManager.GAMETILESIZE) {
									combatX = gameContainer.getInput().getMouseX() / GameManager.GAMETILESIZE;
									combatY = gameContainer.getInput().getMouseY() / GameManager.GAMETILESIZE;
									hasMoved = true;
									inMoveRange = true;
								}
							}
							if(!inMoveRange) { selected = false; }
						}

							
					}
												
					break;
					
				case selected_moved_notActed:
					
					idleTimer += (deltaTime * idleAnimationSpeed);
					if (idleTimer > 4) {
						idleTimer = 0;
					}
					
					skillBar.update(gameContainer, deltaTime);
					
					enemiesInRange = checkEnemiesInWeaponRange(combatX, combatY);
					if(enemiesInRange.size() > 0) {
						
						if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
							
							Enemy enemy = checkSelectedEnemy(
									enemiesInRange, gameContainer.getInput().getMouseX() / GameManager.GAMETILESIZE, gameContainer.getInput().getMouseY() / GameManager.GAMETILESIZE);
							if(enemy == null) {
								System.out.println("enemy null");
								selected = false;
								hasActed = true;
							}							
							else {
								attackAnimation = true;
								Attack.attack(this, enemy); 
								}
						}
						
					}
					
					else {
						hasActed = true;
						selected = false;
					}					
					
					break;

					
				case notSelected_turnFinished:
					turnPassed = true;
				break;
				
				
				default:
					break;
				
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				/*
				if(moving) { skillBar.update(gameContainer, deltaTime); }

				idleTimer += (deltaTime * idleAnimationSpeed);
				if (idleTimer > 4) {
					idleTimer = 0;
				}

				if (attackAnimation) {
					attackTimer += (deltaTime * attackAnimationSpeed);
					if (attackTimer > 4) {
						attackTimer = 0;
						attackAnimation = false;
						leftClickSituation = PlayerTurnLeftClickSituations.NothingToDo;
						turnPassed = true;
					}
				}

				if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {

					leftClickSituation = CombatLeftClicker.decidePlayerLeftClickSituation(this,
							gameContainer.getInput().getMouseX(), gameContainer.getInput().getMouseY());

					switch (leftClickSituation) {

					case Active_Enemy_INRange:
						attackAnimation = true;
						for (Monster enemy : Combat.enemies) {
							if (enemy.getCombatX() == gameContainer.getInput().getMouseX() / GameManager.GAMETILESIZE
									&& enemy.getCombatY() == gameContainer.getInput().getMouseY()
											/ GameManager.GAMETILESIZE) {
								Attack.attack(this, enemy);
							}
						}
						leftClickSituation = PlayerTurnLeftClickSituations.NothingToDo;
						break;
					case Enemy_NOTINRange:
						break;
					case NothingToDo:
						moving = false;
						break;
					case Unit_Active_Moved_EnemyINRANGE:
						combatX = gameContainer.getInput().getMouseX() / GameManager.GAMETILESIZE;
						combatY = gameContainer.getInput().getMouseY() / GameManager.GAMETILESIZE;
						moving = false;
						leftClickSituation = PlayerTurnLeftClickSituations.NothingToDo;
						break;
					case Unit_Active_Moved_EnemyNOTINRANGE:
						combatX = gameContainer.getInput().getMouseX() / GameManager.GAMETILESIZE;
						combatY = gameContainer.getInput().getMouseY() / GameManager.GAMETILESIZE;
						moving = false;
						turnPassed = true;
						break;
					case Unit_Active_NOTMoved:
						moving = true;
						break;
					case Unit_Inactive_TurnPassed:
						moving = false;
						turnPassed = true;
						break;
					}

				}
				break;
				*/
			}
			
			break;

		case InTown: break;
		case Titlescreen: break;
		case WorldMap: break;
		case PartyScreen: break;
		case QuestUI: break;
		case Transition: break;
		case QuestScreen: break;
		case PartyCohesionCheckerUI: break;

		}

	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		switch (GameManager.gameState) {

		case Combat:

			switch (Combat.combatState) {
			case EnemyTurn:

				renderer.drawImageTile(icon, combatX * GameManager.GAMETILESIZE, combatY * GameManager.GAMETILESIZE, genderInt,
						0);
				break;

			case PlayerTurn:

				if (selected) {
					if(!hasMoved) { MoveAreaDrawer.drawMoveArea(moveRange, renderer); }
					skillBar.render(gameContainer, renderer);
				}

				if (!attackAnimation && !turnPassed) {
					renderer.drawImageTile(icon, combatX * GameManager.GAMETILESIZE, combatY * GameManager.GAMETILESIZE,
							(int) idleTimer + genderInt, 0);
				} else if (attackAnimation && !turnPassed) {
					renderer.drawImageTile(icon, combatX * GameManager.GAMETILESIZE, combatY * GameManager.GAMETILESIZE,
							(int) attackTimer + genderInt, 1);
				} else {
					renderer.drawImageTile(icon, combatX * GameManager.GAMETILESIZE, combatY * GameManager.GAMETILESIZE,
							0 + genderInt, 0);
				}

				break;
			}

			HealthBar.drawHealthBar(this, renderer);
			break;

		case InTown: break;
		case Titlescreen: break;
		case WorldMap: break;
		case PartyScreen: break;
		case QuestUI: break;
		case Transition: break;
		case QuestScreen: break;
		case PartyCohesionCheckerUI: break;

		}

	}
	
	private PlayerCombatSituation decidePlayerCombatSituation() {
		if(selected) {
			if(hasMoved) { return PlayerCombatSituation.selected_moved_notActed; }
			else { return PlayerCombatSituation.selected_notMoved_notActed; }
		}
		else {
			if(hasMoved) { return PlayerCombatSituation.notSelected_turnFinished; }
			else { return PlayerCombatSituation.notSelected_turnAvailable; }
		}
		
	}
	
	
	private ArrayList<Enemy> checkEnemiesInWeaponRange(int x, int y) {

		ArrayList<Enemy> enemiesInRange = new ArrayList<Enemy>();
		for (int i = 0; i < Combat.enemies.size(); i++) {
			if (x - 1 == Combat.enemies.get(i).getCombatX() && y == Combat.enemies.get(i).getCombatY()) { enemiesInRange.add(Combat.enemies.get(i)); } 
			else if (x + 1 == Combat.enemies.get(i).getCombatX() && y == Combat.enemies.get(i).getCombatY()) { enemiesInRange.add(Combat.enemies.get(i)); } 
			else if (x == Combat.enemies.get(i).getCombatX() && y - 1 == Combat.enemies.get(i).getCombatY()) { enemiesInRange.add(Combat.enemies.get(i)); } 
			else if (x == Combat.enemies.get(i).getCombatX() && y + 1 == Combat.enemies.get(i).getCombatY()) { enemiesInRange.add(Combat.enemies.get(i)); }
		}
		return enemiesInRange;
	}
	
	private Enemy checkSelectedEnemy(ArrayList<Enemy> enemiesInRange, int x, int y) {
		
		for (int i = 0; i < enemiesInRange.size(); i++) {
			if (x == enemiesInRange.get(i).getCombatX() && y == enemiesInRange.get(i).getCombatY()) { return enemiesInRange.get(i); } 
		}
		return null;
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
