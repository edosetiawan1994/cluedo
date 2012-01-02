package control.ai;

import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.List;

import ui.UIController;

import control.Card;
import control.Player;
import control.Suggestion;

/**
 * This class maintains the knowledge about hand cards of other players. It
 * stores a list of certain and possible hand cards and notifies its observers
 * whenever a new hand card is certainly derived. Observers are other instances
 * of PlayerAssumption or the SearchSpace. The methods removePossibleCard() and
 * addCertainCard() contain some simple hard-coded logic for direct conclusions
 * (for example if all hand cards are known, there are no possible hand cards
 * anymore).
 * 
 * @see control.Player
 * @see #removePossibleCard(Card)
 * @see #addCertainHandCard(Card)
 * @see java.util.Observable
 */
public class PlayerAssumption extends Observable implements Observer {

	private Player player;
	private Set<Card> possibleHandCards;
	private Set<Card> certainHandCards;
	
	/* (non-Javadoc)
	 * The UIController singleton if this AI player assumption should be 
	 * displayed in the UI, null otherwise. 
	 */
	private UIController ui;
	
	/* (non-javadoc)
	 * This CNF represents the knowledge base for the hand cards of this
	 * player. Note that one literal clauses are automatically removed
	 * (that means removed from possibleHandCards or added to certainHandCards)
	 */
	private CNF<Card> kb;
	
	/**
	 * Sole constructor. Initialize internal data structures. 
	 * 
	 * @param player associated player instance
	 * @param displayUI if this AI player should be displayed in the UI
	 * @throws NullPointerException if player is null
	 */
	public PlayerAssumption(Player player, boolean displayUI)
			throws NullPointerException {
		if (player == null) {
			throw new NullPointerException();
		}
		ui = displayUI ? UIController.getSingleton() : null;
		this.player = player;
		this.possibleHandCards = new HashSet<Card>();
		this.certainHandCards = new HashSet<Card>();
		this.possibleHandCards.addAll(Card.generateAllCards());
		this.kb = new CNF<Card>();
	}
	
	/**
	 * Remove a card from the set of possible cards. If this set does not
	 * contain this card, do nothing. If after adding this card, we have as 
	 * much possible cards as free player's hand card slots, add them to
	 * certainHandCards and remove them from possible hand cards.
	 * 
	 * @param card card to remove
	 * @throws NullPointerException if card is null
	 */
	public void removePossibleCard(Card card) throws NullPointerException {
		if (card == null) {
			throw new NullPointerException();
		}
		this.possibleHandCards.remove(card);
		if (this.certainHandCards.size() + this.possibleHandCards.size() 
				== this.player.countHandCards()) {
			this.certainHandCards.addAll(possibleHandCards);
			possibleHandCards.clear();
			// Notify about more cards than necessary, but otherwise we have
			// conflicts with the removal mechanism in addCertainHandCard()
			for (Card certainCard : certainHandCards) {
				this.setChanged();
				this.notifyObservers(certainCard);
			}
		}
		
		kb.addNewFact(new Literal<Card>(card, false));
		
		List<Literal<Card>> facts = kb.getNewFacts();
		Set<Literal<Card>> alreadyAddedFacts = 
				new HashSet<Literal<Card>>();
		while (!facts.isEmpty()) {
			Literal<Card> l = facts.get(0);
			facts.remove(0);
			if (l.getSign() && !alreadyAddedFacts.contains(l)) {
				// we have found new certain hand card
				addCertainHandCard(l.getValue());
				alreadyAddedFacts.add(l);
				facts.addAll(kb.getNewFacts());
			}
		}
		
		if (ui != null) {
			ui.updatePossibleHandCardsPanel(player, possibleHandCards);
			ui.updateCNFPanel(player, kb.toString());
		}
	}
	
	/**
	 * Add a certain hand card. Assert that this card is a possible hand card.
	 * If after adding this card we have as much certain cards as player hand
	 * cards, remove all possible hand cards.
	 *  
	 * @param card
	 * @throws NullPointerException if card is null
	 */
	public void addCertainHandCard(Card card) throws NullPointerException {
		if (card == null) {
			throw new NullPointerException();
		}
		if (!this.possibleHandCards.contains(card)) {
			return; // Already added / not possible
		}
		this.certainHandCards.add(card);
		//this.removePossibleCard(card); <- not necessary
		this.possibleHandCards.remove(card);
		this.setChanged();
		this.notifyObservers(card);
		if (this.certainHandCards.size() == this.player.countHandCards()) {
			this.possibleHandCards.clear();
		}
		
		// remove all clauses with card = true
		kb.addNewFact(card, true);
		
		if (ui != null) {
			ui.updateCertainHandCardsPanel(player, certainHandCards);
			ui.updateCNFPanel(player, kb.toString());
		}
	}
	
	/**
	 * Call this method when the subjected player answered a suggestion hidden
	 * from the AI player. It will add a suitable clause to the knowledge base
	 * if none of the cards in the suggestion are in the certain hand cards.
	 * 
	 * @param sugg suggestion to add
	 * @throws NullPointerException if the parameter is null or one of the card
	 * 		in the suggestion is null
	 */
	public void addAnsweredSuggestion(Suggestion sugg) 
			throws NullPointerException {
		Card[] cards = {sugg.getPerson(), sugg.getWeapon(), sugg.getRoom()};
		Clause<Card> clause = new Clause<Card>();
		for (Card card : cards) {
			if (certainHandCards.contains(card)) {
				return;
			}
			if (possibleHandCards.contains(card)) {
				clause.addLiteral(card, true);
			}
		}
		List<Literal<Card>> literals = clause.getLiterals();
		if (literals.size() == 1) { // New certain hand card
			addCertainHandCard(literals.get(0).getValue());
		} else if (!clause.isEmpty()) { // New clause
			kb.addClause(clause);
			if (ui != null) {
				ui.updateCNFPanel(player, kb.toString());
			}
		}
	}
	
	/**
	 * This method is called whenever a certain card is added somewhere else.
	 * We can then exclude this card from our possible cards pool.
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 * @throws NullPointerException if arg is NULL
	 * @throws IllegalArgumentException if arg is not a Card
	 */
	@Override
	public void update(Observable o, Object arg) {
		if (arg == null) {
			throw new NullPointerException();
		}
		if (!(arg instanceof Card)) {
			throw new IllegalArgumentException();
		}
		this.removePossibleCard((Card) arg);
	}

	/**
	 * Returns if this player is fully explored, meaning that we know each of
	 * his/her hand cards.
	 * 
	 * @return TRUE if we know all hand cards, FALSE otherwise
	 */
	public boolean isFullyExplored() {
		return possibleHandCards.isEmpty();
	}

	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @return the knowledge base for players hand cards 
	 */
	public CNF<Card> getKb() {
		return kb;
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Assumption about " + player;
	}
}
