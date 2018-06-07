package Menu;

import Menu.Button;
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
	
	private final MediaPlayer menuBGM = new MediaPlayer(new Media(getClass().getResource("/Audio/Menu_BGM.mp3").toString()));		//for menu BGM
	private final MediaPlayer gameBGM = new MediaPlayer(new Media(getClass().getResource("/Audio/InGame_BGM.mp3").toString()));		//for in game BGM
	private final MediaPlayer trolling_Fx = new MediaPlayer(new Media(getClass().getResource("/Audio/Trolling_Sound.mp3").toString()));	//for LOLs
	
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
	
	private static double fxVolumn;
	

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
		//Add skillButton in Menu
		skillButton.setIcon(new ImageIcon(MainWindow.class.getResource("/Image/Skill_Btn.png")));
		skillButton.setBounds(250, 255, 115, 155);
		skillButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {	
				SkillPage();
			}
		});	
		contentPane.add(skillButton);
		
		//Add start Button in Menu
		startButton.setIcon(new ImageIcon(MainWindow.class.getResource("/Image/Start_Btn.png")));
		startButton.setBounds(250, 410, 115, 130);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {		
				
				StartGame();
			}
		});
		contentPane.add(startButton);
		
		//Add characterButton in Menu
		chararcterButton.setIcon(new ImageIcon(MainWindow.class.getResource("/Image/Character_Btn.png")));
		chararcterButton.setBounds(115, 255, 115, 155);
		chararcterButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {	
				CharacterPage();
			}
		});
		contentPane.add(chararcterButton);

		//Add achievementButton in Menu
		achievementButton.setIcon(new ImageIcon(MainWindow.class.getResource("/Image/Reward_Btn.png")));
		achievementButton.setBounds(115, 410, 115, 130);
		achievementButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {	
				AchievementPage();
			}
		});
		contentPane.add(achievementButton);
		
		//Add backButton in Menu
		//backButton.setIcon(new ImageIcon(MainWindow.class.getResource("/Image/Back_Btn.png")));
		backButton.setBounds(0, 625, 98, 95);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {	
				MenuPage();
			}
		});
		contentPane.add(backButton);
		
		//Add leftButton in Menu
		leftButton.setIcon(new ImageIcon(MainWindow.class.getResource("/Image/Left_Btn.png")));
		leftButton.setBounds(0, 150, 98, 95);
		contentPane.add(leftButton);
			
		//Add rightButton in Menu
		rightButton.setIcon(new ImageIcon(MainWindow.class.getResource("/Image/Right_Btn.png")));
		rightButton.setBounds(382, 150, 98, 95);
		contentPane.add(rightButton);
		
		//Add settingButton in Menu
		settingButton.setBounds(0, 0, 50, 50);
		settingButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {	
				Setting();
			}
		});
		contentPane.add(settingButton);		
		
		//Add menuTitle in Menu	
		menuTitle.setIcon(new ImageIcon(MainWindow.class.getResource("/Image/MenuTitle.png")));
		menuTitle.setBounds(120, 60, 240, 180);
		menuTitle.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {	
				trolling_Fx.stop();
				trolling_Fx.setVolume(fxVolumn);
				trolling_Fx.play();				
			}
		});
		
		musicSlider.setBounds(212, 373, 200, 26);
		musicSlider.setOpaque(false);
		musicSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				menuBGM.setVolume((double)musicSlider.getValue()/100.0);
				gameBGM.setVolume((double)musicSlider.getValue()/100.0);
			}
		});
		contentPane.add(musicSlider);
		

		fxSlider.setBounds(212, 421, 200, 26);
		fxSlider.setOpaque(false);
		fxSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				fxVolumn = (double)fxSlider.getValue()/100.0;
			}
		});
		contentPane.add(fxSlider);
		
		
		contentPane.add(menuTitle);
		
		//Add nothingIsHere in Menu
		nothingIsHere.setIcon(new ImageIcon(MainWindow.class.getResource("/Image/SorryForNothing.png")));
		nothingIsHere.setBounds(115, 320, 250, 400);
		contentPane.add(nothingIsHere);
		
		//Add character preview picture in character page
		showCharacter.setBounds(140, 75, 200, 255);
		contentPane.add(showCharacter);

		//Add back ground image
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
	
	//for show the menu
	public void MenuPage() {
		//start Menu BGM
		gameBGM.stop();
		menuBGM.setCycleCount(MediaPlayer.INDEFINITE);
		menuBGM.play();	
		
		backGround.setIcon(new ImageIcon(MainWindow.class.getResource("/Image/MainBackground.png")));
		
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
	}
	
	//Go to select character
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
	
	//for select the skill
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
	
	//for check the achievement
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
	
	//for set audio 
	public void Setting() {
		skillButton.setVisible(false);
		startButton.setVisible(false);
		chararcterButton.setVisible(false);
		achievementButton.setVisible(false);
		backButton.setVisible(true);
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		settingButton.setVisible(true);
		musicSlider.setVisible(true);
		fxSlider.setVisible(true);
		menuTitle.setVisible(false);
		nothingIsHere.setVisible(false);
		showCharacter.setVisible(false);
		backGround.setVisible(true);
		
		musicSlider.setValue((int)(menuBGM.getVolume()*100.0));
		fxSlider.setValue((int)(fxVolumn*100.0));
	}
	//for start the game
	public void StartGame() {
		menuBGM.stop();
		gameBGM.setCycleCount(MediaPlayer.INDEFINITE);
		gameBGM.play();
		
		backGround.setIcon(new ImageIcon(MainWindow.class.getResource("/Image/InGameBackground.jpg")));
		
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/Image/Icon.png")));
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
