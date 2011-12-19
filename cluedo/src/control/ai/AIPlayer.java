package control.ai;

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

	/**
	 * Sole constructor. Calls the super class constructor and initialize
	 * class intern data structures.
	 * {@inheritDoc}
	 */
	public AIPlayer(Game game, String name, int id)
			throws NullPointerException {
		super(game, name, id);
		// TODO Auto-generated constructor stub
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
