package bomberman.menu;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

/**
 * 
 * @author Patrick Schneider
 * 
 */
public class StartMenu extends MenuPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	private JButton[] startmenubuttons;
	private static String[] buttonNames = { "START", "INSTRUCTIONS", "CREDITS", "QUIT GAME" };

	public StartMenu() {
		
		super(buttonNames);
		startmenubuttons = super.getMenubuttons();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if ("START".equals(ae.getActionCommand())) {
			DynaMineGui.changeToPlayerMenu();
		}
		if ("INSTRUCTIONS".equals(ae.getActionCommand())){
			DynaMineGui.changeToInstructions();
		}
		if ("CREDITS".equals(ae.getActionCommand())){
			DynaMineGui.changeToCredits();
		}
		if ("QUIT GAME".equals(ae.getActionCommand())) {
			DynaMineGui.changeToExit();
		}
	}

	public void setFocusFirst() {
		startmenubuttons[0].requestFocusInWindow();
	}
}
