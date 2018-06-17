package cardtest;
import javax.swing.ImageIcon;
public class Potion2 extends Item2 {
	public String potiontype;
	public Potion2(String scientificName) {
		super("Potion."+scientificName);
	}
	
	@Override
	public void effect(Player2 input) {
		// TODO Auto-generated method stub
		
	}
	
	
	/*
	public Potion(String scientificName,int size)
	{
		super("Potion."+scientificName);
		
		ImageIcon cardPicture=null;
		hp=size;
		potiontype=scientificName;
		if(potiontype.equals("heal"))
		{
			cardPicture=new ImageIcon(this.getClass().getResource("/image/Icon.png"));
		}
		setIcon(cardPicture);
		
	}

	@Override
	public void effect(Player input) {

		// TODO Auto-generated method stub
		if(potiontype.equals("heal"))
		{
			input.hp+=this.hp;
			if(input.hp>input.maxHP)
			{
				input.hp=input.maxHP;
			}
		}
		
	}
*/

}
