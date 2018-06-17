package cardtest;

import javax.swing.ImageIcon;
public class Wand2 extends Weapon2{
	public Wand2(int size){
		super("Wand");
		hp=size;
		setIcon(new ImageIcon(getClass().getResource("/image/Menu_ReduceCharge.png")));
	}
}
