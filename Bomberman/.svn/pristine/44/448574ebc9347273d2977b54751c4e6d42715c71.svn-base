package bomberman.entities.items;

import bomberman.entities.Character;
import bomberman.tools.Asset;

public class BlastRadiusUpgrade extends Item {

	public BlastRadiusUpgrade(int xPos, int yPos) {
		super(xPos, yPos);
		this.setImage(Asset.item_blastUp);
	}

	@Override
	public void consume(Character c) {
		c.setBlastRadius(c.getBlastRadius()+1);
	}
}
