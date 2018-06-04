package card;

public abstract class Creature extends Object{
	public Status status;
	public abstract void attack(Creature opponent);

}
