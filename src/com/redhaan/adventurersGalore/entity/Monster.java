package com.redhaan.adventurersGalore.entity;

import java.util.ArrayList;
import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.combat.Combat;
import com.redhaan.adventurersGalore.combat.MoveAreaDrawer;
import com.redhaan.adventurersGalore.combat.MoveRangeFiller;
import com.redhaan.adventurersGalore.combat.combatAI.ActionDecision;
import com.redhaan.adventurersGalore.combat.combatAI.AttackDecision;
import com.redhaan.adventurersGalore.combat.combatAI.CombatActions;
import com.redhaan.adventurersGalore.combat.combatAI.MoveDecision;
import com.redhaan.adventurersGalore.entity.adventurer.Affinities;
import com.redhaan.adventurersGalore.entity.adventurer.Job;
import com.redhaan.adventurersGalore.entity.adventurer.Race;
import com.redhaan.adventurersGalore.entity.adventurer.Stats;
import com.redhaan.adventurersGalore.entity.armour.Armour;
import com.redhaan.adventurersGalore.entity.combatAddOns.HealthBar;
import com.redhaan.adventurersGalore.entity.combatAddOns.SkillBar;
import com.redhaan.adventurersGalore.entity.weapon.Weapon;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class Monster extends NPC {
	
	public Stats maxStats;
	public Stats currentStats;
	public Affinities affinities;
	public Stats levelupPercentages;
	
	public Job job;
	public Race race;
	
	protected int combatX, combatY;
	protected boolean dead;
	protected int idleAnimationSpeed;
	protected int attackAnimationSpeed;
	protected float idleTimer;
	protected float attackTimer;
	public boolean attackAnimation;
	public ArrayList<int[]> moveRange;
	
	private boolean moveRangeFlareUp;
	private int moveRangeCounter;
		
	public boolean turnPassed;
	
	private Random random;
	
	public SkillBar skillBar;
	
	public Weapon weapon;
	public Armour armour;
	
	public Monster() {
		
		super();
		
		maxStats = new Stats();
		currentStats = new Stats();
		levelupPercentages = new Stats();
		
		job = Job.squire;
		icon = job.icon;
		race = Race.human;
		
		currentStats.HP = 400;
		maxStats.HP = 400;
		
		dead = false;
		random = new Random();
		idleTimer = 0;
		attackTimer = 0;
		idleAnimationSpeed = random.nextInt(5) + 3;
		attackAnimationSpeed = random.nextInt(2) + 8;
		combatX = 6 + random.nextInt(3);
		combatY = 10 - random.nextInt(3);
		moveRange = new ArrayList<int[]>();
		
		skillBar = new SkillBar(this);
		
		moveRangeCounter = 0;
		moveRangeFlareUp = false;
		attackAnimation = false;
		turnPassed = false;
				
	}
	
	
	@Override
	public void update (GameContainer gameContainer, float deltaTime) {
		
		switch(GameManager.gameState) {
		
		case Combat:
			
			switch(Combat.combatState) {
				
			case PlayerTurn: break;
			
			case EnemyTurn:
				
					idleTimer += (deltaTime * idleAnimationSpeed);
					if(idleTimer > 4 ) {
						idleTimer = 0;
					}
					
					if(attackAnimation) {
						attackTimer +=(deltaTime * attackAnimationSpeed);
						if(attackTimer > 4) {
							attackTimer = 0;
							attackAnimation = false;
							turnPassed = true;
						}
					}
						
					if(moveRange.size() == 0) { moveRange = MoveRangeFiller.fillMoveRange(combatX, combatY, currentStats.move);}
		
					moveRangeCounter++;
					if (moveRangeCounter < 60) { moveRangeFlareUp = true; } 
					else { 
						moveRangeCounter = 0;
						moveRangeFlareUp = false;
					}
					
					if(!moveRangeFlareUp && moveRangeCounter == 0) {
						CombatActions action = ActionDecision.decideActionDecision(Combat.highLevelPlan);
						int[] moveDecision = MoveDecision.decideMoveDecision(action, moveRange, getCombatX(), getCombatY());
						combatX = moveDecision[0];
						combatY = moveDecision[1];
						AttackDecision.decideAttackDecision(this, getCombatX(), getCombatY());
						moveRange.clear();
						turnPassed = true;
						}
					
			break;
			}
			
		break;	
		case WorldMap: break;
		case Titlescreen: break;
		case InTown: break;
		case PartyScreen: break;
		case QuestUI: break;
		case Transition: break;
		
		}
		
	}
	

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		switch(GameManager.gameState) {
		
		case Combat:
			renderer.drawImageTile(icon, combatX * GameManager.GAMETILESIZE, combatY * GameManager.GAMETILESIZE, (int) idleTimer, 0);
			HealthBar.drawHealthBar(this, renderer);
			
			if(moveRangeFlareUp) {
				MoveAreaDrawer.drawMoveArea(moveRange, renderer);
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
	
	public void calculateSecondaryStats() {
		calculateTravelSpeed();
		calculateAttack();
		calculateDefence();
		calculateHit();
		calculateCritical();
	}
	
	
	private void calculateTravelSpeed() {
		int bonus = 0;
		if ((maxStats.PHY + maxStats.PRC / 2) < 15) { }
		else if (maxStats.PHY + maxStats.PRC / 2 < 20) { bonus = 1; }
		else if (maxStats.PHY + maxStats.PRC / 2 < 30) { bonus = 2; }
		else if (maxStats.PHY + maxStats.PRC / 2 < 40) {	bonus = 3; }
		else { bonus = 4; }
		maxStats.travelSpeed = maxStats.move + bonus;
		currentStats.travelSpeed = maxStats.travelSpeed;
	}
		
	private void calculateAttack() {
		maxStats.attack = maxStats.PHY + weapon.damage;
		currentStats.attack = maxStats.attack;
	}
	
	private void calculateDefence() {
		maxStats.defence = maxStats.PHY + armour.defence;
		currentStats.defence = maxStats.defence;
	}
	
	private void calculateHit() {
		maxStats.hit = weapon.hit + maxStats.AGI * 2 + maxStats.DEX;
		currentStats.hit = maxStats.hit;
	}
	
	private void calculateCritical() {
		maxStats.critical = maxStats.DEX + maxStats.AGI / 2;
		currentStats.critical = maxStats.critical;
	}
	

	public int getCombatX() {
		return combatX;
	}

	public void setCombatX(int combatX) {
		this.combatX = combatX;
	}

	public int getCombatY() {
		return combatY;
	}

	public void setCombatY(int combatY) {
		this.combatY = combatY;
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean isDead) {
		this.dead = isDead;
	}
	
	

}
