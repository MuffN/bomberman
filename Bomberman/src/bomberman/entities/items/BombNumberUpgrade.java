package bomberman.entities.items;

import bomberman.entities.Character;
import bomberman.tools.Asset;

public class BombNumberUpgrade extends Item {

	public BombNumberUpgrade(int xPos, int yPos) {
		super(xPos, yPos);
		this.setImage(Asset.item_dynamiteUp); //MISSING ART HERE
	}

	@Override
	public void consume(Character c) {
		c.setAllowedBombs(c.getAllowedBombs()+1);
		
	}
}
