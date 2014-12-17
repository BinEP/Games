package cardGameClasses;

import java.util.ArrayList;

public class Discard {

	private ArrayList<Card> discard;

	public Discard() {

		discard = new ArrayList<Card>();

	}

	public Discard(Card card) {

		discard = new ArrayList<Card>();
		discard.add(card);

	}

	public Discard(ArrayList<Card> cards) {

		discard = new ArrayList<Card>();
		discard.addAll(cards);

	}

	public ArrayList<Card> discard(Card card) {

		discard.add(card);
		return discard;

	}

	public ArrayList<Card> getDiscard() {

		return discard;

	}
	
	public void clear() {
		
		discard.clear();
		
	}

	public static void main(String[] args) {

	}
}
