package card;

import javax.swing.ImageIcon;
public class Sword extends Weapon{
	public Sword(int size){
		super("Sword");
		hp=size;
		setIcon(new ImageIcon(getClass().getResource("/image/Sword_Battle.jpg")));
		updateCard();
	}
}
