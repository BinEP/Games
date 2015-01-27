package networkGoFish;

import goFishCommons.Button;
import goFishCommons.Card;
import goFishCommons.Winner;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This class holds all the necessary information to represent the state of a
 * game of networked TicTacToe. It includes the method
 * apply(hub,sender,message), which modifies the state to reflect a message that
 * was received from a player. The protocol is that two types of messages from
 * client are understood. One is that a TicTacToe client sends the String
 * "newgame" as a message when it wants to start a new game. The other is that
 * when the user makes a mover into one of the squares on the board, the client
 * sends an array of two ints containing the row and column where the user
 * played. Note that to keep things simple, each time a game is started, this
 * class decides at random which of the two players will play 'X' and which will
 * play 'O'. X always makes the first move.
 */
public class GoFishGameState implements Serializable {

	// -------------- state variables recording the state of the game
	// -------------------

	// public boolean playerDisconnected; // This is true if one of the two
	// players has left the game
	// // The new state, with this value set to true, is sent to
	// // the other player as a signal that the game is over. That
	// // client will respond by ending the program.
	//
	// public char[][] board; // The contents of the board. Values are ' ', 'X',
	// or 'O'
	// // This variable is null before the first game starts.
	//
	// public boolean gameInProgress; // True while a game is being played;
	// // false before first game and between games.
	//
	// // The next three variables are meant for use while a game is in
	// progress.
	// // Note that the ID numbers of the players will always be 1 and 2.
	//
	// public int playerPlayingX; // The ID of the player who is playing X.
	// public int playerPlayingO; // The ID of the player who is playing O.
	// public int currentPlayer; // The ID of the player who is to make the next
	// move.
	//
	// // The next two variables are meant for use between games.
	//
	// public boolean gameEndedInTie; // Tells whether the game ended in a tie.
	// public int winner; // The name of winner of the game that just ended, if
	// it was not a tie.
	//
	//
	public ArrayList<Card> deck = new ArrayList<Card>();
	public int numOfPlayers = 2;
	public ArrayList<ArrayList<Card>> hands = new ArrayList<ArrayList<Card>>(
			numOfPlayers);
	public ArrayList<Button> button = new ArrayList<Button>();
	public ArrayList<ArrayList<Card>> restOfDeck = new ArrayList<ArrayList<Card>>();

	public int turn;

	public boolean startGame = true;
	public boolean playing = false;
	public boolean endGame = false;

	public int winner;
	public boolean won = false;

	public int[] playerNumOfCards;
	public Winner playerWon;
	public boolean playerDisconnected;
	public String[] messageFromServer = {" ", " "};
	public boolean netGame = true;

	// ----------- the method that is called by the Hub to react to messages
	// from the players -----------

	/**
	 * Respond to a message that was sent by one of the players to the hub. Note
	 * that illegal messages (of the wrong type or coming at an illegal time)
	 * are simply ignored. The messages that are understood are the string
	 * "newgame" for starting a new game and an array of two ints giving the row
	 * and column of a move that the user wants to make.
	 * 
	 * @param sender
	 *            the ID number of the player who sent the message.
	 * @param message
	 *            the message that was received from that player.
	 */
	public void applyMessage(int sender, Object message) {
		
		if (message instanceof GoFishGameState) {

			GoFishGameState theState = (GoFishGameState) message;

			playerNumOfCards = theState.playerNumOfCards;
			deck = theState.deck;
			turn = theState.turn;
			
			restOfDeck = theState.restOfDeck;
			// setHandSizes(playerNumOfCards);
			// newHands();
			// hands.set(connection.getID() - 1, state.hand);
			// hands.set(connection.getID() - 1, state.hand);
			hands = theState.hands;
			startGame = theState.startGame;
			playing = theState.playing;
			endGame = theState.endGame;
			won = theState.won;
			messageFromServer = theState.messageFromServer;
			checkIfWon();
			resetColors();
			System.out.println(hands.toString());

		} else if (message instanceof String) {
			
			if (message.equals("newgame")) newGame();
			
			
			
		}
	}

	

	public void resetColors() {

		int i = 0;
		for (ArrayList<Card> currentHand : hands) {
			if (turn - 1 != i) {

				for (Card currentCard : currentHand) {

					currentCard.selected = false;
					currentCard.setColor(Color.WHITE);

				}
			}
			i++;
		}

	}
	
	public boolean checkIfWon() {

		int i = 1;
		for (ArrayList<Card> hand : hands) {

			if (hand.isEmpty()) {
				setWon(i);
				return true;

			}
			i++;
		}
		return false;
	}
	
	public void setWon(int i) {
		winner = i;
		won = true;
		playing = false;
		endGame = true;
		
		

	}

	
	public void newDeck() {
		Card card = new Card();
		for (int i = 0; i < 52; i++) {
			while (deck.contains(card)) {
				card = new Card();
			}
			deck.add(card);
		}
	}

	public void newHands() {
		for (int n = 0; n < numOfPlayers; n++) {
			ArrayList<Card> hand = new ArrayList<Card>();
			for (int i = 0; i < 7; i++) {
				hand.add(deck.get(0));
				deck.remove(0);
			}
			
			hands.add(hand);
			sortCards();
		}
		System.out.println(hands);
	}

	public void deckPairsSetup() {

		restOfDeck.clear();
		for (int i = 0; i < numOfPlayers; i++) {
			restOfDeck.add(new ArrayList<Card>());
		}
	}

	public void newGame() {

		deck.clear();
		hands.clear();
		restOfDeck.clear();
		button.clear();
		turn = 1;
		playing = true;
		endGame = false;
		startGame = false;
		
		messageFromServer[1] = "New Deck made";
		messageFromServer[0] = "Hands dealt";
		
		newDeck();
		newHands();
		deckPairsSetup();
		setUpButtons();

	}

	public void setUpButtons() {

		button.add(new Button("Pair", 370, 250, 80, 50));
		button.add(new Button("Ask", 50, 250, 80, 50));
	}

	public void shuffleDeck() {

		Collections.shuffle(deck);
	}

	public void sortCards() {

		for (ArrayList<Card> theCards : hands) {

			Collections.sort(theCards, Card.CardSuitComparator);
			Collections.sort(theCards, Card.CardNumComparator);
		}

	}

	/**
	 * This package private method is called by the hub when the second player
	 * connects. It's purpose is to start the first game.
	 */
	void startFirstGame() {
		newGame();
	}

}
