package control;

import java.util.ArrayList;
import java.util.List;

public class Suggestion {
	//TODO: have exactly one Card of each Kind-type
	private Card person;
	private Card weapon;
	private Card room;
	
	public Suggestion(Card person, Card weapon, Card room) {
		this.person = person;
		this.weapon = weapon;
		this.room = room;
	}
	
	//TODO: make it nicer ;)
	public List<Card> getSuggestion() {
		List<Card> sugg = new ArrayList<Card>();
		sugg.add(person);
		sugg.add(weapon);
		sugg.add(room);
		return sugg;
	}
}
