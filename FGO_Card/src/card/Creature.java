package card;

import java.awt.Point;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import menu.MainWindow;

public abstract class Creature extends Object{
	private final MediaPlayer deadFX = new MediaPlayer(
			new Media(getClass().getResource("/audio/Dead_FX.mp3").toString())); // for menu BGM
	
	public Creature(String ScientificName){
		super("Creature."+ScientificName);
	}
	public int maxHP;
	public Status status;
	public abstract void attack(Creature opponent);
	public void updateHP(){
		if(hp<=0){
			deadFX.setVolume(MainWindow.getFxVolume());
			deadFX.play();
			Point p=field.getLocation(this);
			field.addCard(new Coin(this.maxHP),p);
			this.setVisible(false);
			field.remove((Card)this);
		}
	}
}
