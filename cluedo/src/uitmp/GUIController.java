package uitmp;

import java.util.Set;

import control.Card;
import control.Player;
import control.Suggestion;

/**
 * This class bundles the communication ways between the graphical user 
 * interface and the controller. In order to activate this class, change the
 * default value in getSingleton() or use switchToGui().
 * 
 * @see uitmp.UIController#getSingleton()
 * @see uitmp.UIController#switchToGUI()
 */
public class GUIController extends UIController {

	/* (non-Javadoc)
	 * @see ui.UIController#newLogMessage(java.lang.String)
	 */
	@Override
	public void newLogMessage(String str) {
		// TODO To be implemented (Martin)
	}

	/* (non-Javadoc)
	 * @see ui.UIController#updateCertainHandCardsPanel
	 * 		(control.Player, java.util.Set)
	 */
	@Override
	public void updateCertainHandCardsPanel(Player player, Set<Card> cards) {
		// TODO To be implemented (Martin)
	}

	/* (non-Javadoc)
	 * @see ui.UIController#updatePossibleHandCardsPanel
	 * 		(control.Player, java.util.Set)
	 */
	@Override
	public void updatePossibleHandCardsPanel(Player player, Set<Card> cards) {
		// TODO To be implemented (Martin)
	}

	/* (non-Javadoc)
	 * @see ui.UIController#updateSolutionPanel(control.Suggestion)
	 */
	@Override
	public void updateSolutionPanel(Suggestion sol) {
		// TODO To be implemented (Martin)
	}

	/* (non-Javadoc)
	 * @see ui.UIController#updateCNFPanel(control.Player, java.lang.String)
	 */
	@Override
	public void updateCNFPanel(Player player, String cnf) {
		// TODO To be implemented (Martin)
	}

	/* (non-Javadoc)
	 * @see ui.UIController#playerSolves
	 * 		(control.Player, control.Suggestion, boolean)
	 */
	@Override
	public void playerSolves(Player player,
			int round, Suggestion sol, boolean correct) {
		// TODO To be implemented (Martin)
	}
}
