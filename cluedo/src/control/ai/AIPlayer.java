package control.ai;

import java.util.LinkedList;
import java.util.List;
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
	
	/* (non-javadoc)
	 * Stores the current search space of possible solutions.
	 */
	private SearchSpace searchSpace;
	
	/**
	 * Sole constructor. Calls the super class constructor and initialize
	 * class intern data structures.
	 * {@inheritDoc}
	 */
	public AIPlayer(Game game, String name, int id)
			throws NullPointerException {
		super(game, name, id);
		assumptions = new LinkedList<PlayerAssumption>();
		searchSpace = new SearchSpace();
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
				assumptions.add(new PlayerAssumption(players.get(i)));
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
	 * {@inheritDoc}
	 * @see control.Player#play()
	 */
	@Override
	public Suggestion play() {
		// TODO Auto-generated method stub
		return null;
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
		}
		// TODO Auto-generated method stub
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
		}
		// TODO Auto-generated method stub
	}
}
