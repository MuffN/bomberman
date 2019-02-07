package bomberman.entities.items;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import bomberman.maingame.Map;

//Item object creates new Items, puts them into ItemList and manages them accordingly
public class ItemManager {
	public static List<Item> AllItems = new ArrayList<Item>();
	
	public ItemManager(List<Rectangle> ZgList) {
		if(ZgList.isEmpty()) {
			System.out.println("WARNING: EMPTY ZG LIST"); //Notifiy that ZG List is empty --> no items created
		}
		init(ZgList);
	}
	
	//generate Items beneath ZGs
	public void init(List<Rectangle> ZgList) {
		for(Rectangle zg : ZgList) {
			generateItem((int)zg.getX(), (int)zg.getY());
		}
	}

	public void update() {
		for(Item item : ItemManager.AllItems) {
			item.setVisible();
			for(Rectangle r : Map.zgList) {
				if(item.getRectangle().intersects(r)) {
					item.setInvisible();
				}
			}
		}
		
	}

	public void render(Graphics graphics) {
		for(Item item : AllItems) {
			if(item.isVisible()) {
				item.render(graphics);
			}
			
		}
	}
	
	private void generateItem(int x, int y) {
		int tempRandomNumber = (int)(Math.random()*100); //Zahl zwischen 1 und 100
				
		if(tempRandomNumber <= 10) { //10% chance
			AllItems.add(new BombNumberUpgrade(x, y));
		} 
		else if (tempRandomNumber <= 20) { //10% chance
			AllItems.add(new BlastRadiusUpgrade(x, y));
		}
		else if (tempRandomNumber <= 30) { //10% chance
			//AllItems.add(new CharacterSpeedUpgrade(x, y));
		}
		else if (tempRandomNumber <= 33) { //3% chance
			AllItems.add(new BombNumberDowngrade(x, y));
		}
		else if (tempRandomNumber <= 36) { //3% chance
			AllItems.add(new BlastRadiusDowngrade(x, y));
		}
		else if (tempRandomNumber <= 39) { //3% chance
			//AllItems.add(new CharacterSpeedDowngrade(x, y));
		}
	}	

}
