package menu;

import menu.Button;
import character.*;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.function.Predicate;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.JSlider;
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
	private final JLabel settingText = new JLabel("");		//for setting page's title

	
	private final JSlider musicSlider = new JSlider();
	private final JSlider fxSlider = new JSlider();
	
	private static int charaterLV[] = new int[3];
	private static int skillLV[] = new int[5];
	private static int characterChoice;
	private static int skillChoice[] = new int[3];
	private static int goldAmount;
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
		
		//Load previous data
		LoadData();
		
		//Initial skillButton in Menu
		skillButton.setIcon(new ImageIcon(MainWindow.class.getResource("/image/Skill_Btn.png")));
		skillButton.setBounds(250, 255, 115, 155);
		skillButton.setVolume(fxVolume);
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
		startButton.setVolume(fxVolume);
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
		chararcterButton.setVolume(fxVolume);
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
		achievementButton.setVolume(fxVolume);
		achievementButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {	
				AchievementPage();
			}
		});
		contentPane.add(achievementButton);
		
		
		//Initial backButton in Menu
		backButton.setIcon(new ImageIcon(MainWindow.class.getResource("/image/Back_Btn.png")));
		backButton.setBounds(0, 625, 98, 95);
		backButton.setVolume(fxVolume);
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
		leftButton.setVolume(fxVolume);
		contentPane.add(leftButton);
			
		//Initial rightButton in Menu
		rightButton.setIcon(new ImageIcon(MainWindow.class.getResource("/image/Right_Btn.png")));
		rightButton.setBounds(382, 150, 98, 95);
		rightButton.setVolume(fxVolume);
		contentPane.add(rightButton);


		
		//Initial settingButton in Menu
		settingButton.setIcon(new ImageIcon(MainWindow.class.getResource("/image/Setting_Btn.png")));
		settingButton.setBounds(0, 0, 50, 50);
		settingButton.setVolume(fxVolume);
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
		musicSlider.setBounds(220, 360, 200, 26);
		musicSlider.setOpaque(false);
		musicSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				musicVolume = (double)musicSlider.getValue()/100.0;
				menuBGM.setVolume((double)musicSlider.getValue()/100.0);
				gameBGM.setVolume((double)musicSlider.getValue()/100.0);
				SaveData();
			}
		});
		contentPane.add(musicSlider);
		

		//Initial the fxSlider, for setting the fx sound volume
		fxSlider.setBounds(220, 420, 200, 26);
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
				SaveData();
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
		
		settingText.setIcon(new ImageIcon(MainWindow.class.getResource("/image/test.png")));
		settingText.setBounds(0, 0, 480, 720);
		contentPane.add(settingText);

		//Initial back ground image
		backGround.setBounds(0, 0, 480, 720);
		contentPane.add(backGround);
	
		//Initial the volume of BGM
		menuBGM.setVolume(musicVolume);
		gameBGM.setVolume(musicVolume);
	
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
		settingText.setVisible(false);
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
		settingText.setVisible(false);
		backGround.setVisible(true);
		

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
		settingText.setVisible(false);
		backGround.setVisible(true);
		
		switch (characterChoice) {
		case 1:
			showCharacter.setIcon(character.Caster.characterimage);
			break;
		case 2:
			showCharacter.setIcon(character.Assassin.characterimage);
			break;
		case 3:
			showCharacter.setIcon(character.Lancer.characterimage);
			break;
		}	
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
		settingText.setVisible(false);
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
		settingText.setVisible(false);
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
		settingText.setVisible(true);
		backGround.setVisible(true);
		
		//set the slider to the previous value
		musicSlider.setValue((int)(musicVolume*100.0));
		fxSlider.setValue((int)(fxVolume*100.0));
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
		settingText.setVisible(false);
		backGround.setVisible(true);
		

	}

	/**
	 * call to load data
	 * @throws FileNotFoundException 
	 */
	private void LoadData() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("./SaveData/savedata.data"));
			System.out.println("file open ok");
			
			String characterData = br.readLine().split("character:")[1];
			for(String i: characterData.split(" ")) {
				String data[] = i.split("/");
				charaterLV[Integer.parseInt(data[0])-1] = Integer.parseInt(data[1]);
			}
			
			String skillData = br.readLine().split("skill:")[1];
			for(String i: skillData.split(" ")) {
				String data[] = i.split("/");
				skillLV[Integer.parseInt(data[0])-1] = Integer.parseInt(data[1]);
			}
			
			String characterChosenData = br.readLine().split("character_chosen:")[1];
			characterChoice = Integer.parseInt(characterChosenData);
			
			String skillChosenData = br.readLine().split("skill_chosen:")[1];
			for(int i = 0; i < 3; i++) {
				String data[] = skillChosenData.split(" ");
				skillChoice[i] = Integer.parseInt(data[i]);
			}
			
			String goldData = br.readLine().split("gold:")[1];
			goldAmount = Integer.parseInt(goldData);
			
			String musicData = br.readLine().split("music:")[1];
			musicVolume = Double.parseDouble(musicData);
			
			String fxData = br.readLine().split("fx:")[1];
			fxVolume = Double.parseDouble(fxData);

			System.out.println("file read ok");
			br.close();
		} catch (IOException e) {
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
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("./SaveData/savedata.data")));

			System.out.println("file open ok");
			pw.println("character:1/" + charaterLV[0] + " 2/" + charaterLV[1] + " 3/" + charaterLV[2]);
			pw.println("skill:1/" + skillLV[0] + " 2/" + skillLV[1] + " 3/" + skillLV[2] + " 4/" + skillLV[3] + " 5/" + skillLV[4]);
			pw.println("character_chosen:" + characterChoice);
			pw.println("skill_chosen:" + skillChoice[0] + " " + skillChoice[1] + " " + skillChoice[2]);
			pw.println("gold:" + goldAmount);
			pw.println("music:" + musicVolume);
			pw.println("fx:" + fxVolume);
			System.out.println("file write ok");
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
