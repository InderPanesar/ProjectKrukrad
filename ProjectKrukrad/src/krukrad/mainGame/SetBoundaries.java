package krukrad.mainGame;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SetBoundaries {
	/*
	 * This sets the boundaries for each arrow key. This sets the colours
	 * for each pixel. This will be stored in the main class.
	 * The variables in the main class will be stored with the same
	 * variables in the main class. 
	 * 
	 * This was used made using code from the Internet: (StackOverflow)
	 * https://stackoverflow.com/questions/7749895/java-loop-through-pixels-in-an-image
	 * Credit: Zarkonnen.
	 */
	
	/* The Explanation of what is going on here:
	 * 
	 * RGB holds the red, blue, and green values for the pixels on the image 
	 * rgb & 0x00ff0000 masks off all but the red bits. The 16 bit shift means that 
	 * the red bits  move to the lowest significant positions 
	 * before they're assigned to the red integer variable. This is the exact same thing done
	 * for green and blue which are then stored together with the red variable, to form one colour. 
	 * As every pixel is made up from 3 main colours which are RGB (Red, Green and Blue).
	 * Therefore every pixel is given a RGB Value which will be checked to later to see
	 * if it the same as another color variable in the main class.
	 */
	
	Color colorW[][];
	Color colorS[][];
	Color colorA[][];
	Color colorD[][];
		

	//Gets Color array for W (Collision Map)
	public Color[][] North() {
		BufferedImage image = null;
	    File f = new File("res/level/cMap2W.png");
		try {
			image = ImageIO.read(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int Width = image.getWidth();
		int Height = image.getHeight();
        colorW = new Color[Width][Height];
        
        for (int x = 0; x < Width; x++) {
            for (int y = 0; y < Height; y++) {
                int clr = image.getRGB(x, y);
                int red = (clr & 0x00ff0000) >> 16;
                int green = (clr & 0x0000ff00) >> 8;
                int blue = clr & 0x000000ff;
                colorW[x][y] = new Color(red,green,blue);
            }
        }
		return colorW;
	}
	
	

	//Gets Color array for S (Collision Map)
	public Color[][] South() {
		BufferedImage image = null;
	    File f = new File("res/level/cMap2S.png");
		try {
			image = ImageIO.read(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int Width = image.getWidth();
		int Height = image.getHeight();
        colorS = new Color[Width][Height];
        
        for (int x = 0; x < Width; x++) {
            for (int y = 0; y < Height; y++) {
                int clr = image.getRGB(x, y);
                int red = (clr & 0x00ff0000) >> 16;
                int green = (clr & 0x0000ff00) >> 8;
                int blue = clr & 0x000000ff;
                colorS[x][y] = new Color(red,green,blue);
            }
        }
		return colorS;
	}
	

	//Gets Color array for A (Collision Map)
	public Color[][] West() {
		BufferedImage image = null;
	    File f = new File("res/level/cMap2A.png");
		try {
			image = ImageIO.read(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int Width = image.getWidth();
		int Height = image.getHeight();
        colorW = new Color[Width][Height];
        
        for (int x = 0; x < Width; x++) {
            for (int y = 0; y < Height; y++) {
                int clr = image.getRGB(x, y);
                int red = (clr & 0x00ff0000) >> 16;
                int green = (clr & 0x0000ff00) >> 8;
                int blue = clr & 0x000000ff;
                colorW[x][y] = new Color(red,green,blue);
            }
        }
		return colorW;
	}
	
	//Gets Color array for D (Collision Map)
	public Color[][] East() {
		BufferedImage image = null;
	    File f = new File("res/level/cMap2D.png");
		try {
			image = ImageIO.read(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int Width = image.getWidth();
		int Height = image.getHeight();
        colorD = new Color[Width][Height];
        
        for (int x = 0; x < Width; x++) {
            for (int y = 0; y < Height; y++) {
                int clr = image.getRGB(x, y);
                int red = (clr & 0x00ff0000) >> 16;
                int green = (clr & 0x0000ff00) >> 8;
                int blue = clr & 0x000000ff;
                colorD[x][y] = new Color(red,green,blue);
            }
        }
		return colorD;
	}

	


}
