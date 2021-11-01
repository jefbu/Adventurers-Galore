package com.redhaan.adventurersGalore.entity.adventurer;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.SpellAnimation;
import com.redhaan.adventurersGalore.combat.Attack;
import com.redhaan.adventurersGalore.combat.Combat;
import com.redhaan.adventurersGalore.combat.MoveAreaDrawer;
import com.redhaan.adventurersGalore.combat.MoveRangeFiller;
import com.redhaan.adventurersGalore.combat.PlayerCombatSituation;
import com.redhaan.adventurersGalore.entity.Monster;
import com.redhaan.adventurersGalore.entity.adventurer.personality.Personality;
import com.redhaan.adventurersGalore.entity.adventurer.skills.Skills;
import com.redhaan.adventurersGalore.entity.adventurer.spells.Spell;
import com.redhaan.adventurersGalore.entity.adventurer.spells.SpellType;
import com.redhaan.adventurersGalore.entity.combatAddOns.CombatMovesBar;
import com.redhaan.adventurersGalore.entity.combatAddOns.HealthBar;
import com.redhaan.adventurersGalore.entity.combatAddOns.SpellOptions;
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
	private boolean justMoved;
	ArrayList<Monster> targetsInRange;
	// public PlayerTurnLeftClickSituation leftClickSituation;
	public int battlesPassed;

	public int tier;

	public int spellSlots;
	public ArrayList<Sigil> spells;
	public Tattoo tattoo;
	public Skills skills;
	public Portrait portrait;

	public Personality personality;
	public Titbit titbit;

	public ArrayList<CombatMove> combatMoves;
	private int combatAnimationTypeNumber;
	
	private SpellOptions spellOptions;
	
	Monster opponent;
	Monster selectedAlly;
	
	public boolean known;
	
	int spellTargetInt;


	public Adventurer() {

		super();

		race = Race.human;
		inParty = false;
		combatSituation = PlayerCombatSituation.notSelected_turnAvailable;
		selected = false;
		hasMoved = false;
		hasActed = false;
		justMoved = false;
		// leftClickSituation = PlayerTurnLeftClickSituation.NothingToDo;
		battlesPassed = 0;
		spells = new ArrayList<Sigil>();
		personality = new Personality();
		titbit = new Titbit();
		skills = new Skills();
		portrait = new Portrait();
		targetsInRange = new ArrayList<Monster>();
		combatMoves = new ArrayList<CombatMove>();
		combatMovesBar = new CombatMovesBar(this);
		spellOptions = new SpellOptions(this);
		combatAnimationTypeNumber = 1;
		spellTargetInt = 0;
		
		known = true;

	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		switch (GameManager.gameState) {

		case Combat:

			switch (Combat.combatState) {
			
			case EnemyTurn: break;				
			case PlayerTurn:

				if (actingAnimation) {
					attackTimer += (deltaTime * attackAnimationSpeed);
					if (attackTimer > 4) {
						if (combatMoves.get(combatMovesBar.selectedNumber - 1).name == "Magic") {
							switch(spellTargetInt) {
							case 0: SpellAnimation.activate(spells.get(spellOptions.selectedSpell).spell, spells.get(spellOptions.selectedSpell).spellModifier, this, currentStats.MAG); break;
							case 1: SpellAnimation.activate(spells.get(spellOptions.selectedSpell).spell, spells.get(spellOptions.selectedSpell).spellModifier, selectedAlly, currentStats.MAG); break;
							case 2: SpellAnimation.activate(spells.get(spellOptions.selectedSpell).spell, spells.get(spellOptions.selectedSpell).spellModifier, opponent, currentStats.MAG); break;
							}
						}
						attackTimer = 0;
						actingAnimation = false;
						selected = false;
						hasMoved = true;
						hasActed = true;
						turnPassed = true;
						combatAnimationTypeNumber = 1;
						combatMovesBar.selectedNumber = 1;
						idleTimer = 0;
					}
				}

				else {
					
					if (!turnPassed) {
						
						if (selected) {
							
							justMoved = false;
							
							if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON3)) {
								hasMoved = true;
								hasActed = true;
								turnPassed = true;
							}
							
							if (!hasMoved) {
								
								idleTimer += (deltaTime * idleAnimationSpeed);
								if (idleTimer > 4) {
									idleTimer = 0;
								}
								
								moveRange = MoveRangeFiller.fillMoveRange(combatX, combatY, currentStats.move);
								
								if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {

										for (int i = 0; i < moveRange.size(); i++) {
											if (moveRange.get(i)[0] == gameContainer.getInput().getMouseX() / GameManager.GAMETILESIZE && 
													moveRange.get(i)[1] == gameContainer.getInput().getMouseY() / GameManager.GAMETILESIZE) {
												combatX = gameContainer.getInput().getMouseX() / GameManager.GAMETILESIZE;
												combatY = gameContainer.getInput().getMouseY() / GameManager.GAMETILESIZE;
												hasMoved = true;
												justMoved = true;
											}
										}

									}
								
							}
							
							if (!hasActed && !justMoved) {
								
								idleTimer += (deltaTime * idleAnimationSpeed);
								if (idleTimer > 4) {
									idleTimer = 0;
								}
								
								combatMovesBar.update(gameContainer, deltaTime);
								
								targetsInRange.clear();
								
								// 'FIGHT' or 'AIM' or 'BACKSTAB' COMBATMOVE ACTIVATED					
								if (combatMoves.get(combatMovesBar.selectedNumber - 1).name == "Fight" 
										|| combatMoves.get(combatMovesBar.selectedNumber - 1).name == "Aim!"
										|| combatMoves.get(combatMovesBar.selectedNumber - 1).name == "Back Stab") { 
								
									if (combatMoves.get(combatMovesBar.selectedNumber - 1).name == "Aim!") { Attack.aimedAttack = true; }
									else if (combatMoves.get(combatMovesBar.selectedNumber - 1).name == "Back Stab") { Attack.backstab = true; }
								
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
												turnPassed = true;
												combatMovesBar.selectedNumber = 1;
											}
										} else {
											selected = false;
										}
									}
								}
								
								
								// 'MAGIC' COMBATMOVE ACTIVATED
								else if (combatMoves.get(combatMovesBar.selectedNumber - 1).name == "Magic") {
									spellOptions.update(gameContainer, deltaTime);
									
									if (spellOptions.spellSelected) {
									switch (spells.get(spellOptions.selectedSpell).spell.name) {
									
									case "Oasis of a Tranquil Heart": 
										targetsInRange = checkEligibleAdventurers(getCombatX(), getCombatY(), currentStats.MAG / 3); 
										spellTargetInt = 1;
										break;
									case "City full of Life": 
										targetsInRange = new ArrayList<Monster>();
										targetsInRange.add(this);
										spellTargetInt = 0;
										break;
									case "Fields of Summer Rye": 
										targetsInRange = checkEligibleAdventurers(getCombatX(), getCombatY(), currentStats.MAG / 3); 
										spellTargetInt = 1;
										break;
									case "Grove of Age-old Broadleaves": 
										targetsInRange = checkEligibleAdventurers(getCombatX(), getCombatY(), currentStats.MAG / 3); 
										spellTargetInt = 1;
										break;
									case "Bountiful Vineyard": 
										break;
									case "Impregnable Castle": 
										targetsInRange = checkEligibleAdventurers(getCombatX(), getCombatY(), currentStats.MAG / 3); 
										spellTargetInt = 1;
										break;
									case "Skies of Longing Vagabonds": 
										break;
									case "Heath of Scorched Memories": 
										targetsInRange = checkEligibleAdventurers(getCombatX(), getCombatY(), currentStats.MAG / 3); 
										spellTargetInt = 1;
										break;
									case "River of Killing Currents": 
										targetsInRange = checkEligibleAdventurers(getCombatX(), getCombatY(), currentStats.MAG / 3); 
										spellTargetInt = 1;
										break;
									case "Meadow of Rest for the Wicked": 
										targetsInRange = checkEnemiesInWeaponRange(getCombatX(), getCombatY(), 1, currentStats.MAG / 3); 
										spellTargetInt = 2;
										break;
									case "Volcano of Swallowing Ash": 
										targetsInRange = checkEnemiesInWeaponRange(getCombatX(), getCombatY(), 1, currentStats.MAG / 3); 
										spellTargetInt = 2;
										break;
									case "Mountain of an Early Grave":
										targetsInRange = checkEnemiesInWeaponRange(getCombatX(), getCombatY(), 1, currentStats.MAG); 
										spellTargetInt = 2;
										break;
									case "Ravine to the Gates of Hell": 
										targetsInRange = checkEnemiesInWeaponRange(getCombatX(), getCombatY(), 1, 1); 
										spellTargetInt = 2;
										break;
									case "Ocean of Overwhelming Despair": 
										targetsInRange = checkEnemiesInWeaponRange(getCombatX(), getCombatY(), 1, currentStats.MAG / 3); 
										spellTargetInt = 2;
										break;
									case "Corrosive Morass": 
										targetsInRange = checkEnemiesInWeaponRange(getCombatX(), getCombatY(), 1, currentStats.MAG / 3); 
										spellTargetInt = 2;
										break;
									case "Taiga where Life cannot Grow": 
										targetsInRange = checkEnemiesInWeaponRange(getCombatX(), getCombatY(), 1, currentStats.MAG / 3); 
										spellTargetInt = 2;
										break;
									case "Impatient Graveyard": 
										targetsInRange = new ArrayList<Monster>();
										targetsInRange.add(this);
										spellTargetInt = 0;
										break;
									case "Library of Maddening Wisdom": 
										break;
									
									}
									
									switch (spellTargetInt) {
									
									case 0: 										
										if(gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
											if (gameContainer.getInput().getMouseX() / GameManager.GAMETILESIZE == getCombatX() && 
													gameContainer.getInput().getMouseY() / GameManager.GAMETILESIZE == getCombatY()) {
												
												switch (spells.get(spellOptions.selectedSpell).spell.name) {
												
												case "City full of Life": combatAnimationTypeNumber = 5; break;
												case "Impatient Graveyard": combatAnimationTypeNumber = 18; break;
												default: System.out.println("wrong spell type at self target (Adventurer class)"); break;
												
												}
												
												actingAnimation = true;
												selected = false;
												hasActed = true;
												hasMoved = true;
												turnPassed = true;
											}							
										}
										break;
									case 1:
										if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
											
											for (Monster adventurer: targetsInRange) {
												if (gameContainer.getInput().getMouseX() / GameManager.GAMETILESIZE  == adventurer.getCombatX() &&
														gameContainer.getInput().getMouseY() / GameManager.GAMETILESIZE == adventurer.getCombatY()) {
													
												switch (spells.get(spellOptions.selectedSpell).spell.name) {
												
												case "Oasis of a Tranquil Heart": combatAnimationTypeNumber = 4; break;
												case "Fields of Summer Rye": combatAnimationTypeNumber = 6; break;
												case "Grove of Age-old Broadleaves": combatAnimationTypeNumber = 7; break;
												case "Impregnable Castle": combatAnimationTypeNumber = 8; break;
												case "Heath of Scorched Memories": combatAnimationTypeNumber = 9; break;
												case "River of Killing Currents": combatAnimationTypeNumber = 10; break;
												default: System.out.println("wrong spell type at ally target (Adventurer class)"); break;
												
												}
													actingAnimation = true;
													selectedAlly = adventurer;
													hasActed = true;
													hasMoved = true;
													turnPassed = true;
												}
											}
											
										}
										break;
									case 2:
										if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
											
											if (targetsInRange.size() > 0) {
												opponent = checkSelectedEnemy(targetsInRange,
														gameContainer.getInput().getMouseX() / GameManager.GAMETILESIZE,
														gameContainer.getInput().getMouseY() / GameManager.GAMETILESIZE);

												if (opponent != null) {
													
													switch (spells.get(spellOptions.selectedSpell).spell.name) {
													
													case "Meadow of Rest for the Wicked": combatAnimationTypeNumber = 11; break;
													case "Volcano of Swallowing Ash": combatAnimationTypeNumber = 12; break;
													case "Mountain of an Early Grave": combatAnimationTypeNumber = 13; break;
													case "Ravine to the Gates of Hell": combatAnimationTypeNumber = 14; break;
													case "Ocean of Overwhelming Despair": combatAnimationTypeNumber = 15; break;
													case "Corrosive Morass": combatAnimationTypeNumber = 16; break;
													case "Taiga where Life cannot Grow": combatAnimationTypeNumber = 17; break;
												
													default: System.out.println("wrong spell type at ally target (Adventurer class)"); break;
													
													}
													
													actingAnimation = true;
												} /*else {
													selected = false;
													hasActed = true;
													turnPassed = true;
													combatMovesBar.selectedNumber = 1; 
												} */
											} else {
												selected = false;
											}
										}
										break;
									
									}

								}
									
									
								}
								
								
								

								// 'MEDITATE' COMBATMOVE ACTIVATED
							else if (combatMoves.get(combatMovesBar.selectedNumber - 1).name == "Meditate") {
								
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
									}							
								}
							}
								
								
								// 'SHIELDS UP!' COMBATMOVE ACTIVATED
							else if (combatMoves.get(combatMovesBar.selectedNumber - 1).name == "Shields Up!") {
									
								targetsInRange = checkEligibleAdventurers(getCombatX(), getCombatY(), currentStats.MAG / 3);
								
								if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
									
									for (Monster adventurer: targetsInRange) {
										if (gameContainer.getInput().getMouseX() / GameManager.GAMETILESIZE  == adventurer.getCombatX() &&
												gameContainer.getInput().getMouseY() / GameManager.GAMETILESIZE == adventurer.getCombatY()) {
											combatAnimationTypeNumber = 2;
											actingAnimation = true;
											selectedAlly = adventurer;
											adventurer.currentStats.defence += 5;
											hasActed = true;
											hasMoved = true;
											turnPassed = true;
										}
									}
									
								}

							}
								
								
								
							}
							
						}
						
						else if (!selected) {
							
							idleTimer += (deltaTime * idleAnimationSpeed);
							if (idleTimer > 4) {
								idleTimer = 0;
							}

							if (gameContainer.getInput().isButtonUp(MouseEvent.BUTTON1)) {
								if (gameContainer.getInput().getMouseX() / GameManager.GAMETILESIZE == getCombatX()
										&& gameContainer.getInput().getMouseY() / GameManager.GAMETILESIZE == getCombatY()) {
									boolean okay = true;
									for (Adventurer adventurer: GameManager.adventurers.allAdventurers) {
										if (adventurer.inParty) {
											if (adventurer.selected) { okay = false; }
										}
									}
									if (okay) { selected = true; }
								}
							}
							
						}
						
					}					
					
				}
				
				break;
			}
			
				
			case InTown: break;
			case Titlescreen: break;
			case WorldMap: break;
			case PartyScreen: break;
			case QuestUI: break;
			case Transition: break;
			case QuestScreen: break;
			case PartyCohesionCheckerUI: break;
			case Inventory: break;
										

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
					
					if (turnPassed) {
						renderer.drawImageTile(icon, combatX * GameManager.GAMETILESIZE, combatY * GameManager.GAMETILESIZE, genderInt, 0);
					}
					
					else if (!turnPassed) {
						
						renderer.drawImageTile(icon, combatX * GameManager.GAMETILESIZE, combatY * GameManager.GAMETILESIZE, (int) idleTimer + genderInt, 0);
						
						if (selected) {
							
							if (!hasMoved) { MoveAreaDrawer.drawMoveArea(moveRange, renderer); }
							if (!hasActed) { 
								combatMovesBar.render(gameContainer, renderer);
								
								if (combatMoves.get(combatMovesBar.selectedNumber - 1).name == "Magic") { spellOptions.render(gameContainer, renderer); }
								
								for (Monster monster: targetsInRange) {
									renderer.drawRectOpaque(
										monster.getCombatX() * GameManager.GAMETILESIZE, monster.getCombatY() * GameManager.GAMETILESIZE, GameManager.GAMETILESIZE, GameManager.GAMETILESIZE, 0x44ffaa77);
								}	
							}
							
						}

						
					}
					
				} else {
					
					switch(combatAnimationTypeNumber) {
					
					//fight
					case 1:
						renderer.drawImageTile(icon, combatX * GameManager.GAMETILESIZE, combatY * GameManager.GAMETILESIZE, (int) attackTimer + genderInt, 1);						
						break;
					//shield
					case 2:
						renderer.drawImageTile(icon, combatX * GameManager.GAMETILESIZE, combatY * GameManager.GAMETILESIZE, (int) attackTimer + genderInt, 1);	
						renderer.drawImageTile(CombatMove.icon, selectedAlly.getCombatX() * GameManager.GAMETILESIZE, selectedAlly.getCombatY() * GameManager.GAMETILESIZE, (int) attackTimer + 5, 2);
						break;
					//meditate
					case 3:
						renderer.drawImageTile(icon, combatX * GameManager.GAMETILESIZE, combatY * GameManager.GAMETILESIZE, 0 + genderInt, 1);	
						renderer.drawImageTile(CombatMove.icon, getCombatX() * GameManager.GAMETILESIZE, getCombatY() * GameManager.GAMETILESIZE, (int) attackTimer + 5, 3);
						break;
					//spells
					//oasis
					case 4:
						renderer.drawImageTile(icon, combatX * GameManager.GAMETILESIZE, combatY * GameManager.GAMETILESIZE, 0 + genderInt, 1);	
						renderer.drawImageTile(CombatMove.icon, selectedAlly.getCombatX() * GameManager.GAMETILESIZE, selectedAlly.getCombatY() * GameManager.GAMETILESIZE, (int) attackTimer + 9, 0);
						break;
					//city
					case 5:
						renderer.drawImageTile(icon, combatX * GameManager.GAMETILESIZE, combatY * GameManager.GAMETILESIZE, 0 + genderInt, 1);	
						renderer.drawImageTile(CombatMove.icon, getCombatX() * GameManager.GAMETILESIZE, getCombatY() * GameManager.GAMETILESIZE, (int) attackTimer + 9, 1);
						break;
					//fields
					case 6:
						renderer.drawImageTile(icon, combatX * GameManager.GAMETILESIZE, combatY * GameManager.GAMETILESIZE, 0 + genderInt, 1);	
						renderer.drawImageTile(CombatMove.icon, selectedAlly.getCombatX() * GameManager.GAMETILESIZE, selectedAlly.getCombatY() * GameManager.GAMETILESIZE, (int) attackTimer + 9, 2);
						break;
					//grove
					case 7:
						renderer.drawImageTile(icon, combatX * GameManager.GAMETILESIZE, combatY * GameManager.GAMETILESIZE, 0 + genderInt, 1);	
						renderer.drawImageTile(CombatMove.icon, selectedAlly.getCombatX() * GameManager.GAMETILESIZE, selectedAlly.getCombatY() * GameManager.GAMETILESIZE, (int) attackTimer + 9, 3);
						break;
					//castle
					case 8:
						renderer.drawImageTile(icon, combatX * GameManager.GAMETILESIZE, combatY * GameManager.GAMETILESIZE, 0 + genderInt, 1);	
						renderer.drawImageTile(CombatMove.icon, selectedAlly.getCombatX() * GameManager.GAMETILESIZE, selectedAlly.getCombatY() * GameManager.GAMETILESIZE, (int) attackTimer + 9, 4);
						break;
					//heath
					case 9:
						renderer.drawImageTile(icon, combatX * GameManager.GAMETILESIZE, combatY * GameManager.GAMETILESIZE, 0 + genderInt, 1);	
						renderer.drawImageTile(CombatMove.icon, selectedAlly.getCombatX() * GameManager.GAMETILESIZE, selectedAlly.getCombatY() * GameManager.GAMETILESIZE, (int) attackTimer + 9, 5);
						break;		
					//river
					case 10:
						renderer.drawImageTile(icon, combatX * GameManager.GAMETILESIZE, combatY * GameManager.GAMETILESIZE, 0 + genderInt, 1);	
						renderer.drawImageTile(CombatMove.icon, selectedAlly.getCombatX() * GameManager.GAMETILESIZE, selectedAlly.getCombatY() * GameManager.GAMETILESIZE, (int) attackTimer + 9, 6);
						break;	
					//meadow
					case 11:
						renderer.drawImageTile(icon, combatX * GameManager.GAMETILESIZE, combatY * GameManager.GAMETILESIZE, 0 + genderInt, 1);	
						renderer.drawImageTile(CombatMove.icon, opponent.getCombatX() * GameManager.GAMETILESIZE, opponent.getCombatY() * GameManager.GAMETILESIZE, (int) attackTimer + 9, 7);
						break;	
					//volcano	
					case 12:
						renderer.drawImageTile(icon, combatX * GameManager.GAMETILESIZE, combatY * GameManager.GAMETILESIZE, 0 + genderInt, 1);	
						renderer.drawImageTile(CombatMove.icon, opponent.getCombatX() * GameManager.GAMETILESIZE, opponent.getCombatY() * GameManager.GAMETILESIZE, (int) attackTimer + 9, 8);
						break;	
					//mountain
					case 13:
						renderer.drawImageTile(icon, combatX * GameManager.GAMETILESIZE, combatY * GameManager.GAMETILESIZE, 0 + genderInt, 1);	
						renderer.drawImageTile(CombatMove.icon, opponent.getCombatX() * GameManager.GAMETILESIZE, opponent.getCombatY() * GameManager.GAMETILESIZE, (int) attackTimer + 9, 9);
						break;
					//ravine
					case 14:
						renderer.drawImageTile(icon, combatX * GameManager.GAMETILESIZE, combatY * GameManager.GAMETILESIZE, 0 + genderInt, 1);	
						renderer.drawImageTile(CombatMove.icon, opponent.getCombatX() * GameManager.GAMETILESIZE, opponent.getCombatY() * GameManager.GAMETILESIZE, (int) attackTimer + 9, 10);
						break;	
					//ocean
					case 15:
						renderer.drawImageTile(icon, combatX * GameManager.GAMETILESIZE, combatY * GameManager.GAMETILESIZE, 0 + genderInt, 1);	
						renderer.drawImageTile(CombatMove.icon, opponent.getCombatX() * GameManager.GAMETILESIZE, opponent.getCombatY() * GameManager.GAMETILESIZE, (int) attackTimer + 9, 11);
						break;	
					//morass
					case 16:
						renderer.drawImageTile(icon, combatX * GameManager.GAMETILESIZE, combatY * GameManager.GAMETILESIZE, 0 + genderInt, 1);	
						renderer.drawImageTile(CombatMove.icon, opponent.getCombatX() * GameManager.GAMETILESIZE, opponent.getCombatY() * GameManager.GAMETILESIZE, (int) attackTimer + 9, 12);
						break;	
					//taiga
					case 17:
						renderer.drawImageTile(icon, combatX * GameManager.GAMETILESIZE, combatY * GameManager.GAMETILESIZE, 0 + genderInt, 1);	
						renderer.drawImageTile(CombatMove.icon, opponent.getCombatX() * GameManager.GAMETILESIZE, opponent.getCombatY() * GameManager.GAMETILESIZE, (int) attackTimer + 9, 13);
						break;	
					//graveyard
					case 18:
						renderer.drawImageTile(icon, combatX * GameManager.GAMETILESIZE, combatY * GameManager.GAMETILESIZE, 0 + genderInt, 1);	
						renderer.drawImageTile(CombatMove.icon, getCombatX() * GameManager.GAMETILESIZE, getCombatY() * GameManager.GAMETILESIZE, (int) attackTimer + 9, 14);
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
