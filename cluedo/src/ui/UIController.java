package ui;

import control.Player;
import control.Card;
import control.Suggestion;

import java.util.Set;

/**
 * This class handles the communication between control units (in control.*) and
 * the user interface.
 */
public class UIController {
	
	/**
	 * Display a new log message on the screen.
	 * 
	 * @param str new log message
	 */
	static public void newLogMessage(String str) {
		;
	}
	
	/**
	 * Update the panel for displaying certain hand cards.
	 * 
	 * @param player the player for which the certain hand cards should be
	 * 			updated
	 * @param cards new hand cards
	 */
	static public void updateCertainHandCardsPanel
			(Player player, Set<Card> cards) {
		;
	}
	
	/**
	 * Update the panel for displaying possible hand cards.
	 * 
	 * @param player the player for which the possible hand cards should be
	 * 			updated
	 * @param cards new possible hand cards
	 */
	static public void updatePossibleHandCardsPanel
			(Player player, Set<Card> cards) {
		;
	}
	
	/**
	 * Update the panel for displaying the solution. If one of the elements is
	 * null, this element is not determined yet.
	 * 
	 * @param player the player for which the possible hand cards should be
	 * 			updated
	 * @param sol the current (possibly partial) solution
	 */
	static public void updateSolutionPanel(Player player, Suggestion sol) {
		;
	}
	
	/**
	 * Update the panel for displaying the CNF.
	 * 
	 * @param player the player for which the CNF should be updated
	 * @param cnf the new CNF as string
	 */
	static public void updateCNFPanel(Player player, String cnf) {
		;
	}
	
	/**
	 * Display that a player solves.
	 * 
	 * @param player the player who attempted to solve
	 * @param sol the purposed solution
	 * @param correct TRUE if the purposed solution is correct, FALSE otherwise
	 */
	static public void playerSolves
			(Player player, Suggestion sol, boolean correct) {
		;
	}
}
