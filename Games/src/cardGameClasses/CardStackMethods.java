package cardGameClasses;

import java.util.ArrayList;

public abstract class CardStackMethods {

	ArrayList<Card> cardStack;
	
	public CardStackMethods() {
		
		cardStack = new ArrayList<Card>();
		
	}
	
	public abstract ArrayList<Card> addAll(ArrayList<Card> cards);
	public abstract ArrayList<Card> add(Card card);
	public abstract Card nextCard();
	public abstract ArrayList<Card> nextCardList();
	public abstract boolean removeMatches(Card checkCard);
	public abstract void clear();
	public abstract ArrayList<Card> getStack();
	public abstract Card get(int i);
	public abstract int find(Card card);
	public abstract ArrayList<Card> findMatches(Card card);
	public abstract ArrayList<Card> findMatches(int c);
	public abstract int cardsLeft();
	public abstract ArrayList<Card> shuffle();
	public abstract ArrayList<Card> sort();
	public abstract ArrayList<Card> newStack();
	public abstract ArrayList<Card> newStack(int cardNum);
	public abstract ArrayList<Card> subDeck();
	public abstract ArrayList<Card> subDeck(int cardNum);
}
