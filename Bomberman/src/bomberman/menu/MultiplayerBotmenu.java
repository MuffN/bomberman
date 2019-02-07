package bomberman.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * 
 * @author Patrick Schneider
 * 
 */
public class MultiplayerBotmenu extends MenuPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
		
	private JButton[] multiplayerBotbuttons;
	private static String[] buttonNames = {"WITHOUT BOTS","1 BOT","2 BOTS","GO BACK","QUIT GAME"};
	
	public MultiplayerBotmenu() {
		
		super(buttonNames);
		multiplayerBotbuttons = super.getMenubuttons();
		
//		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae){
		if("WITHOUT BOTS".equals(ae.getActionCommand())){
			DynaMineGui.changeToGame(2, 0);
		}
		if("1 BOT".equals(ae.getActionCommand())){
			DynaMineGui.changeToGame(2, 1);
		}
		if("2 BOTS".equals(ae.getActionCommand())){
			DynaMineGui.changeToGame(2, 2);
		}
		if("GO BACK".equals(ae.getActionCommand())){
			DynaMineGui.changeToPlayerMenu();
		}
		if("QUIT GAME".equals(ae.getActionCommand())){
			DynaMineGui.changeToExit();
		}
	}
	
	public void setFocusFirst(){
		multiplayerBotbuttons[0].requestFocusInWindow();
	}
	
}