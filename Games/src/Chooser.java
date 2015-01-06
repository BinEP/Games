import java.awt.BorderLayout;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import snake.*;
import chooseYourOwnAdventure.*;
import flappyBird.*;
import goFish.*;
import hangman.*;
import holeInTheWall.*;
import pong.*;
import shapeJump.*;
import tunnelRunner.*;
import utilityClasses.*;
import war.*;

public class Chooser {

	public static void main(String[] args) {

		/* Courtesy of Dayton Andersen, 2015 */

		String[] choices = { "Snake", "Choose Your Own Adventure",
				"Flappy Bird", "Go Fish", "Hangman", "Hole In The Wall",
				"Pong", "Shape Jump", "Tunnel Runner", "War" };
		Object choice = JOptionPane.showInputDialog(null, "Choose a game",
				"Brady's Game Chooser", 1, null, choices, choices[0]);

		if (choice == choices[0]) {
			SnakeRunner snake = new SnakeRunner();
			snake.main(null);
		} else if (choice == choices[1]) {
			ChooseYourOwnAdventureRunner cyoar = new ChooseYourOwnAdventureRunner();
			try {
				cyoar.main(null);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (choice == choices[2]) {
			FlappyRunner flappy = new FlappyRunner();
			flappy.main(null);
		} else if (choice == choices[3]) {
			GoFishRunner goFish = new GoFishRunner();
			goFish.main(null);
		} else if (choice == choices[4]) {
			HangmanRunner hangman = new HangmanRunner();
			try {
				hangman.main(null);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (choice == choices[5]) {
			HoleRunner hitw = new HoleRunner();
			hitw.main(null);
		} else if (choice == choices[6]) {
			PongRunner pong = new PongRunner();
			pong.main(null);
		} else if (choice == choices[7]) {
			ShapeRunner shapejump = new ShapeRunner();
			shapejump.main(null);
		} else if (choice == choices[8]) {
			TunnelRunner tunnelrun = new TunnelRunner();
			tunnelrun.main(null);
		} else if (choice == choices[9]) {
			WarRunner war = new WarRunner();
			war.main(null);
		}

	}

}
