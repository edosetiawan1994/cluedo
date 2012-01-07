package ui;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import control.Card;
import control.Game;
import control.Player;
import control.Suggestion;

/**
 * This class bundles the communication ways between the graphical user 
 * interface and the controller. In order to activate this class, change the
 * default value in getSingleton() or use switchToGui().
 * 
 * @see ui.UIController#getSingleton()
 * @see ui.UIController#switchToGUI()
 */
public class GUIController extends UIController {

	/* (non-Javadoc)
	 * @see ui.UIController#newLogMessage(java.lang.String)
	 */
	@Override
	public void newLogMessage(String str) {
		GameUI.logOutput.append(str+"\n");
	}

	/* (non-Javadoc)
	 * @see ui.UIController#updateCertainHandCardsPanel
	 * 		(control.Player, java.util.Set)
	 */
	@Override
	public void updateCertainHandCardsPanel(Player player, Set<Card> cards) {
		try {
			Game game = new Game();
			if (player.getId() == 1) {
				GameUI.gameContentPane4.removeAll();
				GameUI.gameContentPane4.validate();
				GameUI.gameContentPane4.repaint();
				GameUI.gameContentPane4.add(new JLabel("PLAYER 1           hand: "));
				Set<Card> cardsPlayer1 = game.getPlayers().get(0).getHandCards();
				for (Card card : cardsPlayer1) {
					GameUI.gameContentPane4.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/" + card.getId() + ".jpg")))));
					GameUI.gameContentPane4.validate();
					GameUI.gameContentPane4.repaint();
				}
				GameUI.gameContentPane4.validate();
				GameUI.gameContentPane4.repaint();
			}
			if (player.getId() == 2) {
				GameUI.gameContentPane1aCardsHand.removeAll();
				GameUI.gameContentPane1aCardsHand.validate();
				GameUI.gameContentPane1aCardsHand.repaint();
				GameUI.gameContentPane1aCardsHand.add(new JLabel("PLAYER 2           hand: "));
				for (Card card : cards) {
					GameUI.gameContentPane1aCardsHand.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/" + card.getId() + ".jpg")))));
					GameUI.gameContentPane1aCardsHand.validate();
					GameUI.gameContentPane1aCardsHand.repaint();
				}
				GameUI.gameContentPane1aCardsHand.validate();
				GameUI.gameContentPane1aCardsHand.repaint();
			}
			if (player.getId() == 3) {
				GameUI.gameContentPane1bCardsHand.removeAll();
				GameUI.gameContentPane1bCardsHand.validate();
				GameUI.gameContentPane1bCardsHand.repaint();
				GameUI.gameContentPane1bCardsHand.add(new JLabel("PLAYER 3           hand: "));
				for (Card card : cards) {
					GameUI.gameContentPane1bCardsHand.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/" + card.getId() + ".jpg")))));
					GameUI.gameContentPane1bCardsHand.validate();
					GameUI.gameContentPane1bCardsHand.repaint();
				}
				GameUI.gameContentPane1bCardsHand.validate();
				GameUI.gameContentPane1bCardsHand.repaint();
			}
			if (player.getId() == 4) {
				GameUI.gameContentPane1cCardsHand.removeAll();
				GameUI.gameContentPane1cCardsHand.validate();
				GameUI.gameContentPane1cCardsHand.repaint();
				GameUI.gameContentPane1cCardsHand.add(new JLabel("PLAYER 4           hand: "));
				for (Card card : cards) {
					GameUI.gameContentPane1cCardsHand.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/" + card.getId() + ".jpg")))));
					GameUI.gameContentPane1cCardsHand.validate();
					GameUI.gameContentPane1cCardsHand.repaint();
				}
				GameUI.gameContentPane1cCardsHand.validate();
				GameUI.gameContentPane1cCardsHand.repaint();
			}
			if (player.getId() == 5) {
				GameUI.gameContentPane1dCardsHand.removeAll();
				GameUI.gameContentPane1dCardsHand.validate();
				GameUI.gameContentPane1dCardsHand.repaint();
				GameUI.gameContentPane1dCardsHand.add(new JLabel("PLAYER 5           hand: "));
				for (Card card : cards) {
					GameUI.gameContentPane1dCardsHand.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/" + card.getId() + ".jpg")))));
					GameUI.gameContentPane1dCardsHand.validate();
					GameUI.gameContentPane1dCardsHand.repaint();
				}
				GameUI.gameContentPane1dCardsHand.validate();
				GameUI.gameContentPane1dCardsHand.repaint();
			}
			if (player.getId() == 6) {
				GameUI.gameContentPane1eCardsHand.removeAll();
				GameUI.gameContentPane1eCardsHand.validate();
				GameUI.gameContentPane1eCardsHand.repaint();
				GameUI.gameContentPane1eCardsHand.add(new JLabel("PLAYER 6           hand: "));
				for (Card card : cards) {
					GameUI.gameContentPane1eCardsHand.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/" + card.getId() + ".jpg")))));
					GameUI.gameContentPane1eCardsHand.validate();
					GameUI.gameContentPane1eCardsHand.repaint();
				}
				GameUI.gameContentPane1eCardsHand.validate();
				GameUI.gameContentPane1eCardsHand.repaint();
			}
			GameUI.gameContentPaneBasic.validate();
			GameUI.gameContentPaneBasic.repaint();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see ui.UIController#updatePossibleHandCardsPanel
	 * 		(control.Player, java.util.Set)
	 */
	@Override
	public void updatePossibleHandCardsPanel(Player player, Set<Card> cards) {
		try {
			if (player.getId() == 2) {
				GameUI.gameContentPane1aCardsPossible.removeAll();
				GameUI.gameContentPane1aCardsPossible.validate();
				GameUI.gameContentPane1aCardsPossible.repaint();
				GameUI.gameContentPane1aCardsPossible.add(new JLabel("possible: "));
				for (Card card : cards) {
					GameUI.gameContentPane1aCardsPossible.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/" + card.getId() + ".jpg")))));
					GameUI.gameContentPane1aCardsPossible.validate();
					GameUI.gameContentPane1aCardsPossible.repaint();
				}
				GameUI.gameContentPane1aCardsPossible.validate();
				GameUI.gameContentPane1aCardsPossible.repaint();
			}
			if (player.getId() == 3) {
				GameUI.gameContentPane1bCardsPossible.removeAll();
				GameUI.gameContentPane1bCardsPossible.validate();
				GameUI.gameContentPane1bCardsPossible.repaint();
				GameUI.gameContentPane1bCardsPossible.add(new JLabel("possible: "));
				for (Card card : cards) {
					GameUI.gameContentPane1bCardsPossible.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/" + card.getId() + ".jpg")))));
					GameUI.gameContentPane1bCardsPossible.validate();
					GameUI.gameContentPane1bCardsPossible.repaint();
				}
				GameUI.gameContentPane1bCardsPossible.validate();
				GameUI.gameContentPane1bCardsPossible.repaint();
			}
			if (player.getId() == 4) {
				GameUI.gameContentPane1cCardsPossible.removeAll();
				GameUI.gameContentPane1cCardsPossible.validate();
				GameUI.gameContentPane1cCardsPossible.repaint();
				GameUI.gameContentPane1cCardsPossible.add(new JLabel("possible: "));
				for (Card card : cards) {
					GameUI.gameContentPane1cCardsPossible.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/" + card.getId() + ".jpg")))));
					GameUI.gameContentPane1cCardsPossible.validate();
					GameUI.gameContentPane1cCardsPossible.repaint();
				}
				GameUI.gameContentPane1cCardsPossible.validate();
				GameUI.gameContentPane1cCardsPossible.repaint();
			}
			if (player.getId() == 5) {
				GameUI.gameContentPane1dCardsPossible.removeAll();
				GameUI.gameContentPane1dCardsPossible.validate();
				GameUI.gameContentPane1dCardsPossible.repaint();
				GameUI.gameContentPane1dCardsPossible.add(new JLabel("possible: "));
				for (Card card : cards) {
					GameUI.gameContentPane1dCardsPossible.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/" + card.getId() + ".jpg")))));
					GameUI.gameContentPane1dCardsPossible.validate();
					GameUI.gameContentPane1dCardsPossible.repaint();
				}
				GameUI.gameContentPane1dCardsPossible.validate();
				GameUI.gameContentPane1dCardsPossible.repaint();
			}
			if (player.getId() == 6) {
				GameUI.gameContentPane1eCardsPossible.removeAll();
				GameUI.gameContentPane1eCardsPossible.validate();
				GameUI.gameContentPane1eCardsPossible.repaint();
				GameUI.gameContentPane1eCardsPossible.add(new JLabel("possible: "));
				for (Card card : cards) {
					GameUI.gameContentPane1eCardsPossible.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/" + card.getId() + ".jpg")))));
					GameUI.gameContentPane1eCardsPossible.validate();
					GameUI.gameContentPane1eCardsPossible.repaint();
				}
				GameUI.gameContentPane1eCardsPossible.validate();
				GameUI.gameContentPane1eCardsPossible.repaint();
			}
			GameUI.gameContentPaneBasic.validate();
			GameUI.gameContentPaneBasic.repaint();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see ui.UIController#updateSolutionPanel(control.Suggestion)
	 */
	@Override
	public void updateSolutionPanel(Suggestion sol) {
		Card person = sol.getPerson();
		Card weapon = sol.getWeapon();
		Card room = sol.getRoom();
		
		try {
			GameUI.gameContentPane5.remove(GameUI.personLabel);
			GameUI.gameContentPane5.validate();
			GameUI.gameContentPane5.repaint();
			GameUI.personLabel = new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/1.jpg"))));
			GameUI.gameContentPane5.add(GameUI.personLabel);
			GameUI.gameContentPane5.validate();
			GameUI.gameContentPane5.repaint();
	    	
			if (person != null) {
				GameUI.gameContentPane5.remove(GameUI.personLabel);
				GameUI.gameContentPane5.validate();
				GameUI.gameContentPane5.repaint();
				GameUI.personLabel = new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/" + person.getId() + ".jpg"))));
				GameUI.gameContentPane5.add(GameUI.personLabel);
				GameUI.gameContentPane5.validate();
				GameUI.gameContentPane5.repaint();
			}
			else if (person == null) {
				GameUI.gameContentPane5.remove(GameUI.personLabel);
				GameUI.gameContentPane5.validate();
				GameUI.gameContentPane5.repaint();
				GameUI.personLabel = new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/21.jpg"))));
				GameUI.gameContentPane5.add(GameUI.personLabel);
				GameUI.gameContentPane5.validate();
				GameUI.gameContentPane5.repaint();
			}
			if (weapon != null) {
				GameUI.gameContentPane5.remove(GameUI.weaponLabel);
				GameUI.gameContentPane5.validate();
				GameUI.gameContentPane5.repaint();
				GameUI.weaponLabel = new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/" + weapon.getId() + ".jpg"))));
				GameUI.gameContentPane5.add(GameUI.weaponLabel);
				GameUI.gameContentPane5.validate();
				GameUI.gameContentPane5.repaint();
			}
			else if (weapon == null) {
				GameUI.gameContentPane5.remove(GameUI.weaponLabel);
				GameUI.gameContentPane5.validate();
				GameUI.gameContentPane5.repaint();
				GameUI.weaponLabel = new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/21.jpg"))));
				GameUI.gameContentPane5.add(GameUI.weaponLabel);
				GameUI.gameContentPane5.validate();
				GameUI.gameContentPane5.repaint();
			}
			if (room != null) {
				GameUI.gameContentPane5.remove(GameUI.roomLabel);
				GameUI.gameContentPane5.validate();
				GameUI.gameContentPane5.repaint();
				GameUI.roomLabel = new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/" + room.getId() + ".jpg"))));
				GameUI.gameContentPane5.add(GameUI.roomLabel);
				GameUI.gameContentPane5.validate();
				GameUI.gameContentPane5.repaint();
			}
			else if (room == null) {
				GameUI.gameContentPane5.remove(GameUI.roomLabel);
				GameUI.gameContentPane5.validate();
				GameUI.gameContentPane5.repaint();
				GameUI.roomLabel = new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/21.jpg"))));
				GameUI.gameContentPane5.add(GameUI.roomLabel);
				GameUI.gameContentPane5.validate();
				GameUI.gameContentPane5.repaint();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see ui.UIController#updateCNFPanel(control.Player, java.lang.String)
	 */
	@Override
	public void updateCNFPanel(Player player, String cnf) {
		if (player.getId() == 2) {
			GameUI.cnfPlayer2.removeAll();
			GameUI.gameContentPane1aCNF.validate();
			GameUI.gameContentPane1aCNF.repaint();
			if (!cnf.equals("empty")) GameUI.cnfPlayer2.append(cnf);
			GameUI.gameContentPane1aCNF.validate();
			GameUI.gameContentPane1aCNF.repaint();
		}
		if (player.getId() == 3) {
			GameUI.cnfPlayer3.removeAll();
			GameUI.gameContentPane1bCNF.validate();
			GameUI.gameContentPane1bCNF.repaint();
			if (!cnf.equals("empty")) GameUI.cnfPlayer3.append(cnf);
			GameUI.gameContentPane1bCNF.validate();
			GameUI.gameContentPane1bCNF.repaint();
		}
		if (player.getId() == 4) {
			GameUI.cnfPlayer4.removeAll();
			GameUI.gameContentPane1cCNF.validate();
			GameUI.gameContentPane1cCNF.repaint();
			if (!cnf.equals("empty")) GameUI.cnfPlayer4.append(cnf);
			GameUI.gameContentPane1cCNF.validate();
			GameUI.gameContentPane1cCNF.repaint();
		}
		if (player.getId() == 5) {
			GameUI.cnfPlayer5.removeAll();
			GameUI.gameContentPane1dCNF.validate();
			GameUI.gameContentPane1dCNF.repaint();
			if (!cnf.equals("empty")) GameUI.cnfPlayer5.append(cnf);
			GameUI.gameContentPane1dCNF.validate();
			GameUI.gameContentPane1dCNF.repaint();
		}
		if (player.getId() == 6) {
			GameUI.cnfPlayer6.removeAll();
			GameUI.gameContentPane1eCNF.validate();
			GameUI.gameContentPane1eCNF.repaint();
			if (!cnf.equals("empty")) GameUI.cnfPlayer6.append(cnf);
			GameUI.gameContentPane1eCNF.validate();
			GameUI.gameContentPane1eCNF.repaint();
		}
	}

	/* (non-Javadoc)
	 * @see ui.UIController#playerSolves
	 * 		(control.Player, control.Suggestion, boolean)
	 */
	@Override
	public void playerSolves(Player player,
			int round, Suggestion sol, boolean correct) {
		if (correct) {
			GameUI.logOutput.append("========================================\n");
			GameUI.logOutput.append("PLAYER " + player.getId() + " SOLVED THE PUZZLE IN ROUND " + round + ".\n");
			GameUI.logOutput.append("The murderer " + sol.getPerson() + " who used " + sol.getWeapon() + " in " + sol.getRoom() + ".\n");
			GameUI.logOutput.append("========================================\n");
		}
		GameUI.nextMove.setEnabled(false);	
	}
}
