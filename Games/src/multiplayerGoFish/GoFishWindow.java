package multiplayerGoFish;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import utilityClasses.*;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;

import netgame.common.*;

/**
 * This window represents one player in a two-player networked game of
 * TicTacToe. The window is meant to be created by the program
 * netgame.tictactoe.Main.
 */
public class GoFishWindow extends JFrame {

	/**
	 * The state of the game. This state is a copy of the official state, which
	 * is stored on the server. When the state changes, the state is sent as a
	 * message to this window. (It is actually sent to the TicTacToeClient
	 * object that represents the connection to the server.) When that happens,
	 * the state that was received in the message replaces the value of this
	 * variable, and the board and UI is updated to reflect the changed state.
	 * This is done in the newState() method, which is called by the
	 * TicTacToeClient object.
	 */
	private GoFishGameState state;

	private Board board; // A panel that displays the board. The user
							// makes moves by clicking on this panel.

	private JLabel message; // Displays messages to the user about the status of
							// the game.

	private int myID; // The ID number that identifies the player using this
	public boolean cheat = true; // window.

	private String customFontName;
	private Font customFont;
	private static final String Font_File_Name = "joystix";

	private GoFishClient connection; // The Client object for sending and

	// receiving

	// network messages.

	/**
	 * This class defines the client object that handles communication with the
	 * Hub.
	 */
	private class GoFishClient extends Client {

		/**
		 * Connect to the hub at a specified host name and port number.
		 */
		public GoFishClient(String hubHostName, int hubPort) throws IOException {
			super(hubHostName, hubPort);
		}

		/**
		 * Responds to a message received from the Hub. The only messages that
		 * are supported are TicTacToeGameState objects. When one is received,
		 * the newState() method in the TicTacToeWindow class is called. To
		 * avoid problems with synchronization, that method is called using
		 * SwingUtilities.invokeLater() so that it will run in the GUI event
		 * thread.
		 */
		protected void messageReceived(final Object message) {
			if (message instanceof GoFishGameState) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() { // calls a method at the end of the
										// TicTacToeWindow class
						newState((GoFishGameState) message);
					}
				});
			}
		}

		/**
		 * If a shutdown message is received from the Hub, the user is notified
		 * and the program ends.
		 */
		protected void serverShutdown(String message) {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					JOptionPane
							.showMessageDialog(GoFishWindow.this,
									"Your opponent has disconnected.\nThe game is ended.");
					System.exit(0);
				}
			});
		}

		protected int getNumOfPlayers() {
			return connectedPlayerIDs.length;
		}

	}

	/**
	 * A JPanel that draws the TicTacToe board.
	 */
	private class Board extends JPanel { // Defines the board object

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.setColor(Color.WHITE);
			if (state == null || state.startGame) {

				g.setColor(Color.WHITE);
				// g.setFont(new Font("Joystix", Font.BOLD, 60));
				// g.setFont(new Font(customFont.getFamily(), Font.BOLD, 60));
				g.setFont(new Font(customFontName, Font.BOLD, 60));
				// g.setFont(customFont.deriveFont(Font.BOLD, 60));

				CenteredText title1 = new CenteredText("GO FISH!!", 500, 500,
						g, true, 230);

				g.setFont(new Font(customFontName, Font.BOLD, 20));

				// CenteredText start1 = new CenteredText("Press Enter to", 500,
				// 500, g, true, 350);
				// CenteredText start2 = new CenteredText("Start", 500, 500, g,
				// true, 380);
				if (state == null) {
					CenteredText messageFromTheHub = new CenteredText(
							"Waiting for Others...", 500, 500, g, true, 440);

					CenteredText playerNum = new CenteredText(""
							+ connection.getNumOfPlayers(), 500, 500, g, true,
							460);

				} else {

					CenteredText messageFromTheHub = new CenteredText(
							state.messageFromServer[0], 500, 500, g, true, 320);

					CenteredText messageFromTheHub1 = new CenteredText(
							state.messageFromServer[1], 500, 500, g, true, 350);

				}

			}

			if (state == null || state.hands == null || state.deck == null) {
				// g.drawString("Starting up.", 20, 35);
				// System.out.println("waiting");

				return;
			}

			if (state.playing) {

				drawPlayerHand(myID - 1, g, 350);

				drawOtherPlayerHands(myID - 1, g);
				// drawPlayerHand(1, g, 10);
				// drawPlayerHand(2, g, 350);

				state.button.get(0).drawRectangle(g);
				state.button.get(1).drawRectangle(g);
				g.setColor(Color.YELLOW);
				g.fillRect(10, 40 + ((state.turn == myID) ? 1 : 0) * 350, 10,
						30);
				g.setColor(Color.WHITE);

				
				drawPlayerInfo(g);
//				CenteredText leftPairs = new CenteredText(""
//						+ state.restOfDeck.get(myID - 1).size(), 60, 50, g);
//
//				CenteredText rightPairs = new CenteredText(""
//						+ state.restOfDeck.get((myID == 1) ? 1 : 0).size(), 60,
//						50, g);
//
//				CenteredText leftPairNum = new CenteredText("P" + myID, 60, 50,
//						g);
//				CenteredText rightPairNum = new CenteredText("P"
//						+ ((myID == 1) ? 2 : 1), 60, 50, g);
//
//				g.drawString(leftPairs.text, 170 + leftPairs.x, 270);
//				g.drawString(rightPairs.text, 270 + rightPairs.x, 270);
//
//				g.drawString(leftPairNum.text, 170 + leftPairNum.x, 240);
//				g.drawString(rightPairNum.text, 270 + rightPairNum.x, 240);

//				drawHandCover((myID == 1) ? 2 : 1, g);
				g.setColor(Color.WHITE);
				g.setFont(new Font(customFontName, Font.PLAIN, 15));
				if (state != null) {

					CenteredText messageFromTheHub = new CenteredText(
							state.messageFromServer[1], 500, 500, g, true, 140);

					CenteredText messageFromTheHub1 = new CenteredText(
							state.messageFromServer[0], 500, 500, g, true, 170);
				}

			} else if (state.endGame) {

				g.setColor(Color.WHITE);

				g.setFont(new Font(customFontName, Font.BOLD, 60));

				CenteredText win = new CenteredText("Player " + state.winner,
						500, 500, g, true, 130);
				CenteredText win1 = new CenteredText("Wins!!", 500, 500, g,
						true, 210);

				g.setFont(new Font(customFontName, Font.BOLD, 26));

				CenteredText restart = new CenteredText("Click to Restart",
						500, 500, g, true, 350);

			}

		}
		
		public void drawPlayerInfo(Graphics g) {
			
			g.setColor(Color.WHITE);
			
			int stringSpace = 120 / state.numOfPlayers;
			int gaps = 120 / (state.numOfPlayers + 1);
			
			for (int i = 0; i < state.numOfPlayers; i++) {
			CenteredText playerPairs = new CenteredText("" + state.restOfDeck.get(myID - 1).size(), stringSpace, 50, g);

//			CenteredText rightPairs = new CenteredText("" + state.restOfDeck.get((myID == 1) ? 1 : 0).size(), stringSpace, 50, g);

			CenteredText playerPairNum = new CenteredText("P" + (i + 1), stringSpace, 50, g);
//			CenteredText rightPairNum = new CenteredText("P" + ((myID == 1) ? 2 : 1), stringSpace, 50, g);
			
			int x = 130 + gaps * (i + 1) + stringSpace * i;
			
			g.drawString(playerPairs.text, x + playerPairs.x , 270);
//			g.drawString(rightPairs.text, 270 + rightPairs.x, 270);

			g.drawString(playerPairNum.text, x + playerPairNum.x, 240);
//			g.drawString(rightPairNum.text, 270 + rightPairNum.x, 240);
			
			
			if (i + 1 == state.turn) {
				g.setColor(Color.YELLOW);
				g.fillRect(x + ((stringSpace - 40) / 2), 290, 40, 10);
				g.setColor(Color.WHITE);
			}

			
			}
			
			
			
		}

		public void drawHandCover(int pNum, Graphics g) {

			ArrayList<Card> hand = state.hands.get(pNum - 1);

			int y = 10;
			int i = 0;
			int startX = 20;
			int spacing = getSpacing(hand.size());
			for (Card card : hand) {

				int x = getXCenter(hand.size(), startX) + (spacing * i);

				g.setColor(Color.BLUE);
				g.fillRoundRect(x, y, 56, 100, 5, 5);
				g.drawRoundRect(x, y, 56, 100, 5, 5);
				g.setColor(Color.BLACK);
				g.drawRoundRect(x, y, 56, 100, 5, 5);
				i++;
			}
		}

		public void drawOtherPlayerHands(int pNum, Graphics g) {

			int j = 0;
			
			int y = 10;
			int k = 0;
			int startX = 20;
			int spacing = getSpacing(state.numOfPlayers);
			
			for (int i = 0; i < state.numOfPlayers; i++) {

				if (i != pNum) {
					k = (i > pNum) ? -1 : 0;
					int x = getXCenter(state.numOfPlayers - 1, startX) + (spacing * (i + k));					
					
					g.setColor(state.hands.get(i).getColor());
					g.fillRoundRect(x, y, 56, 100, 5, 5);
					g.drawRoundRect(x, y, 56, 100, 5, 5);
					g.setColor(Color.BLACK);
					g.drawRoundRect(x, y, 56, 100, 5, 5);

					CenteredText out = new CenteredText(""
							+ state.hands.get(i).size(), 56, 100, g);

					g.drawString(out.text, x + out.x, y + 56);
					j++;
				
					state.hands.get(i).setBounds(x, y, 56, 100);
				} else {
					state.hands.get(i).setBounds(new Rectangle());
				}
			}
		}

		public int getXCenter(int numObjects, int startX) {

			int size = numObjects;
			if (size > 7)
				size = 7;

			int width = size * 62 - 6;
			startX += (460 - width) / 2;

			return startX;
		}

		public int getSpacing(int numObjects) {

			if (numObjects < 8)
				return 62;
			int size = numObjects + 1;

			int cardWidth = size * 56;
			int space = 460 - cardWidth;
			return (int) (56 + space / (size - 1));
		}

		public void drawPlayerHand(int pNum, Graphics g, int startY) {

			ArrayList<Card> hand = state.hands.get(pNum);

			g.setFont(new Font(customFontName, Font.BOLD, 20));
			int i = 0;

			int startX = 20;

			int spacing = getSpacing(hand.size());
			for (Card card : hand) {

				int x = getXCenter(hand.size(), startX) + (spacing * i);
				int y = startY;

				CenteredText out = new CenteredText(card.getCardFace()
						+ card.getSuitIcon(), 56, 100, g);

				g.setColor(card.getColor());
				g.fillRoundRect(x, y, 56, 100, 5, 5);
				g.drawRoundRect(x, y, 56, 100, 5, 5);

				g.setColor(Color.BLACK);
				g.drawRoundRect(x, y, 56, 100, 5, 5);

				g.setColor((card.getSuit() % 2 == 0) ? Color.RED : Color.BLACK);
				g.drawString(card.getCardFace() + card.getSuitIcon(),
						x + out.x, y + 56);

				state.hands.get(myID - 1).get(i).setRectangle(x, y, 56, 100);

				i++;
			}
		}

	}

	public void makeCustomFont(String fontPath) {

		try {

			fontPath = "InfoFiles/Fonts/" + fontPath + ".ttf";

			InputStream fontStream = new BufferedInputStream(
					new FileInputStream(fontPath));

			GraphicsEnvironment ge = GraphicsEnvironment
					.getLocalGraphicsEnvironment();
			customFont = Font.createFont(Font.TRUETYPE_FONT, fontStream)
					.deriveFont(Font.BOLD);

			ge.registerFont(customFont);

			customFontName = customFont.getFamily();

			String[] defaultFonts = { "Serif", "SansSerif", "Monospace",
					"Dialog", "DialogInput" };

			for (int i = 0; i < defaultFonts.length; i++) {
				if (customFontName.contains(defaultFonts[i])) {

					customFontName = customFontName.substring(0,
							customFontName.indexOf(defaultFonts[i]) - 1);

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean checkIfValidPairs(ArrayList<Card> selectedCards) {

		boolean allSame = true;

		int i = 1;
		while (i < selectedCards.size() && allSame) {

			allSame = allSame
					&& selectedCards.get(i - 1).getCard() == selectedCards.get(
							i).getCard();

			i++;
		}

		return allSame && selectedCards.size() > 1;

	}

	public ArrayList<Card> getSelected() {

		ArrayList<Card> selected = new ArrayList<Card>();

		for (Card currentCard : state.hands.get(myID - 1)) {

			if (currentCard.selected)
				selected.add(currentCard);
		}

		return selected;
	}
	
	public ArrayList<Hand> getSelectedHands() {

		ArrayList<Hand> selected = new ArrayList<Hand>();

		for (Hand currentHand : state.hands) {

			if (currentHand.selected)
				selected.add(currentHand);
		}

		return selected;
	}

	public void goFish() {

		if (!state.deck.isEmpty()) {
			state.hands.get(myID - 1).add(state.deck.get(0));
			state.deck.remove(0);
		} else {
			int highestPairs = 0;
			int highestPlayer = 0;
			int i = 1;
			for (ArrayList<Card> playerPairs : state.restOfDeck) {

				if (playerPairs.size() > highestPairs) {
					highestPairs = playerPairs.size();
					highestPlayer = i;
				}

				i++;
			}
			setWon(highestPlayer);

		}
		sortCards();

	}

	/**
	 * Creates and configures the window, opens a connection to the server, and
	 * makes the widow visible on the screen. This constructor can block until
	 * the connection is established.
	 * 
	 * @param hostName
	 *            the name or IP address of the host where the server is
	 *            running.
	 * @param serverPortNumber
	 *            the port number on the server computer when the Hub is
	 *            listening for connections.
	 * @throws IOException
	 *             if some I/O error occurs while trying to open the connection.
	 * @throws Client.DuplicatePlayerNameException
	 *             it playerName is already in use by another player in the
	 *             game.
	 */
	public GoFishWindow(String hostName, int serverPortNumber)
			throws IOException {
		super("Network Go Fish");
		connection = new GoFishClient(hostName, serverPortNumber);
		myID = connection.getID();

		makeCustomFont(Font_File_Name);

		board = new Board();
		message = new JLabel("Waiting for two players to connect.",
				JLabel.CENTER);
		board.setBackground(Color.BLACK);
		board.setPreferredSize(new Dimension(500, 500));
		board.addMouseListener(new MouseAdapter() { // A mouse listener to
													// respond to user's clicks.
			public void mousePressed(MouseEvent evt) {
				doMouseClick(evt.getX(), evt.getY());
			}
		});
		board.addKeyListener(new KeyListener() {

			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_C) {
					cheat = !cheat;

				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

		});
		message.setBackground(Color.LIGHT_GRAY);
		message.setOpaque(true);
		JPanel content = new JPanel();
		content.setLayout(new BorderLayout(2, 2));
		content.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		content.setBackground(Color.GRAY);
		content.add(board, BorderLayout.CENTER);
		content.add(message, BorderLayout.SOUTH);
		setContentPane(content);
		pack();
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			// When the user clicks the window's close box, this listener will
			// send a disconnect message to the Hub and will end the program.
			// The other player will then be notified that this player has
			// disconnected.
			public void windowClosing(WindowEvent evt) {
				dispose();
				connection.disconnect(); // Send a disconnect message to the
											// hub.
				try {
					Thread.sleep(333); // Wait one-half second to allow the
										// message to be sent.
				} catch (InterruptedException e) {
				}
				System.exit(0);
			}
		});
		setLocation(30, 100);
		setVisible(true);
		board.repaint();
	}

	public boolean checkIfWon() {

		int i = 1;
		for (ArrayList<Card> hand : state.hands) {

			if (hand.isEmpty()) {
				setWon(i);
				return true;

			}
			i++;
		}
		return false;
	}

	public void asking() {
		if (!getSelected().isEmpty() && !getSelectedHands().isEmpty()) {
			Card selectedCard = getSelected().get(0);
			Hand currentHand = getSelectedHands().get(0);
			ArrayList<Card> matchingCards = new ArrayList<Card>();
			
					for (Card currentCard : currentHand) {

						if (selectedCard.getCard() == currentCard.getCard()) {
							matchingCards.add(currentCard);
						}
					}
				
				for (Card matchCard : matchingCards) {
					currentHand.remove(matchCard);
				}
			

			state.hands.get(myID - 1).addAll(matchingCards);

			sortCards();
			newMessageLog("Player " + myID + " asked for a "
					+ selectedCard.getCardFace());
			if (matchingCards.isEmpty())
				nextTurn();
		}
	}

	public void setWon(int i) {
		state.winner = i;
		state.won = true;
		state.playing = false;
		state.endGame = true;
		board.repaint();
		connection.send(state);

	}

	public void nextTurn() {

		goFish();
		// sortCards();
		state.turn++;
		if (state.turn > state.numOfPlayers)
			state.turn = 1;

		newMessageLog("Player " + myID + " drew a Card. Next player");
		connection.send(state);

	}

	public void pairings() {

		ArrayList<Card> selectedCards = new ArrayList<Card>();
		selectedCards = getSelected();

		if (getSelected().size() > 2 && getSelected().size() % 2 != 0) {

			selectedCards.subList(2, selectedCards.size()).clear();

		}

		if (checkIfValidPairs(selectedCards)) {

			for (Card currentCard : selectedCards) {

				state.restOfDeck.get(myID - 1).add(currentCard);
				for (ArrayList<Card> cardAL : state.hands) {

					cardAL.remove(currentCard);
				}
			}

			newMessageLog("Player " + myID + " paired " + selectedCards.size()
					+ " " + selectedCards.get(0).getCardFace() + "s");
		}
	}

	public void newMessageLog(String theMessage) {

		state.messageFromServer[1] = state.messageFromServer[0];
		state.messageFromServer[0] = theMessage;

	}

	public void resetColors() {

		for (Hand currentHand : state.hands) {
			currentHand.selected = false;
			currentHand.setColor(Color.CYAN);
			for (Card currentCard : currentHand) {

				currentCard.selected = false;
				currentCard.setColor(Color.WHITE);

			}

		}

	}

	public void sortCards() {

		for (ArrayList<Card> theCards : state.hands) {

			Collections.sort(theCards, Card.CardSuitComparator);
			Collections.sort(theCards, Card.CardNumComparator);
		}

	}

	/**
	 * This method is called when the user clicks the tictactoe board. If the
	 * click represents a legal move at a legal time, then a message is sent to
	 * the Hub to inform it of the move. The Hub will change the game state and
	 * send the new state to both players. It is very important that the game
	 * clients do not change the game state directly, since the "official" game
	 * state is maintained by the Hub. Doing things this way guarantees that
	 * both players see the same board.
	 */
	private void doMouseClick(int x, int y) {
		if (!(state == null || state.hands == null || state.deck == null)
				&& state.playing && state.turn == myID) {

			if (state.turn == myID) {
				if (!checkIfWon() && state.playing) {

					highlightClickedCards(x, y);
					
					highlightClickedHands(x, y);

					doClickedButtonAction(x, y);

					connection.send(state);
					board.repaint();
				}
			}
		} else if (state.endGame) {
			// After a game ends, the winning player -- or either
			// player in the event of a tie -- can start a new
			// game by clicking the board. When this happens,
			// the String "newgame" is sent as a message to Hub.
			if (myID == state.winner) {

				connection.send("newgame"); // Start a new game.
			}
		}

	}

	private void highlightClickedHands(int x, int y) {
		// TODO Auto-generated method stub
		
		for (Hand r : state.hands) {
			
			if (r.getBounds().contains(new Point(x, y))) {

				r.selected = !r.selected;
				r.setColor((r.selected) ? Color.RED : Color.CYAN);
			}
			
			
		}
		
		
		
	}

	public void highlightClickedCards(int x, int y) {

		for (ArrayList<Card> aHand : state.hands) {
			for (Card r : aHand) {
				if (r.getRectangle().contains(new Point(x, y))) {

					r.selected = !r.selected;
					r.setColor((r.selected) ? Color.YELLOW : Color.WHITE);
				}
			}

		}

	}

	public void doClickedButtonAction(int x, int y) {

		for (Button b : state.button) {

			if (b.getButton().contains(new Point(x, y))) {

				if (b.getText().equals("Pair")) {

					pairings();

				} else if (b.getText().equals("Ask")) {

					asking();

				}
				resetColors();
			}
		}

	}

	/**
	 * This method is called when a new game state is received from the hub. It
	 * stores the new state in the instance variable that represents the game
	 * state and updates the user interface to reflect the state. Note that this
	 * method is called on the GUI event thread (using
	 * SwingUtilitites.invokeLater()) to avoid synchronization problems.
	 * (Synchronization is an issue when a method that manipulates the GUI is
	 * called from a thread other than the GUI event thread. In this problem,
	 * there is also the problem that a message can actually be received before
	 * the constructor has completed, which would lead to errors in this method
	 * from uninitialized variables, if SwingUtilities.invokeLater() were not
	 * used.)
	 */
	private void newState(GoFishGameState state) {
		if (state.playerDisconnected) {
			JOptionPane.showMessageDialog(this,
					"Your opponent has disconnected.\nThe game is ended.");
			System.exit(0);
		}
		this.state = state;
		board.repaint();
		if (state.hands == null || state.deck == null) {
			return; // haven't started yet -- waiting for 2nd player
		} else if (state.endGame) {
			setTitle("Game Over");
			if (myID == state.winner)
				message.setText("You won!  Click to start a new game.");
			else
				message.setText("You lost.  Waiting for new game...");
		} else {
			if (myID == 1) {
				setTitle("You are Player " + connection.getID());
			} else {
				setTitle("You are Player " + connection.getID());
			}
			if (myID == state.turn) {
				message.setText("Your move");
			} else {
				message.setText("Waiting for opponent's move");
			}
		}
	}

}
