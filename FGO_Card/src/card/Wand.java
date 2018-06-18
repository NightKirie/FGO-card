package card;

import javax.swing.ImageIcon;
public class Wand extends Weapon{
	public Wand(int size){
		super("Wand");
		hp=size;
		hpShow.setText(Integer.toString(hp));
		setIcon(new ImageIcon(getClass().getResource("/image/Wand_Battle.jpg")));
	}
}
