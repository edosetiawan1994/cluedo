package ui;

import ui.com.cloudgarden.layout.AnchorConstraint;
import ui.com.cloudgarden.layout.AnchorLayout;

import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import control.Game;

public class GameUI {
	// declaration of main frame, main panel and subpanels
    static JFrame game = new JFrame();
    static JPanel gameContentPaneBasic = new JPanel();
    static JPanel gameContentPane1a = new JPanel(new GridLayout(2,0));
    static JPanel gameContentPane1b = new JPanel(new GridLayout(2,0));
    static JPanel gameContentPane1c = new JPanel(new GridLayout(2,0));
    static JPanel gameContentPane1d = new JPanel(new GridLayout(2,0));
    static JPanel gameContentPane1e = new JPanel(new GridLayout(2,0));
    static JScrollPane gameContentPane2 = new JScrollPane();
    static JPanel gameContentPane3 = new JPanel();
    static JPanel gameContentPane4 = new JPanel();
    static JPanel gameContentPane5 = new JPanel();

    // declaration of even more subpanels
    static JPanel gameContentPane1aCards = new JPanel(new GridLayout(0,2));
	static JPanel gameContentPane1aCardsHand = new JPanel();
	static JPanel gameContentPane1aCardsPossible = new JPanel();
	static JScrollPane gameContentPane1aCardsPossibleScroll = new JScrollPane();
	static JPanel gameContentPane1aCNF = new JPanel();
	
    static JPanel gameContentPane1bCards = new JPanel(new GridLayout(0,2));
	static JPanel gameContentPane1bCardsHand = new JPanel();
	static JPanel gameContentPane1bCardsPossible = new JPanel();
	static JScrollPane gameContentPane1bCardsPossibleScroll = new JScrollPane();
	static JPanel gameContentPane1bCNF = new JPanel();
	
    static JPanel gameContentPane1cCards = new JPanel(new GridLayout(0,2));
	static JPanel gameContentPane1cCardsHand = new JPanel();
	static JPanel gameContentPane1cCardsPossible = new JPanel();
	static JScrollPane gameContentPane1cCardsPossibleScroll = new JScrollPane();
	static JPanel gameContentPane1cCNF = new JPanel();
	
    static JPanel gameContentPane1dCards = new JPanel(new GridLayout(0,2));
	static JPanel gameContentPane1dCardsHand = new JPanel();
	static JPanel gameContentPane1dCardsPossible = new JPanel();
	static JScrollPane gameContentPane1dCardsPossibleScroll = new JScrollPane();
	static JPanel gameContentPane1dCNF = new JPanel();
	
    static JPanel gameContentPane1eCards = new JPanel(new GridLayout(0,2));
	static JPanel gameContentPane1eCardsHand = new JPanel();
	static JPanel gameContentPane1eCardsPossible = new JPanel();
	static JScrollPane gameContentPane1eCardsPossibleScroll = new JScrollPane();
	static JPanel gameContentPane1eCNF = new JPanel();
    
	// declaration of components for subpanels
	static AnchorLayout anchorLayout = new AnchorLayout();
    static JButton exitProgram = new JButton("exit program");
    static JButton nextMove = new JButton("next move");
    static JTextArea logOutput = new JTextArea();
    static JTextArea cnfPlayer2 = new JTextArea();
    static JTextArea cnfPlayer3 = new JTextArea();
    static JTextArea cnfPlayer4 = new JTextArea();
    static JTextArea cnfPlayer5 = new JTextArea();
    static JTextArea cnfPlayer6 = new JTextArea();
    
	public GameUI(int numPlayers, final Game nonUIGame) throws IOException {
		// addition of subpanels 1-5 to main panel
		gameContentPaneBasic.setLayout(anchorLayout);
		gameContentPaneBasic.add(gameContentPane1aCards, new AnchorConstraint(0, 712, 120, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
		gameContentPaneBasic.add(gameContentPane1aCNF, new AnchorConstraint(120, 712, 150, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
		if(numPlayers > 2) {
			gameContentPaneBasic.add(gameContentPane1bCards, new AnchorConstraint(180, 712, 300, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			gameContentPaneBasic.add(gameContentPane1bCNF, new AnchorConstraint(300, 712, 330, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
		}
		if(numPlayers > 3) {
			gameContentPaneBasic.add(gameContentPane1cCards, new AnchorConstraint(360, 712, 480, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			gameContentPaneBasic.add(gameContentPane1cCNF, new AnchorConstraint(480, 712, 510, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
		}
		if(numPlayers > 4) {
			gameContentPaneBasic.add(gameContentPane1dCards, new AnchorConstraint(540, 712, 660, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			gameContentPaneBasic.add(gameContentPane1dCNF, new AnchorConstraint(660, 712, 690, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
		}
		if(numPlayers > 5) {
			gameContentPaneBasic.add(gameContentPane1eCards, new AnchorConstraint(720, 712, 840, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			gameContentPaneBasic.add(gameContentPane1eCNF, new AnchorConstraint(840, 712, 870, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
		}
    	gameContentPaneBasic.add(gameContentPane2, new AnchorConstraint(0, 1000, 795, 761, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
		gameContentPaneBasic.add(gameContentPane3, new AnchorConstraint(881, 1000, 1000, 761, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
		gameContentPaneBasic.add(gameContentPane4, new AnchorConstraint(900, 422, 1000, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
		gameContentPaneBasic.add(gameContentPane5, new AnchorConstraint(900, 712, 1000, 419, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
	
		// addition of components to subpanels 1-5
		gameContentPane1aCards.add(gameContentPane1aCardsHand);
		gameContentPane1aCardsHand.setPreferredSize(new java.awt.Dimension(477, 113));
		gameContentPane1aCards.add(gameContentPane1aCardsPossibleScroll);
    	{
    		gameContentPane1aCardsPossibleScroll.setViewportView(gameContentPane1aCardsPossible);
    	}
		gameContentPane1aCards.setBorder(BorderFactory.createLineBorder(Color.black));
		
		gameContentPane1bCards.add(gameContentPane1bCardsHand);
		gameContentPane1bCardsHand.setPreferredSize(new java.awt.Dimension(477, 113));
		gameContentPane1bCards.add(gameContentPane1bCardsPossibleScroll);
    	{
    		gameContentPane1bCardsPossibleScroll.setViewportView(gameContentPane1bCardsPossible);
    	}
		gameContentPane1bCards.setBorder(BorderFactory.createLineBorder(Color.black));

		gameContentPane1cCards.add(gameContentPane1cCardsHand);
		gameContentPane1cCardsHand.setPreferredSize(new java.awt.Dimension(477, 113));
		gameContentPane1cCards.add(gameContentPane1cCardsPossibleScroll);
    	{
    		gameContentPane1cCardsPossibleScroll.setViewportView(gameContentPane1cCardsPossible);
    	}
		gameContentPane1cCards.setBorder(BorderFactory.createLineBorder(Color.black));
		
		gameContentPane1dCards.add(gameContentPane1dCardsHand);
		gameContentPane1dCardsHand.setPreferredSize(new java.awt.Dimension(477, 113));
		gameContentPane1dCards.add(gameContentPane1dCardsPossibleScroll);
    	{
    		gameContentPane1dCardsPossibleScroll.setViewportView(gameContentPane1dCardsPossible);
    	}
		gameContentPane1dCards.setBorder(BorderFactory.createLineBorder(Color.black));
		
		gameContentPane1eCards.add(gameContentPane1eCardsHand);
		gameContentPane1eCardsHand.setPreferredSize(new java.awt.Dimension(477, 113));
		gameContentPane1eCards.add(gameContentPane1eCardsPossibleScroll);
    	{
    		gameContentPane1eCardsPossibleScroll.setViewportView(gameContentPane1eCardsPossible);
    	}
		gameContentPane1eCards.setBorder(BorderFactory.createLineBorder(Color.black));
		
    	gameContentPane2.setPreferredSize(new java.awt.Dimension(285, 768));
    	gameContentPane2.setViewportView(logOutput);
		gameContentPane3.add(exitProgram);
		gameContentPane3.add(nextMove);
    	gameContentPane3.setPreferredSize(new java.awt.Dimension(596, 293));
    	gameContentPane4.add(new JLabel("Player 1 hand: "));
    	gameContentPane4.setPreferredSize(new java.awt.Dimension(545, 97));
    	gameContentPane4.setBorder(BorderFactory.createLineBorder(Color.black));
    	gameContentPane5.add(new JLabel("Solution: "));
    	gameContentPane5.setPreferredSize(new java.awt.Dimension(379, 97));
    	gameContentPane5.setBorder(BorderFactory.createLineBorder(Color.black));
    	
    	// addition of card pictures and CNF text area for first computer player (Player 2)
    	gameContentPane1aCardsHand.add(new JLabel("PLAYER 2           hand: "));
    	gameContentPane1aCardsHand.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/21.jpg")))));
    	gameContentPane1aCardsHand.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/21.jpg")))));
    	gameContentPane1aCardsHand.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/21.jpg")))));
    	gameContentPane1aCardsHand.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/21.jpg")))));
    	gameContentPane1aCardsHand.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/21.jpg")))));
    	gameContentPane1aCardsPossible.add(new JLabel("possible: "));
    	gameContentPane1aCardsPossible.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/1.jpg")))));
    	gameContentPane1aCardsPossible.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/2.jpg")))));
    	gameContentPane1aCardsPossible.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/3.jpg")))));
    	gameContentPane1aCardsPossible.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/4.jpg")))));
    	gameContentPane1aCardsPossible.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/1.jpg")))));
    	gameContentPane1aCardsPossible.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/2.jpg")))));
    	gameContentPane1aCardsPossible.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/3.jpg")))));
    	gameContentPane1aCardsPossible.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/3.jpg")))));
    	cnfPlayer2.setEditable(false);
        cnfPlayer2.setLineWrap(true);
        cnfPlayer2.setWrapStyleWord(true);
        cnfPlayer2.append("(blablabla v blabla2 v blablabla3) v (blablabla4 v blablabla5)");
        cnfPlayer2.setPreferredSize(new java.awt.Dimension(848,40));
        gameContentPane1aCNF.add(cnfPlayer2);
        
    	gameContentPane1bCardsHand.add(new JLabel("PLAYER 3           hand: "));
    	gameContentPane1bCardsHand.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/21.jpg")))));
    	gameContentPane1bCardsHand.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/21.jpg")))));
    	gameContentPane1bCardsHand.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/21.jpg")))));
    	gameContentPane1bCardsHand.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/21.jpg")))));
    	gameContentPane1bCardsHand.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/21.jpg")))));
    	gameContentPane1bCardsPossible.add(new JLabel("possible: "));
    	gameContentPane1bCardsPossible.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/1.jpg")))));
    	gameContentPane1bCardsPossible.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/2.jpg")))));
    	gameContentPane1bCardsPossible.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/3.jpg")))));
    	gameContentPane1bCardsPossible.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/4.jpg")))));
    	gameContentPane1bCardsPossible.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/1.jpg")))));
    	gameContentPane1bCardsPossible.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/2.jpg")))));
    	gameContentPane1bCardsPossible.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/3.jpg")))));
    	cnfPlayer3.setEditable(false);
        cnfPlayer3.setLineWrap(true);
        cnfPlayer3.setWrapStyleWord(true);
        cnfPlayer3.append("(blablabla v blabla2 v blablabla3) v (blablabla4 v blablabla5)");
        cnfPlayer3.setPreferredSize(new java.awt.Dimension(848,40));
        gameContentPane1bCNF.add(cnfPlayer3);
        
    	gameContentPane1cCardsHand.add(new JLabel("PLAYER 4           hand: "));
    	gameContentPane1cCardsHand.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/21.jpg")))));
    	gameContentPane1cCardsHand.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/21.jpg")))));
    	gameContentPane1cCardsHand.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/21.jpg")))));
    	gameContentPane1cCardsHand.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/21.jpg")))));
    	gameContentPane1cCardsHand.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/21.jpg")))));
    	gameContentPane1cCardsPossible.add(new JLabel("possible: "));
    	gameContentPane1cCardsPossible.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/1.jpg")))));
    	gameContentPane1cCardsPossible.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/2.jpg")))));
    	gameContentPane1cCardsPossible.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/3.jpg")))));
    	gameContentPane1cCardsPossible.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/4.jpg")))));
    	gameContentPane1cCardsPossible.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/1.jpg")))));
    	gameContentPane1cCardsPossible.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/2.jpg")))));
    	gameContentPane1cCardsPossible.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/3.jpg")))));
    	cnfPlayer4.setEditable(false);
        cnfPlayer4.setLineWrap(true);
        cnfPlayer4.setWrapStyleWord(true);
        cnfPlayer4.append("(blablabla v blabla2 v blablabla3) v (blablabla4 v blablabla5)");
        cnfPlayer4.setPreferredSize(new java.awt.Dimension(848,40));
        gameContentPane1cCNF.add(cnfPlayer4);
        
    	gameContentPane1dCardsHand.add(new JLabel("PLAYER 5           hand: "));
    	gameContentPane1dCardsHand.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/21.jpg")))));
    	gameContentPane1dCardsHand.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/21.jpg")))));
    	gameContentPane1dCardsHand.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/21.jpg")))));
    	gameContentPane1dCardsHand.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/21.jpg")))));
    	gameContentPane1dCardsHand.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/21.jpg")))));
    	gameContentPane1dCardsPossible.add(new JLabel("possible: "));
    	gameContentPane1dCardsPossible.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/1.jpg")))));
    	gameContentPane1dCardsPossible.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/2.jpg")))));
    	gameContentPane1dCardsPossible.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/3.jpg")))));
    	gameContentPane1dCardsPossible.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/4.jpg")))));
    	gameContentPane1dCardsPossible.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/1.jpg")))));
    	gameContentPane1dCardsPossible.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/2.jpg")))));
    	gameContentPane1dCardsPossible.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/3.jpg")))));
    	cnfPlayer5.setEditable(false);
        cnfPlayer5.setLineWrap(true);
        cnfPlayer5.setWrapStyleWord(true);
        cnfPlayer5.append("(blablabla v blabla2 v blablabla3) v (blablabla4 v blablabla5)");
        cnfPlayer5.setPreferredSize(new java.awt.Dimension(848,40));
        gameContentPane1dCNF.add(cnfPlayer5);
        
    	gameContentPane1eCardsHand.add(new JLabel("PLAYER 6           hand: "));
    	gameContentPane1eCardsHand.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/21.jpg")))));
    	gameContentPane1eCardsHand.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/21.jpg")))));
    	gameContentPane1eCardsHand.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/21.jpg")))));
    	gameContentPane1eCardsHand.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/21.jpg")))));
    	gameContentPane1eCardsHand.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/21.jpg")))));
    	gameContentPane1eCardsPossible.add(new JLabel("possible: "));
    	gameContentPane1eCardsPossible.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/1.jpg")))));
    	gameContentPane1eCardsPossible.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/2.jpg")))));
    	gameContentPane1eCardsPossible.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/3.jpg")))));
    	gameContentPane1eCardsPossible.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/4.jpg")))));
    	gameContentPane1eCardsPossible.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/1.jpg")))));
    	gameContentPane1eCardsPossible.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/2.jpg")))));
    	gameContentPane1eCardsPossible.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/3.jpg")))));
    	cnfPlayer6.setEditable(false);
        cnfPlayer6.setLineWrap(true);
        cnfPlayer6.setWrapStyleWord(true);
        cnfPlayer6.append("(blablabla v blabla2 v blablabla3) v (blablabla4 v blablabla5)");
        cnfPlayer6.setPreferredSize(new java.awt.Dimension(848,40));
        gameContentPane1eCNF.add(cnfPlayer6);
        
        // addition of card pictures for our own player (Player 1)
        gameContentPane4.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/1.jpg")))));
        gameContentPane4.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/2.jpg")))));
    	gameContentPane4.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/3.jpg")))));
    	gameContentPane4.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/4.jpg")))));
    	gameContentPane4.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/5.jpg")))));
        
        // addition of card pictures for the solution
    	gameContentPane5.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/21.jpg")))));
        gameContentPane5.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/21.jpg")))));
        gameContentPane5.add(new JLabel(new ImageIcon(ImageIO.read(new File("cluedoCards/21.jpg")))));
    	
        // preparation of text area for log output
        logOutput.setEditable(false);
        logOutput.append("LOG OUTPUT:\n\n");
        logOutput.append("first log statement\n");
        logOutput.append("second log statement\n");
        logOutput.append("many more statements to come\n");
        gameContentPane2.setViewportView(logOutput);
        logOutput.setPreferredSize(new java.awt.Dimension(267, 753));

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
        game.add(gameContentPaneBasic);
        game.setTitle("Cluedo - game");
        game.pack();
        game.setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());
        game.setVisible(true);
	}
	
	public static void main(String[] args) {
		try {
			new GameUI(2, new Game());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}