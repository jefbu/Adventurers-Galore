package com.redhaan.adventurersGalore.entity.adventurer;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.combat.Attack;
import com.redhaan.adventurersGalore.combat.Combat;
import com.redhaan.adventurersGalore.combat.CombatLeftClicker;
import com.redhaan.adventurersGalore.combat.MoveAreaDrawer;
import com.redhaan.adventurersGalore.combat.PlayerTurnLeftClickSituations;
import com.redhaan.adventurersGalore.entity.Monster;
import com.redhaan.adventurersGalore.entity.adventurer.personality.Personality;
import com.redhaan.adventurersGalore.entity.combatAddOns.HealthBar;
import com.redhaan.adventurersGalore.entity.town.Town;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class Adventurer extends Monster {

	public Race race;
	public String name;
	public String gender;
	private int genderInt;
	public int age;
	
	public int mapX, mapY;

	private int level;
	private int money;

	public Town homeTown;

	public boolean inParty;
	public boolean moving;
	public PlayerTurnLeftClickSituations leftClickSituation;
	public int battlesPassed;
	
	public int tier;
	
	public int sigilSlots;
	public ArrayList<Sigil> sigils;
	public Tattoo tattoo;
	
	public Personality personality;
	public Titbit titbit;
		
	public Adventurer() {

		super();

		race = Race.human;
		inParty = false;
		moving = false;
		leftClickSituation = PlayerTurnLeftClickSituations.NothingToDo;
		battlesPassed = 0;
		sigils = new ArrayList<Sigil>();
		genderInt = 0;
		personality = new Personality();
		titbit = new Titbit();

	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		switch (GameManager.gameState) {

		case Combat:

			if (gender.equals("Female")) { genderInt = 4; } else { genderInt = 0; }
			switch (Combat.combatState) {

			case EnemyTurn:
				break;

			case PlayerTurn:

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
						// leftClickSituation = PlayerTurnLeftClickSituations.NothingToDo;
						break;
					case Unit_Active_Moved_EnemyNOTINRANGE:
						combatX = gameContainer.getInput().getMouseX() / GameManager.GAMETILESIZE;
						combatY = gameContainer.getInput().getMouseY() / GameManager.GAMETILESIZE;
						moving = false;
						turnPassed = true;
						break;
					case Unit_Active_NOTMoved:
						moving = true;
						skillBar.update(gameContainer, deltaTime);
						break;
					case Unit_Inactive_TurnPassed:
						moving = false;
						turnPassed = true;
						break;
					}

				}
			}

			break;

		case InTown: break;
		case Titlescreen: break;
		case WorldMap: break;
		case PartyScreen: break;
		case QuestUI: break;
		case Transition: break;

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

				if (moving) {
					MoveAreaDrawer.drawMoveArea(moveRange, renderer);
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

		}

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
