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
import com.redhaan.adventurersGalore.entity.combatAddOns.CombatMovesBar;
import com.redhaan.adventurersGalore.entity.combatAddOns.HealthBar;
import com.redhaan.adventurersGalore.entity.enemies.Enemy;
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
	ArrayList<Enemy> enemiesInRange;
	// public PlayerTurnLeftClickSituation leftClickSituation;
	public int battlesPassed;

	public int tier;

	public int sigilSlots;
	public ArrayList<Sigil> sigils;
	public Tattoo tattoo;
	public Skills skills;

	public Personality personality;
	public Titbit titbit;

	public ArrayList<CombatMove> combatMoves;

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
		sigils = new ArrayList<Sigil>();
		personality = new Personality();
		titbit = new Titbit();
		skills = new Skills();
		enemiesInRange = new ArrayList<Enemy>();
		combatMoves = new ArrayList<CombatMove>();
		combatMovesBar = new CombatMovesBar(this);

	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		switch (GameManager.gameState) {

		case Combat:

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
						if (gameContainer.getInput().getMouseX() / GameManager.GAMETILESIZE == getCombatX()
								&& gameContainer.getInput().getMouseY() / GameManager.GAMETILESIZE == getCombatY()) {
							selected = true;
						}
					}

					break;

				case selected_notMoved_notActed:

					idleTimer += (deltaTime * idleAnimationSpeed);
					if (idleTimer > 4) {
						idleTimer = 0;
					}

					combatMovesBar.update(gameContainer, deltaTime);
					moveRange = MoveRangeFiller.fillMoveRange(getCombatX(), getCombatY(), currentStats.move);

					if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {

						// 'FIGHT' or 'AIM' or 'BACKSTAB' COMBATMOVE ACTIVATED
						if (combatMoves.get(CombatMovesBar.selectedNumber - 1).name.equals("Fight")
								|| combatMoves.get(CombatMovesBar.selectedNumber - 1).name.equals("Aim!")
								|| combatMoves.get(CombatMovesBar.selectedNumber - 1).name.contentEquals("Back Stab")) {

							if (combatMoves.get(CombatMovesBar.selectedNumber - 1).name.equals("Aim!")) { Attack.aimedAttack = true; }
							else if (combatMoves.get(CombatMovesBar.selectedNumber - 1).name.equals("Back Stab")) { Attack.backstab = true; }

							boolean keepGoing = true;

							enemiesInRange = checkEnemiesInWeaponRange(combatX, combatY, weapon.minRange,
									weapon.maxRange);
							if (enemiesInRange.size() > 0) {

								Enemy enemy = checkSelectedEnemy(enemiesInRange,
										gameContainer.getInput().getMouseX() / GameManager.GAMETILESIZE,
										gameContainer.getInput().getMouseY() / GameManager.GAMETILESIZE);

								if (enemy != null) {
									keepGoing = false;
									attackAnimation = true;
									Attack.attack(this, enemy);
								}
							}

							if (gameContainer.getInput().getMouseX() / GameManager.GAMETILESIZE == combatX
									&& gameContainer.getInput().getMouseY() / GameManager.GAMETILESIZE == combatY) {
								selected = false;
								hasMoved = true;
								hasActed = true;
							}

							if (keepGoing) {
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

						// 'MAGIC' COMBATMOVE ACTIVATED

						// 'SHIELDS UP!' COMBATMOVE ACTIVATED

						// 'MEDITATE' COMBATMOVE ACTIVATED
						if (gameContainer.getInput().getMouseX() / GameManager.GAMETILESIZE == combatX
								&& gameContainer.getInput().getMouseY() / GameManager.GAMETILESIZE == combatY) {
							System.out.println("MAG Increased");
							currentStats.MAG = currentStats.MAG + 5;
							selected = false;
							hasMoved = true;
							hasActed = true;
						} else { selected = false; }

						// 'MOW DOWN!' COMBATMOVE ACTIVATED

					}

					break;

				case selected_moved_notActed:

					idleTimer += (deltaTime * idleAnimationSpeed);
					if (idleTimer > 4) {
						idleTimer = 0;
					}

					combatMovesBar.update(gameContainer, deltaTime);

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

				if (selected) {
					if (!hasMoved) {
						MoveAreaDrawer.drawMoveArea(moveRange, renderer);
					}
					combatMovesBar.render(gameContainer, renderer);
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
				return PlayerCombatSituation.selected_moved_notActed;
			} else {
				return PlayerCombatSituation.selected_notMoved_notActed;
			}
		} else {
			if (hasMoved) {
				return PlayerCombatSituation.notSelected_turnFinished;
			} else {
				return PlayerCombatSituation.notSelected_turnAvailable;
			}
		}

	}

	private ArrayList<Enemy> checkEnemiesInWeaponRange(int x, int y, int minRange, int maxRange) {

		ArrayList<Enemy> enemiesInRange = new ArrayList<Enemy>();
		for (int i = 0; i < Combat.enemies.size(); i++) {

			int xDistance = Math.abs(Combat.enemies.get(i).getCombatX()) - Math.abs(x);
			int yDistance = Math.abs(Combat.enemies.get(i).getCombatY()) - Math.abs(y);
			int totalDistance = Math.abs(xDistance) + Math.abs(yDistance);
			if (totalDistance >= weapon.minRange && totalDistance <= weapon.maxRange) {
				enemiesInRange.add(Combat.enemies.get(i));
			}
			/*
			 * if (x - 1 == Combat.enemies.get(i).getCombatX() && y ==
			 * Combat.enemies.get(i).getCombatY()) {
			 * enemiesInRange.add(Combat.enemies.get(i)); } else if (x + 1 ==
			 * Combat.enemies.get(i).getCombatX() && y ==
			 * Combat.enemies.get(i).getCombatY()) {
			 * enemiesInRange.add(Combat.enemies.get(i)); } else if (x ==
			 * Combat.enemies.get(i).getCombatX() && y - 1 ==
			 * Combat.enemies.get(i).getCombatY()) {
			 * enemiesInRange.add(Combat.enemies.get(i)); } else if (x ==
			 * Combat.enemies.get(i).getCombatX() && y + 1 ==
			 * Combat.enemies.get(i).getCombatY()) {
			 * enemiesInRange.add(Combat.enemies.get(i)); }
			 */
		}
		return enemiesInRange;
	}

	private Enemy checkSelectedEnemy(ArrayList<Enemy> enemiesInRange, int x, int y) {

		for (int i = 0; i < enemiesInRange.size(); i++) {
			if (x == enemiesInRange.get(i).getCombatX() && y == enemiesInRange.get(i).getCombatY()) {
				return enemiesInRange.get(i);
			}
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
