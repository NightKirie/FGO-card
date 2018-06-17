package card;
import java.awt.Point;

import javax.swing.ImageIcon;
public class Lancer extends Player{
	public Lancer(int hp){
		super("Lancer",hp);
		name="lancer";
		this.hp=hp;
		this.maxHP=hp;
		setIcon(new ImageIcon(this.getClass().getResource("/image/Icon.png")));
	}
	public void attack(Creature opponent) {
		// TODO Auto-generated method stub
		if(weapon.hp>0)
		{
			
			if(weapon.hp>=opponent.hp)
			{
				weapon.hp-=opponent.hp;
				if(weapon instanceof Sword)//sword attack
				{
					opponent.getSwordDamage(opponent.hp);
				}
				if(weapon instanceof Wand)//fire wand attack
				{
					Point enemyLocation=field.getLocation(opponent);
					Point myLocation=field.getLocation(this);
					int xdir=enemyLocation.x-myLocation.x;
					int ydir=enemyLocation.y-myLocation.y;
					if(xdir!=0&&(myLocation.x+2*xdir)>=0&&(myLocation.x+2*xdir)<=0)
					{
						((Object)field.map[myLocation.x+2*xdir][myLocation.y]).getwardDamage(opponent.hp);
					}
					else if(ydir!=0&&(myLocation.y+2*ydir)>=0&&(myLocation.y+2*ydir)<=0)
					{
						((Object)field.map[myLocation.x][myLocation.y+2*ydir]).getwardDamage(opponent.hp);
					}
					opponent.getwardDamage(opponent.hp);
				}
			}
			else
			{
				if(weapon instanceof Sword)//sword attack
				{
					opponent.getSwordDamage(weapon.hp);
					field.swapCard(field.getLocation(this), field.getLocation(opponent));
				}
				if(weapon instanceof Wand)//wand attack
				{
					Point enemyLocation=field.getLocation(opponent);
					Point myLocation=field.getLocation(this);
					int xdir=enemyLocation.x-myLocation.x;
					int ydir=enemyLocation.y-myLocation.y;
					if(xdir!=0&&(myLocation.x+2*xdir)>=0&&(myLocation.x+2*xdir)<=0)
					{
						((Object)field.map[myLocation.x+2*xdir][myLocation.y]).getwardDamage(weapon.hp);
					}
					else if(ydir!=0&&(myLocation.y+2*ydir)>=0&&(myLocation.y+2*ydir)<=0)
					{
						((Object)field.map[myLocation.x][myLocation.y+2*ydir]).getwardDamage(weapon.hp);
					}
					opponent.getwardDamage(weapon.hp);
				}
				weapon.hp=0;
			}
		}
		else if(weapon.hp==0||weapon==null)
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
}
