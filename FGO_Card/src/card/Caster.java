package card;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
public class Caster extends Player{
	public Caster(int hp){
		super("Caster");
		name="caster";
		this.hp=hp;
		this.maxHP=hp;
		ImageIcon icon=new ImageIcon(this.getClass().getResource("/image/Caster_Battle.jpg"));
		Image image = icon.getImage();
	    image = image.getScaledInstance(150,200, Image.SCALE_SMOOTH);
	    icon.setImage(image);
		setIcon(icon);
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
						((Object)field.map[myLocation.x+2*xdir][myLocation.y]).getwardDamageOfMage(opponent.hp);
					}
					else if(ydir!=0&&(myLocation.y+2*ydir)>=0&&(myLocation.y+2*ydir)<=0)
					{
						((Object)field.map[myLocation.x][myLocation.y+2*ydir]).getwardDamageOfMage(opponent.hp);
					}
					opponent.getwardDamageOfMage(opponent.hp);
				}
			}
			else
			{
				if(weapon instanceof Sword)//sword attack
				{
					opponent.getSwordDamage(weapon.hp);
				}
				if(weapon instanceof Wand)//wand attack
				{
					Point enemyLocation=field.getLocation(opponent);
					Point myLocation=field.getLocation(this);
					int xdir=enemyLocation.x-myLocation.x;
					int ydir=enemyLocation.y-myLocation.y;
					if(xdir!=0&&(myLocation.x+2*xdir)>=0&&(myLocation.x+2*xdir)<=0)
					{
						((Object)field.map[myLocation.x+2*xdir][myLocation.y]).getwardDamageOfMage(weapon.hp);
					}
					else if(ydir!=0&&(myLocation.y+2*ydir)>=0&&(myLocation.y+2*ydir)<=0)
					{
						((Object)field.map[myLocation.x][myLocation.y+2*ydir]).getwardDamageOfMage(weapon.hp);
					}
					opponent.getwardDamageOfMage(weapon.hp);
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
