package bomberman.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 * The entity class is the parent class
 * of all items and objects inside the game
 * 
 * @author Lukas Pruetzel
 *
 */
public abstract class Entity {

	private int x,y;
	private int nextY, nextX;
	private Rectangle rectangle;

	private BufferedImage img;
	
	public abstract void update();
	public abstract void render(Graphics graphics);
	
	public void move() {
		x = nextX;
		y = nextY;
	}
	
	public void moveX(int num) {
		x += num;
	}
	
	public void moveY(int num) {
		y += num;
	}
	
	public void resetNextXY() {
		nextX=x;
		nextY=y;
	}
	
	public void setImage(BufferedImage img) {
		this.img = img;
	}
	
	//GETTER & SETTER
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x=x;
	}
	public void setY(int y) {
		this.y=y;
	}
	
	public int getNextX() {
		return nextX;
	}
	
	public int getNextY() {
		return nextY;
	}
	
	public void setNextX(int cHARACTER_SPEED) {
		this.nextX += cHARACTER_SPEED;
	}
	
	public void setNextY(int cHARACTER_SPEED) {
		this.nextY += cHARACTER_SPEED;
	}
		
	public BufferedImage getImage() {
		return img;
	}
	public Rectangle getRectangle() {
		return rectangle;
	}
	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}
}
