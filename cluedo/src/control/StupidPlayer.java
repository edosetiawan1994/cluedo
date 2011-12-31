package control;

import java.util.Set;

public class StupidPlayer extends Player{

	public StupidPlayer(Game game, String name, int id)
			throws NullPointerException {
		super(game, name, id);
	}

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
		// do not think, do nothing
		
	}

	@Override
	public void observeMove(Suggestion suggestion, Player questionair,
			Player answerer, Set<Player> couldNotAnswer)
			throws NullPointerException {
		// do not think, do nothing
	}

}
