package card;

public class Item extends Object{
	public Item(String scientifficName){
		super("Object."+scientifficName);
	}
	public abstract void effect(Player input);
}
