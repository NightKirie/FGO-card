package cardtest;

import javax.swing.ImageIcon;

import menu.MainWindow;

public class Object2 extends Card2 {

	public Object2(String scientificName) {
		super(scientificName);
		setIcon(new ImageIcon(MainWindow.class.getResource("/image/Assassin_Menu.png")));
	}
	public int hp=0;

}
