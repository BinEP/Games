package cardClasses;

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
	
	
	//cardStack if the variable that has all the cards and can be used in any subclasses
	protected ArrayList<Card> cardStack = new ArrayList<Card>();

	public CardStack() {

		newStack();

	}

	public CardStack(int numOfCards) {

		
			double deckCount = Math.ceil((double)numOfCards/52);
			//Adds the number of complete decks needed for the number of cards
			for (int i = 0; i < deckCount; i++) {
			
				 cardStack.addAll(newStackList(52));
			}
			
			//removes the unneeded cards from the end
			cardStack.subList(numOfCards, cardStack.size()).clear();
			
		
	}
	
	//new Stack of different cards - 52 cards

	public ArrayList<Card> newStack() {
//checks if present, if not, adds it
		Card card = new Card();
		for (int i = 0; i < 52; i++) {
			while (cardStack.contains(card)) {
				card = new Card();
			}
			cardStack.add(card);
		}

		return cardStack;
	}
	
	//new Stack of different cards - specified number of cards

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
	
	//just returns a 52 random cards, doesn't modify cardStack
	
	public ArrayList<Card> newStackList() {

		ArrayList<Card> cardStack = new ArrayList<Card>();
		Card card = new Card();
		for (int i = 0; i < 52; i++) {
			while (cardStack.contains(card)) {
				card = new Card();
			}
			cardStack.add(card);
		}

		return cardStack;
	}

	//just returns a bunch of random cards, doesn't modify cardStack - n number of cards
	public ArrayList<Card> newStackList(int numOfCards) {

		ArrayList<Card> cardStack = new ArrayList<Card>();
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

	//gets part of a stack without removing cards from cardStack
	public ArrayList<Card> subStackCopy() {

		ArrayList<Card> hand = new ArrayList<Card>();
		for (int i = 0; i < 7; i++) {
			hand.add(cardStack.get(i));
		}
		sortStack();

		return hand;
	}
	
	//same as above, but removes cards

	public ArrayList<Card> subStackRemove() {

		ArrayList<Card> hand = new ArrayList<Card>();
		for (int i = 0; i < 7; i++) {
			hand.add(cardStack.get(0));
			cardStack.remove(0);
		}
		sortStack();

		return hand;
	}
	
	//exactly the same as above, just named intelligently
	//Also all substack methods just have different parameters for customizability

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
	
	//sorts by number

	public ArrayList<Card> sortStack() {

		Collections.sort(cardStack, Card.CardSuitComparator);
		Collections.sort(cardStack, Card.CardNumComparator);
		return cardStack;
	}
	
	//sorts by suit

	public ArrayList<Card> sortStackSuit() {

		Collections.sort(cardStack, Card.CardNumComparator);
		Collections.sort(cardStack, Card.CardSuitComparator);
		return cardStack;
	}
	
	//sorts specified card stack

	public ArrayList<Card> sortStack(ArrayList<Card> stack) {

		Collections.sort(stack, Card.CardSuitComparator);
		Collections.sort(stack, Card.CardNumComparator);
		return stack;
	}

	public ArrayList<Card> sortStackSuit(ArrayList<Card> stack) {

		Collections.sort(stack, Card.CardNumComparator);
		Collections.sort(stack, Card.CardSuitComparator);
		return stack;
	}

	public int cardsLeft() {

		return cardStack.size();

	}

	public Card drawCard() {

		return cardStack.remove(0);

	}

	public Card getCard(int cardIndex) {

		return cardStack.get(cardIndex);

	}
	

	public Card getNextCard() {

		return cardStack.get(0);

	}

	public ArrayList<Card> addCard(Card c) {

		cardStack.add(c);
		return cardStack;

	}

	public ArrayList<Card> getStack() {

		return cardStack;
	}

	public void clearStack() {
		cardStack.clear();
	}

	public ArrayList<Card> removeCard(Card c) {

		cardStack.remove(c);
		return cardStack;
	}
	
	public String toString() {
		
		return cardStack.toString();
		
		
	}

	public static void main(String[] args) {
		new CardStack(52);
	}
}
