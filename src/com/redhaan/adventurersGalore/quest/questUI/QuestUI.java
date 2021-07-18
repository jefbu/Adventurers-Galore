package com.redhaan.adventurersGalore.quest.questUI;

import java.util.ArrayList;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.GameState;
import com.redhaan.adventurersGalore.Transition;
import com.redhaan.adventurersGalore.combat.Combat;
import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;
import com.redhaan.adventurersGalore.entity.enemies.Enemy;
import com.redhaan.adventurersGalore.entity.party.PartyCohesionChecker;
import com.redhaan.adventurersGalore.quest.Quest;
import com.redhaan.adventurersGalore.quest.QuestStep;
import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class QuestUI extends GameObject {

	private static final long serialVersionUID = 1L;
	public static GameState nextGameState;
	public static QuestStep nextQuestStep;
	private Requester requester;
	private QuestParty party;
	private TextBlock text;
	private Portrait portrait;
	public static Quest quest;
	public static boolean questAccepted;
	public static boolean questRefused;
	
	public static ArrayList<Enemy> enemies;
	public static boolean itsaFight;
	
	private PartyCohesionChecker partyCohesionChecker;

	public QuestUI() {

		requester = new Requester();
		party = new QuestParty();
		text = new TextBlock();
		portrait = new Portrait();
		quest = new Quest();
		nextGameState = GameState.InTown;
		questAccepted = false;
		questRefused = false;
		enemies = new ArrayList<Enemy>();
		itsaFight = false;
		partyCohesionChecker = new PartyCohesionChecker();

	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		switch (GameManager.gameState) {

		case QuestUI:

			text.update(gameContainer, deltaTime);
			portrait.update(gameContainer, deltaTime);
			
			if (questAccepted) {
				partyCohesionChecker.checkNewQuestPartyCohesion(gameContainer, nextGameState);
				quest.playerQuest = true;
				questAccepted = false;
				for(Adventurer adventurer: QuestUI.quest.questParty) {
					adventurer.inParty = true;
				}
				if(itsaFight) {
					for (Enemy enemy: enemies) {
						Combat.enemies.add(enemy);
					}
					Transition.nextGameState = GameState.Combat;
					GameManager.gameState = GameState.Transition;	
				} else {
					Transition.nextGameState = QuestUI.nextGameState;
					GameManager.gameState = GameState.Transition;
				}
			}

			else if (questRefused) {
				questRefused = false;
				Transition.nextGameState = QuestUI.nextGameState;
				GameManager.gameState = GameState.Transition;
			}
			break;

		case Combat: break;
		case InTown: break;
		case PartyScreen: break;
		case Titlescreen: break;
		case WorldMap: break;
		case Inventory: break;
		case PartyCohesionCheckerUI: break;
		case QuestScreen: break;
		case Transition: break;


		}
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
		switch (GameManager.gameState) {

		case QuestUI:

			renderer.drawRectOpaque(50, 40, 540, 400, 0xff202020);
			renderer.drawRectOpaque(55, 45, 120, 150, 0xff242824);
			renderer.drawRectOpaque(55, 200, 120, 100, 0xff242428);
			renderer.drawRectOpaque(180, 45, 280, 255, 0xff282424);
			renderer.drawRectOpaque(465, 45, 120, 220, 0xff282820);
			renderer.drawRectOpaque(465, 270, 120, 30, 0xff282028);
			renderer.drawRectOpaque(55, 305, 530, 130, 0xff202828);

			requester.render(gameContainer, renderer);
			party.render(gameContainer, renderer);
			text.render(gameContainer, renderer);
			portrait.render(gameContainer, renderer);


			break;

		case Combat: break;
		case InTown: break;
		case PartyScreen: break;
		case Titlescreen: break;
		case WorldMap: break;
		case Inventory: break;
		case PartyCohesionCheckerUI: break;
		case QuestScreen: break;
		case Transition: break;


		}

	}

}
