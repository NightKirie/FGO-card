package cardtest;

public abstract class Item2 extends Object2{

	public Item2(String scientifficName){
		super("Object."+scientifficName);
	}
	public abstract void effect(Player2 input) ;
}
