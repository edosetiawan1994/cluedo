package control;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import uitmp.UIController;

/**
 * This class contains the overall game logic of Cluedo. It controls the game
 * flow and the communication between players. The class Player provides proper
 * methods for notifying players about different events or letting them play
 * their round. All these methods are called by this class.
 * 
 * @see control.Player
 */
public class Game {
	
	private List<Player> players;
	private Suggestion solution;
	private Player currentPlayer;
	private Iterator<Player> playerIt;
	private int nPlayers;
	private UIController ui;
	private int nextMoveCount;
	
	/**
	 * Starts a game without executing the first move.
	 * 
	 * @param players all players in the game
	 * @see #nextMove()
	 */
	public void start(List<Player> players) {
		ui = UIController.getSingleton();
		ui.newLogMessage("Start game with " + players.size() + " players.");
		this.players = players;
		nPlayers = players.size();
		nextMoveCount = nPlayers;
		playerIt = players.iterator();
		List<Card> cards = Card.generateAllCards();
		Collections.shuffle(cards);
		solution = Suggestion.getRandomSuggestion(cards);
		int from = 0, to = 0;
		final int nCards = cards.size();
		final int cardsPerPlayer = nCards / nPlayers;
		int nRemaningPlayers = nPlayers;
		for (Player player : players) {
			nRemaningPlayers--;
			to = from + cardsPerPlayer;
			if (nCards - to > cardsPerPlayer * nRemaningPlayers) {
				to++;
			}
			ui.newLogMessage(player.getName() + " gets "
					+ (to - from) + " hand cards.");
			player.beginGame(new HashSet<Card>(cards.subList(from, to)));
			from = to;
		}	
	}
	
	/* (non-Javadoc)
	 * This method handles circular iteration. If the iterator has no next
	 * element, it is set to the begin of players. The next player is returned
	 * then.
	 */
	private Player nextPlayer() {
		if (!playerIt.hasNext()) {
			playerIt = players.iterator();
		}
		return playerIt.next();
	}
	
	/**
	 * Execute the next move. Ask the next player for a suggestion and deliver
	 * it to the other players. The move is done when all the other players have
	 * been asked or a player answered.
	 */
	public void nextMove() {
		boolean disproved = false;
		currentPlayer = nextPlayer();
		Suggestion sugg = currentPlayer.play();
		ui.newLogMessage(currentPlayer.getName() 
				+ ": \"I suggest it was " + sugg.toString() + ".\"");
		Set<Player> couldNotAnswer = new HashSet<Player>();
		Player answerer = null;
		Card card = null;
		for (int i = 1; i < nPlayers; i++) {
			Player askedPlayer = nextPlayer();
			if (disproved) {
				continue;
			}
			card = askedPlayer.receiveSuggestion(currentPlayer, sugg);
			if (card != null) {
				ui.newLogMessage(askedPlayer
						+ " shows a card to " + currentPlayer + ".");
				answerer = askedPlayer;
				disproved = true;
			} else {
				ui.newLogMessage(askedPlayer
						+ " cannot disprove this suggestion.");
				couldNotAnswer.add(askedPlayer);
			}
		}
		nextPlayer();
		currentPlayer.receiveAnswer(sugg, card, answerer, couldNotAnswer);
		for (int i = 1; i < nPlayers; i++) {
			Player player = nextPlayer();
			player.observeMove(sugg, currentPlayer, answerer, couldNotAnswer);
		}
		nextPlayer();
		nextMoveCount++;
	}

	/**
	 * This method reflects the design pattern Mediator. Game acts as mediator
	 * between players - this method can be used to get all players in a game
	 * without coupling the players together. Note that this is not exactly the
	 * GoF Mediator since it allows direct access to other players.
	 * 
	 * @return set of players
	 */
	public List<Player> getPlayers() {
		return players;
	}
	
	/**
	 * This method is called if a player wants to solve. If the suggestion is
	 * correct, this player wins. If not, [s]he looses. The game ends anyway
	 * (not like in the original game). However, since we have only AI players,
	 * this situation should not occur.
	 * 
	 * @param player Player who tries to solve
	 * @param suggestion his/her solution
	 * @throws NullPointerException if one of the parameters is null
	 */
	public void playerSolves(Player player, Suggestion suggestion) 
			throws NullPointerException {
		if (player == null || suggestion == null) {
			throw new NullPointerException();
		}
		ui.playerSolves(player, nextMoveCount / nPlayers, suggestion,
				solution.getPerson().equals(suggestion.getPerson())
				 && solution.getWeapon().equals(suggestion.getWeapon())
				 && solution.getRoom().equals(suggestion.getRoom()));
	}
}
