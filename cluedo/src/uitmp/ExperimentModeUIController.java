package uitmp;

import java.util.Set;

import start.ExperimentStarter;

import control.Card;
import control.Player;
import control.Suggestion;

/**
 * This class controls the UI in experiment mode. Since there is now UI in 
 * experiment mode, most of the methods are trivially implemented here. This
 * UIController implementation is similar to GoF design pattern null object.
 */
public class ExperimentModeUIController extends UIController {

	/* (non-Javadoc)
	 * @see ui.UIController#newLogMessage(java.lang.String)
	 */
	@Override
	public void newLogMessage(String str) {
		;
	}

	/* (non-Javadoc)
	 * @see ui.UIController#updateCertainHandCardsPanel
	 * 		(control.Player, java.util.Set)
	 */
	@Override
	public void updateCertainHandCardsPanel(Player player, Set<Card> cards) {
		;
	}

	/* (non-Javadoc)
	 * @see ui.UIController#updatePossibleHandCardsPanel
	 * 		(control.Player, java.util.Set)
	 */
	@Override
	public void updatePossibleHandCardsPanel(Player player, Set<Card> cards) {
		;
	}

	/* (non-Javadoc)
	 * @see ui.UIController#updateSolutionPanel(control.Suggestion)
	 */
	@Override
	public void updateSolutionPanel(Suggestion sol) {
		;
	}

	/* (non-Javadoc)
	 * @see ui.UIController#updateCNFPanel(control.Player, java.lang.String)
	 */
	@Override
	public void updateCNFPanel(Player player, String cnf) {
		;
	}

	/**
	 * This is the only implemented method in the class. When a game ends, the
	 * control flow is returned to the starter in order to output a csv
	 * formatted line and start a new game.
	 * {@inheritDoc}
	 * @see uitmp.UIController#playerSolves
	 * 		(control.Player, int, control.Suggestion, boolean)
	 * @see start.ExperimentStarter#playerSolves
	 * 		(control.Player, int, control.Suggestion, boolean)
	 */
	@Override
	public void playerSolves(Player player, int round, Suggestion sol,
			boolean correct) {
		ExperimentStarter.playerSolves(player, round, sol, correct);
	}
}
