package bomberman.maingame;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 * Display class to be used in Game class
 * Sets up a JFrame containing a canvas
 * allows drawing to the screen and generally
 * setting up a window
 * 
 * @author Lukas Pruetzel
 *
 */

public class Display extends JPanel {

	private Canvas canvas;

	public Display(){
		setSize(getPreferredSize());
		
		canvas = new Canvas();
		canvas.setPreferredSize(getPreferredSize());
		canvas.setFocusable(true);
		this.add(canvas);
	}
	
	public Canvas getCanvas(){
		return canvas;
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(900,780);
	}
}