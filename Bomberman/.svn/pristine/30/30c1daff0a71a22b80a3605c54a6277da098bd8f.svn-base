package bomberman.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * 
 * @author Patrick Schneider
 * 
 */
public class SingleplayerBotmenu extends MenuPanel implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JButton[] singleplayerBotbuttons;
	private static String[] buttonNames = { "1 BOT", "2 BOTS", "3 BOTS", "GO BACK", "QUIT GAME" };

	public SingleplayerBotmenu() {

		super(buttonNames);
		singleplayerBotbuttons = super.getMenubuttons();	
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if ("1 BOT".equals(ae.getActionCommand())) {
			DynaMineGui.changeToGame(1, 1);
		}
		if ("2 BOTS".equals(ae.getActionCommand())) {
			DynaMineGui.changeToGame(1, 2);
		}
		if ("3 BOTS".equals(ae.getActionCommand())) {
			DynaMineGui.changeToGame(1, 3);
		}
		if ("GO BACK".equals(ae.getActionCommand())) {

			DynaMineGui.changeToPlayerMenu();
		}
		if ("QUIT GAME".equals(ae.getActionCommand())) {
			DynaMineGui.changeToExit();
		}
	}

	public void setFocusFirst() {
		singleplayerBotbuttons[0].requestFocusInWindow();
	}

}