package ui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import control.Game;
import control.Player;
import control.StupidPlayer;
import control.ai.AIPlayer;

public class SetupUI {
    static JFrame setup = new JFrame();
    static JPanel setupContentPaneBasic = new JPanel(new GridLayout(5,0));
    static JPanel setupContentPane1 = new JPanel();
    static JPanel setupContentPane2 = new JPanel();
    static JPanel setupContentPane3 = new JPanel();
    static JPanel setupContentPane4 = new JPanel();
    static JPanel setupContentPane5 = new JPanel(); 
    static JFrame error = new JFrame();
    static JPanel errorContentPaneBasic = new JPanel(new GridLayout(5,0));
    static JPanel errorContentPane1 = new JPanel();
    static JPanel errorContentPane2 = new JPanel();
    static JPanel errorContentPane3 = new JPanel();
    static JPanel errorContentPane4 = new JPanel();
    static JPanel errorContentPane5 = new JPanel();
    
	static JLabel playersOwn = new JLabel("my own player");
	static SpinnerModel playerAIListModel = new SpinnerNumberModel(1,0,5,1);
	static JLabel playersAIPlus = new JLabel("+");
	static JSpinner playersAIList = new JSpinner(playerAIListModel);
	static JLabel playersAI = new JLabel("AI players");
	static SpinnerModel playerStupidListModel = new SpinnerNumberModel(1,0,5,1);
	static JSpinner playersStupidList = new JSpinner(playerStupidListModel);
	static JLabel playersStupidPlus = new JLabel("+");
	static JLabel playersStupid = new JLabel("stupid players");
	static JLabel playersWarning = new JLabel("(altogether max. 6 players)");
    static JButton startGame = new JButton("start game");
	static JLabel playersError1 = new JLabel("Please re-check the numbers of players!");
	static JLabel playersError2 = new JLabel("The maximum number of players is 6,");
	static JLabel playersError3 = new JLabel("the minimum number 2. Please click the ");
	static JLabel playersError4 = new JLabel("button below to return to the setup menu.");
    static JButton okay = new JButton("OK");
    
	public SetupUI() {
    	setupContentPaneBasic.add(setupContentPane1);
    	setupContentPaneBasic.add(setupContentPane2);
    	setupContentPaneBasic.add(setupContentPane3);
    	setupContentPaneBasic.add(setupContentPane4);
    	setupContentPaneBasic.add(setupContentPane5);
    	
		setupContentPane1.add(playersOwn);
		setupContentPane2.add(playersAIPlus);
		setupContentPane2.add(playersAIList);
		setupContentPane2.add(playersAI);
		setupContentPane3.add(playersStupidPlus);
		setupContentPane3.add(playersStupidList);
		setupContentPane3.add(playersStupid);
		setupContentPane4.add(playersWarning);
		setupContentPane5.add(startGame);
    	
        setup.add(setupContentPaneBasic);
        setup.setPreferredSize(new Dimension(250,200));
        setup.setTitle("Cluedo - choose players");
        setup.pack();
        setup.setVisible(true);
        
        startGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int numPlayersStupid = (Integer)playersStupidList.getValue();
            	int numPlayersAI = (Integer)playersAIList.getValue();
            	int numPlayers = numPlayersStupid + numPlayersAI;
            	if(numPlayers < 1 || numPlayers > 5) {
            		errorContentPaneBasic.add(errorContentPane1);
            		errorContentPaneBasic.add(errorContentPane2);
            		errorContentPaneBasic.add(errorContentPane3);
            		errorContentPaneBasic.add(errorContentPane4);
            		errorContentPaneBasic.add(errorContentPane5);
            		errorContentPane1.add(playersError1);
            		errorContentPane2.add(playersError2);
            		errorContentPane3.add(playersError3);
            		errorContentPane4.add(playersError4);
            		errorContentPane5.add(okay);
                    error.add(errorContentPaneBasic);
                    error.setPreferredSize(new Dimension(250,200));
                    error.setTitle("Cluedo - choose players");
                    error.pack();
                    error.setVisible(true);
                    okay.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                        	error.setVisible(false);
                        }
                    });
            	} else {
            		try {
            			List<Player> players = new LinkedList<Player>();
            			final int fullIntelligence = 1; 
            					//+ AIAbility.HAND_CARDS_TRACKING.getId()
            					//+ AIAbility.CARD_RANKING.getId()
            					//+ AIAbility.CNF_REASONING.getId()
            					;
            			numPlayersAI--;
            			Game game = new Game();
            			int id = 1;
            			players.add(new AIPlayer(
            					game, "Myself", id++, true, fullIntelligence));
            			for (; numPlayersAI > 0; numPlayersAI--) { // Add AI players
            				players.add(new AIPlayer(game, "AI" + String.valueOf(id),
            						id++, false, fullIntelligence));
            			}
            			for (; numPlayersStupid > 0; numPlayersStupid--) { // Add stupid players
            				players.add(new StupidPlayer(game, "Stupid" + String.valueOf(id),
            						id++));
            			}
            			game.start(players);
            			new GameUI(numPlayers+1, game); 
            		} catch (IOException ex) {
            			ex.printStackTrace(); 
            		}
            		setup.setVisible(false);
            	}
            }
        });
	}

	public static void main(String[] args) {
		new SetupUI();
	}
}