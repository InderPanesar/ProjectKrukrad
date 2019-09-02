package krukrad.mainGame;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Background {

    public int x = 0;
    public int y = 0;
    public int width = 0;
    public int height = 0;

    public JLabel label = new JLabel();
    
	/* This is the object for the map
	 * they have 4 variables, all of which are related to the JLabel
	 */
    
    public Background( int x, int y, int width, int height ) {
    	this.label.setIcon(new ImageIcon("res/level/map2.png"));
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public void setVisibleFalse() {
        this.label.setVisible(false);
        this.label.setEnabled(false);
        this.updateBounds();
    }
    
    //set the position of the Jlabel

    public void setPosition( int x, int y ) {
        this.x = x;
        this.y = y;
        this.updateBounds();
    }

    public void updateBounds() {
        this.label.setBounds( this.x, this.y, this.width, this.height );
    }

	public void setVisibleTrue() {
        this.label.setVisible(true);
        this.label.setEnabled(true);
    	this.label.setIcon(new ImageIcon("res/level/map2.png"));
        this.updateBounds();
	}
    
}
