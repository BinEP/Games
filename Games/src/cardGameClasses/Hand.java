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
			hand = subDeck(7);
			//hand.sort();
			
			Collections.sort(hand, Card.CardNumComparator);
			Collections.sort(hand, Card.CardSuitComparator);
			
		
		
	}
	
	
	
	
//	public static void main(String[] args) {
//		Deck d = new Deck();
//		System.out.println(d.getDeck());
//	}
}
