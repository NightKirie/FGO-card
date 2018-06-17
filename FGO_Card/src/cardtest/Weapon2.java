package cardtest;

import javax.swing.ImageIcon;


public class Weapon2 extends Item2 {
	public String weapontype;
	public Weapon2(String scientificName)//,int whp,int attackrange,String type)
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
	public void effect(Player2 input) {
		// TODO Auto-generated method stub
		//input.weapon=this;
	}

}
