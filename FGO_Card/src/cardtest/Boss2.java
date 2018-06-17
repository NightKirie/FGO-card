package cardtest;

import javax.swing.ImageIcon;

public class Boss2 extends Monster2 {

	public Boss2(int size) {
		super("Boss");
		ImageIcon cardPicture=null;
		cardPicture=new ImageIcon(this.getClass().getResource("/image/RedPotion_Game.png"));
		setIcon(cardPicture);
		hp=size;
	}

}
