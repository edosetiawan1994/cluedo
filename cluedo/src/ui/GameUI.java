package ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import control.Card;
import control.Game;
import control.Player;
import control.ai.AIPlayer;

public class GameUI {
	// declaration of main frame, main panel and subpanels
    static JFrame game = new JFrame();
    
    static JPanel gameContentPaneBasic = new JPanel(new GridBagLayout());
    
    static JPanel playerI = new JPanel(new FlowLayout());
    static JPanel playerIcards = new JPanel();
    static JPanel solutionPanel = new JPanel();
    
    static JPanel player1 = new JPanel(new GridBagLayout());
    static JPanel player1cards = new JPanel();
    static JPanel player1possible = new JPanel();
    static JTextArea cnfPlayer1 = new JTextArea();
    
    static JPanel player2 = new JPanel(new GridBagLayout());
    static JPanel player2cards = new JPanel();
    static JPanel player2possible = new JPanel();
    static JTextArea cnfPlayer2 = new JTextArea();
    
    static JPanel player3 = new JPanel(new GridBagLayout());
    static JPanel player3cards = new JPanel();
    static JPanel player3possible = new JPanel();
    static JTextArea cnfPlayer3 = new JTextArea();
    
    static JPanel player4 = new JPanel(new GridBagLayout());
    static JPanel player4cards = new JPanel();
    static JPanel player4possible = new JPanel();
    static JTextArea cnfPlayer4 = new JTextArea();
        
    static JPanel player5 = new JPanel(new GridBagLayout());
    static JPanel player5cards = new JPanel();
    static JPanel player5possible = new JPanel();
    static JTextArea cnfPlayer5 = new JTextArea();
    
    //contains panels player1 to player5
    static JPanel players = new JPanel(new GridBagLayout());
    
    static JPanel buttonPane = new JPanel();
    static JPanel loggPane = new JPanel();
	static JScrollPane loggPaneScroll = new JScrollPane();
	
    static JButton exitProgram = new JButton("exit program");
    static JButton nextMove = new JButton("next move");
    static JTextArea logOutput = new JTextArea();
	
    static JLabel personLabel;
    static JLabel weaponLabel;
    static JLabel roomLabel;
    
	public GameUI(int numPlayers1, final Game nonUIGame) throws IOException {
		List<Player> playersList = nonUIGame.getPlayers();
		int numPlayers = playersList.size();
		int i;
		Image unknownImage = ImageIO.read(new File("cluedoCards/42.jpg"));
		GridBagConstraints gridConst;
		
		Rectangle window = GraphicsEnvironment.getLocalGraphicsEnvironment().
        		getMaximumWindowBounds();
		int height = window.height/6 - 10;
		int width = window.width/4 - 20;
		Dimension maxPaneSize = new Dimension(3 * width+10, height + 30);
	    Dimension maxHandCardSize = new Dimension(width+30, height/5*4);
	    Dimension maxPossibleCardSize = new Dimension(2 * width-30, height/5*4);
	    Dimension maxCNFdim = new Dimension(maxPaneSize.width, 15);
	    Dimension logSize = new Dimension(width - 50, 3 * window.height / 4 - 50);
		
		// first player panel =================================================
    	String playerName = playersList.get(1).getName();
    	
    	cnfPlayer1.setEditable(false);
        cnfPlayer1.setLineWrap(true);
        cnfPlayer1.setWrapStyleWord(true);
        cnfPlayer1.setMaximumSize(maxCNFdim);
        cnfPlayer1.setPreferredSize(maxCNFdim);
        gridConst = new GridBagConstraints();
        gridConst.gridwidth = 3;
        gridConst.gridx = 0;
        gridConst.gridy = 0;
        player1.add(cnfPlayer1, gridConst);
        
        int hcNo = nonUIGame.getPlayers().get(1).getHandCards().size();
        for (i = 0; i < hcNo; i++) {
        	player1cards.add(new JLabel(new ImageIcon(unknownImage)));
        }
        player1cards.setBorder(BorderFactory.createCompoundBorder(
    			BorderFactory.createTitledBorder(playerName + 
    					"'s hand cards"),
    			BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        player1cards.setPreferredSize(maxHandCardSize);
        player1cards.setMaximumSize(maxHandCardSize);
        
        gridConst = new GridBagConstraints();
        gridConst.gridwidth = 1;
        gridConst.gridx = 0;
        gridConst.gridy = 1;
		
		player1.add(player1cards, gridConst);
        
		player1possible.setBorder(BorderFactory.createCompoundBorder(
    			BorderFactory.createTitledBorder(playerName + 
    					"'s possible hand cards"),
    			BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		player1possible.setPreferredSize(maxPossibleCardSize);
		player1possible.setMaximumSize(maxPossibleCardSize);
		gridConst = new GridBagConstraints();
        gridConst.gridwidth = 2;
        gridConst.gridx = 1;
        gridConst.gridy = 1;
		player1.add(player1possible, gridConst);
		player1.setMaximumSize(maxPaneSize);
		
		/*
		gridConst = new GridBagConstraints();
		gridConst.gridwidth = 3;
		gridConst.gridx = 0;
		gridConst.gridy = 1;
		gameContentPaneBasic.add(player2, gridConst);*/
		gridConst = new GridBagConstraints();
		gridConst.gridy = 0;
		players.add(player1, gridConst);
		// first player panel ============================================ended
		
		// second player panel ================================================
		if (numPlayers > 2) {
			playerName = playersList.get(2).getName();
	    	
	    	cnfPlayer2.setEditable(false);
	        cnfPlayer2.setLineWrap(true);
	        cnfPlayer2.setWrapStyleWord(true);
	        cnfPlayer2.setMaximumSize(maxCNFdim);
	        cnfPlayer2.setPreferredSize(maxCNFdim);
	        gridConst = new GridBagConstraints();
	        gridConst.gridwidth = 3;
	        gridConst.gridx = 0;
	        gridConst.gridy = 0;
	        player2.add(cnfPlayer2, gridConst);
	        
	        hcNo = nonUIGame.getPlayers().get(2).getHandCards().size();
	        for (i = 0; i < hcNo; i++) {
	        	player2cards.add(new JLabel(new ImageIcon(unknownImage)));
	        }
	        player2cards.setBorder(BorderFactory.createCompoundBorder(
	    			BorderFactory.createTitledBorder(playerName + 
	    					"'s hand cards"),
	    			BorderFactory.createEmptyBorder(5, 5, 5, 5)));
	        player2cards.setPreferredSize(maxHandCardSize);
	        player2cards.setMaximumSize(maxHandCardSize);
	        gridConst = new GridBagConstraints();
	        gridConst.gridwidth = 1;
	        gridConst.gridx = 0;
	        gridConst.gridy = 1;
			player2.add(player2cards, gridConst);
	        
			player2possible.setBorder(BorderFactory.createCompoundBorder(
	    			BorderFactory.createTitledBorder(playerName + 
	    					"'s possible hand cards"),
	    			BorderFactory.createEmptyBorder(5, 5, 5, 5)));
			player2possible.setPreferredSize(maxPossibleCardSize);
			player2possible.setMaximumSize(maxPossibleCardSize);
			gridConst = new GridBagConstraints();
	        gridConst.gridwidth = 2;
	        gridConst.gridx = 1;
	        gridConst.gridy = 1;
			player2.add(player2possible, gridConst);
			player2.setMaximumSize(maxPaneSize);
			
			/*
			gridConst = new GridBagConstraints();
			gridConst.gridwidth = 3;
			gridConst.gridx = 0;
			gridConst.gridy = 1;
			gameContentPaneBasic.add(player2, gridConst);*/
			gridConst = new GridBagConstraints();
			gridConst.gridy = 1;
			players.add(player2, gridConst);
		}
		// second player panel ===========================================ended
    	
		// third player panel =================================================
		if (numPlayers > 3) {
			playerName = playersList.get(3).getName();
	    	
	    	cnfPlayer3.setEditable(false);
	        cnfPlayer3.setLineWrap(true);
	        cnfPlayer3.setWrapStyleWord(true);
	        cnfPlayer3.setMaximumSize(maxCNFdim);
	        cnfPlayer3.setPreferredSize(maxCNFdim);
	        gridConst = new GridBagConstraints();
	        gridConst.gridwidth = 3;
	        gridConst.gridx = 0;
	        gridConst.gridy = 0;
	        player3.add(cnfPlayer3, gridConst);
	        
	        hcNo = nonUIGame.getPlayers().get(3).getHandCards().size();
	        for (i = 0; i < hcNo; i++) {
	        	player3cards.add(new JLabel(new ImageIcon(unknownImage)));
	        }
	        player3cards.setBorder(BorderFactory.createCompoundBorder(
	    			BorderFactory.createTitledBorder(playerName + 
	    					"'s hand cards"),
	    			BorderFactory.createEmptyBorder(5, 5, 5, 5)));
	        player3cards.setPreferredSize(maxHandCardSize);
	        player3cards.setMaximumSize(maxHandCardSize);
	        gridConst = new GridBagConstraints();
	        gridConst.gridwidth = 1;
	        gridConst.gridx = 0;
	        gridConst.gridy = 1;
			player3.add(player3cards, gridConst);
	        
			player3possible.setBorder(BorderFactory.createCompoundBorder(
	    			BorderFactory.createTitledBorder(playerName + 
	    					"'s possible hand cards"),
	    			BorderFactory.createEmptyBorder(5, 5, 5, 5)));
			player3possible.setPreferredSize(maxPossibleCardSize);
			player3possible.setMaximumSize(maxPossibleCardSize);
			gridConst = new GridBagConstraints();
	        gridConst.gridwidth = 2;
	        gridConst.gridx = 1;
	        gridConst.gridy = 1;
			player3.add(player3possible, gridConst);
			player3.setMaximumSize(maxPaneSize);
			
			/*
			gridConst = new GridBagConstraints();
			gridConst.gridwidth = 3;
			gridConst.gridx = 0;
			gridConst.gridy = 2;
			gameContentPaneBasic.add(player3, gridConst);*/
			gridConst = new GridBagConstraints();
			gridConst.gridy = 2;
			players.add(player3, gridConst);
		}
		// third player panel ===========================================ended
		
		// fourth player panel ================================================
		if (numPlayers > 4) {
			playerName = playersList.get(4).getName();
	    	
	    	cnfPlayer4.setEditable(false);
	        cnfPlayer4.setLineWrap(true);
	        cnfPlayer4.setWrapStyleWord(true);
	        cnfPlayer4.setMaximumSize(maxCNFdim);
	        cnfPlayer4.setPreferredSize(maxCNFdim);
	        gridConst = new GridBagConstraints();
	        gridConst.gridwidth = 3;
	        gridConst.gridx = 0;
	        gridConst.gridy = 0;
	        player4.add(cnfPlayer4, gridConst);
	        
	        hcNo = nonUIGame.getPlayers().get(4).getHandCards().size();
	        for (i = 0; i < hcNo; i++) {
	        	player4cards.add(new JLabel(new ImageIcon(unknownImage)));
	        }
	        player4cards.setBorder(BorderFactory.createCompoundBorder(
	    			BorderFactory.createTitledBorder(playerName + 
	    					"'s hand cards"),
	    			BorderFactory.createEmptyBorder(5, 5, 5, 5)));
	        player4cards.setPreferredSize(maxHandCardSize);
	        player4cards.setMaximumSize(maxHandCardSize);
	        gridConst = new GridBagConstraints();
	        gridConst.gridwidth = 1;
	        gridConst.gridx = 0;
	        gridConst.gridy = 1;
			player4.add(player4cards, gridConst);
	        
			player4possible.setBorder(BorderFactory.createCompoundBorder(
	    			BorderFactory.createTitledBorder(playerName + 
	    					"'s possible hand cards"),
	    			BorderFactory.createEmptyBorder(5, 5, 5, 5)));
			player4possible.setPreferredSize(maxPossibleCardSize);
			player4possible.setMaximumSize(maxPossibleCardSize);
			gridConst = new GridBagConstraints();
	        gridConst.gridwidth = 2;
	        gridConst.gridx = 1;
	        gridConst.gridy = 1;
			player4.add(player4possible, gridConst);
			player4.setMaximumSize(maxPaneSize);
			
			/*
			gridConst = new GridBagConstraints();
			gridConst.gridwidth = 3;
			gridConst.gridx = 0;
			gridConst.gridy = 3;
			gameContentPaneBasic.add(player4, gridConst);*/
			gridConst = new GridBagConstraints();
			gridConst.gridy = 3;
			players.add(player4, gridConst);
		}
		// fourth player panel ===========================================ended
		
		// fifth player panel ================================================
		if (numPlayers > 5) {
			playerName = playersList.get(5).getName();
	    	
	    	cnfPlayer5.setEditable(false);
	        cnfPlayer5.setLineWrap(true);
	        cnfPlayer5.setWrapStyleWord(true);
	        cnfPlayer5.setMaximumSize(maxCNFdim);
	        cnfPlayer5.setPreferredSize(maxCNFdim);
	        gridConst = new GridBagConstraints();
	        gridConst.gridwidth = 3;
	        gridConst.gridx = 0;
	        gridConst.gridy = 0;
	        player5.add(cnfPlayer5, gridConst);
	        
	        hcNo = nonUIGame.getPlayers().get(5).getHandCards().size();
	        for (i = 0; i < hcNo; i++) {
	        	player5cards.add(new JLabel(new ImageIcon(unknownImage)));
	        }
	        player5cards.setBorder(BorderFactory.createCompoundBorder(
	    			BorderFactory.createTitledBorder(playerName + 
	    					"'s hand cards"),
	    			BorderFactory.createEmptyBorder(5, 5, 5, 5)));
	        player5cards.setPreferredSize(maxHandCardSize);
	        player5cards.setMaximumSize(maxHandCardSize);
	        gridConst = new GridBagConstraints();
	        gridConst.gridwidth = 1;
	        gridConst.gridx = 0;
	        gridConst.gridy = 1;
			player5.add(player5cards, gridConst);
	        
			player5possible.setBorder(BorderFactory.createCompoundBorder(
	    			BorderFactory.createTitledBorder(playerName + 
	    					"'s possible hand cards"),
	    			BorderFactory.createEmptyBorder(5, 5, 5, 5)));
			player5possible.setPreferredSize(maxPossibleCardSize);
			player5possible.setMaximumSize(maxPossibleCardSize);
			gridConst = new GridBagConstraints();
	        gridConst.gridwidth = 2;
	        gridConst.gridx = 1;
	        gridConst.gridy = 1;
			player5.add(player5possible, gridConst);
			player5.setMaximumSize(maxPaneSize);
			
			/*
			gridConst = new GridBagConstraints();
			gridConst.gridwidth = 3;
			gridConst.gridx = 0;
			gridConst.gridy = 3;
			gameContentPaneBasic.add(player4, gridConst);*/
			gridConst = new GridBagConstraints();
			gridConst.gridy = 4;
			players.add(player5, gridConst);
		}
		// fourth player panel ===========================================ended
		
		// myself panel =======================================================
		Player myself = playersList.get(0);
		Set<Card> ownHandCards = nonUIGame.getPlayers().get(0).getHandCards();
        for (Card c : ownHandCards) {
        	playerIcards.add(new JLabel(new ImageIcon(ImageIO.read(
        			new File("cluedoCards/" + c.getId() + ".jpg")
        			))));
        }
        playerIcards.setBorder(BorderFactory.createCompoundBorder(
    			BorderFactory.createTitledBorder(myself.getName() + "'s hand cards"),
    			BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        playerIcards.setMaximumSize(maxPossibleCardSize);
        playerIcards.setPreferredSize(maxPossibleCardSize);
        
        JScrollPane playerIcardsSP = new JScrollPane(playerIcards);
        playerIcardsSP.setHorizontalScrollBarPolicy(
        		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        playerIcardsSP.setBorder(BorderFactory.createEmptyBorder());
		playerI.add(playerIcardsSP);
		
		personLabel = new JLabel(new ImageIcon(unknownImage));
        weaponLabel = new JLabel(new ImageIcon(unknownImage));
        roomLabel = new JLabel(new ImageIcon(unknownImage));
        
        solutionPanel.add(personLabel);
        solutionPanel.add(weaponLabel);
        solutionPanel.add(roomLabel);
    	solutionPanel.setBorder(BorderFactory.createCompoundBorder(
    			BorderFactory.createTitledBorder("Solution"),
    			BorderFactory.createEmptyBorder(5, 5, 5, 5)));
    	solutionPanel.setMaximumSize(maxHandCardSize);
    	solutionPanel.setPreferredSize(maxHandCardSize);
		playerI.add(solutionPanel);
		playerI.setMinimumSize(maxPaneSize);
    	playerI.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    	
    	gridConst = new GridBagConstraints();
		gridConst.gridwidth = 3;
		gridConst.gridx = 0;
		gridConst.gridy = numPlayers - 1;
		gameContentPaneBasic.add(playerI, gridConst);
    	// myself panel ==================================================ended
		
		// player panel =======================================================
		gridConst = new GridBagConstraints();
		gridConst.gridwidth = 3;
		gridConst.gridheight = numPlayers - 2;
		gridConst.gridx = 0;
		gridConst.gridy = 0;
		gameContentPaneBasic.add(players, gridConst);
		//TODO: add JScrollPane to players panel
		// player panel ==================================================ended
		
		// logg panel =========================================================
		// preparation of text area for log output
        logOutput.setEditable(false);
        logOutput.setLineWrap(true);
        logOutput.setWrapStyleWord(true);
        logOutput.setSize(logSize);
        logOutput.setMaximumSize(logSize);
        logOutput.setMinimumSize(logSize);
        logOutput.setPreferredSize(logSize);
        
        
        //TODO: repair JScrollPane of loggPane (or logOutput)
		loggPaneScroll.add(loggPane);
		loggPane.add(logOutput);
        loggPaneScroll.setPreferredSize(logSize);             
        logSize.width += 50;
        logSize.height += 50;
        loggPaneScroll.setPreferredSize(logSize);
        loggPaneScroll.setMaximumSize(logSize);
        loggPaneScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        loggPaneScroll.setViewportView(loggPane);
        
        gridConst = new GridBagConstraints();
		gridConst.gridwidth = 1;
		gridConst.gridheight = numPlayers - 1;
		gridConst.gridx = 3;
		gridConst.gridy = 0;
		gameContentPaneBasic.add(loggPane, gridConst);
		// logg panel ====================================================ended
		
		// buttons panel ======================================================
		buttonPane.add(nextMove);
		buttonPane.add(exitProgram);
		
		gridConst = new GridBagConstraints();
		gridConst.gridwidth = 1;
		gridConst.gridx = 3;
		gridConst.gridy = numPlayers - 1;
		gameContentPaneBasic.add(buttonPane, gridConst);
		// buttons panel =================================================ended
		
		/*
		// addition of components to subpanels 1-5
		gameContentPane1aCards.add(gameContentPane1aCardsHandScroll);
    	{
    		gameContentPane1aCardsHandScroll.setViewportView(gameContentPane1aCardsHand);
    	}
		gameContentPane1aCards.add(gameContentPane1aCardsPossibleScroll);
    	{
    		gameContentPane1aCardsPossibleScroll.setViewportView(gameContentPane1aCardsPossible);
    	}
		gameContentPane1aCards.setBorder(BorderFactory.createLineBorder(Color.black));
		
		gameContentPane1bCards.add(gameContentPane1bCardsHandScroll);
	   	{
    		gameContentPane1bCardsHandScroll.setViewportView(gameContentPane1bCardsHand);
    	}
		gameContentPane1bCards.add(gameContentPane1bCardsPossibleScroll);
    	{
    		gameContentPane1bCardsPossibleScroll.setViewportView(gameContentPane1bCardsPossible);
    	}
		gameContentPane1bCards.setBorder(BorderFactory.createLineBorder(Color.black));

		gameContentPane1cCards.add(gameContentPane1cCardsHandScroll);
	   	{
    		gameContentPane1cCardsHandScroll.setViewportView(gameContentPane1cCardsHand);
    	}
	   	gameContentPane1cCards.add(gameContentPane1cCardsPossibleScroll);
    	{
    		gameContentPane1cCardsPossibleScroll.setViewportView(gameContentPane1cCardsPossible);
    	}
		gameContentPane1cCards.setBorder(BorderFactory.createLineBorder(Color.black));
		
		gameContentPane1dCards.add(gameContentPane1dCardsHandScroll);
	   	{
    		gameContentPane1dCardsHandScroll.setViewportView(gameContentPane1dCardsHand);
    	}
	   	gameContentPane1dCards.add(gameContentPane1dCardsPossibleScroll);
    	{
    		gameContentPane1dCardsPossibleScroll.setViewportView(gameContentPane1dCardsPossible);
    	}
		gameContentPane1dCards.setBorder(BorderFactory.createLineBorder(Color.black));
		
		gameContentPane1eCards.add(gameContentPane1eCardsHandScroll);
	   	{
    		gameContentPane1eCardsHandScroll.setViewportView(gameContentPane1eCardsHand);
    	}
	   	gameContentPane1eCards.add(gameContentPane1eCardsPossibleScroll);
    	{
    		gameContentPane1eCardsPossibleScroll.setViewportView(gameContentPane1eCardsPossible);
    	}
		gameContentPane1eCards.setBorder(BorderFactory.createLineBorder(Color.black));

		gameContentPane2.add(logOutputScroll);
    	{
    		logOutputScroll.setViewportView(logOutput);
            logOutputScroll.setPreferredSize(new java.awt.Dimension(300,700));
    	}        
		*/
        // definition of buttons
        exitProgram.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	game.setVisible(false);
            }
        });
        
        nextMove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	nonUIGame.nextMove();
            }
        });
        
        // preparation of main frame
        // TODO: add JScrollPane to the whole game (or gameContentPaneBasic panel)
        game.add(gameContentPaneBasic);
        game.setTitle("Cluedo - game");
        game.pack();
        game.setBounds(window);
        game.setVisible(true);
	}
	
	public static void main(String[] args) {
		try {
			Game game = new Game();
			List<Player> players = new ArrayList<Player>();
			players.add(new AIPlayer(game, "myself", 0, true, 7));
			players.add(new AIPlayer(game, "AI 1", 1, false, 3));
			players.add(new AIPlayer(game, "AI 2", 2, false, 3));
			game.start(players);
			new GameUI(3, game);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
}