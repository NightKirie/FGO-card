package card;

import javax.swing.ImageIcon;

public class Minion extends Monster {

	public Minion(int size) {
		super("minion");
		name="minion";
		ImageIcon cardPicture=null;
		hp=size;
		cardPicture=new ImageIcon(this.getClass().getResource("/Images/Midboss.jpg"));
		setIcon(cardPicture);
	}

}
