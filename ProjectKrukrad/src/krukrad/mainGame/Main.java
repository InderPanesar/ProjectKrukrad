package krukrad.mainGame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import krukrad.Attacks.AttackHandler;
import krukrad.Chest.Chest;
import krukrad.EnemyAI.DecisionMaking;
import krukrad.LeaderboardUpdate.UpdateTime;
import krukrad.ReviveHealth.Heart;
import krukrad.WeaponNames.NameWeapon;
import krukrad.chatBox.CheckForCharacters;
import krukrad.chatBox.TextBox;
import krukrad.chatBox.UIChatBox;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;

public class Main extends JFrame  {

	private static final long serialVersionUID = 1613286429802005520L;
	
	JPanel contentPane;
	String playerAttack = "";
	String enemyAttack = "";
	
	Boolean PauseMenuActive = false;
	
	
	Color color;
	Color c2 = new Color(0,0,0);
	
	
    char c =  'x';
    int KeyInput; 
    
	int x = -760 + 200;
	int y = -815 + 200;
	
	int met = 0;

	
    Color[][] colorW;
    Color[][] colorA;
    Color[][] colorS;
    Color[][] colorD;
    
	long startTime;
	long endTime;
    
	
    // Initialises Boolean for each Key - WASD
	Boolean W = true;
	Boolean S = true;
	Boolean D = true;
	Boolean A = true;
	
	Boolean Paused = false;
	Boolean TextBoxActive = false;
	
	int TempHealth = 0;
	
	
	int w = 2;
	int s = 2;
	int a = 2;
	int d = 2;
	
	int wPressed = 0;
	int sPressed = 0;
	int aPressed = 0;
	int dPressed = 0;
	
	public static int difficulty = 0;
	public int Skin = 0;
	
	int speed = 10;
	
	int Enemy1NewY = 100;
	int Enemy1NewX = 100;

	//Initialises JLabels shown here.
	
	private final JLabel PauseButton = new JLabel("");
	protected final JLabel Animation = new JLabel("");

	JLabel ExitButton = new JLabel();
	JLabel lblNewLabel = new JLabel("");
	JLabel lblNewLabel_2 = new JLabel();
	
    JButton ResumeButton = new JButton("RESUME");
    JButton btnExitGame = new JButton("EXIT GAME");
    
	int Xdifference;
	int Ydifference;
	
	int FinalX = 300;
	int FinalY = 300;
	
	int X2;
	int Y2;
	int intialise = 0;
	int z = 0;
	
	Boolean On;
	Boolean Done = false;
	
	Player player;
	Background map;

	Boolean movement = false;
	Boolean BoundarySet = false;
	
	String UP = "res/character/CharacterS.png";
	String DOWN = "res/character/CharacterSO.png";
	String STATIONARY = "res/character/CharacterSO.png";
	
	int ix = 0;
	int iy = 0;
	public int XCoordinate = 0;
	public int YCoordinate = 0;
	int DifferenceXA = 0;
	int DifferenceXD = 0;
	int DifferenceYW = 0;
	int DifferenceYS = 0;
	int DeltaX = 0;
	int DeltaY = 0;

	Boolean Stopped = false;
	Boolean YMovement = false;
	Boolean[] Direction = {false,false,false,false};
	
	int DONE = 0;
	int TempStorage = 0;
	
	Boolean Reverse = false;
	
	ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	ArrayList<Boolean> Interacted = new ArrayList<Boolean>();
	ArrayList<Heart> canisters = new ArrayList<Heart>();
	ArrayList<Chest> Chests = new ArrayList<Chest>();
	ArrayList<TextBox> LetterBox = new ArrayList<TextBox>();
	List<String> Class = new ArrayList<String>();
	List<Integer> X = new ArrayList<Integer>();
	List<Integer> Y = new ArrayList<Integer>();
	List<Integer> Health = new ArrayList<Integer>();
	List<Boolean> EnemyInteracted = new ArrayList<Boolean>();
	List<Integer> OriginalX = new ArrayList<Integer>();	List<Integer> OriginalY = new ArrayList<Integer>();
	Queue<Character> queueA = new LinkedList<Character>();
	
	int Enemy = 0;
    int turn = 0; 
    int movementChanges = 0;
	int SequenceTextBox = 0;
	int I = 0;
	int whileInterval = 0;
    
    Thread thread2;
	UIChatBox Box;
	TextBox Five;
	Boolean InteractedWithCharacter = false;
	Boolean done = false;
	Boolean NearEnemyTextBox = false;
	
	JLabel PlayerHealthJL = new JLabel("100");
	JLabel EnemyImage = new JLabel("PictureMiddle");
	JLabel Player = new JLabel("PictureMiddle");
	JButton AttackOneButton = new JButton("ATTACK 1");
	JButton AttackTwoButton = new JButton("ATTACK 2");
	JButton AttackThreeButton = new JButton("ATTACK 3");
	JLabel PlayerClass = new JLabel("CLASS: ");
	JLabel lblClass = new JLabel(": CLASS");
	JButton btnSkipTurn = new JButton("SKIP TURN");
	JButton btnRunAway = new JButton("RUN AWAY");
	JLabel lblTurn = new JLabel("TURN : " + turn);
	JLabel MainEnemy = new JLabel("150");
	private JTextField txtHealth;
	private JTextField HealthBarBackground;
	private final JTextField HealthBar = new JTextField();
	private JTextField EnemyBattleHealth;
	private JTextField textField_2;
	private JTextField EnemyAttacked;
	private final JTextField PlayerAttacked = new JTextField();
	private final JTextField EnemyDamage = new JTextField();
	private final JTextField PlayerDamage = new JTextField();
	private final JTextField txtLastTurn = new JTextField();
	JLabel YouHaveDied = new JLabel("YOU HAVE DIED");
	JButton LeaveGame = new JButton("LEAVE GAME");
	
	static Main frame = new Main();
	
	public int HealthRestoredButtonPressed = 0;
	public int HealPressed = 0;
	public Boolean InBattle = false;
	private JTextField txtArmour;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField txtPlayerShield;
	private final JTextField Armour = new JTextField();
	private JTextField txtWeaponName;
	private JTextField textField_4;
	private JTextField txtWeaponMultipler;
	private final JTextField txtXTimes = new JTextField();
	
	
	/*
	 * This entire class is to do with the InputHandling, CanvasDrawing.
	 */
    
	/*
	 * This method below runs the JFrame and sets the title
	 * for the JFrame as well as not letting the JFrame to be
	 * resized, sets the Icon For the JFrame as well.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
					//Sets the JFrame to the middle of the screen
					ImageIcon img = new ImageIcon("res/JFrameLogo/dungeon.png");
					frame.setIconImage(img.getImage());
					frame.setTitle("Project Krukrad");
					//Initialises J-Frame.

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//Gets the character value of the keyboard
	public void GetChar(char Input) {
		c = Input;
	}
	
	//Gets the WeaponName for a specific level.
	public String[] WeaponName(int Level) {
		String[] Levels = new String[10];
		if (Level > 0 && Level < 4) {
			NameWeapon nc = new NameWeapon();
			//Creates a new version of the class NameWeapon(); in package WeaponNames
			Levels= nc.getName(3);
		}
		return Levels;
		//Returns the levels to the game.
	}
	
	
	public void UpdateTextBox (String Input) {
		//Calls the SplitCharacter Method which splits the characters
		//and stores them into the Letters array.
		char[] Letters = SplitCharacters(Input);
		
		//gets all the characters and places them all in a
		//queue where they will be used later to place in the TextBox
		for(int i=0;i<Letters.length;i++) {
			char C = Letters[i];
			C = Character.toLowerCase(C);
			queueA.add(C);
		}
		
		int Jlabel = 0;
		
		//Makes a queue iterator.
		java.util.Iterator<Character> iterator = queueA.iterator();
		
		//While the queue has next and JLabel is less than 24
		//24 is the maximum letters in a TextBox
		while(iterator.hasNext() && Jlabel < 24) {
			Character element = (Character) iterator.next();
		  	CheckForCharacters nc = new CheckForCharacters ();
		  	String Filename = nc.CheckCharacters(element);
			TextBox Five = LetterBox.get(Jlabel);
			Five.UpdateImage(Filename);
		  	Jlabel++;
		  	I++;
		}
		
	}
	
	//Called when first initalising the TextBox (so when the first textBox is need)
	//The first textbox is used in state 1.
	public void TextBox(String Input) {
		
		// This sets the first row of Letterbox.
		int x = 50; 
		int y = 330;
		
		while (x <= 380) {
			LetterBox.add(new TextBox(x, y, 50, 70));
			x = x + 30;
		}
		
		// This sets the second row of Letterbox. 
		
		x = 50;
		y = 370;
		
		while (x <= 380) {
			LetterBox.add(new TextBox(x, y, 50, 70));
			x = x + 30;
		}
		
		//This adds each of the LetterBox labels on the contentPane
		
		for (int i = 0; i < LetterBox.size(); i++) {
			Five = LetterBox.get(i);
			contentPane.add( Five.label );
		}
		
		//Splits the string into seperate characters
		
		char[] Letters = SplitCharacters(Input);
	
		//This then adds each of the letters to the queue.
		for(int i=0;i<Letters.length;i++) {
			char C = Letters[i];
			C = Character.toLowerCase(C);
			queueA.add(C);
		}
		
		//Gets the icon for each character and 
		//sets the corrosponding JLabel with that Letter.
		int Jlabel = 0;
		java.util.Iterator<Character> iterator = queueA.iterator();
		while(iterator.hasNext() && Jlabel < 24) {
			Character element = (Character) iterator.next();
		  	CheckForCharacters nc = new CheckForCharacters ();
		  	String Filename = nc.CheckCharacters(element);
			TextBox Five = LetterBox.get(Jlabel);
			Five.UpdateImage(Filename);
			System.out.println(Filename);
		  	Jlabel++;
		  	I++;
		}
		
		Box = new UIChatBox (44, 331, 400, 119);
		Box.UpdateImage("res/Letters/UIChat.png");
		contentPane.add(Box.label);
			
	}
	
	//Splits a String into multiple characters.
	public char[] SplitCharacters (String Name) {
		char[] Letters = Name.toCharArray();
		return Letters;
	}

	

	//This contains all of the JComponenets to do with the Pause Menu
	public void PauseMenuComponents() {
		
	    ResumeButton.setForeground(Color.WHITE);
	    ResumeButton.setBackground(Color.BLACK);
	    ResumeButton.setBounds(139, 300, 200, 23);
	    ResumeButton.setVisible(false);
	    ResumeButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		PAUSE();
	    		//When the button is pressed it calls the method above.
	    		//The method is PAUSE(); which unpauses the game
	    	}
	    });
	    contentPane.add(ResumeButton);

	    
		PauseButton.setBounds(139, 46, 200, 200);
		PauseButton.setVisible(false);
		PauseButton.setIcon(new ImageIcon("res/pause/pausebutton.png"));
		//sets the pausebutton.png for the Icon of the JLabel PauseButton
		contentPane.add(PauseButton);
	    
	    btnExitGame.setBackground(Color.BLACK);
	    btnExitGame.setForeground(Color.WHITE);
	    btnExitGame.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		System.exit(0);
	    		//This would exit the game and program safely.
	    	}
	    });
	    btnExitGame.setBounds(139, 378, 200, 23);
	    btnExitGame.setVisible(false);
	    contentPane.add(btnExitGame);
	    
		ExitButton.setBackground(Color.LIGHT_GRAY);
		ExitButton.setBounds(-34, -79, 722, 637);
		contentPane.add(ExitButton);
	    //adds the JButton to the contentPane, so it can be viewed on the
	    //the JPanel
	}
	

	/*
	 * Called when the enemy has stopped and if it has it will
	 * make the animation stationary. Called from the XMovement Method and YMovement Method.
	 */
	public void Stop() {
		if (Stopped) {
			if(Direction[1]) {
				UP = "res/enemy/leftstationary.png";
				STATIONARY = "res/enemy/leftstationary.png";
				DOWN = "res/enemy/leftstationary.png";
				Update();
			}
			if(Direction[3]) {
				UP = "res/enemy/rightstationary.png";
				STATIONARY = "res/enemy/rightstationary.png";
				DOWN = "res/enemy/rightstationary.png";
				Update();
			}
		}
	}
	
	/*
	 * This method works out the Y Movement for the enemy movement
	 * this happens during the transition when you come in contact with 
	 * an enemy.
	 */
	public void YMovement() {
		//If the DifferenceYW > 5 it then moves Downwards.
		if (DifferenceYW > 5) {
			int enemyY = Y.get(Enemy);
			//gets the Y Value of the Enemy
			enemyY = enemyY + 5;
			//Adds 5 to it.
			Y.set(Enemy,enemyY);  
			//Sets that as the new Enemy Position of the JLabel
			
			UP = "res/enemy/down1.png";
			DOWN = "res/enemy/down2.png";
			STATIONARY = "res/enemy/stationary.png";
			
			//Sets the variables of the movement of each state correctly 
			//so it looks like it is moving down.
			
			krukrad.mainGame.Enemy Five = enemies.get(Enemy);
			Five.YChangeMove(75, 150);
			//Gets the Enemy and calls YChangeMove.
			
			DifferenceYW = DifferenceYW - 5;
			//It then takes 5 away from the difference.
			Direction[0] = true;
			if (DifferenceYW == 5) {
				YMovement = true;
				//Then the YMovement is set as True if the DifferenceYW is equal to 5
			}

		}
		
		//If the DifferenceYS > 5 it then moves Upwards.
		else if (DifferenceYS < -5) {
			int enemyY = Y.get(Enemy);
			enemyY = enemyY - 5;
			//takes away 5 away from the enemyY value
			Y.set(Enemy,enemyY);  
			//sets the Y value of that Enemy
			
			krukrad.mainGame.Enemy Five = enemies.get(Enemy);
			Five.YChangeMove(75, 150);
			//YMoves the enemy, JLabel.
			
			UP = "res/enemy/up1.png";
			DOWN = "res/enemy/up2.png";
			STATIONARY = "res/enemy/stationaryup.png";
			
			//Sets the variables of the movement of each state correctly 
			//so it looks like it is moving up.
			
			DifferenceYS = DifferenceYS + 5;
			//It then adds 5 away from the difference.
			Direction[2] = true;
			if (DifferenceYS == -5) {
				YMovement = true;
				//Then the YMovement is set as True is DifferenceYS is equal to -5
			}
		}
		
		else {
			YMovement = true;
			//Otherwise it just equals true.
		}
		
		if(Reverse && Stopped) {
			Stop();
			//If stopped and reversed is true then call the stop method.
		}
	}
	
	/*
	 * This method works out the X Movement for the enemy movement
	 * this happens during the transition when you come in contact with 
	 * an enemy.
	 */
	
	public void XMovement() {
		//If XD is bigger than 5 it then moves to right
		if (DifferenceXD > 5 && !Stopped) {
			int enemyX = X.get(Enemy);
			//gets the X Value for the Enemy
			enemyX = enemyX + 5;
			//adds 5 to the X Value of EnemyX
			X.set(Enemy,enemyX);  		
			//Sets the new X Value in the X List for the specific enemy
			
			UP = "res/enemy/right1.png";
			STATIONARY = "res/enemy/rightstationary.png";
			DOWN = "res/enemy/right2.png";
			
			//Sets the variables of the movement of each state correctly 
			//so it looks like it is moving right.
			
			DifferenceXD = DifferenceXD - 5;
			//Takes away 5 from the DifferenceXD
			Direction[3] = true;
			if (DifferenceXD < 5) {
				DifferenceXD = 5;
				//If DifferenceXD < 5 then set it as 5 to avoid conflict with
				//the check others Method.
			}
			if (DifferenceXD == 5) {
				Stopped = true;
				//if XD is equal to 5 set stopped to true.
			}
		}
		
		//If XA is smaller than -5 then it moves to the left
		else if (DifferenceXA < -5 && !Stopped) {
			
			int enemyX = X.get(Enemy);
			//gets the X Value for the Enemy
			enemyX = enemyX - 5;
			//subtracts 5 to the X Value of EnemyX
			X.set(Enemy,enemyX); 
			//Sets the new X Value in the X List for the specific enemy
			
			UP = "res/enemy/left1.png";
			STATIONARY = "res/enemy/leftstationary.png";
			DOWN = "res/enemy/left2.png";
			
			//Sets the variables of the movement of each state correctly 
			//so it looks like it is moving left.
			
			DifferenceXA = DifferenceXA + 5;
			//adds 5 from the DifferenceXA
			Direction[1] = true;
			
			if (DifferenceXA > -5) {
				DifferenceXA = -5;
				//If DifferenceXD > -5 then set it as -5 to avoid conflict with
				//the check others Method.
			}
			if (DifferenceXA == -5) {
				Stopped = true;
				//if XA is equal to -5 set stopped to true.
			}
		}
		else {
			checkOthers();
			//Calls CheckOthers method, if XA > -5 and XD < 5
		}

		if(!Reverse && Stopped) {
			Stop();
			//Call stopped if stopped.
		}

	}
	
	/*
	 * This method works out the X Movement for the enemy movement
	 * this happens during the transition when you come in contact with 
	 * an enemy. This is only called if XA > -5 and XD < 5
	 */
	
	private void checkOthers() {
		
		//If XD is less than 5 it then moves to left
		if (DifferenceXD <= 5 && !Stopped) {
			
			int enemyX = X.get(Enemy);
			//gets the X Value for the Enemy
			enemyX = enemyX - 5;
			//subtracts 5 to the X Value of EnemyX
			X.set(Enemy,enemyX); 
			//Sets the new X Value in the X List for the specific enemy
						
			DifferenceXD = DifferenceXD + 5;
			//Adds 5 to the DifferenceXD.
			
			UP = "res/enemy/left1.png";
			STATIONARY = "res/enemy/leftstationary.png";
			DOWN = "res/enemy/left2.png";
			
			//Sets the variables of the movement of each state correctly 
			//so it looks like it is moving left.
			
			if (DifferenceXD == 5) {
				Stopped = true;
				//sets Stopped as true
				enemyX = enemyX - 5;
				//takes 5 away from enemyX
				X.set(Enemy,enemyX); 
				//sets the X Value for the enemy,
				Direction[3] = true;
			}
			Stop();
			//Calls the Stop Method
		}
		
		//If XA is bigger than 5 it then moves to right
		else if (DifferenceXA >= -5 && !Stopped) {
			
			int enemyX = X.get(Enemy);
			//gets the X Value for the Enemy
			enemyX = enemyX + 5;
			//subtracts 5 to the X Value of EnemyX
			X.set(Enemy,enemyX);  
			//Sets the new X Value in the X List for the specific enemy
			
			DifferenceXA = DifferenceXA - 5;
			//Takes 5 away from DifferenceXA
			
			UP = "res/enemy/right1.png";
			STATIONARY = "res/enemy/rightstationary.png";
			DOWN = "res/enemy/right2.png";
			
			//Sets the variables of the movement of each state correctly 
			//so it looks like it is moving right.
			
			if (DifferenceXA == -5) {
				Stopped = true;
				enemyX = enemyX + 5;
				X.set(Enemy,enemyX); 
				Direction[1] = true;
			}
			Stop();
			//Calls the Stop Method
		}
		
	}
	
	//This is the method called in the thread in the Main() method.

	public void Thread2EnemyBob() {
		//if YMovment is true
		//it calls XMovement
		if (YMovement) {
			XMovement();
		}
		else {
			YMovement();
		}		
		
		krukrad.mainGame.Enemy Five = enemies.get(Enemy);
		Five.setPosition(X.get(Enemy), Y.get(Enemy));	
		//Sets the position of the JLabel enemy which it has interacted with.
		
		//Changes between these three states of the enemy.
		//This is what makes it look like it's moving.
		if(movementChanges == 0) {
			Five.UpdateImage(UP);
		}
		else if (movementChanges == 1) {
			Five.UpdateImage(STATIONARY);
		}
		else if (movementChanges == 2) {
			Five.UpdateImage(DOWN);
		}
		
		movementChanges++;
		
		if (movementChanges > 2) {
			movementChanges = 0;
		}
		//When state change is equal to 2 it resets so it restarts the entire cycle of the
		//animation of the movement of the enemy.
		
		repaint();
		revalidate(); 
		
		//repaints and revalidates the canvas/
	}
	
	/*
	 * This gets the difficulty of the game,
	 * and then stores it within a global variable called
	 * difficulty which is a integer,
	 * this is read through a textFile using
	 * FileReader.
	 */
	public static void DifficultySet() {
	    String line;
	    try {
		    FileReader in = new FileReader("res/otherFiles/Difficulty.txt");
		    BufferedReader br = new BufferedReader(in);
			while ((line = br.readLine()) != null) {
			    System.out.println(line);		    
			    difficulty = Integer.parseInt(line);
			}
		    in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * This gets the character model chosen,
	 * and then stores it within a global variable called
	 * skin which is a integer,
	 * this is read through a textFile using
	 * FileReader.
	 * This is similar to DifficultySet Method above.
	 */
	public void CharacterSet() {
	    String line;
	    try {
		    FileReader in = new FileReader("res/otherFiles/CharacterModel.txt");
		    BufferedReader br = new BufferedReader(in);
			while ((line = br.readLine()) != null) {
			    System.out.println(line);		    
			    Skin = Integer.parseInt(line);
			}
		    in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/*
	 * The Main method of the game
	 */

	public Main() {
		startTime = System.nanoTime();
		//Gets the NanoTime for the LeaderBoard.
		System.out.println(startTime + "STARTING TIME");
		DifficultySet();
		//Gets the difficulty set
		CharacterSet();
		//Gets the Character Skin Chosen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.BLACK);
		//Sets the Background to black
		
		SetEnemyPositions();
		//Gets the EnemyPositions
	    PauseMenuComponents();
	    //Draws the PauseMenu Components
	    BattleComponents();
	    //Draws the BattleComponents 
	    SetEnabled(false);
	    SetVisible(false);
	    PlayerDeadVisible(false);
	    PlayerDeadEnabled(false);
	    //set them all set to not Enable and set not to Visible
		//Draws an exit button.
		TextBox("Press K To  Move On Or..");
		TextBoxActive = true;
		//Makes a textBox and states its Active.
		
		//Calls all of the other components required for the game.
		heartCanisters();		
		Player();		
		UserInterface();
	    Chests();
	    Enemy();
	    Animation();
	    Map();
	    
	    //Creates a new thread which constantly listens for input.
	    Thread thread = new Thread() {
	    	public void run() {
	    		JTextField textField = new JTextField();
	    		//The inputHandler is later on in the Main Program.
	    		textField.addKeyListener(new InputHandler());
	    		contentPane.add(textField);
	    	}
	    };
	    
	    Thread thread2 = new Thread() {
	    	public void run() {
	    		class Movement extends TimerTask {
	    		    public void run() {	
	    		    	//This is only called when you interact with an enemy.
	    		    	if (InteractedWithCharacter) {
	    		    		Thread2EnemyBob();
	    		    	}

	    		    }
	    		}

	    		// And From your main() method or any other method
	    		Timer timer = new Timer();
	    		timer.schedule(new Movement(), 0, 50);
	    		//This is also on a timer schedule, to check every 50 milliseconds.
	    	}
	    };

	    thread.start();
	    //Thread 1 is started here.
	    thread2.start();
	    //Thread 2 is started here.

		
	    //Using an empty textField as to listen for the key input.
	    //If key is pressed it will call the CustomKeyListener
	    
	    //This calls the class Boundary.
		SetBoundaries C = new SetBoundaries();
	    
		colorW = C.North();
		colorS = C.South();
		colorA = C.West();
		colorD = C.East();
		//Gets all of the Boundary Colors and stores them within
		//the corrosponding values.
		

	    
	}
	
	/*
	 * This is to do with the Animation
	 * JLabel this is used for the transitions.
	 */
	public void Animation() {
	    Animation.setIcon(new ImageIcon(""));
	    Animation.setBounds(0, 0, 500, 500);
	    Animation.setEnabled(false);
	    Animation.setVisible(false);
	    contentPane.add(Animation);
	}
	
	/*
	 * This is to do with the UserInterface
	 * all the JLabels are contained in here.
	 */
	
	public void UserInterface() {
	    
	    txtHealth = new JTextField();
	    txtHealth.setEnabled(false);
	    txtHealth.setEditable(false);
	    txtHealth.setForeground(Color.WHITE);
	    txtHealth.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
	    txtHealth.setHorizontalAlignment(SwingConstants.CENTER);
	    txtHealth.setText("HEALTH");
	    txtHealth.setBackground(Color.BLACK);
	    txtHealth.setBounds(10, 11, 72, 20);
	    contentPane.add(txtHealth);
	    txtHealth.setColumns(10);
		HealthBar.setEnabled(false);
		HealthBar.setEditable(false);
		Armour.setEnabled(false);
		Armour.setEditable(false);
		
		Armour.setBackground(Color.CYAN);
		Armour.setBounds(85, 35, 0, 20);
		Armour.setColumns(10);
		contentPane.add(Armour);
	    
	   
		HealthBar.setBackground(Color.RED);
		HealthBar.setBounds(85, 10, player.Health, 20);
		HealthBar.setColumns(10);
	    contentPane.add(HealthBar);
	    
	    HealthBarBackground = new JTextField();
	    HealthBarBackground.setBackground(Color.LIGHT_GRAY);
	    HealthBarBackground.setEnabled(false);
	    HealthBarBackground.setEditable(false);
	    HealthBarBackground.setBounds(85, 10, 100, 20);
	    contentPane.add(HealthBarBackground);
	    HealthBarBackground.setColumns(10);
	    
	    txtArmour = new JTextField();
	    txtArmour.setEnabled(false);
	    txtArmour.setEditable(false);
	    txtArmour.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
	    txtArmour.setForeground(Color.WHITE);
	    txtArmour.setBackground(Color.BLACK);
	    txtArmour.setHorizontalAlignment(SwingConstants.CENTER);
	    txtArmour.setText("ARMOUR");
	    txtArmour.setBounds(10, 35, 72, 20);
	    contentPane.add(txtArmour);
	    txtArmour.setColumns(10);
	    
	    
	    textField_1 = new JTextField();
	    textField_1.setBackground(Color.LIGHT_GRAY);
	    textField_1.setEnabled(false);
	    textField_1.setEditable(false);
	    textField_1.setColumns(10);
	    textField_1.setBounds(85, 35, 100, 20);
	    contentPane.add(textField_1);
	    
	    txtWeaponName = new JTextField();
	    txtWeaponName.setEnabled(false);
	    txtWeaponName.setBackground(Color.BLACK);
	    txtWeaponName.setForeground(Color.WHITE);
	    txtWeaponName.setHorizontalAlignment(SwingConstants.CENTER);
	    txtWeaponName.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
	    txtWeaponName.setText("WEAPON NAME:");
	    txtWeaponName.setBounds(237, 9, 90, 20);
	    contentPane.add(txtWeaponName);
	    txtWeaponName.setColumns(10);
	    
	    textField_4 = new JTextField();
	    textField_4.setEnabled(false);
	    textField_4.setBackground(Color.BLACK);
	    textField_4.setForeground(Color.BLACK);
	    textField_4.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
	    textField_4.setColumns(10);
	    textField_4.setBounds(337, 9, 147, 20);
	    contentPane.add(textField_4);
	    
	    txtWeaponMultipler = new JTextField();
	    txtWeaponMultipler.setEnabled(false);
	    txtWeaponMultipler.setBackground(Color.BLACK);
	    txtWeaponMultipler.setForeground(Color.WHITE);
	    txtWeaponMultipler.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
	    txtWeaponMultipler.setText("WEAPON MULTIPLIER:");
	    txtWeaponMultipler.setColumns(10);
	    txtWeaponMultipler.setBounds(237, 35, 121, 20);
	    contentPane.add(txtWeaponMultipler);
	    txtXTimes.setEnabled(false);
	    
	    txtXTimes.setBackground(Color.BLACK);
	    txtXTimes.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
	    txtXTimes.setColumns(10);
	    txtXTimes.setBounds(363, 35, 121, 20);
	    contentPane.add(txtXTimes);
   
	}
	
	/*
	 * This is to do with the User Interface and sets it 
	 * visible and invisble as required.
	 */
	
	public void UserInterfaceSetVisible(Boolean TrueOrFalse) {
		txtHealth.setVisible(TrueOrFalse);
		HealthBar.setVisible(TrueOrFalse);
		HealthBarBackground.setVisible(TrueOrFalse);
		txtArmour.setVisible(TrueOrFalse);
		textField_1.setVisible(TrueOrFalse);
		txtWeaponName.setVisible(TrueOrFalse);
		textField_4.setVisible(TrueOrFalse);
		txtWeaponMultipler.setVisible(TrueOrFalse);
		txtXTimes.setVisible(TrueOrFalse);
		Armour.setVisible(TrueOrFalse);
	}
	
	/*
	 * This is using the Object, Background which 
	 * adds the JLabel.
	 */
	
	public void Map() {
		map = new Background(x, y, 2400, 900);
		map.setPosition(x, y);
		contentPane.add(map.label);
	}
	
	/*
	 * Sets all of the EnemyPositions
	 * So the X and Y Values
	 * as well as the Classes 
	 * and The Health of each Character.
	 */
	
	
	public void SetEnemyPositions() {
		int XC = 50;
		int YC = 100;
		addToX(XC);
		addToY(YC);
		Class.add("The Ruthless");
		Health.add(150);
		
		XC = 500;	
		YC = -10;
		addToX(XC);
		addToY(YC);
		Class.add("The Daring");
		Health.add(100);
		
		XC = 475;
		YC = -275;
		addToX(XC);
		addToY(YC);
		Class.add("The Confident");
		Health.add(100);
		
		XC = 200;
		YC = 200;
		addToX(XC);
		addToY(YC);
		Class.add("The Ruthless");
		Health.add(150);
			
	}
	
	/*
	 * This adds all the X values of the enemies
	 * into a list and has the original values 
	 * in that list as well. The method below does this
	 * does the exact same thing as well.
	 */
	
	public void addToX(int x) {
		X.add(x);
		OriginalX.add(x);
	}
	
	public void addToY(int y) {
		Y.add(y);
		OriginalY.add(y);
	}
	
	/*
	 * This adds of the Enemy JLabels to the ContentPane.
	 * This initalises there Health and there damage of there 3 attacks
	 * as well as their heal ability
	 */
	//This is also multiple objects being stored into a ArrayList
	public void Enemy() {
		for (int i = 0; i < X.size(); i++) {
			//This first set is only called for the very last enemy, which is the boss enemy and has buffed
			//attack statisitics. after Health.get(i) This shows, A1, A2, A3 and H1 
			//A1 = Attack 1
			//A2 = Attack 2
			//A3 = Attack 3
			//H1 = Heal 1
			
			if (((X.size() - i) == 1)) {
				//According to the Difficulty they we either do more or less damage.
				if (difficulty == 1) {
					enemies.add(new Enemy(X.get(i),Y.get(i),75, 75, Class.get(i), Health.get(i), 10, 15, 10, 30));
				}
				if (difficulty == 2) {
					enemies.add(new Enemy(X.get(i),Y.get(i),75, 75, Class.get(i), Health.get(i), 20, 25, 20, 40));
				}
				if (difficulty == 3) {
					enemies.add(new Enemy(X.get(i),Y.get(i),75, 75, Class.get(i), Health.get(i), 35, 40, 30, 50));
				}
				Interacted.add(false);	
			}
			// This is for the Normal enemies.
			else {
				if (difficulty == 1) {
					enemies.add(new Enemy(X.get(i),Y.get(i),75, 75, Class.get(i), Health.get(i), 10, 5, 15, 25));
				}
				if (difficulty == 2) {
					enemies.add(new Enemy(X.get(i),Y.get(i),75, 75, Class.get(i), Health.get(i), 15, 10, 25, 30));
				}
				if (difficulty == 3) {
					enemies.add(new Enemy(X.get(i),Y.get(i),75, 75, Class.get(i), Health.get(i), 20, 15, 30, 40));
				}
				Interacted.add(false);		
			}
		}
		
		// This then adds all the enemies to the ContentPane, and
		// sets the Boss Enemy as not visible and not Enabled.
		for (int i = 0; i < enemies.size(); i++) {
			krukrad.mainGame.Enemy Five = enemies.get(i);
			contentPane.add( Five.label );
			if (((X.size() - i) == 1)) {
				Five.NotBossEnemy = false;
				Five.setVisibleFalse();
				Five.EnabledEnemy = false;
			}
		}
		
	}
	
	// this adds all the chests which is 2 chests into the game.
	public void Chests() {
		//adds all the chests into a ArrayList
		for (int i = 0; i < 1; i++) {
			Chests.add(new Chest(-275, -525, 50, 50));
			Chests.add(new Chest(-250, 0, 50, 50));
			Interacted.add(false);
		}

		//Adds all the chests in the ArrayList on to the ContentPane
		for (int i = 0; i < Chests.size(); i++) {
			Chest Five = Chests.get(i);
			contentPane.add( Five.label );
		}
		
	}
	
	// this adds all the heartCanisters into a space.
	public void heartCanisters() {
		int Space = 0;
		
		for(int i = 0; i < 3; i++) {
			canisters.add(new Heart(75 - Space, 60, 30, 30, false));
			Space = Space + 30;
		}
		
		for (int i = 0; i < canisters.size(); i++) {
			Heart Five = canisters.get(i);
			contentPane.add( Five.label );

		}
	}
	
	// This adds the enemy to the ContentPane
	public void Player() {
		player = new Player(100, 100, 75, 75, 100, "The Athletic",25, 20, 5, "Ruthless Execution", "Bayonet Charge", "HEAL", Skin);
	    player.setPosition(200, 200);
	    contentPane.add(player.label);
	}
	

	/*This will check if the player is on the boundary
	 * if the player is on the boundary it will move the 
	 * player in the opposite direction.
	 * Therefore the player is not able to cheat
	 * and able to move directly into another room. 
	 */
	
	public void CheckBoundaries() {
		
		int TrueX = x - 200;
		int TrueY = y - 200;
		
		System.out.println(DeltaY);
		
		// this makes x = to the player position as the x and y coordinates are negative.
		
		
		//This turn the x and y value from a negative to a positive number. 
		int PositiveX = Math.abs(TrueX);
		int PositiveY = Math.abs(TrueY);
		
		for (int i = 0; i < X.size(); i++) {
			int x = OriginalX.get(i);
			int y = OriginalY.get(i);
			EnemyProximity(x, y, PositiveX, PositiveY, i);
		}
		
		for (int i = 0; i < Chests.size(); i++) {
			Chest X = Chests.get(i);
			int xChest = X.OriginalX;
			int yChest = X.OriginalY;
			ChestProximity(xChest, yChest, PositiveX, PositiveY, X);
		}
	
		
	    /*The keyboard input is checked
	     * so it can move in the opposite direction
	     * therefore the player can never move in-front of the boundary.
	     */
		CheckBoundaries C = new CheckBoundaries();
		
		Color sand = new Color(50,50,255);
		
		
		if (c == 'd') {
			Boolean IsItOnBoundary = false;
			int DX = PositiveX + 65;
			int DY = PositiveY + 25;
			
			IsItOnBoundary = C.OnBoundary(colorD, c2, DX, DY);
			speed = C.OnSand(colorD, sand, DX, DY, speed);
			if (IsItOnBoundary) {
				OnBoundary();
				OnBoundaryEnemy();
			}

		}

		else if (c == 's') {
			Boolean IsItOnBoundary = false;
			int DY = PositiveY + 40;
			int DX = PositiveX + 25;
			
			IsItOnBoundary = C.OnBoundary(colorS, c2, DX, DY);
			speed = C.OnSand(colorS, sand, DX, DY, speed);

			if (IsItOnBoundary) {
				OnBoundary();
				OnBoundaryEnemy();
			}

			 while (y < -625) {
				 y = -625;
				 OnBoundaryEnemy();
			 }
			 

		}
		
		else if (c == 'w') {
			Boolean IsItOnBoundary = false;
			int DY = PositiveY;
			int DX = PositiveX + 25;
		
			IsItOnBoundary = C.OnBoundary(colorW, c2, DX, DY);
			speed = C.OnSand(colorW, sand, DX, DY, speed);
			if (IsItOnBoundary) {
				OnBoundary();
				OnBoundaryEnemy();
			}
			
			
			 while (y > 200) {
				 y = 200;
				 OnBoundaryEnemy();
			 }
			
		}
		
		else if (c == 'a') {
			Boolean IsItOnBoundary = false;
			int DY = PositiveY + 25;
			int DX = PositiveX;
			
			IsItOnBoundary = C.OnBoundary(colorA, c2, DX, DY);
			speed = C.OnSand(colorA, sand, DX, DY, speed);
			
			if (IsItOnBoundary) {
				OnBoundary();
				OnBoundaryEnemy();
			}
			


		}	
		System.out.println(y);
		System.out.println(PositiveX + " , " + PositiveY);
	}
	
	
	/*
	 * If the player is on the boundary this class will be called allowing the user to move 
	 * the other direction, making sure that 
	 */
	public void OnBoundary() {
		if (c == 'w') {
			y = y - speed;
			// Y - Opposite Direction (S)
		}
		else if (c == 'a') {
			x = x - speed;
			// X - Opposite Direction (D)
		}
		else if (c == 's') {
			y = y + speed;
			// Y - Opposite Direction (W)
		}
		else if (c == 'd') {
			x = x + speed;
			// X - Opposite Direction (A)
		}

	}
	
	//As when you move with momentum everything else moves in the opposite direction, 
	// this ensures that it stays in the same position.
	
	public void KeepEnemyInSamePosition(int x, int y) {
		
		int XC = 0;
		int YC = 0;
		
		for (int i = 0; i < X.size(); i++) {
			XC= X.get(i);
			YC= Y.get(i);
			//gets enemy X and Y values and stored it in XC and YC
			YC = YC + y;
			XC = XC + x;
			// adds X and Y to both
			Y.set(i,YC);  
			X.set(i,XC);  
			//gets enemy X and Y values and as stored in XC and YC
			krukrad.mainGame.Enemy Five = enemies.get(i);
			Five.setPosition(XC, YC);
			//Sets the position of the enemies (JLabels)
		}
		
		for (int i = 0; i < Chests.size(); i++) {
			Chest Five = Chests.get(i);
			int ChestX = Five.x;
			int ChestY = Five.y;
			//gets chest X and Y values and stored it in ChestX and ChestY
			ChestY = ChestY + y;
			ChestX = ChestX + x;
			//adds X and Y to both Values.
			Five.setPosition(ChestX, ChestY);
			//Sets the position of the enemies (JLabels)

			
		}

	}
	  
	
	// When you hit a boundary there should be a equal and opposite force
	// on the other enemies. So this is the other force on the enemies.
	
	public void OnBoundaryEnemy() {
		if (c == 'w') {
			KeepEnemyInSamePosition(0, -speed);
			DeltaY = DeltaY - 5;
			// Y - Opposite Direction (S)
		}
		else if (c == 'a') {
			KeepEnemyInSamePosition(-speed, 0);
			// X - Opposite Direction (D)
		}
		else if (c == 's') {
			KeepEnemyInSamePosition(0, speed);
			DeltaY = DeltaY + 5;
			// Y - Opposite Direction (W)
		}
		else if (c == 'd') {
			KeepEnemyInSamePosition(speed, 0);
			// X - Opposite Direction (A)
		}
	}
	
	
	//checks how close the player is to Chests on the Map
	
	public void ChestProximity(int x2, int y2 , int PX, int PY, Chest H ) {
		
		
		int XScreen = 200 - x2;
		// Gets the Displacement from the players first point in the X Component.
		int YScreen = 200 - y2;
		// Gets the Displacement from the players first point in the Y Compoenent.
			
		int LowerX= (760 - XScreen) - 60; 
		int UpperX= (760 - XScreen) + 60; 
		int UpperY= (815 - YScreen) + 90;
		int LowerY= (815 - YScreen) - 90; 
		
		// It then takes it away from 760 (X) and 815 (Y)
		// and then works out a upper and lower boundary for each of the values.

		Boolean Get = H.Opened;
		//It then gets the value and see's if the chest has already been opened.

    	
		if (PX >= LowerX && PX <= UpperX && PY >= LowerY  && PY <= UpperY && !Get) {
			//If true it means that you are able to open a chest.
			H.Opened = true;
			H.updateBounds();
			repaint();
			
			// Sets the chest boolean value as opened == True
			// it updates the chest to make it look open.
			// repaints the canvas

			int random = new Random().nextInt(100);
			
			// randomises a value
			
			//if you already got one weapon/shield you will automatically get the other in
			// the next chest.
			
			if (player.gotShield && !player.gotWeapon) {
				random = 55;
			}
			
			else if (player.gotWeapon && !player.gotShield) {
				random = 10;
			}
			
			//if the value is less than 50 then you get armour.
			System.out.println("random number = " + random);
			if (random < 50 && !player.gotShield) {
				//It calls AttackWeapon To see how much armour you have gained.
				Shield();
				//It then updates the TextBox to say what you got.
				if (c != 'k' && !NearEnemyTextBox) {
					UpdateTextBox("Armour      Gained");
					Box.setVisibleTrue();
					TextBoxActive = true;
					repaint();
					revalidate();
					player.gotShield = true;
				}
			}
			//if the value is equal to or more than 50 then you get a weapon.
			else if (random >= 50 && !player.gotWeapon) {
				//It calls AttackWeapon To See what weapon you have got.
				AttackWeapon();
				//It then updates the TextBox to say what you got.
				if (c != 'k' && !NearEnemyTextBox) {
					UpdateTextBox("Weapon      Gained");
					Box.setVisibleTrue();
					TextBoxActive = true;
					repaint();
					revalidate();
					player.gotWeapon = true;
				}
				
			}
		}
	}
			
	/*
	 * If the weapon has been chosen in the chest
	 * then you can see in the game
	 * you get a specific type of weapon and gets a 
	 * specific name of the weapon.
	 * The name is gotten from the value
	 * WeaponName(X);
	 */

	private void AttackWeapon() {
		int random = new Random().nextInt(100);
		
		if (random < 60) {
			player.Multiplier = 2;
			String Name[] = WeaponName(1);
			int randomNameIdentifier = new Random().nextInt(10);
			textField_4.setText(Name[randomNameIdentifier]);
			txtXTimes.setText(player.Multiplier + " Times");
		}
		if (random >= 60 && random <= 90) {
			player.Multiplier = 3;
			String Name[] = WeaponName(2);
			int randomNameIdentifier = new Random().nextInt(10);
			textField_4.setText(Name[randomNameIdentifier]);
			txtXTimes.setText(player.Multiplier + " Times");
		}
		if (random > 90) {
			player.Multiplier = 4;
			String Name[] = WeaponName(3);
			int randomNameIdentifier = new Random().nextInt(10);
			textField_4.setText(Name[randomNameIdentifier]);
			txtXTimes.setText(player.Multiplier + " Times");
		}
		
	}
	
	/*
	 * If the shield has been chosen in the chest
	 * then you will randomly get a shield
	 * however the shield will be 
	 * between 20 and 100
	 */

	private void Shield() {
		int random = new Random().nextInt(100);
		if (random < 20) {
			random = 20;
		}
		player.Shield = random;
		ShieldUpdate();
	}
	
	
	//checks how close the player is to enemy on the Map

	public void EnemyProximity(int x2, int y2 , int PX, int PY, int enemy ) {
		
		int XScreen = 200 - x2;
		int YScreen = 200 - y2;
		
		// Gets the Displacement from the players first point in the X Component.
		// Gets the Displacement from the players first point in the Y Compoenent.
		
		int TrueX = 760 -XScreen;
		int TrueY = 815 -YScreen;
		
		// Works out the the True X Value on the map.
		
		int LowerX= (760 - XScreen) - 80; 
		int UpperX= (760 - XScreen) + 80; 
		int UpperY= (815 - YScreen) + 100;
		int LowerY= (815 - YScreen) - 100; 
		
		// It then takes it away from 760 (X) and 815 (Y)
		// and then works out a upper and lower boundary for each of the values.
		
		Boolean Get = Interacted.get(enemy);
		//Gets whether the enemy has interacted
		Enemy XZ = enemies.get(enemy);
		//gets the enemy itself
		Boolean Enabled = XZ.EnabledEnemy;
		//it also checks that is enabled, so that you don't encounter the boss.

    	
		if (PX >= LowerX && PX <= UpperX && PY >= LowerY  && PY <= UpperY && !Get && Enabled) {
			
			Enemy = enemy;	
			
			//There are multiple version here as the skin can change from game to game 
			    if (c == 'd') {
			    	if (Skin == 1) {
				    	player.UpdateImage("res/character/1/CharacterDStill.png");
			    	}
			    	if (Skin == 2) {
				    	player.UpdateImage("res/character/2/CharacterDStill.png");
			    	}
			    	if (Skin == 3) {
				    	player.UpdateImage("res/character/3/CharacterDStill.png");
			    	}
			    	if (Skin == 4) {
				    	player.UpdateImage("res/character/4/CharacterDStill.png");
			    	}
			    	if (Skin == 5) {
				    	player.UpdateImage("res/character/5/CharacterDStill.png");
			    	}
				}
				if (c == 'a') {
			    	if (Skin == 1) {
						player.UpdateImage("res/character/1/CharacterAStill.png");
			    	}
			    	if (Skin == 2) {
						player.UpdateImage("res/character/2/CharacterAStill.png");
			    	}
			    	if (Skin == 3) {
						player.UpdateImage("res/character/3/CharacterAStill.png");
			    	}
			    	if (Skin == 4) {
						player.UpdateImage("res/character/4/CharacterAStill.png");
			    	}
			    	if (Skin == 5) {
						player.UpdateImage("res/character/5/CharacterAStill.png");
			    	}

				}
				//The TextBox is updated and says the "RAHHH!" - the enemy.
				if (c != 'k' && !NearEnemyTextBox) {
					UpdateTextBox("Raaaaaaaah!!!!");
					Box.setVisibleTrue();
					TextBoxActive = true;
					repaint();
					revalidate();
					NearEnemyTextBox = true;
				}
				
				//When enter is pressed on that textbox it leads to the next else method.

				else {	
					// sets as false
					NearEnemyTextBox = false;
					Animation.setVisible(true);
					Animation.setEnabled(true);
					UserInterfaceSetVisible(false);
					Animation.setIcon(new ImageIcon("res/transition/transition.gif"));
					//adds a transition gif
					Paused = true;
			
					// Makes all but the interacted enemy invisible
					for (int i = 0; i < X.size(); i++) {
						if (i == Enemy) {
							i++;
						}
						if (i < X.size()) {
							krukrad.mainGame.Enemy Five = enemies.get(i);
							Five.setVisibleFalse();
						}
					}
					
					// Makes all the heart canisters invisible
					
					for (int J = 0; J < canisters.size(); J++) {
						Heart Canistor = canisters.get(J);
						Canistor.setVisibleFalse();
					}
						
					int XCoordinate = PX;
					int YCoordinate = PY;
				
					Timer t = new Timer();
					TimerTask tt = new TimerTask() {
						@Override
						public void run() {
							// sets the InteracterWithCharacter
							// This automatically moves the character
							// as the thread is already always looking for this 
							Animation.setIcon(new ImageIcon("res/transition/10.png"));
							InteractedWithCharacter = true;
							DifferenceXA = XCoordinate - TrueX + 65;
							//System.out.println(DifferenceXA);
							DifferenceXD = XCoordinate - TrueX - 65;
							DifferenceYW = YCoordinate - TrueY + 5;
							DifferenceYS = YCoordinate - TrueY - 5;
							System.out.println(DifferenceYW);
							System.out.println(DifferenceYS);
							System.out.println(Enemy);
							t.cancel();
						}
					};
					t.schedule(tt,1000,1000);
				}
			}
		else {
			// met then equals 0
			met = 0;
		}
	}

	/*
	 * this is the sequences of the textbox 
	 * which is seen in the first few states of the game
	 * which take to explain the game to you
	 */

	public void SequenceTextBox() {
		
		for (int i = 0; i < LetterBox.size(); i++) {
			Five = LetterBox.get(i);
			Five.setVisibleTrue();
		}
		
		Box.setVisibleTrue();
		if (SequenceTextBox == 0) {
			UpdateTextBox("Press Enter");
			TextBoxActive = true;
			SequenceTextBox++;
		}
		else if (SequenceTextBox == 1) {
			UpdateTextBox("Welcome To  Krukrad");
			TextBoxActive = true;
			SequenceTextBox++;
		}
		else if (SequenceTextBox == 2) {
			UpdateTextBox("PRESS WASD  TO MOVE");
			TextBoxActive = true;
			SequenceTextBox++;
		}
		else if (SequenceTextBox == 3) {
			UpdateTextBox("OR THE ARROWKEYS");
			TextBoxActive = true;
			SequenceTextBox++;
		}
		else if (SequenceTextBox == 4) {
			UpdateTextBox("PRESS P TO  PAUSE OR ESC");
			TextBoxActive = true;
			SequenceTextBox++;
		}
		else if (SequenceTextBox == 5) {
			UpdateTextBox("GOOD LUCK");
			TextBoxActive = true;
			SequenceTextBox++;
		}
		else if (SequenceTextBox == 6) {
			UpdateTextBox("May The Oddsever...");
			TextBoxActive = true;
			SequenceTextBox++;
		}
		
		else if (SequenceTextBox == 7) {
			UpdateTextBox("Be In Your  Favour");
			TextBoxActive = true;
			SequenceTextBox++;
		}
		else {
			Box.setVisibleFalse();
			TextBoxActive = false;
		}
		
		if (NearEnemyTextBox) {
			CheckBoundaries();
		}
	}
	
	// This resets the keys pressed, so c will equal x;
	
	public void KeyHandler() {
		if (KeyInput == KeyEvent.VK_UP && c == 'w') {
			c = 'x';
		}
		else if (KeyInput == KeyEvent.VK_DOWN && c == 's') {
			c = 'x';
		}
		else if (KeyInput == KeyEvent.VK_LEFT && c == 'a') {
			c = 'x';
		}
		else if (KeyInput == KeyEvent.VK_RIGHT && c == 'd') {
			c = 'x';
		}
	}

	
	  class InputHandler implements KeyListener{
		@Override
		public void keyPressed(KeyEvent e) {
		    c = e.getKeyChar();
		    KeyInput = e.getKeyCode();
		    
		    KeyHandler();
		    
		    if ((KeyInput == KeyEvent.VK_UP || c == 'w') && !Paused && !TextBoxActive) {
		    	c = 'w';
		    	UP();
		    	//calls the up function.
		    }
		    if ((KeyInput == KeyEvent.VK_DOWN ||c == 's') && !Paused && !TextBoxActive) {
		    	c = 's';
		    	DOWN();
		    	//calls the down function.
		    }
		    if ((KeyInput == KeyEvent.VK_RIGHT || c == 'd') && !Paused && !TextBoxActive) {
		    	c = 'd';
		    	RIGHT();
		    	//calls the right function.
		    }
		    if ((KeyInput == KeyEvent.VK_LEFT ||c == 'a') && !Paused && !TextBoxActive) {
		    	c = 'a';
		    	LEFT();
		    	//calls the left function.
		    }
		    if (KeyInput == KeyEvent.VK_ESCAPE || c == 'p') {
		    	PAUSE();
		    	//calls the pause function.
		    }
		    if (KeyInput == KeyEvent.VK_ENTER || c == 'k') {
		    	if(!PauseMenuActive) {
			    	TextBox();
			    	//calls the TextBox function.
		    	}
		    }
		    if (c == 'i' && HealPressed == 0) {
		    	if (!InBattle) {
		    		HealPressed++;
		    		// this gets the cannisters size and if it hasn't been used
		    		// it is then used and then the for loop is stopped
		    		// by i being changed to 99
		    		for (int i = 0; i < canisters.size(); i++) {
		    			Heart Five = canisters.get(i);
		    			if ((!(Five.Used)) && player.Health < 100) {
		    				Five.setVisibleFalse();
		    				Five.Used = true;
		    				player.Health = 100;
		    				HealthBar.setBounds(85, 10, player.Health, 20);
		    				updatePlayerHealthBox(player.Health);
		    				i = 99;
		    			}
		    		}
		    	}	
		    }
		    
		    
		}
		@Override
		public void keyReleased(KeyEvent e) {
		    char cR = e.getKeyChar();
		    KeyInput = e.getKeyCode();
		    
		    // this changes the key to UP and changes c to x, the same happens to A,S,D and also resets the 
		    // Corresponding Pressed integer value.
		    if ((KeyInput == KeyEvent.VK_UP || cR == 'w') && !Paused && !TextBoxActive && c == 'w') {
		    	c = 'x';
		    	w = 2;
		    	wPressed = 0;
		    }
		    if ((KeyInput == KeyEvent.VK_DOWN || cR == 's') && !Paused && !TextBoxActive && c == 's') {
		    	c = 'x';
		    	s = 2;
		    	sPressed = 0;
		    }
		    if ((KeyInput == KeyEvent.VK_LEFT ||cR == 'a') && !Paused && !TextBoxActive && c == 'a') {
		    	c = 'x';
		    	a = 2;
		    	aPressed = 0;
		    	//This makes sure that the character is always using the stops in the same place when let go.
		    	if (Skin == 1) {
					player.UpdateImage("res/character/1/CharacterAStill.png");
		    	}
		    	if (Skin == 2) {
					player.UpdateImage("res/character/2/CharacterAStill.png");
		    	}
		    	if (Skin == 3) {
					player.UpdateImage("res/character/3/CharacterAStill.png");
		    	}
		    	if (Skin == 4) {
					player.UpdateImage("res/character/4/CharacterAStill.png");
		    	}
		    	if (Skin == 5) {
					player.UpdateImage("res/character/5/CharacterAStill.png");
		    	}
		    }
		    if ((KeyInput == KeyEvent.VK_RIGHT ||cR == 'd') && !Paused && !TextBoxActive && c == 'd') {
		    	c = 'x';
		    	d = 2;
		    	dPressed = 0;
		    	//This makes sure that the character is always using the stops in the same place when let go.
		    	if (Skin == 1) {
			    	player.UpdateImage("res/character/1/CharacterDStill.png");
		    	}
		    	if (Skin == 2) {
			    	player.UpdateImage("res/character/2/CharacterDStill.png");
		    	}
		    	if (Skin == 3) {
			    	player.UpdateImage("res/character/3/CharacterDStill.png");
		    	}
		    	if (Skin == 4) {
			    	player.UpdateImage("res/character/4/CharacterDStill.png");
		    	}
		    	if (Skin == 5) {
			    	player.UpdateImage("res/character/5/CharacterDStill.png");
		    	}
		    }
		    if (c == 'i') {
		    	//Heal Pressed = 0, so that you can't hold down the I button
		    	HealPressed = 0;
		    }
		}
		@Override
		public void keyTyped(KeyEvent e) {
			//This empty as no key is being typed
			//However, this had to be in the code as it wouldn't
			//work without this as well as KeyPressed, KeyReleased, KeyTyped
		}
	}
	  

	  
	  
	  // This flips between the two different movements for the character
	  // so there is Boolean as there is only two options here
	  // 0 and 1 (true or false).
	  public void PlayerAnimationHandler() {
		  if(c == 'w') {
			  if(W) {
				  W = false;
				  w = 0;
			  }
			  else {
				  W = true;
				  w = 0;
			  }
		  }
		  else if(c == 's') {
			  if(S) {
				  S = false;
				  s = 0;
			  }
			  else {
				  S = true;
				  s = 0;
			  }
		  }
		  
		  else if(c == 'a') {
			  if(A) {
				  A = false;
				  a = 0;
			  }
			  else {
				  A = true;
				  a = 0;
			  }
		  }
		  
		  else if(c == 'd') {
			  if(D) {
				  D = false;
				  d = 0;
			  }
			  else {
				  D = true;
				  d = 0;
			  }
		  }
	  }
	  

	  // This following methods all affect the movement of the character.
		public void UP() {
	    	y = y + speed;
			DeltaY = DeltaY + speed;
			KeepEnemyInSamePosition(0, speed);
			map.setPosition(x, y);
			
			// it adds to the Y axis and then sets the new position of the JLabel
			
			
			Toolkit.getDefaultToolkit().sync();
			//CODE FROM: https://stackoverflow.com/questions/25348631/screen-tearing-jpanel-game-and-double-buffering
			//To Reduce ScreenTearing.
			// Screen Tearing was present in the game however the issue has become not as noticeable as it was before. 
			
			if(wPressed > 4) {
				if (w == 2) {
					player.UpdateImageMovementW(W);
					PlayerAnimationHandler();
				}
				w++;

				// If this code is not placed then the animation changes too quickly. Therefore, this delays the animation.
			}
			else {
				player.UpdateImageMovementW(W);
				PlayerAnimationHandler();
			}
			Toolkit.getDefaultToolkit().sync();
			
			CheckBoundaries();
			wPressed++;
			//Checks the boundaries and then adds to the Value wPressed.
			revalidate();
			repaint();
		}
		
		public void DOWN() {
	    	y = y - speed;
			DeltaY = DeltaY - speed;
			KeepEnemyInSamePosition(0, -speed);
			map.setPosition(x, y);
			
			// it takes away from the Y axis and then sets the new position of the JLabel
			
			Toolkit.getDefaultToolkit().sync();
			//CODE FROM: https://stackoverflow.com/questions/25348631/screen-tearing-jpanel-game-and-double-buffering
			//To Reduce ScreenTearing.
			// Screen Tearing was present in the game however the issue has become not as noticeable as it was before. 
			
			if(sPressed > 4) {
				if (s == 2) {
					player.UpdateImageMovementS(S);
					PlayerAnimationHandler();
				}
				s++;
				// If this code is not placed then the animation changes too quickly. Therefore, this delays the animation.
			}
			else {
				player.UpdateImageMovementS(S);
				PlayerAnimationHandler();
			}
			
			CheckBoundaries();
			sPressed++;
			//Checks the boundaries and then adds to the Value sPressed.
			revalidate();
			repaint();
		}
		
		public void RIGHT() {
	    	x = x - speed;
			DeltaX = DeltaX - speed;
			KeepEnemyInSamePosition(-speed, 0);
			map.setPosition(x, y);
			
			// it takes away from the X axis and then sets the new position of the JLabel
			
			Toolkit.getDefaultToolkit().sync();
			//CODE FROM: https://stackoverflow.com/questions/25348631/screen-tearing-jpanel-game-and-double-buffering
			//To Reduce ScreenTearing.
			// Screen Tearing was present in the game however the issue has become not as noticeable as it was before. 
			
			if(dPressed > 4) {
				if (d == 2) {
					player.UpdateImageMovementD(D);
					PlayerAnimationHandler();
				}
				d++;
			}
			// If this code is not placed then the animation changes too quickly. Therefore, this delays the animation.
			else {
				player.UpdateImageMovementD(D);
				PlayerAnimationHandler();
			}
			
			CheckBoundaries();
			//Checks the boundaries and then adds to the Value dPressed.
			dPressed++;
			revalidate();
			repaint();
		}
		
		public void LEFT() {
	    	x = x + speed;
			DeltaX = DeltaX + speed;
			KeepEnemyInSamePosition(speed, 0);
			map.setPosition(x, y);
			
			// it adds to the X axis and then sets the new position of the JLabel
			
			Toolkit.getDefaultToolkit().sync();
			//CODE FROM: https://stackoverflow.com/questions/25348631/screen-tearing-jpanel-game-and-double-buffering
			//To Reduce ScreenTearing.
			// Screen Tearing was present in the game however the issue has become not as noticeable as it was before. 
			
			if(aPressed > 4) {
				if (a == 2) {
					player.UpdateImageMovementA(A);
					PlayerAnimationHandler();
				}
				a++;
				// If this code is not placed then the animation changes too quickly. 
				// Therefore, this delays the animation.
			}
			else {
				player.UpdateImageMovementA(A);
				PlayerAnimationHandler();
			}
			
			CheckBoundaries();
			aPressed++;
			//Checks the boundaries and then adds to the Value aPressed.
			revalidate();
			repaint();
		}
		
		//This either makes the PauseMenu Components, Visible or makes it invisible.
		public void PAUSE() {
	    	if (!Paused) {
	    		Paused = true;
	    		PauseMenuActive = true;
	    	    ExitButton.setIcon(new ImageIcon("res/pause/pause.gif"));
	    		PauseButton.setVisible(true);
	    	    ResumeButton.setVisible(true);
	    	    btnExitGame.setVisible(true);
	    		repaint();
	    	}
	    	else {
	    		Paused = false;
	    		PauseMenuActive = false;
	    	    ExitButton.setIcon(new ImageIcon(""));
	    		PauseButton.setVisible(false);
	    	    ResumeButton.setVisible(false);
	    	    btnExitGame.setVisible(false);
	    		repaint();
	    	}
		}
		
		// This then gets rid of the TextBox on the screen
		// If this is during the first few states of the game
		// it will also go through the sequences of the different TextBox States.
		public void TextBox() {
			for (int i = 0; i < LetterBox.size(); i++) {
				Five = LetterBox.get(i);
				Five.UpdateImage(null);
				Five.setVisibleFalse();
			}
			Box.setVisibleFalse();
			Paused = false;
			
			TextBoxActive = false;
			
			repaint();
			revalidate();
			
			int Interval = 0;
			
			while(Interval < I) {
				queueA.remove();
				Interval++;
			}
			I = 0;
			
			SequenceTextBox();
		}
		
	//EVERYTHING ABOVE THIS POINT IS TO DO WITH CANVAS and MOVEMENT
	//BELOW IS TO DO WITH BATTLEHANDLING --> CANVAS (-_-)
		
		public void BattleTransition() {
			Timer t = new Timer();
			TimerTask tt = new TimerTask() {
			    @Override
			    public void run() {
					Animation.setIcon(new ImageIcon("res/transition/white.png"));
					InBattle = true;
					Enemy John = enemies.get(Enemy);
					TempHealth = John.Health;
					updateEnemyHealthBox(TempHealth);
					//Updates the HealthBox before going into battle,
					//As it may have a similar to textBox to before.
					revalidate();
					repaint();
			    	t.cancel();
				    SetVisible(true);
				    SetEnabled(true);
					updateText();
			    	repaint();
			    	revalidate();
				}
			};
			t.schedule(tt,2800,2800);
		}
		
		//This then delays the battle transition and turns all components invisible.
		
		public void Update() {
			Timer t = new Timer();
			TimerTask tt = new TimerTask() {
			    @Override
			    public void run() {
					player.setVisibleFalse();
					for (int i = 0; i < enemies.size(); i++) {
						krukrad.mainGame.Enemy Five = enemies.get(i);
						Five.setVisibleFalse();
						map.setVisibleFalse();
						txtHealth.setVisible(false);
						HealthBarBackground.setVisible(false);
						HealthBar.setVisible(false);
						InteractedWithCharacter = false;
						Animation.setIcon(new ImageIcon("res/transition/BlackToWhiteTransition.gif"));
						//Makes the Components not visible and then
						//Sets the animation as the SetIcon
						BattleTransition();
						//Then calls the BattleTransition.
					}

					revalidate();
					repaint();
			    	t.cancel();
			    }
			};
			t.schedule(tt,250,250);
			
		}
		
		//Updates the Shield Components, (Values which are shown on screen).
		public void ShieldUpdate() {
		    textField_3.setBounds(153, 185, player.Shield, 20);
		    txtPlayerShield.setText("Player Shield : " + player.Shield);
		    Armour.setBounds(85, 35, player.Shield, 20);
		}
		
		//This method contains all of the Components used in the battle.
		public void BattleComponents() {

			
		    EnemyBattleHealth = new JTextField();
		    EnemyBattleHealth.setEditable(false);
		    EnemyBattleHealth.setEnabled(false);
		    EnemyBattleHealth.setBackground(Color.RED);
		    EnemyBattleHealth.setBounds(313, 28, 150, 20);
		    contentPane.add(EnemyBattleHealth);
		    EnemyBattleHealth.setColumns(10);
		    
		    textField_3 = new JTextField();
		    textField_3.setBackground(Color.CYAN);
		    textField_3.setBounds(153, 185, 0, 20);
		    contentPane.add(textField_3);
		    textField_3.setColumns(10);
		    textField_3.setEditable(false);
		    
		    txtPlayerShield = new JTextField();
		    txtPlayerShield.setText("Player Shield : " + "0");
		    txtPlayerShield.setBounds(153, 164, 165, 20);
		    contentPane.add(txtPlayerShield);
		    txtPlayerShield.setColumns(10);
		    txtPlayerShield.setEditable(false);
		    
		    txtLastTurn.setEditable(false);
			txtLastTurn.setHorizontalAlignment(SwingConstants.CENTER);
			txtLastTurn.setText("Last Turn");
			txtLastTurn.setBounds(188, 28, 86, 20);
			txtLastTurn.setColumns(10);
		    
			PlayerDamage.setBounds(153, 133, 165, 20);
			PlayerDamage.setColumns(10);
			PlayerDamage.setEditable(false);
			
			EnemyDamage.setEditable(false);
			EnemyDamage.setBounds(154, 79, 164, 20);
			EnemyDamage.setColumns(10);
				
			PlayerAttacked.setEditable(false);
			PlayerAttacked.setText("Player Attack:");
			PlayerAttacked.setBounds(153, 108, 165, 20);
			PlayerAttacked.setColumns(10);
			
		    EnemyAttacked = new JTextField();
		    EnemyAttacked.setText("Enemy Attack:");
		    EnemyAttacked.setEditable(false);
		    EnemyAttacked.setBounds(153, 58, 165, 20);
		    contentPane.add(EnemyAttacked);
		    EnemyAttacked.setColumns(10);
		    
		    YouHaveDied.setFont(new Font("Century Schoolbook", Font.PLAIN, 40));
		    YouHaveDied.setHorizontalAlignment(SwingConstants.CENTER);
		    YouHaveDied.setForeground(Color.BLACK);
		    YouHaveDied.setBounds(57, 110, 382, 64);
		    contentPane.add(YouHaveDied);
		    
		    LeaveGame.setBackground(Color.WHITE);
		    LeaveGame.setBounds(149, 321, 190, 23);
			LeaveGame.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					//Leaves the Game.
					System.exit(0);
				}
				
			});
		    contentPane.add(LeaveGame);
		    contentPane.add(PlayerAttacked);
		    contentPane.add(EnemyDamage);
		    contentPane.add(PlayerDamage);
		    contentPane.add(txtLastTurn);
		    
		    textField_2 = new JTextField();
		    textField_2.setEnabled(false);
		    textField_2.setEditable(false);
		    textField_2.setColumns(10);
		    textField_2.setBackground(Color.RED);
		    textField_2.setBounds(20, 28, 100, 20);
		    contentPane.add(textField_2);
			
			PlayerHealthJL.setHorizontalAlignment(SwingConstants.CENTER);
			PlayerHealthJL.setForeground(Color.BLACK);
			PlayerHealthJL.setBackground(Color.RED);
			PlayerHealthJL.setBounds(20, 10, 100, 20);
			contentPane.add(PlayerHealthJL);
			
			EnemyImage.setIcon(new ImageIcon("res/characterMugShot/enemy.png"));
			EnemyImage.setHorizontalAlignment(SwingConstants.CENTER);
			EnemyImage.setBounds(324, 79, 160, 129);
			contentPane.add(EnemyImage);
			
			Player.setIcon(new ImageIcon("res/characterMugShot/character.png"));
			Player.setHorizontalAlignment(SwingConstants.CENTER);
			Player.setBounds(0, 79, 160, 129);
			contentPane.add(Player);
			AttackOneButton.setBackground(Color.WHITE);
			AttackOneButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					// makes a new state of AttackHandler and gets the attack numbers and health.
					AttackHandler Z = new AttackHandler();
					Enemy John = enemies.get(Enemy);
					int Health = John.Health;
					String Class = John.EnemyClass;
					int AttackDamage = player.AttackD1;
					String Attack = player.Attack1Name;
					
					//Gets the logic of how much damage the attack does.
					int DamageDone = Z.whatLogicToUse(Attack, AttackDamage, Class, Health, turn);
					DamageDone = DamageDone * player.Multiplier;
					// if the player has a weapon the multiplier will be added to it
					Health = Health - DamageDone;
					// this is then taken away
					John.Health = Health;
					// stores this in the enemies health
					updateEnemyHealthBox(Health);
					
					if (Health <= 0) {
						IfEnemyDead();
						John.Dead = true;
						John.Health = 0;
					    CheckForEndGame();
						Interacted.add(Enemy, true);
						John.UpdateImage("res/enemy/gravestone.png");
						repaint();
						revalidate();
					}
					turn++;
					UpdateText();
					
					// it then checks whether the enemy has died.
					
					int attackType = EnemyAttack();
					int DamageToPlayer= EnemyDamageHandler(attackType);
					
					//if the player is alive it does the following.
					if(John.Health > 0) {
						
						//if the attackType is 4, the Heal is added.
						if (attackType == 4) {
							John.Health = John.Health + John.HealAbility;
							if (John.Health > TempHealth) {
								John.Health = TempHealth;
							}
						}
						//else it first needs to get rid of the shield
						// then it will effect the health of the character
						else {
							if (player.Shield != 0) {
								player.Shield = player.Shield - DamageToPlayer;
								if (player.Shield < 0) {
									player.Shield = 0;
								}
							}
							else {
								player.Health = player.Health - DamageToPlayer;
							}
						}
						
						//stores the health in player health
						//This then updates the player health box
						//this then updates the shield box aswell
						int HealthP = player.Health;
						updatePlayerHealthBox(HealthP);
						ShieldUpdate();
						
						//then checks the player damage and whether the player is dead
						if (player.Health <= 0) {
							player.Health = 0;
							PlayerDead();
							SetVisible(false);
							SetEnabled(false);
						}
					}
					// it then resets the following values
					else {
						attackType = 0;
						DamageToPlayer = 0;
					}
					
					//updates the player Health
					
					updatePlayerHealthBox(player.Health);
					ShieldUpdate();
					
					// then checks again if the player has died.
					if (player.Health <= 0) {
						player.Health = 0;
						PlayerDead();
						SetVisible(false);
						SetEnabled(false);
					}
					
					//Put the attack of choice on the screen
					String PlayerAttack = AttackOneButton.getText();
					
					//displays the values
					DisplayDamageAttackVariables(attackType, DamageToPlayer, DamageDone, PlayerAttack);
					
					//if the attackType is 4 then the following happens.
					if (attackType == 4) {
						DisplayDamageAttackVariables(4, John.HealAbility, player.AttackD1, PlayerAttack);
						updateEnemyHealthBox(John.Health);
					}
					

					
				}
			});	
			AttackOneButton.setBounds(44, 219, 395, 23);
			contentPane.add(AttackOneButton);
			AttackTwoButton.setBackground(Color.WHITE);
			
			//The logic of this is explained in AttackOneButton
			AttackTwoButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					AttackHandler Z = new AttackHandler();
					Enemy John = enemies.get(Enemy);
					int Health = John.Health;
					String Class = John.EnemyClass;
					int AttackDamage = player.AttackD2;
					String Attack = player.Attack2Name;
					
					int DamageDone = Z.whatLogicToUse(Attack, AttackDamage, Class, Health, turn);
					DamageDone = DamageDone * player.Multiplier;
					Health = Health - DamageDone;
					John.Health = Health;
					updateEnemyHealthBox(Health);
					
					if (Health <= 0) {
						IfEnemyDead();
						John.Dead = true;
						John.Health = 0;
						CheckForEndGame();
						Interacted.add(Enemy, true);
						John.UpdateImage("res/enemy/gravestone.png");
						repaint();
						revalidate();
					}
					turn++;
					UpdateText();
					int attackType = EnemyAttack();
					int DamageToPlayer= EnemyDamageHandler(attackType);
					
					if(John.Health > 0) {
						if (attackType == 4) {
							John.Health = John.Health + John.HealAbility;
							if (John.Health > TempHealth) {
								John.Health = TempHealth;
							}
						}
						else {
							if (player.Shield != 0) {
								player.Shield = player.Shield - DamageToPlayer;
								if (player.Shield < 0) {
									player.Shield = 0;
								}
							}
							else {
								player.Health = player.Health - DamageToPlayer;
							}
						}
						
						int HealthP = player.Health;
						updatePlayerHealthBox(HealthP);
						ShieldUpdate();
						
						if (player.Health <= 0) {
							player.Health = 0;
							PlayerDead();
							SetVisible(false);
							SetEnabled(false);
						}
					}
					
					else {
						attackType = 0;
						DamageToPlayer = 0;
					}

					String PlayerAttack = AttackTwoButton.getText();
					
					DisplayDamageAttackVariables(attackType, DamageToPlayer, DamageDone, PlayerAttack);
					if (attackType == 4) {
						DisplayDamageAttackVariables(4, John.HealAbility, player.AttackD2, PlayerAttack);
						updateEnemyHealthBox(John.Health);
					}
					
				}
			});
			AttackTwoButton.setBounds(44, 253, 395, 23);
			contentPane.add(AttackTwoButton);
			
			//The logic of this is explained in AttackOneButton
			AttackThreeButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {					
					player.Health = player.Health + player.HealD3;
					
					if (player.Health > 100) {
						player.Health = 100;
					}
					
					Enemy John = enemies.get(Enemy);
					turn++;
					UpdateText();
					int attackType = EnemyAttack();
					int DamageToPlayer= EnemyDamageHandler(attackType);
					
					if (attackType == 4) {
						John.Health = John.Health + John.HealAbility;
						if (John.Health > TempHealth) {
							John.Health = TempHealth;
						}
					}
					else {
						if (player.Shield != 0) {
							player.Shield = player.Shield - DamageToPlayer;
							if (player.Shield < 0) {
								player.Shield = 0;
							}
						}
						else {
							player.Health = player.Health - DamageToPlayer;
						}
					}
					
					int HealthP = player.Health;
					updatePlayerHealthBox(HealthP);
					ShieldUpdate();
					
					if (player.Health <= 0) {
						player.Health = 0;
						PlayerDead();
						SetVisible(false);
						SetEnabled(false);
					}
					
					String PlayerAttack = AttackThreeButton.getText();
					DisplayDamageAttackVariables(attackType, DamageToPlayer, player.HealD3, PlayerAttack);
					
					if (attackType == 4) {
						DisplayDamageAttackVariables(attackType, John.HealAbility, player.HealD3, PlayerAttack);
						updateEnemyHealthBox(John.Health);
					}
					
				}
			});
			AttackThreeButton.setBackground(Color.WHITE);
			
			AttackThreeButton.setBounds(44, 287, 395, 23);
			contentPane.add(AttackThreeButton);
			
			PlayerClass.setBounds(44, 332, 150, 14);
			contentPane.add(PlayerClass);
			
			lblClass.setHorizontalAlignment(SwingConstants.RIGHT);
			lblClass.setBounds(289, 332, 150, 14);
			contentPane.add(lblClass);
			btnSkipTurn.setBackground(Color.WHITE);
			
			btnSkipTurn.setBounds(44, 357, 395, 23);
			contentPane.add(btnSkipTurn);
			
			lblTurn.setHorizontalAlignment(SwingConstants.CENTER);
			
			//The logic of this is explained in AttackOneButton excluding the player attacks.
			btnSkipTurn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					turn++;
					repaint();
					UpdateText();
					int attackType = EnemyAttack();
					int DamageToPlayer= EnemyDamageHandler(attackType);
		
					Enemy John = enemies.get(Enemy);
					if (attackType == 4) {
						John.Health = John.Health + John.HealAbility;
					}
					else {
						if (player.Shield != 0) {
							player.Shield = player.Shield - DamageToPlayer;
							if (player.Shield < 0) {
								player.Shield = 0;
							}
						}
						else {
							player.Health = player.Health - DamageToPlayer;
						}
					}
					int HealthP = player.Health;
					updatePlayerHealthBox(HealthP);
					ShieldUpdate();
					
					if (player.Health <= 0) {
						player.Health = 0;
						PlayerDead();
						SetVisible(false);
						SetEnabled(false);
					}
					String PlayerAttack = AttackThreeButton.getText();
					DisplayDamageAttackVariables(attackType, DamageToPlayer, 0, PlayerAttack);
					
					if (attackType == 4) {
						DisplayDamageAttackVariables(attackType, John.HealAbility, 0, PlayerAttack);
						updateEnemyHealthBox(John.Health);
					}
				}
			});
			lblTurn.setBounds(186, 436, 108, 14);
			contentPane.add(lblTurn);
			
			MainEnemy.setBackground(Color.RED);
			MainEnemy.setForeground(Color.BLACK);
			MainEnemy.setHorizontalAlignment(SwingConstants.CENTER);
			MainEnemy.setBounds(313, 10, 150, 20);
			contentPane.add(MainEnemy);			
		}
		
		//This updates the JComponents so it shows how much damage it has done the characters.
		public void DisplayDamageAttackVariables(int attackType, int damageToPlayer, int damageToEnemy, String player2Attack) {
			AttackHandler Z = new AttackHandler();
			playerAttack = Z.Type;
			krukrad.Attacks.EnemyAttack X = new krukrad.Attacks.EnemyAttack();
			enemyAttack = X.AttackSkipOrHeal(attackType);
			EnemyAttacked.setText(enemyAttack);
			PlayerAttacked.setText(player2Attack);
			String PlayerDamageString = Integer.toString(damageToEnemy);
			String EnemyDamageString = Integer.toString(damageToPlayer);	
			EnemyDamage.setText(EnemyDamageString);
			PlayerDamage.setText(PlayerDamageString);
		}
		
		//This gets the EnemyAttack which it will carry out.
		public int EnemyAttack() {
			DecisionMaking nc = new DecisionMaking();
			Enemy John = enemies.get(Enemy);
			int EnemyHealth = John.Health;
			int EnemyAttack1 = John.AttackOneDamage;
			int EnemyAttack2 = John.AttackTwoDamage;
			int EnemyAttack3 = John.AttackThreeDamage;
			int PlayerHealth = player.Health;
			String EnemyClass = John.EnemyClass;
			
			int attack = nc.getVariablesEnemy(EnemyHealth, EnemyAttack1, EnemyAttack2, EnemyAttack3, PlayerHealth, EnemyClass);
			return attack;
		}
		
		//Returns the amount of damage that the Enemy Does.
		public int EnemyDamageHandler(int AttackType) {
			int damage = 0;
			Enemy John = enemies.get(Enemy);
			if (AttackType == 0) {
				damage = 0;
			}
			else if (AttackType == 1) {
				damage = John.AttackOneDamage;
			}
			else if (AttackType == 2) {
				damage = John.AttackTwoDamage;
			}
			else if (AttackType == 3) {
				damage = John.AttackThreeDamage;
			}
			return damage;
		}
		
		//Updates The Turn each round.
		public void UpdateText() {
			lblTurn.setText("TURN : " + turn);
		}
		
		//Updates the Enemy HealthBox in the Battle
		public void updateEnemyHealthBox(int Health) {
		    EnemyBattleHealth.setBounds(313, 28, Health, 20);
		    String healthText= Integer.toString(Health);
		    MainEnemy.setText(healthText);
		}
		
		//Updates the Player HealthBox in the Battle
		public void updatePlayerHealthBox(int Health) {
			textField_2.setBounds(20, 28, Health, 20);
		    String healthText= Integer.toString(Health);
		    PlayerHealthJL.setText(healthText);
		}
		
		//This then updates the text of the attacks and damage.
		public void updateText() {
			String EnemyClass = Class.get(Enemy);
			lblClass.setText(EnemyClass + " : CLASS");
			String PClass = player.PlayerClass;
			PlayerClass.setText("CLASS: " + PClass);
			AttackOneButton.setText(player.Attack1Name);
			AttackTwoButton.setText(player.Attack2Name);
			AttackThreeButton.setText(player.Heal1Name);
			MainEnemy.setBackground(Color.RED);
			int H = Health.get(Enemy);
		    EnemyBattleHealth.setBounds(313, 28, H, 20);    
		}
		
		/*
		 * This changes whether the Player Dead Menu
		 * is invisible or visible.
		 */
		
		public void PlayerDeadVisible(Boolean True) {
			YouHaveDied.setVisible(True);
			LeaveGame.setVisible(True);
		}
		
		/*
		 * This changes whether the Player Dead Menu
		 * is enabled or disabled.
		 */
		
		public void PlayerDeadEnabled(Boolean True) {
			YouHaveDied.setEnabled(True);
			LeaveGame.setEnabled(True);
		}
		
		/* 
		 * This is the how the game will Make the BattleComponents visible
		 * or invisible, so they don't interfere when they are not 
		 * needed.
		 */
		
		public void SetVisible(Boolean True) {
			PlayerHealthJL.setVisible(True);
			EnemyImage.setVisible(True);
			Player.setVisible(True);
			AttackOneButton.setVisible(True);
			AttackTwoButton.setVisible(True);
			AttackThreeButton.setVisible(True);
			PlayerClass.setVisible(True);
			lblClass.setVisible(True);
			btnSkipTurn.setVisible(True);
			lblTurn.setVisible(True);
			MainEnemy.setVisible(True);
			textField_2.setVisible(True);
			EnemyBattleHealth.setVisible(True);
			PlayerDamage.setVisible(True);
			EnemyDamage.setVisible(True);
			PlayerAttacked.setVisible(True);
			EnemyAttacked.setVisible(True);
		    txtLastTurn.setVisible(True);
		    textField_3.setVisible(True);
		    txtPlayerShield.setVisible(True);
		}
		
		/* 
		 * This is the how the game will Make the PlayerDeadMenu components enabled
		 * or disabled and are Visible or Invisible , so they don't interfere 
		 * when they are not needed. They are then accordingly dead.
		 * Which then requires them to restart the game.
		 */
		
		public void PlayerDead() {
			PlayerDeadEnabled(true);
			PlayerDeadVisible(true);
		}
		
		//This checks whether or not the game has ended.
		public void CheckForEndGame() {
			int EnemiesDead = 0;
			//Checkes how many Enemies have died
			for (int i = 0; i < enemies.size(); i++) {
				krukrad.mainGame.Enemy Five = enemies.get(i);
				if(!(Five.Dead) && Five.NotBossEnemy) {
					EnemiesDead++;
				}
			}
			//If the enemies are all dead it checks whether or not the Boss has been killed
			if(EnemiesDead == 0) {
				krukrad.mainGame.Enemy Five = enemies.get(enemies.size() - 1);
				if (!Five.NotBossEnemy && Five.Dead) {
					PlayerDeadVisible(true);
					PlayerDeadEnabled(true);
					UserInterfaceSetVisible(false);
					
					player.setVisibleFalse();
					
					for (int J = 0; J < X.size(); J++) {
						Enemy Bob = enemies.get(J);
						Bob.setVisibleFalse();
					}
					
					
					for (int J = 0; J < canisters.size(); J++) {
						Heart Canistor = canisters.get(J);
						Canistor.setVisibleFalse();
					}
					//This then makes the entire game invisible
					
					Paused = true;
					YouHaveDied.setText("VICTORY");
					Animation.setVisible(true);
					Animation.setIcon(new ImageIcon("res/transition/white.png"));	
					// Makes it so the UI is shown, that the User is able to see that they have won.
					endTime = System.nanoTime();
					long totalTime = endTime - startTime;
					long Seconds = TimeUnit.SECONDS.convert(totalTime, TimeUnit.NANOSECONDS);			
					GameSet();
					UpdateTime NC = new UpdateTime();
					NC.LeaderBoardUpdate((double)Seconds);
					// Gets the Time in seconds and updates the Leaderboard and also calls 
					// the method GameSet
				}
				// if the boss hasn't been killed it will be spawned
				// as this will be the very last enemy in the game.
				else {
					Five.NotBossEnemy = false;
					Five.setVisibleTrue();
					Five.EnabledEnemy = true;
					//Makes the Boss Visible
					if (c != 'k' && !NearEnemyTextBox) {
						UpdateTextBox("Boss Has    Arrived");
						//Notifies the user that the Boss has arrived.
						Box.setVisibleTrue();
						TextBoxActive = true;
						repaint();
						revalidate();
						player.gotShield = true;
					}
				}

			}
		}
		
		//This adds the number of games.
		public void GameSet() {
		    String line;
		    int Victories = 0;
		    //it will try to read the file and if it catches,
		    // it will try to create the file and write the number 1
		    // if the file does exist it will get the value and add 1 and rewrite it to the text file.
		    try {
			    FileReader in = new FileReader("res/otherFiles/VictoryNumber.txt");
			    BufferedReader br = new BufferedReader(in);
				while ((line = br.readLine()) != null) {
				    System.out.println(line);		    
				    Victories = Integer.parseInt(line);
				    Victories++;
				}
			    in.close();
        		try {
					PrintWriter writer = new PrintWriter("res/otherFiles/VictoryNumber.txt", "UTF-8");
					writer.println(Victories);
					writer.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			} catch (IOException e) {
        		try {
					PrintWriter writer = new PrintWriter("res/otherFiles/VictoryNumber.txt", "UTF-8");
					writer.println(1);
					writer.close();
				} catch (Exception e2) {
					e.printStackTrace();
				}
			}
		}
		
		/* 
		 * This is the how the game will Make the BattleComponents enabled
		 * and disabled, so they don't interfere when they are not 
		 * needed.
		 */
		
		public void SetEnabled(Boolean True) {
			PlayerHealthJL.setEnabled(True);
			EnemyImage.setEnabled(True);
			Player.setEnabled(True);
			AttackOneButton.setEnabled(True);
			AttackTwoButton.setEnabled(True);
			AttackThreeButton.setEnabled(True);
			PlayerClass.setEnabled(True);
			lblClass.setEnabled(True);
			btnSkipTurn.setEnabled(True);
			lblTurn.setEnabled(True);
			MainEnemy.setEnabled(True);
			textField_2.setEnabled(True);
			EnemyBattleHealth.setEnabled(True);
			PlayerDamage.setEnabled(True);
			EnemyDamage.setEnabled(True);
			PlayerAttacked.setEnabled(True);
			EnemyAttacked.setEnabled(True);
			txtLastTurn.setEnabled(True);
		    textField_3.setVisible(True);
			txtPlayerShield.setVisible(True);
		}
		
		//This is called when the enemy has died within the battle, this returns
		//the player back to the original place and map where they started. 
		public void IfEnemyDead() {
			System.out.println("Enemy Dead");
			SetVisible(false);
		    SetEnabled(false);
			UserInterfaceSetVisible(true);
		    //Sets all the BattleComponents notVisible and notEnabled.
			
			Random rand = new Random();
			int randomNum = rand.nextInt((20 - 1) + 1) + 1;
			 
			player.Health = player.Health + randomNum;
			if (player.Health > 100) {
				player.Health = 100;
			}

			for (int i = 0; i < enemies.size(); i++) {
				krukrad.mainGame.Enemy Five = enemies.get(i);
				Five.setVisibleTrue();
				if (!(Five.EnabledEnemy)) {
					Five.setVisibleFalse();
				}
				InteractedWithCharacter = false;
				//Sets all enemies as visible.
			}
			
			//makes the animation invisible as there will be no icon filling it. 
			//Map and Player is then set as visible.
			Animation.setIcon(new ImageIcon(""));	
			map.setVisibleTrue();
			player.setVisibleTrue();

			//Unpause the movement so that the player is able to move. 
			Paused = false;

			//Sets the HealthBar and HealthBarGround as visible.
			//Then repaints and revalidates everything on the JFrame
			//Which then calls the EnemyMovementParameterReset method.
			txtHealth.setVisible(true);
			HealthBarBackground.setVisible(true);
			HealthBar.setVisible(true);
			
			for (int i = 0; i < canisters.size(); i++) {
				Heart Five = canisters.get(i);
				if (!(Five.Used)) {
					Five.setVisibleTrue();
				}
			}
			revalidate();
			repaint();
			EnemyMovementParameterReset();
		}
		
		
		/*
		 * This resets the parameters for the enemy movement when encountered
		 * this means that it can move freely, and doesn't glitch out.
		 */	
		public void EnemyMovementParameterReset() {
			DifferenceXA = 0;
			DifferenceXD = 0;
			DifferenceYW = 0;
			DifferenceYS = 0;
			Direction[1] = false;
			Direction[3] = false;
			Stopped = false;
			YMovement = false;
			turn = 0;
			HealthBar.setBounds(85, 10, player.Health, 20);
			InBattle = false;
			updatePlayerHealthBox(player.Health);
		}
}
