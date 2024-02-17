/*
Name: Trieu Huynh
Exit
*/

public class Exit {
	//enemy data --> accesible by all enemy methods, scoped for as long as Game class runs
	private static String image;
	private static int width;
	private static int height;
	private static double x;
	private static double y;

	//draw enemy
	public static void draw() {
		StdDraw.picture(x+width/2, y+height/2, image);
	}

	public static void start() {
		image = "assets/exit2.png";
		width = 64;
		height = 64;
		x = Scene.getWidth() - width;
		y = Scene.getHeight() - height;
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
		return Player.getLeft() == Exit.getLeft() && Exit.getRight() == Player.getRight();
	}

	public static boolean isTouchingY() {
		return Player.getTop() == Exit.getTop() && Exit.getBottom() == Player.getBottom();
	}

	public static boolean isTouching() {
		return isTouchingX() && isTouchingY();
	}

	public static void update() {
		if (Exit.isTouching()) {
			Game.setGameOver(true);
		}
	}
}