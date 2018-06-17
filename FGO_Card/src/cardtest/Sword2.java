package cardtest;

import javax.swing.ImageIcon;
public class Sword2 extends Weapon2{
	public Sword2(int size){
		super("Sword");
		hp=size;
		setIcon(new ImageIcon(getClass().getResource("/image/Menu_SumonSword.png")));
	}
}
