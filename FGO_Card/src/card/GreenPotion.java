package card;
import javax.swing.ImageIcon;
public class GreenPotion extends Potion{
	public GreenPotion(int size) {
		super("GreenPotion");
		ImageIcon cardPicture=null;
		hp=size;
		cardPicture=new ImageIcon(this.getClass().getResource("/image/Icon.png"));
		setIcon(cardPicture);
	}
	
	public void effect(Player input) {
		input.hp-=this.hp;
		if(input.hp <= 0)
		{
			//gameover
		}
	}
}
