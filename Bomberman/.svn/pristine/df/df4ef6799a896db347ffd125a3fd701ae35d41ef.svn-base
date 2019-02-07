package bomberman.tools;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GameImage {
	
	private GameImage() {
		
	};
	
	public static BufferedImage loadImage(String imageName) {
		
		String imagePath = "/images/"+imageName;
		try {
			return ImageIO.read(GameImage.class.getResource(imagePath));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		return null;
	}

}
