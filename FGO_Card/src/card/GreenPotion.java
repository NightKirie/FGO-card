package card;

import java.awt.Image;


import javax.swing.ImageIcon;
public class GreenPotion extends Potion{
	public GreenPotion(int size) {
		super("GreenPotion");
		ImageIcon icon=new ImageIcon(this.getClass().getResource("/image/GreenPotion_Battle.jpg"));
		Image image = icon.getImage();
	    image = image.getScaledInstance(130,200, Image.SCALE_SMOOTH);
	    icon.setImage(image);
		setIcon(icon);
		hp=size;
		updateCard();
	}
	
	public void effect(Player input) {
		input.hp-=this.hp;
		if(input.hp<=0)
		{
			input.hp=1;
		}
	}
}
