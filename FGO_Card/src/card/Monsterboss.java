package card;

import javax.swing.ImageIcon;

public class Monsterboss extends Monster {

	public Monsterboss(String scientificName) {
		super(scientificName);
		name="boss";
		ImageIcon cardPicture=null;
		cardPicture=new ImageIcon(this.getClass().getResource("/Images/Boss.jpg"));
		setIcon(cardPicture);
		hp=100;
	}

}
