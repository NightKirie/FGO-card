package menu;

import menu.Button;
import card.Player;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.AttributedCharacterIterator;

import java.net.URL;

import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.stage.Stage;
import javax.swing.JSlider;
import javax.swing.JTextPane;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class MainWindow extends JFrame{

	private final JPanel contentPane;
	
	private final JFXPanel fxPanel = new JFXPanel();		//for FX to play, not sure why
	
	private final MediaPlayer menuBGM = new MediaPlayer(new Media(getClass().getResource("/audio/Menu_BGM.mp3").toString()));		//for menu BGM
	private final MediaPlayer gameBGM = new MediaPlayer(new Media(getClass().getResource("/audio/InGame_BGM.mp3").toString()));		//for in game BGM
	private final MediaPlayer trolling_Fx = new MediaPlayer(new Media(getClass().getResource("/audio/Trolling_Sound.mp3").toString()));	//for LOLs
	
	private final Button skillButton = new Button();		//for go to skill page
	private final Button startButton = new Button();		//for start the game
	private final Button chararcterButton = new Button();	//for go to character page
	private final Button achievementButton = new Button();	//for go to achievement page
	private final Button backButton = new Button();			//for any page to go back to the menu
	private final Button leftButton = new Button();			//for character page to preview next character
	private final Button rightButton = new Button();		//for character page to preview previous character
	private final Button settingButton = new Button();		//for go to setting
	
	private final JLabel menuTitle = new JLabel("");		//for menu title picture
	private final JLabel backGround = new JLabel("");		//for menu background picture
	private final JLabel nothingIsHere = new JLabel("");	//for the page is not done
	private final JLabel showCharacter = new JLabel("");	//for character page to show the character
	
	private final JSlider musicSlider = new JSlider();
	private final JSlider fxSlider = new JSlider();
	
	
	private static double musicVolume;
	private static double fxVolume;
	

	/**********
	  Launch the application.
	 ****/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void InitialPage() {		
		//Initial skillButton in Menu
		skillButton.setIcon(new ImageIcon(MainWindow.class.getResource("/image/Skill_Btn.png")));
		skillButton.setBounds(250, 255, 115, 155);
		skillButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {	
				SkillPage();
			}
		});	
		contentPane.add(skillButton);
		
		//Initial start Button in Menu
		startButton.setIcon(new ImageIcon(MainWindow.class.getResource("/image/Start_Btn.png")));
		startButton.setBounds(250, 410, 115, 130);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {		
				StartGame();
			}
		});
		contentPane.add(startButton);
		
		//Initial characterButton in Menu
		chararcterButton.setIcon(new ImageIcon(MainWindow.class.getResource("/image/Character_Btn.png")));
		chararcterButton.setBounds(115, 255, 115, 155);
		chararcterButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {	
				CharacterPage();
			}
		});
		contentPane.add(chararcterButton);

		//Initial achievementButton in Menu
		achievementButton.setIcon(new ImageIcon(MainWindow.class.getResource("/image/Reward_Btn.png")));
		achievementButton.setBounds(115, 410, 115, 130);
		achievementButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {	
				AchievementPage();
			}
		});
		contentPane.add(achievementButton);
		backButton.setIcon(new ImageIcon(MainWindow.class.getResource("/image/Back_Btn.png")));
		
		//Initial backButton in Menu
		backButton.setBounds(0, 625, 98, 95);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {	
				MenuPage();
			}
		});
		contentPane.add(backButton);
		
		//Initial leftButton in Menu
		leftButton.setIcon(new ImageIcon(MainWindow.class.getResource("/image/Left_Btn.png")));
		leftButton.setBounds(0, 150, 98, 95);
		contentPane.add(leftButton);
			
		//Initial rightButton in Menu
		rightButton.setIcon(new ImageIcon(MainWindow.class.getResource("/image/Right_Btn.png")));
		rightButton.setBounds(382, 150, 98, 95);
		contentPane.add(rightButton);


		
		//Initial settingButton in Menu
		settingButton.setIcon(new ImageIcon(MainWindow.class.getResource("/image/Setting_Btn.png")));
		settingButton.setBounds(0, 0, 50, 50);
		settingButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {	
				Setting();			
			}
		});
		contentPane.add(settingButton);		
		
		//Initial menuTitle label in Menu	
		menuTitle.setIcon(new ImageIcon(MainWindow.class.getResource("/image/MenuTitle.png")));
		menuTitle.setBounds(120, 60, 240, 180);
		menuTitle.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {	
				trolling_Fx.stop();
				trolling_Fx.setVolume(fxVolume);
				trolling_Fx.play();				
			}
		});
		
		//Initial the musicSlider, for setting the music sound volume
		musicSlider.setBounds(212, 373, 200, 26);
		musicSlider.setOpaque(false);
		musicSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				menuBGM.setVolume((double)musicSlider.getValue()/100.0);
				gameBGM.setVolume((double)musicSlider.getValue()/100.0);
			}
		});
		contentPane.add(musicSlider);
		
		//Initial the fxSlider, for setting the fx sound volume
		fxSlider.setBounds(212, 421, 200, 26);
		fxSlider.setOpaque(false);
		fxSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				fxVolume = (double)fxSlider.getValue()/100.0;
				skillButton.setVolume(fxVolume);
				startButton.setVolume(fxVolume);
				chararcterButton.setVolume(fxVolume);
				achievementButton.setVolume(fxVolume);
				backButton.setVolume(fxVolume);
				leftButton.setVolume(fxVolume);
				rightButton.setVolume(fxVolume);
				settingButton.setVolume(fxVolume);
			}
		});
		contentPane.add(fxSlider);
		
		//Initial menu title label
		contentPane.add(menuTitle);
		
		//Initial nothingIsHere page in Menu
		nothingIsHere.setIcon(new ImageIcon(MainWindow.class.getResource("/image/SorryForNothing.png")));
		nothingIsHere.setBounds(115, 320, 250, 400);
		contentPane.add(nothingIsHere);
		
		//Initial character preview picture in character page
		showCharacter.setBounds(140, 75, 200, 255);
		contentPane.add(showCharacter);

		//Initial back ground image
		backGround.setBounds(0, 0, 480, 720);
		contentPane.add(backGround);
		
	
		skillButton.setVisible(false);
		startButton.setVisible(false);
		chararcterButton.setVisible(false);
		achievementButton.setVisible(false);
		backButton.setVisible(false);
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		settingButton.setVisible(false);
		musicSlider.setVisible(false);
		fxSlider.setVisible(false);
		menuTitle.setVisible(false);
		nothingIsHere.setVisible(false);
		showCharacter.setVisible(false);
		backGround.setVisible(false);
		
	}
	
	//call to show the menu page
	public void MenuPage() {
		//start Menu BGM
		gameBGM.stop();
		menuBGM.setCycleCount(MediaPlayer.INDEFINITE);
		menuBGM.play();	
		
		//set the menu background
		backGround.setIcon(new ImageIcon(MainWindow.class.getResource("/image/MainBackground.png")));
		
		skillButton.setVisible(true);
		startButton.setVisible(true);
		chararcterButton.setVisible(true);
		achievementButton.setVisible(true);
		backButton.setVisible(false);
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		settingButton.setVisible(true);
		musicSlider.setVisible(false);
		fxSlider.setVisible(false);
		menuTitle.setVisible(true);
		nothingIsHere.setVisible(false);
		showCharacter.setVisible(false);
		backGround.setVisible(true);
		
		SaveData();
	}
	
	/**
	 * call to go to character page
	 */
	public void CharacterPage() {
		skillButton.setVisible(false);
		startButton.setVisible(false);
		chararcterButton.setVisible(false);
		achievementButton.setVisible(false);
		backButton.setVisible(true);
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		settingButton.setVisible(false);
		musicSlider.setVisible(false);
		fxSlider.setVisible(false);
		menuTitle.setVisible(false);
		nothingIsHere.setVisible(false);
		showCharacter.setVisible(true);
		backGround.setVisible(true);
		
			
	}
	
	//call to go to skill page
	public void SkillPage() {
		skillButton.setVisible(false);
		startButton.setVisible(false);
		chararcterButton.setVisible(false);
		achievementButton.setVisible(false);
		backButton.setVisible(true);
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		settingButton.setVisible(false);
		musicSlider.setVisible(false);
		fxSlider.setVisible(false);
		menuTitle.setVisible(false);
		nothingIsHere.setVisible(false);
		showCharacter.setVisible(false);
		backGround.setVisible(true);
		

	}
	
	/**
	 * call to go to achievement page
	 */
	public void AchievementPage() {
		skillButton.setVisible(false);
		startButton.setVisible(false);
		chararcterButton.setVisible(false);
		achievementButton.setVisible(false);
		backButton.setVisible(true);
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		settingButton.setVisible(false);
		musicSlider.setVisible(false);
		fxSlider.setVisible(false);
		menuTitle.setVisible(false);
		nothingIsHere.setVisible(true);
		showCharacter.setVisible(false);
		backGround.setVisible(false);	
	}
	
	/**
	 * call to go to setting page 
	 */
	public void Setting() {
		skillButton.setVisible(false);
		startButton.setVisible(false);
		chararcterButton.setVisible(false);
		achievementButton.setVisible(false);
		backButton.setVisible(true);
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		settingButton.setVisible(false);
		musicSlider.setVisible(true);
		fxSlider.setVisible(true);
		menuTitle.setVisible(false);
		nothingIsHere.setVisible(false);
		showCharacter.setVisible(false);
		backGround.setVisible(true);
		
		//set the slider to the previous value
		musicSlider.setValue((int)(menuBGM.getVolume()*100.0));
		fxSlider.setValue((int)(fxVolume*100.0));
	}
	
	/**
	 * call to load data
	 * @throws FileNotFoundException 
	 */
	private void LoadData() {
		try {
			FileInputStream is = new FileInputStream("./SaveData/savedata.data");
			System.out.println("file open ok");
			//is.read();
			System.out.println("file read ok");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * call to save data
	 * @throws FileNotFoundException 
	 */
	private void SaveData() {
		try {
			FileOutputStream os = new FileOutputStream("./SaveData/savedata.data");
			String st = "character:1/1 2/1 3/1\nskill:1/1 2/1 3/1 4/1 5/1\ncharacter_chosen:1\nskill_chosen:0/0/0\ngold:0\nmusic:1.0\nfx:1.0";
			System.out.println("file open ok");
			try {
				os.write(st.getBytes());
				os.close();
				System.out.println("file write ok");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * call to start the game
	 */
	public void StartGame() {
		menuBGM.stop();
		gameBGM.setCycleCount(MediaPlayer.INDEFINITE);
		gameBGM.play();
		
		backGround.setIcon(new ImageIcon(MainWindow.class.getResource("/image/InGameBackground.jpg")));
		
		skillButton.setVisible(false);
		startButton.setVisible(false);
		chararcterButton.setVisible(false);
		achievementButton.setVisible(false);
		backButton.setVisible(true);
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		settingButton.setVisible(false);
		menuTitle.setVisible(false);
		nothingIsHere.setVisible(false);
		showCharacter.setVisible(false);
		backGround.setVisible(true);
		

	}
	
	
	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setResizable(false);
		setTitle("FGO Card");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/image/Icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 485, 748);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.BLACK);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		InitialPage();
		MenuPage();
	}
}
