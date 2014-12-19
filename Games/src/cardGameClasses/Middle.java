package cardGameClasses;

import java.util.ArrayList;

public class Middle extends CardStack  {

	private ArrayList<Card> middle;

	public Middle() {

		middle = new ArrayList<Card>();

	}

	public Middle(ArrayList<Card> cards) {

		middle = new ArrayList<Card>();
		middle.addAll(cards);

	}

	public ArrayList<Card> addToMiddle(ArrayList<Card> cards) {

		middle.addAll(cards);
		return middle;

	}

	public void clear() {

		middle.clear();
	}

	public ArrayList<Card> getMiddle() {
		
		return middle;
		
	}

	public static void main(String[] args) {

	}
}
