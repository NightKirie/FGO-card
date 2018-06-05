package card;

public abstract class Creature extends Object{
	public Creature(String name){
		super("Creature."+name);
	}
	public Status status;
	public abstract void attack(Creature opponent);

}
