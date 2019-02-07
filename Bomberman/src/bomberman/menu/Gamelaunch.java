package bomberman.menu;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import bomberman.tools.Asset;

public class Gamelaunch {

	public static void main(String[] args) {
		
		 SwingUtilities.invokeLater(new Runnable() {
		      public void run() {
		    	UIManager.put("Button.defaultButtonFollowsFocus", Boolean.TRUE);
		    	Asset.loadAssets();
		        new DynaMineGui();
		      }
		    });
	}

}
