package bomberman.entities.items;

import bomberman.entities.Character;
import bomberman.tools.Asset;

public class CharacterSpeedDowngrade extends Item {

	public CharacterSpeedDowngrade(int xPos, int yPos) {
		super(xPos, yPos);
		this.setImage(Asset.item_speedDown);
	}

	@Override
	public void consume(Character c) {
		c.setCharacterSpeed(c.getCharacterSpeed()-2);
		
	}
}
