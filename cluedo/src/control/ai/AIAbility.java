package control.ai;

/**
 * Enumerates the possible abilities of a AI player and therefore can be used
 * to specify the degree of intelligence. Use the getId() function and the +
 * operator to define set of abilities. For example
 * HAND_CARDS_TRACKING.getId() + CNF_REASONING.getId()
 * defines an agent which tracks certain and possible hand cards of advisors
 * and use CNFs to reason about them.
 * 
 * @see control.ai.AIPlayer
 * @see #getId()
 */
public enum AIAbility {
	/**
	 * Refers to the ability of keep track of possible and certain hand cards
	 * of all advisors.
	 */
	HAND_CARDS_TRACKING(0),
	
	/**
	 * Use card ranking to figure out good cards for including it in a 
	 * suggestion.
	 */
	CARD_RANKING(2),
	
	/**
	 * Use CNFs for each advisor to gain additional knowledge about their
	 * hand cards.
	 */
	CNF_REASONING(4);
	
	private int id;
	private AIAbility(int id) {
		this.id = id;
	}
	
	/**
	 * Get the ID. Use this value in combination with + to specify the
	 * ability set of an AI player.
	 * 
	 * @return the id of the ability
	 */
	public int getId() {
		return id;
	}
}
