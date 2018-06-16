package menu;

import menu.Button;
import skill.ChooseSkill;
import character.*;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private final Button backButton = 	new Button();			//for any page to go back to the menu
	private final Button leftButton = new Button();			//for character page to preview next character
	private final Button rightButton = new Button();		//for character page to preview previous character
	private final Button settingButton = new Button();		//for go to setting
	private final Button confirmButton = new Button();
	private final Button upgradeButton = new Button();
	
	private final SkillButton[] showSkill = {new SkillButton(), new SkillButton(), new SkillButton(), new SkillButton(), new SkillButton()};
	
	private final JLabel menuTitle = new JLabel("");		//for menu title picture
	private final JLabel backGround = new JLabel("");		//for menu background picture
	private final JLabel nothingIsHere = new JLabel("");	//for the page is not done
	private final JLabel showCharacter = new JLabel("");	//for character page to show the character
	private final JLabel settingText = new JLabel("");		//for setting page's title
	private final JLabel goldAmountIcon = new JLabel("");	//for show the gold amount icon
	private final JLabel chosenCharacterMenu = new JLabel("");	//for show the chosen character's image in menu
	private final JLabel showSkillDetail = new JLabel("");	//for show the hover on skill's detail
	private final JLabel[] chosenSkillMenu = {new JLabel(""), new JLabel(""), new JLabel("")};
	private final JLabel[] chosenSkillBattle = {new JLabel(""), new JLabel(""), new JLabel("")};
	
	private final JTextField goldAmountNumber = new RoundedTextField(15);	//for show the gold	amount player has
	private final JTextField goldBattleNumber = new RoundedTextField(15);	//for show the gold player get in battle
	
	private final JTextField levelText = new RoundedTextField(15);		//for show the level of character or skill 
	private final RoundedTextField upgradeText = new RoundedTextField(15);		//for show the upgrade needed of character or skill

	private final JSlider musicSlider = new JSlider();
	private final JSlider fxSlider = new JSlider();
	
	private static int goldAmount;
	private static double musicVolume;
	private static double fxVolume;
	private static String levelString[] = {"LV.1", "LV.2", "LV.3", "LV.4", "LV.MAX"};
	private static String upgradeString[] = {"100Gold->LV.2", "200Gold->LV.3", "500Gold->LV.4", "1000Gold->LV.MAX", "No Upgrade"};
	private static Icon focusOnSkill;
	


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
		
		//Set Button FX volume
		Button.setVolume(fxVolume);
		SkillButton.setVolume(fxVolume);
		
		//Initial chosen skill show in Battle
		chosenSkillBattle[0].setBounds(10, 10, 55, 55);
		chosenSkillBattle[1].setBounds(80, 10, 55, 55);
		chosenSkillBattle[2].setBounds(150, 10, 55, 55);
		for(int i = 0; i < chosenSkillBattle.length; ++i) {
			contentPane.add(chosenSkillBattle[i]);
		}
		
		//Initial chosen skill show in Menu, MUST ABOVE THE SKILL BUTTON!!!
		chosenSkillMenu[0].setBounds(250, 255, 55, 55);
		chosenSkillMenu[1].setBounds(310, 255, 55, 55);
		chosenSkillMenu[2].setBounds(250, 315, 55, 55);
		for(int i = 0; i < chosenSkillMenu.length; ++i) {
			chosenSkillMenu[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			contentPane.add(chosenSkillMenu[i]);
		}
		skillButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
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
		
		//Initial chosen character show in Menu, MUST ABOVE THE CHARACTER BUTTON!!!
		chosenCharacterMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		chosenCharacterMenu.setBounds(115, 255, 115, 125);		
		contentPane.add(chosenCharacterMenu);
		
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
		
		
		//Initial backButton in Menu
		backButton.setIcon(new ImageIcon(MainWindow.class.getResource("/image/Back_Btn.png")));
		backButton.setBounds(0, 621, 97, 99);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {	
				MenuPage();
			}
		});
		contentPane.add(backButton);
		
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
		
		//Initial leftButton in character page
		leftButton.setIcon(new ImageIcon(MainWindow.class.getResource("/image/Left_Btn.png")));
		leftButton.setBounds(0, 150, 98, 95);
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {	
				//show previous character
				showCharacter.setIcon(ChooseCharacter.getPrevious(showCharacter.getIcon()));
				//set the level to previous character's level
				levelText.setText(levelString[ChooseCharacter.getLevel(showCharacter.getIcon())-1]);
				//set the upgrade detail of previous character
				upgradeText.setText(upgradeString[ChooseCharacter.getLevel(showCharacter.getIcon())-1]);
				//if the level of previous character is max, set the upgrade button disable
				if(ChooseCharacter.getLevel(showCharacter.getIcon()) == 5)
					upgradeButton.setEnabled(false);
				else
					upgradeButton.setEnabled(true);
			}
		});
		contentPane.add(leftButton);
			
		//Initial rightButton in character page
		rightButton.setIcon(new ImageIcon(MainWindow.class.getResource("/image/Right_Btn.png")));
		rightButton.setBounds(382, 150, 98, 95);
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {	
				//show next character
				showCharacter.setIcon(ChooseCharacter.getNext(showCharacter.getIcon()));
				//set the level to next character's level
				levelText.setText(levelString[ChooseCharacter.getLevel(showCharacter.getIcon())-1]);
				//set the upgrade detail of next character
				upgradeText.setText(upgradeString[ChooseCharacter.getLevel(showCharacter.getIcon())-1]);
				//if the level of next character is max, set the upgrade button disable
				if(ChooseCharacter.getLevel(showCharacter.getIcon()) == 5)
					upgradeButton.setEnabled(false);
				else
					upgradeButton.setEnabled(true);
			}
		});
		contentPane.add(rightButton);
		confirmButton.setFocusable(false);
		
		//Initial confirmButton in character page & skill page 
		confirmButton.setIcon(new ImageIcon(MainWindow.class.getResource("/image/Confirm_Btn.png")));
		confirmButton.setBounds(383, 621, 97, 99);
		confirmButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {	
				//when in the character page
				if(showCharacter.isVisible()) {
					//store the chosen character's id
					ChooseCharacter.setChooseID(showCharacter.getIcon());
					SaveData();
				}
				//when in the skill page
				else {
					//store the chosen skills' id
					int chosenOrder = 0;
					//loop through five skill see if chosen
					for(int i = 0; i < showSkill.length; ++i) {
						if(showSkill[i].getChosen()) {
							ChooseSkill.setChooseSkill(i+1, chosenOrder);
							++chosenOrder;
						}
						System.out.println(showSkill[i].getChosen());
					}
					//if not chosen set to 0
					for(int i = 2; i >= chosenOrder; --i)
						ChooseSkill.setChooseSkill(0, chosenOrder);
					SaveData();
				}
			}
		});
		contentPane.add(confirmButton);
		upgradeButton.setFocusable(false);
		
		//Initial upgradeButton in character page & skill page
		upgradeButton.setIcon(new ImageIcon(MainWindow.class.getResource("/image/Upgrade_Btn.png")));
		upgradeButton.setBounds(193, 621, 97, 99);
		upgradeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {	
				//when in the character page
				if(showCharacter.isVisible()) {
					//reduce the gold amount after upgrade
					goldAmount = ChooseCharacter.levelUp(showCharacter.getIcon(), goldAmount);
					//reset the level of the character after upgrade
					levelText.setText(levelString[ChooseCharacter.getLevel(showCharacter.getIcon())-1]);
					//reset the upgrade detail of character after upgrade
					upgradeText.setText(upgradeString[ChooseCharacter.getLevel(showCharacter.getIcon())-1]);
					//if character's level is max, disable the upgrade button
					if(ChooseCharacter.getLevel(showCharacter.getIcon()) == 5)
						upgradeButton.setEnabled(false);
					else
						upgradeButton.setEnabled(true);
					//reset the gold amount
					goldAmountNumber.setText(Integer.toString(goldAmount));
					SaveData();
				}
				//when in the skill page
				else {
					//reduce the gold amount after upgrade
					goldAmount = ChooseSkill.levelUp(focusOnSkill, goldAmount);
					//reset the level of the character after upgrade
					levelText.setText(levelString[ChooseSkill.getSkillLevel(focusOnSkill)-1]);
					//reset the upgrade detail of characer after upgrade
					upgradeText.setText(upgradeString[ChooseSkill.getSkillLevel(focusOnSkill)-1]);
					//if skill's level is max, disable the upgrade button
					if(ChooseSkill.getSkillLevel(focusOnSkill) == 5) 
						upgradeButton.setEnabled(false);
					else
						upgradeButton.setEnabled(true);
					//reset the gold amount
					goldAmountNumber.setText(Integer.toString(goldAmount));
					SaveData();
				}
			}
		});
		contentPane.add(upgradeButton);
		
		//Initial the skills in skill page
		for(int i = 0; i < showSkill.length; ++i) {
			final int ID = i+1;		//for inner class can eat local variable
			showSkill[i].setBounds(40+i*80, 100, 80, 80);
			showSkill[i].setIcon(ChooseSkill.getSkillImage(ID));				
			showSkill[i].addFocusListener(new FocusAdapter() {
				//if the skill isn't be chosen, single click to show detail
				public void focusGained(FocusEvent e) {
					showSkillDetail.setIcon(ChooseSkill.getSkillDetail(ID));
					levelText.setText(levelString[ChooseSkill.getSkillLevel(ID)-1]);
					levelText.setVisible(true);
					upgradeText.setText(upgradeString[ChooseSkill.getSkillLevel(ID)-1]);
					upgradeText.setVisible(true);			
					showSkillDetail.setVisible(true);
					//get the skill that is focus
					focusOnSkill = showSkill[ID-1].getIcon();
					//if the selected skill's level is max, disable the upgrade button
					if(ChooseSkill.getSkillLevel(focusOnSkill) == 5) 
						upgradeButton.setEnabled(false);
					else
						upgradeButton.setEnabled(true);
				}
				//if the skill is be chosen, single click other skill, reset this skill 
				public void focusLost(FocusEvent e) {
					levelText.setVisible(false);
					upgradeText.setVisible(false);
					showSkillDetail.setVisible(false);
				}
			});
			contentPane.add(showSkill[i]);
		}
		
		//Initial the chosen skill be highlighted
		for(int i = 0; i < 3; ++i) {
			if(ChooseSkill.getChooseID(i) != 0) {
				showSkill[ChooseSkill.getChooseID(i)-1].setChosen();
			}
		}
		
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
				Button.setVolume(fxVolume);
				SaveData();
			}
		});
		contentPane.add(fxSlider);
		
		//Initial gold amount icon
		goldAmountIcon.setIcon(new ImageIcon(MainWindow.class.getResource("/image/Gold_Amount.png")));
		goldAmountIcon.setBounds(297, 0, 50, 50);		
		contentPane.add(goldAmountIcon);
		
		//Initial gold amount number
		goldAmountNumber.setBounds(357, 0, 123, 50);
		contentPane.add(goldAmountNumber);
		
		//Initial gold battle number
		goldBattleNumber.setBounds(357, 0, 123, 50);
		contentPane.add(goldBattleNumber);
		
		//Initial character or skill level text
		levelText.setBounds(0, 0, 143, 50);
		contentPane.add(levelText);
		upgradeText.setForeground(Color.LIGHT_GRAY);

		
		//Initial character or skill upgrade text
		upgradeText.setHorizontalAlignment(SwingConstants.CENTER);
		upgradeText.setBounds(85, 484, 327, 50);
		upgradeText.setFont(new Font("MV Boli", Font.PLAIN, 20));
		contentPane.add(upgradeText);
		
		//Initial menu title label
		contentPane.add(menuTitle);
		
		//Initial nothingIsHere page in Menu
		nothingIsHere.setIcon(new ImageIcon(MainWindow.class.getResource("/image/SorryForNothing.png")));
		nothingIsHere.setBounds(115, 320, 250, 400);
		contentPane.add(nothingIsHere);
		
		//Initial character preview picture in character page
		showCharacter.setBounds(0, 0, 480, 720);
		contentPane.add(showCharacter);
		
		//Initial skill's detail in skill page
		showSkillDetail.setBounds(0, 0, 480, 720);
		contentPane.add(showSkillDetail);
		
		//Initial the settingText in setting page
		settingText.setIcon(new ImageIcon(MainWindow.class.getResource("/image/Setting_Text.png")));
		settingText.setBounds(0, 0, 480, 720);
		contentPane.add(settingText);

		//Initial back ground image
		backGround.setBounds(0, 0, 480, 720);
		contentPane.add(backGround);
	
		//Initial the volume of BGM
		menuBGM.setVolume(musicVolume);
		gameBGM.setVolume(musicVolume);
	
		for(int i = 0; i < chosenSkillMenu.length; ++i)
			chosenSkillMenu[i].setVisible(false);
		skillButton.setVisible(false);
		startButton.setVisible(false);
		chosenCharacterMenu.setVisible(false);
		chararcterButton.setVisible(false);
		achievementButton.setVisible(false);
		backButton.setVisible(false);
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		settingButton.setVisible(false);
		confirmButton.setVisible(false);
		upgradeButton.setVisible(false);
		for(int i = 0; i < showSkill.length; ++i)
			showSkill[i].setVisible(false);
		musicSlider.setVisible(false);
		fxSlider.setVisible(false);
		goldAmountIcon.setVisible(false);
		goldAmountNumber.setVisible(false);
		levelText.setVisible(false);
		upgradeText.setVisible(false);
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
		//set the gold amount
		goldAmountNumber.setText(Integer.toString(goldAmount));
		//set the chosen character's image
		chosenCharacterMenu.setIcon(ChooseCharacter.getMenuChosenCharacter());
		//set the chosen skills' image
		for(int i = 0; i < chosenSkillMenu.length; ++i) {
			if(ChooseSkill.getChooseID(i) != 0)
				chosenSkillMenu[i].setIcon(ChooseSkill.getSkillMenu(ChooseSkill.getChooseID(i)));
			else
				chosenSkillMenu[i].setIcon(null);
		}

		for(int i = 0; i < chosenSkillMenu.length; ++i)
			chosenSkillMenu[i].setVisible(true);
		for(int i = 0; i < chosenSkillBattle.length; ++i)
			chosenSkillBattle[i].setVisible(false);
		skillButton.setVisible(true);
		startButton.setVisible(true);
		chosenCharacterMenu.setVisible(true);
		chararcterButton.setVisible(true);
		achievementButton.setVisible(true);
		backButton.setVisible(false);
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		settingButton.setVisible(true);
		confirmButton.setVisible(false);
		upgradeButton.setVisible(false);
		for(int i = 0; i < showSkill.length; ++i)
			showSkill[i].setVisible(false);
		musicSlider.setVisible(false);
		fxSlider.setVisible(false);
		goldAmountIcon.setVisible(true);
		goldAmountNumber.setVisible(true);
		goldBattleNumber.setVisible(false);
		levelText.setVisible(false);
		upgradeText.setVisible(false);
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
		
		for(int i = 0; i < chosenSkillMenu.length; ++i)
			chosenSkillMenu[i].setVisible(false);
		for(int i = 0; i < chosenSkillBattle.length; ++i)
			chosenSkillBattle[i].setVisible(false);
		skillButton.setVisible(false);
		startButton.setVisible(false);
		chosenCharacterMenu.setVisible(false);
		chararcterButton.setVisible(false);
		achievementButton.setVisible(false);
		backButton.setVisible(true);
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		settingButton.setVisible(false);
		confirmButton.setVisible(true);
		upgradeButton.setVisible(true);
		for(int i = 0; i < showSkill.length; ++i)
			showSkill[i].setVisible(false);
		musicSlider.setVisible(false);
		fxSlider.setVisible(false);
		goldAmountIcon.setVisible(true);
		goldAmountNumber.setVisible(true);
		goldBattleNumber.setVisible(false);
		levelText.setVisible(true);
		upgradeText.setVisible(true);
		menuTitle.setVisible(false);
		nothingIsHere.setVisible(false);
		showCharacter.setVisible(true);
		settingText.setVisible(false);
		backGround.setVisible(true);
		
		//show the previous chosen character
		showCharacter.setIcon(ChooseCharacter.getCharacterPageChosenCharater());
		
		//set the upgrade button unable if the character's level is max
		if(ChooseCharacter.getLevel(showCharacter.getIcon()) == 5)
			upgradeButton.setEnabled(false);
		else
			upgradeButton.setEnabled(true);
		
		//show the previous chosen character's level
		levelText.setText(levelString[ChooseCharacter.getChosenLevel()-1]);
		
		//show the previous chosen character's upgrade needed
		upgradeText.setText(upgradeString[ChooseCharacter.getChosenLevel()-1]);
	}
	
	//call to go to skill page
	public void SkillPage() {
		for(int i = 0; i < chosenSkillMenu.length; ++i)
			chosenSkillMenu[i].setVisible(false);
		for(int i = 0; i < chosenSkillBattle.length; ++i)
			chosenSkillBattle[i].setVisible(false);
		skillButton.setVisible(false);
		startButton.setVisible(false);
		chosenCharacterMenu.setVisible(false);
		chararcterButton.setVisible(false);
		achievementButton.setVisible(false);
		backButton.setVisible(true);
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		settingButton.setVisible(false);
		confirmButton.setVisible(true);
		upgradeButton.setVisible(true);
		for(int i = 0; i < showSkill.length; ++i)
			showSkill[i].setVisible(true);
		musicSlider.setVisible(false);
		fxSlider.setVisible(false);
		menuTitle.setVisible(false);
		goldAmountIcon.setVisible(true);
		goldAmountNumber.setVisible(true);
		goldBattleNumber.setVisible(false);
		levelText.setVisible(false);
		upgradeText.setVisible(false);
		nothingIsHere.setVisible(false);
		showCharacter.setVisible(false);
		settingText.setVisible(false);
		backGround.setVisible(true);	
	}
	
	/**
	 * call to go to achievement page
	 */
	public void AchievementPage() {
		for(int i = 0; i < chosenSkillMenu.length; ++i)
			chosenSkillMenu[i].setVisible(false);
		for(int i = 0; i < chosenSkillBattle.length; ++i)
			chosenSkillBattle[i].setVisible(false);
		skillButton.setVisible(false);
		startButton.setVisible(false);
		chosenCharacterMenu.setVisible(false);
		chararcterButton.setVisible(false);
		achievementButton.setVisible(false);
		backButton.setVisible(true);
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		settingButton.setVisible(false);
		confirmButton.setVisible(false);
		upgradeButton.setVisible(false);
		for(int i = 0; i < showSkill.length; ++i)
			showSkill[i].setVisible(false);
		musicSlider.setVisible(false);
		fxSlider.setVisible(false);
		goldAmountIcon.setVisible(true);
		goldAmountNumber.setVisible(true);
		goldBattleNumber.setVisible(false);
		levelText.setVisible(false);
		upgradeText.setVisible(false);
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
		for(int i = 0; i < chosenSkillMenu.length; ++i)
			chosenSkillMenu[i].setVisible(false);
		for(int i = 0; i < chosenSkillBattle.length; ++i)
			chosenSkillBattle[i].setVisible(false);
		skillButton.setVisible(false);
		startButton.setVisible(false);
		chosenCharacterMenu.setVisible(false);
		chararcterButton.setVisible(false);
		achievementButton.setVisible(false);
		backButton.setVisible(true);
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		settingButton.setVisible(false);
		confirmButton.setVisible(false);
		upgradeButton.setVisible(false);
		for(int i = 0; i < showSkill.length; ++i)
			showSkill[i].setVisible(false);
		musicSlider.setVisible(true);
		fxSlider.setVisible(true);
		goldAmountIcon.setVisible(false);
		goldAmountNumber.setVisible(false);
		goldBattleNumber.setVisible(false);
		levelText.setVisible(false);
		upgradeText.setVisible(false);
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
		
		for(int i = 0; i < chosenSkillMenu.length; ++i)
			chosenSkillMenu[i].setVisible(false);
		for(int i = 0; i < chosenSkillBattle.length; ++i) {
			if(ChooseSkill.getChooseID(i) != 0)
				chosenSkillBattle[i].setIcon(ChooseSkill.getSkillMenu(ChooseSkill.getChooseID(i)));
			else
				chosenSkillBattle[i].setIcon(null);
		}
		for(int i = 0; i < chosenSkillBattle.length; ++i)
			chosenSkillBattle[i].setVisible(true);
		skillButton.setVisible(false);
		startButton.setVisible(false);
		chosenCharacterMenu.setVisible(false);
		chararcterButton.setVisible(false);
		achievementButton.setVisible(false);
		backButton.setVisible(true);
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		settingButton.setVisible(false);
		confirmButton.setVisible(false);
		upgradeButton.setVisible(false);
		for(int i = 0; i < showSkill.length; ++i)
			showSkill[i].setVisible(false);
		musicSlider.setVisible(false);
		fxSlider.setVisible(false);
		goldAmountIcon.setVisible(true);
		goldAmountNumber.setVisible(false);
		goldBattleNumber.setVisible(true);
		levelText.setVisible(false);
		upgradeText.setVisible(false);
		menuTitle.setVisible(false);
		nothingIsHere.setVisible(false);
		showCharacter.setVisible(false);
		settingText.setVisible(false);
		backGround.setVisible(true);
		
		goldBattleNumber.setText("0");
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
				ChooseCharacter.setLevel(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
			}
			
			String skillData = br.readLine().split("skill:")[1];
			for(String i: skillData.split(" ")) {
				String data[] = i.split("/");
				ChooseSkill.setLevel(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
			}
			
			String characterChosenData = br.readLine().split("character_chosen:")[1];
			ChooseCharacter.setChooseID(Integer.parseInt(characterChosenData));
			
			String skillChosenData = br.readLine().split("skill_chosen:")[1];
			for(int i = 0; i < 3; i++) {
				String data[] = skillChosenData.split(" ");
				ChooseSkill.setChooseSkill(Integer.parseInt(data[i]), i);
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
			pw.println("character:1/" + ChooseCharacter.getLevel(1) + " 2/" + ChooseCharacter.getLevel(2) + " 3/" + ChooseCharacter.getLevel(3));
			pw.println("skill:1/" + ChooseSkill.getSkillLevel(1) + " 2/" + ChooseSkill.getSkillLevel(2) + " 3/" + ChooseSkill.getSkillLevel(3) + " 4/" + ChooseSkill.getSkillLevel(4) + " 5/" + ChooseSkill.getSkillLevel(5));
			pw.println("character_chosen:" + ChooseCharacter.getChosenID());
			pw.println("skill_chosen:" + ChooseSkill.getChooseID(0) + " " +  ChooseSkill.getChooseID(1) + " " +  ChooseSkill.getChooseID(2));
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
