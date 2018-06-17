package card;

import javax.swing.ImageIcon;


public class Weapon extends Item {
	public String weapontype;
	public Weapon(String scientificName)//,int whp,int attackrange,String type)
	{
		super("Weapon."+scientificName);
		/*
		this.attackrange=attackrange;
		this.hp=whp;
		this.weapontype=type;
		ImageIcon cardPicture=null;
		if(type.equals("sword"))
		{
			cardPicture=new ImageIcon(this.getClass().getResource("/image/Icon.png"));
		}
		else if(type.equals("wand"))
		{
			cardPicture=new ImageIcon(this.getClass().getResource("/image/Icon.png"));
		}
		setIcon(cardPicture);
		*/
	}
	@Override
	public void effect(Player input) {
		// TODO Auto-generated method stub
		input.weapon=this;
	}

}
