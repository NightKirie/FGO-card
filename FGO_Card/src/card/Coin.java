package card;

import javax.swing.ImageIcon;

public class Coin extends Item{
	public Coin() {
		super("Coin");
		setIcon(new ImageIcon(this.getClass().getResource("/Images/Coin.jpg")));
	}
	public  void effect(Player input)
	{
		
	}
}
