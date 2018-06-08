package card;
import javax.swing.ImageIcon;
public class Potion extends Item {
	public String potiontype;
	public Potion(String scientificName,int size)
	{
		super("Potion."+scientificName);
		hp=size;
		potiontype=type;
		if(type.equals("heal"))
		{
			cardPicture=new ImageIcon("healpotion.jpg");
		}
		setIcon(cardPicture);
	}

	@Override
	public void effect(Player input) {
		// TODO Auto-generated method stub
		if(potiontype.equals("heal"))
		{
			input.hp+=this.hp;
			if(input.hp>input.maxhp)
			{
				input.hp=input.maxhp;
			}
		}
	}

}
