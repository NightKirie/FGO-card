package card;

import javax.swing.ImageIcon;

public class Coin extends Item{
	public Coin(int size) {
		super("Coin");
		hp=size;
		setIcon(new ImageIcon(this.getClass().getResource("/image/Gold_Battle.jpg")));
		updateCard();
	}
	public  void effect(Player input)
	{
		
	}
}
