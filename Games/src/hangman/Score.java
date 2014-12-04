package hangman;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class Score {

	
	
	public Score(String scoreFile, String peopleFile) {
		
		
		
		
		
		
		
		
	}
	
	
public ArrayList<String[]> getScores() throws FileNotFoundException {
		
		Scanner scoreContents = new Scanner(new File("scores.txt"));
		
		ArrayList<Integer> scores = new ArrayList<Integer>();
		
		while (scoreContents.hasNext()) {
			scores.add(Integer.parseInt(scoreContents.next()));	
		}
		
		Scanner peopleContents = new Scanner(new File("people.txt"));
		
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
		
		//pIndex = people.indexOf(pName);
		//pName = "";
		
		return results;
		
		
	}
	
	public void setScores(int score, String person) throws IOException {
		
		Scanner scoreContents = new Scanner(new File("scores.txt"));
		
		ArrayList<Integer> scores = new ArrayList<Integer>();
		
		//int score = wrongs.size();
		while (scoreContents.hasNext()) {
			scores.add(Integer.parseInt(scoreContents.next()));
			
		}
		scores.add(score);
	
		/////////////////////////////////////////////////////////////
		Scanner peopleContents = new Scanner(new File("people.txt"));
		
		ArrayList<String> people = new ArrayList<String>();
		
		// person = pName;
		
		while (peopleContents.hasNext()) {
			
			people.add(peopleContents.next());
		}
		people.add(person);
		
		ArrayList<String[]> results = scoreOrder(scores, people);
		PrintWriter scoreWriter1 = new PrintWriter(new FileWriter("scores.txt"));
		PrintWriter peopleWriter1 = new PrintWriter(new FileWriter("people.txt"));
		
		for (String[] sp : results) {
			
			scoreWriter1.println(sp[0]);
			peopleWriter1.println(sp[1]);
			
		}
		
		peopleWriter1.flush();
		scoreWriter1.flush();
		peopleWriter1.close();
		scoreWriter1.close();
		scoreContents.close();
		peopleContents.close();
		
	}
	
	public ArrayList<String[]> scoreOrder(ArrayList<Integer> scores, ArrayList<String> people) {
		
		ArrayList<String[]> results = new ArrayList<String[]>();
		for (int i = 0; i < people.size(); i++) {
			
			String[] sp = {scores.get(i).toString(), people.get(i)};
			results.add(sp);
			
		}
		
		Collections.sort(results, new Comparator<String[]>(){
			   @Override
			   public int compare(String[] person1, String[] person2) {
			         return person1[1].compareTo(person2[1]);
			     }
			 });
		Collections.sort(results, new Comparator<String[]>(){
			   @Override
			   public int compare(String[] score1, String[] score2) {
			         return Integer.parseInt(score1[0]) - Integer.parseInt(score2[0]);
			     }
			 });
		
		return results;
	}
	public static void main(String[] args) {

	}
}
