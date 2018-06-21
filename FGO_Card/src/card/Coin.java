package card;

import javax.swing.ImageIcon;
import java.awt.Point;

public class Coin extends Item{
	public Coin(int size) {
		super("Coin");
		hp=size;
		setIcon(new ImageIcon(this.getClass().getResource("/image/Gold_Battle.jpg")));
		updateCard();
	}
	public void updateHP(){
		if(hp<=0){
			Point p=field.getLocation(this);
			field.addCard(new Empty(),p);
			this.setVisible(false);
			field.remove((Card)this);
		}
	
	}
	public void effect(Player input)
	{
		
	}
}
