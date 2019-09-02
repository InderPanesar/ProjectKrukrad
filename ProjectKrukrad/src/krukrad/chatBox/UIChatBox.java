package krukrad.chatBox;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class UIChatBox {
	
    public int x = 0;
    public int y = 0;
    public int width = 0;
    public int height = 0;

    public JLabel label = new JLabel();
    
    //This is an object for the main UI Box which contains the letters
    //This will always be the same.

    //This method gets the X, Y values as well as the Width and Height of the JLabel
    
    public UIChatBox( int x, int y, int width, int height ) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    //These two methods both sets the JLabel Visible or Invisible
    
    public void setVisibleFalse() {
        this.label.setVisible(false);
        this.label.setEnabled(false);
        this.updateBounds();
    }
    
    public void setVisibleTrue() {
        this.label.setVisible(true);
        this.label.setEnabled(true);
        this.updateBounds();
    }
    
    //This method sets the JLabel Icon Image
    
    public void UpdateImage(String Name) {
    	this.label.setIcon(new ImageIcon(Name));
        this.updateBounds();
    }
    
    //This method sets the bounds of the JLabel

    public void updateBounds() {
        this.label.setBounds( this.x, this.y, this.width, this.height );
    }
}
