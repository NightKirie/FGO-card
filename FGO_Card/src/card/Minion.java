package card;

import javax.swing.ImageIcon;

public class Minion extends Monster {

	public Minion(String scientificName) {
		super(scientificName);
		name="minion";
		ImageIcon cardPicture=null;
		hp=50;
		cardPicture=new ImageIcon(this.getClass().getResource("/Images/Midboss.jpg"));
		setIcon(cardPicture);
	}

}
