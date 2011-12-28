package control;

import java.util.List;

/**
 * This class contains the overall game logic of Cluedo. It controls the game
 * flow and the communication between players. The class Player provides proper
 * methods for notifying players about different events or letting them play
 * their round. All these methods are called by this class.
 * 
 * @see control.Player
 */
public class Game {
	
	private List<Player> players;
	
	public void start() {
		
	}

	/**
	 * This method reflects the design pattern Mediator. Game acts as mediator
	 * between players - this method can be used to get all players in a game
	 * without coupling the players together. Note that this is not exactly the
	 * GoF Mediator since it allows direct access to other players.
	 * 
	 * @return set of players
	 */
	public List<Player> getPlayers() {
		return players;
	}
	
	/**
	 * This method is called if a player wants to solve. If the suggestion is
	 * correct, this player wins. If not, [s]he looses. The game ends anyway
	 * (not like in the original game). However, since we have only AI players,
	 * this situation should not occur.
	 * 
	 * @param player Player who tries to solve
	 * @param suggestion his/her solution
	 * @throws NullPointerException if one of the parameters is null
	 */
	public void playerSolves(Player player, Suggestion suggestion) 
			throws NullPointerException {
		if (player == null || suggestion == null) {
			throw new NullPointerException();
		}
	}
}
