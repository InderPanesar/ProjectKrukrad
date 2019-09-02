package krukrad.mainGame;

import java.awt.Color;

public class CheckBoundaries {
	
	//if the character is on a boundary it returns a Boolean value (if it is on boundary ==> True;)
	public Boolean OnBoundary (Color[][] color,Color c2, int x, int y) {
		Boolean TrueOrFalse = false;
		if (color[x][y].equals(c2)) {
			TrueOrFalse = true;
		}
		
		return TrueOrFalse;
	}
	
	
	//if character is on sand the character moves slower
	public int OnSand (Color[][] color,Color c2, int x, int y, int CharacterSpeed) {
		int speed = CharacterSpeed;
		if (color[x][y].equals(c2)) {
			speed = 3;
		}
		else {
			speed = 5;
		}
		
		return speed;
	}

}
