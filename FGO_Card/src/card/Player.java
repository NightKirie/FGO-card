package card;
import character.Character;
import javax.swing.ImageIcon;

public class Player extends Creature{
	public Weapon weapon=null;
	public Player(String scientifficName,int hp)
	{
		super("Player."+scientifficName);
		//hp=input.maxHP;
		//maxhp=input.maxHP;
		ImageIcon cardPicture=null;
		
		/*
		//set caster picture
		cardPicture=new ImageIcon(this.getClass().getResource("/Images/caster.jpg"));
		//set assassin picture
		cardPicture=new ImageIcon(this.getClass().getResource("/Images/assassin.jpg"));
		//set lancer picture
		cardPicture=new ImageIcon(this.getClass().getResource("/Images/lancer.jpg"));
		*/
	}
	public void attack(Creature opponent) {
		// TODO Auto-generated method stub
		if(weapon.hp>0)
		{
			if(weapon.hp>=opponent.hp)
			{
				weapon.hp-=opponent.hp;
				opponent.hp=0;
			}
			else
			{
				opponent.hp-=weapon.hp;
				weapon.hp=0;
			}
		}
		else if(weapon.hp==0)
		{
			if(this.hp>opponent.hp)
			{
				this.hp-=opponent.hp;
				opponent.hp=0;
			}
			else
			{
				//game over!!
			}
		}
	}
	
	public void ability() {
		//default Do nothing~!
	}
	
}
