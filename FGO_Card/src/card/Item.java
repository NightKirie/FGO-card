package card;

public abstract class Item extends Object{

	public Item(String scientifficName){
		super("Object."+scientifficName);
	}
	public abstract void effect(Player input) ;
}
