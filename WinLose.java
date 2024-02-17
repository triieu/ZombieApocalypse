/*
Author: Trieu Huynh
Win/Lose Screen
*/

public class WinLose {
	public static void draw() {
		StdDraw.setPenColor(StdDraw.PINK);
		if (Game.getGameOver() == true && Exit.isTouching() == true){
			StdDraw.text(Scene.getWidth()/2, Scene.getHeight()/2, "You survived and made it to the exit!");
		}
		else if (Enemy.isTouching() == true || Enemy2.isTouching() == true ){
			StdDraw.text(Scene.getWidth()/2, Scene.getHeight()/2, "You died to the enemy.");
		}
	}
}