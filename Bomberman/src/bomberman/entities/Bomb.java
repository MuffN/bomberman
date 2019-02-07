package bomberman.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import bomberman.maingame.Map;
import bomberman.maingame.Settings;
import bomberman.tools.Asset;

public class Bomb extends Entity {

	private int x, y, timer, blastRadius;

	private enum Direction {
		NORTH, EAST, SOUTH, WEST
	}

	private List<Rectangle> explosionList = new ArrayList<Rectangle>();
	public static List<Bomb> bombList = new ArrayList<Bomb>();
	private boolean explosionHappend = false;
	private int charNum;
	private boolean removeBomb = false;

	public Bomb(int x, int y, int charNum, int blastRadius) {
		this.x = x;
		this.y = y;
		this.timer = Settings.DEFAULT_BOMB_TIMER;
		this.charNum = charNum;
		this.blastRadius = blastRadius;
		this.setRectangle(new Rectangle(x, y, 60, 60));
		this.init();
	}

	public void init() {
		Bomb.bombList.add(this);
	}

	// decrease bomb Timer and trigger explosion if necessary
	// returns true if timer can be decreased; false if bomb exploded
	public void decreaseBombTimerX() {
		if (timer <= 0) {
			Bomb.bombList.remove(this);
			Map.blastList.removeAll(explosionList);
			removeBomb = true;
			return;
		} else if (timer <= 60 && explosionHappend == false) {
			explosionHappend = true;
			explosion();
			Bomb.bombList.remove(this);
		}
		timer--;
	}

	public void render(Graphics graphics) {
		if (timer >= 60) {
			graphics.drawImage(getImg(), x, y, null);
		} else if (timer >= 0) { // expl happend
			for (Rectangle r : explosionList) {
				graphics.drawImage(getExplosion(), (int) r.getX(), (int) r.getY(), null);

			}
			graphics.drawImage(getExplosion(), x, y, null);
		}
	}

	private void explosion() {
		explosionList.add(new Rectangle(x, y, 60, 60));
		blast(Direction.NORTH);
		blast(Direction.SOUTH);
		blast(Direction.EAST);
		blast(Direction.WEST);
		Map.blastList.addAll(explosionList);
	}

	private void blast(Direction d) {
		int blastX = x;
		int blastY = y;
		for (int i = 0; i < blastRadius; i++) {
			switch (d) {
			case NORTH:
				blastY -= 60;
				break;

			case WEST:
				blastX -= 60;
				break;

			case SOUTH:
				blastY += 60;
				break;

			case EAST:
				blastX += 60;
				break;

			default:
				System.out.println("ERROR BLAST");
				return;
			}
			Rectangle blastRect = new Rectangle(blastX, blastY, 60, 60);
			
			//If the explosion hits NZGs - stop it right there
			for (Rectangle e : Map.nzgList) {
				if (e.intersects(blastRect)) {
					return;
				}
			}
			
			//If the explosion hits ZGs - remove them and stop the blast in this direction
			for (Rectangle e : Map.zgList) {
				if (e.intersects(blastRect)) {
					explosionList.add(new Rectangle(blastX, blastY, 60, 60));
					Map.zgList.remove(e);
					e = null;
					Map.koordinateRandom[(int) (blastRect.getY() / 60)][(int) (blastRect.getX() / 60)] = 0; //removes the zg from the map
					return; //stops this blast
				}

			}
			explosionList.add(new Rectangle(blastX, blastY, 60, 60));
			for (Bomb e : Bomb.bombList) {
				if (e.getRectangle().intersects(blastRect)) {
					e.trigger();
				}
			}
		}

	}

	public void trigger() {
		timer = 60;
	}

	private BufferedImage getImg() {
		switch (charNum) {
		case 1:
			return Asset.tnt_blue;
		case 2:
			return Asset.tnt_red;
		case 3:
			return Asset.tnt_green;
		case 4:
			return Asset.tnt_yellow;
		default:
			return Asset.dynamite;
		}
	}

	private BufferedImage getExplosion() {

		switch (charNum) {
		case 1:
			return Asset.explosion_blue;
		case 2:
			return Asset.explosion_red;
		case 3:
			return Asset.explosion_green;
		case 4:
			return Asset.explosion_yellow;
		default:
			return Asset.explosion;
		}
	}

	@Override
	public void update() {
		this.decreaseBombTimerX();

	}

	public boolean canRemoveBomb() {
		return removeBomb;
	}
	
	public int getBlastRadius() {
		return blastRadius;
	}


}
