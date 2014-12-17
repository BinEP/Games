package cardGameClasses;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.Comparator;

public class Card {

	private int suit;
	private int card;
	private String shown;
	private Color col = Color.WHITE;
	private Rectangle picCard = new Rectangle();
	public boolean selected = false;

	public Card() {

		suit = (int) (Math.random() * 4) + 1;
		card = (int) (Math.random() * 13) + 1;
		shown = getCardFace() + getSuitIcon();
		col = Color.WHITE;
		selected = false;
		//hearts
		//diamonds
		//clubs
		//spades
		
	}
	
	public Card(int s, int c) {
		
		suit = s;
		card = c;
		shown = getCardFace() + getSuitIcon();
		col = Color.WHITE;
		selected = false;
		
	}
	
	public String getShown() {
		
		return shown;
		
	}
	
	public int getSuit() {
		return suit;
	}
	
	public Color getColor() {
		return col;
	}
	
	public Rectangle getRectangle() {
		return picCard;
	}
	
	public void setRectangle(int x, int y, int w, int h) {
		picCard = new Rectangle(x, y, w, h);
	}
	
	public void setColor(Color color) {
		
		col = color;
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
	    	   return cardNum2-cardNum1;

	    	   /*For descending order*/
	    	   //rollno2-rollno1;
	       }};
	       
	       @Override
	       public String toString() {
	           return card + getSuitIcon();
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
