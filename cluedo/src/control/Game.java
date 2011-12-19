package control;

import java.util.List;

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
}
