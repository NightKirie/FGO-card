package card;

import javax.swing.ImageIcon;

public class RedPotion extends Potion{
	public RedPotion(int size) {
		super("RedPotion");
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
