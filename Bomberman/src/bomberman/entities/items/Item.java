package bomberman.entities.items;

import java.awt.Graphics;
import java.awt.Rectangle;
import bomberman.entities.Entity;
import bomberman.entities.Character;

public abstract class Item extends Entity {
	
	private boolean itemVisible = false;
	
	public Item (int xPos, int yPos) {
		this.setRectangle(new Rectangle(xPos, yPos, 60, 60));
		setX(xPos);
		setY(yPos);
	}

	@Override
	public void update() {
		//not needed
	};

	@Override
	public void render(Graphics graphics) {
		graphics.drawImage(this.getImage(), getX(), getY(), null);
	}
	
	public void setVisible() {
		itemVisible = true;
	}
	
	public void setInvisible() {
		itemVisible = false;
	}
	
	public boolean isVisible() {
		return itemVisible;
	}
	
	public abstract void consume(Character c);
	
}
