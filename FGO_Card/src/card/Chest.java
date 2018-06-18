package card;
import java.awt.Image;

import javax.swing.ImageIcon;
public class Chest extends Item {
	public Chest(int size)
	{
		super("Chest");
		hp=size;
		hpShow.setText(Integer.toString(hp));
		ImageIcon icon=new ImageIcon(this.getClass().getResource("/image/Treasurebox_Game.jpg"));
		Image image = icon.getImage();
	    image = image.getScaledInstance(130,200, Image.SCALE_SMOOTH);
	    icon.setImage(image);
		setIcon(icon);
	}
	@Override
	public void effect(Player input) {
		// TODO Auto-generated method stub

	}

}
