package cardtest;

import javax.swing.ImageIcon;

public class Minion2 extends Monster2 {

	public Minion2(int size) {
		super("minion");
		ImageIcon cardPicture=null;
		hp=size;
		cardPicture=new ImageIcon(this.getClass().getResource("/image/GreenPotion_Game.png"));
		setIcon(cardPicture);
	}

}
