package ui;

import control.Player;
import control.Card;
import control.Suggestion;

import java.util.Set;

/**
 * This class handles the communication between control units (in control.*) and
 * the user interface. This class uses the GoF design pattern Singleton.
 */
public abstract class UIController {
	
	static private UIController singleton = null;
	
	/**
	 * Get the singleton for controlling the UI. This has not to be called from
	 * outside the class. User classes should stick to the static methods.
	 * 
	 * @see CommandLineUIController
	 * @see GUIController
	 */
	static public UIController getSingleton() {
		if (singleton == null) {
			switchToCommandLine(); // Configure the default UI here
		}
		return singleton;
	}
	
	/**
	 * Switch to command line interface.
	 * 
	 * @see CommandLineUIController
	 * @see #getSingleton()
	 */
	static public void switchToCommandLine() {
		singleton = new CommandLineUIController();
	}
	
	/**
	 * Switch to graphical user interface.
	 * 
	 * @see GUIController
	 * @see #getSingleton()
	 */
	static public void switchToGUI() {
		singleton = new GUIController();
	}
	
	/**
	 * Display a new log message on the screen.
	 * 
	 * @param str new log message
	 */
	abstract public void newLogMessage(String str);
	
	/**
	 * Update the panel for displaying certain hand cards.
	 * 
	 * @param player the player for which the certain hand cards should be
	 * 			updated
	 * @param cards new hand cards
	 */
	abstract public void updateCertainHandCardsPanel
			(Player player, Set<Card> cards);
	
	/**
	 * Update the panel for displaying possible hand cards.
	 * 
	 * @param player the player for which the possible hand cards should be
	 * 			updated
	 * @param cards new possible hand cards
	 */
	abstract public void updatePossibleHandCardsPanel
			(Player player, Set<Card> cards);
	
	/**
	 * Update the panel for displaying the solution. If one of the elements is
	 * null, this element is not determined yet.
	 * 
	 * @param sol the current (possibly partial) solution
	 */
	abstract public void updateSolutionPanel(Suggestion sol);
	
	/**
	 * Update the panel for displaying the CNF.
	 * 
	 * @param player the player for which the CNF should be updated
	 * @param cnf the new CNF as string
	 */
	abstract public void updateCNFPanel(Player player, String cnf);
	
	/**
	 * Display that a player solves.
	 * 
	 * @param player the player who attempted to solve
	 * @param sol the purposed solution
	 * @param correct TRUE if the purposed solution is correct, FALSE otherwise
	 */
	abstract public void playerSolves
			(Player player, Suggestion sol, boolean correct);
}
