package krukrad.ReviveHealth;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Heart {
	
	/* This is the object for the heart cannisters
	 * they have 5 variables, 4 which are related to the JLabel
	 * then one which is to show whether if the heart cannister has been used.
	 */

    public int x = 0;
    public int y = 0;
    public int width = 0;
    public int height = 0;
    public boolean Used = false;

    public JLabel label = new JLabel();
    
    
    public Heart( int x, int y, int width, int height, boolean Used)	{
    	this.label.setIcon(new ImageIcon("res/heartIcon/heart.png"));
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        setPosition(x,y);
    }
    
    public void setVisibleFalse() {
        this.label.setVisible(false);
        this.label.setEnabled(false);
        this.updateBounds();
    }

    public void setPosition( int x, int y )	{
        this.x = x;
        this.y = y;
        this.updateBounds();
    }


    public void updateBounds()	{
        this.label.setBounds( this.x, this.y, this.width, this.height );
    }

	public void setVisibleTrue() {
        this.label.setVisible(true);
        this.label.setEnabled(true);
    	this.label.setIcon(new ImageIcon("res/heartIcon/heart.png"));
        this.updateBounds();
		
	}
	
}
