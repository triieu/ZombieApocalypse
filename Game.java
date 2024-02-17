/*
Author: Trieu Huynh
Zombie Apocalypse Game Re-rendering
*/

import java.util.Scanner;

public class Game {
	private static boolean gameOver = false;
	
	public static boolean getGameOver() {
		return gameOver;
	}

	public static void main(String[] args) {
		start();						//tart game
		while (gameOver == false) {		//while game not over
			update();					//update game
			render();					//render game
		}
	}

	public static void start() {
		Scene.start();	//setup scene data
		Enemy.start();	//setup enemy data
		Enemy2.start(); //setup enemy 2 data
		Player.start();	//setup player data
		Exit.start();	//setup exit data
	}

	public static void update() {
		//get player input
		Player.update();	//update player data
		Enemy.update();		//update enemy data
		Enemy2.update();	//update enemy 2 data
		Exit.update();		//update exit data
	}

	public static void render() {
		Scene.draw();		//draw scene
		Player.draw();		//draw player
		Enemy.draw();		//draw enemy
		Enemy2.draw();		//draw enemy 2
		Exit.draw();		//draw exit
		WinLose.draw();		//draw win or lose screen
		StdDraw.show(100);	//show graphics
	}

	public static void setGameOver(boolean gameOver) {
		Game.gameOver = gameOver;
	}
}