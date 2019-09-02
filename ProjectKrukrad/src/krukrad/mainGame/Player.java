package krukrad.mainGame;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

//This class is the object used to handle the player. This is one example of OOP (Object-Orientated Programming).

public class Player {
	// These are the variables that are assigned for each of the players
	// X-Coordinate and Y-Coordinate that can so that the move in the appropriate directions. 
	// As well as the height and width of the Object. 
	// Health of the object is also initialised. 
	// Label draws a new JLabel. 
	
    public int x = 0;
    public int y = 0;
    public int width = 0;
    public int height = 0;
    public int Health = 0;
    public String PlayerClass = null;
    public int AttackD1 = 0;
    public int AttackD2 = 0;
    public int HealD3 = 0;
    public String Attack1Name = null;
    public String Attack2Name = null;
    public String Heal1Name = null;
    public int Shield = 0;
    public int Multiplier = 1;
    public Boolean gotShield = false;
    public Boolean gotWeapon = false;
    public int CharacterVersion = 0;
    
    
    public JLabel label = new JLabel();
    
    //This is where the player object is called by the main class to place a character there. 
    
    public Player( int x, int y, int width, int height, int Health, String PlayerClass, int Attack1, int Attack2, int Heal3, String AttackName, String AttackName2, String HealName, int CharacterVersion) {

    	if (CharacterVersion == 1) {
        	this.label.setIcon(new ImageIcon("res/character/1/CharacterS.png"));
    	}
    	if (CharacterVersion == 2) {
        	this.label.setIcon(new ImageIcon("res/character/2/CharacterS.png"));
    	}
    	if (CharacterVersion == 3) {
        	this.label.setIcon(new ImageIcon("res/character/3/CharacterS.png"));
    	}
    	if (CharacterVersion == 4) {
        	this.label.setIcon(new ImageIcon("res/character/4/CharacterS.png"));
    	}
    	if (CharacterVersion == 5) {
        	this.label.setIcon(new ImageIcon("res/character/5/CharacterS.png"));
    	}
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.Health = Health;
        this.PlayerClass = PlayerClass;
        this.AttackD1 = Attack1;
        this.AttackD2 = Attack2;
        this.HealD3 = Heal3;
        this.Attack1Name = AttackName;
        this.Attack2Name = AttackName2;
        this.Heal1Name = HealName;
        this.CharacterVersion = CharacterVersion;
    }
    
    //This is called when you need to update the position of the object.

    public void setPosition( int x, int y ) {
        this.x = x;
        this.y = y;
        this.updateBounds();
    }
    
    // This will set the Character visible after the battle has taken place. 
    
    public void setVisibleFalse() {
        this.label.setVisible(false);
        this.label.setEnabled(false);
        this.updateBounds();
    }
    
    // This will set the Character invisible after the battle has been initialised. 
    
    public void setVisibleTrue() {
        this.label.setVisible(true);
        this.label.setEnabled(true);
        this.updateBounds();
    }
    
    // Updates the image of the character
   
    public void UpdateImage(String Name) {
    	this.label.setIcon(new ImageIcon(Name));
        this.updateBounds();
    }
    
    // Updates the bounds of the character, so if you need to change the characters height not
    // just it's width and height.

    public void updateBounds() {
        this.label.setBounds( this.x, this.y, this.width, this.height );
    }

    // Update Image of it moving upwards. (WO and W - To give the illusion of it walking).
   
	public void UpdateImageMovementW(Boolean w) {
		if (w) {
			
			if (this.CharacterVersion == 1) {
		    	this.label.setIcon(new ImageIcon("res/character/1/CharacterWO.png"));
			}
			if (this.CharacterVersion == 2) {
		    	this.label.setIcon(new ImageIcon("res/character/2/CharacterWO.png"));
			}	    	
			if (this.CharacterVersion == 3) {
		    	this.label.setIcon(new ImageIcon("res/character/3/CharacterWO.png"));
			}
			if (this.CharacterVersion == 4) {
				this.label.setIcon(new ImageIcon("res/character/4/CharacterWO.png"));
			}
			if (this.CharacterVersion == 5) {
				this.label.setIcon(new ImageIcon("res/character/5/CharacterWO.png"));
			}
		}
		else {
			if (this.CharacterVersion == 1) {
		    	this.label.setIcon(new ImageIcon("res/character/1/CharacterW.png"));
			}
			if (this.CharacterVersion == 2) {
		    	this.label.setIcon(new ImageIcon("res/character/2/CharacterW.png"));
			}	    	
			if (this.CharacterVersion == 3) {
		    	this.label.setIcon(new ImageIcon("res/character/3/CharacterW.png"));
			}
			if (this.CharacterVersion == 4) {
				this.label.setIcon(new ImageIcon("res/character/4/CharacterW.png"));
			}
			if (this.CharacterVersion == 5) {
				this.label.setIcon(new ImageIcon("res/character/5/CharacterW.png"));
			}
		}
	}
	
    // Update Image of it moving downwards. (SO and S - To give the illusion of it walking).
	
	public void UpdateImageMovementS(Boolean s) {
		if (s) {
			if (this.CharacterVersion == 1) {
		    	this.label.setIcon(new ImageIcon("res/character/1/CharacterSO.png"));
			}
			if (this.CharacterVersion == 2) {
		    	this.label.setIcon(new ImageIcon("res/character/2/CharacterSO.png"));
			}	    	
			if (this.CharacterVersion == 3) {
		    	this.label.setIcon(new ImageIcon("res/character/3/CharacterSO.png"));
			}
			if (this.CharacterVersion == 4) {
				this.label.setIcon(new ImageIcon("res/character/4/CharacterSO.png"));
			}
			if (this.CharacterVersion == 5) {
				this.label.setIcon(new ImageIcon("res/character/5/CharacterSO.png"));
			}
		}
		else {
			if (this.CharacterVersion == 1) {
		    	this.label.setIcon(new ImageIcon("res/character/1/CharacterS.png"));
			}
			if (this.CharacterVersion == 2) {
		    	this.label.setIcon(new ImageIcon("res/character/2/CharacterS.png"));
			}	    	
			if (this.CharacterVersion == 3) {
		    	this.label.setIcon(new ImageIcon("res/character/3/CharacterS.png"));
			}
			if (this.CharacterVersion == 4) {
				this.label.setIcon(new ImageIcon("res/character/4/CharacterS.png"));
			}
			if (this.CharacterVersion == 5) {
				this.label.setIcon(new ImageIcon("res/character/5/CharacterS.png"));
			}
		}
	}
	

    // Update Image of it moving upwards. (A(still) and A(walking) - To give the illusion of it walking).
	
	public void UpdateImageMovementA(Boolean a) {
		if (a) {
			if (this.CharacterVersion == 1) {
		    	this.label.setIcon(new ImageIcon("res/character/1/CharacterAStill.png"));
			}
			if (this.CharacterVersion == 2) {
		    	this.label.setIcon(new ImageIcon("res/character/2/CharacterAStill.png"));
			}	    	
			if (this.CharacterVersion == 3) {
		    	this.label.setIcon(new ImageIcon("res/character/3/CharacterAStill.png"));
			}
			if (this.CharacterVersion == 4) {
				this.label.setIcon(new ImageIcon("res/character/4/CharacterAStill.png"));
			}
			if (this.CharacterVersion == 5) {
				this.label.setIcon(new ImageIcon("res/character/5/CharacterAStill.png"));
			}
		}
		else {
			if (this.CharacterVersion == 1) {
		    	this.label.setIcon(new ImageIcon("res/character/1/CharacterAWalking.png"));
			}
			if (this.CharacterVersion == 2) {
		    	this.label.setIcon(new ImageIcon("res/character/2/CharacterAWalking.png"));
			}	    	
			if (this.CharacterVersion == 3) {
		    	this.label.setIcon(new ImageIcon("res/character/3/CharacterAWalking.png"));
			}
			if (this.CharacterVersion == 4) {
				this.label.setIcon(new ImageIcon("res/character/4/CharacterAWalking.png"));
			}
			if (this.CharacterVersion == 5) {
				this.label.setIcon(new ImageIcon("res/character/5/CharacterAWalking.png"));
			}
		}
	}
	
    // Update Image of it moving right. (D(still) and D(walking) - To give the illusion of it walking).
	
	public void UpdateImageMovementD(Boolean d) {
		if (d) {
			if (this.CharacterVersion == 1) {
		    	this.label.setIcon(new ImageIcon("res/character/1/CharacterDStill.png"));
			}
			if (this.CharacterVersion == 2) {
		    	this.label.setIcon(new ImageIcon("res/character/2/CharacterDStill.png"));
			}	    	
			if (this.CharacterVersion == 3) {
		    	this.label.setIcon(new ImageIcon("res/character/3/CharacterDStill.png"));
			}
			if (this.CharacterVersion == 4) {
				this.label.setIcon(new ImageIcon("res/character/4/CharacterDStill.png"));
			}
			if (this.CharacterVersion == 5) {
				this.label.setIcon(new ImageIcon("res/character/5/CharacterDStill.png"));
			}
		}
		else {
			if (this.CharacterVersion == 1) {
		    	this.label.setIcon(new ImageIcon("res/character/1/CharacterDWalking.png"));
			}
			if (this.CharacterVersion == 2) {
		    	this.label.setIcon(new ImageIcon("res/character/2/CharacterDWalking.png"));
			}	    	
			if (this.CharacterVersion == 3) {
		    	this.label.setIcon(new ImageIcon("res/character/3/CharacterDWalking.png"));
			}
			if (this.CharacterVersion == 4) {
				this.label.setIcon(new ImageIcon("res/character/4/CharacterDWalking.png"));
			}
			if (this.CharacterVersion == 5) {
				this.label.setIcon(new ImageIcon("res/character/5/CharacterDWalking.png"));
			}
		}
	}
	
    // Update the health of the character after a battle.
	
	public void Update(int Health) {
		this.Health = Health;
	}
}
