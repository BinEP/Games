package utilityClasses;

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
	public ScoreInfo(String gN) {
		gameName = gN;
	}
	
	public void setScores(int score, String person) {
		
		
		String gameScores = gameName.concat("Scores.txt");
		String gamePeople = gameName.concat("People.txt");

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
		PrintWriter scoreWriter = new PrintWriter(new FileWriter(gameScores));
		PrintWriter peopleWriter = new PrintWriter(new FileWriter(gamePeople));

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
		
	String gameScores = gameName.concat("Scores.txt");
	String gamePeople = gameName.concat("People.txt");
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
			String[] hs = {scores.get(i).toString(), people.get(i)};
			results.add(hs);
		}
		
		scoreContents.close();
		peopleContents.close();
				
		return results;
	} catch (FileNotFoundException e) {
		ArrayList<String[]> n = new ArrayList<String[]>();
		String[] m = {"0", "UNK"};
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
				return Integer.parseInt(score2[0])
						- Integer.parseInt(score1[0]);
			}
		});

		return results;
	}

//	public static void main(String[] args) {
//		
//		ScoreInfo SI = new ScoreInfo("hole");
//		ArrayList<String[]> scores = SI.getScores();
//		SI.setScores(10, "BradyTest1");
//		System.out.println();
//		
//	}
}
