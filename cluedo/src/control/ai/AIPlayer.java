package control.ai;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Set;

import control.Card;
import control.Game;
import control.Player;
import control.Suggestion;

/**
 * This class is the AI implementation of the Player class and the entry point
 * for the control.ai package. All AI related tasks are initiated by this
 * class.
 * 
 * @see control.Player
 */
public class AIPlayer extends Player {

	/* (non-javadoc)
	 * Note: assumptions may not correspond to Game.players in terms of
	 * ordering. The first element in assumptions represents the left neighbor
	 * of the AIPlayer 
	 */
	private List<PlayerAssumption> assumptions;
	
	/* (non-Javadoc)
	 * Stores the current search space of possible solutions.
	 */
	private SearchSpace searchSpace;
	
	/* (non-Javadoc)
	 * TRUE if this AI player should be displayed in the UI. 
	 */
	private boolean displayUI;
	
	/**
	 * Sole constructor. Calls the super class constructor and initialize
	 * class intern data structures.
	 * {@inheritDoc}
	 * @param displayUI if this AI player should be displayed in the UI
	 */
	public AIPlayer(Game game, String name, int id, boolean displayUI)
			throws NullPointerException {
		super(game, name, id);
		this.displayUI = displayUI;
		assumptions = new LinkedList<PlayerAssumption>();
		searchSpace = new SearchSpace();
	}

	/**
	 * @return the searchSpace
	 */
	public SearchSpace getSearchSpace() {
		return searchSpace;
	}



	/* (non-Javadoc)
	 * @see control.Player#beginGame(java.util.Set)
	 */
	@Override
	public void beginGame(Set<Card> handCards) throws NullPointerException {
		super.beginGame(handCards);
		// Generate assumptions, starting with left neighbor
		assumptions.clear();
		List<Player> players = this.game.getPlayers();
		boolean thisPlayerPassed = false; 
		final int numPlayer = players.size();
		for (int i = 0, j = 1; j < numPlayer; i = (i + 1) % numPlayer) {
			if (thisPlayerPassed) {
				assumptions.add(new PlayerAssumption(players.get(i),
						displayUI));
				j++;
			} else if (this.equals(players.get(i))) {
				thisPlayerPassed = true;
			}
		}
		// Player assumptions are observed by searchSpace and each other
		Observable o = new Observable();
		o.addObserver(searchSpace);
		for (PlayerAssumption assumption : assumptions) {
			assumption.addObserver(searchSpace);
			o.addObserver(assumption);
			for (PlayerAssumption otherAssumption : assumptions) {
				if (otherAssumption != assumption) {
					assumption.addObserver(otherAssumption);
				}
			}
		}
		// Inform all about own hand cards
		for (Card card : handCards) {
			o.notifyObservers(card);
		}
	}

	/**
	 * Includes reasoning about how to shrink the search space the most and how
	 * to formulate this as a suggestion.
	 * The basic approach is as follows:
	 * 	- For each kind, fetch possible solution cards from search space
	 *  - Rank each of these cards
	 *  - Increase rank of card each time it occurs in PlayerAssumptions CNF
	 *  	- Increase more if the player sits close to us
	 *  - Suggest the best ranked cards of each kind 
	 * {@inheritDoc}
	 * @see control.Player#play()
	 */
	@Override
	public Suggestion play() {
		Set<Card> cards = searchSpace.getPossibleCards();
		Suggestion suggestion = new Suggestion(
				searchSpace.getSolutionPerson(),
				searchSpace.getSolutionWeapon(),
				searchSpace.getSolutionRoom());
		if (suggestion.isComplete()) {
			game.playerSolves(this, suggestion);
		}
		
		// Look for unknown cards frequent in other players CNF
		HashMap<Card, Integer> ranks = new HashMap<Card, Integer>();
		int bestRanks[] = {-1, -1, -1}; // Dependent on Kind.size!
		for (Card card : cards) {
			ranks.put(card, 1);
		}
		int inc = assumptions.size() + 1;
		for (PlayerAssumption assumption : assumptions) {
			CNF<Card> cnf = assumption.getKb();
			HashMap<Literal<Card>, Integer> literals = cnf.getAllLiterals();
			for (Map.Entry<Literal<Card>, Integer> entry 
					: literals.entrySet()) {
				Card card = entry.getKey().getValue();
			    ranks.put(card, ranks.get(card) + inc * entry.getValue());
			}
			inc--;
		}
		for (Map.Entry<Card, Integer> entry : ranks.entrySet()) {
			int rank = entry.getValue();
			Card card = entry.getKey();
			if (rank > bestRanks[card.getKind().ordinal()]) {
				suggestion.setCard(card);
				bestRanks[card.getKind().ordinal()] = rank; 
			}
		}
		return suggestion;
	}

	/**
	 * Decide which card (if any) should be shown. Takes into account the
	 * knowledge about other players hand cards.
	 * {@inheritDoc}
	 * @see control.Player#receiveSuggestion(control.Suggestion)
	 */
	@Override
	public Card receiveSuggestion(Player questionair, Suggestion suggestion)
			throws NullPointerException {
		if (questionair == null || suggestion == null) {
			throw new NullPointerException();
		}
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Feed the information gained by receiving this answer to the internal
	 * data structures.
	 * {@inheritDoc}
	 * @see control.ai.PlayerAssumption
	 * @see control.Player#receiveAnswer(control.Suggestion, control.Card,
	 * 				control.Player, java.util.Set)
	 */
	@Override
	public void receiveAnswer(Suggestion suggestion, Card card,
			Player answerer, Set<Player> couldNotAnswer)
			throws NullPointerException {
		if (suggestion == null || couldNotAnswer == null) {
			throw new NullPointerException();
		} else {
			couldNotAnswer(suggestion, couldNotAnswer);
			PlayerAssumption pa = getPlayerAssumption(answerer);
			pa.addCertainHandCard(card);
		}
	}
	
	/**
	 * Updates gained information from suggestion to all players who could not
	 * answer it (do not have any of the cards in suggestion).
	 * 
	 * @param suggestion	Asked suggestion
	 * @param couldNotAnswer	Set of players who could not answer
	 */
	private void couldNotAnswer(Suggestion suggestion, 
			Set<Player> couldNotAnswer) {
		for (Player p : couldNotAnswer) {
			PlayerAssumption pa = getPlayerAssumption(p);
			pa.removePossibleCard(suggestion.getPerson());
			pa.removePossibleCard(suggestion.getRoom());
			pa.removePossibleCard(suggestion.getWeapon());
		}
	}

	/**
	 * Feed the information gained by observing this move to the internal
	 * data structures.
	 * {@inheritDoc}
	 * @see control.ai.PlayerAssumption
	 * @see control.Player#observeMove(control.Suggestion, control.Player,
	 * 				control.Player, java.util.Set)
	 */
	@Override
	public void observeMove(Suggestion suggestion, Player questionair,
			Player answerer, Set<Player> couldNotAnswer)
			throws NullPointerException {
		if (suggestion == null || couldNotAnswer == null) {
			throw new NullPointerException();
		} else {
			couldNotAnswer(suggestion, couldNotAnswer);
			PlayerAssumption pa = getPlayerAssumption(answerer);
			boolean addClause = true;
			Card person = suggestion.getPerson();
			Card room = suggestion.getRoom();
			Card weapon = suggestion.getWeapon();
			
			for (Card c : pa.getCertainHandCards()) {
				if (c.equals(person) || c.equals(room) || c.equals(weapon)) {
					addClause = false;
				}
			}
			
			if (addClause) {
				Clause<Card> clause = new Clause<Card>();
				clause.addLiteral(person, true);
				clause.addLiteral(room, true);
				clause.addLiteral(weapon, true);
				pa.getKb().addClause(clause);
			}
		}
	}
	
	/**
	 * Returns PlayerAssumption from given player.
	 * 
	 * @param player	Player whose PlayerAssumption we search for
	 * @return	PlayerAssumption from requested player
	 * @throws IllegalArgumentException	if requested player's PlayerAssumption
	 * 									does not exist
	 */
	public PlayerAssumption getPlayerAssumption(Player player) 
			throws IllegalArgumentException {
		for (PlayerAssumption pa : assumptions) {
			if (pa.getPlayer().equals(player)) {
				return pa;
			}
		}
		throw new IllegalArgumentException();
	}
}
