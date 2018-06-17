package card;

import javax.swing.ImageIcon;

public class Boss extends Monster {

	public Boss(int size) {
		super("Boss");
		name="boss";
		ImageIcon cardPicture=null;
		cardPicture=new ImageIcon(this.getClass().getResource("/image/Icon.png"));
		setIcon(cardPicture);
		hp=size;
	}

}
