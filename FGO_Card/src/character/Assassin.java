package character;
import menu.MainWindow;

import javax.swing.ImageIcon;


public class Assassin extends Character {
	public static int level = 1;
	public static int ID = 2;
	public static final ImageIcon characterimage = new ImageIcon(MainWindow.class.getResource("/Image/Assassin_Choice.png"));

	public Assassin() {
		super.maxHP = 5 + Assassin.level;
		super.HP = maxHP;
	}

	public static void levelup() {
		if (Assassin.level < 5) {
			++Assassin.level;
		}
	}

	public void interact(int itemID) {
	}
}
