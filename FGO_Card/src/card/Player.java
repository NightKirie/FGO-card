package card;
import character.Character;
import javax.swing.ImageIcon;

public class Player extends Creature{
	public Weapon weapon=new Weapon(0,0,"");
	public int maxhp;
	public Player(Character input)
	{
		hp=input.maxHP;
		maxhp=input.maxHP;
		if(input.ID==1)
		{
			//set caster picture
			cardPicture=new ImageIcon(this.getClass().getResource("/Images/caster.jpg"));
		}
		if(input.ID==2)
		{
			//set assassin picture
			cardPicture=new ImageIcon(this.getClass().getResource("/Images/assassin.jpg"));
		}
		if(input.ID==3)
		{
			//set lancer picture
			cardPicture=new ImageIcon(this.getClass().getResource("/Images/lancer.jpg"));
			
		}
		setIcon(cardPicture);
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
		
	}
	
}
