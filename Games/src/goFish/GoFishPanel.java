package goFish;

import utilityClasses.CenteredText;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GoFishPanel extends JPanel implements ActionListener, KeyListener, MouseListener {

	private ArrayList<Card> deck = new ArrayList<Card>();
//	private ArrayList<Card> p1Hand = new ArrayList<Card>();
//	private ArrayList<Card> p2Hand = new ArrayList<Card>();
	private int numOfPlayers = 2;
	private ArrayList<ArrayList<Card>> hands = new ArrayList<ArrayList<Card>>(numOfPlayers);
	
	private boolean startGame = true;
	private boolean playing = false;
	private boolean endGame = false;
	
	ArrayList<Rectangle> cards = new ArrayList<Rectangle>();

	public GoFishPanel() {

		newDeck();
//		p1Hand = playerHand();
//		p2Hand = playerHand();
		newHands();
		
		setBackground(Color.BLACK);

		setFocusable(true);
		addKeyListener(this);
		addMouseListener(this);

		Timer timer = new Timer(1000 / 60, this);
		timer.start();

	}

	public GoFishPanel(int i) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		moves();
	}

	public void moves() {

		
		if (playing) {
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
		
		
		
		repaint();
	}

	public void newDeck() {
		Card card = new Card();
		for (int i = 0; i < 52; i++) {
			while(deck.contains(card)) {
				
				card = new Card();
				
			}
			deck.add(card);

		}

	}
	
	public void drawPlayerHand(int pNum, Graphics g) {
		
		ArrayList<Card> hand = hands.get(pNum-1);
				
		
		int HY = (pNum == 1) ? 20 : 550;
		
		g.setFont(new Font("Joystix", Font.BOLD, 20));
		int i = 0;
		int startX = 20;
		int startY = 10;
		int spacing = (448 - hand.size() * 56)/hand.size();
		//startX = (500 - (i * (56 + spacing)) * hand.size())/2;
		
		//System.out.println((500 - ((i * (56 + spacing)) * hand.size()))/2);
		
		for (Card card : hand) {
			
			int x = (i * (56 + spacing)) + startX;
			int y = startY;
			CenteredText out = new CenteredText(card.getCardFace() + card.getSuitIcon(), 56, 100, g);
			g.setColor(card.getColor());
			g.fillRoundRect(x, y, 56, 100, 5, 5);
			g.drawRoundRect(x, y, 56, 100, 5, 5);
			g.setColor((card.getSuit() % 2 == 0) ? Color.RED : Color.BLACK );
			g.drawString(card.getCardFace() + card.getSuitIcon(), x + out.x, y + 56);
			//cards.add(new Rectangle(x, y, 56, 100));
			
			hands.get(pNum-1).get(i).setRectangle(x, y, 56, 100);
			
				
			i++;
			
			
		}
		
		
	}
	
	public ArrayList<Card> playerHand() {
		
		
		ArrayList<Card> hand = new ArrayList<Card>();
		for (int i = 0; i < 7; i++) {
			hand.add(deck.get(0));
			deck.remove(0);
			
		}
		Collections.sort(hand, Card.CardNumComparator);
		Collections.sort(hand, Card.CardSuitComparator);
		
		
		return hand;
	}
	
	public void newHands() {
		for (int n = 0; n < numOfPlayers; n++) {
		ArrayList<Card> hand = new ArrayList<Card>();
		for (int i = 0; i < 7; i++) {
			hand.add(deck.get(0));
			deck.remove(0);
			
		}
		Collections.sort(hand, Card.CardNumComparator);
		Collections.sort(hand, Card.CardSuitComparator);
		hands.add(hand);
		}
		//return hand;
	}

	public void shuffleDeck() {

		Collections.shuffle(deck);
		

	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		
		drawPlayerHand(1, g);
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

//	public static void main(String[] args) {
//		
//		GoFishPanel p = new GoFishPanel(1);
//		p.runFromMain();
//
//	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		for (ArrayList<Card> aHand : hands) {
			//System.out.println(aHand);
			for (Card r : aHand) {
			if (r.getRectangle().contains(e.getPoint())) {
				
				r.selected = !r.selected;
				r.setColor((r.selected) ? Color.YELLOW : Color.WHITE);
				
				
			}
			}
			
		}
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
