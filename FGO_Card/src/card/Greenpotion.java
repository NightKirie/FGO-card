package card;
import javax.swing.ImageIcon;
public class Greenpotion extends Potion{
	public Greenpotion(String scientificName,int size) {
		super(scientificName);
		ImageIcon cardPicture=null;
		hp=size;
		cardPicture=new ImageIcon(this.getClass().getResource("/Images/greenpotion.jpg"));
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
