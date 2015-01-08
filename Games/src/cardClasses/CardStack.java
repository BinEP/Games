package cardClasses;

import goFish.Card;

import java.util.ArrayList;
import java.util.Collections;

public class CardStack {

	// new stack
	// sub stack
	// sort
	// shuffle
	// cards left
	// get card
	// add card
	//

	protected ArrayList<Card> cardStack = new ArrayList<Card>();

	public ArrayList<Card> newStack() {

		Card card = new Card();
		for (int i = 0; i < 52; i++) {
			while (cardStack.contains(card)) {
				card = new Card();
			}
			cardStack.add(card);
		}

		return cardStack;
	}

	public ArrayList<Card> newStack(int numOfCards) {

		Card card = new Card();
		for (int i = 0; i < numOfCards; i++) {
			while (cardStack.contains(card)) {
				card = new Card();
			}
			cardStack.add(card);
		}

		return cardStack;

	}

	public void shuffle() {

		Collections.shuffle(cardStack);
	}

	public ArrayList<Card> subStackCopy() {

		ArrayList<Card> hand = new ArrayList<Card>();
		for (int i = 0; i < 7; i++) {
			hand.add(cardStack.get(i));
		}
		sortStack();

		return hand;
	}

	public ArrayList<Card> subStackRemove() {

		ArrayList<Card> hand = new ArrayList<Card>();
		for (int i = 0; i < 7; i++) {
			hand.add(cardStack.get(0));
			cardStack.remove(0);
		}
		sortStack();

		return hand;
	}

	public ArrayList<Card> subStack() {

		ArrayList<Card> hand = new ArrayList<Card>();
		for (int i = 0; i < 7; i++) {
			hand.add(cardStack.get(0));
			cardStack.remove(0);
		}
		sortStack();

		return hand;
	}

	public ArrayList<Card> subStackCopy(int numOfCards) {

		ArrayList<Card> hand = new ArrayList<Card>();
		for (int i = 0; i < numOfCards; i++) {
			hand.add(cardStack.get(i));
		}
		sortStack();

		return hand;
	}

	public ArrayList<Card> subStackRemove(int numOfCards) {

		ArrayList<Card> hand = new ArrayList<Card>();
		for (int i = 0; i < numOfCards; i++) {
			hand.add(cardStack.get(0));
			cardStack.remove(0);
		}
		sortStack();

		return hand;
	}

	public ArrayList<Card> subStack(int numOfCards) {

		ArrayList<Card> hand = new ArrayList<Card>();
		for (int i = 0; i < numOfCards; i++) {
			hand.add(cardStack.get(0));
			cardStack.remove(0);
		}
		sortStack();

		return hand;
	}

	public ArrayList < Card > sortStack() {

		Collections.sort(cardStack, Card.CardSuitComparator);
		Collections.sort(cardStack, Card.CardNumComparator);
		return cardStack;
	}
	
	public ArrayList < Card >  sortStackSuit() {

		Collections.sort(cardStack, Card.CardNumComparator);
		Collections.sort(cardStack, Card.CardSuitComparator);
		return cardStack;
	}
	
	public ArrayList < Card > sortStack(ArrayList < Card > stack) {

		Collections.sort(stack, Card.CardSuitComparator);
		Collections.sort(stack, Card.CardNumComparator);
		return stack;
	}
	
	public ArrayList < Card >  sortStackSuit(ArrayList < Card > stack) {

		Collections.sort(stack, Card.CardNumComparator);
		Collections.sort(stack, Card.CardSuitComparator);
		return stack;
	}
	
	public int cardsLeft() {
		
		return cardStack.size();
		
	}
	
	public Card deal() {
		
		return cardStack.remove(0);
		
	}
	
public Card getCard(int cardIndex) {
		
		return cardStack.get(cardIndex);
		
	}

public Card getNextCard() {
	
	return cardStack.get(0);
	
}

public ArrayList < Card > addCard(Card c) {
	
	cardStack.add(c);
	return cardStack;
	
}

public ArrayList < Card > getStack() {
	
	return cardStack;
}

public void clearStack() {
	cardStack.clear();
}

public ArrayList < Card > removeCard(Card c) {
	
	
	cardStack.remove(c);
	return cardStack;
}

	public static void main(String[] args) {

	}
}
