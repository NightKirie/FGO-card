package character;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import menu.MainWindow;

public class ChooseCharacter {
	private static int chooseID;
	private static int characterLevel[] = new int[3];
	private static int characterMaxHP[] = new int[3];
	private static final ImageIcon[] characterPageImage = {new ImageIcon(MainWindow.class.getResource("/Image/Caster_Choice.png")),
													  new ImageIcon(MainWindow.class.getResource("/Image/Assassin_Choice.png")),
													  new ImageIcon(MainWindow.class.getResource("/Image/Lancer_Choice.png"))};
	private static final ImageIcon[] MenuImage = {new ImageIcon(MainWindow.class.getResource("/Image/Caster_Menu.png")),
													  new ImageIcon(MainWindow.class.getResource("/Image/Assassin_Menu.png")),	
													  new ImageIcon(MainWindow.class.getResource("/Image/Lancer_Menu.png"))};
	private static final int levelUpGold[] = {100, 200, 500, 1000};


	/** 
	 * set the chosen character's ID, for pressing confirm button
	 */
	public static void setChooseID(Icon img) {
		if(img.equals(characterPageImage[0]))
			chooseID = 1;
		else if(img.equals(characterPageImage[1]))
			chooseID = 2;
		else if(img.equals(characterPageImage[2]))
			chooseID = 3;
	}
	
	/**
	 * set the chosen character's ID, for initial
	 */
	public static void setChooseID(int ID) {
		chooseID = ID;
	}
	
	/**
	 * set the chosen character's level, for initial
	 */
	public static void setLevel(int ID, int level) {
		characterLevel[ID-1] = level;
		setMaxHP(ID);
	}
	
	public static void setMaxHP(int ID) {
		if(ID == 1)
			characterMaxHP[ID-1] = 7 + characterLevel[ID-1];
		else if(ID == 2)
			characterMaxHP[ID-1] = 5 + characterLevel[ID-1];
		else if(ID == 3)
			characterMaxHP[ID-1] = 9 + characterLevel[ID-1];
	}
	
	/** 
	 * get the chosen character's ID
	 */
	public static int getChosenID() {
		return chooseID;
	}
	
	/**
	 *get the chosen character's level 
	 */
	public static int getChosenLevel() {
		return characterLevel[chooseID-1];
	}
	
	/**
	 * get the chosen character's max HP
	 */
	public static int getChosenMaxHP() {
			return characterMaxHP[chooseID-1];
	}
	
	/**
	 * get the characters' level, for character page
	 */
	public static int getLevel(Icon img) {
		if(img.equals(characterPageImage[0]))
			return characterLevel[0];
		else if(img.equals(characterPageImage[1]))
			return characterLevel[1];
		else
			return characterLevel[2];
	}
	
	/**
	 * get the characters' level, for save data
	 */
	public static int getLevel(int ID) {
		return characterLevel[ID-1];
	}
	
	/**
	 * get the characters' maxHP, for character page
	 */
	public static int getMaxHP(Icon img) {
		if(img.equals(characterPageImage[0])) 
			return characterMaxHP[0];
		else if(img.equals(characterPageImage[1]))
			return characterMaxHP[1];
		else
			return characterMaxHP[2];
	}
	
	/**
	 * for press the right button to show the next character
	 */
	public static ImageIcon getNext(Icon img) {
		if(img.equals(characterPageImage[0]))
			return characterPageImage[1];
		else if(img.equals(characterPageImage[1]))
			return characterPageImage[2];
		else 
			return characterPageImage[0];	
	}
	
	/**
	 * for press the left button to show the next character
	 */
	public static ImageIcon getPrevious(Icon img) {
		if(img.equals(characterPageImage[0]))
			return characterPageImage[2];
		else if(img.equals(characterPageImage[1]))
			return characterPageImage[0];
		else 
			return characterPageImage[1];
	}
	
	/**
	 * for show the previous chosen character in character page
	 */
	public static ImageIcon getCharacterPageChosenCharater() {
		return characterPageImage[chooseID-1];
	}
	
	/**
	 * for show the previous chosen character in menu
	 */
	public static ImageIcon getMenuChosenCharacter() {
		return MenuImage[chooseID-1];
	}
	
	/**
	 * for press the levelup button to upgrade the character
	 */
	public static int levelUp(Icon img, int gold) {
		if(img.equals(characterPageImage[0]) && characterLevel[0] < 5) {
			if(levelUpGold[characterLevel[0]-1] <= gold) {
				characterLevel[0]++;
				characterMaxHP[0] = 7 + characterLevel[0];
				return gold-levelUpGold[characterLevel[0]-2];
			}
			else
				return gold;
		}
		else if(img.equals(characterPageImage[1]) && characterLevel[1] < 5) {
			if(levelUpGold[characterLevel[1]-1] <= gold) {
				characterLevel[1]++;
				characterMaxHP[1] = 5 + characterLevel[1];
				return gold-levelUpGold[characterLevel[1]-2];
			}
			else
				return gold;
		}
		else if(img.equals(characterPageImage[2]) && characterLevel[2] < 5) {
			if(levelUpGold[characterLevel[2]-1] <= gold) {
				characterLevel[2]++;
				characterMaxHP[2] = 9 + characterLevel[2];
				return gold-levelUpGold[characterLevel[2]-2];
			}
			else
				return gold;
		}
		else 
			return gold;		
	}
}
