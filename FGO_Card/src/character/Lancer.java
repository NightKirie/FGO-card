package character;
import menu.MainWindow;
import javax.swing.ImageIcon;

import Menu.MainWindow;

public class Lancer extends Character {
	public static int level = 1;
	public static int ID = 3;
	public static final ImageIcon characterimage = new ImageIcon(MainWindow.class.getResource("/Image/Lancer_Choice.png"));


	public Lancer() {
		super.maxHP = 9 + Lancer.level;
		super.HP = maxHP;
	}

	public static void levelup() {
		if (Lancer.level < 5) {
			++Lancer.level;
		}
	}

	public void interact(int itemID) {
		// TODO Auto-generated method stub

	}
}
