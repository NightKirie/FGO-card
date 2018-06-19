package card;

import java.awt.Point;
public abstract class Creature extends Object{
	public Creature(String ScientificName){
		super("Creature."+ScientificName);
	}
	public int maxHP;
	public Status status;
	public abstract void attack(Creature opponent);
	public void updateCard(){
		Point p=field.getLocation(this);
		field.map[p.x][p.y]=new Coin(((Creature)this).maxHP);
	}

}
