package control;

/**
 * This enumeration data type enumerates all possible kinds of cards. In
 * standard cluedo these are suspects, rooms and weapons.
 * 
 * @see control.Card
 */
public enum Kind {
	/**
	 * The card shows a suspect.
	 */
	PERSON,
	
	/**
	 * The card shows a possible room.
	 */
	ROOM,
	
	/**
	 * The card shows a possible weapon.
	 */
	WEAPON;
	
	public static final int size = 3;
}
