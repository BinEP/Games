package cardClasses;

import java.util.ArrayList;

public class Deck extends CardStack {

	public static void main(String[] args) {

	}

	public Deck() {
		super(52);

	}

	public Deck(int numOfCards) {

		super(numOfCards);

	}

	public ArrayList<Card> reshuffle() {

		this.shuffle();
		return cardStack;
	}
	
	//returns array list of array list of cards
	//all deal methods are variatioins of this

	public ArrayList<ArrayList<Card>> deal(ArrayList<ArrayList<Card>> allHands,
			int handSize) {

		for (ArrayList<Card> hand : allHands) {
			for (int i = 0; i < handSize; i++) {
				hand.add(drawCard());
			}

		}

		return allHands;

	}
	
	public ArrayList<Hand> deal(ArrayList<Hand> allHands, int handSize, boolean handInput) {

		for (Hand hand : allHands) {
			
			for (int i = 0; i < handSize; i++) {
				hand.add(drawCard());
			}

		}

		return allHands;

	}

	public ArrayList<ArrayList<Card>> deal(int handSize) {

		ArrayList<ArrayList<Card>> allHands = new ArrayList<ArrayList<Card>>();

		for (ArrayList<Card> hand : allHands) {
			for (int i = 0; i < handSize; i++) {
				hand.add(drawCard());
			}

		}

		return allHands;

	}

	public ArrayList<ArrayList<Card>> deal() {

		int handSize = 7;
		ArrayList<ArrayList<Card>> allHands = new ArrayList<ArrayList<Card>>();

		for (ArrayList<Card> hand : allHands) {
			for (int i = 0; i < handSize; i++) {
				System.out.println(cardStack);
				System.out.println(allHands.toString());
				hand.add(drawCard());
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
