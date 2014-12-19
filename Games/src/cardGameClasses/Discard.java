package cardGameClasses;

import java.util.ArrayList;
import java.util.Collections;

public class Discard extends CardStack  {

	private ArrayList<Card> discard;

	public Discard() {

		super();
//		discard = new ArrayList<Card>();
		discard = cardStack;
		
	}

	public Discard(Card card) {
		
		super((ArrayList<Card>) Collections.singleton(card));
//		discard = new ArrayList<Card>();
		discard = cardStack;
		discard.add(card);

	}

	public Discard(ArrayList<Card> cards) {
		
		super(new ArrayList<Card>());
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

//	public static void main(String[] args) {
//		
//		Discard n = new Discard();
//		n.add(new Card());
//		n.add(new Card());
//		System.out.println(n.getStack());
//		System.out.println(n.nextCard());
//		System.out.println(n.getDiscard());
//		System.out.println(n.getStack());
//		n.add(new Card());
//		System.out.println(n.getDiscard());
//		System.out.println(n.getStack());
//		
//		
//	}
}
