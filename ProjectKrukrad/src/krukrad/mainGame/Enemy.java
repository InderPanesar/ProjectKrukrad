package krukrad.mainGame;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Enemy {
	
    public int x = 0;
    public int y = 0;
    public int width = 0;
    public int height = 0;
    public String EnemyClass = "";
    public int Health = 0;
    public int AttackOneDamage = 0;
    public int AttackTwoDamage = 0;
	public int AttackThreeDamage;
    public int HealAbility = 0;
    public Boolean Dead = false;
    public Boolean NotBossEnemy = true;
    public Boolean EnabledEnemy = true;
    

    public JLabel label = new JLabel();
    
    
    public Enemy( int x, int y, int width, int height, String EnemyClass, int Health, int AttackOneDamage, int AttackTwoDamage, int AttackThreeDamage, int HealAbility)
    {
    	this.label.setIcon(new ImageIcon("res/enemy/leftstationary.png"));
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.EnemyClass = EnemyClass;
        this.Health = Health;
        this.AttackOneDamage = AttackOneDamage;
        this.AttackTwoDamage = AttackTwoDamage;
        this.AttackThreeDamage = AttackThreeDamage;
        this.HealAbility = HealAbility;
        setPosition(x, y);
    }

    public void setPosition( int x, int y )
    {
        this.x = x;
        this.y = y;
        this.updateBounds();
    }
    
    public void UpdateImage(String Name) {
    	this.label.setIcon(new ImageIcon(Name));
        this.updateBounds();
        System.out.println(Name);
    }

    public void move( int dx, int dy )
    {
        this.x += dx;
        this.y += dy;
        this.updateBounds();
    }
    
    public void YChangeMove( int Z, int V )
    {
        this.width = Z;
        this.y = V;
        this.updateBounds();
    }
    
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

    public void updateBounds()
    {
        this.label.setBounds( this.x, this.y, this.width, this.height );
    }
    
}
