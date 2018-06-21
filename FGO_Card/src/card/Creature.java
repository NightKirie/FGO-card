package card;

import java.awt.Point;
public abstract class Creature extends Object{
	public Creature(String ScientificName){
		super("Creature."+ScientificName);
	}
	public int maxHP;
	public Status status;
	public abstract void attack(Creature opponent);
	public void updateHP(){
		if(hp<=0){
			Point p=field.getLocation(this);
			field.addCard(new Coin(this.maxHP),p);
			this.setVisible(false);
			field.remove((Card)this);
		}
	}
}
