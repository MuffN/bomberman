package bomberman.menu;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import bomberman.maingame.Display;
import bomberman.maingame.Game;

public class DynaMineGui extends JPanel{

	/**
	 * 
	 * @author Patrick Schneider
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static JPanel guiContainer;
	private static StartMenu startmenu;
	private static Instructions instructions;
	private static Credits credits;
	private static PlayerMenu playermenu;
	private static SingleplayerBotmenu singleplayerbotmenu;
	private static MultiplayerBotmenu multiplayerbotmenu;
	private static Display gameDisplay;
	private static EndMenu endMenu;
	private static Game myGame;
	private static boolean needToCreateNewGame = false;
	private static String win = "WON THE GAME";
	private static String lose = "LOST THE GAME";
	private static String draw = "IT'S A DRAW";
	private static int amountOfPlayer,amountOfBots;
	
	
	public DynaMineGui() {
		
		myGame = new Game("DynaMine", 900, 780);
		guiContainer = new JPanel(new CardLayout());
		startmenu = new StartMenu();
		instructions = new Instructions();
		credits = new Credits();
		playermenu = new PlayerMenu();
		singleplayerbotmenu = new SingleplayerBotmenu();
		multiplayerbotmenu = new MultiplayerBotmenu();
		gameDisplay = myGame.getgameDisplay();
		endMenu = new EndMenu();
		guiContainer.add(startmenu, "StartMenu");
		guiContainer.add(instructions, "Instructions");
		guiContainer.add(credits, "Credits");
		guiContainer.add(playermenu, "PlayerMenu");
		guiContainer.add(singleplayerbotmenu, "SingleplayerBotMenu");
		guiContainer.add(multiplayerbotmenu, "MultiplayerBotMenu");
		guiContainer.add(endMenu, "EndMenu");
		guiContainer.add(gameDisplay, "GameDisplay");
		
		
		
		JFrame frame = new JFrame("DynaMine");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(guiContainer, BorderLayout.CENTER);
		//creating the glasspanel to catch all the mouseinteractions 
		MenuGlassPanel glass = MenuGlassPanel.getInstance();
		frame.setGlassPane(glass);
		glass.setVisible(true);
		
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	
	public static void changeToStart(){
		CardLayout cl = (CardLayout) guiContainer.getLayout();
		cl.show(guiContainer,"StartMenu");
		guiContainer.requestFocusInWindow();
		startmenu.setFocusFirst();
	}
	
	public static void backToMenu(){
		CardLayout cl = (CardLayout) guiContainer.getLayout();
		cl.show(guiContainer,"StartMenu");
		guiContainer.requestFocusInWindow();
		startmenu.setFocusFirst();
		needToCreateNewGame = true;
		myGame.stop();
	}
	
	public static void changeToInstructions(){
		CardLayout cl = (CardLayout) guiContainer.getLayout();
		cl.show(guiContainer,"Instructions");
		guiContainer.requestFocusInWindow();
		instructions.setFocusFirst();
	}
	
	public static void changeToCredits(){
		CardLayout cl = (CardLayout) guiContainer.getLayout();
		cl.show(guiContainer,"Credits");
		guiContainer.requestFocusInWindow();
		credits.setFocusFirst();
	}
	
	public static void changeToPlayerMenu(){
		CardLayout cl = (CardLayout) guiContainer.getLayout();
		cl.show(guiContainer,"PlayerMenu");
		playermenu.setFocusFirst();
	}
	
	public static void changeToSingleplayerBot(){
		CardLayout cl = (CardLayout) guiContainer.getLayout();
		cl.show(guiContainer,"SingleplayerBotMenu");
		singleplayerbotmenu.setFocusFirst();
	}
	
	public static void changeToMultiplayerBot(){
		CardLayout cl = (CardLayout) guiContainer.getLayout();
		cl.show(guiContainer,"MultiplayerBotMenu");
		multiplayerbotmenu.setFocusFirst();
	}
	
	public static void changeToEndScreen(int winner, int amountOfPlayer){
		if(amountOfPlayer == 1){
			if(winner == 1){
				endMenu.setEndResult("YOU", win);
			}else {
				endMenu.setEndResult("YOU", lose);
			}
		} else {
			if(winner == 0) {
				endMenu.setEndResult("BOTH OF YOU DIED", draw);
			} else if(winner == 1) {
				endMenu.setEndResult("PLAYER1", win);
			} else if(winner == 2) {
				endMenu.setEndResult("PLAYER2", win);
			} else {
				endMenu.setEndResult("BOTH OF YOU", lose);
			}
		}
		CardLayout cl = (CardLayout) guiContainer.getLayout();
		cl.show(guiContainer, "EndMenu");
		guiContainer.transferFocus();
		needToCreateNewGame = true;
		myGame.stop();
	}
		
	public static void changeToGame(int amountOfPlayer, int amountOfBots){
		DynaMineGui.amountOfPlayer = amountOfPlayer;
		DynaMineGui.amountOfBots = amountOfBots;
		
		if(needToCreateNewGame) {
			myGame = new Game("DynaMine",900,700);
			gameDisplay = myGame.getgameDisplay();
			guiContainer.add(gameDisplay, "GameDisplay");
		}
		CardLayout cl = (CardLayout) guiContainer.getLayout();
		cl.show(guiContainer, "GameDisplay");
		myGame.setAmountOfParticipants(amountOfPlayer, amountOfBots);
		myGame.start();
	}
	
	public static void changeToGame(){
		if(needToCreateNewGame) {
			myGame = new Game("DynaMine",900,700);
			gameDisplay = myGame.getgameDisplay();
			guiContainer.add(gameDisplay, "GameDisplay");
		}
		CardLayout cl = (CardLayout) guiContainer.getLayout();
		cl.show(guiContainer, "GameDisplay");
		myGame.setAmountOfParticipants(amountOfPlayer, amountOfBots);
		myGame.start();
	}
	
	public static void changeToExit(){
		System.exit(0);
	}
	
}
