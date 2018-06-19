package card;
import java.awt.Point;
import battle.Battle;
import javax.swing.ImageIcon;
public class Lancer extends Player{
	public Lancer(int hp){
		super("Lancer");
		name="lancer";
		this.hp=hp;
		this.maxHP=hp;
		hpShow.setText(Integer.toString(hp));
		setIcon(new ImageIcon(this.getClass().getResource("/image/Lancer_Battle.jpg")));
		weapon=new Sword(5);
		ImageIcon icon=new ImageIcon(this.getClass().getResource("/image/Sword_Get.jpg"));
		weaponpic.setIcon(icon);
		weaponshow.setText(Integer.toString(weapon.hp));
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
			if(weapon instanceof Sword){
				opponent.getSwordDamage(opponent.hp);
				field.swapCard(enemyLocation,myLocation);
			}
			else if(weapon instanceof Wand){
				for(;field.inField(enemyLocation);Battle.addPoint(enemyLocation,Battle.relation[direction])){
					if(field.map[enemyLocation.x][enemyLocation.y] instanceof Object)
						((Object)field.map[enemyLocation.x][enemyLocation.y]).getwardDamage(damage);
				}
			}
		}
		if(weapon!=null&&weapon.hp<=0) weapon=null;
		/*
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
		*/
	}
}
