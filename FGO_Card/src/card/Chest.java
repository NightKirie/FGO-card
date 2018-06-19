package card;
import java.awt.Image;

import java.awt.Point;
import javax.swing.ImageIcon;
public class Chest extends Item {
	public Chest(int size)
	{
		super("Chest");
		ImageIcon icon=new ImageIcon(this.getClass().getResource("/image/Treasurebox_Game.jpg"));
		Image image = icon.getImage();
	    image = image.getScaledInstance(130,200, Image.SCALE_SMOOTH);
	    icon.setImage(image);
		setIcon(icon);
		hp=size;
		updateCard();
	}
	public void open(){
		Point p=field.getLocation(this);
		field.remove(this);
		field.addCard(new Coin(80+field.generater.nextInt(40)),p);
	}
	@Override
	public void effect(Player input) {
		// TODO Auto-generated method stub

	}

}
