package control;

import java.util.HashSet;
import java.util.Set;

/**
 * This class represents a player in a Cluedo game. Note that this is a 
 * abstract class, meaning that you have to implement the player's 
 * behavior by your own (i.e. AI or using a user interface). Furthermore,
 * it can be seen as colleague (GoF Mediator) with Game as mediator.
 *
 * @see control.Game
 * @see control.Game#getPlayers()
 * @see control.ai.AIPlayer
 * @see control.StupidPlayer
 */
public abstract class Player {

	private String name;
	private int id;
	protected Set<Card> handCards;
	protected Game game;
	
	/**
	 * Sole constructor.
	 * 
	 * @param game Game the player belongs to
	 * @param name Name of the player
	 * @throws NullPointerException
	 */
	public Player(Game game, String name, int id) throws NullPointerException {
		if (game == null || name == null) {
			throw new NullPointerException();
		}
		this.handCards = new HashSet<Card>();
		this.game = game;
		this.name = name;
		this.id = id;
	}
	
	/**
	 * Set the hand cards of this player. This should be only done at the
	 * beginning of the game.
	 * 
	 * @param handCards list of hand cards
	 * @see control.Card
	 * @throws NullPointerException
	 */
	public void beginGame(Set<Card> handCards) 
			throws NullPointerException {
		if (handCards == null) {
			throw new NullPointerException();
		}
		this.handCards = handCards;
	}
	
	/**
	 * Get the number of hand cards (equal to the cardinality of the
	 * argument in the last call of beginGame(), 0 default)
	 * 
	 * @return size of this.handCards
	 */
	public int countHandCards() {
		return this.handCards.size();
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @return the handCards
	 */
	public Set<Card> getHandCards() {
		return handCards;
	}

	/**
	 * This method indicates that the players turn has begun. Therefore, the
	 * player has to announce a suggestion when this method is called. The
	 * player receives the answer from the game logic via receiveAnswer
	 * 
	 * @see #receiveAnswer(Suggestion, Card, Player, Set)
	 * @return the suggestion the player announces
	 */
	public abstract Suggestion play();
	
	/**
	 * When this method is called, the player is ask to disprove a suggestion.
	 * Returns null if the player is not able to disprove it, a hand card
	 * otherwise.
	 * 
	 * @param questionair player who announced the suggestion
	 * @param suggestion Suggestion to disprove
	 * @return null if cannot disprove or a disproving Card
	 * @throws NullPointerException if an argument is null
	 */
	public abstract Card receiveSuggestion(Player questionair,
			Suggestion suggestion) throws NullPointerException;
	
	/**
	 * Call this method to notify the player about the outcome of his/her
	 * last announced suggestion.
	 * 
	 * @param suggestion subjected suggestion
	 * @param card card which was shown by answerer
	 * @param answerer player which answered
	 * @param couldNotAnswer set of players which could not answer
	 * @see #observeMove(Suggestion, Player, Player, Set)
	 * @throws NullPointerException if suggestion is null
	 */
	public abstract void receiveAnswer(Suggestion suggestion, Card card,
			Player answerer, Set<Player> couldNotAnswer)
			throws NullPointerException;
	
	/**
	 * This method is called when a player show another player a card hidden from
	 * this player.
	 * 
	 * @param suggestion subjected suggestion
	 * @param questionair asking player
	 * @param answerer answering player
	 * @param couldNotAnswer set of players which could not answer
	 * @throws NullPointerException if suggestion or couldNotAnswer are null
	 */
	public abstract void observeMove(Suggestion suggestion, Player questionair,
			Player answerer, Set<Player> couldNotAnswer)
			throws NullPointerException;

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return 31 + id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Player)) {
			return false;
		}
		return id == ((Player) obj).id;
	}
}
