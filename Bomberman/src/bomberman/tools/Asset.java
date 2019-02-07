package bomberman.tools;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;


import bomberman.menu.StartMenu;

public class Asset {
	public static BufferedImage character1, character2, character3, character4;
	public static BufferedImage cdeath1, cdeath2, cdeath3, cdeath4, dead_character1, dead_character2, dead_character3, dead_character4;
//	public static BufferedImage cdynamite1, cdynamite2, cdynamite3, cdynamite4;
	public static BufferedImage bomb_debug, avoid, dynamite, tnt_blue, tnt_red, tnt_green, tnt_yellow;
	public static BufferedImage explosion, explosion_blue, explosion_red, explosion_green, explosion_yellow;
	public static BufferedImage item_blastUp, item_blastDown, item_speedUp, item_speedDown, item_dynamiteUp, item_dynamiteDown;

	public static BufferedImage nzgfest;
	public static BufferedImage nzg1, nzg2, nzg3, nzg4, nzg5, nzg6, nzg7, nzg8;
	public static BufferedImage zg3, path_ground, path_ground_version2, path_ground_version3, ground_coords;
	
	//public static BufferedImage ground_debug, ground_coords, path_ground, path_ground_version3, zg_min, nzg_min, zg, zg2, zg3, explosion;

	public static BufferedImage menu_background_logo, menu_background, button_background_arrow, button_background_blank;
	public static BufferedImage instructions, blackground;
	public static Font pcsenior;
	
	private static boolean loaded = false;
		
	private Asset() {
	}
	
	public static void loadAssets() {
		if(!loaded) {
			System.out.print("Loading Assets...");
			
			//Character Related
			character1 = GameImage.loadImage("character1.png");
			character2 = GameImage.loadImage("character2.png");
			character3 = GameImage.loadImage("character3.png");
			character4 = GameImage.loadImage("character4.png");
			
			cdeath1 = GameImage.loadImage("cdeath1.png");
			cdeath2 = GameImage.loadImage("cdeath2.png");
			cdeath3 = GameImage.loadImage("cdeath3.png");
			cdeath4 = GameImage.loadImage("cdeath4.png");
			
			dead_character1 = GameImage.loadImage("dead_character1.png");
			dead_character2 = GameImage.loadImage("dead_character2.png");
			dead_character3 = GameImage.loadImage("dead_character3.png");
			dead_character4 = GameImage.loadImage("dead_character4.png");
			
			dynamite = GameImage.loadImage("dynamite.png");
//			cdynamite1 = GameImage.loadImage("cdynamite1.png");
//			cdynamite2 = GameImage.loadImage("cdynamite2.png");
//			cdynamite3 = GameImage.loadImage("cdynamite3.png");
//			cdynamite4 = GameImage.loadImage("cdynamite4.png");
			
			tnt_blue = GameImage.loadImage("tnt_blue.png");
			tnt_red = GameImage.loadImage("tnt_red.png");
			tnt_green = GameImage.loadImage("tnt_green.png");
			tnt_yellow = GameImage.loadImage("tnt_yellow.png");
			
			explosion = GameImage.loadImage("explosion.png");
			explosion_blue = GameImage.loadImage("explosion_blue.png");
			explosion_red = GameImage.loadImage("explosion_red.png");
			explosion_green = GameImage.loadImage("explosion_green.png");
			explosion_yellow = GameImage.loadImage("explosion_yellow.png");
			
			item_blastUp = GameImage.loadImage("item_blastUp.png");
			item_blastDown = GameImage.loadImage("item_blastDown.png");
			item_speedUp = GameImage.loadImage("item_speedUp.png");
			item_speedDown = GameImage.loadImage("item_speedDown.png");
			item_dynamiteUp = GameImage.loadImage("item_dynamiteUp.png");
			item_dynamiteDown = GameImage.loadImage("item_dynamiteDown.png");
			
			//Map related
			//NZG
			nzgfest = GameImage.loadImage("nzgfest.png");
			nzg1 = GameImage.loadImage("nzg1.png");
			nzg2 = GameImage.loadImage("nzg2.png");
			nzg3 = GameImage.loadImage("nzg3.png");
			nzg4 = GameImage.loadImage("nzg4.png");
			nzg5 = GameImage.loadImage("nzg5.png");
			nzg6 = GameImage.loadImage("nzg6.png");
			nzg7 = GameImage.loadImage("nzg7.png");
			nzg8 = GameImage.loadImage("nzg8.png");
			
			//ZG
			zg3 = GameImage.loadImage("zg3.png");
			//zg_min = GameImage.loadImage("zg_min.png");
			//zg = GameImage.loadImage("zg.png");
			//zg2 = GameImage.loadImage("zg2.png");
			
			
			//Path-Ground
			//ground_debug = GameImage.loadImage("path_ground.png");
			path_ground = GameImage.loadImage("path_ground.png");
			path_ground_version2 = GameImage.loadImage("path_ground_version2.png");
			path_ground_version3 = GameImage.loadImage("path_ground_version3.png");
			ground_coords = GameImage.loadImage("ground_coords.png");
			
			bomb_debug = GameImage.loadImage("bomb_debug.png");
			avoid = GameImage.loadImage("avoid.png");
			
			//MENU
			menu_background_logo = GameImage.loadImage("DynaMine_Menu_Background_Logo.png");
			menu_background = GameImage.loadImage("DynaMine_Menu_Background.png");
			button_background_arrow = GameImage.loadImage("Background_Img_Arrows.png");
			button_background_blank = GameImage.loadImage("Background_Img_black.png");
			blackground = GameImage.loadImage("Blackground.png");
			instructions = GameImage.loadImage("instructions.png");
			
			try {
				InputStream inputStream = StartMenu.class.getResourceAsStream("/fonts/pcsenior.ttf");
				pcsenior= Font.createFont(Font.TRUETYPE_FONT, inputStream);
			} catch (FontFormatException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		
			loaded = true;
			System.out.println("Assets loaded");
		}
	}

}
