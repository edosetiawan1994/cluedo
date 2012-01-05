package control;

import java.util.Set;

/**
 * This player concentrates on being stupid. We approach this complex task by 
 * avoiding thinking whenever possible, and acting as stupid as the game rules
 * allow. Therefore a stupid player plays fair (shows a hand card if he can
 * disprove a suggestion), but all other decisions are made completely on
 * random. This implementation follows the Forrest Gump GoF design pattern.
 */
public class StupidPlayer extends Player{

	/**
	 * {@inheritDoc}
	 */
	public StupidPlayer(Game game, String name, int id)
			throws NullPointerException {
		super(game, name, id);
	}

	/**
	 *
	 */
	@Override
	public Suggestion play() {
		return Suggestion.getRandomSuggestion();
	}

	@Override
	public Card receiveSuggestion(Player questionair, Suggestion suggestion)
			throws NullPointerException {
		if (handCards.contains(suggestion.getPerson())) {
			return suggestion.getPerson();
		}
		if (handCards.contains(suggestion.getWeapon())) {
			return suggestion.getWeapon();
		}
		if (handCards.contains(suggestion.getRoom())) {
			return suggestion.getRoom();
		}
		return null;
	}

	@Override
	public void receiveAnswer(Suggestion suggestion, Card card,
			Player answerer, Set<Player> couldNotAnswer)
			throws NullPointerException {
		// do not think, do nothing, just be stupid
	}

	@Override
	public void observeMove(Suggestion suggestion, Player questionair,
			Player answerer, Set<Player> couldNotAnswer)
			throws NullPointerException {
		// do not think, do nothing, just be stupid
	}

}
