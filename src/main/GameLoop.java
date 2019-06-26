package main;

import javax.swing.JFrame;

import utilities.FPS;

public class GameLoop implements Runnable {
	
	public boolean running;
	private Thread thread;
	public Game game;
	
	public GameLoop() {	
		game = new Game();
		game.screen.add(game);
		game.screen.setResizable(false);
		game.screen.pack();
		game.screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.screen.setVisible(true);
	}
	
	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}
			
	public synchronized void stop() {
		running = false;
		try {
			thread.join();			
		} catch (InterruptedException e) {
			e.printStackTrace();			
		}
	}

	public void run() {

		while (running) {

			if(FPS.updateRequired()) {
				game.update();
				game.render();
			}
			
			if(FPS.printFPS()) {
				game.screen.setTitle("Adventurer's Galore" + " | " + FPS.updates + "ups, " + FPS.frames + "fps");
				FPS.updates = 0;
				FPS.frames = 0;
			}						
		}	
	}

}
