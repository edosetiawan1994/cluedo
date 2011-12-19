package control.ai;

import java.util.HashSet;
import java.util.Set;

import control.Card;
import control.Player;

public class PlayerAssumption {
	
	private Player player;
	private Set<Card> possibleHandCards;
	private Set<Card> certainHandCards;
	
	/**
	 * Sole constructor. Initialize internal data structures. 
	 * 
	 * @param player associated player instance
	 * @throws NullPointerException if player is null
	 */
	public PlayerAssumption(Player player) throws NullPointerException {
		if (player == null) {
			throw new NullPointerException();
		}
		this.player = player;
		this.possibleHandCards = new HashSet<Card>();
		this.certainHandCards = new HashSet<Card>();
		this.possibleHandCards.addAll(Card.generateAllCards());
	}
	
	/**
	 * Remove a card from the set of possible cards. If this set does not
	 * contain this card, do nothing.
	 * 
	 * @param card card to remove
	 * @throws NullPointerException if card is null
	 */
	public void removePossibleCard(Card card) throws NullPointerException {
		if (card == null) {
			throw new NullPointerException();
		}
		this.possibleHandCards.remove(card);
	}
	
	/**
	 * Add a certain hand card. Assert that this card is a possible hand card.
	 * If after adding this card we have as much certain cards as player hand
	 * cards, remove all possible hand cards.
	 *  
	 * @param card
	 * @throws NullPointerException if card is null
	 */
	public void addCertainCard(Card card) throws NullPointerException {
		if (card == null) {
			throw new NullPointerException();
		}
		assert this.possibleHandCards.contains(card);
		this.removePossibleCard(card);
		this.certainHandCards.remove(card);
		if (this.certainHandCards.size() == this.player.countHandCards()) {
			this.possibleHandCards.clear();
		}
	}

	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @return the possibleHandCards
	 */
	public Set<Card> getPossibleHandCards() {
		return possibleHandCards;
	}

	/**
	 * @return the certainHandCards
	 */
	public Set<Card> getCertainHandCards() {
		return certainHandCards;
	}
}
