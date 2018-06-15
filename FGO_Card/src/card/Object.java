package card;

import battle.Battle;
import java.awt.Point;
public class Object extends Card {
	public Object(String scientificName){
		super("Object."+scientificName);
	}
	public int hp;	
	/*
	 * object have hp,so every damage will in there first
	 * ex code:
	 public void getFireDamage(int damage){
	 	hp-=damage;
	 }
	 */
	public void deadAction(){
		Point p=Battle.getLocation(this);
		if(this instanceof Creature){
			 Battle.map[p.x][p.y]=new Coin(((Creature)this).maxHP);
		}
			 Battle.map[p.x][p.y]=new Coin(10);
		
	}
	public void getSwordDamage(int damage)//sword damage
	{
		hp-=damage;
	}
	public void getFireDamage(int damage)//fire ward
	{
		hp-=damage;
	}
	public void getIceDamage(int damage)//ice ward
	{
		hp-=damage;
	}
	public void getTrapDamage(int damage)//step trap
	{
		hp-=damage;
	}
	public void getBombDamage(int damage)//touch bomb 
	{
		hp-=damage;
	}
}
