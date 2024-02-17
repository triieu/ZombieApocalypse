/*
Name: Trieu Huynh
Player
*/

public class Player {
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
		image = "assets/player.png";
		width = 64;
		height = 64;
		x = 0;
		y = 0;
	}

	public static void move() {
		if (StdDraw.hasNextKeyTyped() ) {
			char move = StdDraw.nextKeyTyped();
			if (move == 'w') {
				y -= 64;
				if (y < 0 ){
					y = 0;
				}

			}
			else if (move == 'd') {
				x += 64;
				if (x >= Scene.getWidth() ){
					x = Scene.getWidth() - 64;
				}
			}
			else if (move == 'a') {
				x -= 64;
				if (x < 0){
					x = 0;
				}
			}
			else if (move == 's') {
				y += 64;
				if (y >= Scene.getHeight() ) {
					y = Scene.getHeight() - 64;
				}
			}
		}
	}
	

	public static void update() {
		Player.move();
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
}