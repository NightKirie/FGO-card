package cardtest;

import javax.swing.ImageIcon;

public class Coin2 extends Item2{
	public Coin2(int size) {
		super("Coin");
		hp=size;
		setIcon(new ImageIcon(this.getClass().getResource("/image/Gold_Amount.png")));
	}
	public  void effect(Player2 input)
	{
		
	}
}
