package card;

public class Weapon extends Item {
	public String weapontype;
	public Weapon(String scientificName)//,int whp,int attackrange,String type)
	{
		super("Weapon."+scientificName);
		
		this.weapontype=scientificName;
		
	}
	@Override
	public void effect(Player input) {
		// TODO Auto-generated method stub
		input.weapon=this;
	}

}
