package card;

import java.awt.Image;
import java.awt.Point;
import javax.swing.ImageIcon;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import menu.MainWindow;

public class Chest extends Item {
	private final MediaPlayer chestFX = new MediaPlayer(
			new Media(getClass().getResource("/audio/Chest_FX.mp3").toString())); // for menu BGM
	
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
		chestFX.setVolume(MainWindow.getFxVolume());
		chestFX.play();
		Point p=field.getLocation(this);
		field.addCard(new Coin(30+field.generater.nextInt(40)),p);
		this.setVisible(false);
		field.remove(this);
	}
	@Override
	public void effect(Player input) {
		// TODO Auto-generated method stub

	}

}
