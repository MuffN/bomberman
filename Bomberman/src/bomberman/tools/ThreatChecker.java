package bomberman.tools;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import bomberman.entities.Bomb;
import bomberman.entities.Character;
import bomberman.maingame.Map;

//handles all threats due to incomming blasts for all bots
public class ThreatChecker {
	
	private enum bombDirection {
		NORTH, EAST, SOUTH, WEST
	}
	
	//List with all dangerous tiles
	private  List<Rectangle> threatList = new ArrayList<Rectangle>();


	//List with all bombs
	private List<Bomb> lastBombList = new ArrayList<Bomb>();
	
	public ThreatChecker() {
		init();
	}
	
	private void init() {
		calculateThreatList();
	}
	
	public void update() {
		List<Bomb> currentBombList = new ArrayList<Bomb>();
		for(Character c : Character.characterList) {
			currentBombList.addAll(c.getCharacterBombList());
		}
		
		if(!(lastBombList.containsAll(currentBombList) && currentBombList.containsAll(lastBombList))) {
			lastBombList = currentBombList;
			calculateThreatList();
		}
	}
	
	private void calculateThreatList() {
		threatList.clear();
		for(Bomb b : lastBombList) {
			int bombX = (int)b.getRectangle().getX();
			int bombY = (int)b.getRectangle().getY();
			threatList.add(new Rectangle(bombX, bombY, 60, 60));
			calculateBlastDirection(bombDirection.NORTH, b);
			calculateBlastDirection(bombDirection.EAST, b);
			calculateBlastDirection(bombDirection.SOUTH, b);
			calculateBlastDirection(bombDirection.WEST, b);
		}
	}
	
	private void calculateBlastDirection(bombDirection d, Bomb b) {
		int blastX = (int)b.getRectangle().getX();
		int blastY = (int)b.getRectangle().getY();
		for (int i = 0; i < b.getBlastRadius(); i++) {
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

			// If the explosion hits NZGs - stop it right there
			for (Rectangle e : Map.nzgList) {
				if (e.intersects(blastRect)) {
					return;
				}
			}

			// If the explosion hits ZGs - remove them and stop the blast in this direction
			for (Rectangle e : Map.zgList) {
				if (e.intersects(blastRect)) {
					threatList.add(new Rectangle(blastX, blastY, 60, 60));
					return; // stops this blast
				}

			}
			threatList.add(blastRect);
		}
	}
	
	public void render(Graphics graphics) {
		for(Rectangle r : this.threatList) {
			graphics.drawImage(Asset.avoid, (int)r.getX(), (int) r.getY(),null);
			//graphics.drawRect((int) r.getX(), (int) r.getY(), (int) r.getWidth(), (int) r.getHeight());
		}
	}
	
	public List<Rectangle> getThreatList() {
		return threatList;
	}

}
