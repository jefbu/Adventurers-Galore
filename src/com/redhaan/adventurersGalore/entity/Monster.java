package com.redhaan.adventurersGalore.entity;

import java.util.ArrayList;
import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.combat.Combat;
import com.redhaan.adventurersGalore.combat.MoveAreaDrawer;
import com.redhaan.adventurersGalore.combat.MoveRangeFiller;
import com.redhaan.adventurersGalore.combat.combatAI.ActionDecision;
import com.redhaan.adventurersGalore.combat.combatAI.CombatActions;
import com.redhaan.adventurersGalore.combat.combatAI.MoveDecision;
import com.redhaan.adventurersGalore.entity.adventurer.Job;
import com.redhaan.adventurersGalore.entity.adventurer.Stats;
import com.redhaan.adventurersGalore.entity.combatAddOns.HealthBar;
import com.redhaan.adventurersGalore.entity.combatAddOns.SkillBar;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class Monster extends NPC {
	
	public Stats maxStats;
	public Stats currentStats;
	
	public Job job;
	
	protected int combatX, combatY;
	protected boolean dead;
	protected int idleAnimationSpeed;
	protected int attackAnimationSpeed;
	protected float idleTimer;
	protected float attackTimer;
	protected boolean attackAnimation;
	public ArrayList<int[]> moveRange;
	
	private boolean flareUpAnimation;
	private int ticksToFlareUp;
		
	public boolean turnPassed;
	
	private Random random;
	
	public SkillBar skillBar;
	
	public Monster() {
		
		super();
		
		maxStats = new Stats();
		currentStats = new Stats();
		
		job = Job.squire;
		icon = job.icon;
		
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
		
		ticksToFlareUp = 0;
		flareUpAnimation = false;
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
				
			if(moveRange.size() == 0) { moveRange = MoveRangeFiller.fillMoveRange(combatX, combatY, currentStats.move); }

			ticksToFlareUp++;
			if (ticksToFlareUp < 10) { flareUpAnimation = true; } 
			else if (ticksToFlareUp < 20) { flareUpAnimation = false; }
			else if (ticksToFlareUp < 70) { flareUpAnimation = true; }
			else { 
				ticksToFlareUp = 0;
				flareUpAnimation = false;
			}
			
			if(!flareUpAnimation && ticksToFlareUp == 0) {
				CombatActions action = ActionDecision.decideActionDecision(Combat.combatStrategy);
				int[] moveDecision = MoveDecision.decideMoveDecision(action, moveRange);
				combatX = moveDecision[0];
				combatY = moveDecision[1];
				//AttackDecision.decideAttackDecision();
				moveRange.clear();
				turnPassed = true;
				}
					
			break;
			}
			
		break;	
		case WorldMap: break;
		case Titlescreen: break;
		case InTown: break;
		
		}
		
	}
	

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		switch(GameManager.gameState) {
		
		case Combat:
			renderer.drawImageTile(icon, combatX * GameManager.GAMETILESIZE, combatY * GameManager.GAMETILESIZE, (int) idleTimer, 1);
			HealthBar.drawHealthBar(this, renderer);
			
			if(flareUpAnimation) {
				MoveAreaDrawer.drawMoveArea(moveRange, renderer);
			}
			
			break;
		case InTown: break;
		case Titlescreen: break;
		case WorldMap: break;
	
		}
		
		
	}
	
	public void calculateSecondaryStats() {
		calculateMove();
		calculateTravelSpeed();
		calculateAttack();
		calculateDefence();
		calculateHit();
		calculateCritical();
	}
	
	
	public void calculateMove() {
		maxStats.move = job.jobBonusStats.move;
		currentStats.move = maxStats.move;
	}
	
	public void calculateTravelSpeed() {
		int bonus = 0;
		if ((maxStats.PHY + maxStats.PRC / 4) < 80) { }
		else if (maxStats.PHY + maxStats.PRC / 4 < 100) { bonus = 1; }
		else if (maxStats.PHY + maxStats.PRC / 4 < 110) { bonus = 2; }
		else if (maxStats.PHY + maxStats.PRC / 4 < 120) {	bonus = 3; }
		else { bonus = 4; }
		maxStats.travelSpeed = maxStats.move + bonus;
		currentStats.travelSpeed = maxStats.travelSpeed;
	}
		
	public void calculateAttack() {
		maxStats.attack = maxStats.PHY * 3;
		currentStats.attack = maxStats.attack;
	}
	
	public void calculateDefence() {
		maxStats.defence = maxStats.PHY * 2;
		currentStats.defence = maxStats.defence;
	}
	
	public void calculateHit() {
		maxStats.hit = maxStats.AGI;
	}
	
	public void calculateCritical() {
		maxStats.critical = maxStats.DEX / 5;
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
