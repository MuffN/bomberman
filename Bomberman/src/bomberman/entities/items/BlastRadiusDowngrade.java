package bomberman.entities.items;

import bomberman.entities.Character;
import bomberman.tools.Asset;

public class BlastRadiusDowngrade extends Item {

	public BlastRadiusDowngrade(int xPos, int yPos) {
		super(xPos, yPos);
		this.setImage(Asset.item_blastDown);
	}

	@Override
	public void consume(Character c) {
		c.setBlastRadius(c.getBlastRadius()-1);
	}
}
