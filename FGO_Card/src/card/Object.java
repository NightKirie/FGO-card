package card;
import battle.Battle;
import java.awt.Point;
import javax.swing.JLabel;
public class Object extends Card {
	public Object(String scientificName){
		super("Object."+scientificName);
		hpShow=new JLabel();
		hpShow.setBounds(0,0,50,50);
		add(hpShow);
	}
	public int hp=0;	
	public JLabel hpShow=new JLabel();
	/*
	 * object have hp,so every damage will in there first
	 * ex code:
	 public void getFireDamage(int damage){
	 	hp-=damage;
	 }
	 */
	public void updateUI()
	{
		//hpShow.setText(Integer.toString(hp));
	}
	public void deadAction(){
		Point p=field.getLocation(this);
		if(this instanceof Creature){
			 field.map[p.x][p.y]=new Coin(((Creature)this).maxHP);
		}
		else field.map[p.x][p.y]=new Coin(10);
		
	}
	public void getSwordDamage(int damage)//sword damage
	{
		hp-=damage;
	}
	public void getwardDamage(int damage)//fire ward
	{
		hp-=damage;
	}
	public void getwardDamageOfMage(int damage)//ice ward
	{
		//only monster get hurt
	}
	public void getTrapDamage(int damage)//step trap
	{
		hp-=damage;
	}
	public void getBombDamage(int damage)//touch bomb 
	{
		hp-=damage;
	}
}
