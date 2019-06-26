package utilities;

public abstract class FPS {
	
	private static long lastTime = System.nanoTime();
	private static long timer = System.currentTimeMillis();
	private static final double ns = 1000000000.0 / 60.0;
	private static double delta = 0;
	public static int frames = 0;
	public static int updates = 0;

	public static boolean updateRequired() {
		
		long now = System.nanoTime();
		delta += (now - lastTime) / ns;
		lastTime = now;
		if (delta >= 1) {
			updates++;
			delta = 0;
			frames++;
			return true;
		}
		return false;
		
	}
	
	public static boolean printFPS() {
		
		if (System.currentTimeMillis() - timer > 1000) {
			timer += 1000;
			return true;
		}
		return false;
	}
	
}
