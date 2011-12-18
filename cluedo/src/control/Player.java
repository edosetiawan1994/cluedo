package control;

import java.util.List;

public abstract class Player {
	private int id;
	private List<Card> handCards;
	
	public void setHandCards(List<Card> handCards) {
		this.handCards = handCards;
	}
	
	public int getNumberOfHandCards() {
		return this.handCards.size();
	}
	
	public abstract Suggestion play();
	
	public abstract Card receiveSuggestion();
	
	public abstract void receiveAnswer(Card card, Player player);
	
	public abstract void observeMove(Suggestion suggestion, List<Player> couldNotAnswer, Player answered);
	
	

}
