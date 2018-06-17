package cardtest;
import javax.swing.ImageIcon;
public class GreenPotion2 extends Potion2{
	public GreenPotion2(int size) {
		super("GreenPotion");
		ImageIcon cardPicture=null;
		hp=size;
		cardPicture=new ImageIcon(this.getClass().getResource("/image/GreenPotion_Game.png"));
		setIcon(cardPicture);
	}
	
	/*public void effect(Player input) {
		input.hp-=this.hp;
		if(input.hp <= 0)
		{
			//gameover
		}
	}*/
}
