package card;

public abstract class Creature extends Object{
	public Creature(String ScientificName){
		super("Creature."+ScientificName);
	}
	public int maxHP;
	public Status status;
	public abstract void attack(Creature opponent);

}
