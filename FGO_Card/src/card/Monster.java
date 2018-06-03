package card;
import javax.swing.ImageIcon;
public abstract class Monster extends Creature {
	public Monster(String monstertype)
	{
		if(monstertype.equals("Boss"))
		{
			hp=100;
			cardPicture=new ImageIcon("boss.jpg");
		}
		if(monstertype.equals("midboss"))
		{
			hp=50;
			cardPicture=new ImageIcon("midboss.jpg");
		}
	}

	public void attack() {
		// TODO Auto-generated method stub
		
	}
}
