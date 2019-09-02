package krukrad.mainUI;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import krukrad.LeaderboardUpdate.ReadLeaderBoard;
import krukrad.mainGame.Main;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;


import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class ui extends JFrame {

	private static final long serialVersionUID = 4772423670896163961L;
	private JPanel contentPane;
	private JTextField GameTitle;
	private JTextField txtLeaderboard;
	private JTextField Minutes;
	private JTextField Seconds;
	private JTextField Minutes1;
	private JTextField Minutes2;
	private JTextField Minutes3;
	private JTextField Minutes4;
	private JTextField Minutes5;
	private JTextField Seconds1;
	private JTextField Seconds2;
	private JTextField Seconds3;
	private JTextField Seconds4;
	private JTextField Seconds5;
	private JTextField txtCharacterCustomisation;
	private JTextField textField1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField Difficulty1;
	private JComboBox<Object> DifficultyChoice;
	private JComboBox<Object> SkinChoice = new JComboBox<Object>();
	//private JFrame ui = new ui();
	
	
	Boolean Play_notleft = true;
	Boolean Play_clicked = false;
	Boolean Exit_notleft = true;
	Boolean Exit_clicked = false;
	Boolean Easy = true;
	Boolean Medium = true;
	Boolean Hard = true;
	String SelectedDifficulty = " ";
	int leftmenu = 0;
	String Name = " ";
	int index = 0;
	int volume = 75;
	Boolean Timer = false;
    Timer timer = new Timer("Timer");
    static double widthD = 0;
    static double heightD = 0;
    static int width = 0;
    static int height = 0;
    static int Difficulty = 2;
    static int CharacterSkin = 1;
    static int Won = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ui frame = new ui();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setJMenuBar(null);
					frame.setLocationRelativeTo(null);
					ImageIcon img = new ImageIcon("res/JFrameLogo/dungeon.png");
					frame.setIconImage(img.getImage());
					frame.setTitle("Project Krukrad");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	}
	


	/**
	 * Create the frame.
	 */
	
	// cals the Launcher and loads the launcher components
	public ui() {
		Launcher();	      	
	}
	
	// this loads the game, and adds a loading GIF.
	public void loading() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 283);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("res/UI/loading.gif"));
		lblNewLabel.setBounds(0, 0, 417, 246);
		contentPane.add(lblNewLabel);
		loadTheGameFrame();
	}
	
	//This reads the file and stores the amount of games won in the variable "won"
	public void CheckGamesWon() {
	    String line;
	    try {
		    FileReader in = new FileReader("res/otherFiles/VictoryNumber.txt");
		    BufferedReader br = new BufferedReader(in);
			while ((line = br.readLine()) != null) {
			    System.out.println(line);		    
			    Won = Integer.parseInt(line);
			}
		    in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// loads the game frame
	public void loadTheGameFrame(){
	    TimerTask repeatedTask = new TimerTask() {
	        public void run() {
	        	if(!Timer) {
	        		//music();
	        		String Hello;
	        		
	        		// sets the following difficulty
	        		try {
	        			Hello= (String) DifficultyChoice.getSelectedItem();
	        		} catch (Exception e) {
	        			Hello = "Medium";
	        		}
					System.out.println(Hello);
	        		if (Hello == "Easy") {
	        			Difficulty = 1;
	        		}
	        		if (Hello == "Medium") {
	        			Difficulty = 2;
	        		}
	        		if (Hello == "Hard") {
	        			Difficulty = 3;
	        		}
	        		
	        		//writes the difficulty in the TextFile
	        		try {
						PrintWriter writer = new PrintWriter("res/otherFiles/Difficulty.txt", "UTF-8");
						writer.println(Difficulty);
						writer.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
	        		
	        		try {
	        			Hello= (String) SkinChoice.getSelectedItem();
	        		} catch (Exception e) {
	        			Hello = "Normal";
	        		}
					System.out.println(Hello);
	        		if (Hello == "Normal") {
	        			CharacterSkin = 1;
	        		}
	        		if (Hello == "Ghost") {
	        			CharacterSkin = 2;
	        		}
	        		if (Hello == "Red") {
	        			CharacterSkin = 3;
	        		}
	        		if (Hello == "Blue") {
	        			CharacterSkin = 4;
	        		}
	        		if (Hello == "Gold") {
	        			CharacterSkin = 5;
	        		}
	        		
	        		//writes the character customisation choice in the TextFile
	        		
	        		try {
						PrintWriter writer = new PrintWriter("res/otherFiles/CharacterModel.txt", "UTF-8");
						writer.println(CharacterSkin);
						writer.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
	        		
	        		
	        		//this then opens a JFrame and sets the corrosponding JFrame Features.
	            	Main nf=new Main(); 
	            	nf.setVisible(true);
	            	nf.setLocationRelativeTo(null);
					ImageIcon img = new ImageIcon("res/JFrameLogo/dungeon.png");
					nf.setIconImage(img.getImage());
					nf.setTitle("Project Krukrad");
					nf.setResizable(false);
	         		timer.cancel();
	        		timer.purge();
	            	dispose();	
	        	}
	        }
	    };
	     
	    long delay  = 1000L;
	    long period = 1000L;
	    timer.scheduleAtFixedRate(repeatedTask, delay, period);
	}

	
	public void Launcher() {
		CheckGamesWon();
		this.setLocationRelativeTo(null);
		getContentPane().removeAll();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 433, 287);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		
		//sets the contentpane to place multiple different elements within 
		
		
		GameTitle = new JTextField();
		GameTitle.setEnabled(false);
		GameTitle.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		//removes the textfield border
		GameTitle.setEditable(false);
		GameTitle.setBackground(Color.BLACK);
		GameTitle.setForeground(Color.WHITE);
		GameTitle.setText("PROJECT KRUKRAD");
		// Set the text of the the textField
		GameTitle.setFont(new Font("Centaur", Font.BOLD, 26));
		// Set tht font of the new text as well as setting it BOLD and at a size of 26
		GameTitle.setBounds(80, 11, 249, 45);
		contentPane.add(GameTitle);
		GameTitle.setColumns(10);
		GameTitle.setOpaque(false);
		// Sets the background of the textField to be transparent
		


		//To do with the play button and how it works
		ImageIcon playbutton = new ImageIcon("res/UI/playbuttonnormal.png");
		JLabel ButtonPlay = new JLabel(playbutton);
		ButtonPlay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ImageIcon playbuttonhover = new ImageIcon("res/UI/playbuttonhover.png");
				ButtonPlay.setIcon(playbuttonhover);
				Play_notleft = true;
				if (Play_clicked) {
					ImageIcon playbuttonpush = new ImageIcon("res/UI/playbuttonpush.png");
					ButtonPlay.setIcon(playbuttonpush);
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon playbuttonleft = new ImageIcon("res/UI/playbuttonnormal.png");
				ButtonPlay.setIcon(playbuttonleft);
			    Play_notleft = false;
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon playbuttonpush = new ImageIcon("res/UI/playbuttonpush.png");
				ButtonPlay.setIcon(playbuttonpush);
				Play_notleft = true;
				Play_clicked = true;
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon playbuttonrelease = new ImageIcon("res/UI/playbuttonnormal.png");
				ButtonPlay.setIcon(playbuttonrelease);
				if (Play_notleft && Play_clicked) {
					loading();
				}
				Play_clicked = false;
			}
		});
		ButtonPlay.setBounds(36, 192, 135, 45);
		contentPane.add(ButtonPlay);
		
		textField1 = new JTextField();
		textField1.setEnabled(false);
		textField1.setForeground(Color.WHITE);
		contentPane.add(textField1);
		textField1.setColumns(10);
		textField1.setFont(new Font("Centaur", Font.BOLD, 11));
		textField1.setText("By Inder Panesar");
		textField1.setEditable(false);
		textField1.setBounds(155, 48, 150, 20);
		textField1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		textField1.setOpaque(false);


		

		ImageIcon exitbutton = new ImageIcon("res/UI/exitbuttonnormal.png");
		JLabel ButtonExit = new JLabel(exitbutton);

		
   
		ButtonExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ImageIcon exitbuttonhover = new ImageIcon("res/UI/exitbuttonhover.png");
				ButtonExit.setIcon(exitbuttonhover);
				Exit_notleft = true;
				if (Exit_clicked) {
					ImageIcon exitbuttonpush = new ImageIcon("res/UI/exitbuttonpush.png");
					ButtonExit.setIcon(exitbuttonpush);
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon exitbuttonleft = new ImageIcon("res/UI/exitbuttonnormal.png");
				ButtonExit.setIcon(exitbuttonleft);
				Exit_notleft = false;
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon exitbuttonpush = new ImageIcon("exitbuttonpush.png");
				ButtonExit.setIcon(exitbuttonpush);
				Exit_notleft = true;
				Exit_clicked = true;
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon exitbuttonrelease = new ImageIcon("res/UI/exitbuttonnormal.png");
				ButtonExit.setIcon(exitbuttonrelease);
				if (Exit_notleft && Exit_clicked) {
					System.exit(0);
				}
				Exit_clicked = false;
			}
		});
		ButtonExit.setBounds(247, 192, 135, 45);
		contentPane.add(ButtonExit);
		
		ImageIcon imageSettings = new ImageIcon("res/UI/settings.png");
		JLabel lblNewLabel = new JLabel(imageSettings);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				settings();
			}
		});
		lblNewLabel.setBounds(361, 11, 46, 30);
		contentPane.add(lblNewLabel);
		
		ImageIcon imageIcon = new ImageIcon("res/UI/game.gif");
		JLabel label = new JLabel(imageIcon);
		label.setBounds(0, 0, 434, 261);
		contentPane.add(label);
	}
	
	//Sets all the setting components.
	public void settings() {
		repaint();
		revalidate();
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 433, 286);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		// This sets all the variables required for the Leader-board
		ReadLeaderBoard nc = new ReadLeaderBoard();
		List<java.lang.String> timeInSeconds = nc.list();
		List <Double> timeInSecondsDouble = new ArrayList<Double>();
		List <String> timeSecondsIntegers = new ArrayList<String>();
		List <String> timeMinutesIntegers = new ArrayList<String>();
		
		//This then converts the following to Minutes and Second
		for (int J = 0; J < timeInSeconds.size(); J++) {
			double total = Double.parseDouble(timeInSeconds.get(J));
			System.out.println(total);
			timeInSecondsDouble.add(total);
		}
		
		for (int J = 0; J < timeInSecondsDouble.size(); J++) {
			double seconds = timeInSecondsDouble.get(J);
			double secondsMinutes = seconds/60;
			
			double ActualSeconds = secondsMinutes - Math.floor(secondsMinutes);
			double ActualMinutes = Math.floor(secondsMinutes);
			
			
			double SecondsShown = 60 * ActualSeconds;
			double x = SecondsShown - Math.floor(SecondsShown);

			
			int i = (int) ActualMinutes;		
			int c = (int) SecondsShown;
			
			if (x > 0.4) {
				c++;
			}
			
			String MinutesAsString = Integer.toString(i);
			
			if (c < 10 && c > -1) {
				String SecondsAsString = "0" + Integer.toString(c);
				timeSecondsIntegers.add(SecondsAsString);
			}
			else {
				String SecondsAsString = Integer.toString(c);
				timeSecondsIntegers.add(SecondsAsString);
			}
			
			timeMinutesIntegers.add(MinutesAsString);
		}
		
		
		

		

		// Cancel returns to the menu
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setBackground(SystemColor.inactiveCaption);
		btnCancel.setFont(new Font("Rockwell", Font.PLAIN, 13));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Launcher();
				leftmenu++;
			}
		});
		btnCancel.setBounds(10, 214, 180, 23);
		contentPane.add(btnCancel);
		

		
		JButton button = new JButton("CONFIRM");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Launcher();
				leftmenu++;
				
			}
		});
		button.setFont(new Font("Rockwell", Font.PLAIN, 13));
		button.setBackground(SystemColor.inactiveCaption);
		button.setBounds(225, 214, 180, 23);
		contentPane.add(button);
		
		
		txtLeaderboard = new JTextField();
		txtLeaderboard.setEditable(false);
		txtLeaderboard.setHorizontalAlignment(SwingConstants.CENTER);
		txtLeaderboard.setText("Leaderboard");
		txtLeaderboard.setBounds(10, 11, 191, 20);
		contentPane.add(txtLeaderboard);
		txtLeaderboard.setColumns(10);
		
		Minutes = new JTextField();
		Minutes.setEditable(false);
		Minutes.setHorizontalAlignment(SwingConstants.CENTER);
		Minutes.setText("Minutes");
		Minutes.setBounds(10, 42, 86, 20);
		contentPane.add(Minutes);
		Minutes.setColumns(10);
		
		Seconds = new JTextField();
		Seconds.setEditable(false);
		Seconds.setText("Seconds");
		Seconds.setHorizontalAlignment(SwingConstants.CENTER);
		Seconds.setColumns(10);
		Seconds.setBounds(115, 42, 86, 20);
		contentPane.add(Seconds);
		
		Minutes1 = new JTextField();
		Minutes1.setEditable(false);
		Minutes1.setHorizontalAlignment(SwingConstants.RIGHT);
		Minutes1.setBounds(10, 73, 86, 20);
		contentPane.add(Minutes1);
		Minutes1.setColumns(10);
		Minutes1.setText(timeMinutesIntegers.get(0));
		
		Minutes2 = new JTextField();
		Minutes2.setEditable(false);
		Minutes2.setHorizontalAlignment(SwingConstants.RIGHT);
		Minutes2.setBounds(10, 97, 86, 20);
		contentPane.add(Minutes2);
		Minutes2.setColumns(10);
		Minutes2.setText(timeMinutesIntegers.get(1));
		
		Minutes3 = new JTextField();
		Minutes3.setEditable(false);
		Minutes3.setHorizontalAlignment(SwingConstants.RIGHT);
		Minutes3.setBounds(10, 120, 86, 20);
		contentPane.add(Minutes3);
		Minutes3.setColumns(10);
		Minutes3.setText(timeMinutesIntegers.get(2));
		
		Minutes4 = new JTextField();
		Minutes4.setEditable(false);
		Minutes4.setHorizontalAlignment(SwingConstants.RIGHT);
		Minutes4.setBounds(10, 145, 86, 20);
		contentPane.add(Minutes4);
		Minutes4.setColumns(10);
		Minutes4.setText(timeMinutesIntegers.get(3));
		
		Minutes5 = new JTextField();
		Minutes5.setEditable(false);
		Minutes5.setHorizontalAlignment(SwingConstants.RIGHT);
		Minutes5.setBounds(10, 170, 86, 20);
		contentPane.add(Minutes5);
		Minutes5.setColumns(10);
		Minutes5.setText(timeMinutesIntegers.get(4));
		
		Seconds1 = new JTextField();
		Seconds1.setEditable(false);
		Seconds1.setHorizontalAlignment(SwingConstants.LEFT);
		Seconds1.setColumns(10);
		Seconds1.setBounds(115, 73, 86, 20);
		contentPane.add(Seconds1);
		Seconds1.setText(timeSecondsIntegers.get(0));
		
		Seconds2 = new JTextField();
		Seconds2.setEditable(false);
		Seconds2.setHorizontalAlignment(SwingConstants.LEFT);
		Seconds2.setColumns(10);
		Seconds2.setBounds(115, 97, 86, 20);
		contentPane.add(Seconds2);
		Seconds2.setText(timeSecondsIntegers.get(1));
		
		Seconds3 = new JTextField();
		Seconds3.setEditable(false);
		Seconds3.setHorizontalAlignment(SwingConstants.LEFT);
		Seconds3.setColumns(10);
		Seconds3.setBounds(115, 120, 86, 20);
		contentPane.add(Seconds3);
		Seconds3.setText(timeSecondsIntegers.get(2));
		
		Seconds4 = new JTextField();
		Seconds4.setEditable(false);
		Seconds4.setHorizontalAlignment(SwingConstants.LEFT);
		Seconds4.setColumns(10);
		Seconds4.setBounds(115, 145, 86, 20);
		contentPane.add(Seconds4);
		Seconds4.setText(timeSecondsIntegers.get(3));
		
		Seconds5 = new JTextField();
		Seconds5.setEditable(false);
		Seconds5.setHorizontalAlignment(SwingConstants.LEFT);
		Seconds5.setColumns(10);
		Seconds5.setBounds(115, 170, 86, 20);
		contentPane.add(Seconds5);
		Seconds5.setText(timeSecondsIntegers.get(4));
		
		txtCharacterCustomisation = new JTextField();
		txtCharacterCustomisation.setHorizontalAlignment(SwingConstants.CENTER);
		txtCharacterCustomisation.setText("Character Customisation");
		txtCharacterCustomisation.setBounds(216, 11, 191, 20);
		contentPane.add(txtCharacterCustomisation);
		txtCharacterCustomisation.setEditable(false);
		txtCharacterCustomisation.setColumns(10);
		
		SkinChoice.setBackground(Color.WHITE);
		//if you have won more than 5 games you unlock a special character
		if (Won < 5) {
			SkinChoice.setModel(new DefaultComboBoxModel<Object>(new String[] {"Normal","Ghost", "Red", "Blue"}));
		}
		else {
			SkinChoice.setModel(new DefaultComboBoxModel<Object>(new String[] {"Normal","Ghost", "Red", "Blue", "Gold"}));

		}		
		SkinChoice.setBounds(216, 42, 191, 20);
		contentPane.add(SkinChoice);
		
		textField1 = new JTextField();
		textField1.setEditable(false);
		textField1.setHorizontalAlignment(SwingConstants.CENTER);
		textField1.setText(":");
		textField1.setBounds(100, 73, 11, 20);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setText(":");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		textField_1.setBounds(100, 97, 11, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setText(":");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setColumns(10);
		textField_2.setBounds(100, 120, 11, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setText(":");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setColumns(10);
		textField_3.setBounds(100, 145, 11, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setText(":");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setColumns(10);
		textField_4.setBounds(100, 170, 11, 20);
		contentPane.add(textField_4);
		
		Difficulty1 = new JTextField();
		Difficulty1.setText("Difficulty");
		Difficulty1.setHorizontalAlignment(SwingConstants.CENTER);
		Difficulty1.setColumns(10);
		Difficulty1.setBounds(216, 73, 191, 20);
		Difficulty1.setEditable(false);
		contentPane.add(Difficulty1);
		
		// this is where the 3 different difficulty are shown.
		DifficultyChoice = new JComboBox<Object>();
		DifficultyChoice.setModel(new DefaultComboBoxModel<Object>(new String[] {"Medium", "Easy", "Hard"}));
		DifficultyChoice.setBackground(Color.WHITE);
		DifficultyChoice.setBounds(216, 107, 191, 20);
		contentPane.add(DifficultyChoice);
	}
	


}




