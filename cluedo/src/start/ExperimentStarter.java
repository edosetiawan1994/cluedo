package start;

import java.util.LinkedList;
import java.util.List;

import control.Game;
import control.Player;
import control.Suggestion;
import control.ai.AIPlayer;
import ui.UIController;

/**
 * This class is suitable for running large scaled experiments. It contains a
 * main runner method which takes exactly three arguments: the number of players,
 * the intelligence level (expressed as a set of AIAbility flags) and the number
 * of games. It writes a csv formatted string to stdout - each line represents
 * one game.
 * 
 * @see control.ai.AIAbility
 * @see ui.ExperimentModeUIController
 */
public class ExperimentStarter {

	/* (non-Javadoc)
	 * Following four variables store the experiment settings given via
	 * command line arguments.
	 */
	static private int nAIPlayers, nStupidPlayers, intelligence, nGames;
	
	/* (non-Javadoc)
	 * This is set by playerSolves() to true to indicate that the current game
	 * has ended.
	 */
	static private boolean gameEnded;
	
	/**
	 * Main runner method. The expected command line arguments are:
	 * 	- number of AI players. All players will have the same AIAbilities.
	 *  - number of stupid players.
	 *  - level of intelligence for the players, expressed as AIAbilities.
	 *  	For further information how to define these abilities please
	 *  	read {@link control.ai.AIAbility}. Note that no stupid players can
	 *  	be configured.
	 *  - Number of games which should be executed. Each game will cause a
	 *  	new line on stdout formatted as csv containing who wan, in which
	 *  	round and with which suggestion.
	 *  
	 * @param args string array with four elements as described above
	 * @throws NullPointerException if one element in args is null
	 * @throws NumberFormatException if one element in args does not contain an 
	 * 		integer.
	 */
	public static void main(String[] args) throws NumberFormatException {
		UIController.switchToExperimentMode();
		if (args.length != 3) {
			System.err.println("Please provide three integer arguments:");
			System.err.println("- Number of AI players");
			System.err.println("- Number of stupid players");
			System.err.println("- Level of intelligence");
			System.err.println("- Number of games");
			System.exit(1);
		}
		nAIPlayers = Integer.parseInt(args[0]);
		nStupidPlayers = Integer.parseInt(args[1]);
		intelligence = Integer.parseInt(args[2]);
		nGames = Integer.parseInt(args[3]);
		playGames();
	}
	
	/* (non-Javadoc)
	 * Begin subsequently nGames new games with nPlayers AI players with 
	 * intelligence level intelligence.
	 */
	private static void playGames() {
		for (; nGames > 0; nGames--) {
			List<Player> players = new LinkedList<Player>();
			Game game = new Game();
			for (int i = 1; i <= nAIPlayers; i++) {
				players.add(new AIPlayer(game, "AI " + i, i,
						true, intelligence));
			}
			for (int i = 1; i <= nStupidPlayers; i++) {
				players.add(new AIPlayer(game, "Stupid " + i, i + nAIPlayers,
						true, intelligence));
			}
			game.start(players);
			gameEnded = false;
			while (!gameEnded) {
				game.nextMove();
			}
		}
	}
	
	/**
	 * Call this when a player has solved the current game. This method will
	 * write the csv output to stdout and trigger a new game by setting
	 * gameEnded to true. If a player solved incorrectly, output an error
	 * and exit.
	 * 
	 * @param player the player who attempted to solve
	 * @param round the current round (first round is denoted with 1)
	 * @param sol the purposed solution
	 * @param correct TRUE if the purposed solution is correct, FALSE otherwise
	 */
	public static void playerSolves(Player player, int round, Suggestion sol,
			boolean correct) {
		if (!correct) {
			System.err.println("Player solved incorrectly!");
			System.exit(0);
		}
		System.out.println(player + ";"  + round + ";" + sol);
		gameEnded = true;
	}
}
