package card;
import javax.swing.ImageIcon;
public class Monster extends Creature {
	public Monster(String scientificName)
	{
		super("Monster."+scientificName);
		ImageIcon cardPicture=null;
		if(monstertype.equals("Boss"))
		{
			hp=100;
			cardPicture=new ImageIcon(this.getClass().getResource("/Images/Boss.jpg"));
		}
		if(monstertype.equals("midboss"))
		{
			hp=50;
			cardPicture=new ImageIcon(this.getClass().getResource("/Images/Midboss.jpg"));
		}
		setIcon(cardPicture);
	}

	public void attack() {
		// TODO Auto-generated method stub
		
	}
}
