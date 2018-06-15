package card;
import javax.swing.ImageIcon;
public class Chest extends Item {
	public Chest()
	{
		super("Chest");
		setIcon(new ImageIcon(this.getClass().getResource("/Images/Chest.jpg")));
	}
	@Override
	public void effect(Player input) {
		// TODO Auto-generated method stub

	}

}
