package card;

import javax.swing.ImageIcon;

public class Boss extends Monster {

	public Boss(int size) {
		super("Boss");
		name="boss";
		ImageIcon cardPicture=new ImageIcon(this.getClass().getResource("/image/Boss_Battle.jpg"));
		setIcon(cardPicture);
		hp=size;
		updateCard();
	}
}
