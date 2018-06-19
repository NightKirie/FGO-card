package card;

import javax.swing.ImageIcon;
public class Wand extends Weapon{
	public Wand(int size){
		super("Wand");
		hp=size;
		setIcon(new ImageIcon(getClass().getResource("/image/Wand_Battle.jpg")));
		updateCard();
	}
}
