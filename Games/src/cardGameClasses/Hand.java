package cardGameClasses;

import java.util.ArrayList;
import java.util.Collections;

public class Hand extends CardStack {

	private Deck deck;
	private ArrayList<Card> hand;
	
	
	public Hand() {
		
		deck = new Deck();
		newHand();
		
		
	}
	
	
	public void newHand() {
		
		
			hand = new ArrayList<Card>();
			for (int i = 0; i < 7; i++) {
				hand.add(deck.getDeck().get(0));
				deck.getDeck().remove(0);
			}
			
			Collections.sort(hand, Card.CardNumComparator);
			Collections.sort(hand, Card.CardSuitComparator);
			
		
		
	}
	
	
	
	
//	public static void main(String[] args) {
//		Deck d = new Deck();
//		System.out.println(d.getDeck());
//	}
}
