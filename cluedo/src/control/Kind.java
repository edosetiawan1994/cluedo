package control;

/**
 * This enumeration data type enumerates all possible kinds of cards. In
 * standard cluedo these are suspects, rooms and weapons.
 * 
 * @see control.Card
 */
public enum Kind {
	PERSON,
	ROOM,
	WEAPON;
	
	public static final int size = 3;
}
