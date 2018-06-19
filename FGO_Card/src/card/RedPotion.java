package card;

import java.awt.Image;

import javax.swing.ImageIcon;

public class RedPotion extends Potion{
	public RedPotion(int size) {
		super("RedPotion");
		ImageIcon icon=new ImageIcon(this.getClass().getResource("/image/RedPotion_Battle.jpg"));
		Image image = icon.getImage();
	    image = image.getScaledInstance(130,200, Image.SCALE_SMOOTH);
	    icon.setImage(image);
		setIcon(icon);
		hp=size;
		updateCard();
	}
	
	public void effect(Player input) {
		input.hp+=this.hp;
		if(input.hp>input.maxHP)
		{
			input.hp=input.maxHP;
		}
	}
}
