package goFish;

import java.util.Comparator;

public class Card {

	private int suit;
	private int card;
	private String shown;

	public Card() {

		suit = (int) (Math.random() * 4) + 1;
		card = (int) (Math.random() * 13) + 1;
		shown = getCardFace() + getSuitIcon();
		//hearts
		//diamonds
		//clubs
		//spades
		
	}
	
	public String getShown() {
		
		return shown;
		
	}
	
	public int getSuit() {
		return suit;
	}

	public String getSuitIcon() {
		String suitChar = "J";
		switch (suit) {
		case 4:
			suitChar = "\u2665";
			break;
		case 3:
			suitChar = "\u2663";
			break;
		case 2:
			suitChar = "\u2666";
			break;
		case 1:
			suitChar = "\u2660";
			break;
		}
		
		return suitChar;

	}

	public int getCard() {

		return card;

	}

	public String getCardFace() {
		
		String cardFace = "A";
		if (card < 11 && card != 1) {

			return String.valueOf(card);

		} else {

			switch (card) {

			case 11:
				cardFace = "J";
				break;
			case 12:
				cardFace = "Q";
				break;
			case 13:
				cardFace = "K";
				break;
			default:
				cardFace = "A";
				break;

			}
			return cardFace;

		}

	}
	
	public static Comparator<Card> CardSuitComparator = new Comparator<Card>() {

		public int compare(Card c1, Card c2) {
		   int cardSuit1 = c1.getSuit();
		   int cardSuit2 = c2.getSuit();

		   //ascending order
		   return cardSuit2 - cardSuit1;

		   //descending order
		   //return StudentName2.compareTo(StudentName1);
	    }};
	    
	    public static Comparator<Card> CardNumComparator = new Comparator<Card>() {

	    	public int compare(Card c1, Card c2) {

	    	   int cardNum1 = c1.getCard();
	    	   int cardNum2 = c2.getCard();

	    	   /*For ascending order*/
	    	   return cardNum1-cardNum2;

	    	   /*For descending order*/
	    	   //rollno2-rollno1;
	       }};
	       
	       @Override
	       public String toString() {
	           return "[ Card Suit = " + getSuitIcon() + ", Card Value = " + getCardFace() + "]";
	       }
	       
	       @Override
	       public boolean equals(Object o) {
	    	   
	    	   if (o instanceof Card) {
	    		   
	    		   return getCard() == ((Card) o).getCard() && getSuit() == ((Card) o).getSuit();
	    		   
	    	   }
	    	   return false;
	    	   
	       }

	public static void main(String[] args) {
		System.out.println('\u2665');
		System.out.println("\u2663");
		System.out.println("\u2666");
		System.out.println("\u2660");
	}
}
