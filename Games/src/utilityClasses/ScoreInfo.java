package utilityClasses;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
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
import java.lang.Class;

public class ScoreInfo {

	private String gameName;
	private String gameScores;
	private String gamePeople;

	public ScoreInfo(String gN) {
		gameName = gN;
		gameScores = "InfoFiles/" + gameName.concat("Scores.txt");
		gamePeople = "InfoFiles/" + gameName.concat("People.txt");
		verifyFile();
		
	}

	public void setScores(int score, String person) {

		try {
			Scanner scoreContents = new Scanner(new File(gameScores));

			ArrayList<Integer> scores = new ArrayList<Integer>();

			while (scoreContents.hasNext()) {
				scores.add(Integer.parseInt(scoreContents.next()));

			}
			scores.add(score);

			// ///////////////////////////////////////////////////////////
			Scanner peopleContents = new Scanner(new File(gamePeople));

			ArrayList<String> people = new ArrayList<String>();

			while (peopleContents.hasNext()) {

				people.add(peopleContents.next());
			}
			people.add(person);

			ArrayList<String[]> results = scoreOrder(scores, people);
			PrintWriter scoreWriter = new PrintWriter(
					new FileWriter(gameScores));
			PrintWriter peopleWriter = new PrintWriter(new FileWriter(
					gamePeople));

			for (String[] sp : results) {

				scoreWriter.println(sp[0]);
				peopleWriter.println(sp[1]);

			}

			peopleWriter.flush();
			scoreWriter.flush();
			peopleWriter.close();
			scoreWriter.close();
			scoreContents.close();
			peopleContents.close();

		} catch (IOException e) {

		}

	}

	public ArrayList<String[]> getScores() {

		try {
			Scanner scoreContents = new Scanner(new File(gameScores));

			ArrayList<Integer> scores = new ArrayList<Integer>();

			while (scoreContents.hasNext()) {
				scores.add(Integer.parseInt(scoreContents.next()));
			}

			Scanner peopleContents = new Scanner(new File(gamePeople));

			ArrayList<String> people = new ArrayList<String>();

			while (peopleContents.hasNext()) {

				people.add(peopleContents.next());
			}

			ArrayList<String[]> results = new ArrayList<String[]>();

			for (int i = 0; i < people.size(); i++) {
				String[] hs = { scores.get(i).toString(), people.get(i) };
				results.add(hs);
			}

			scoreContents.close();
			peopleContents.close();

			return results;
		} catch (FileNotFoundException e) {
			ArrayList<String[]> n = new ArrayList<String[]>();
			String[] m = { "0", "UNK" };
			n.add(m);
			return n;
		}

	}

	public ArrayList<String[]> scoreOrder(ArrayList<Integer> scores,
			ArrayList<String> people) {

		ArrayList<String[]> results = new ArrayList<String[]>();
		for (int i = 0; i < people.size(); i++) {

			String[] sp = { scores.get(i).toString(), people.get(i) };
			results.add(sp);

		}

		Collections.sort(results, new Comparator<String[]>() {
			@Override
			public int compare(String[] person1, String[] person2) {
				return person1[1].compareTo(person2[1]);
			}
		});
		Collections.sort(results, new Comparator<String[]>() {
			@Override
			public int compare(String[] score1, String[] score2) {
				return Integer.parseInt(score2[0]) - Integer.parseInt(score1[0]);
			}
		});

		return results;
	}

	public void drawScores(Graphics g) {

		ArrayList<String[]> results = getScores();
		g.setFont(new Font("Joystix", Font.BOLD, 17));
		int i = 0;
		int yStart = 40;
		int xStart = 30;
		int lineH = 50;
		int l = 0;
		int r = 1;
		g.setColor(Color.WHITE);
		for (String[] c : results) {

			if (l > 12) {
				i++;
				l = 0;
			}
			int x = (340 * i) + xStart;
			String dots = "";
			int m = String.valueOf(r).length();
			// System.out.println(m);
			for (int n = 0; n < 11 - c[1].length() - m + 1; n++) {
				dots = dots.concat(".");
			}
			dots = dots.concat(".");

			// CenteredText lx = new CenteredText(c.toString(), 45, 8, g);
			// System.out.println(pIndex);
			// Color col = (pIndex == r - 1) ? Color.YELLOW : Color.WHITE;
			// g.setColor(col);
			g.drawString(r + ". " + c[1] + dots + c[0], x, (yStart - 2)
					+ (l * lineH));

			l++;
			r++;
		}
	}

	public void enterName(Graphics g, int wSW, int wSH, int score, String pName) {

		g.setFont(new Font("Joystix", Font.BOLD, 40));
		CenteredText enter = new CenteredText("Enter", wSW, wSH, g, true, 100);
		CenteredText enter1 = new CenteredText("Your Name", wSW, wSH, g, true,
				170);

		int barWidth = 35;
		int barSpace = 10 + barWidth;
		int tw = 450;
		int startText = (wSW - tw) / 2;
		g.setFont(new Font("Joystix", Font.BOLD, 20));
		for (int i = 0; i < 10; i++) {
			if (pName.length() > i) {
				CenteredText lx = new CenteredText(Character.toString(pName
						.charAt(i)), barWidth, 8, g);
				g.drawString(Character.toString(pName.charAt(i)), (barSpace * i)
						+ startText + lx.x, 440);
			}
			g.fillRect((barSpace * i) + startText, 442, barWidth, 8);
		}
	}
	
	public void verifyFile() {
		
		File scoreFile = new File(gameScores);
		File peopleFile = new File(gamePeople);
		
			try {
				scoreFile.createNewFile();
				peopleFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	// public static void main(String[] args) {
	//
	// ScoreInfo SI = new ScoreInfo("hole");
	// ArrayList<String[]> scores = SI.getScores();
	// SI.setScores(10, "BradyTest1");
	// System.out.println();
	//
	// }
}
