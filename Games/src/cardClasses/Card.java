package cardClasses;

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
		// hearts
		// diamonds
		// clubs
		// spades

	}
	
	//gets what would be on an actual playing card - AKQJ10 9 8 ... and the suit

	public String getShown() {

		return shown;

	}
	
	//gets suit number

	public int getSuit() {
		return suit;
	}

	//for goFish - to be selected color
	public Color getColor() {
		return col;
	}
	
	//rectangle of the card that can be used to be drawn

	public Rectangle getRectangle() {
		return picCard;
	}
	
	//sets rectangle of position and size of card on screen

	public void setRectangle(int x, int y, int w, int h) {
		picCard = new Rectangle(x, y, w, h);
	}
	
	//selected or not selected color

	public void setColor(Color color) {

		col = color;
	}
	
	//ascii character for suit

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
	
	//returns card number - j = 11, q = 12 ...

	public int getCard() {

		return card;

	}

	//returns the letter or number for the card
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
	
	//checks if same card by number

	public boolean equalRank(Card c) {

		return this.getCard() == c.getCard();

	}
	
	//checks for suit

	public boolean sameSuit(Card c) {

		return this.getSuit() == c.getSuit();

	}
	
	//for sorting, which card suit is above, used by the sort method

	public static Comparator<Card> CardSuitComparator = new Comparator<Card>() {

		public int compare(Card c1, Card c2) {
			int cardSuit1 = c1.getSuit();
			int cardSuit2 = c2.getSuit();

			// ascending order
			return cardSuit2 - cardSuit1;

			// descending order
			// return StudentName2.compareTo(StudentName1);
		}
	};

	//for sorting, which card number is above, used by the sort method

	
	public static Comparator<Card> CardNumComparator = new Comparator<Card>() {

		public int compare(Card c1, Card c2) {

			int cardNum1 = c1.getCard();
			int cardNum2 = c2.getCard();

			/* For ascending order */
			return cardNum2 - cardNum1;

			/* For descending order */
			// rollno2-rollno1;
		}
	};

	//the tostring retuns string of what would appear on a playing card
	@Override
	public String toString() {
		return getCardFace() + getSuitIcon();
	}

	//for checking if exactly same card
	@Override
	public boolean equals(Object o) {

		if (o instanceof Card) {

			return getCard() == ((Card) o).getCard()
					&& getSuit() == ((Card) o).getSuit();

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
