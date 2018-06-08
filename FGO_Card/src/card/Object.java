package card;
public class Object extends Card {
	public Object(String scientificName){
		super("Object."+scientificName);
	}
	public int hp;	
	/*
	 * object have hp,so every damage will in there first
	 * ex code:
	 public void getFireDamage(int damage){
	 	hp-=damage;
	 }
	 */
}
