package cardtest;

import javax.swing.ImageIcon;

public class RedPotion2 extends Potion2{
	public RedPotion2(int size) {
		super("RedPotion");
		ImageIcon cardPicture=null;
		hp=size;
		cardPicture=new ImageIcon(this.getClass().getResource("/image/RedPotion_Game.png"));
		setIcon(cardPicture);
	}
	
	public void effect(Player2 input) {
		input.hp+=this.hp;
		if(input.hp>input.maxHP)
		{
			input.hp=input.maxHP;
		}
	}
}
