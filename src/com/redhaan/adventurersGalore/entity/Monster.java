package com.redhaan.adventurersGalore.entity;

import java.util.ArrayList;
import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.entity.adventurer.Affinities;
import com.redhaan.adventurersGalore.entity.adventurer.Job;
import com.redhaan.adventurersGalore.entity.adventurer.Race;
import com.redhaan.adventurersGalore.entity.adventurer.Stats;
import com.redhaan.adventurersGalore.entity.combatAddOns.CombatMovesBar;
import com.redhaan.adventurersGalore.entity.item.armour.Armour;
import com.redhaan.adventurersGalore.entity.item.weapon.Weapon;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class Monster extends NPC {

	private static final long serialVersionUID = 1L;
	
	public Stats maxStats;
	public Stats currentStats;
	public Affinities affinities;
	public Stats levelupPercentages;
	
	public String name;
	public Job job;
	public Race race;
	
	protected int combatX, combatY;
	protected boolean dead;
	protected int idleAnimationSpeed;
	protected int attackAnimationSpeed;
	protected float idleTimer;
	protected float attackTimer;
	public boolean actingAnimation;
	public ArrayList<int[]> moveRange;
	
	public boolean moveRangeFlareUp;
	public int moveRangeCounter;
		
	public boolean turnPassed;
	
	private Random random;
	
	public CombatMovesBar combatMovesBar;
	
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
		
		currentStats.HP = 20;
		maxStats.HP = 20;
		
		dead = false;
		random = new Random();
		idleTimer = 0;
		attackTimer = 0;
		idleAnimationSpeed = random.nextInt(5) + 3;
		attackAnimationSpeed = random.nextInt(2) + 8;
		moveRange = new ArrayList<int[]>();
				
		moveRangeCounter = 0;
		moveRangeFlareUp = false;
		actingAnimation = false;
		turnPassed = false;
				
	}
	
	
	@Override
	public void update (GameContainer gameContainer, float deltaTime) {
		
	}
	

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		renderer.drawImageTile(icon, combatX * GameManager.GAMETILESIZE, combatY * GameManager.GAMETILESIZE, 0, 0);
		
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
	
	public void refreshStats() {
		
		currentStats.HP = maxStats.HP;
		currentStats.MP = maxStats.MP;
		currentStats.PHY = maxStats.PHY;
		currentStats.AGI = maxStats.AGI;
		currentStats.MAG = maxStats.MAG;
		currentStats.DEX = maxStats.DEX;
		currentStats.INT = maxStats.INT;
		currentStats.PRC = maxStats.PRC;
		currentStats.move = maxStats.move;
		
	}
	
	

}
