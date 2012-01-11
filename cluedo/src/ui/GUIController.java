package ui;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import control.Card;
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
		String oldLog = GameUI.logOutput.getText();
		str += "\n " + oldLog;
		GameUI.logOutput.removeAll();
		GameUI.logOutput.setText(str);
		GameUI.logOutput.repaint();
	}

	/* (non-Javadoc)
	 * @see ui.UIController#updateCertainHandCardsPanel
	 * 		(control.Player, java.util.Set)
	 */
	@Override
	public void updateCertainHandCardsPanel(Player player, Set<Card> cards) {
		try {
			if (player.getId() == 1) {
				GameUI.player1cards.removeAll();
				GameUI.player1cards.validate();
				GameUI.player1cards.repaint();
				for (Card card : cards) {
					GameUI.player1cards.add(new JLabel(new ImageIcon(
							ImageIO.read(new File("cluedoCards/" + 
									card.getId() + ".jpg")))));
					GameUI.player1cards.validate();
					GameUI.player1cards.repaint();
				}
				int diff = player.countHandCards() - cards.size();
				if (diff > 0) {
					for (int i = 0; i < diff; i++) {
						GameUI.player1cards.add(new JLabel(new ImageIcon(
								ImageIO.read(new File("cluedoCards/42.jpg")))));
					}
					GameUI.player1cards.validate();
					GameUI.player1cards.repaint();
				}
				GameUI.player1cards.validate();
				GameUI.player1cards.repaint();
			}
			if (player.getId() == 2) {
				GameUI.player2cards.removeAll();
				GameUI.player2cards.validate();
				GameUI.player2cards.repaint();
				for (Card card : cards) {
					GameUI.player2cards.add(new JLabel(new ImageIcon(
							ImageIO.read(new File("cluedoCards/" + 
									card.getId() + ".jpg")))));
					GameUI.player2cards.validate();
					GameUI.player2cards.repaint();
				}
				int diff = player.countHandCards() - cards.size();
				if (diff > 0) {
					for (int i = 0; i < diff; i++) {
						GameUI.player2cards.add(new JLabel(new ImageIcon(
								ImageIO.read(new File("cluedoCards/42.jpg")))));
					}
					GameUI.player2cards.validate();
					GameUI.player2cards.repaint();
				}
				GameUI.player2cards.validate();
				GameUI.player2cards.repaint();
			}
			if (player.getId() == 3) {
				GameUI.player3cards.removeAll();
				GameUI.player3cards.validate();
				GameUI.player3cards.repaint();
				for (Card card : cards) {
					GameUI.player3cards.add(new JLabel(new ImageIcon(
							ImageIO.read(new File("cluedoCards/" + 
									card.getId() + ".jpg")))));
					GameUI.player3cards.validate();
					GameUI.player3cards.repaint();
				}
				int diff = player.countHandCards() - cards.size();
				if (diff > 0) {
					for (int i = 0; i < diff; i++) {
						GameUI.player3cards.add(new JLabel(new ImageIcon(
								ImageIO.read(new File("cluedoCards/42.jpg")))));
					}
					GameUI.player3cards.validate();
					GameUI.player3cards.repaint();
				}
				GameUI.player3cards.validate();
				GameUI.player3cards.repaint();
			}
			if (player.getId() == 4) {
				GameUI.player4cards.removeAll();
				GameUI.player4cards.validate();
				GameUI.player4cards.repaint();
				for (Card card : cards) {
					GameUI.player4cards.add(new JLabel(new ImageIcon(
							ImageIO.read(new File("cluedoCards/" + 
									card.getId() + ".jpg")))));
					GameUI.player4cards.validate();
					GameUI.player4cards.repaint();
				}
				int diff = player.countHandCards() - cards.size();
				if (diff > 0) {
					for (int i = 0; i < diff; i++) {
						GameUI.player4cards.add(new JLabel(new ImageIcon(
								ImageIO.read(new File("cluedoCards/42.jpg")))));
					}
					GameUI.player4cards.validate();
					GameUI.player4cards.repaint();
				}
				GameUI.player4cards.validate();
				GameUI.player4cards.repaint();
			}
			if (player.getId() == 5) {
				GameUI.player5cards.removeAll();
				GameUI.player5cards.validate();
				GameUI.player5cards.repaint();
				for (Card card : cards) {
					GameUI.player5cards.add(new JLabel(new ImageIcon(
							ImageIO.read(new File("cluedoCards/" + 
									card.getId() + ".jpg")))));
					GameUI.player5cards.validate();
					GameUI.player5cards.repaint();
				}
				int diff = player.countHandCards() - cards.size();
				if (diff > 0) {
					for (int i = 0; i < diff; i++) {
						GameUI.player5cards.add(new JLabel(new ImageIcon(
								ImageIO.read(new File("cluedoCards/42.jpg")))));
					}
					GameUI.player5cards.validate();
					GameUI.player5cards.repaint();
				}
				GameUI.player5cards.validate();
				GameUI.player5cards.repaint();
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
			if (player.getId() == 1) {
				GameUI.player1possible.removeAll();
				GameUI.player1possible.validate();
				GameUI.player1possible.repaint();
				for (Card card : cards) {
					GameUI.player1possible.add(new JLabel(new ImageIcon(
							ImageIO.read(new File("cluedoCards/" + 
									card.getId() + ".jpg")))));
					GameUI.player1possible.validate();
					GameUI.player1possible.repaint();
				}
				GameUI.player2possible.validate();
				GameUI.player2possible.repaint();
			}
			if (player.getId() == 2) {
				GameUI.player2possible.removeAll();
				GameUI.player2possible.validate();
				GameUI.player2possible.repaint();
				for (Card card : cards) {
					GameUI.player2possible.add(new JLabel(new ImageIcon(
							ImageIO.read(new File("cluedoCards/" + 
									card.getId() + ".jpg")))));
					GameUI.player2possible.validate();
					GameUI.player2possible.repaint();
				}
				GameUI.player2possible.validate();
				GameUI.player2possible.repaint();
			}
			if (player.getId() == 3) {
				GameUI.player3possible.removeAll();
				GameUI.player3possible.validate();
				GameUI.player3possible.repaint();
				for (Card card : cards) {
					GameUI.player3possible.add(new JLabel(new ImageIcon(
							ImageIO.read(new File("cluedoCards/" + 
									card.getId() + ".jpg")))));
					GameUI.player3possible.validate();
					GameUI.player3possible.repaint();
				}
				GameUI.player4possible.validate();
				GameUI.player4possible.repaint();
			}
			if (player.getId() == 4) {
				GameUI.player4possible.removeAll();
				GameUI.player4possible.validate();
				GameUI.player4possible.repaint();
				for (Card card : cards) {
					GameUI.player4possible.add(new JLabel(new ImageIcon(
							ImageIO.read(new File("cluedoCards/" + 
									card.getId() + ".jpg")))));
					GameUI.player4possible.validate();
					GameUI.player4possible.repaint();
				}
				GameUI.player4possible.validate();
				GameUI.player4possible.repaint();
			}
			if (player.getId() == 5) {
				GameUI.player5possible.removeAll();
				GameUI.player5possible.validate();
				GameUI.player5possible.repaint();
				for (Card card : cards) {
					GameUI.player5possible.add(new JLabel(new ImageIcon(
							ImageIO.read(new File("cluedoCards/" + 
									card.getId() + ".jpg")))));
					GameUI.player5possible.validate();
					GameUI.player5possible.repaint();
				}
				GameUI.player5possible.validate();
				GameUI.player5possible.repaint();
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
			GameUI.personLabel.removeAll();
			GameUI.personLabel.validate();
			GameUI.personLabel.repaint();
			GameUI.weaponLabel.removeAll();
			GameUI.weaponLabel.validate();
			GameUI.weaponLabel.repaint();
			GameUI.roomLabel.removeAll();
			GameUI.roomLabel.validate();
			GameUI.roomLabel.repaint();
			GameUI.solutionPanel.removeAll();
			GameUI.solutionPanel.validate();
			GameUI.solutionPanel.repaint();
			if (person != null) {
				GameUI.personLabel = new JLabel(new ImageIcon(ImageIO.read(
						new File("cluedoCards/" + person.getId() + ".jpg"))));
			} else {
				GameUI.personLabel = new JLabel(new ImageIcon(
						ImageIO.read(new File("cluedoCards/42.jpg"))));
			}
			if (weapon != null) {
				GameUI.weaponLabel = new JLabel(new ImageIcon(ImageIO.read(
						new File("cluedoCards/" + weapon.getId() + ".jpg"))));
			} else {
				GameUI.weaponLabel = new JLabel(new ImageIcon(
						ImageIO.read(new File("cluedoCards/42.jpg"))));
			}
			if (room != null) {
				GameUI.roomLabel = new JLabel(new ImageIcon(ImageIO.read(
						new File("cluedoCards/" + room.getId() + ".jpg"))));
			} else {
				GameUI.roomLabel = new JLabel(new ImageIcon(
						ImageIO.read(new File("cluedoCards/42.jpg"))));
			}
			GameUI.personLabel.validate();
			GameUI.personLabel.repaint();
			GameUI.weaponLabel.validate();
			GameUI.weaponLabel.repaint();
			GameUI.roomLabel.validate();
			GameUI.roomLabel.repaint();
			GameUI.solutionPanel.validate();
			GameUI.solutionPanel.add(GameUI.personLabel);
			GameUI.solutionPanel.add(GameUI.weaponLabel);
			GameUI.solutionPanel.add(GameUI.roomLabel);
			GameUI.solutionPanel.repaint();
			GameUI.playerI.validate();
			GameUI.playerI.repaint();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see ui.UIController#updateCNFPanel(control.Player, java.lang.String)
	 */
	@Override
	public void updateCNFPanel(Player player, String cnf) {
		if (player.getId() == 1) {
			GameUI.player1.validate();
			GameUI.player1.repaint();
			GameUI.cnfPlayer1.removeAll();
			GameUI.cnfPlayer1.validate();
			GameUI.cnfPlayer1.repaint();
			if (!cnf.equals("empty")) {
				GameUI.cnfPlayer1.append(cnf);
			}
			GameUI.cnfPlayer1.validate();
			GameUI.cnfPlayer1.repaint();
			GameUI.player1.validate();
			GameUI.player1.repaint();
		}
		if (player.getId() == 2) {
			GameUI.player2.validate();
			GameUI.player2.repaint();
			GameUI.cnfPlayer2.removeAll();
			GameUI.cnfPlayer2.validate();
			GameUI.cnfPlayer2.repaint();
			if (!cnf.equals("empty")) {
				GameUI.cnfPlayer2.append(cnf);
			}
			GameUI.cnfPlayer2.validate();
			GameUI.cnfPlayer2.repaint();
			GameUI.player2.validate();
			GameUI.player2.repaint();
		}
		if (player.getId() == 3) {
			GameUI.player3.validate();
			GameUI.player3.repaint();
			GameUI.cnfPlayer3.removeAll();
			GameUI.cnfPlayer3.validate();
			GameUI.cnfPlayer3.repaint();
			if (!cnf.equals("empty")) {
				GameUI.cnfPlayer3.append(cnf);
			}
			GameUI.cnfPlayer3.validate();
			GameUI.cnfPlayer3.repaint();
			GameUI.player3.validate();
			GameUI.player3.repaint();
		}
		if (player.getId() == 4) {
			GameUI.player4.validate();
			GameUI.player4.repaint();
			GameUI.cnfPlayer4.removeAll();
			GameUI.cnfPlayer4.validate();
			GameUI.cnfPlayer4.repaint();
			if (!cnf.equals("empty")) {
				GameUI.cnfPlayer4.append(cnf);
			}
			GameUI.cnfPlayer4.validate();
			GameUI.cnfPlayer4.repaint();
			GameUI.player4.validate();
			GameUI.player4.repaint();
		}
		if (player.getId() == 5) {
			GameUI.player5.validate();
			GameUI.player5.repaint();
			GameUI.cnfPlayer5.removeAll();
			GameUI.cnfPlayer5.validate();
			GameUI.cnfPlayer5.repaint();
			if (!cnf.equals("empty")) {
				GameUI.cnfPlayer5.append(cnf);
			}
			GameUI.cnfPlayer5.validate();
			GameUI.cnfPlayer5.repaint();
			GameUI.player5.validate();
			GameUI.player5.repaint();
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
			String oldLog = GameUI.logOutput.getText();
			String str = "==============================\n" +  
					player.getName() + " SOLVED THE PUZZLE IN ROUND " + round +
					".\n The murderer " + sol.getPerson() + " who used " + 
					sol.getWeapon() + " in " + sol.getRoom() + ".\n" +
					"==============================\n" + oldLog;
			GameUI.logOutput.removeAll();
			GameUI.logOutput.setText(str);
			GameUI.logOutput.repaint();
			GameUI.nextMove.setEnabled(false);
		}
	}
}
