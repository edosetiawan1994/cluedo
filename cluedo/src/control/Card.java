package control;

import java.util.ArrayList;
import java.util.List;


public class Card {
	private int id;
	private String name;
	private Kind kind;
	
	/**
	 * Private constructor! Cards should be generated one time by Card.
	 * generateAllCards() and then maintained in appropriate data structures.
	 * 
	 * @param id unique id
	 * @param name
	 */
	private Card(int id, String name, Kind kind) {
		this.name = name;
		this.id = id;
		this.kind = kind;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the kind
	 */
	public Kind getKind() {
		return kind;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return 61 + id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Card)) {
			return false;
		}
		return id == ((Card) obj).id;
	}
	
	/**
	 * Static method for generating the card deck. It is returned as list to
	 * make shuffling easier. Use this method for generating cards instead of
	 * the constructor. 
	 */
	public static List<Card> generateAllCards() {
		String[] persons = {"Miss Scarlett", "Colonel Mustard", "Mrs. White",
				"Reverend Green", "Mrs. Peacock", "Professor Plum"};
		String[] weapons = {"Candlestick", "Dagger", "Lead Pipe", "Revolver",
				"Rope", "Spanner"};
		String[] rooms = {"Ballroom", "Kitchen", "Conservatory", "Dining Room",
				"Billiard Room", "Library", "Hall", "Lounge", "Study"};
		int id = 1;
		List<Card> cards = new ArrayList<Card>();
		for (String person : persons) {
			cards.add(new Card(id++, person, Kind.PERSON));
		}
		for (String weapon : weapons) {
			cards.add(new Card(id++, weapon, Kind.WEAPON));
		}
		for (String room : rooms) {
			cards.add(new Card(id++, room, Kind.ROOM));
		}
		return cards;
	}
}
