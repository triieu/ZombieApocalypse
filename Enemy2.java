/*
Name: Trieu Huynh
Enemy 2
*/

public class Enemy2 {
	//enemy data --> accesible by all enemy methods, scoped for as long as Game class runs
	private static String image;
	private static int width;
	private static int height;
	private static double x;
	private static double y;
	private static long time;

	//draw enemy
	public static void draw() {
		StdDraw.picture(x+width/2, y+height/2, image);
	}

	public static void start() {
		image = "assets/zombie.png";
		width = 64;
		height = 64;
		x = Scene.getWidth() - width;
		y = Scene.getHeight() - 4*(height/2);
		time = System.currentTimeMillis();
	}

	public static void move() {
		int enemyChoice = (int) (Math.random() * 4);

		if (enemyChoice == 0) {
			x = (x + width);
			if (x >= Scene.getWidth() ){
				x = 0;
			}
		}
		else if (enemyChoice == 1) {
			x = x - width;
			if (x < 0) {
				x = (Scene.getWidth() - 64);
			}
		}
		else if (enemyChoice == 2) {
			y = y - height;
			if (y < 0) {
				y = (Scene.getHeight() - 64);
			}
		}
		else if (enemyChoice == 3) {
			y = (y + height);
			if (y >= Scene.getHeight()) {
				y = 0;
			}
		}
		time = System.currentTimeMillis();
	}

	public static void update() {
		long now = System.currentTimeMillis();
		if (now - time > 1000) {
			Enemy2.move();
		}
		if (Enemy2.isTouching() ) {
			Game.setGameOver(true);
		}
	}

	public static double getLeft() {
		return x;
	}

	public static double getTop() {
		return y;
	}

	public static double getBottom() {
		return y + height;
	}

	public static double getRight() {
		return x + width;
	}

	public static boolean isTouchingX() {
		return Player.getLeft() == Enemy2.getLeft() && Enemy2.getRight() == Player.getRight();
	}

	public static boolean isTouchingY() {
		return Player.getTop() == Enemy2.getTop() && Enemy2.getBottom() == Player.getBottom();
	}

	public static boolean isTouching() {
		return isTouchingX() && isTouchingY();
	}
}