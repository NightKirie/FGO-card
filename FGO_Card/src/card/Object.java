package card;
public abstract class Object extends Card {
	public Object(String scientificName){
		super("Object."+scientificName);
	}
	public int hp;	
}
