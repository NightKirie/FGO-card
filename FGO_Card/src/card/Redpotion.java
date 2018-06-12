package card;

import javax.swing.ImageIcon;

public class Redpotion extends Potion{
	public Redpotion(String scientificName,int size) {
		super(scientificName);
		ImageIcon cardPicture=null;
		hp=size;
		cardPicture=new ImageIcon(this.getClass().getResource("/Images/redpotion.jpg"));
		setIcon(cardPicture);
	}
	
	public void effect(Player input) {
		input.hp+=this.hp;
		if(input.hp>input.maxHP)
		{
			input.hp=input.maxHP;
		}
	}
}
