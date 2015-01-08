package cardClasses;

import java.util.ArrayList;

public class Deck extends CardStack {

	public static void main(String[] args) {

	}

	public Deck() {
		// TODO Auto-generated constructor stub
		super(52);

	}

	public Deck(int numOfCards) {

		super(numOfCards);

		// TODO Auto-generated constructor stub
	}

	public ArrayList<Card> reshuffle() {

		this.shuffle();
		return cardStack;
	}

	public ArrayList<ArrayList<Card>> deal(ArrayList<ArrayList<Card>> allHands,
			int handSize) {

		for (ArrayList<Card> hand : allHands) {
			for (int i = 0; i < handSize; i++) {
				hand.add(drawCard());
			}

		}

		return allHands;

	}

	public ArrayList<ArrayList<Card>> deal(int handNum, int handSize) {

		ArrayList<ArrayList<Card>> allHands = new ArrayList<ArrayList<Card>>();

		for (int h = 0; h < handNum; h++) {
			for (int i = 0; i < handSize; i++) {
				allHands.get(h).add(drawCard());
			}

		}

		return allHands;

	}
	

	public ArrayList<ArrayList<Card>> deal() {

		int handSize = 7;
		int handNum = 2;
		ArrayList<ArrayList<Card>> allHands = new ArrayList<ArrayList<Card>>();

		for (int h = 0; h < handNum; h++) {
			allHands.add(new ArrayList < Card >());
			for (int i = 0; i < handSize; i++) {
				
				allHands.get(h).add(drawCard());
			}

		}
	
		return allHands;

	}

}

class DoubleDeck extends Deck {

	public DoubleDeck() {
		super(104);

	}

}

class TripleDeck extends Deck {

	public TripleDeck() {
		super(104);

	}

}

class NDecks extends Deck {

	public NDecks(int numOfDecks) {
		super(numOfDecks * 52);

	}

}
