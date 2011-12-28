package control.ai;

import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import control.Card;

/**
 * This class maintains the search space (i.e. possible solution combinations).
 * It observes all instances of PlayerAssumptions to exclude solutions with 
 * cards on other player's hands. 
 * 
 * @see control.ai.PlayerAssumption
 * @see control.ai.AIPlayer
 */
public class SearchSpace implements Observer {
	
	private Set<Card> possiblePersons;
	private Set<Card> possibleWeapons;
	private Set<Card> possibleRooms;
	
	/**
	 * Sole constructor. Initializes search space with all possible
	 * solution combinations.
	 */
	public SearchSpace() {
		possiblePersons = new HashSet<Card>();
		possibleWeapons = new HashSet<Card>();
		possibleRooms = new HashSet<Card>();
		for (Card card : Card.generateAllCards()) {
			switch (card.getKind()) {
			case PERSON:
				possiblePersons.add(card);
				break;
			case WEAPON:
				possibleWeapons.add(card);
				break;
			case ROOM:
				possibleRooms.add(card);
				break;
			default:
				assert false;
			}
		}
	}

	/**
	 * Exclude all possible solutions with a certain hand card.
	 * 
	 * @param card the card which is not in the solution envelope
	 * @throws NullPointerException if card is null
	 */
	public void excludeCard(Card card) {
		switch (card.getKind()) {
		case PERSON:
			possiblePersons.remove(card);
			break;
		case WEAPON:
			possibleWeapons.remove(card);
			break;
		case ROOM:
			possibleRooms.remove(card);
			break;
		default:
			assert false;
		}
	}
	
	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 * @throws NullPointerException if arg is null
	 * @throws IllegalArgumentException if arg is not a card
	 */
	@Override
	public void update(Observable o, Object arg) {
		if (!(arg instanceof Card)) {
			throw new IllegalArgumentException();
		}
		excludeCard((Card) arg);
	}

	/**
	 * Get all possible cards (not separated by their kind).
	 * 
	 * @return set of cards which could be in the envelope
	 */
	public Set<Card> getPossibleCards() {
		Set<Card> allCards = new HashSet<Card>();
		allCards.addAll(possiblePersons);
		allCards.addAll(possibleWeapons);
		allCards.addAll(possibleRooms);
		return allCards;
	}
}
