package hangman;

//New hangman Game!!!
//Added a comment!!!
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import javax.swing.JPanel;
import javax.swing.Timer;

import utilityClasses.*;

@SuppressWarnings("serial")
public class HangmanPanel extends JPanel implements KeyListener, ActionListener {

	public static ArrayList<Integer[]> drawHangman = new ArrayList<Integer[]>();
	private boolean startGame = true;
	private boolean playing = false;
	private boolean endGame = false;

	private boolean waitForLetter = true;
	private boolean guessError = false;
	private boolean nameEnter = false;
	private boolean highScores = false;

	Scanner console = new Scanner(System.in);
	private int wSW = 700;
	private int wSH = 700;

	String word;
	private ArrayList<Character> allChars;
	private ArrayList<Character> guesses;
	private ArrayList<Character> wrongs;
	private Character letter;
	private String pName = "";
	private int pIndex = 0;

	private int age = 0;
	private String ageS = "";
	private Character ageL;
	private boolean ageEnter = false;
	private boolean specialGame = false;

	private boolean win;
	private ScoreInfo scores = new ScoreInfo("hangman");

	private Color background = Color.BLACK;

	private Color topHang = Color.WHITE;
	private Color sideHang = Color.WHITE;
	private Color bottomHang = Color.WHITE;

	// private Color head = Color.RED;
	// private Color chest = Color.GREEN;
	// private Color arms = Color.RED;
	// private Color legs = Color.RED;
	// private Color shoulders = Color.GREEN;
	private Color head = Color.WHITE;
	private Color chest = Color.WHITE;
	private Color arms = Color.WHITE;
	private Color legs = Color.WHITE;
	private Color shoulders = Color.WHITE;
	private Color addedLimb = Color.WHITE;
	private Color[] body = { legs, legs, arms, shoulders, arms, shoulders,
			chest, head };

	private Color startTitle = Color.WHITE;
	private Color startEnter = Color.WHITE;

	private Color wordText = Color.WHITE;
	private Color guessText = Color.WHITE;
	private Color underlines = Color.WHITE;
	private Color guessInst = Color.WHITE;

	private Color enterNameInst = Color.WHITE;
	private Color nameUnder = Color.WHITE;
	private Color nameLetters = Color.WHITE;

	private Color endNotif = Color.WHITE;
	private Color endRestart = Color.WHITE;
	private Color endLetters = Color.WHITE;
	private Color endUnderlines = Color.WHITE;

	public HangmanPanel() throws FileNotFoundException {

		newWordSetup();

		setBackground(background);

		setFocusable(true);
		addKeyListener(this);

		Timer timer = new Timer((int) (1000 / 60), this);
		timer.start();

	}

	public void newWordSetup() throws FileNotFoundException {

		NewWord getWords = new NewWord(age);
		word = getWords.newWord();
		allChars = getWords.getCharList();
		guesses = new ArrayList<Character>();
		wrongs = new ArrayList<Character>();
		System.out.println(word);
	}

	public void Game() throws FileNotFoundException {

		if (playing) {

			if (!waitForLetter) {

				if (!guesses.contains(letter)) {
					waitForLetter = true;
					guesses.add(letter);

					wrongs = duplicateArr(guesses);
					wrongs.removeAll(allChars);

					if (guesses.containsAll(allChars) && wrongs.size() < 7) {
						playing = false;
						win = true;
						nameEnter = true;
						clearConsole();
					} else if (wrongs.size() > 6) {
						playing = false;
						win = false;
						nameEnter = true;
						clearConsole();
					}

				} else {

					guessError = true;
					waitForLetter = true;
				}

			}

		} else if (nameEnter) {

		}
		repaint();

	}

	@SuppressWarnings("unused")
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Joystix", Font.BOLD, 20));

		if (startGame) {
			g.setColor(startTitle);
			g.setFont(new Font("Joystix", Font.BOLD, 80));
			CenteredText title1 = new CenteredText("HANGMAN!!", wSW, wSH, g,
					true, 230);

			g.setFont(new Font("Joystix", Font.BOLD, 20));
			g.setColor(startEnter);
			CenteredText start1 = new CenteredText("Press Enter to", wSW, wSH,
					g, true, 350);
			CenteredText start2 = new CenteredText("Start", wSW, wSH, g, true,
					380);

		} else if (playing) {

			int baseX = 240, baseY = 100;
			g.setColor(topHang);
			g.fillRect(baseX - 115, baseY - 60, 260, 25);
			g.setColor(sideHang);
			g.fillRect(baseX - 115, baseY - 35, 25, 455);
			g.setColor(bottomHang);
			g.fillRect(baseX - 230, baseY + 420, 425, 25);
			printGuy(wrongs.size(), g);
			int i = 0;
			for (Integer[] n : drawHangman) {
				int x = n[0] + baseX, y = n[1] + baseY, h = n[2], w = n[3];
				g.setColor(body[n[5]]);
				switch (n[4]) {

				case 1: // square

					g.fillRect(x, y, w, h);
					break;
				case 2: // circle

					g.fillOval(x, y, w, h);
					break;
				}
				i++;
			}

			g.setFont(new Font("Joystix", Font.BOLD, 35));
			i = 0;
			for (Character c : allChars) {

				int x = (55 * i) + 40;
				g.setColor(wordText);
				CenteredText lx = new CenteredText(c.toString(), 45, 8, g);
				if (guesses.contains(c))
					g.drawString(c.toString(), x + lx.x, 613);
				g.setColor(underlines);
				g.fillRect(x, 615, 45, 8);
				i++;
			}

			g.setFont(new Font("Joystix", Font.BOLD, 35));
			i = 0;
			int yStart = 100;
			int xStart = 410;
			int lineH = 50;
			int l = 0;
			g.setColor(guessInst);
			for (Character c : guesses) {

				if (i > 4) {
					l++;
					i = 0;
				}
				int x = (55 * i) + xStart;

				CenteredText lx = new CenteredText(c.toString(), 45, 8, g);
				g.drawString(c.toString(), x + lx.x, (yStart - 2) + (l * lineH));

				i++;
			}
			g.setColor(guessInst);
			g.setFont(new Font("Joystix", Font.BOLD, 18));
			if (guessError) {

				CenteredText guess = new CenteredText("Already Guessed", 250,
						200, g);
				g.drawString("Already Guessed", guess.x + 450, 500);

				CenteredText guess1 = new CenteredText("Try again", 250, 200, g);
				g.drawString("Try Again", guess1.x + 450, 550);

			} else if (waitForLetter) {

				CenteredText guess = new CenteredText("Guess a Letter", 250,
						150, g);
				g.drawString("Guess a Letter", guess.x + 450, guess.y + 475);

			}

		} else if (endGame) {

			g.setFont(new Font("Joystix", Font.BOLD, 40));
			g.setColor(endNotif);

			g.setFont(new Font("Joystix", Font.BOLD, 60));
			if (win) {
				CenteredText win = new CenteredText("You Win!", wSW, wSH, g,
						true, 170);

			} else {
				CenteredText lose = new CenteredText("You Lose!", wSW, wSH, g,
						true, 170);
			}

			g.setFont(new Font("Joystix", Font.BOLD, 26));
			g.setColor(endRestart);
			CenteredText restart = new CenteredText("Enter to Restart", wSW,
					wSH, g, true, 320);

			g.setFont(new Font("Joystix", Font.BOLD, 35));
			int i = 0;
			int tw = allChars.size() * 55;
			int startText = (wSW - tw) / 2;
			g.setColor(endLetters);
			for (Character c : allChars) {

				int x = (55 * i) + startText;

				CenteredText lx = new CenteredText(c.toString(), 45, 8, g);
				g.drawString(c.toString(), x + lx.x, 470);

				g.fillRect(x, 472, 45, 8);
				i++;
			}

		} else if (nameEnter) {

			g.setColor(enterNameInst);
			g.setFont(new Font("Joystix", Font.BOLD, 80));
			CenteredText enter = new CenteredText("Enter", wSW, wSH, g, true,
					150);
			CenteredText enter1 = new CenteredText("Your Name", wSW, wSH, g,
					true, 250);

			int tw = 550;
			int startText = (wSW - tw) / 2;
			g.setFont(new Font("Joystix", Font.BOLD, 35));

			for (int i = 0; i < 10; i++) {
				g.setColor(nameLetters);
				if (pName.length() > i) {
					CenteredText lx = new CenteredText(Character.toString(pName
							.charAt(i)), 45, 8, g);
					g.drawString(Character.toString(pName.charAt(i)), (55 * i)
							+ startText + lx.x, 470);
				}
				g.setColor(nameUnder);
				g.fillRect((55 * i) + startText, 472, 45, 8);
			}
			// try {
			// getScores();
			// } catch (FileNotFoundException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
		} else if (highScores) {

			pName = "";
			
			scores.drawScoresHangman(g);
		} else if (ageEnter) {

			g.setFont(new Font("Joystix", Font.BOLD, 40));
			CenteredText enter = new CenteredText("Enter", wSW, wSH, g, true,
					100);
			CenteredText enter1 = new CenteredText("Your Age", wSW, wSH, g,
					true, 170);

			int barWidth = 35;
			int barSpace = 10 + barWidth;
			int letterNum = 3;
			int tw = letterNum * barSpace;
			int startText = (wSW - tw) / 2;
			g.setFont(new Font("Joystix", Font.BOLD, 20));
			for (int i = 0; i < letterNum; i++) {
				if (ageS.length() > i) {
					CenteredText lx = new CenteredText(Character.toString(ageS
							.charAt(i)), barWidth, 8, g);
					g.drawString(Character.toString(ageS.charAt(i)),
							(barSpace * i) + startText + lx.x, 440);
				}
				g.fillRect((barSpace * i) + startText, 442, barWidth, 8);
			}

		} else if (specialGame) {
			
			g.setFont(new Font("Joystix", Font.BOLD, 40));
			
			CenteredText s1 = new CenteredText("This is a special", wSW, wSH, g,
					true, 150);
			CenteredText s2 = new CenteredText("Game just for", wSW, wSH, g,
					true, 250);
			CenteredText s3 = new CenteredText("your age group", wSW, wSH, g,
					true, 350);
			
			g.setFont(new Font("Joystix", Font.BOLD, 50));
			CenteredText enter1 = new CenteredText("Enter to begin", wSW, wSH, g,
					true, 500);
			
			
			
		}

	}

	public static ArrayList<Character> duplicateArr(ArrayList<Character> guesses) {

		ArrayList<Character> wrongs = new ArrayList<Character>();
		for (Character c : guesses) {

			wrongs.add(c);
		}
		return wrongs;
	}

	public void printGuy(int incorrect, Graphics g) {
		drawHangman.clear();
		Integer[] values = new Integer[6];
		// [x, y, height, width, circle2/square1, rotate]

		switch (incorrect) {

		case 6:
			// String rightLeg =
			// "      \\\\\n" +
			// "       \\\\\n" +
			// "        \\\\\n" +
			// "         \\\\\n";
			values[0] = 55;
			values[1] = 245;
			values[2] = 150;
			values[3] = 25;
			values[4] = 1;
			values[5] = 0;
			drawHangman.add(values.clone());
		case 5:
			// String leftLeg =
			// "    //\n" +
			// "   //  \n" +
			// "  //    \n" +
			// " //      \n";
			values[0] = -10;
			values[1] = 245;
			values[2] = 150;
			values[3] = 25;
			values[4] = 1;
			values[5] = 1;
			drawHangman.add(values.clone());
		case 4:
			// String rightArm =
			// "       \\\\\n" +
			// "        \\\\\n" +
			// "         \\\\\n" +
			// "       \n";
			// shoulder
			values[0] = 80;
			values[1] = 95;
			values[2] = 25;
			values[3] = 40;
			values[4] = 1;
			values[5] = 2;
			drawHangman.add(values.clone());
			// arm
			values[0] = 95;
			values[1] = 120;
			values[2] = 115;
			values[3] = 25;
			values[4] = 1;
			values[5] = 3;
			drawHangman.add(values.clone());
		case 3:
			// String leftArm =
			// "   //\n" +
			// "  // \n" +
			// " //  \n" +
			// "     \n";
			// shoulder
			values[0] = -50;
			values[1] = 95;
			values[2] = 25;
			values[3] = 40;
			values[4] = 1;
			values[5] = 4;
			drawHangman.add(values.clone());
			// arm
			values[0] = -50;
			values[1] = 120;
			values[2] = 115;
			values[3] = 25;
			values[4] = 1;
			values[5] = 5;
			drawHangman.add(values.clone());
		case 2:
			// String body =
			// "     ||\n" +
			// "     ||\n" +
			// "     ||\n" +
			// "     ||\n";
			values[0] = -10;
			values[1] = 95;
			values[2] = 150;
			values[3] = 90;
			values[4] = 1;
			values[5] = 6;
			// g.setColor(chest);
			drawHangman.add(values.clone());
		case 1:
			// String head =
			// "    ____\n" +
			// "   /    \\\n" +
			// "  |      |\n" +
			// "   \\____/\n";

			values[0] = 0;
			values[1] = 0;
			values[2] = 75;
			values[3] = 75;
			values[4] = 2;
			values[5] = 7;
			// g.setColor(head);
			drawHangman.add(values.clone());
		}

	}

	public void clearConsole() {
		
		
		int i = 0;
		while (i < 100) {
			System.out.println();
			i++;
		}
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {

			if (startGame) {
				startGame = false;
				playing = true;
			} else if (endGame) {
				endGame = false;
				playing = true;
				try {
					newWordSetup();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			} else if (nameEnter) {

				nameEnter = false;
				highScores = true;
				// endGame = true;

				scores.setScores(wrongs.size(), pName);

			} else if (highScores) {

				highScores = false;
				endGame = true;
				// endGame = true;

			} else if (ageEnter) {

				ageEnter = false;
				specialGame = true;
				age = Integer.parseInt(ageS);
				try {
					newWordSetup();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			} else if (specialGame) {

				specialGame = false;
				playing = true;
				
				
			} else {

				try {
					Game();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}

		} else if (e.getKeyLocation() == KeyEvent.KEY_LOCATION_STANDARD) {

			if (nameEnter) {
				if (pName.length() < 10) {
					letter = e.getKeyChar();

					letter = Character.toUpperCase(letter);
					pName = pName.concat(letter.toString());
				}
			} else if (ageEnter) {

				ageL = e.getKeyChar();

				ageL = Character.toUpperCase(ageL);
				try {

					Integer.parseInt(ageL.toString());
					if (ageS.length() < 3)
						ageS = ageS.concat(ageL.toString());

				} catch (NumberFormatException e2) {

				}

			} else if (startGame) {
				if (e.getKeyChar() == 'a') {
					startGame = false;
					ageEnter = true;
				}
			} else {

				letter = e.getKeyChar();
				letter = Character.toUpperCase(letter);
				waitForLetter = false;
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Game();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}
}