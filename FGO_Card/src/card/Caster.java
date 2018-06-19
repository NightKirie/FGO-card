package card;
import java.awt.Image;
import java.awt.Point;
import battle.Battle;
import javax.swing.ImageIcon;
public class Caster extends Player{
	public Caster(int hp){
		super("Caster");
		name="caster";
		this.hp=hp;
		this.maxHP=hp;
		setIcon(new ImageIcon(this.getClass().getResource("/image/Caster_Battle.jpg")));
		weapon=new Wand(10);
		updateCard();
	}
	public void attack(Creature opponent) {
		// TODO Auto-generated method stub
		Point enemyLocation=field.getLocation(opponent);
		Point myLocation=field.getLocation(this);
		int direction=-1,damage=0;
		for(int i=0;i<4;++i){
			if(enemyLocation.equals(Battle.addPoint(myLocation,Battle.relation[i]))) direction=i;
		}
		if(weapon==null)
		{
			field.pickGold(opponent.hp);
			hp-=opponent.hp;
			field.remove(opponent);
			field.moveCard(myLocation,direction);
		}
		else{
			if(weapon.hp>opponent.hp) damage=opponent.hp;
			else damage=weapon.hp;
			weapon.hp-=damage;
			if(weapon instanceof Sword)	opponent.getSwordDamage(damage);
			else if(weapon instanceof Wand){
				for(;field.inField(enemyLocation);enemyLocation=Battle.addPoint(enemyLocation,Battle.relation[direction])){
					if(		(field.map[enemyLocation.x][enemyLocation.y] instanceof Object)&&
							!(field.map[enemyLocation.x][enemyLocation.y] instanceof RedPotion)&&
							!(field.map[enemyLocation.x][enemyLocation.y] instanceof Weapon))
						((Object)field.map[enemyLocation.x][enemyLocation.y]).getwardDamage(damage);
				}
			}
		}
		if(weapon!=null&&weapon.hp<=0) weapon=null;
		/*if(weapon.hp>0)
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
					Point enemyLocation=field.getLocation((Card)opponent);
					Point myLocation=field.getLocation((Card)this);
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
		*/
	}
}
