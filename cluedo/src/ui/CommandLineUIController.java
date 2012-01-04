package ui;

import java.util.Set;

import control.Card;
import control.Player;
import control.Suggestion;

/**
 * This class implements the command line interface. In order to use this,
 * please change this in UIController.getSingleton()
 * 
 * @see UIController#getSingleton()
 */
public class CommandLineUIController extends UIController {

	/* (non-Javadoc)
	 * @see ui.UIController#newLogMessage(java.lang.String)
	 */
	@Override
	public void newLogMessage(String str) {
		System.out.println("[LOG]: " + str);
	}

	/* (non-Javadoc)
	 * @see ui.UIController#updateCertainHandCardsPanel
	 * 		(control.Player, java.util.Set)
	 */
	@Override
	public void updateCertainHandCardsPanel(Player player, Set<Card> cards) {
		System.out.println(player + ": Certain hand cards are now " + cards);
	}

	/* (non-Javadoc)
	 * @see ui.UIController#updatePossibleHandCardsPanel
	 * 		(control.Player, java.util.Set)
	 */
	@Override
	public void updatePossibleHandCardsPanel(Player player, Set<Card> cards) {
		System.out.println(player + ": Possible hand cards are now " + cards);
	}

	/* (non-Javadoc)
	 * @see ui.UIController#updateSolutionPanel
	 * 		(control.Player, control.Suggestion)
	 */
	@Override
	public void updateSolutionPanel(Suggestion sol) {
		// TODO Auto-generated method stub
		System.out.println("Current solution: " + sol);
	}

	/* (non-Javadoc)
	 * @see ui.UIController#updateCNFPanel(control.Player, java.lang.String)
	 */
	@Override
	public void updateCNFPanel(Player player, String cnf) {
		System.out.println(player + ": CNF is now " + cnf);
	}

	/* (non-Javadoc)
	 * @see ui.UIController#playerSolves(control.Player, control.Suggestion, boolean)
	 */
	@Override
	public void playerSolves(Player player, int round,
			Suggestion sol, boolean correct) {
		System.out.println(player + " solves "
				+ (correct ? "" : "in") + "correctly with " + sol + " in round "
				+ round);
		System.exit(0);
	}
}
