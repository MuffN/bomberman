package bomberman.menu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import bomberman.tools.Asset;

import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * 
 * @author Patrick Schneider
 * 
 */
public class EndMenu extends MenuPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private JButton[] endmenubuttons;
	private static String[] buttonNames = {"REPLAY","MENU","QUIT GAME"};
	private JLabel firstLabel;
	private JLabel secondLabel;
	
	
	public EndMenu() {
		
		super(buttonNames);
		firstLabel = new JLabel();
		secondLabel = new JLabel();
		firstLabel.setForeground(Color.YELLOW);
		secondLabel.setForeground(Color.YELLOW);
		firstLabel.setBounds(200, 240, 500, 50);
		firstLabel.setFont(Asset.pcsenior.deriveFont(26f));
		secondLabel.setBounds(200, 290, 500, 50);
		secondLabel.setFont(Asset.pcsenior.deriveFont(22f));
		endmenubuttons = super.getMenubuttons();
		
		add(firstLabel);
		add(secondLabel);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if("REPLAY".equals(ae.getActionCommand())){
			DynaMineGui.changeToGame();
		}
		if("MENU".equals(ae.getActionCommand())){
			DynaMineGui.changeToStart();
		}
		if("QUIT GAME".equals(ae.getActionCommand())){
			DynaMineGui.changeToExit();
		}
	}
	
	public void setFocusFirst(){
		endmenubuttons[0].requestFocusInWindow();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(Asset.menu_background, 0, 0, null);
	}
	
	public void setEndResult(String firstRow, String secondRow){
		
		firstLabel.setHorizontalAlignment(SwingConstants.CENTER);
		secondLabel.setHorizontalAlignment(SwingConstants.CENTER);
		firstLabel.setText(firstRow);
		secondLabel.setText(secondRow);
	}
	
	@Override
	protected void setTheBounds(int i){
		getMenubuttons()[i].setBounds(250, 490 + (i*40), 400, 40);
	}
}
