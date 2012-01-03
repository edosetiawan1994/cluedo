package start;

import ui.UIController;
import control.Player;
import control.Game;
import control.StupidPlayer;
import control.ai.AIAbility;
import control.ai.AIPlayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * This class offers a simple command line interface for running Cluedo. This
 * is the alternative to the graphical user interface, which could be started
 * using GUIStarter.
 * 
 * @see start.GUIStarter
 * @see ui.CommandLineUIController
 */
public class CommandLineStarter {

	/**
	 * This is the main runner method when using command line interface. After
	 * basic sanity checks, it starts a game with the specified number of
	 * different kinds of players. Then a basic menu command line is lunched to
	 * control the game flow via keyboard.
	 * 
	 * @param args ([#ai [#stupid]]) specifies the number of stupid and AI
	 * 		players
	 */
	public static void main(String[] args) {
		UIController.switchToCommandLine();
		System.out.println("Usage: CommandLineStarter [<#ai> [<#stupid>]]");
		System.out.println("(number of AI and stupid players)");
		int nAi = 2, nStupid = 2;
		if (args.length > 2) {
			System.err.println("Too many arguments.");
			return;
		}
		if (args.length > 0) {
			nAi = Integer.parseInt(args[0]);
		}
		if (args.length > 1) {
			nStupid = Integer.parseInt(args[1]);
		}
		if (nAi < 1) {
			System.err.println("Specify at least one AI player.");
		}
		if (nAi + nStupid > 18) {
			System.err.println("Maximum number of players is 18.");
		}
		beginGame(nAi, nStupid);
	}
	
	/* (non-Javadoc)
	 * Begin a game with the given number of AI and stupid players. The first
	 * AI player is configured to be "myself". The parameters were already
	 * sanity checked.
	 */
	private static void beginGame(int nAi, int nStupid) {
		List<Player> players = new LinkedList<Player>();
		final int fullIntelligence = AIAbility.HAND_CARDS_TRACKING.getId()
				+ AIAbility.CARD_RANKING.getId()
				+ AIAbility.CNF_REASONING.getId();
		nAi--;
		Game game = new Game();
		int id = 1;
		players.add(new AIPlayer(
				game, "Myself", id++, true, fullIntelligence));
		for (; nAi > 0; nAi--) { // Add AI players
			players.add(new AIPlayer(game, "AI" + String.valueOf(id),
					id++, false, fullIntelligence));
		}
		for (; nStupid > 0; nStupid--) { // Add stupid players
			players.add(new StupidPlayer(game, "Stupid" + String.valueOf(id),
					id++));
		}
		game.start(players);
		System.out.println("Press <Enter> to execute the next move.");
		System.out.println("Press c <Enter> to exit.");
		BufferedReader stdin = new BufferedReader(
				new InputStreamReader(System.in));
		boolean cancel = false;
		while (!cancel) {
			try {
				String line = stdin.readLine();
				if (line == "c") {
					cancel = true;
				} else {
					game.nextMove();
				}
			} catch (IOException e) {
				System.out.println("Could not read from stdin: "
						+ e.getMessage());
			}
		}
	}
}
