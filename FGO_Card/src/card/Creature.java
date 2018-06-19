package card;

import java.awt.Point;
public abstract class Creature extends Object{
	public Creature(String ScientificName){
		super("Creature."+ScientificName);
	}
	public int maxHP;
	public Status status;
	public abstract void attack(Creature opponent);
	public void updateStatus(){
		if(hp<=0){
			Point p=field.getLocation(this);
			field.map[p.x][p.y]=new Coin(((Creature)this).maxHP);
			field.remove((Card)this);
		}
	}
	public void updateCard(){
	}

}
