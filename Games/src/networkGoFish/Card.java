package networkGoFish;

import java.awt.Color;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.Comparator;

public class Card implements Serializable  {

	private int suit;
	private int card;
	private int point;
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

		getCardFace();
		// hearts
		// diamonds
		// clubs
		// spades

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
		point = 11;
		if (card < 11 && card != 1) {
			
			point = card;
			return String.valueOf(card);

		} else {

			switch (card) {

			case 11:
				cardFace = "J";
				point = 10;
				break;
			case 12:
				cardFace = "Q";
				point = 10;
				break;
			case 13:
				cardFace = "K";
				point = 10;
				break;
			default:
				cardFace = "A";
				point = 11;
				break;

			}
			return cardFace;

		}

	}

	public boolean equalRank(Card c) {

		return this.getCard() == c.getCard();

	}

	public boolean sameSuit(Card c) {

		return this.getSuit() == c.getSuit();

	}
	
	public int getPoint() {
		return point;
		
		
	}

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

	@Override
	public String toString() {
		return getCardFace() + getSuitIcon();
	}

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




	

	// @Override
	// public boolean equals(Object o) {
	//
	// StackTraceElement[] stackTraceElements = Thread.currentThread()
	// .getStackTrace();
	// if (o instanceof Card) {
	// if (stackTraceElements[3].getMethodName().equals("contains")) {
	// // for (int i = 0; i < stackTraceElements.length; i++) {
	// // System.out.println(stackTraceElements[i].getMethodName());
	// // }
	// //
	// System.out.println(stackTraceElements[stackTraceElements.length-1].getMethodName().toString());
	//
	// return getCard() == ((Card) o).getCard()
	// && getSuit() == ((Card) o).getSuit();
	// } else {
	// return getCard() == ((Card) o).getCard();
	// }
	// } else {
	// return false;
	// }
	// }

	// @Override
	// public boolean equals(Object o) {
	//
	// if (o instanceof Card) {
	//
	// return getCard() == ((Card) o).getCard();
	//
	// }
	// return false;
	//
	// }

	// public static void main(String[] args) {
	// System.out.println(new Card());
	// }
}
