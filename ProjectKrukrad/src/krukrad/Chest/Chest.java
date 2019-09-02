package krukrad.Chest;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Chest {

    public int x = 0;
    public int y = 0;
    public int OriginalX = 0;
    public int OriginalY = 0;
    public int width = 0;
    public int height = 0;
    public Boolean Opened = false;

    public JLabel label = new JLabel();
    
    
    public Chest ( int x, int y, int width, int height ) {
    	this.label.setIcon(new ImageIcon("res/chest/Closed.png"));
        this.x = x;
        this.OriginalX = x;
        this.OriginalY = y;
        this.y = y;
        this.width = width;
        this.height = height;
        this.updateBounds();
    }
    

    public void setPosition( int x, int y ) {
        this.x = x;
        this.y = y;
        this.updateBounds();
    }

    public void move( int dx, int dy ) {
        this.x += dx;
        this.y += dy;
        this.updateBounds();
    }

    public void updateBounds() {
    	if(Opened) {
        	this.label.setIcon(new ImageIcon("res/chest/Opened.png"));
    	}
    	else {
        	this.label.setIcon(new ImageIcon("res/chest/Closed.png"));
    	}
    	
        this.label.setBounds( this.x, this.y, this.width, this.height );
    }
    

	public void setVisibleTrue() {
        this.label.setVisible(true);
        this.label.setEnabled(true);
    	if(Opened) {
        	this.label.setIcon(new ImageIcon("res/chest/Opened.png"));
    	}
    	else {
        	this.label.setIcon(new ImageIcon("res/chest/Closed.png"));
    	}
        this.updateBounds();
		
	}
	
	public void setVisibleFalse() {
        this.label.setVisible(false);
        this.label.setEnabled(false);
    	if(Opened) {
        	this.label.setIcon(new ImageIcon("res/chest/Opened.png"));
    	}
    	else {
        	this.label.setIcon(new ImageIcon("res/chest/Closed.png"));
    	}
        this.updateBounds();
		
	}
	
}
