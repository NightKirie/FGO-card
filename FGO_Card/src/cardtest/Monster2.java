package cardtest;
import javax.swing.ImageIcon;
public class Monster2 extends Creature2 {
	public Monster2(String scientificName)
	{
		super("Monster."+scientificName);
		
	}

	public void attack(Creature2 opponent) {
		// TODO Auto-generated method stub
		
	}
	public void getwardDamageOfMage(int damage)//ice ward
	{
		hp-=damage;
	}
}
