package control;

import java.util.ArrayList;
import java.util.List;

public class PlayerAssumption {
	private Player player;
	private List<Card> possibleHandCards;
	//TODO: should certainHandCards actually be Suggestion and not List<Card>?
	private List<Card> certainHandCards;
	
	public PlayerAssumption(Player player) {
		this.player = player;
		//TODO: initialize possibleHandCards with every possibleCard and then remove?
		this.possibleHandCards = new ArrayList<Card>();
		this.certainHandCards = new ArrayList<Card>();
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public List<Card> getPossibleHandCards() {
		return this.possibleHandCards;
	}
	
	public void removePossibleCard(Card card) {
		this.possibleHandCards.remove(card);
	}
	
	public void addCertainCard(Card card) {
		this.certainHandCards.add(card);
	}
	
	public List<Card> getCertainHandCards() {
		return this.certainHandCards;
	}
}
