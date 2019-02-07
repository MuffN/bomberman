package bomberman.entities.items;

import bomberman.entities.Character;
import bomberman.tools.Asset;

public class CharacterSpeedUpgrade extends Item {

	public CharacterSpeedUpgrade(int xPos, int yPos) {
		super(xPos, yPos);
		this.setImage(Asset.item_speedUp);
	}

	@Override
	public void consume(Character c) {
		c.setCharacterSpeed(c.getCharacterSpeed()+2);
	}
}
