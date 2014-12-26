package goFish;

import java.util.ArrayList;
import java.util.Collections;

public class ComputerPlayer {

	ArrayList<Card> hand = new ArrayList<Card>();
	private ArrayList<Card> deck = new ArrayList<Card>();
	private ArrayList<ArrayList<Card>> hands = new ArrayList<ArrayList<Card>>();

	public ComputerPlayer(ArrayList<Card> compHand) {

		hand = compHand;

	}

	public ComputerPlayer() {

	}

	// public ArrayList<Card> getGuess() {
	//
	// }
	//
//	 public ArrayList<Card> getPairs(int pairNum) {
//	
//		 
//		 
//	 }

	public int getNumOfPairs() {

		ArrayList<Integer> matchNums = new ArrayList<Integer>();
		for (Card c1 : hand) {
			for (Card c2 : hand) {
				if (c2.getCard() == c1.getCard() && !c2.equals(c1) && !matchNums.contains(c2.getCard()))
					matchNums.add(c2.getCard());
			}
		}
		return matchNums.size();
	}

	public void newHands() {
		for (int n = 0; n < 2; n++) {
			ArrayList<Card> hand1 = new ArrayList<Card>();
			for (int i = 0; i < 7; i++) {
				hand1.add(deck.get(0));
				deck.remove(0);
			}
			Collections.sort(hand1, Card.CardSuitComparator);
			Collections.sort(hand1, Card.CardNumComparator);

			hands.add(hand1);
			hand = hand1;
		}
		// System.out.println(hands);
	}

	public void newDeck() {
		Card card = new Card();
		for (int i = 0; i < 52; i++) {
			while (deck.contains(card)) {
				card = new Card();
			}
			deck.add(card);
		}
	}

	public void shuffleDeck() {

		Collections.shuffle(deck);
	}

	public void newGame() {

		deck.clear();
		hands.clear();
		newDeck();
		newHands();
	}

	public void testing() {

		newGame();
		System.out.println(hand);
		System.out.println(getNumOfPairs());

	}

	public static void main(String[] args) {

		ComputerPlayer cp = new ComputerPlayer();
		for (int i = 0; i < 10; i++) {
			cp.testing();
		}

	}
}
