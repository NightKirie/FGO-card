package card;
import javax.swing.ImageIcon;
public class Monster extends Creature {
	public Monster(String scientificName)
	{
		super("Monster."+scientificName);
		/*ImageIcon cardPicture=null;

		if(scientificName.equals("Boss"))
		{
			hp=100;
			cardPicture=new ImageIcon(this.getClass().getResource("/Images/Boss.jpg"));
		}
		if(scientificName.equals("midboss"))
		{
			hp=50;
			cardPicture=new ImageIcon(this.getClass().getResource("/Images/Midboss.jpg"));
		}
		setIcon(cardPicture);*/
	}

	public void attack(Creature opponent) {
		// TODO Auto-generated method stub
		
	}
}
