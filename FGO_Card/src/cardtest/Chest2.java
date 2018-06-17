package cardtest;
import javax.swing.ImageIcon;
public class Chest2 extends Item2 {
	public Chest2(int size)
	{
		super("Chest");
		hp=size;
		setIcon(new ImageIcon(this.getClass().getResource("/image/Treasurebox_Game.png")));
	}
	@Override
	public void effect(Player2 input) {
		// TODO Auto-generated method stub

	}

}
