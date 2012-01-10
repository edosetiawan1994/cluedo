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
public class CopyOfGUIControllerOld extends UIController {

	/* (non-Javadoc)
	 * @see ui.UIController#newLogMessage(java.lang.String)
	 */
	@Override
	public void newLogMessage(String str) {
		GameUIold.logOutput.append(str+"\n");
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
				GameUIold.gameContentPane4.removeAll();
				GameUIold.gameContentPane4.validate();
				GameUIold.gameContentPane4.repaint();
				GameUIold.gameContentPane4.add(new JLabel("PLAYER 1  \n handCards: "));
				Set<Card> cardsPlayer1 = game.getPlayers().get(0).getHandCards();
				for (Card card : cardsPlayer1) {
					GameUIold.gameContentPane4.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/" + card.getId() + ".jpg")))));
					GameUIold.gameContentPane4.validate();
					GameUIold.gameContentPane4.repaint();
				}
				GameUIold.gameContentPane4.validate();
				GameUIold.gameContentPane4.repaint();
			}
			if (player.getId() == 2) {
				GameUIold.gameContentPane1aCardsHand.removeAll();
				GameUIold.gameContentPane1aCardsHand.validate();
				GameUIold.gameContentPane1aCardsHand.repaint();
				GameUIold.gameContentPane1aCardsHand.add(new JLabel("PLAYER 2 \n handCards: "));
				for (Card card : cards) {
					GameUIold.gameContentPane1aCardsHand.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/" + card.getId() + ".jpg")))));
					GameUIold.gameContentPane1aCardsHand.validate();
					GameUIold.gameContentPane1aCardsHand.repaint();
				}
				GameUIold.gameContentPane1aCardsHand.validate();
				GameUIold.gameContentPane1aCardsHand.repaint();
			}
			if (player.getId() == 3) {
				GameUIold.gameContentPane1bCardsHand.removeAll();
				GameUIold.gameContentPane1bCardsHand.validate();
				GameUIold.gameContentPane1bCardsHand.repaint();
				GameUIold.gameContentPane1bCardsHand.add(new JLabel("PLAYER 3 \n handCards: "));
				for (Card card : cards) {
					GameUIold.gameContentPane1bCardsHand.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/" + card.getId() + ".jpg")))));
					GameUIold.gameContentPane1bCardsHand.validate();
					GameUIold.gameContentPane1bCardsHand.repaint();
				}
				GameUIold.gameContentPane1bCardsHand.validate();
				GameUIold.gameContentPane1bCardsHand.repaint();
			}
			if (player.getId() == 4) {
				GameUIold.gameContentPane1cCardsHand.removeAll();
				GameUIold.gameContentPane1cCardsHand.validate();
				GameUIold.gameContentPane1cCardsHand.repaint();
				GameUIold.gameContentPane1cCardsHand.add(new JLabel("PLAYER 4 \n handCards: "));
				for (Card card : cards) {
					GameUIold.gameContentPane1cCardsHand.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/" + card.getId() + ".jpg")))));
					GameUIold.gameContentPane1cCardsHand.validate();
					GameUIold.gameContentPane1cCardsHand.repaint();
				}
				GameUIold.gameContentPane1cCardsHand.validate();
				GameUIold.gameContentPane1cCardsHand.repaint();
			}
			if (player.getId() == 5) {
				GameUIold.gameContentPane1dCardsHand.removeAll();
				GameUIold.gameContentPane1dCardsHand.validate();
				GameUIold.gameContentPane1dCardsHand.repaint();
				GameUIold.gameContentPane1dCardsHand.add(new JLabel("PLAYER 5 \n handCards: "));
				for (Card card : cards) {
					GameUIold.gameContentPane1dCardsHand.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/" + card.getId() + ".jpg")))));
					GameUIold.gameContentPane1dCardsHand.validate();
					GameUIold.gameContentPane1dCardsHand.repaint();
				}
				GameUIold.gameContentPane1dCardsHand.validate();
				GameUIold.gameContentPane1dCardsHand.repaint();
			}
			if (player.getId() == 6) {
				GameUIold.gameContentPane1eCardsHand.removeAll();
				GameUIold.gameContentPane1eCardsHand.validate();
				GameUIold.gameContentPane1eCardsHand.repaint();
				GameUIold.gameContentPane1eCardsHand.add(new JLabel("PLAYER 6  \n handCards: "));
				for (Card card : cards) {
					GameUIold.gameContentPane1eCardsHand.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/" + card.getId() + ".jpg")))));
					GameUIold.gameContentPane1eCardsHand.validate();
					GameUIold.gameContentPane1eCardsHand.repaint();
				}
				GameUIold.gameContentPane1eCardsHand.validate();
				GameUIold.gameContentPane1eCardsHand.repaint();
			}
			GameUIold.gameContentPaneBasic.validate();
			GameUIold.gameContentPaneBasic.repaint();
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
				GameUIold.gameContentPane1aCardsPossible.removeAll();
				GameUIold.gameContentPane1aCardsPossible.validate();
				GameUIold.gameContentPane1aCardsPossible.repaint();
				GameUIold.gameContentPane1aCardsPossible.add(new JLabel("possible: "));
				for (Card card : cards) {
					GameUIold.gameContentPane1aCardsPossible.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/" + card.getId() + ".jpg")))));
					GameUIold.gameContentPane1aCardsPossible.validate();
					GameUIold.gameContentPane1aCardsPossible.repaint();
				}
				GameUIold.gameContentPane1aCardsPossible.validate();
				GameUIold.gameContentPane1aCardsPossible.repaint();
			}
			if (player.getId() == 3) {
				GameUIold.gameContentPane1bCardsPossible.removeAll();
				GameUIold.gameContentPane1bCardsPossible.validate();
				GameUIold.gameContentPane1bCardsPossible.repaint();
				GameUIold.gameContentPane1bCardsPossible.add(new JLabel("possible: "));
				for (Card card : cards) {
					GameUIold.gameContentPane1bCardsPossible.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/" + card.getId() + ".jpg")))));
					GameUIold.gameContentPane1bCardsPossible.validate();
					GameUIold.gameContentPane1bCardsPossible.repaint();
				}
				GameUIold.gameContentPane1bCardsPossible.validate();
				GameUIold.gameContentPane1bCardsPossible.repaint();
			}
			if (player.getId() == 4) {
				GameUIold.gameContentPane1cCardsPossible.removeAll();
				GameUIold.gameContentPane1cCardsPossible.validate();
				GameUIold.gameContentPane1cCardsPossible.repaint();
				GameUIold.gameContentPane1cCardsPossible.add(new JLabel("possible: "));
				for (Card card : cards) {
					GameUIold.gameContentPane1cCardsPossible.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/" + card.getId() + ".jpg")))));
					GameUIold.gameContentPane1cCardsPossible.validate();
					GameUIold.gameContentPane1cCardsPossible.repaint();
				}
				GameUIold.gameContentPane1cCardsPossible.validate();
				GameUIold.gameContentPane1cCardsPossible.repaint();
			}
			if (player.getId() == 5) {
				GameUIold.gameContentPane1dCardsPossible.removeAll();
				GameUIold.gameContentPane1dCardsPossible.validate();
				GameUIold.gameContentPane1dCardsPossible.repaint();
				GameUIold.gameContentPane1dCardsPossible.add(new JLabel("possible: "));
				for (Card card : cards) {
					GameUIold.gameContentPane1dCardsPossible.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/" + card.getId() + ".jpg")))));
					GameUIold.gameContentPane1dCardsPossible.validate();
					GameUIold.gameContentPane1dCardsPossible.repaint();
				}
				GameUIold.gameContentPane1dCardsPossible.validate();
				GameUIold.gameContentPane1dCardsPossible.repaint();
			}
			if (player.getId() == 6) {
				GameUIold.gameContentPane1eCardsPossible.removeAll();
				GameUIold.gameContentPane1eCardsPossible.validate();
				GameUIold.gameContentPane1eCardsPossible.repaint();
				GameUIold.gameContentPane1eCardsPossible.add(new JLabel("possible: "));
				for (Card card : cards) {
					GameUIold.gameContentPane1eCardsPossible.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/" + card.getId() + ".jpg")))));
					GameUIold.gameContentPane1eCardsPossible.validate();
					GameUIold.gameContentPane1eCardsPossible.repaint();
				}
				GameUIold.gameContentPane1eCardsPossible.validate();
				GameUIold.gameContentPane1eCardsPossible.repaint();
			}
			GameUIold.gameContentPaneBasic.validate();
			GameUIold.gameContentPaneBasic.repaint();
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
			GameUIold.gameContentPane5.remove(GameUIold.personLabel);
			GameUIold.gameContentPane5.validate();
			GameUIold.gameContentPane5.repaint();
			GameUIold.personLabel = new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/1.jpg"))));
			GameUIold.gameContentPane5.add(GameUIold.personLabel);
			GameUIold.gameContentPane5.validate();
			GameUIold.gameContentPane5.repaint();
	    	
			if (person != null) {
				GameUIold.gameContentPane5.remove(GameUIold.personLabel);
				GameUIold.gameContentPane5.validate();
				GameUIold.gameContentPane5.repaint();
				GameUIold.personLabel = new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/" + person.getId() + ".jpg"))));
				GameUIold.gameContentPane5.add(GameUIold.personLabel);
				GameUIold.gameContentPane5.validate();
				GameUIold.gameContentPane5.repaint();
			}
			else if (person == null) {
				GameUIold.gameContentPane5.remove(GameUIold.personLabel);
				GameUIold.gameContentPane5.validate();
				GameUIold.gameContentPane5.repaint();
				GameUIold.personLabel = new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/21.jpg"))));
				GameUIold.gameContentPane5.add(GameUIold.personLabel);
				GameUIold.gameContentPane5.validate();
				GameUIold.gameContentPane5.repaint();
			}
			if (weapon != null) {
				GameUIold.gameContentPane5.remove(GameUIold.weaponLabel);
				GameUIold.gameContentPane5.validate();
				GameUIold.gameContentPane5.repaint();
				GameUIold.weaponLabel = new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/" + weapon.getId() + ".jpg"))));
				GameUIold.gameContentPane5.add(GameUIold.weaponLabel);
				GameUIold.gameContentPane5.validate();
				GameUIold.gameContentPane5.repaint();
			}
			else if (weapon == null) {
				GameUIold.gameContentPane5.remove(GameUIold.weaponLabel);
				GameUIold.gameContentPane5.validate();
				GameUIold.gameContentPane5.repaint();
				GameUIold.weaponLabel = new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/21.jpg"))));
				GameUIold.gameContentPane5.add(GameUIold.weaponLabel);
				GameUIold.gameContentPane5.validate();
				GameUIold.gameContentPane5.repaint();
			}
			if (room != null) {
				GameUIold.gameContentPane5.remove(GameUIold.roomLabel);
				GameUIold.gameContentPane5.validate();
				GameUIold.gameContentPane5.repaint();
				GameUIold.roomLabel = new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/" + room.getId() + ".jpg"))));
				GameUIold.gameContentPane5.add(GameUIold.roomLabel);
				GameUIold.gameContentPane5.validate();
				GameUIold.gameContentPane5.repaint();
			}
			else if (room == null) {
				GameUIold.gameContentPane5.remove(GameUIold.roomLabel);
				GameUIold.gameContentPane5.validate();
				GameUIold.gameContentPane5.repaint();
				GameUIold.roomLabel = new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/21.jpg"))));
				GameUIold.gameContentPane5.add(GameUIold.roomLabel);
				GameUIold.gameContentPane5.validate();
				GameUIold.gameContentPane5.repaint();
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
			GameUIold.cnfPlayer2.removeAll();
			GameUIold.gameContentPane1aCNF.validate();
			GameUIold.gameContentPane1aCNF.repaint();
			if (!cnf.equals("empty")) GameUIold.cnfPlayer2.append(cnf);
			GameUIold.gameContentPane1aCNF.validate();
			GameUIold.gameContentPane1aCNF.repaint();
		}
		if (player.getId() == 3) {
			GameUIold.cnfPlayer3.removeAll();
			GameUIold.gameContentPane1bCNF.validate();
			GameUIold.gameContentPane1bCNF.repaint();
			if (!cnf.equals("empty")) GameUIold.cnfPlayer3.append(cnf);
			GameUIold.gameContentPane1bCNF.validate();
			GameUIold.gameContentPane1bCNF.repaint();
		}
		if (player.getId() == 4) {
			GameUIold.cnfPlayer4.removeAll();
			GameUIold.gameContentPane1cCNF.validate();
			GameUIold.gameContentPane1cCNF.repaint();
			if (!cnf.equals("empty")) GameUIold.cnfPlayer4.append(cnf);
			GameUIold.gameContentPane1cCNF.validate();
			GameUIold.gameContentPane1cCNF.repaint();
		}
		if (player.getId() == 5) {
			GameUIold.cnfPlayer5.removeAll();
			GameUIold.gameContentPane1dCNF.validate();
			GameUIold.gameContentPane1dCNF.repaint();
			if (!cnf.equals("empty")) GameUIold.cnfPlayer5.append(cnf);
			GameUIold.gameContentPane1dCNF.validate();
			GameUIold.gameContentPane1dCNF.repaint();
		}
		if (player.getId() == 6) {
			GameUIold.cnfPlayer6.removeAll();
			GameUIold.gameContentPane1eCNF.validate();
			GameUIold.gameContentPane1eCNF.repaint();
			if (!cnf.equals("empty")) GameUIold.cnfPlayer6.append(cnf);
			GameUIold.gameContentPane1eCNF.validate();
			GameUIold.gameContentPane1eCNF.repaint();
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
			GameUIold.logOutput.append("========================================\n");
			GameUIold.logOutput.append("PLAYER " + player.getId() + " SOLVED THE PUZZLE IN ROUND " + round + ".\n");
			GameUIold.logOutput.append("The murderer " + sol.getPerson() + " who used " + sol.getWeapon() + " in " + sol.getRoom() + ".\n");
			GameUIold.logOutput.append("========================================\n");
		}
		GameUIold.nextMove.setEnabled(false);	
	}
}
