package card;

import javax.swing.ImageIcon;


public class Weapon extends Item {
	public int attackrange;
	public String weapontype;
	public Weapon(String scientificName,int whp,int attackrange,String type)
	{
		super("Weapon."+scientificName);
		this.attackrange=attackrange;
		this.hp=whp;
		if(type.equals("sword"))
		{
			cardPicture=new ImageIcon(this.getClass().getResource("/Images/sword.jpg"));
		}
		else if(type.equals("wand"))
		{
			cardPicture=new ImageIcon(this.getClass().getResource("/Images/wand.jpg"));
		}
		setIcon(cardPicture);
	}
	@Override
	public void effect(Player input) {
		// TODO Auto-generated method stub
		input.weapon=this;
	}

}
