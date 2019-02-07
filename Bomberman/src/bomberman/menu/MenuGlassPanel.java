package bomberman.menu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;

public class MenuGlassPanel extends JComponent {
	
	private static MenuGlassPanel instance = new MenuGlassPanel();

	@Override
	public void setVisible(boolean isvisible) {
		super.setVisible(isvisible);
	}

	public MenuGlassPanel() {
		addMouseListener (new MouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				e.consume();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				e.consume();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				e.consume();
			}
			
		});
	}
	
	public static MenuGlassPanel getInstance() {
        return instance;
    }

}
