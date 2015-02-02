package goFishCommons;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import utilityClasses.*;

public class ChatCensor {

	public String wordFile;
	public String checkString;
	ArrayList<String> allSwearWords = new ArrayList<String>();
	ArrayList<String> allFunnyWords = new ArrayList<String>();

	public static void main(String[] args) {
		ChatCensor runIt = new ChatCensor();
		runIt.runFromMain();
	}

	public void runFromMain() {

		checkString = "Hello, how are you!";
		censorString();
	}

	public ChatCensor() {
		// TODO Auto-generated constructor stub
		getCensoredWords();
		getFunnyWords();
	}

	public ChatCensor(String checkString) {

		getCensoredWords();
		getFunnyWords();
		this.checkString = checkString;

	}

	public void setCheckString(String checkString) {

		this.checkString = checkString;

	}

	public String censorString() {
		
		String[] badWords = arrayOfSwears();
		
		String[] replacementWords = arrayOfGoods();
		
		
		Random r = new Random();
		
		for (int i = 0; i < badWords.length; i++) {
			
			int indexOfBadWord = (checkString.toLowerCase()).indexOf(badWords[i].toLowerCase());
			
			if (indexOfBadWord != -1 && checkPartialWord(indexOfBadWord, badWords[i].toLowerCase(), checkString)) {
				String begin = checkString.substring(0, indexOfBadWord);
				String replacement = replacementWords[r
						.nextInt(replacementWords.length)];
				String end = checkString.substring(indexOfBadWord
						+ badWords[i].length());
				checkString = begin + replacement + end;
				i = -1;
			}
		}

		return checkString; // now holy.
	}
	
	public boolean checkPartialWord(int indexOfBadWord, String badWord, String checkString) {
		
		if (true) return true;
		if (indexOfBadWord != -1 && checkString.length() == badWord.length()) return true;
		if (checkString.charAt(indexOfBadWord + 1) != ' ') return false;
		
		return true;
//		if (indexOfBadWord + badWord.length() + 1 == checkString.length()) return true;
		
		
		
		
		
	}

	public String[] arrayOfSwears() {

		return allSwearWords.toArray(new String[allSwearWords.size()]);

	}
	
	public String[] arrayOfGoods() {
		
		return allFunnyWords.toArray(new String[allFunnyWords.size()]);
		
	}

	public void getCensoredWords() {

		wordFile = "swearWords.txt";
		Scanner input;
		try {
			input = new Scanner(new File(wordFile));
			while (input.hasNext()) {
				allSwearWords.add(input.next());
			}
			input.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void getFunnyWords() {

		wordFile = "funnyWords.txt";
		Scanner input;
		try {
			input = new Scanner(new File(wordFile));
			while (input.hasNext()) {
				allFunnyWords.add(input.next());
			}
			input.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
