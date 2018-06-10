package character;
import menu.MainWindow;

import javax.swing.ImageIcon;


public class Caster extends Character {
	public static int level = 1;
	public static int ID = 1;
	public static final ImageIcon characterimage = new ImageIcon(MainWindow.class.getResource("/Image/Caster_Choice.png"));
	
	public Caster() {
		super.maxHP = 7 + Caster.level;
		super.HP = maxHP;
	}

	public static void levelup() {
		if (Caster.level < 5) {
			++Caster.level;
		}
	}

	public void interact(int itemID) {

	}
}
